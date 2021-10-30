package ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {
	@Test
	public void bearerToke()
	{
            // create the data
		HashMap map=new HashMap();
		
		map.put("name","REST-SDET21-BEARER-Token");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all();
		
	}

}
