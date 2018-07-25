package com.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

/*
	
	randomBewteen(x,y) Tests
	
	*/
	//Tests rrandomBewteen(x,y) when x is greater than y
	@Test
	public void testXGreaterYRandomBewteen() {
		int x = 2, y = 10;
		int randomNumber = Utilities.randomBewteen(x, y);
		boolean bool = (x <= randomNumber && y >= randomNumber);
		assertTrue(bool);
	}
	//Tests randomBewteen(x,y) when x is less than y
	@Test
	public void testXLessYRandomBetween(){
		int x = 10, y = 2;
		int randomNumber = Utilities.randomBewteen(x, y);
		boolean bool = (x >= randomNumber && y <= randomNumber);
		assertTrue(bool);
	}
	//Tests randomBewteen(x,y) when x is equal to y
	@Test
	public void testXEqualYRandomBewteen(){
		int x = 10, y = 10;
		int randomNumber = Utilities.randomBewteen(x, y);
		boolean bool = (x == randomNumber);
		assertTrue(bool);
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

}
