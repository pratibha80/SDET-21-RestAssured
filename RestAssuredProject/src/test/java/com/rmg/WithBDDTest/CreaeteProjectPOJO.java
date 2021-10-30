package com.rmg.WithBDDTest;

import org.testng.annotations.Test;

import SDET21.GenericsUtils.JavaUtility;
import SDET21.POJO.Class.Projectlibrary;
import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class CreaeteProjectPOJO {
	@Test
	public void CreateProjectUsingPOJO()
	{
		JavaUtility jLib=new JavaUtility();
		
		baseURI ="http://localhost";
		port = 8084;
		//read data through pojo class
		Projectlibrary pLib=new Projectlibrary("Pratibha", "BadDay", "On Going",1 );
		
		// request specification
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		
		// request
		
		.when()
		.post("/addProject")
		
		//validation
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
