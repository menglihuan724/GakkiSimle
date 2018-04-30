import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by terrymeng
 * IM启动类
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableCaching
@ComponentScan(basePackages = {"com.terry.gakkisimle.IM"})
public class IMApplication {
    public static void main(String[] args) {
       SpringApplication.run(IMApplication.class, args);
    }
}