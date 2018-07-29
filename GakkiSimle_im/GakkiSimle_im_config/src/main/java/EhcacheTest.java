import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import java.net.URL;

public class EhcacheTest {
    public static void main(String[] args) throws Exception{
        /**
         * 创建缓存管理对象
         */
        URL url = EhcacheTest.class.getResource("ehcache.xml");
        CacheManager cacheManager = CacheManager.create(url);
        Thread.sleep(2000);
        /**
         * 取出数据
         */
        Cache cache = cacheManager.getCache("test1");

        System.out.println(cache.get("menglihuan1"));

        cacheManager.shutdown();
    }
}