package ordering;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ordering.controller.OrderingController;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


//Ctrl+Shift+O 可以自動導入需要的包

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderingApplicationTests {

	@Autowired
	OrderingController orderingController;

	@Test
	public void testIndex() 
	{
		assertEquals( orderingController.index(), "success");
	}
	
	@Test
	public void testNewMovieOrdering() 
	{
		assertEquals( orderingController.newMovieOrdering("5c35ddffa3f01c41d8bb4192"), "success");
	}
	/*
	@Test
	public void testNewGroceryOrdering() 
	{
		assertEquals( orderingController.newGroceryOrdering("5c49e70e212d8d18c0fccd59", "3"), "success");
	}
	*/
	@Test
	public void testGetMovieFromOrderList() 
	{
		assertTrue( isJSONValid(orderingController.getMovieFromOrderList("1")) );
	}
	
	@Test
	public void testGetGroceryFromOrderList() 
	{
		assertTrue( isJSONValid(orderingController.getGroceryFromOrderList("1")) );
	}
	
	
	@After
	public void clearTest() {
		deleteNotification("1");
	}
	
	public boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        // edited, to include @Arthur's comment
	        // e.g. in case JSONArray is valid as well...
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static String deleteNotification(String ID) 
	{
		try {  
            
			System.out.println("MongoDBConnect to database begin");
            //連線到MongoDB服務 如果是遠端連線可以替換“localhost”為伺服器所在IP地址
			
            //通過連線認證獲取MongoDB連線
            MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4116");
            
            //連線到資料庫(schema)
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Notification");
            System.out.println("MongoDBConnect to database successfully");

            //選擇到collection
            MongoCollection<Document> collection = mongoDatabase.getCollection("notification");
            
            //找到最後一個並刪除
            collection.deleteOne(collection.find().sort(new BasicDBObject("_ID",-1)).first());
            return "success";
            
        } catch (Exception e) {  
            return e.getClass().getName() + ": " + e.getMessage() ;
        }
	}
	
	

}

