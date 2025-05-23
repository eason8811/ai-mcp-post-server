package xin.eason.aimcppostserver.infrastructure.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发帖请求 DTO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {

    /**
     * 文章 ID ( 为空则代表室新文章, 不为空则表示修改这个 ID 的文章)
     */
    private String articleId = "";
    /**
     * 鉴权状态
     */
    private boolean authorizedStatus = false;
    /**
     * 类别
     */
    private String categories = "";
    /**
     * checkOriginal ( 未知字段 )
     */
    private boolean checkOriginal = false;
    /**
     * 内容
     */
    private String content;
    /**
     * 封面图片 URL
     */
    private List<String> coverImages = List.of();
    /**
     * 封面类型
     */
    private int coverType = 1;
    /**
     * 文章创建者活动 ID
     */
    private String creatorActivityId = "";
    /**
     * 文章描述
     */
    private String description;
    /**
     * 文章是否是新建文章的标记
     */
    private int isNew = 1;
    /**
     * 是否自动保存
     */
    private int notAutoSaved = 1;
    /**
     * 原始链接
     */
    private String originalLink = "";
    /**
     * 文章可见性
     */
    private String readType = "public";
    /**
     * 原因 ? ( 未知字段 )
     */
    private String reason = "";
    /**
     * 资源 ID
     */
    private String resourceId = "";
    /**
     * 定时时间 ( 定时发布时启用 )
     */
    private int scheduledTime = 0;
    /**
     * 文章来源
     */
    private String source = "pc_postedit";
    /**
     * 状态
     */
    private int status = 0;
    /**
     * 同步 Git 代码 ( 未知字段 )
     */
    private int syncGitCode = 0;
    /**
     * 文章标签
     */
    private String tags;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 文章类型
     */
    private String type = "original";
    /**
     * 投票 ID
     */
    private int voteId = 0;
}
