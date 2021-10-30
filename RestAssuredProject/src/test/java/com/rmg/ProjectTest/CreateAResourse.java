package com.rmg.ProjectTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateAResourse {
	
	@Test
	public void create()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "pratibha");
		jobj.put("projectName", "rmg_project_01");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 10);
		
		RequestSpecification respec = RestAssured.given();
		respec.contentType(ContentType.JSON);
		respec.body(jobj);
		
		Response res = respec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = res.then();
		validate.assertThat().statusCode(201);
		validate.assertThat().contentType("application/json");
		validate.log().all();
		
		
	}

}
