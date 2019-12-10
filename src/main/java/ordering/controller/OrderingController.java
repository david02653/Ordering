package ordering.controller;

import com.soselab.vmamvserviceclient.annotation.FeignRequest;
import com.soselab.vmamvserviceclient.annotation.FeignRequests;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ordering.Ordering;
import ordering.feign.NotificationInterface;
import ordering.feign.PaymentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;




@Api(value = "OrderingController", tags = "與購買相關的電影與雜物都在這裡")
@RestController
public class OrderingController {

	@Autowired
	PaymentInterface paymentInterface;

	@Autowired
	NotificationInterface notificationInterface;

/*	@RequestMapping(value="/pact", method = RequestMethod.GET)
	public String test2() { return "tom";}*/

	
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String index()
    {
		return "success";
    }

	// 模擬404
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/index2", method = RequestMethod.GET)
	public ResponseEntity<Ordering> index2()
	{

		return ResponseEntity.notFound().build();
	}

	// 模擬回應
	@ApiOperation(value = "測試是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/index3", method = RequestMethod.GET)
	public String index3()
	{

		String result = "wait success";


		long num = (long)(Math.random() * 30);
		try {
			Thread.sleep(num);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@FeignRequests(value = {@FeignRequest(client = PaymentInterface.class, method = "payment", parameterTypes = {String.class, String.class}), @FeignRequest(client = NotificationInterface.class, method = "newNotification", parameterTypes = {String.class, String.class})})
	@ApiOperation(value = "將購買電影加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newMovieOrdering", method = RequestMethod.GET)
    public String newMovieOrdering(@ApiParam(required = true, name = "moviesID", value = "電影編號")@RequestParam("moviesID") String moviesID)
    {
		try {
			if ((Ordering.newMovieOrdering(moviesID)).equals("success"))
				if ((paymentInterface.payment("1", "250")).equals("success"))
					if ((notificationInterface.newNotification("1", URLEncoder.encode("ordering Movies Successfully", "UTF-8"))).equals("success"))
						return "success";
		}catch (Exception e){
			e.printStackTrace();
		}

		return "fail";
    }

    @FeignRequests(value = {@FeignRequest(client = PaymentInterface.class, method = "payment", parameterTypes = {String.class, String.class}), @FeignRequest(client = NotificationInterface.class, method = "newNotification", parameterTypes = {String.class, String.class})})
	@ApiOperation(value = "將購買的周邊商品加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newGroceryOrdering", method = RequestMethod.GET)
    public String newGroceryOrdering(@ApiParam(required = true, name = "groceryID", value = "物品編號")@RequestParam("groceryID") String groceryID, @ApiParam(required = true, name = "quantity", value = "物品編號")@RequestParam("quantity") String quantity)
    {
		try {
			if ((Ordering.newGroceryOrdering(groceryID, quantity)).equals("success"))
				if ((paymentInterface.payment("1", "250")).equals("success"))
					if ((notificationInterface.newNotification("1", URLEncoder.encode("ordering Grocery successfully", "UTF-8"))).equals("success"))
						return "success";
		}catch (Exception e){
			e.printStackTrace();
		}

		return "fail";
    }
	
	@ApiOperation(value = "透過userID得到已購買電影的ID", notes = "回傳已購買電影ID")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getMovieFromOrderList", method = RequestMethod.GET)
    public String getMovieFromOrderList(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID)
    {
    	return Ordering.getMovieFromOrderList(userID);
    }
	
	@ApiOperation(value = "透過userID得到已購買周邊的ID", notes = "回傳已購買周邊ID")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getGroceryFromOrderList", method = RequestMethod.GET)
    public String getGroceryFromOrderList(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID)
    {
    	return Ordering.getGroceryFromOrderList(userID);
    }
	
}
