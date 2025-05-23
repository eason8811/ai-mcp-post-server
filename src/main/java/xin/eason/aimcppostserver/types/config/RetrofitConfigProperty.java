package xin.eason.aimcppostserver.types.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Retrofit 配置属性类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("retrofit")
public class RetrofitConfigProperty {
    private String baseUrl;
}
