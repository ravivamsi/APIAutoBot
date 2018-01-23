/**
 * 
 */
package com.api.autobot.rest.put;

import org.json.simple.JSONObject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;

/**
 * @author vamsiravi
 *
 */
public class HttpPut204Model {
	
	
	ExtentReports extentReports;
	
	ExtentTest test;
	
	Response response;
	
	JSONObject jsonResponseObject;

	/**
	 * @return the jsonResponseObject
	 */
	public JSONObject getJsonResponseObject() {
		return jsonResponseObject;
	}

	/**
	 * @param jsonResponseObject the jsonResponseObject to set
	 */
	public void setJsonResponseObject(JSONObject jsonResponseObject) {
		this.jsonResponseObject = jsonResponseObject;
	}

	/**
	 * @return the extentReports
	 */
	public ExtentReports getExtentReports() {
		return extentReports;
	}

	/**
	 * @param extentReports the extentReports to set
	 */
	public void setExtentReports(ExtentReports extentReports) {
		this.extentReports = extentReports;
	}

	/**
	 * @return the test
	 */
	public ExtentTest getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(ExtentTest test) {
		this.test = test;
	}

	/**
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
	



}
