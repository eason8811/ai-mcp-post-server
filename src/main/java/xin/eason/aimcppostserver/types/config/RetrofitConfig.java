package xin.eason.aimcppostserver.types.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import xin.eason.aimcppostserver.infrastructure.gateway.ICsdnWebHandler;

/**
 * Retrofit 配置类
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(RetrofitConfigProperty.class)
public class RetrofitConfig {

    /**
     * Retrofit 配置属性
     */
    private final RetrofitConfigProperty property;

    /**
     * 注入 Retrofit Bean 对象
     *
     * @return Retrofit Bean 对象
     */
    @Bean
    public Retrofit retrofit() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new Retrofit.Builder()
                .baseUrl(property.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
    }

    /**
     * 注入发送 CSDN 发帖的网络请求的类的 Bean 对象
     *
     * @param retrofit Retrofit Bean 对象
     * @return 发送发帖网络请求的 Bean 对象
     */
    @Bean
    public ICsdnWebHandler iCsdnWebHandler(Retrofit retrofit) {
        return retrofit.create(ICsdnWebHandler.class);
    }
}
