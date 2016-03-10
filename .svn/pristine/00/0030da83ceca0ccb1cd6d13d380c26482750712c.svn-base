package com.taikang.iu.opt.business.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.iu.opt.business.action.IBusinessAction;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.iu.opt.business.model.BusinessBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.business.service.IBusinessService;

/**
  * BusinessAction
  */
  @Service(IBusinessAction.ACTION_ID)
public class BusinessActionImpl extends BaseActionImpl 
  implements IBusinessAction {

    /**
      * 注入service
      */
    @Resource(name=IBusinessService.SERVICE_ID)
	private IBusinessService<BusinessBO> businessService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======BusinessAction--addBusiness======>");
		
		BusinessBO businessBO = BaseDto.toModel(BusinessBO.class , param);
		businessService.insertObject(businessBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======BusinessAction--updateBusiness======>");
		
		BusinessBO businessBO = BaseDto.toModel(BusinessBO.class , param);
		businessService.updateObject(businessBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======BusinessAction--deleteBusiness======>");
		
		BusinessBO businessBO = BaseDto.toModel(BusinessBO.class , param);
		businessService.deleteObject(businessBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======BusinessAction--findOneBusiness======>");
		
		BusinessBO businessBO = BaseDto.toModel(BusinessBO.class , param);
		return businessService.findOne(businessBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======BusinessAction--findAllBusiness======>");
				
		return businessService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======BusinessAction--queryBusinessForPage======>");
		
		return businessService.queryForPage(currentPage);
	}	
}
