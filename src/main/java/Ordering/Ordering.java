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
	
	public static String newMovie(String moviesID) {
		try {
			
			
			System.out.println("MongoDBConnect to database orderinglist begin");
			
			MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4115");
			
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderingList");
	         System.out.println("MongoDBConnect to database successfully");
	         
	         MongoCollection<Document> collection = mongoDatabase.getCollection("orderingList");
	         
	         
	         ArrayList<Document> documents = new ArrayList<Document>();
	         
	         
	         // split moviesID from ,
	         String[] moviesIDArr = moviesID.split(",");
	         
	         // insert into documents
	         for(int i = 0; i < moviesIDArr.length; i++) {
		         Document doc = new Document("ObjectID", moviesIDArr[i])
		        		    .append("Category", "Movie")
		        		    .append("Quantity", 0);
		         
		         documents.add(doc);
	         }

	         // insert into collecion
    		collection.insertMany(documents);
			
	         return "Ordering success.";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	
	

}

