package com.taikang.iu.biz.appliancesku.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.iu.biz.appliancesku.service.IApplianceskuService;
import javax.annotation.Resource;
import com.taikang.iu.biz.appliancesku.model.ApplianceskuBO;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.iu.biz.appliancesku.action.IApplianceskuAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * ApplianceskuAction
  */
  @Service(IApplianceskuAction.ACTION_ID)
public class ApplianceskuActionImpl extends BaseActionImpl 
  implements IApplianceskuAction {

    /**
      * 注入service
      */
    @Resource(name=IApplianceskuService.SERVICE_ID)
	private IApplianceskuService<ApplianceskuBO> applianceskuService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ApplianceskuAction--addAppliancesku======>");
		
		ApplianceskuBO applianceskuBO = BaseDto.toModel(ApplianceskuBO.class , param);
		applianceskuService.insertObject(applianceskuBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ApplianceskuAction--updateAppliancesku======>");
		
		ApplianceskuBO applianceskuBO = BaseDto.toModel(ApplianceskuBO.class , param);
		applianceskuService.updateObject(applianceskuBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ApplianceskuAction--deleteAppliancesku======>");
		
		ApplianceskuBO applianceskuBO = BaseDto.toModel(ApplianceskuBO.class , param);
		applianceskuService.deleteObject(applianceskuBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ApplianceskuAction--findOneAppliancesku======>");
		
		ApplianceskuBO applianceskuBO = BaseDto.toModel(ApplianceskuBO.class , param);
		return applianceskuService.findOne(applianceskuBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ApplianceskuAction--findAllAppliancesku======>");
				
		return applianceskuService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ApplianceskuAction--queryApplianceskuForPage======>");
		
		return applianceskuService.queryForPage(currentPage);
	}	
	
	 /**
     * 分页查询数据(ApplianceId为空的)
     */
	public CurrentPage findAllNull(CurrentPage currentPage){
		logger.debug("<======ApplianceskuServiceImpl--queryApplianceIdnull======>");
		
		return applianceskuService.findAllNull(currentPage);
	}
}
