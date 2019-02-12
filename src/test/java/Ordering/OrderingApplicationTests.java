package Ordering;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//Ctrl+Shift+O 可以自動導入需要的包

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderingApplication.class)
@WebAppConfiguration
public class OrderingApplicationTests {

	@Autowired
	Ordering ordering;
	@Test
	public void contextLoads() throws Exception{
				
		ordering.notification("1", "Junit test");
		
	}

}

