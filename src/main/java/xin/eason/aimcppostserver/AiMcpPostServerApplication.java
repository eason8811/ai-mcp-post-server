package xin.eason.aimcppostserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xin.eason.aimcppostserver.domain.service.CsdnPostService;

@Slf4j
@SpringBootApplication
public class AiMcpPostServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AiMcpPostServerApplication.class, args);
    }

    /**
     * 给 AI 提供工具
     * @param csdnPostService 工具服务类
     * @return {@link ToolCallbackProvider}
     */
    @Bean
    public ToolCallbackProvider toolCallbackProvider(CsdnPostService csdnPostService) {
        return MethodToolCallbackProvider.builder().toolObjects(csdnPostService).build();
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("MCP 服务 ai-mcp-post-server 启动成功!");
    }
}
