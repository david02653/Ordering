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
			
			MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4118");
			
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderingList");
	         System.out.println("MongoDBConnect to database successfully");
	         
	         MongoCollection<Document> collection = mongoDatabase.getCollection("orderingList");
	         
	         
	         Document doc1 = new Document("ObjectID", "123")
	        		    .append("Category", "test")
	        		    .append("Quantity", 666);
	
	         Document doc2 = new Document("ObjectID", "321")
	        		    .append("Category", "test2")
	        		    .append("Quantity", 222);

    		ArrayList<Document> documents = new ArrayList<Document>();
    		documents.add(doc1);
    		documents.add(doc2);

    		collection.insertMany(documents);
			
	         return "success";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	

}

