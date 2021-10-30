package ParametersAndAuthentication;

import org.testng.annotations.Test;

import SDET21.GenericsUtils.JavaUtility;
import SDET21.POJO.Class.Projectlibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingGet {
	@Test
	public void requestchainging()
	{
		JavaUtility jLib =new JavaUtility();
		baseURI ="http://localhost";
		port=8084;
		
		//this is the first request to create a project
		Projectlibrary pLib=new Projectlibrary("pratibha", "Apple"+ jLib.getRandomNumber(), "Completed", 50);
		
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post("/addProject");
		
		//capture the project id using json path
		String myProjID=res.jsonPath().getString("projectId");
		System.out.println(myProjID);
		
		res.then().log().all();
		
		//this is second request to read the same project created in 1st request
		given()
		.pathParam("projID", myProjID)
		
		.when()
		.get("/projects/{projID}")
		
		.then().assertThat().statusCode(200).log().all();
		
	}
	
	

}
