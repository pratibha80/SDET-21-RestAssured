package ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Oauth2_Authentication {
	@Test
	public void oauth2_Authentication()
	{
		Response res = given()
		.formParam("client_id", "SDET-21 RMGY-REST")
		.formParam("client_secret", "a3e35a41813e96a8a36a4ebbd3058579")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri ", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String Token=res.jsonPath().get("access_token");
		System.out.println(Token);
		
		//create a new request to access the token
		
		given()
		.auth()
		.oauth2(Token)
		.pathParam("USER_ID", "2394")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then().log().all();
		
		
	}

}
