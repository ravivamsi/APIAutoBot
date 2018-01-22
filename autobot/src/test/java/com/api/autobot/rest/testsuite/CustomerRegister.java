/**
 * 
 */
package com.api.autobot.rest.testsuite;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.autobot.configuration.PathConfiguration;
import com.api.autobot.rest.post.HttpPost201;
import com.api.autobot.rest.post.HttpPost201Model;
import com.api.autobot.utilities.DateStringConverter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author vamsiravi
 *
 */
public class CustomerRegister {

	PathConfiguration pathConfig = new PathConfiguration();
	
	ExtentReports extentReports;
	
	ExtentTest test;
	
	String reportDirectoryPath = pathConfig.getReportsDirectory()+this.getClass().getSimpleName()+File.separator+DateStringConverter.dateStringConverter()+File.separator;
	
	String host = "http://restapi.demoqa.com/customer";
	
	String path = "/register";
	
	
	
	String contentType = "application/json";
	
	HttpPost201 httpPost201 = new HttpPost201();
//	Report 
	
	
	@BeforeTest
	public void init() throws Exception{
		System.out.println("The output directory of the report is "+ reportDirectoryPath);
		extentReports = new ExtentReports(reportDirectoryPath+this.getClass().getSimpleName()+"Report.html");
		
	}
	
	
	@Test(enabled=true)
	public void registerCustomer() throws ParseException{
		
		
		JSONObject payload = new JSONObject();
		payload.put("FirstName", "Ven" );
		payload.put("LastName", "Kat");
		payload.put("UserName", "venkat");
		payload.put("Password", "radrapula");
		payload.put("Email", "vekare123@gmail.com");
		
		
		
		
		
		HttpPost201Model httpPost201Model = httpPost201.apiTester( extentReports,  test,  "shuffleADeck", "This Test will cover the endpoint which will shuffle the deck based on the deck count", host, path, payload, contentType  );
		
//		Add Custom Assertions

		if(httpPost201Model.getJsonResponseObject().isEmpty()){
			httpPost201Model.getTest().log(LogStatus.FAIL, "The response is null");
		}else{
			
//		Add you validations here
			
			
		}
		
		
		
//		End the Test
		httpPost201Model.getExtentReports().endTest(httpPost201Model.getTest());
			
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(LogStatus.FAIL, result.getThrowable());
			
		}
//		extentReports.endTest(test);
	}
	
	@AfterTest
	public void endReport() throws Exception{
			
			extentReports.flush();
			extentReports.close();
			
	}
}
