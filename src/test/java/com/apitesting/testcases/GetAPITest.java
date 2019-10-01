package com.apitesting.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.httpmethods.RestClint;
import com.restapi.utils.TestUtils;

public class GetAPITest extends TestBase {
	public TestBase testBase;
	String mainUrl;
	String serviceUrl;
	String url;
	RestClint restClient;
	CloseableHttpResponse closableHttpResponse;
	HashMap<String, String> headerMap;

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		// Getting the urls from the propertie file
		mainUrl = properties.getProperty("url");
		serviceUrl = properties.getProperty("serviceURL");
		url = mainUrl + serviceUrl;

	}

	@Test(priority = 1)
	public void getApiTestWithOutHeaders() throws ClientProtocolException, IOException {
		// sending the get request
		restClient = new RestClint();
		closableHttpResponse = restClient.get(url);

		// Getting status code
		int status = closableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(status, TestBase.HTTP_STATUS_200);

		// Getting Json String from http response
		String stringResponse = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");

		// Converting String to json object
		JSONObject jsonObject = new JSONObject(stringResponse);
		System.out.println("JsonResponse-----> :" + jsonObject);
		String page = TestUtils.getVAlueByJpath(jsonObject, "/per_page");
		System.out.println("Page: " + page);

		// Getting the headers
		Header[] allHeaders = closableHttpResponse.getAllHeaders();

		HashMap<String, String> headerMap = new HashMap<String, String>();

		// Converting from the name value to key Value pairs
		for (Header header : allHeaders) {
			headerMap.put(header.getName(), header.getValue());
		}
	}

	@Test(priority = 2)
	public void getApiTestWithHeader() throws ClientProtocolException, IOException {
		// sending the get request
		restClient = new RestClint();

		// Adding Headers to hash map
		Map<String, String> headerMaps = new HashMap<String, String>();
		headerMaps.put("Content-Type", "application/json");
		closableHttpResponse = restClient.get(url, headerMaps);

		// Getting status code
		int status = closableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(status, TestBase.HTTP_STATUS_200);

		// Getting Json String from http response
		String stringResponse = EntityUtils.toString(closableHttpResponse.getEntity(), "UTF-8");

		// Converting String to json object
		JSONObject jsonObject = new JSONObject(stringResponse);
		System.out.println("JsonResponse-----> :" + jsonObject);

		// Getting the headers
		Header[] allHeaders = closableHttpResponse.getAllHeaders();

		HashMap<String, String> headerMap = new HashMap<String, String>();

		// Converting from the name value to key Value pairs
		for (Header header : allHeaders) {
			headerMap.put(header.getName(), header.getValue());
		}
	}
}
