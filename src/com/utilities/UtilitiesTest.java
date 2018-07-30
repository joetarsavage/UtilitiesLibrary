package com.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	@Test
	public void testUtilities() {
		Utilities utilities = new Utilities();
		utilities.toString();
	}
	/*

	randomBewteen(x,y) Tests
	
	*/
	//Tests rrandomBewteen(x,y) when x is greater than y
	@Test
	public void testXGreaterYRandomBewteen() {
		int x = 2, y = 3;
		int randomNumber = Utilities.randomBewteen(x, y);
		assertTrue(x <= randomNumber && y >= randomNumber);
	}
	//Tests randomBewteen(x,y) when x is less than y
	@Test
	public void testXLessYRandomBetween(){
		int x = 10, y = 2;
		int randomNumber = Utilities.randomBewteen(x, y);
		assertTrue(x >= randomNumber && y <= randomNumber);
	}
	//Tests randomBewteen(x,y) when x is equal to y
	@Test
	public void testXEqualYRandomBewteen(){
		int x = 10, y = 10;
		int randomNumber = Utilities.randomBewteen(x, y);
		assertTrue(x == randomNumber);
	}
	
	/*
	
	parseByMultipleChar(String toParse, String parseBy) Tests
	
	*/
	@Test
	public void testParseByMultipleChar(){
		String oldString = "Testing/ :)&%^^><><Method";
		String newString = Utilities.parseByMultipleChar(oldString, "/:)%&^><");
		assertEquals("Testing Method", newString);
	}
	
	/*
	
	dateToString(Date date, String format) Tests
	
	*/
	@Test
	public void testDateToString(){
		@SuppressWarnings("deprecation")
		Date oldDate = new Date("12/12/2012");
		assertEquals(Utilities.dateToString(oldDate, "hh:mm:ss a | MM/dd/YYYY"),"12:00:00 AM | 12/12/2012");
		assertEquals(Utilities.dateToString(oldDate,"hh:mm a MMM d, YYYY"),"12:00 AM Dec 12, 2012");
	}
	
	/*
	
	wordCounter(String string) Tests
	
	*/
	@Test
	public void testWordCounter(){
		String str1 = "This is a test sentence for testing";
		String str2 = "Hello there friend";
		assertEquals(7,Utilities.wordCounter(str1));
		assertEquals(3,Utilities.wordCounter(str2));
	}
	
	@Test
	public void testIsPhoneNumber(){
		String str1 = "This is a test sentence for testing";
		String str2 = "215-460-490";
		String str3 = "215-460-49";
		String str4 = "215-460-490p";
		String str5 = "215-460-";
		String str6 = "215-460-4908";
		assertFalse(Utilities.isPhoneNumber(str1));
		assertFalse(Utilities.isPhoneNumber(str2));
		assertFalse(Utilities.isPhoneNumber(str3));
		assertFalse(Utilities.isPhoneNumber(str4));
		assertFalse(Utilities.isPhoneNumber(str5));
		assertTrue(Utilities.isPhoneNumber(str6));
	}
	
	@Test
	public void testIsEmail(){
		String str1 = "joey";
		String str2 = "joey@";
		String str3 = "joey@comcast";
		String str4 = "joey@comcast.";
		String str5 = "@comcast.net";
		String str6 = "joey@comcast.net";
		assertFalse(Utilities.isEmail(str1));
		assertFalse(Utilities.isEmail(str2));
		assertFalse(Utilities.isEmail(str3));
		assertFalse(Utilities.isEmail(str4));
		assertFalse(Utilities.isEmail(str5));
		assertTrue(Utilities.isEmail(str6));
	}
	@Test
	public void testIsJnjEmail(){
		String str1 = "joey";
		String str2 = "joey@";
		String str3 = "joey@its";
		String str4 = "joey@its.jnj";
		String str5 = "@its.jnj.com";
		String str6 = "joey@comcast.net";
		String str7 = "joey@its.jnj.com";
		assertFalse(Utilities.isJnjEmail(str1));
		assertFalse(Utilities.isJnjEmail(str2));
		assertFalse(Utilities.isJnjEmail(str3));
		assertFalse(Utilities.isJnjEmail(str4));
		assertFalse(Utilities.isJnjEmail(str5));
		assertFalse(Utilities.isJnjEmail(str6));
		assertTrue(Utilities.isJnjEmail(str7));
	}
	
	@Test
	public void testIsDate(){
		String str1 = "This is a test sentence for testing";
		String str2 = "10";
		String str3 = "10/";
		String str4 = "10/100";
		String str5 = "10/fds10";
		String str6 = "10/10/10";
		String str7 = "10/10/10 12:00:00";
		assertFalse(Utilities.isDate(str1));
		assertFalse(Utilities.isDate(str2));
		assertFalse(Utilities.isDate(str3));
		assertFalse(Utilities.isDate(str4));
		assertFalse(Utilities.isDate(str5));
		assertTrue(Utilities.isDate(str6));
		assertTrue(Utilities.isDate(str7));
	}
	
	@Test
	public void testIsNonNegative() {
		String num1 = "-9";
		String num2 = "-9.9";
		String num3 = "-9.po";
		String num4 = "-";
		String num5 = "9.f";
		String num6 = "9.";
		String num7 = "9l";
		String num8 = "9.9";
		String num9 = "9";
		String num10 = ".9";
		
		assertFalse(Utilities.isNonNegative(num1));
		assertFalse(Utilities.isNonNegative(num2));
		assertFalse(Utilities.isNonNegative(num3));
		assertFalse(Utilities.isNonNegative(num4));
		assertFalse(Utilities.isNonNegative(num5));
		assertFalse(Utilities.isNonNegative(num6));
		assertFalse(Utilities.isNonNegative(num7));
		assertTrue(Utilities.isNonNegative(num8));
		assertTrue(Utilities.isNonNegative(num9));
		assertTrue(Utilities.isNonNegative(num10));
		
	}
	
	@Test
	public void testIsSecurePassoword() {
		String pass1 = "";
		String pass2 = "password";
		String pass3 = "Password";
		String pass4 = "password1";
		String pass5 = "Password1";
		String pass6 = "#password1";
		String pass7 = "#Password";
		String pass8 = "#Password1";

		assertFalse(Utilities.isSecurePassword(pass1));
		assertFalse(Utilities.isSecurePassword(pass2));
		assertFalse(Utilities.isSecurePassword(pass3));
		assertFalse(Utilities.isSecurePassword(pass4));
		assertFalse(Utilities.isSecurePassword(pass5));
		assertFalse(Utilities.isSecurePassword(pass6));
		assertFalse(Utilities.isSecurePassword(pass7));
		assertTrue(Utilities.isSecurePassword(pass8));
	}
	
	@Test
	public void testHasHttps() {
		String url1 = "www.google.com";
		String url2 = "http://www.google.com";
		String url3 = "https://www.google.com";
		
		assertFalse(Utilities.hasHttps(url1));
		assertFalse(Utilities.hasHttps(url2));
		assertTrue(Utilities.hasHttps(url3));
	}
	
	@Test
	public void testWriteToFile_Success() throws IOException {
		String path = "/Users/jtarsavage/";
		String fileName = "scoreTest.txt";
		String toWrite = "Hello there!";
		
		assertTrue(Utilities.writeToFile(path+fileName, toWrite));
	}
	
	@Test
	public void testWriteToFile_Failure() throws IOException {
		String path = "/Users/jtarsavage/HighScores/";
		String fileName = "scoreTest.txt";
		String toWrite = "Hello there!";
		
		assertFalse(Utilities.writeToFile(path+fileName, toWrite));
	}
	
	@Test
	public void testReadFromFile_Success() throws IOException {
		String path = "/Users/jtarsavage/";
		String fileName = "scoreTest.txt";
		String toRead = "Hello there!";
		
		assertEquals(toRead, Utilities.readFromFile(path+fileName));
	}
	
	@Test
	public void testReadFromFile_Failure() throws IOException {
		String path = "/Users/jtarsavage/HighScores/";
		String fileName = "scoreTest.txt";
		String toRead = "Hello there!";
		
		assertNotEquals(toRead, Utilities.readFromFile(path+fileName));
	}
}
