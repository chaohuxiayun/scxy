package pri.xy.servieribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ServiceRibbonApplication
 * @Description
 * @Date 2019/8/26 11:24
 * @Author xiayun
 */
@SpringBootApplication
@EnableEurekaClient
// 向服务中心注册
@EnableDiscoveryClient
// 开启断路器 Hystrix
@EnableHystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceRibbonApplication.class, args );
    }

    @Bean
    // 表明restTemplate是负载均衡的
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}