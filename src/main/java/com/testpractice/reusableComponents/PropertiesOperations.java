package com.testpractice.reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {
	
	static Properties prop = new Properties();
	
	public static String getProperties(String key) {
		String path = System.getProperty("user.dir")+"/config.properties";
		String value = null;
		
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			value = prop.getProperty(key);
			if(value.isEmpty()) {
				throw new Exception("Property is Empty for key" + key);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}

}
