package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import tddApi.Main;
import tddApi.getChuckNorris;

class TestInMock {

	getChuckNorris test = mock(getChuckNorris.class);
	 
	@BeforeEach
	void addUser() {

		System.out.println("loading new test...");

	}
	
	//Using bad name convention for educational reasons, to get extra use of displayname
	@Test
	@DisplayName("Got a quote?")
	void test1() throws JsonIOException, JsonSyntaxException, IOException {
		
		// define return value
        when(test.getValue()).thenReturn("Chuck is watching....");

        // use mock in test....
        assertEquals(test.getValue(), "Chuck is watching....");
	}
	
	@Test
	@DisplayName("Got ID?")
	void test2() {
		
		// define return value
        when(test.getId()).thenReturn("42");

        // use mock in test....
        assertEquals(test.getId(), "42");
	}
	
	@Test
	@DisplayName("Icon the correct icon adress")
	void test3() {
		
		// define return value
        when(test.getIcon()).thenReturn("icon");

        // use mock in test....
        assertEquals(test.getIcon(), "icon");
	}
	
	@Test
	@DisplayName("Got an adress?")
	void test4() {
		
		// define return value
        when(test.getUrl()).thenReturn("URL");

        // use mock in test....
        assertEquals(test.getUrl(), "URL");
	}
	
	@Ignore
	@Test
	@DisplayName("Got the right quote")
	void test5() {
		
	}
	
	@Test
	@DisplayName("Got uppers")
	void test6() {
		
		String test = Main.toUpper("aaa");
		Assert.assertEquals("AAA".toString(), test);
	}
	
	@Test
	@DisplayName("Got lowers")
	void test7() {
		
		String test = Main.toLower("AAA");
		Assert.assertEquals("aaa".toString(), test);
	}
	
	@Test
	@DisplayName("Got sorted")
	void test8() {
		
		String test = Main.sortedString("cba");
		Assert.assertEquals("abc".toString(), test);
	}
	
	@Test
	@DisplayName("Got count")
	void test9() {
		
		int test = Main.stringLength("AAA");
		Assert.assertEquals(3, test);
	}
	
	@Test
	@DisplayName("Got trimed")
	void test10() {
		
		String test = Main.stringTrimed(" AAA ");
		Assert.assertEquals("AAA", test);
	}

}
