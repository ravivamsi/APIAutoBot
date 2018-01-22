/**
 * 
 */
package com.api.autobot.rest.post;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.api.autobot.utilities.HttpStatusCodes;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author vamsiravi
 *
 */
public class HttpPost201 {
	


	public HttpPost201Model apiTester(ExtentReports extentReports, ExtentTest test, String testCaseName, String testCaseDescription, String host, String path, JSONObject payload, String contentType) throws ParseException {
		
		
		HttpPost201Model httpGet206Model = new HttpPost201Model();
		
		test = extentReports.startTest(testCaseName, testCaseDescription);
		
//		Assume - Parameters
		
//		 When 
		test.log(LogStatus.INFO, "Host Name "+ host);
		test.log(LogStatus.INFO, "Path "+ path);
		
		RestAssured.baseURI = host;
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", contentType);
		request.body(payload.toJSONString());
		
		Response response = RestAssured.post(path);
		
		
//		Then

//		Check the Status Code
		if(HttpStatusCodes.statusCode201.equals(response.getStatusCode())){
			test.log(LogStatus.PASS, "The Actual Status Code is as Expected "+response.getStatusCode());
		}else{
			test.log(LogStatus.PASS, "The Actual Status Code is not as Expected "+response.getStatusCode());
		}
		
//		Log the Response Time
		test.log(LogStatus.INFO, "The response time for the request took "+ response.getTime()+ " milli seconds");
		
//		Log Response Headers
		test.log(LogStatus.INFO, "The response headers for the request are "+ response.getHeaders());
		
//		Log the Response Body
		test.log(LogStatus.INFO, "The Response Body Pretty Print "+ System.getProperty("line.separator")+ response.getBody().prettyPrint());
		
		JSONParser jsonpParser = new JSONParser();
		JSONObject jsonResponseObject = (JSONObject) jsonpParser.parse(response.body().asString());
		
//		Set the Model 
		httpGet206Model.setExtentReports(extentReports);
		httpGet206Model.setResponse(response);
		httpGet206Model.setTest(test);
		httpGet206Model.setJsonResponseObject(jsonResponseObject);
		
		System.out.println("Response Time " +response.getTime());
		System.out.println("Get Status Line" +response.getStatusLine());
		System.out.println("Actual Status Code " +response.getStatusCode());
		System.out.println("Content Type " +response.getContentType());
		System.out.println("Response Headers " +response.getHeaders());
		System.out.println("Response in Body " +response.getBody().prettyPrint());

		return httpGet206Model; 
		
		
	}

}
