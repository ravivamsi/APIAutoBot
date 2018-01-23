/**
 * 
 */
package com.api.autobot.faker;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

/**
 * @author vamsiravi
 *
 */
public class Generator {

	Faker faker = new Faker();
	Random random = new Random();
	
	
	public String getDummyFullName(){
		return faker.name().fullName();
	}
	
	
	public String getDummyFirstName(){
		return faker.name().firstName();
	}
	
	
	public String getDummyLastName(){
		return faker.name().lastName();
	}
	
	
	public String getDummyMiddleName(){
		return faker.name().nameWithMiddle();
	}
	
	
	public String getDummyTitle(){
		return faker.name().title();
	}

	
	public String getDummyPrefix(){
		return faker.name().prefix();
	}
		
	
	public String getDummySuffix(){
		return faker.name().suffix();
	}
	
	
	public String getDummyUsername(){
		return faker.name().username();
	}
	
	public String getDummyCompanyIndustry(){
		return faker.company().industry();
	}
	
	public String getDummyCompanyBS(){
		return faker.company().bs();
	}
	
	public String getDummyCompanyBuzzWord(){
		return faker.company().buzzword();
	}
	
	public String getDummyCompanyCatchPhrase(){
		return faker.company().catchPhrase();
	}
	
	public String getDummyCompanyLogo(){
		return faker.company().logo();
	}

	public String getDummyCompanyName(){
		return faker.company().name();
	}
		
	public String getDummyCompanyProfession(){
		return faker.company().profession();
	}
	
	public String getDummyCompanyUrl(){
		return faker.company().url();
	}

	public String getDummyCompanySuffix(){
		return faker.company().suffix();
	}
	
	public String getDummyCreditCardNumber(){
		return faker.business().creditCardNumber();
	}
	
	public String getDummyBusinessCCExpiry(){
		return faker.business().creditCardExpiry();
	}
	
	public String getDummyBusinessCCType(){
		return faker.business().creditCardType();
	}
	
	public int getDummyBusinessCVV(){
		return faker.number().numberBetween(100, 999);
	}
	
	public int getRandomIntegerNumber(Integer min, Integer max){
		return faker.number().numberBetween(min, max);
	}
	
	public Long getRandomLongNumber(Long min, Long max){
		return faker.number().numberBetween(min, max);
	}
	
	public boolean getRandomBoolean(){
		return random.nextBoolean();
	}
	
	public String getRandomUnBoundedString(Integer limit){
		byte[] array = new byte[limit]; // length of string is rectricted by limit variable 
	    new Random().nextBytes(array);
		return new String(array, Charset.forName("UTF-8"));
	}
	
	public String getRandomBoundedString(Integer leftBound, Integer rightBound, Integer length){
		Random random = new Random();
	    StringBuilder buffer = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	        int randomLimitedInt = leftBound + (int) 
	          (random.nextFloat() * (rightBound - leftBound + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    return buffer.toString();    
	}
	
	public String getBoundedRandomStringApacheCommons(Boolean useLetters, Boolean useNumbers, Integer length){
		return RandomStringUtils.random(length, useLetters, useNumbers);
	}
	
	public String getRandomAlphanumericString(Integer length){
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	public String getAlphabeticString(Integer length){
		return RandomStringUtils.randomAlphabetic(length);
	}
}
