package com.restapi.httpmethods;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClint {
	public void get(String url) throws ClientProtocolException, IOException {
		// Creating the connection with http client
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// Creating http get method
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closableHttpClient = httpClient.execute(httpGet);

		// Getting status code
		int status = closableHttpClient.getStatusLine().getStatusCode();
		System.out.println("Status code ---> :" + status);

		// Getting Json String from http response
		String stringResponse = EntityUtils.toString(closableHttpClient.getEntity(), "UTF-8");

		// Converting String to json object
		JSONObject jsonObject = new JSONObject(stringResponse);
		System.out.println("JsonResponse-----> :" + jsonObject);

		// Getting the headers
		Header[] allHeaders = closableHttpClient.getAllHeaders();

		HashMap<String, String> headerMap = new HashMap<String, String>();

		// Converting from the name value to key Value pairs
		for (Header header : allHeaders) {
			headerMap.put(header.getName(), header.getValue());
		}
		System.out.println(headerMap);

	}
}
