package com.restapi.httpmethods;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClint {
	CloseableHttpResponse closableHttpResponse;

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		// Creating the connection with http client
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// Creating http get method
		HttpGet httpGet = new HttpGet(url);
		closableHttpResponse = httpClient.execute(httpGet);

		return closableHttpResponse;

	}

	public CloseableHttpResponse get(String url, Map<String, String> headerMaps)
			throws ClientProtocolException, IOException {
		// Creating the connection with http client
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// Creating http get method
		HttpGet httpGet = new HttpGet(url);

		// Adding the headers to the url
		for (Map.Entry<String, String> header : headerMaps.entrySet()) {
			httpGet.addHeader(header.getKey(), header.getValue());
		}
		closableHttpResponse = httpClient.execute(httpGet);
		return closableHttpResponse;

	}

	public CloseableHttpResponse post(String url, String entity, Map<String, String> headerMaps)
			throws ClientProtocolException, IOException {
		CloseableHttpClient closableHttpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(entity));

		// Adding the headers to the url
		for (Map.Entry<String, String> header : headerMaps.entrySet()) {
			httpPost.addHeader(header.getKey(), header.getValue());
		}
		closableHttpResponse = closableHttpClient.execute(httpPost);
		return closableHttpResponse;
	}
}
