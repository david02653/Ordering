package Ordering;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
@Component
public class Ordering {
	
	public static String newMovieOrdering(String moviesID) {
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
    		
    		// checkout , write deadly
    		
    		notification("1","Ordering Movies Successfully.");
    		
    		payment("1","250");
    		
    		
			
	         return "Ordering success.";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	
	public static String newGroceryOrdering(String groceryID, String quantity) {
		try {
			
			
			System.out.println("MongoDBConnect to database orderinglist begin");
			
			MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4115");
			
			 MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderingList");
	         System.out.println("MongoDBConnect to database successfully");
	         
	         MongoCollection<Document> collection = mongoDatabase.getCollection("orderingList");
	         
	         
	         ArrayList<Document> documents = new ArrayList<Document>();
	         
	         
	         // 
	         String[] groceryIDArr = groceryID.split(",");
	         String[] quantityArr = quantity.split(",");
	         
	         // insert into documents
	         for(int i = 0; i < groceryIDArr.length; i++) {
		         Document doc = new Document("ObjectID", groceryIDArr[i])
		        		    .append("Category", "Grocery")
		        		    .append("Quantity", quantityArr[i]);
		         
		         documents.add(doc);
	         }

	         // insert into collecion
    		collection.insertMany(documents);
    		
    		// checkout , write deadly
    		
    		notification("1","Ordering Grocery successfully.");
    		
    		payment("1","250");
    		
    		
    		
    		
	         return "Ordering success.";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	
	
	public static String payment(String userID, String price) {
		String result = "";
		try {
			URL url = new URL("http://140.121.196.23:4106/Payment");
			URLConnection urlConnection = url.openConnection();
			
			
			BufferedReader in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream()) );
			String current = "";
			while((current = in.readLine()) != null)
	         {
				result += current;
	         }
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public static String getMovieFromOrderList(String userID) {
		try {  
		            
			System.out.println("MongoDBConnect to database begin");
			
            MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4115");
            
            MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderingList");
            System.out.println("MongoDBConnect to database successfully");

            String result = "[";
            MongoCollection<Document> collection = mongoDatabase.getCollection("orderingList");
            FindIterable<Document> fi = collection.find(eq("Category","Movie"));
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
	
	
	public static String getGroceryFromOrderList(String userID) {
		try {  
		            
			System.out.println("MongoDBConnect to database begin");
			
            MongoClient mongoClient = MongoClients.create("mongodb://cinema:cinema@140.121.196.23:4115");
            
            MongoDatabase mongoDatabase = mongoClient.getDatabase("OrderingList");
            System.out.println("MongoDBConnect to database successfully");

            String result = "[";
            MongoCollection<Document> collection = mongoDatabase.getCollection("orderingList");
            FindIterable<Document> fi = collection.find(eq("Category","Grocery"));
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
	
	
	public static String notification(String userID, String content) {
		/*
		String result = "";
		
		//Logger logger = LoggerFactory.getLogger(Ordering.class);
		
		
		
		try {
			
			String originUrl = "http://140.121.196.23:4102/newNotification?userID=" + userID + "&content=" + content;
			String encodedURL = URLEncoder.encode(originUrl, "UTF-8");
			
			
			URL url = new URL(encodedURL);
			URLConnection urlConnection = url.openConnection();
			
			BufferedReader in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream()) );
			String current = "";
			while((current = in.readLine()) != null)
	         {
				result += current;
	         }
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
		//------------------
		
		String result = "";
		//這邊利用Jsoup爬蟲 直接拿到Notification的資料
		try {
			String originUrl = "http://140.121.196.23:4102/newNotification?userID=" + userID + "&content=" + content;
			String encodedURL = URLEncoder.encode(originUrl, "UTF-8");
			
			
			URL url = new URL(encodedURL);
			org.jsoup.nodes.Document xmlDoc =  Jsoup.parse(url, 3000); //使用Jsoup jar 去解析網頁
			result = xmlDoc.select("body").get(0).text();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	

}

