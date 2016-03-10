package com.taikang.iu.opt.operation.service.impl;
 
import com.taikang.iu.opt.operation.service.IoperationService;
import java.util.List;
import com.taikang.iu.opt.operation.model.operationBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * operationServiceImpl
  */
 @Service(IoperationService.SERVICE_ID)
 public class operationServiceImpl extends BaseServiceImpl 
 implements IoperationService<operationBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(operationBO operation) {
		logger.debug("<======operationServiceImpl--insertoperation======>");		
		appDao.insert("operation.addoperation",operation);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(operationBO operation) {
		logger.debug("<======operationServiceImpl--updateoperation======>");
		appDao.update("operation.updateoperation",operation);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(operationBO operation) {
		logger.debug("<======operationServiceImpl--deleteoperation======>");
		appDao.delete("operation.deleteoperation",operation);
	}
	
	/**
      * 查询数据
      */
	public operationBO findOne(operationBO operation) {
		logger.debug("<======operationServiceImpl--findoperation======>");
		
		operationBO operationBackBO=appDao.queryOneObject("operation.findOneoperation", operation);
		return operationBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<operationBO> findAll(operationBO  operation) {
		logger.debug("<======operationServiceImpl--findAlloperation======>");
		return appDao.queryForEntityList("operation.findAlloperation", operation);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======operationServiceImpl--queryoperationForPage======>");
		//return appDao.queryForPage("operation.queryoperationForPage", currentPage);
		return appDao.queryForPage("operation.queryComplainByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======operationServiceImpl--findAllMapoperation======>");		
		return appDao.queryForMapList("operation.findAllMapoperation", param);
	}
 }
  