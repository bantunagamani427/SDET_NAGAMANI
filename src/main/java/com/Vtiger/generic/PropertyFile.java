package com.Vtiger.generic;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyFile {

	private static PropertyFile prop;

	public  PropertyFile () {

	}

	public static PropertyFile getObjectPropfile() {
		return prop= new PropertyFile();
	}
//	public String readDatafromPropfile(String key) throws IOException {
//		FileInputStream fis = new FileInputStream("./vtiger.PROPERTIES");
//
//		Properties prop = new Properties();
//		prop.load(fis);
//
//		return	prop.getProperty(key);

	//}
	public String readDatafromPropfile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./vtiger.PROPERTIES");

		Properties prop = new Properties();
		prop.load(fis);

		return	prop.getProperty(key);
	}}


