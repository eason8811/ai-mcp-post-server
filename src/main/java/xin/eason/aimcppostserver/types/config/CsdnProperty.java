package xin.eason.aimcppostserver.types.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CSDN 配置属性类
 */
@Data
@ConfigurationProperties("csdn")
public class CsdnProperty {
    /**
     * Cookie 字符串
     */
    private String cookieString;
}
