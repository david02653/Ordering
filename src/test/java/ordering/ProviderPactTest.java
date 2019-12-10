/*
package ordering;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.ConfigurableWebApplicationContext;


import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;


//@SpringBootTest(classes=OrderingApplication.class,properties={"spring.profiles.active=test","spring.cloud.config.enabled=false"},webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@SpringBootTest
//@ActiveProfiles("test")
//@PactBroker(host="${pact.host}",port="${pact.port}")
//@PactBroker(host="127.0.0.1",port="8080")
@RunWith(PactRunner.class)
@Provider("test_provider")
//@ActiveProfiles("test")
@PactBroker(host="localhost",port="8500")
//@PactFolder("/ordering/pacts")
public class ProviderPactTest {
//    @TestTarget
//    public final Target target = new HttpTarget(9050);
//    public final Target target = new HttpTarget("http", "localhost", 8082, "/spring-rest");

    private static ConfigurableWebApplicationContext application;

    @BeforeClass
    public static void start() {
        application = (ConfigurableWebApplicationContext)
                SpringApplication.run(OrderingApplication.class);
    }

    @State("test GET")
    public void toGetState() {
    }

    @State("test POST")
    public void toPostState() { }
}
*/
