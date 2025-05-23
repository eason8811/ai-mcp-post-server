package xin.eason.aimcppostserver.types.util;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;


/**
 * 将 Markdown 格式转换为 HTML 富文本格式的工具类
 */
public class MarkdownConvert {

    /**
     * 转换器
     */
    private static final Parser parser;
    /**
     * HTML 渲染器
     */
    private static final HtmlRenderer htmlRenderer;

    static {
        MutableDataSet mutableDataSet = new MutableDataSet();
        parser = Parser.builder(mutableDataSet).build();
        htmlRenderer = HtmlRenderer.builder(mutableDataSet).build();
    }

    /**
     * 将 Markdown 文本转换并渲染为 HTML 文本
     * @param markdownContent Markdown 文本
     * @return 渲染好的 HTML 文本
     */
    public static String convertToHtmlContent(String markdownContent) {
        if (markdownContent == null || markdownContent.isBlank())
            return "";
        return htmlRenderer.render(parser.parse(markdownContent));
    }
}
