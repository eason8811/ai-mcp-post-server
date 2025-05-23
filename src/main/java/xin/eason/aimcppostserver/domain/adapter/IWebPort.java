package xin.eason.aimcppostserver.domain.adapter;

import xin.eason.aimcppostserver.domain.model.PostRequest;
import xin.eason.aimcppostserver.domain.model.PostResponse;

/**
 * 发帖领域适配器接口
 */
public interface IWebPort {
    /**
     * 将文章发表到 CSDN 中, 然后返回已发表的文章信息
     * @param postRequest 发表文章请求对象
     * @return 发表文章信息响应对象
     */
    PostResponse postArticle(PostRequest postRequest, String cookieString);
}
