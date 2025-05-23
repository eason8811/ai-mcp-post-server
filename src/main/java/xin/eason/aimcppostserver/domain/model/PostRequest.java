package xin.eason.aimcppostserver.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import xin.eason.aimcppostserver.types.util.MarkdownConvert;

/**
 * CSDN 发帖请求对象, 用于提供给大模型输入到 MCP 服务中
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequest {
    /**
     * 标题
     */
    @JsonProperty(required = true)
    @JsonPropertyDescription("发表的文章标题")
    private String title;

    /**
     * 文章内容 Markdown 文本
     */
    @JsonProperty(required = true)
    @JsonPropertyDescription("发表的文章内容的 Markdown 文本")
    private String markdownContent;

    /**
     * 文章标签
     */
    @JsonProperty(required = true)
    @JsonPropertyDescription("发表的文章标签, 使用英文逗号隔开")
    private String tags;

    /**
     * 文章描述
     */
    @JsonProperty(required = true)
    @JsonPropertyDescription("发表的文章描述")
    private String desc;

    /**
     * 将 Markdown 文本转换并渲染为 HTML 文本
     *
     * @param originContent Markdown 文本
     * @return 渲染好的 HTML 文本
     */
    public String convertToHtmlContent(String originContent) {
        return MarkdownConvert.convertToHtmlContent(originContent);
    }
}
