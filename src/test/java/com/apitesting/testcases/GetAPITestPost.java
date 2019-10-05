package com.apitesting.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.base.TestBase;
import com.restapi.httpmethods.RestClint;
import com.restapi.users.Users;

public class GetAPITestPost extends TestBase {
	public TestBase testBase;
	String mainUrl;
	String serviceUrl;
	String url;
	RestClint restClient;
	CloseableHttpResponse closableHttpResponse;

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		// Getting the urls from the propertie file
		mainUrl = properties.getProperty("url");
		serviceUrl = properties.getProperty("serviceURL");
		url = mainUrl + serviceUrl;

	}
	
	@Test
	public void getHttpPost() throws ClientProtocolException, IOException {
		// Adding Headers to hash map
		Map<String, String> headerMaps = new HashMap<String, String>();
		headerMaps.put("Content-Type", "application/json");
		
		//creating the payLoad
		ObjectMapper objectMapper = new ObjectMapper();
		Users users = new Users("Dinesh", "Associate Software Engineer");
		String payloadString = objectMapper.writeValueAsString(users);
		System.out.println("PayLoad: " + payloadString);
		
		restClient = new RestClint();
		closableHttpResponse = restClient.post(url, payloadString, headerMaps);
		int statusCode = closableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(HTTP_STATUS_201, statusCode);
		
		String response = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");
		JSONObject jobject = new JSONObject(response);
		System.out.println("Response: " + jobject);
		
		/*Users responseUserObject = objectMapper.readValue(response, Users.class);
		System.out.println(responseUserObject);*/
	}
}
