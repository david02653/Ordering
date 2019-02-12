package Ordering;

import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.bson.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class OrderingController {
	@CrossOrigin(origins = "*")
	@RequestMapping("/")
    public String index() 
    {
		return "success";
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newMovieOrdering", method = RequestMethod.GET)
    public String newMovieOrdering(@RequestParam("moviesID") String moviesID)
    {
    	return Ordering.newMovieOrdering(moviesID);
    }
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "newGroceryOrdering", method = RequestMethod.GET)
    public String newGroceryOrdering(@RequestParam("groceryID") String groceryID, @RequestParam("quantity") String quantity)
    {
    	return Ordering.newGroceryOrdering(groceryID, quantity);
    }
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getMovieFromOrderList", method = RequestMethod.GET)
    public String getMovieFromOrderList(@RequestParam("userID") String userID)
    {
    	return Ordering.getMovieFromOrderList(userID);
    }
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "getGroceryFromOrderList", method = RequestMethod.GET)
    public String getGroceryFromOrderList(@RequestParam("userID") String userID)
    {
    	return Ordering.getGroceryFromOrderList(userID);
    }
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "notification", method = RequestMethod.GET)
    public String notification(@RequestParam("userID") String userID, @RequestParam("content") String content)
    {
		try {  
			return Ordering.notification(userID, content);
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return "{}";
        }
    	
    }
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "payment", method = RequestMethod.GET)
    public String payment(@RequestParam("userID") String userID, @RequestParam("price") String price)
    {
    	return Ordering.payment(userID, price);
    }
	
	
}
