/**
 * 
 */
package com.api.autobot.configuration;

/**
 * @author vamsiravi
 *
 */
public enum Environments {

	TST("TST"), STG("STG"), PROD("PROD"), SYS("SYS"), INT("INT"), DEV("DEV"), DR("DR"), SANDBOX("SANDBOX"), QA("QA"); 

	
	
private String environment;
	
Environments(String environment){
		this.environment = environment;
	}
	
	public String getEnvironment(){
		return environment;
	}
}
