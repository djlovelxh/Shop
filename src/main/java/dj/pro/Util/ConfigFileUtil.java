package dj.pro.Util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 管理配置文件工具类
 * 用于生产环境和开发环境的切换
 * @author czf
 * 2017年8月31日
 * 类说明：
 */
public class ConfigFileUtil {
	private static String suffix = "";
	
	/**
	 * 探针，到外围的配置文件指定的key取配置文件后辍名
	 * @param key
	 */
	public static void probe(String propertiesFilePath,String key){
		Properties pro = new Properties();
		try {
			pro.load(ConfigFileUtil.class.getClassLoader().getResourceAsStream(propertiesFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = pro.getProperty(key);
		if(value != null && !"".equals(value.trim())){
			suffix = "-" + value;
		}
	}

	public static String getSuffix(){
		//如果suffix为空时，则从配置文件获取活动的后辍文件名，自动注入
		if(suffix == null || "".equals(suffix.trim())){
			String active = getVal("active-suffix");
			
			if(active != null && !"".equals(active.trim())){
				setSuffix(active);
			}
		}
		return suffix;
	}
	
	/**
	 * 设置文件后辍
	 * @param suffixx
	 */
	public static void setSuffix(String suffixx){
		if(suffixx != null && !"".equals(suffixx.trim())){
			suffix = "-" + suffixx;
		}
	}
	
	/**
	 * 读取默认配置文件
	 * @param key
	 * @return
	 */
	private static String getVal(String key){
		try {
			Properties pro = new Properties();
			pro.load(new InputStreamReader(ConfigFileUtil.class.getClassLoader().getResourceAsStream("config/config.properties"),"UTF-8"));
			return (String) pro.get(key);
		} catch (IOException e) {
			return null;
		}
	}

}
