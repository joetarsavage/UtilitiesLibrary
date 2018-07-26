package com.utilities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Pattern;

public class Utilities {
	
	//takes 2 numbers and returns a random number between them
	//order doesn't matter
	//returns the number if they are equal
	public static int randomBewteen(int x, int y){
		Random rand = new Random();
		if(x>y){
			return rand.nextInt(x-y) + y;
		}else if(x<y){
			return rand.nextInt(y-x) + x;
		}else{
			return x;
		}
	}
	
	//takes 2 strings as arguments
	//first string is the string that you would like to parse
	//second string is a string of characters you'd like to remove from the first string
	//method returns first string with all characters in the second string removed
	public static String parseByMultipleChar(String toParse, String parseBy){
		StringBuilder sb = new StringBuilder();
		for(char stringChar : toParse.toCharArray()){
			if(parseBy.indexOf(stringChar) < 0){
				sb.append(stringChar);
			}
		}
		return sb.toString();
	}
	
	//takes a date object and string as arguments
	//string is the way you want to format the date (i.e. "hh:mm:ss a MM/dd/YYYY")
	//returns the date as a formated string
	public static String dateToString(Date date, String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	//takes string as argument
	//counts number of words in the string
	//returns the number of words
	public static int wordCounter(String string){
		return string.split(" ").length;
	}
	
	//takes string argument
	//uses regex to determine if string is a valid phone number
	//returns true if yes
	public static boolean isPhoneNumber(String phoneNumber) {	
		Pattern pattern = Pattern.compile("^[01]?[- .]?(\\([2-9]\\d{2}\\)|[2-9]\\d{2})[- .]?\\d{3}[- .]?\\d{4}$", Pattern.CASE_INSENSITIVE);
		if(pattern.matcher(phoneNumber).find()) {
			return true;
		}
		return false;
	}
	
	//takes string argument
	//uses regex to determine if string is a valid email
	//returns true if yes
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if(pattern.matcher(email).find()) {
			return true;
		}
		return false;
	}

	//takes string argument
	//uses regex to determine if string is a valid email
	//and if it ends in @its.jnj.com
	//returns true if yes
	public static boolean isJnjEmail(String email) {
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if(pattern.matcher(email).find() && email.endsWith("@its.jnj.com")) {
			return true;
		}
		return false;
	}

	//takes string argument
	//determines if string is a valid date
	//returns true if yes
	@SuppressWarnings("deprecation")
	public static boolean isDate(String date) {
	    try {
	    	Date.parse(date);
	    	return true;
	    }catch(Exception e){
	    	return false;
	    }
	}

	//takes string argument
	//uses regex to determine if string is a valid positive number
	//returns true if yes
	public static boolean isNonNegative(String number) {
		Pattern pattern = Pattern.compile("^(\\d*\\.)?\\d+$");
		if(pattern.matcher(number).find()) {
			return true;
		}
		return false;
	}

	//takes string argument
	//determines if given url has https at the beginning
	//returns true if yes
	public static boolean hasHttps(String url) {
		return (url.startsWith("https://"));
	}

}
