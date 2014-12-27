import com.jayway.jsonpath.JsonPath;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.testng.annotations.Test;

import java.io.*;

/**
 * Created by Zhong on 2014/12/1.
 */
public class TangHunt {

    @Test
    public void testStream() throws Exception {
        // The code works fine with this string.
        //String kafkaMessage = "{\"payload\":{\"description\":\"\",\"locales\":[{\"max_price\":0,\"id\":\"zh_CN\",\"min_price\":0,\"currency\":\"RMB\"}],\"id\":1934225080650566400,\"author_id\":3578599986148432000,\"editions\":[{\"avg_rating\":3,\"reviews\":[],\"uri\":\"3097872815824342187\",\"icon_id\":1254131973218745300,\"url\":\"\",\"name\":\"Moxiu\",\"platform_ids\":[2005],\"downloads\":130,\"description\":\"\",\"store\":\"wandoujia\",\"price\":0,\"rating_count\":0,\"currency\":\"RMB\",\"author_name\":\"moxiubd1\",\"app_id\":1934225080650566400,\"labels\":[\"virus_free\",\"ad_free\",\"official\"],\"icon_uri\":\"\",\"cents\":0,\"package_name\":\"aimoxiu.theme.mx\",\"apk_links\":{\"wandoujia\":\"\"},\"screenshots\":[],\"id\":3097872815824342000,\"size\":5967216,\"requirements\":{},\"app_uri\":\"1934225080650566308\",\"billing\":0,\"short_desc\":\"\",\"custom\":{}}],\"avg_rating\":0,\"delete_dt\":null,\"rating_count\":0,\"name\":\"Moxiu\",\"url\":\"\",\"short_desc\":\"\",\"icon_id\":1254131973218745300,\"icon_uri\":\"\",\"uri\":\"1934225080650566308\",\"platform_ids\":[2005],\"author_uri\":\"author:moxiu:\"},\"action\":\"put\",\"request_id\":\"ff7525a3-2cc8-4a53-b60d-a064e6a53a3b\"}";

        // However, this string will cause hang at line 66.
        String kafkaMessage = "{\"kdp_note\":\"proper-add\",\"time_stamp\":\"2014-11-21T11:35:30.469-08:00\",\"payload\":{\"description\":\"魔秀主题桌面—国内主题桌面先驱者\\n魔秀主题桌面团队数百名优秀设计师亲自为你打造属于你的主题桌面，万余种免费主>题桌面任你挑选，彰显手机个性。\\n千万用户的选择，用户心中“最潮”“最酷”“最时尚”的主题桌面。\\n最丰富的内容：海量精品主题桌面免费下载，总有一款适合你。\\n最干净的桌面：无任何广告插件干扰，主题桌面应用中耗用内存最少。\\n最时尚的界面：简洁，明快，更适合东方人的操作方式。\\n最便捷的功能：>主题桌面管理，随时下载保存最新主题桌面，应用一键添加，方便快捷。\\n最精彩的专题：资深小编每日推荐百余种个性主题桌面，让你永远紧跟>潮流。\\n——魔秀是一种时尚的选择\\n更多精彩请关注—魔秀主题桌面\",\"locales\":[{\"max_price\":0,\"id\":\"zh_CN\",\"min_price\":0,\"currency\":\"RMB\"}],\"id\":1934225080650566400,\"author_id\":3578599986148432000,\"editions\":[{\"avg_rating\":3,\"reviews\":[],\"uri\":\"3097872815824342187\",\"icon_id\":1254131973218745300,\"url\":\"http://www.wandoujia.com/apps/aimoxiu.theme.mx75635524a20428782423b73005a28828\",\"name\":\"百变小丸子魔秀桌面\",\"platform_ids\":[2005],\"downloads\":130,\"description\":\"魔秀主题桌面—国内主题桌面先驱者\\n魔秀主题桌面团队数百名优秀设计师亲自为你打造属于你的主题桌面，万余>种免费主题桌面任你挑选，彰显手机个性。\\n千万用户的选择>，用户心中“最潮”“最酷”“最时尚”的主题桌面。\\n最丰富的内容：海量精品主题桌面免费下载，总有一款适合你。\\n最干净的桌面：无任何广告插件干扰，主题桌面应用中耗用内存最少。\\n最时尚的界面：简洁，明快，更适合东方人的操作方式。\\n最便捷的功能：主题桌面管理，随时下载保存最新主题桌面，应用一键添加，方便快捷。\\n最精彩的专题：资深小编每日推荐百余种个性主题桌面，让你永远紧跟潮流。\\n——魔秀是一种时尚的选择\\n更多精彩请关注—>魔秀主题桌面\",\"store\":\"wandoujia\",\"price\":0,\"rating_count\":0,\"currency\":\"RMB\",\"author_name\":\"moxiubd1\",\"app_id\":1934225080650566400,\"labels\":[\"virus_free\",\"ad_free\",\"official\"],\"icon_uri\":\"http://img.wdjimg.com/mms/icon/v1/4/f1/38aac62ffe7b5a799c3f6e8415053f14_68_68.png\",\"cents\":0,\"package_name\":\"aimoxiu.theme.mx75635524a20428782423b73005a28828\",\"apk_links\":{\"wandoujia\":\"http://apps.wandoujia.com/apps/aimoxiu.theme.mx75635524a20428782423b73005a28828/qrbinded\"},\"screenshots\":[\"http://img.wdjimg.com/mms/screenshot/a/08/8245eba78c14c51adeaed30bc411108a_320_533.jpeg\",\"http://img.wdjimg.com/mms/screenshot/2/4f/ad4de21eb5f0c3a99072113b702e14f2_320_533.jpeg\",\"http://img.wdjimg.com/mms/screenshot/9/c3/13c0ba452c12b8a6b7224eb174427c39_320_533.jpeg\",\"http://img.wdjimg.com/mms/screenshot/1/b7/5482a8f94e11df737aea9a9b8f416b71_320_533.jpeg\",\"http://img.wdjimg.com/mms/screenshot/7/c6/452670e003f8af6d47f244b2baa88c67_320_533.jpeg\"],\"id\":3097872815824342000,\"size\":5967216,\"requirements\":{},\"app_uri\":\"1934225080650566308\",\"billing\":0,\"short_desc\":\"魔秀主题桌面—国内主题桌面先驱者\\n魔秀主题桌面团队数百名优秀设计师亲自为你打造属于你的主题桌面，万余种免费主题桌面任你挑选，彰显手机个性。\\n千万用户的选择，用户心中“最潮”“最酷”“>最时尚”的主题桌面。\\n最丰富的内容：海量精品主题桌面免费下载，总有一款适合你。\\n最干净的桌面：无任何广告插件干扰，主题桌面应用中耗用内存最少\",\"custom\":{}}],\"avg_rating\":0,\"delete_dt\":null,\"rating_count\":0,\"name\":\"百变小丸子魔秀桌面\",\"url\":\"http://www.wandoujia.com/apps/aimoxiu.theme.mx75635524a20428782423b73005a28828\",\"short_desc\":\"魔秀主题桌面—国内主题桌面先驱者\\n魔秀主题桌面团队数百名优秀设计师亲自为你打造属于你的主题桌面，万余种免费主题桌面任你挑选，彰显手机个性。\\n千万用户的选择，用户心中“最潮”“最酷”“>最时尚”的主题桌面。\\n最丰富的内容：海量精品主题桌面免费下载，总有一款适合你。\\n最干净的桌面：无任何广>告插件干扰，主题桌面应用中耗用内存最少\",\"icon_id\":1254131973218745300,\"icon_uri\":\"http://img.wdjimg.com/mms/icon/v1/4/f1/38aac62ffe7b5a799c3f6e8415053f14_68_68.png\",\"uri\":\"1934225080650566308\",\"platform_ids\":[2005],\"author_uri\":\"author:moxiubd1:\"},\"name\":\"KDP2163e221a-a0c3-4406-925f-8da1bcdc6254App\",\"action\":\"put\",\"message_id\":\"1\",\"source\":\"kdp.store\",\"request_id\":\"ff7525a3-2cc8-4a53-b60d-a064e6a53a3b\"}";
        String requestId = JsonPath.read(kafkaMessage, "$.request_id");
        byte[] content = JsonPath.read(kafkaMessage, "$.payload").toString().getBytes("UTF8");
        ArchiveOutputStream aos;
        try (OutputStream outputStream = new BufferedOutputStream(new ByteArrayOutputStream())) {
            outputStream.write(content);
            try (CompressorOutputStream cos = new CompressorStreamFactory().createCompressorOutputStream(CompressorStreamFactory.GZIP, outputStream)) {
                aos = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.TAR, cos);
                TarArchiveEntry tae = new TarArchiveEntry(requestId);
                tae.setSize(content.length);
                aos.putArchiveEntry(tae);
                aos.write(content);
                aos.closeArchiveEntry();
            }
        }
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("compressedData", aos.toString().getBytes("UTF8"));
        HttpPost httpPost = new HttpPost();
        httpPost.setEntity(entityBuilder.build());
    }
}
