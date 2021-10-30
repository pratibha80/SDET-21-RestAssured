package com.rmg.ProjectTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetSingleResource {
	
	@Test
	public void GetSingleFile()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1002");
		System.out.println(resp.getContentType());
		System.out.println(resp.getTime());
		System.out.println(resp.statusCode());
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().statusCode(200);
		
		validate.log().all();
	}
	

}
