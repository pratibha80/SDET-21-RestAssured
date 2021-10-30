package com.rmg.ProjectTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateAllTheResource {
	
	@Test
	public void update()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Tpratibha");
		jobj.put("projectName", "Shri_project_01");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 12);
		
		RequestSpecification respec = RestAssured.given();
		respec.contentType(ContentType.JSON);
		respec.body(jobj);
		
		 Response res = respec.put("http://localhost:8084/projects/TY_PROJ_1002");
		ValidatableResponse validate = res.then();
		validate.assertThat().contentType("application/json");
		validate.log().all();
		
		
		
		
		
	}

}
