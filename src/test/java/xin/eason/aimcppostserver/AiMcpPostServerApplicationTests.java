package xin.eason.aimcppostserver;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xin.eason.aimcppostserver.domain.model.PostRequest;
import xin.eason.aimcppostserver.domain.model.PostResponse;
import xin.eason.aimcppostserver.domain.service.CsdnPostService;

@Slf4j
@SpringBootTest
class AiMcpPostServerApplicationTests {

    @Autowired
    private CsdnPostService csdnPostService;

    @Test
    public void apiTest() {
        PostRequest request = new PostRequest();
        request.setTitle("测试测试测试11111");
        request.setDesc("这是一篇测试文章");
        request.setTags("Java,MCP");
        request.setMarkdownContent("# 测试测试测试 \n **这是一个测试段落**");

        String cookieString = "fid=20_93490702654-1730121421213-525865; UN=eason8811; historyList-new=%5B%5D; c_ins_prid=-; c_ins_rid=1737969160702_848437; c_ins_fref=https://blog.csdn.net/m0_37573740/article/details/137380136; c_ins_fpage=/index.html; c_ins_um=-; ins_first_time=1737969163053; ssxmod_itna=Yq0xy7it0QiQqAKDQDXDnnA=qF3oFqhC8qa=DlcDrxA5D8D6DQeGTW2FeaIrsKAIjGbeD9YrpPdY=+lxheAiz+4GLDmKDyFQiTr3D4fKGwD0eG+DD4DWfx03DoxGYBGx0bSyuLvzQGRD0YDzqDgD7QVbqDEDG3D036pQi+nD73Df4DAtTr9mDDll0wxQGGPDYpnmM34ZuiDAkxg8AhnD0tDIqGXGiH3xDU1Ma4lmTF8NPp2eWiDtqD9beUjQeDH7TNSDMW3FDoXEG54SFp=YAG++7lxbGwPBRkdniEe33xo8AAhRG3oRjxlPt=YD; ssxmod_itna2=Yq0xy7it0QiQqAKDQDXDnnA=qF3oFqhC8qbD61RD05re03iTXD97Ojtl4n+al8qzSGj8xNYc3zQO01xE6RHXHFWtP8T1ip+mAWwiE2TCwKFqbWlaL8HOG57GKv9ibUHb7/Z5xhoTGyNXgeTZr77xbWqY1Yigp5Fxp5rDtg3aRW+DoKmUZRTycOOXQWWs/qb6he8yx8fV7eAxxf7/imtG8mryb8IjfkbSWft2p5AeMMNxaf2ocj+x4azMGkqbuqATq3hMjM3C55c0Zw9oc=N9/6W+xPy66qw+rellnHMCZwT8MTMSCzMurzskr4havwz6LxbODKlx7wssT=9kGbOqgue4x+Mi=4m8OOkqi=07zFnojkGf28Iki1CxdeioC8D8zq7tQnCPiYXEsK3mgwGtxooQpzLkQ8DulkjevZemMMvqfxhki1OGKbfIuIVeix6KvDDwO5DjKDeT44D=; tfstk=gPwm021etSlfKKzpkzkf97uZ1qC-GnMs2PptWA3Na4u5fAHYH70gbylt_lIjbzV_SALxHfIijyqHkIhYMzDgjkrYHPIbrc4LYiZYWqUoUcoB7CJwguWrh8FvBqQjIlzKIwQdp9EbDfMNJwBtC_omQcWt7_hq9Gh82wQdpTdP8QICJrIzY_xof4oq0KJVqTojzI-47qlyzDmIQVza70krYDdw0clZaUuSbAua7ASu4ApJg2eaT87zKXoLwquLEmcm8ufBQdmXpj0U04vN88mcQ2rqrCRZk3SFSuqAopZ-hoznvrBynyqQFzmz8OboCzNa7c4PdFHb9rwIZu1eUoDmyXub01RnNf00a-lkbdrSeVcQsrbDGqPYrXirahXI2y3zc-PlfUr4JqDq4bBFxulaw-GQHaJmLWZxH5z19QM0bSkl4oOyTHhHCypiVCOsg0goJE6_O9PTFealqgALfjoSA2IlqCOsg0ioJgjk9RGqVDgd.; p_uid=U010000; csdn_newcert_eason8811=1; dc_sid=e544f19dc5512462a728cff55f8abaf3; c_first_ref=default; c_first_page=https%3A//so.csdn.net/so/search%3Fspm%3D1001.2101.3001.4498%26q%3D%25E8%25AF%25A5%25E6%2596%2587%25E4%25BB%25B6%25E5%258C%2585%25E5%2590%25AB%25E4%25B8%258D%25E8%2583%25BD%25E5%259C%25A8%25E5%25BD%2593%25E5%2589%258D%25E4%25BB%25A3%25E7%25A0%2581%25E9%25A1%25B5%2528936%2529%25E4%25B8%25AD%25E8%25A1%25A8%25E7%25A4%25BA%25E7%259A%2584%25E5%25AD%2597%25E7%25AC%25A6%25E3%2580%2582%25E8%25AF%25B7%25E5%25B0%2586%25E8%25AF%25A5%25E6%2596%2587%25E4%25BB%25B6%25E4%25BF%259D%25E5%25AD%2598%25E4%25B8%25BA%2520Unicode%2520%25E6%25A0%25BC%25E5%25BC%258F%25E4%25BB%25A5%25E9%2598%25B2%25E6%25AD%25A2%25E6%2595%25B0%25E6%258D%25AE%25E4%25B8%25A2%25E5%25A4%25B1%26t%3D%26u%3D%26urw%3D%26s%3Dnew; HMACCOUNT=1DB1DCB0C03E6F13; c_dl_fref=https://so.csdn.net/so/search; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1746269141,1746454567,1746492763; uuid_tt_dd=10_19036646940-1747399243064-685690; c_segment=10; c_dl_prid=1747807579203_982370; c_dl_rid=1747807586065_703743; c_dl_fpage=/download/m0_73411917/89710492; c_dl_um=distribute.pc_search_result.none-task-download-2%7Eall%7Etime_text%7Edefault-1-90168111-null-null.142%5Ev102%5Epc_search_result_base8; is_advert=1; _clck=2o0q6m%7C2%7Cfw4%7C0%7C1764; creative_btn_mp=3; c_utm_source=cknow_so_nontop_query; SESSION=0f54ab67-372c-4358-9cda-79f88feae590; hide_login=1; loginbox_strategy=%7B%22taskId%22%3A317%2C%22abCheckTime%22%3A1747924194302%2C%22version%22%3A%22ExpA%22%2C%22nickName%22%3A%22%E9%98%8E%E7%82%8E%22%7D; UserName=eason8811; UserInfo=7862bc68e20b4b53a5761bd89dcd9369; UserToken=7862bc68e20b4b53a5761bd89dcd9369; UserNick=%E9%98%8E%E7%82%8E; AU=371; BT=1747924224140; FCNEC=%5B%5B%22AKsRol-BI0vvneH46EpHyYE1-9N-I01MnONxvDKelV6YkOIbUWhHa23-Bpvxkz6OIygBaZSUaHNVp-st-XfSN-7qlv_nPlCKPyDQtw57sZC3XaXjcFDGVt5Xg5We8B_AWKLI3Gbo_7UsYhjBFy8yc5B1tlhAXiJ-FA%3D%3D%22%5D%5D; fe_request_id=1747926150463_9644_1780261; __gads=ID=fabd9903ef73909a:T=1730302298:RT=1747926182:S=ALNI_MbhRY3y3imn56zQHkJSuJd9xKgtqQ; __gpi=UID=00000f448a159490:T=1730302298:RT=1747926182:S=ALNI_MY0K90-l35MUGJZ9aaLdnCRpJkwig; __eoi=ID=d3d078d9db396f18:T=1745858642:RT=1747926183:S=AA-Afjao9b3EFIa4Zpvy7UXm4D9_; c_pref=https%3A//blog.csdn.net/moshowgame/article/details/146544293%3Fops_request_misc%3D%25257B%252522request%25255Fid%252522%25253A%252522dae5eda8ab15f4e487285d2a374fdeba%252522%25252C%252522scm%252522%25253A%25252220140713.130102334.pc%25255Fall.%252522%25257D%26request_id%3Ddae5eda8ab15f4e487285d2a374fdeba%26biz_id%3D0%26utm_medium%3Ddistribute.pc_search_result.none-task-blog-2%7Eall%7Etime_text%7Edefault-1-146544293-null-null.142%5Ev102%5Epc_search_result_base8%26utm_term%3Dmaven%25E9%2595%259C%25E5%2583%258F%26spm%3D1018.2226.3001.4187; c_ref=https%3A//so.csdn.net/so/search%3Fspm%3D1001.2101.3001.4498%26q%3Dmaven%25E9%2595%259C%25E5%2583%258F%26t%3D%26u%3D%26urw%3D%26s%3Dnew; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1747926192; _clsk=83a2r0%7C1747926194767%7C7%7C0%7Ca.clarity.ms%2Fcollect; dc_session_id=10_1747979496116.906142; log_Id_view=1; dc_tos=swp9mv; log_Id_click=3";

        PostResponse postResponse = csdnPostService.postArticle(request);
        log.info("发表文章响应: {}", postResponse);
    }

}
