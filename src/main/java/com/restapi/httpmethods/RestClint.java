package com.restapi.httpmethods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClint {
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		// Creating the connection with http client
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// Creating http get method
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse closableHttpResponse = httpClient.execute(httpGet);

		return closableHttpResponse;

	}

	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		// Creating the connection with http client
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// Creating http get method
		HttpGet httpGet = new HttpGet(url);

		// Adding the headers to the url
		for (Map.Entry<String, String> header : headerMap.entrySet()) {
			httpGet.addHeader(header.getKey(), header.getValue());
		}
		CloseableHttpResponse closableHttpResponse = httpClient.execute(httpGet);
		return closableHttpResponse;

	}
}
