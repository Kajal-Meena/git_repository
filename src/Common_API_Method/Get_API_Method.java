package Common_API_Method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Get_API_Method {
public static int ResponseStatusCode(String BaseURI,String Resource) {
		
		RestAssured.baseURI = BaseURI;
		
		int statusCode = given().header("Content-Type","application/json")
				.body("").when().get(Resource).then().extract()
				.statusCode();
		return statusCode ;
	}
		
	public static String ResponseBody(String BaseURI,String Resource) {
			
		RestAssured.baseURI = BaseURI;
			
		String Responsebody = given().header("Content-Type","application/json")
				.body("").log().all().when().get(Resource).then().log().all().extract()
				.response().asPrettyString();
		return Responsebody;
	}
}