package Ordering;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="api-gateway")
public interface FeignInterface {
	
	@RequestMapping(value = "/notification/newNotification", method = RequestMethod.GET)
    public String notification(@RequestParam("userID") String userID, @RequestParam("content") String content);
	
}
