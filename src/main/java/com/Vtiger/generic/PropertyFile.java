package com.Vtiger.generic;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyFile {
public String fetchpro(String keys) throws IOException {
FileInputStream fis=new FileInputStream("../SDET7_NAGA/src/test/java/com/VTiger/TCs/data.PROPERTIES");
Properties pobj=new Properties();
pobj.load(fis);
String data=pobj.getProperty(keys);
return data;
}
}
