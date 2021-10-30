package com.rmg.ProjectTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteOneResource {
	@Test
	public void delete()
	{
		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_618");
		ValidatableResponse validate = res.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().statusCode(204);
		validate.log().all();
		
		
		
	}
	

}
