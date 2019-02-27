package dj.pro.Util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


/**
 * log4j辅助类，主要用途是进行多配置文件切换
 * @author czf
 * 2017年9月13日
 * 类说明：
 */
public class Log4jHelper {
	private static boolean isInit = false;
	
	public static Logger getLogger(Class clazz){
		
		if(!isInit){
			//获取配置后辍
			String active = getVal("log4j-active-suffix");
			
			if(active != null && !"".equals(active.trim())){
				if(active != null && !"".equals(active.trim())){
					active = "-" + active;
				}
			}else{
				active = "";
			}
			
			String customizedPath = "config/log/log4j" + active + ".xml";
			System.out.println("@@@@@@@@@@@@@@ ==== log4j配置文件路径：" + customizedPath + " ==== @@@@@@@@@@@");
			System.setProperty("log4j.configuration", customizedPath);
			isInit = true;
		}
		Logger log = Logger.getLogger(clazz);
		
		return log;
	}
	
	private static String getVal(String key){
		try {
			Properties pro = new Properties();
			pro.load(new InputStreamReader(Log4jHelper.class.getClassLoader().getResourceAsStream("config/config.properties"),"UTF-8"));
			return (String) pro.get(key);
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * 此方法用于手动配置后辍名，但已经过时
	 * @param suffix
	 */
	@Deprecated
	public static void setConfigFileSuffixAndInit(String suffix){
		if(suffix == null || "".equals(suffix)){
			suffix = "";
		}else{
			suffix = "-" + suffix;
		}
		String customizedPath = "config/log/log4j" + suffix + ".xml";
		System.out.println("@@@@@@@@@@@@@@ ==== log4j配置文件路径：" + customizedPath + " ==== @@@@@@@@@@@");
		System.setProperty("log4j.configuration", customizedPath);
		isInit = true;
	}
}
