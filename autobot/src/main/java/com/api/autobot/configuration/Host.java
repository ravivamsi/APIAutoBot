/**
 * 
 */
package com.api.autobot.configuration;

/**
 * @author vamsiravi
 *
 */
public enum Host {

	 registerhost("http://restapi.demoqa.com"), deckofcardshoststg("https://deckofcardsapi.com"),
	
	deckofcardshosttst("https://deckofcardsapi.com");
	
	private String host;
	
	Host(String host){
			this.host = host;
		}
		
		public String getHost(){
			return host;
		}
}
