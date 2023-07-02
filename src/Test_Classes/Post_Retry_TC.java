package Test_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;


import Common_API_Method.Post_Create_API_Method;
import Repository.Post_Create_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Retry_TC {
	public static void extractor() throws IOException {
		System.out.println("extractor method call");
		for(int i=0;i<5;i++) {
			int statusCode = Post_Create_API_Method.ResponseStatusCode(Post_Create_Repository.BaseURI(),
					Post_Create_Repository.Post_Resource() ,
					Post_Create_Repository.Post_Req_TC01()) ;
		System.out.println(statusCode);
		
		if(statusCode==201) {
			String ResponseBody = Post_Create_API_Method.ResponseBody(Post_Create_Repository.BaseURI(),
					Post_Create_Repository.Post_Resource() ,
					Post_Create_Repository.Post_Req_TC01()) ;
			System.out.println(ResponseBody);
			
			String RequestBody = Post_Create_Repository.Post_Req_TC01() ;
			
			//validator method
			Validator(RequestBody,ResponseBody);
			break;
		}
		else {
			System.out.println("invalid statuscode");
		}
		}
	    }
	       
	        public static void Validator(String requestBody, String responseBody) {
	         System.out.println("validator method call");
	         JsonPath jspres = new JsonPath (responseBody);
	   		 String Res_name = jspres.getString("name");
	   		 System.out.println();
	   		 String Res_job = jspres.getString("job");
	   		 String Res_id = jspres.getString("id");
	   		 String Res_createdAt= jspres.getString("createdAt");
	   		 Res_createdAt = Res_createdAt.substring(0,10);		
	
	   		 
	         JsonPath jspreq = new JsonPath (requestBody);
	   		 String Req_name = jspres.getString("name");
	   		 System.out.println();
	   		 String Req_job = jspres.getString("job");
   		     LocalDateTime currentdate = LocalDateTime.now();
	   		 String expectedDate = currentdate.toString().substring(0,10);
	   		 
	   		Assert.assertEquals(Res_name,Req_name);
	   		Assert.assertEquals(Res_job,Req_job);
	   		Assert.assertEquals(Res_id,0);
	   		Assert.assertEquals(Res_id,null);
	   		Assert.assertEquals(Res_createdAt,expectedDate);
		
	}

}
