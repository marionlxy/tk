package com.taikang.iu.opt.custom.service.impl;
 
import com.taikang.iu.opt.custom.model.CustomBO;
import com.taikang.iu.opt.custom.service.ICustomService;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * CustomServiceImpl
  */
 @Service(ICustomService.SERVICE_ID)
 public class CustomServiceImpl extends BaseServiceImpl 
 implements ICustomService<CustomBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(CustomBO custom) {
		logger.debug("<======CustomServiceImpl--insertCustom======>");		
		appDao.insert("Custom.addCustom",custom);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(CustomBO custom) {
		logger.debug("<======CustomServiceImpl--updateCustom======>");
		appDao.update("Custom.updateCustom",custom);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(CustomBO custom) {
		logger.debug("<======CustomServiceImpl--deleteCustom======>");
		appDao.delete("Custom.deleteCustom",custom);
	}
	
	/**
      * 查询数据
      */
	public CustomBO findOne(CustomBO custom) {
		logger.debug("<======CustomServiceImpl--findCustom======>");
		
		CustomBO customBackBO=appDao.queryOneObject("Custom.findOneCustom", custom);
		return customBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<CustomBO> findAll(CustomBO  custom) {
		logger.debug("<======CustomServiceImpl--findAllCustom======>");
		return appDao.queryForEntityList("Custom.findAllCustom", custom);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======CustomServiceImpl--queryCustomForPage======>");
		return appDao.queryForPage("Custom.queryCustomForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======CustomServiceImpl--findAllMapCustom======>");		
		return appDao.queryForMapList("Custom.findAllMapCustom", param);
	}

	public void insertCustom(CustomBO custom) {
		logger.debug("<======CustomServiceImpl--insertCustom======>");		
		appDao.insert("Custom.addCustom",custom);		
	}
 }
  