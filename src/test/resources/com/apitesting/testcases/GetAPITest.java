package com.apitesting.testcases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.httpmethods.RestClint;

public class GetAPITest extends TestBase {
	public TestBase testBase;
	String mainUrl;
	String serviceUrl;
	String url;
	RestClint restClient;

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		// Getting the urls from the propertie file
		mainUrl = properties.getProperty("url");
		serviceUrl = properties.getProperty("serviceURL");
		url = mainUrl + serviceUrl;

	}

	@Test
	public void getApiTest() throws ClientProtocolException, IOException {
		// sending the get request
		restClient = new RestClint();
		restClient.get(url);
	}
}
