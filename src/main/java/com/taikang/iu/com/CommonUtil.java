package com.taikang.iu.com;

import java.io.InputStream;
import java.util.logging.Logger;

import com.taikang.udp.framework.core.properties.PropertiesFile;
import com.taikang.udp.framework.core.properties.PropertiesHandler;
import com.taikang.udp.framework.core.properties.PropertiesHandlerFactory;

/**
 * 工具类
 * @author t-wuke
 * @version [版本号，默认V1.0.0]
 * @Credited 2015年4月17日 下午5:43:48
 */
public class CommonUtil {
	
	protected static PropertiesHandler initProperty = PropertiesHandlerFactory.getPropertiesHelper(PropertiesFile.FRAMEWORK);
	
	public static String RELATION_UPLOAD_FILEPATH = initProperty.getValue("relation_upload_filepath");
    
	public static String uploadFilePath(){
		String defaultFilePath = "";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = PropertiesHandlerFactory.class.getClassLoader();
		}
		// 加载属性文件global.eredbos.properties
		try {
			InputStream is = classLoader.getResourceAsStream("META-INF/app_config/properties/init.config.properties");
			if(is!=null){
				PropertiesHandler ph = new PropertiesHandler(is);
				defaultFilePath = ph.getValue("default_upload_filepath");
			}			
		} catch (Exception e1) {
		}
		return defaultFilePath;
	}
}