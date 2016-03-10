package com.taikang.iu.opt.appraise.action.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.appraise.action.IAppraiseAction;
import com.taikang.iu.opt.appraise.model.AppraiseBO;
import com.taikang.iu.opt.appraise.service.IAppraiseService;
import com.taikang.iu.opt.order.model.OrderSevBO;
import com.taikang.iu.opt.order.model.OrderSubBO;
import com.taikang.iu.opt.order.service.IOrderSevService;
import com.taikang.iu.opt.order.service.IOrderSubService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * AppraiseAction
  */
  @Service(IAppraiseAction.ACTION_ID)
public class AppraiseActionImpl extends BaseActionImpl 
  implements IAppraiseAction {
	   /**
	      * orderSub注入service
	      */
	    @Resource(name=IOrderSubService.SERVICE_ID)
		private IOrderSubService<OrderSubBO> orderSubService;
    /**
      * 注入service
      */
    @Resource(name=IAppraiseService.SERVICE_ID)
	private IAppraiseService<AppraiseBO> appraiseService;	
    /**
     * 注入服务service
     */
    @Resource(name=IOrderSevService.SERVICE_ID)
   	private IOrderSevService<OrderSevBO> orderSevService;	
	/**
	  * 增加数据
	  */
    
	public void insertObject(Dto param) {
		logger.debug("<======AppraiseAction--addAppraise======>");
		
		AppraiseBO appraiseBO = BaseDto.toModel(AppraiseBO.class , param);
		appraiseService.insertObject(appraiseBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======AppraiseAction--updateAppraise======>");
		
		AppraiseBO appraiseBO = BaseDto.toModel(AppraiseBO.class , param);
		appraiseService.updateObject(appraiseBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======AppraiseAction--deleteAppraise======>");
		
		AppraiseBO appraiseBO = BaseDto.toModel(AppraiseBO.class , param);
		appraiseService.deleteObject(appraiseBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======AppraiseAction--findOneAppraise======>");
		
		AppraiseBO appraiseBO = BaseDto.toModel(AppraiseBO.class , param);
		return appraiseService.findOne(appraiseBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======AppraiseAction--findAllAppraise======>");
				
		return appraiseService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======AppraiseAction--queryAppraiseForPage======>");
		
		return appraiseService.queryForPage(currentPage);
	}

	public List<AppraiseBO> findUniquedAppraise(AppraiseBO appraise) {
		 return appraiseService.findUniquedAppraise(appraise);
		
		
	}

	@SuppressWarnings("unchecked")
	public void updateAppraiseAndOrderStatus(Dto param, String orderSevId,
			String subId) {
		AppraiseBO appraiseBO = BaseDto.toModel(AppraiseBO.class , param);
		appraiseService.insertObject(appraiseBO);//保存评价状态
		Dto  sevDto = new BaseDto();
		sevDto.put("appraiseState",1);
		sevDto.put("orderSevId",param.get("orderSevId"));
		OrderSevBO orderSevBO = BaseDto.toModel(OrderSevBO.class , sevDto);
		orderSevService.updateObject(orderSevBO);//修改服务评价状态
		Dto sub = new BaseDto();
		sub.put("subId", subId);
		List<Dto> sev = orderSevService.findSubOrderIsBysubId(sub);
		List subSev = new ArrayList();
		for(int i= 0; i <sev.size();i++){
			if(!sev.get(i).getAsString("APPRAISE_STATE").equals("1")){
				subSev.add(sev.get(i).getAsString("APPRAISE_STATE"));
			}
		}
		if(subSev.size() <= 0){
			Dto subOrder = new BaseDto();
			subOrder.put("appraiseState", 1);
			subOrder.put("subId", subId);
			OrderSubBO orderSubBO = BaseDto.toModel(OrderSubBO.class , subOrder);
			orderSubService.updateObject(orderSubBO);
		}
	}

	public Dto findOneApp(Dto param) {
		return appraiseService.findOneApp(param);
	}	
	
}
