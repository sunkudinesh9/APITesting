package com.restapi.base;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	public Properties properties;

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
