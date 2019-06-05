package Ordering;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;

@FeignClient(name="api-gateway")
public interface FeignInterface {
	
	@RequestMapping(value = "/notification/newNotification", method = RequestMethod.GET)
    public String notification(@RequestParam("userID") String userID, @RequestParam("content") String content);
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String payment();
	
}
