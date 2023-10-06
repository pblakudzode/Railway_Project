package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	public String getvalueFromOr(String filePath, String key) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.err.print("File not Found " + filePath);
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.err.print("The File is Unable to load " + filePath);
		}
		return prop.getProperty(key);		
	}
	/**
	 * This method can be used to on OR.properties file only 
	 * @param key for which we want to read locators
	 * @return the locators value in form of {@code String}
	 **/
	public String getObjectFromRepo(String key) {
		
		String baseDir= System.getProperty("user.dir");//Current Working Directory
		return getvalueFromOr(baseDir+"\\src\\main\\resources\\OR.properties",key);
	}
	/**
	 * This method can be used to on Credentials.properties file only 
	 * @param key for which we want to read locators
	 * @return the locators value in form of {@code String}
	 **/
	public String getUserAndPassword(String key) {
		String baseDir=System.getProperty("user.dir");	
		return getvalueFromOr(baseDir+"\\src\\main\\resources\\Credentials.Properties", key);	
	}
}