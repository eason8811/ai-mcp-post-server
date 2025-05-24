package xin.eason.aimcppostserver.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import xin.eason.aimcppostserver.domain.adapter.IWebPort;
import xin.eason.aimcppostserver.domain.model.PostRequest;
import xin.eason.aimcppostserver.domain.model.PostResponse;
import xin.eason.aimcppostserver.types.config.CsdnProperty;

/**
 * CSDN 发帖业务类
 */
@Slf4j
@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(CsdnProperty.class)
public class CsdnPostService {

    /**
     * 发帖基础设施网络请求接口
     */
    private final IWebPort webPort;
    /**
     * CSDN API 属性
     */
    private final CsdnProperty csdnProperty;

    /**
     * 发表文章
     * @param postRequest 发表文章请求
     * @return 发表文章结果响应
     */
    @Tool(description = "根据发表文章的请求数据在CSDN上发表文章, 并返回这个已经发表的文章的结果信息")
    public PostResponse postArticle(PostRequest postRequest) {
        log.info("已收到发帖请求对象: {}", postRequest);
        log.info("Cookie 信息: {}", csdnProperty.getCookieString().substring(0, 50));
        return webPort.postArticle(postRequest, csdnProperty.getCookieString());
    }
}
