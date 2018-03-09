/**
 * 
 */
package com.api.autobot.configuration;

/**
 * @author vamsiravi
 *
 */
public enum Projects {

	deckofcards("deckofcards"), salesforce("salesforce"), maxim("maxim"), microservices("microservices"), stocks("stocks");

	private String project;
	
	Projects(String project){
		this.project = project;
	}
	
	public String getProject(){
		return project;
	}
	

}
