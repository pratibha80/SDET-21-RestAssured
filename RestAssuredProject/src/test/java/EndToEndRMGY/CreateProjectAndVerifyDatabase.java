package EndToEndRMGY;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import SDET21.GenericsUtils.BaseAPIClass;
import SDET21.GenericsUtils.EndPoints;
import SDET21.POJO.Class.Projectlibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateProjectAndVerifyDatabase extends BaseAPIClass {
	@Test
	public void createProjectAndVerifyInDB() throws Throwable
	{

		//create a project through API
		Projectlibrary pLib=new Projectlibrary("Pratibha", "Apple"+jLib.getRandomNumber(), "Completed", 10);
		Response res = given()
				.contentType(ContentType.JSON)
				.body(pLib)
				.when()
				.post(EndPoints.addProject);
				
				res.then().log().all();
				
				//capture the expected data
				String expData = rLib.getJsonData(res, "projectName");
				System.out.println(expData);
				
				//verify it in database
				String query = "select * from project";
				String actData = dLib.executeQueryGetData(query, 4, expData);
				
				//validate
				Assert.assertEquals(actData, expData);
				System.out.println("sucessful");
		
	
}
}