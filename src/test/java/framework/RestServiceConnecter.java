package framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;




public class RestServiceConnecter {

	
	private Scanner sc;

/**
 * 
 * @param url
 * @param requestMethod
 * @param ContentType
 * @return
 * @throws IOException
 */
	public HttpURLConnection openRestConnection(String url, String StateAbrv,String requestMethod, String ContentType)
			throws IOException {
		 sc = new Scanner(System.in);  
      if(StateAbrv!=null){

	   url=url+"/"+ StateAbrv.toUpperCase();
	
	
}
     else{
		   System.out.println("\n"+"Enter your state abbreviation:");  
		   String Stateabbr=sc.next();
		   
		   if(Stateabbr.contains("exit")){
			
			   System.exit(0);
			  
		   }
		   else{
			   url=url+"/"+ Stateabbr.toUpperCase();  
			   
		   }
		   
}
		url.replace("https://", "http://");

		URL urlObj;
		HttpURLConnection connection = null;
		try {
			urlObj = new URL(url);

			System.out.println("\nSending " + requestMethod.toUpperCase() + " request to URL : " + url);

			System.out.println("Find below response Details\n");

			connection = (HttpURLConnection) urlObj.openConnection();
			if (ContentType != null) {
				connection.setRequestProperty("Content-Type", ContentType);
			}

			connection.setRequestMethod(requestMethod.toUpperCase());

			connection.setDoOutput(true);

		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Response Code Received : " + connection.getResponseCode());
		return connection;
	}
/**
 * 
 * @param connection
 * @return
 * @throws Exception
 */
	public String getRestResponse(HttpURLConnection connection) throws Exception {

		StringBuffer response = new StringBuffer();
		BufferedReader br = null;
		if (connection.getResponseCode() == 200) {
			br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
 
		} else {
			br = new BufferedReader(new InputStreamReader((connection.getErrorStream())));

		}

		String inputLine;

		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
	
		//System.out.println("response  "+response);
		//String xmlResponse =  StringUtil.convertStringToXml(response.toString());
		
		System.out.println("\n\nResponse Received :: \n\n" + response + "\n");
		 
		 
		return response.toString();
	}


}
