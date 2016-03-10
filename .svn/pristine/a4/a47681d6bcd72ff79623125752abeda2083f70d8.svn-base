package com.taikang.iu.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taikang.udp.framework.core.properties.PropertiesFile;
import com.taikang.udp.framework.core.properties.PropertiesHandler;
import com.taikang.udp.framework.core.properties.PropertiesHandlerFactory;

/**
 * 短信发送相关功能
 * @author t-wuke
 * @version [版本号，默认V1.0.0]
 * @Credited 2015年5月12日 
 */
public class SMSUtil {
	
	protected static PropertiesHandler initProperty = PropertiesHandlerFactory.getPropertiesHelper(PropertiesFile.FRAMEWORK);
	private static final Log log = LogFactory.getLog(SMSUtil.class);
	
	// 业务类型
	// 发送短信通知用户已注册
	public static final String BUSINESS_TYPE_TOABG = "TOABG";
	// 发送短信通知座席
	public static final String BUSINESS_TYPE_TOABH = "TOABH";
	// 发送短信通知天使
	public static final String BUSINESS_TYPE_TOABI = "TOABI";
	// 微信支付用品订单成功后，发送短信通知用品商
	public static final String BUSINESS_TYPE_TOABJ = "TOABJ";
	// POS支付服务订单成功后，发送短信通知给客户
	public static final String BUSINESS_TYPE_TOABK = "TOABK";
	// 运营人员为服务订单生成子订单后，短信通知商户
	public static final String BUSINESS_TYPE_TOABL = "TOABL";
	
	/**
     * 发送短消息
     * 
     * @param  phoneNo  		接收人的电话号码
     * @param  content  		发送的内容
     * @param  businessType  	业务类型
     * @return result 			所代表远程资源的响应结果
     */
	public static String sendSMS(String phoneNo, String content, String businessType){
		// GBK编码
		try {
			content = URLEncoder.encode(content,"GBK");
		} catch (UnsupportedEncodingException e) {

			log.info("**************SMSUtil.sendSMS.URLEncoder 出现错误**************************");
			e.printStackTrace();
		}
		
		// 获取资源文件中的短信发送的url
		String smsurl = initProperty.getValue("smsurl");
		
		// 参数设置
		smsurl = smsurl.replace("#phoneNo#", phoneNo).replace("#content#", content).replace("#businessType#", businessType);
		
		// 发送短消息
		String result = sendGet(smsurl);
		
		return result;
	}
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param 	urlSMS    		发送请求的URL
     * @return 	result 		所代表远程资源的响应结果
     */
	private static String sendGet(String urlSMS) {
		HttpURLConnection connect = null;
		BufferedReader br = null;
		
		try {
//			String smsUrl = urlt + "?" + param;
			log.info(urlSMS);

			URL url = new URL(urlSMS);
			connect = (HttpURLConnection) url.openConnection();
			connect.setRequestProperty("Content-Type", "text/xml; charset=GB");
			connect.setConnectTimeout(60000);
			connect.setReadTimeout(60000);
			connect.connect();
			
			br = new BufferedReader(new InputStreamReader(connect.getInputStream(),"GBK"));
			String line = br.readLine();
			return line;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connect != null){
				connect.disconnect();	
			}
		}
		return "UNKNOW";
	}
	
    public static void main(String[] args) {

    }
}
