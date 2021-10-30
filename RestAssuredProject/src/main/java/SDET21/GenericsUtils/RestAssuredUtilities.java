package SDET21.GenericsUtils;

import io.restassured.response.Response;

/**
 * this class contains generic methods pertaining to rest-assured
 * @author Pratibha
 *
 */
public class RestAssuredUtilities {
	/**
	 * This method will return the data inside JSON path
	 */

	
	public String getJsonData(Response res,String jsonPath)
	{
		String value=res.jsonPath().getString(jsonPath);
		return value;
	}
}
