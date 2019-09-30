package com.restapi.base;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	public Properties properties;
	public static final int HTTP_STATUS_200 = 200;
	public static final int HTTP_STATUS_201 = 201;
	public static final int HTTP_STATUS_400 = 400;
	public static final int HTTP_STATUS_401 = 401;
	

	public TestBase() {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
