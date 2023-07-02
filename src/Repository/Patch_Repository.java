package Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Method.Common_Utility_Method;

public class Patch_Repository
{
	public static String BaseURI()
	{
		String baseuri = "https://reqres.in";
		return baseuri;
	}
	
	public static String Post_Resource()
	{
		String patch_Resource ="/api/users/2";
		return patch_Resource ;
	}
	
	public static String post_ReqBody() throws IOException
	{
		ArrayList<String> Req_Data = Common_Utility_Method.ReadDataExcel("Patch_Ref", "TC1");
		String Req_name = Req_Data.get(1);
		String Req_job = Req_Data.get(2);
		
		String RequestBody = "{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}\r\n"
				+ "";
		return RequestBody;
	}

}
