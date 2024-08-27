package com.MyStoreUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiig {

// We have created an utility package to store all the generic functions ..
// This class  is created for read the config.properties class ..
// In java there is a class to read properties file so ll create class object of that to read the file.
	Properties properties;
// created the Path for read the config file 	
	String path = "C://Users//ankit//eclipse-workspace//MyStoreV1//Configuration//config.properties";

// Constructor ..	
	public ReadConfiig() {
// Initialize the properties object. 	
		try {
			properties = new Properties();
//For read the properties file bytes created FileInputStream class object
			FileInputStream file = new FileInputStream(path);
// Now have to load the file 		
			properties.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

// Created the method to read the keys vales of the config file ..	
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl"); // this will return the String vale ..

		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");

	}

	public String getBrowser() {
		String value = properties.getProperty("browser");
		if (value != null)
			return value;
		else
			throw new RuntimeException("browser is not specified in congif file");
	}
	
	public String getEmail() {
		
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
	}
	
	public String getPassword() {
		
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
	
	}
	
}
	
	
	
	


