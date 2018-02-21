package framework;


import java.net.HttpURLConnection;
import com.jayway.jsonpath.JsonPath;
import framework.RestServiceConnecter;


public class RestFuntions {
	
public static String RESTResponse;
	
	public static void executeRESTRequest(String url,String StateAbrv,String requestMethod, String ContentType)
			throws Exception {

		 RestServiceConnecter restconn = new RestServiceConnecter();
	HttpURLConnection connect = restconn.openRestConnection(url, StateAbrv, requestMethod, ContentType);
	RESTResponse = restconn.getRestResponse(connect);

	
}
	
	
	public static void JsonPath(){

		JsonPath compile = JsonPath.compile("$.RestResponse.result.largest_city");
		String largest_city= compile.read(RestFuntions.RESTResponse);
		JsonPath compile2 = JsonPath.compile("$.RestResponse.result.capital");
		String CapitalCity = compile2.read(RestFuntions.RESTResponse);

		System.out.println("Largest City of :"+largest_city +"\n"+ "CapitalCity is :"+ CapitalCity );
		
	}
	public static void ValidateResponse(){
	if (RestFuntions.RESTResponse.contains("No matching state found for requested code")){
		System.out.println("Validated the Invalid Input Successfully");
	}
}
}