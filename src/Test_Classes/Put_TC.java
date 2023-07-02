package Test_Classes;

import java.io.IOException;

import org.testng.Assert;


import Common_API_Method.Put_API_Method;
import Repository.Put_Repository;
import io.restassured.path.json.JsonPath;

public class Put_TC { 
	public static void extractor() throws IOException {
		
	int statusCode = Put_API_Method.ResponsestatusCode(Put_Repository.BaseURI(),Put_Repository.Put_Resource(),Put_Repository.Put_Req_TC1());
	System.out.println(statusCode);
	
	String ResponseBody = Put_API_Method.ResponseBody(Put_Repository.BaseURI(),Put_Repository.Put_Resource(),Put_Repository.Put_Req_TC1());
	System.out.println(ResponseBody);
	
	JsonPath jspResponse = new JsonPath(ResponseBody);
	String res_name = jspResponse.getString("name");
    String res_job = jspResponse.getString("job");
    String res_updatedAt = jspResponse.getString("updatedAt");
    res_updatedAt = res_updatedAt.substring(0,11);
    
    Assert.assertEquals(res_name,"morpheus");
	Assert.assertEquals(res_job,"zion resident");
	
	}

}