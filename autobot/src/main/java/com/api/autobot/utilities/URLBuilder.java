/**
 * 
 */
package com.api.autobot.utilities;

import com.api.autobot.configuration.Environments;
import com.api.autobot.configuration.Host;

import com.api.autobot.configuration.Projects;

/**
 * @author vamsiravi
 *
 */
public class URLBuilder {
	
	public String ProjectEnvironmentHostMapper(Environments environment, Projects project){
		
		
		if(environment.equals(Environments.DEV)){
			switch(project){
			
				case deckofcards:
					
					return Host.deckofcardshosttst.getHost();
					
				case salesforce:
					
					
				case maxim:
					
				case microservices:
					
				case stocks:
					
					
				default:
					return null;
			
			}
		}else if(environment.equals(Environments.DR)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.INT)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.PROD)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.SANDBOX)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.QA)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.STG)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.SYS)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else if(environment.equals(Environments.TST)){
			switch(project){
			
			case deckofcards:
				
				return Host.deckofcardshosttst.getHost();
				
			case salesforce:
				
				
			case maxim:
				
			case microservices:
				
			case stocks:
				
				
			default:
				return null;
		
		}
	
			
		}else{
			
		}
		
		return null;
		
	}
}
