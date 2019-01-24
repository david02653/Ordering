package Ordering;

import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping(value = "newMovieOrdering", method = RequestMethod.GET)
    public String newGroceryOrdering(@RequestParam("groceryID") String groceryID, @RequestParam("quantity") String quantity)
    {
    	return Ordering.newGroceryOrdering(groceryID, quantity);
    }
	
}
