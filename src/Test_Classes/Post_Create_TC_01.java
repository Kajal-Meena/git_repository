package Test_Classes;

import java.io.IOException;

import org.testng.Assert;


import Common_API_Method.Post_Create_API_Method;
import Repository.Post_Create_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Create_TC_01 { 
	
	public static void extractor () throws IOException{
		
		int statusCode = Post_Create_API_Method.ResponseStatusCode(Post_Create_Repository.BaseURI(),
				Post_Create_Repository.Post_Resource() ,
				Post_Create_Repository.Post_Req_TC01()) ;
		System.out.println("Print From TC01 StatusCode " +statusCode);
		
		String ResponseBody = Post_Create_API_Method.ResponseBody(Post_Create_Repository.BaseURI(),
				Post_Create_Repository.Post_Resource() ,
				Post_Create_Repository.Post_Req_TC01()) ;
		System.out.println("Print from TC01 ResponseBody" +ResponseBody);
		
		JsonPath jspres = new JsonPath (ResponseBody);
		 String Res_name = jspres.getString("name");
		 System.out.println();
		 String Res_job = jspres.getString("job");
		Assert.assertEquals(statusCode,201);
		System.out.println("Print from TC01 Check StatusCode is :"+statusCode);
	}

}
