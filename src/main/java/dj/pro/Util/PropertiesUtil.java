package dj.pro.Util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties pro = new Properties();
	
	static{
		try {
			pro.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getVal(String key){
		return pro.getProperty(key);
	}
	

}
