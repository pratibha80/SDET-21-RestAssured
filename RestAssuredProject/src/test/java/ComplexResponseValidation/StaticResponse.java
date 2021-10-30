package ComplexResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class StaticResponse {
	@Test
	public void staticresponse()
	{
		
		baseURI ="http://localhost";
		port=8084;
		
		String expData="TY_PROJ_1002";
		
		//store all the response
		 Response res = when()
	  .get("/projects");		
				
				// capturing the data using json path
		 String actData = res.jsonPath().getString("[0].projectId");
		 System.out.println(actData);
		 
		 // validate
		 Assert.assertEquals(actData, expData);
		 System.out.println(actData + "data varified");
		 
		 res.then().log().all();
				
				
	}

}
