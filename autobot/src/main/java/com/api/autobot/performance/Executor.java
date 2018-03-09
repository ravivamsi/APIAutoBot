/**
 * 
 */
package com.api.autobot.performance;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.restassured.RestAssured;
import io.restassured.response.Response;



/**
 * @author vamsiravi
 *
 */
public class Executor {

	public void demonExecutor(){
	ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	Runnable worker = new MyRunnable("http://www.google.com");
	executor.execute(worker);
//	executor.execute(command);
	
//	Future<InputStream> response1 = executor.submit(new RestAssured.get("http://www.google.com"));
	
	// ...
//	ByteArrayOutputStream totalResponse = new ByteArrayOutputStream();
//	copyAndCloseInput(response1.get(), totalResponse);
//	totalResponse.
//	copyAndCloseInput(response2.get(), totalResponse);
	// ...
	executor.shutdown();
	}
	
	
	
	
	public static class MyRunnable implements Runnable {
		private final String url;
 
		MyRunnable(String url) {
			this.url = url;
		}
 
		public void run() {
 
			String result = "";
			int code = 200;
			try {
				Response response = RestAssured.get(url);
				if (response.getStatusCode() == code) {
					System.out.println("Passed");
				}else{
					System.out.println("Failed "+response.getStatusCode());
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}
