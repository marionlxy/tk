package com.taikang.iu.job.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.job.service.IRegoodsJob;
import com.taikang.iu.opt.regoods.action.IRegoodsAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.web.BaseController;


@Service(IRegoodsJob.SERVICE_ID)
public class RegoodsJob extends BaseController implements  IRegoodsJob{
	@Resource(name=IRegoodsAction.ACTION_ID)
	private IRegoodsAction regoodsAction;
	
	
	public void confrimReGoods() {

		Dto job = new BaseDto();
		List<Dto> regoodsJobs =	regoodsAction.findAllRegoods(job);
		for (int i = 0; i < regoodsJobs.size(); i++) {
			
			if(regoodsJobs.get(i).get("RETURN_STATE").equals("0") && regoodsJobs.get(i).get("APPLY_TIME") != null){//客户申请后48小时不响应，系统自动通知客户发货
				boolean dateFlag = dateCompare(dateCtrlInfo(regoodsJobs.get(i).get("APPLY_TIME").toString().substring(0, regoodsJobs.get(i).get("APPLY_TIME").toString().length()-2),2));
				if(dateFlag == true){
					regoodsAction.updateFixedTimeRe(regoodsJobs.get(i));
				}
			}else if(regoodsJobs.get(i).get("RETURN_STATE").equals("1") && regoodsJobs.get(i).get("AUDIT_TIME") != null){//客户在审核通过后，30天内没有填写发货信息 取消退货
				boolean dateFlag = dateCompare(dateCtrlInfo(regoodsJobs.get(i).get("AUDIT_TIME").toString().substring(0, regoodsJobs.get(i).get("AUDIT_TIME").toString().length()-2),30));
				if(dateFlag == true){
					regoodsAction.updateFixedTimeRe(regoodsJobs.get(i));
				}
			}else if(regoodsJobs.get(i).get("RETURN_STATE").equals("3") && regoodsJobs.get(i).get("SEND_TIME") != null){//在退货单成为待收货状态起10天内，如果商户没有确认收获，系统自动生成退款确认
				boolean dateFlag = dateCompare(dateCtrlInfo(regoodsJobs.get(i).get("SEND_TIME").toString().substring(0, regoodsJobs.get(i).get("SEND_TIME").toString().length()-2),10));
				if(dateFlag == true){
					regoodsAction.updateFixedTimeRe(regoodsJobs.get(i));
				}
			}
		}
		
	
	}
	
	/**
	 * 时间格式转换
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
		Long nDay =(tmpDate.getTime()/(24*60*60*1000)+1+(n-2))*(24*60*60*1000);
		tmpDate.setTime(nDay);
		return df.format(tmpDate);
	}
	
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
