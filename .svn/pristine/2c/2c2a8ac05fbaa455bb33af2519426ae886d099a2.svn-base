package com.taikang.iu.opt.business.service.impl;
 
import java.util.List;
import com.taikang.iu.opt.business.model.BusinessBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.business.service.IBusinessService;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * BusinessServiceImpl
  */
 @Service(IBusinessService.SERVICE_ID)
 public class BusinessServiceImpl extends BaseServiceImpl 
 implements IBusinessService<BusinessBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(BusinessBO business) {
		logger.debug("<======BusinessServiceImpl--insertBusiness======>");		
		appDao.insert("Business.addBusiness",business);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(BusinessBO business) {
		logger.debug("<======BusinessServiceImpl--updateBusiness======>");
		appDao.update("Business.updateBusiness",business);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(BusinessBO business) {
		logger.debug("<======BusinessServiceImpl--deleteBusiness======>");
		appDao.delete("Business.deleteBusiness",business);
	}
	
	/**
      * 查询数据
      */
	public BusinessBO findOne(BusinessBO business) {
		logger.debug("<======BusinessServiceImpl--findBusiness======>");
		
		BusinessBO businessBackBO=appDao.queryOneObject("Business.findOneBusiness", business);
		return businessBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<BusinessBO> findAll(BusinessBO  business) {
		logger.debug("<======BusinessServiceImpl--findAllBusiness======>");
		return appDao.queryForEntityList("Business.findAllBusiness", business);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======BusinessServiceImpl--queryBusinessForPage======>");
		return appDao.queryForPage("Business.queryBusinessForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======BusinessServiceImpl--findAllMapBusiness======>");		
		return appDao.queryForMapList("Business.findAllMapBusiness", param);
	}
 }
  