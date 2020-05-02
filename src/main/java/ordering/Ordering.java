package ordering;

import com.mongodb.client.*;
import org.bson.Document;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.FilterBuilder;
import org.springframework.stereotype.Component;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;
import java.util.function.Predicate;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
@Component
public class Ordering {
	
	private static Logger logger = Logger.getLogger(Ordering.class.getName());

	private static final String dbURL = "mongodb://cinema:cinema@140.121.196.23:4115";
	private static final String dbName = "OrderingList";
	private static final String collectionName = "orderingList";
	
	public static String newMovieOrdering(String moviesID) {
		try {

	         
	         MongoCollection<Document> collection = mongodbGetCollection();
	         
	         
	         ArrayList<Document> documents = new ArrayList<Document>();
	         
	         
	         // split moviesID from ,
	         String[] moviesIDArr = moviesID.split(",");
	         
	         // insert into documents
	         for(int i = 0; i < moviesIDArr.length; i++) {
		         Document doc = new Document("objectid", moviesIDArr[i])
		        		    .append("category", "Movie")
		        		    .append("quantity", 0);
		         
		         documents.add(doc);
	         }

	         // insert into collecion
    		collection.insertMany(documents);

	         return "success";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            logger.warning("function newMovieOrdering test unsuccessfully");
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	
	public static String newGroceryOrdering(String groceryID, String quantity) {
		try {
	         
	         MongoCollection<Document> collection = mongodbGetCollection();
	         
	         
	         ArrayList<Document> documents = new ArrayList<Document>();
	         
	         
	         // 
	         String[] groceryIDArr = groceryID.split(",");
	         String[] quantityArr = quantity.split(",");
	         
	         // insert into documents
	         for(int i = 0; i < groceryIDArr.length; i++) {
		         Document doc = new Document("objectid", groceryIDArr[i])
		        		    .append("category", "Grocery")
		        		    .append("quantity", quantityArr[i]);
		         
		         documents.add(doc);
	         }

	         // insert into collecion
    		collection.insertMany(documents);
    		
	         return "success";
		} catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            logger.warning("function newGroceryOrdering test unsuccessfully");
            return e.getClass().getName() + ": " + e.getMessage();
        }
	}
	
	
	public static String getMovieFromOrderList(String userID) {
		try {

			MongoCollection<Document> collection = mongodbGetCollection();

            String result = "[";

            FindIterable<Document> fi = collection.find(eq("category","Movie"));
            MongoCursor<Document> cursor = fi.iterator();
            while(cursor.hasNext()) 
            {
            	result += cursor.next().toJson();
            	if(cursor.hasNext())
            		result += ",";
            }
            result += "]";
            System.out.println("Connect to database successfully");
            
            logger.info("function getMovieFromOrderList test successfully");
            
            return result;
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            logger.warning("function getMovieFromOrderList test unsuccessfully");
            return "{}";
        }
	}


	public static String getGroceryFromOrderList(String userID) {
		try {

			MongoCollection<Document> collection = mongodbGetCollection();

            String result = "[";

            FindIterable<Document> fi = collection.find(eq("category","Grocery"));
            MongoCursor<Document> cursor = fi.iterator();
            while(cursor.hasNext()) 
            {
            	result += cursor.next().toJson();
            	if(cursor.hasNext())
            		result += ",";
            }
            result += "]";
            System.out.println("Connect to database successfully");
            
            logger.info("function getGroceryFromOrderList test successfully");
            
            return result;
            
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            logger.warning("function getGroceryFromOrderList test unsuccessfully");
            return "{}";
        }
	}

	public static MongoCollection<Document> mongodbGetCollection() {
		try {

			System.out.println("MongoDBConnect to database begin");
			logger.info("MongoDBConnect to database begin");

			MongoClient mongoClient = MongoClients.create(dbURL);

			MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
			System.out.println("MongoDBConnect to database successfully");
			logger.info("MongoDBConnect to database successfully");

			MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

			if( collection != null){
				System.out.println("Get collection successfully");
				logger.info("Get collection successfully");
			}


			return collection;

		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}

		return null;
	}

	public static void refl() {
		//Reflections ref = new Reflections();
		//Predicate<String> filter = new FilterBuilder().include(".*\\.groovy").include(".*\\.json");
		//ref.save(System.getProperty("user.dir") + "/target/test-classes" + "/META-INF/reflections/testModel-reflections.xml");
		//Set<String> resolved = ref.getResources(Pattern.compile(".*resource1-reflections\\.xml"));

		String current = System.getProperty("user.dir");

		System.out.println(current);
	}
	

}

