package Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Method.Common_Utility_Method;
//To reuse the method , functions etc of Common_Utility_Method in the current file

public class Post_Create_Repository 
    {
	public static String BaseURI() 
	{
		String baseuri = "https://reqres.in";
		return baseuri;	
	}
	public static String Post_Resource() 
	{
		String post_Resource = "/api/users";
		return post_Resource;
	}
	public static String Post_Req_TC01() throws IOException 
	{
		ArrayList<String> Req_Data = Common_Utility_Method.ReadDataExcel("Post_Ref", "TC2"); 
		 
		String Req_name = Req_Data.get(1);
		 
		String Req_job = Req_Data.get(2);
		 
		String RequestBody = "{\r\n\n"
				+ "    \"name\": \""+Req_name+"\",\r\n\n"
				+ "    \"job\": \""+Req_job+"\"\r\n\n"
				+ "}";
		return RequestBody;
	}
	
    }
    
