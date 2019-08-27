package pri.xy.servieribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pri.xy.servieribbon.service.HelloService;

/**
 * @Classname HelloService
 * @Description
 * @Date 2019/8/26 11:37
 * @Author xiayun
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Autowired
    RestTemplate restTemplate;

    @Override
    // 创建熔断器功能，并指定熔断器的方法
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,error!";

    }

}
