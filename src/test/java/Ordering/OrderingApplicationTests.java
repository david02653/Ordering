package Ordering;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Ordering.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderingApplicationTests {

	@Autowired
	Ordering ordering;
	@Test
	public void contextLoads() {
				
		ordering.notification("1", "Ordering successfully");
		
	}

}

