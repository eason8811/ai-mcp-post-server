package xin.eason.aimcppostserver.infrastructure.gateway;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import xin.eason.aimcppostserver.infrastructure.gateway.dto.PostRequestDTO;
import xin.eason.aimcppostserver.infrastructure.gateway.dto.PostResponseDTO;

/**
 * 具体发送网络请求的接口
 */
public interface ICsdnWebHandler {

    /**
     * 发送发帖请求
     * @param postRequestDTO 发帖请求 DTO
     * @return 发帖响应 DTO
     */
    @Headers({
            "accept: application/json, text/plain, */*",
            "accept-language: zh-CN,zh;q=0.9",
            "cache-control: no-cache",
            "content-type: application/json;",
            "origin: https://mpbeta.csdn.net",
            "pragma: no-cache",
            "priority: u=1, i",
            "referer: https://mpbeta.csdn.net/",
            "sec-ch-ua: \"Chromium\";v=\"9\", \"Not?A_Brand\";v=\"8\"",
            "sec-ch-ua-mobile: ?0",
            "sec-ch-ua-platform: \"Windows\"",
            "sec-fetch-dest: empty",
            "sec-fetch-mode: cors",
            "sec-fetch-site: same-site",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36 SLBrowser/9.0.6.2081 SLBChan/10 SLBVPV/64-bit",
            "x-ca-key: 203803574",
            "x-ca-nonce: a29e75a3-76fc-44a1-9a30-de9819d87f66",
            "x-ca-signature: xPtjv8SsXABWYwYEV3vrTOHSFCyUpZUNAnkyqipuIl0=",
            "x-ca-signature-headers: x-ca-key,x-ca-nonce"
    })
    @POST("/blog-console-api/v1/postedit/saveArticle")
    Call<PostResponseDTO> postArticle(@Body PostRequestDTO postRequestDTO, @Header("Cookie") String cookieString);

}
