package ordering.feign;

import com.soselab.vmamvserviceclient.annotation.TargetVersion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("payment")
//@TargetVersion("0.0.1-SNAPSHOT")
public interface PaymentInterface {

//	@RequestMapping(value = "/notification/newNotification", method = RequestMethod.GET)
//    String notification(@RequestParam("userID") String userID, @RequestParam("content") String content);

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    String payment(@RequestParam("userID") String userID, @RequestParam("price") String price);

}
