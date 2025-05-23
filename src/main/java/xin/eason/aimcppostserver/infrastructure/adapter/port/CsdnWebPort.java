package xin.eason.aimcppostserver.infrastructure.adapter.port;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xin.eason.aimcppostserver.domain.adapter.IWebPort;
import xin.eason.aimcppostserver.domain.model.PostRequest;
import xin.eason.aimcppostserver.domain.model.PostResponse;
import xin.eason.aimcppostserver.infrastructure.gateway.ICsdnWebHandler;
import xin.eason.aimcppostserver.infrastructure.gateway.dto.PostRequestDTO;
import xin.eason.aimcppostserver.infrastructure.gateway.dto.PostResponseDTO;

import java.io.IOException;

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

            PostResponseDTO postResponseDTO = csdnWebHandler.postArticle(postRequestDTO, cookieString).execute().body();

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
}
