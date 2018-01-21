/**
 * 
 */
package com.api.autobot.rest.testsuite;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.autobot.configuration.PathConfiguration;
import com.api.autobot.utilities.DateStringConverter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author vamsiravi
 *
 */
public class DeckOfCards {
	
	
	PathConfiguration pathConfig = new PathConfiguration();
	
	ExtentReports extentReports;
	
	ExtentTest test;
	
	String reportDirectoryPath = pathConfig.getReportsDirectory()+this.getClass().getName()+File.separator+DateStringConverter.dateStringConverter()+File.separator;
	
//	Report 
	
	
	@BeforeTest
	public void init() throws Exception{
		System.out.print("The output directory of the report is "+ reportDirectoryPath);
//		extentReports = new ExtentReports(reportDirectoryPath+this.getClass().getName()+"Report.html");
//		test = extentReports.startTest(this.getClass().getName()+"Report");

	}
	
	
	@Test
	public void shuffleADeck(){
		
		Response response = RestAssured.get("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count="+"1");
		
		System.out.println("Response Time" +response.getTime());
		System.out.println("Response Time" +response.getStatusCode());
		System.out.println("Response Time" +response.getBody());
		System.out.println("Response Time" +response.getContentType());
		System.out.println("Response Time" +response.getHeaders());
		System.out.println("Response Time" +response.getSessionId());
		System.out.println("Get Status Line" +response.getStatusLine());
			
	}
	
//	Number of Tests
	
	/*
	 * Shuffle the Cards:
	 
		https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1
		Add deck_count as a GET or POST parameter to define the number of Decks you want to use. Blackjack typically uses 6 decks. The default is 1.


		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "shuffled": true,
		    "remaining": 52
		}
		Draw a Card:
		https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2
		The count variable defines how many cards to draw from the deck. Be sure to replace deck_id with a valid deck_id. We use the deck_id as an identifier so we know who is playing with what deck. After two weeks, if no actions have been made on the deck then we throw it away.

		TIP: replace <<deck_id>> with "new" to create a shuffled deck and draw cards from that deck in the same request.


		Response:
		{
		    "success": true,
		    "cards": [
		        {
		            "image": "https://deckofcardsapi.com/static/img/KH.png",
		            "value": "KING",
		            "suit": "HEARTS",
		            "code": "KH"
		        },
		        {
		            "image": "https://deckofcardsapi.com/static/img/8C.png",
		            "value": "8",
		            "suit": "CLUBS",
		            "code": "8C"
		        }
		    ],
		    "deck_id":"3p40paa87x90",
		    "remaining": 50
		}
		Reshuffle the Cards:
		https://deckofcardsapi.com/api/deck/<<deck_id>>/shuffle/
		Don't throw away a deck when all you want to do is shuffle. Include the deck_id on your call to shuffle your cards. Don't worry about reminding us how many decks you are playing with.


		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "shuffled": true,
		    "remaining": 52
		}
		A Brand New Deck:
		https://deckofcardsapi.com/api/deck/new/
		Open a brand new deck of cards. 
		A-spades, 2-spades, 3-spades... followed by diamonds, clubs, then hearts.

		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "shuffled": false,
		    "remaining": 52
		}
		A Partial Deck:
		https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH
		If you want to use a partial deck, then you can pass the card codes you want to use using the cards parameter. Separate the card codes with commas, and each card code is a just a two character case-insensitive string:

		The value, one of A (for an ace), 2, 3, 4, 5, 6, 7, 8, 9, 0 (for a ten), J (jack), Q (queen), or K (king);
		The suit, one of S (Spades), D (Diamonds), C (Clubs), or H (Hearts).
		In this example, we are asking for a deck consisting of all the aces, twos, and kings.

		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "shuffled": true,
		    "remaining": 12
		}
		Adding to Piles
		https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/add/?cards=AS,2S
		Piles can be used for discarding, players hands, or whatever else. Piles are created on the fly, just give a pile a name and add a drawn card to the pile. If the pile didn't exist before, it does now. After a card has been drawn from the deck it can be moved from pile to pile.

		Note: This will not work with multiple decks.

		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "remaining": 12,
		    "piles": {
		        "discard": {
		            "remaining": 2
		        }
		    }
		}
		Shuffle Piles
		https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/shuffle
		Note: This will not work with multiple decks.

		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "remaining": 12,
		    "piles": {
		        "discard": {
		            "remaining": 2
		        }
		    }
		}
		Listing Cards in Piles
		https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/list
		Note: This will not work with multiple decks.

		Response:
		{
		    "success": true,
		    "deck_id": "d5x0uw65g416",
		    "remaining": "42",
		    "piles": {
		        "player1": {
		            "remaining": "3"
		        },
		        "player2": {
		            "cards": [
		                {
		                    "image": "https://deckofcardsapi.com/static/img/KH.png",
		                    "value": "KING",
		                    "suit": "HEARTS",
		                    "code": "KH"
		                },
		                {
		                    "image": "https://deckofcardsapi.com/static/img/8C.png",
		                    "value": "8",
		                    "suit": "CLUBS",
		                    "code": "8C"
		                }
		            ],
		            "remaining": "2"
		        }
		    },
		}
		Drawing from Piles
		https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/draw/?cards=AS
		https://deckofcardsapi.com/api/deck/<<deck_id>>/pile/<<pile_name>>/draw/?count=2
		https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/bottom/
		Specify the cards that you want to draw from the pile. The default is to just draw off the top of the pile (it's a stack). Or add the bottom parameter to the URL to draw from the bottom.

		Response:
		{
		    "success": true,
		    "deck_id": "3p40paa87x90",
		    "remaining": 12,
		    "piles": {
		        "discard": {
		            "remaining": 1
		        }
		    },
		    "cards": [
		        {
		            "image": "https://deckofcardsapi.com/static/img/AS.png",
		            "value": "ACE",
		            "suit": "SPADES",
		            "code": "AS"
		        }
		    ]
		}
	
	
	
	*/
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(LogStatus.FAIL, result.getThrowable());
			
		}
//		extentReports.endTest(test);
	}
	
	@AfterTest
	public void endReport() throws Exception{
			
//			extentReports.flush();
//			extentReports.close();
			
	}
}
