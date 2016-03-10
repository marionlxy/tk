package com.taikang.iu.job.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.job.service.IOrderJob;
import com.taikang.iu.opt.order.action.IOrderAction;
import com.taikang.iu.opt.order.action.IOrderAppAction;
import com.taikang.iu.opt.order.action.IOrderSevAction;
import com.taikang.iu.opt.order.action.IOrderSubAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.web.BaseController;

@Service(IOrderJob.SERVICE_ID)
public class OrderJob extends BaseController implements IOrderJob{
	/**
	 * 注入订单action
	 */
	@Resource(name=IOrderAction.ACTION_ID)
	private IOrderAction orderAction;
	/**
	 * 注入用品action
	 */
	@Resource(name=IOrderAppAction.ACTION_ID)
	private IOrderAppAction orderAppAction;
	/**
	 * 注入服务的action
	 */
	
	@Resource(name=IOrderSubAction.ACTION_ID)
	private IOrderSubAction orderSubAction;
	/**
	 * 注入子订单action
	 */
	@Resource(name=IOrderSevAction.ACTION_ID)
	private IOrderSevAction orderSevAction;
	/**
	 * 自动确认用品
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 上午10:27:09
	 * @return
	 */
	public void confrimAppSign(){
		//IOrderAction iorderAction = ApplicationContext.getBean("orderAction");
		Dto param = new BaseDto();
		List<Dto> orderAppList = orderAction.findOrderIsTypeSD(param);//获得主订单 的用品
	//	List<Dto> subOrderAppList = orderSubAction.findSubOrderIsTypeST(param);//获得子订单的用品
		for(int i = 0 ; i < orderAppList.size(); i++){
			if(orderAppList.get(i).get("SEND_TIME") != null){//获得发货的时间
			//判断确认后七天的时间时候大于发货的时间  
			boolean dateFlag = dateCompare(dateCtrlInfo(orderAppList.get(i).get("SEND_TIME").toString().substring(0,orderAppList.get(i).get("SEND_TIME").toString().length()-2),7));
			if(dateFlag == true){
				orderAction.updateFixedTimeApp(orderAppList.get(i));
			}
			}
		} 
//		for(Dto subApp:subOrderAppList){
//			boolean dateFlag = dateCompare(dateCtrlInfo((String)subApp.get("SEND_TIME"),7),(String)subApp.get("SEND_TIME"));
//			if(dateFlag == true){
//				orderSubAction.updateFixedTimeSubApp(subApp);
//			}
//			}
	}
//	/**
//	 * 自动确认服务
//	 * @author t-zhaohan
//	 * @Credited 2015年4月21日 上午10:27:34
//	 * @return
//	 */
//	public void confirmSevsin(){
//		Dto param = new BaseDto();
//	List<Dto> subOrderSevList = orderSubAction.findSubOrderIsTypeFT(param);//获得子订单的服务
//	 for(Dto orderSev:subOrderSevList){
//		 boolean fgdate = dateCompare(dateCtrlInfo((String)orderSev.get("SEND_TIME"),7),(String)orderSev.get("SEND_TIME"));
//		 if(fgdate == true){//不确定时间
//		 }
//	   }
//    }
	/**
	 * 时间格式转换
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 上午10:39:43
	 * @return
	 */
	public String dateCtrlInfo(String baseDate,int n){
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tmpDate = null;
		try{
			tmpDate = df.parse(baseDate);
		}catch(Exception e){
			e.getStackTrace();
			//时间类型字符串报错
		}
		Long nDay =(tmpDate.getTime()/(24*60*60*1000)+1+(n-1))*(24*60*60*1000);
		tmpDate.setTime(nDay);
		return df.format(tmpDate);
	}
	/**
	 * 字符串时间类型比较
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 上午11:06:29
	 * @return
	 */
	public boolean dateCompare(String beforDate){
		boolean flag= false;
		SimpleDateFormat df =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			Date bDate = df.parse(beforDate);//获得7天的时间
			Date josDate = new Date();
		    boolean fg= josDate.after(bDate);//当前时间
			if(fg == true){
				flag = fg;
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return flag;
	}

}
