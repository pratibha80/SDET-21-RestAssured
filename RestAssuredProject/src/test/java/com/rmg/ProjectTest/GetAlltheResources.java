package com.rmg.ProjectTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAlltheResources {
	@Test
	public void getAlldata()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		System.out.println(resp.getContentType());
		System.out.println(resp.getTime());
		System.out.println(resp.statusCode());
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().statusCode(200);
		
		validate.log().all();
		
	}
	

}
