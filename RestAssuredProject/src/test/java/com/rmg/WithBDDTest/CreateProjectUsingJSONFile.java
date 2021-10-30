package com.rmg.WithBDDTest;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFile {
	@Test
	public void CreateProjectUsingFile() throws FileNotFoundException
	{
		//read the file
		
		FileInputStream fis=new FileInputStream("./data.json");
		
		//request specification
		given()
		.contentType(ContentType.JSON)
		.body(fis)
		//actual request
		
		.when()
		.post("http://localhost:8084/addProject")
		
		//validation
		.then()
		.statusCode(201)
		.log().all();
		
		
	}
	

}
