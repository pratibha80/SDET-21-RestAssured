

package ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameters {
	
	@Test
	public void queryparameter()
	{
		baseURI = "https://reqres.in";
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
	

}
