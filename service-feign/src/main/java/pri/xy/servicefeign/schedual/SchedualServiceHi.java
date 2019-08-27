package pri.xy.servicefeign.schedual;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname SchedualServiceHi
 * @Description
 * @Date 2019/8/26 14:36
 * @Author xiayun
 */

// @FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口
@FeignClient(value = "service-hi",fallback = SchedualServiceHystric.class)
public interface  SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
