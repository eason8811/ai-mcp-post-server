package xin.eason.aimcppostserver.domain.model;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * CSDN 发帖响应对象, 用于返回给大模型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse {

    /**
     * 响应代码
     */
    @JsonProperty(required = true, value = "code")
    @JsonPropertyDescription("发表文章请求的响应代码")
    private Integer code;

    /**
     * 响应信息
     */
    @JsonProperty(required = true, value = "msg")
    @JsonPropertyDescription("发表文章请求的响应信息")
    private String msg;

    /**
     * 文章数据
     */
    @JsonProperty(required = true, value = "articleData")
    @JsonPropertyDescription("发表的文章的具体数据")
    private ArticleData articleData;

    /**
     * 文章数据类
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ArticleData {

        /**
         * 文章 URL
         */
        @JsonProperty(required = true, value = "url")
        @JsonPropertyDescription("发表的文章的URL")
        private String url;

        /**
         * 文章 ID
         */
        @JsonProperty(required = true, value = "id")
        @JsonPropertyDescription("发表的文章的ID")
        private Long id;

        /**
         * 文章二维码
         */
        @JsonProperty(required = true, value = "qrcode")
        @JsonPropertyDescription("发表的文章的二维码")
        private String qrcode;

        /**
         * 文章标题
         */
        @JsonProperty(required = true, value = "title")
        @JsonPropertyDescription("发表的文章的标题")
        private String title;

        /**
         * 文章描述
         */
        @JsonProperty(required = true, value = "description")
        @JsonPropertyDescription("发表的文章的描述信息")
        private String description;
    }


}
