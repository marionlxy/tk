package com.taikang.iu.job.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.iu.job.service.IMainJob;
import com.taikang.iu.job.service.IOrderJob;
import com.taikang.iu.job.service.IRegoodsJob;
import com.taikang.iu.job.service.ISystemJob;
import com.taikang.udp.framework.core.web.BaseController;

@Service(IMainJob.SERVICE_ID)
@Transactional
public class MainJob extends BaseController{
	
	@Resource(name=IOrderJob.SERVICE_ID)
	private IOrderJob orderJob;
	
	@Resource(name=ISystemJob.SERVICE_ID)
	private ISystemJob systemJob;
	@Resource(name=IRegoodsJob.SERVICE_ID)
	private IRegoodsJob regoodsJob;
	public void startMainJob() {
		// 系统管理
//		systemJob.freshCurrent();
		// 订单
//	    orderJob.confrimAppSign();
		// 退货单
//		regoodsJob.confrimReGoods();
	}
}
