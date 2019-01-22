package Ordering;

import java.util.ArrayList;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.bson.Document;
import org.bson.types.ObjectId;
//import org.jsoup.Jsoup;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Ordering {
	public static String getCinemaCatalog(String userID) {
		try {  
            
			
			
            MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4118");
            
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Movies");
            System.out.println("MongoDBConnect to database successfully");

            String result = "[";
            MongoCollection<Document> collection = mongoDatabase.getCollection("Movie");
            FindIterable<Document> fi = collection.find();
            MongoCursor<Document> cursor = fi.iterator();
            while(cursor.hasNext()) 
            {
            	result += cursor.next().toJson();
            	if(cursor.hasNext())
            		result += ",";
            }
            result += "]";
            System.out.println("Connect to database successfully");
            return result;
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return "{}";
        }
	}
	
	
	public static String orderingMovie(String moviesID) {
		try {
			System.out.println("MongoDBConnect to database orderinglist begin");
			
			MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4115");
			
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderingList");
	         System.out.println("MongoDBConnect to database successfully");
	         
	         MongoCollection<Document> collection = mongoDatabase.getCollection("orderingList");
	         
	         
	         ArrayList<Document> documents = new ArrayList<Document>();
	         
	         String[] moviesIDArr = moviesID.split(",");
	         
	         for(int i = 0; i < moviesIDArr.length; i++) {
		         Document doc = new Document("ObjectID", moviesIDArr[i])
		        		    .append("Category", "Movie")
		        		    .append("Quantity", 0);
		         
		         documents.add(doc);
	         }

    		collection.insertMany(documents);
			
	         return "succeess";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	

}

