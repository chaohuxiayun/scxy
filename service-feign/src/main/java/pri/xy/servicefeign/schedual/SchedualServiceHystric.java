package pri.xy.servicefeign.schedual;

import org.springframework.stereotype.Component;

/**
 * @Classname SchedualServiceHystric
 * @Description
 * @Date 2019/8/26 15:40
 * @Author xiayun
 */
@Component
public class SchedualServiceHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name + " error! --from feign";
    }
}
