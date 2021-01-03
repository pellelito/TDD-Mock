package tddApi;

import java.util.Arrays;
import java.util.Collections;

import com.google.gson.JsonObject;

public class Main {
	
	static getChuckNorris chuck = new getChuckNorris();
	static JsonObject chuckNorris = chuck.setChuck();
	public static void main(String[] args) {
		// my main method is in a class called Main because that's how I was taught, and I have no imagination ;-)	
		
		printIcon();
		printId();
		printUrl();
		printValue();
		System.out.println(toUpper(chuck.getValue()));
		System.out.println(toLower(chuck.getValue()));
		System.out.println(sortedString(chuck.getValue()));
		System.out.println(stringLength(chuck.getValue()));
		System.out.println(stringTrimed(chuck.getValue()));
		
	}
	private static void printIcon() {
		
		System.out.println(chuck.getIcon());
	}
	
	private static void printId() {
		
		System.out.println(chuck.getId());
	}

	private static void printUrl() {
		
		System.out.println(chuck.getUrl());
	}

	private static void printValue() {
		
		System.out.println(chuck.getValue());
	}
	
	public static String toUpper(String s) {
			
		return s.toUpperCase();
	}
	
	public static String toLower(String s) {
		
		return s.toLowerCase();
	}
	
	public static String sortedString(String s) {
		
		char ch[] = s.toCharArray();
		Arrays.sort(ch);	
		return new String(ch);
		
	}
	
	public static int stringLength(String s) {
		
		return s.length();
	}
	
	public static String stringTrimed(String s) {
		
		return s.trim();
	}
	
	
}

