package testcases;


import org.testng.annotations.Test;


import framework.RestFuntions;




public class funtional {

	
	
	@Test(priority=1)
	public void Largest_City_And_Capital() throws Exception{
		
		while (true){
			RestFuntions.executeRESTRequest("http://services.groupkt.com/state/get/USA",null,"GET",null);
			RestFuntions.JsonPath();
			
		}
	}
	
	@Test(priority=2)
	public void InvalidInput() throws Exception{

		RestFuntions.executeRESTRequest("http://services.groupkt.com/state/get/USA","ABC123","GET",null);
		
		RestFuntions.ValidateResponse();
		
		
	}		
	 

	
}


		