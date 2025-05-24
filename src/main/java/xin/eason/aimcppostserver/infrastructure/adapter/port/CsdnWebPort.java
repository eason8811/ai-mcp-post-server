package xin.eason.aimcppostserver.infrastructure.adapter.port;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.RequestBody;
import okio.Buffer;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import xin.eason.aimcppostserver.domain.adapter.IWebPort;
import xin.eason.aimcppostserver.domain.model.PostRequest;
import xin.eason.aimcppostserver.domain.model.PostResponse;
import xin.eason.aimcppostserver.infrastructure.gateway.ICsdnWebHandler;
import xin.eason.aimcppostserver.infrastructure.gateway.dto.PostRequestDTO;
import xin.eason.aimcppostserver.infrastructure.gateway.dto.PostResponseDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * CSDN 发帖实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CsdnWebPort implements IWebPort {

    /**
     * 具体发送网络请求的 Bean 对象
     */
    private final ICsdnWebHandler csdnWebHandler;

    /**
     * 将文章发表到 CSDN 中, 然后返回已发表的文章信息
     *
     * @param postRequest 发表文章请求对象
     * @return 发表文章信息响应对象
     */
    @Override
    public PostResponse postArticle(PostRequest postRequest, String cookieString) {
        PostResponse response = null;
        try {
            PostRequestDTO postRequestDTO = new PostRequestDTO();
            postRequestDTO.setTitle(postRequest.getTitle());
            postRequestDTO.setContent(postRequest.convertToHtmlContent(postRequest.getMarkdownContent()));
            postRequestDTO.setTags(postRequest.getTags());
            postRequestDTO.setDescription(postRequest.getDesc());

            log.info("正在准备发帖, 发帖请求 DTO: {}", postRequestDTO);

            Response<PostResponseDTO> execute = csdnWebHandler.postArticle(postRequestDTO, cookieString).execute();
            if (!execute.isSuccessful()) {
                Map<String, Object> map = JSON.parseObject(execute.errorBody().string());
                PostResponseDTO postResponseDTO = PostResponseDTO.builder()
                        .data(null)
                        .code((Integer) map.get("code"))
                        .msg((String) map.get("msg"))
                        .traceId((String) map.get("traceId"))
                        .build();
                log.error("请求失败, 状态码: {}, 响应体: {}", execute.code(), postResponseDTO);
                return PostResponse.builder()
                        .code(postResponseDTO.getCode())
                        .msg(postResponseDTO.getMsg())
                        .build();
            }
            PostResponseDTO postResponseDTO = execute.body();

            if (postResponseDTO == null)
                return null;

            PostResponseDTO.ArticleData articleData = postResponseDTO.getData();
            response = PostResponse.builder()
                    .code(postResponseDTO.getCode())
                    .msg(postResponseDTO.getMsg())
                    .articleData(
                            PostResponse.ArticleData.builder()
                                    .url(articleData.getUrl())
                                    .id(articleData.getArticleId())
                                    .qrcode(null)
                                    .title(articleData.getTitle())
                                    .description(articleData.getDescription())
                                    .build()
                    )
                    .build();
            if (response.getCode() == 200) {
                log.info("发表文章成功, 标题: {}, 文章链接: {}", response.getArticleData().getTitle(), response.getArticleData().getUrl());
            } else {
                log.info("发表文章失败, 响应代码: {}, 响应信息: {}", response.getCode(), response.getMsg());
            }

        } catch (IOException e) {
            log.error("发送 CSDN 发表文章请求出现错误! 错误信息: {}", e.getMessage(), e);
        }
        return response;
    }

    // 工具类方法
    public static String requestToCurl(okhttp3.Request request) {
        StringBuilder curlCmd = new StringBuilder("curl");

        // 添加 method
        curlCmd.append(" -X ").append(request.method());

        // 添加 headers
        for (Map.Entry<String, List<String>> header : request.headers().toMultimap().entrySet()) {
            for (String value : header.getValue()) {
                curlCmd.append(" -H ")
                        .append("\"")
                        .append(header.getKey()).append(": ").append(value)
                        .append("\"");
            }
        }

        // 添加请求体
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            try {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                String bodyStr = buffer.readUtf8();

                curlCmd.append(" --data ")
                        .append("\"")
                        .append(bodyStr.replace("\"", "\\\""))  // 转义双引号
                        .append("\"");
            } catch (IOException e) {
                curlCmd.append(" [Error reading body: ").append(e.getMessage()).append("]");
            }
        }

        // 添加 URL
        curlCmd.append(" \"").append(request.url()).append("\"");

        return curlCmd.toString();
    }


}
