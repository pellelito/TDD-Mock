package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import tddApi.Main;

class TestAPI {
	
	static String sURL; 
	static HttpURLConnection request;
	static JsonParser jp = new JsonParser(); //from gson
	static JsonObject chuckNorris;
	static JsonElement chuck;
	static String gotChuck;
    
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sURL = "https://api.chucknorris.io/jokes/random";
		URL url = new URL(sURL);
		request = (HttpURLConnection) url.openConnection();
		chuck = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
	    
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		sURL = null;
		request = null;
		jp = null;
		chuckNorris = null;
		chuck = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		request.connect();
		chuckNorris = chuck.getAsJsonObject(); //May be an array, may be an object. 
	}

	@AfterEach
	void tearDown() throws Exception {
		request.disconnect();
	}
	
	//Using bad name convention for educational reasons, to get extra use of displayname
	@Test
	@DisplayName("Got a quote?")
	void test1() throws JsonIOException, JsonSyntaxException, IOException {

	    gotChuck = chuckNorris.get("value").toString();
	    System.out.println(gotChuck);
		Assert.assertNotNull("Chuck's missing", gotChuck);
	}
	
	@Test
	@DisplayName("Got ID?")
	void test2() {
	    String gotChuck = chuckNorris.get("id").toString();
	    System.out.println(gotChuck);
		Assert.assertNotNull("Chuck's missing", gotChuck);
	}
	
	@Test
	@DisplayName("Icon the correct icon adress")
	void test3() {
		
	    String gotChuck = chuckNorris.get("icon_url").toString();
	    Assert.assertEquals("\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\"", gotChuck);
	}
	
	@Test
	@DisplayName("Got an adress?")
	void test4() {
	    String gotChuck = chuckNorris.get("url").toString();
	    System.out.println(gotChuck);
		Assert.assertNotNull("Chuck's missing", gotChuck);
	}
	
	@Test
	@DisplayName("Got the right quote")
	void test5() {
		
		Assert.assertEquals(chuckNorris.get("value").toString(), gotChuck);
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
