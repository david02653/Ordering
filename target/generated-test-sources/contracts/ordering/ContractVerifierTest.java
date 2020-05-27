package ordering;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import ordering.ProviderRoleBaseTestClass;
import org.junit.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

public class ContractVerifierTest extends ProviderRoleBaseTestClass {

	@Test
	public void validate_cinemacatalog_validate_prime_number() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("number","2")
					.get("/validate/prime-number");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("Even");
	}

	@Test
	public void validate_cinemacatalog_newMovieOrdering() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("moviesID","5e0b10fa974ef74883b43403")
					.get("/newMovieOrdering");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("success");
	}

	@Test
	public void validate_cinemacatalog_getMovieFromOrderList() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("userID","1")
					.get("/getMovieFromOrderList");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
	}

	@Test
	public void validate_groceryinventory_newGroceryOrdering() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("groceryID","5c49e70e212d8d18c0fccd55")
					.queryParam("quantity","2")
					.get("/newGroceryOrdering");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("success");
	}

	@Test
	public void validate_groceryinventory_getGroceryFromOrderList() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("userID","1")
					.get("/getGroceryFromOrderList");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
	}

}
