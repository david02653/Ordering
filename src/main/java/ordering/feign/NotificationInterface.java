package ordering.feign;

import com.soselab.vmamvserviceclient.annotation.TargetVersion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("notification")
@TargetVersion("0.0.1-SNAPSHOT")
public interface NotificationInterface {

	@RequestMapping(value = "/newNotification", method = RequestMethod.GET)
    String newNotification(@RequestParam("userID") String userID, @RequestParam("content") String content);


    @RequestMapping(value = "/getSomething2", method = RequestMethod.GET)
    String getSomething2(@RequestParam("userID") String userID);

}
