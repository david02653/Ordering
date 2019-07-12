package Ordering;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;




@Api(value = "OrderingController", tags = "與購買相關的電影與雜物都在這裡")
@RestController
public class OrderingController {

	@Autowired
	PaymentInterface paymentInterface;
	
	
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String index()
    {
		return "success";
    }
	
	@ApiOperation(value = "將購買電影加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newMovieOrdering", method = RequestMethod.GET)
    public String newMovieOrdering(@ApiParam(required = true, name = "moviesID", value = "電影編號")@RequestParam("moviesID") String moviesID)
    {
    	return Ordering.newMovieOrdering(moviesID);
    }
	
	@ApiOperation(value = "將購買的周邊商品加入資料庫", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newGroceryOrdering", method = RequestMethod.GET)
    public String newGroceryOrdering(@ApiParam(required = true, name = "groceryID", value = "物品編號")@RequestParam("groceryID") String groceryID, @ApiParam(required = true, name = "quantity", value = "物品編號")@RequestParam("quantity") String quantity)
    {
    	return Ordering.newGroceryOrdering(groceryID, quantity);
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
	
	@ApiOperation(value = "將訊息加入資料庫中", notes = "成功加入資料庫就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "notification", method = RequestMethod.GET)
    public String notification(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID, @ApiParam(required = true, name = "content", value = "訊息內容")@RequestParam("content") String content)
    {

		try {
			return Ordering.notification(userID, URLEncoder.encode(content, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return "{}";

		
/*
		String result = "";
		try {
			
			result = feignInterface.notification(userID, URLEncoder.encode(content, "UTF-8"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;

*/
    }

	@ApiOperation(value = "結帳", notes = "成功結帳就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "payment", method = RequestMethod.GET)
    public String payment(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID, @ApiParam(required = true, name = "price", value = "價錢")@RequestParam("price") String price)
    {
//    	return Ordering.payment(userID, price);

		String result = "";
		try {

			result = paymentInterface.payment();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

    }

	public String payment2(String userID, String price)
	{
//    	return Ordering.payment(userID, price);

		String result = "";
		try {

			result = paymentInterface.payment();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
}
