package com.taikang.iu.biz.appliance.service.impl;
 
import java.util.List;
import com.taikang.iu.biz.appliance.model.ApplianceBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.biz.appliance.service.IApplianceService;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * ApplianceServiceImpl
  */
 @Service(IApplianceService.SERVICE_ID)
 public class ApplianceServiceImpl extends BaseServiceImpl 
 implements IApplianceService<ApplianceBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(ApplianceBO appliance) {
		logger.debug("<======ApplianceServiceImpl--insertAppliance======>");		
		appDao.insert("Appliance.addAppliance",appliance);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(ApplianceBO appliance) {
		logger.debug("<======ApplianceServiceImpl--updateAppliance======>");
		appDao.update("Appliance.updateAppliance",appliance);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(ApplianceBO appliance) {
		logger.debug("<======ApplianceServiceImpl--deleteAppliance======>");
		appDao.delete("Appliance.deleteAppliance",appliance);
	}
	
	/**
      * 查询数据
      */
	public ApplianceBO findOne(ApplianceBO appliance) {
		logger.debug("<======ApplianceServiceImpl--findAppliance======>");
		
		ApplianceBO applianceBackBO=appDao.queryOneObject("Appliance.findOneAppliance", appliance);
		return applianceBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<ApplianceBO> findAll(ApplianceBO  appliance) {
		logger.debug("<======ApplianceServiceImpl--findAllAppliance======>");
		return appDao.queryForEntityList("Appliance.findAllAppliance", appliance);
	}
	
	
	 /**
      * 分页查询数据查询用品需要审批的列表
      */
	public CurrentPage queryPriductForPage(CurrentPage currentPage) {
		logger.debug("<======ApplianceServiceImpl--queryProductForPage======>");
		return appDao.queryForPage("Appliance.queryProductForPage", currentPage);
	}
	
	 /**
     * 分页查询数据
     */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======ApplianceServiceImpl--queryApplianceByConForPage======>");
		return appDao.queryForPage("Appliance.queryApplianceForPage", currentPage);
	}
	
	/**
     * 分页查询数据查询用品查看的列表
     */
	public CurrentPage queryProductSeatForPage(CurrentPage currentPage) {
		logger.debug("<======ApplianceServiceImpl--queryProductSeatForPage======>");
		return appDao.queryForPage("Appliance.queryProductSeatForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======ApplianceServiceImpl--findAllMapAppliance======>");		
		return appDao.queryForMapList("Appliance.findAllMapAppliance", param);
	}
 }
  