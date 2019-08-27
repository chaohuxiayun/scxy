package pri.xy.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname EurekaCLient2Application
 * @Description
 * @Date 2019/8/26 15:17
 * @Author xiayun
 */

@SpringBootApplication
// 表明自己是一个client
@EnableEurekaClient
@RestController
public class EurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run( EurekaClient2Application.class, args );
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "xy") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
