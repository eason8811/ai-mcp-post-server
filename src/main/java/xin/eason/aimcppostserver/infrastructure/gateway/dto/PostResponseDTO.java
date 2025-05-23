package xin.eason.aimcppostserver.infrastructure.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发帖响应 DTO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {

    /**
     * 响应状态码，200 表示成功。
     */
    private int code;

    /**
     * 请求的追踪 ID，用于追踪请求的唯一标识。
     */
    private String traceId;

    /**
     * 包含文章相关数据的对象。
     */
    private ArticleData data;

    /**
     * 响应消息，通常表示操作的结果说明。
     */
    private String msg;

    /**
     * Data 子对象类，包含与文章相关的详细信息。
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ArticleData {

        /**
         * 文章的 URL 地址。
         */
        private String url;

        /**
         * 文章的唯一 ID。
         */
        private long articleId;

        /**
         * 文章的标题。
         */
        private String title;

        /**
         * 文章的描述。
         */
        private String description;
    }
}
