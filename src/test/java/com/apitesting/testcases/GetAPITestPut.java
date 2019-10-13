package com.apitesting.testcases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.httpmethods.RestClint;

public class GetAPITestPut extends TestBase{
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
	public void getHttpPut() {
		
	}
}
