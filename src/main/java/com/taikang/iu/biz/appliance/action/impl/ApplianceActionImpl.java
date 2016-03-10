package com.taikang.iu.biz.appliance.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.iu.biz.appliance.action.IApplianceAction;
import com.taikang.iu.biz.appliance.model.ApplianceBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.biz.appliance.service.IApplianceService;
import org.springframework.stereotype.Service;

/**
  * ApplianceAction
  */
  @Service(IApplianceAction.ACTION_ID)
public class ApplianceActionImpl extends BaseActionImpl 
  implements IApplianceAction {

    /**
      * 注入service
      */
    @Resource(name=IApplianceService.SERVICE_ID)
	private IApplianceService<ApplianceBO> applianceService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ApplianceAction--addAppliance======>");
		
		ApplianceBO applianceBO = BaseDto.toModel(ApplianceBO.class , param);
		applianceService.insertObject(applianceBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ApplianceAction--updateAppliance======>");
		
		ApplianceBO applianceBO = BaseDto.toModel(ApplianceBO.class , param);
		applianceService.updateObject(applianceBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ApplianceAction--deleteAppliance======>");
		
		ApplianceBO applianceBO = BaseDto.toModel(ApplianceBO.class , param);
		applianceService.deleteObject(applianceBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ApplianceAction--findOneAppliance======>");
		
		ApplianceBO applianceBO = BaseDto.toModel(ApplianceBO.class , param);
		return applianceService.findOne(applianceBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ApplianceAction--findAllAppliance======>");
				
		return applianceService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ApplianceAction--queryApplianceForPage======>");
		
		return applianceService.queryForPage(currentPage);
	}	
	
	/**
     * 分页查询数据查询用品需要审批的列表
     */
	public CurrentPage queryPriductForPage(CurrentPage currentPage){
		logger.debug("<======ApplianceAction--queryApplianceForPage======>");
		return applianceService.queryPriductForPage(currentPage);
	}
	
	/**
     * 分页查询数据查询用品查看的列表
     */
	public CurrentPage queryProductSeatForPage(CurrentPage currentPage){
		logger.debug("<======ApplianceAction--queryProductSeatForPage======>");
		return applianceService.queryProductSeatForPage(currentPage);
	}
}
