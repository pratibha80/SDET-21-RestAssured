package com.rmg.ProjectTest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashmap {
	@Test
	public void createProjectUsingHashmap()
	{
		HashMap map=new HashMap();
		map.put("createdBy", "pratibha");
		map.put("projectName", "Chrome");
		map.put("status", "Completed");
		map.put("teamSize", 20);
		
		// request specifiaction
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		// actual request
		.when()
		.post("http://localhost:8084/addProject")
		
		// validation
	   .then()
	   .assertThat()
	   .statusCode(201)
	   .contentType(ContentType.JSON)
	   .log().all();
	}

}
