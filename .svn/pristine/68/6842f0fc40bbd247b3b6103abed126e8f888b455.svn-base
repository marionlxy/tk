package com.taikang.iu.opt.cemetery.service.impl;
 
import java.util.List;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.opt.cemetery.service.ICemeteryTypeService;
import com.taikang.iu.opt.cemetery.model.CemeteryParkBO;
import com.taikang.iu.opt.cemetery.model.CemeteryTypeBO;

import org.springframework.stereotype.Service;

import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * CemeteryTypeServiceImpl
  */
 @Service(ICemeteryTypeService.SERVICE_ID)
 public class CemeteryTypeServiceImpl extends BaseServiceImpl 
 implements ICemeteryTypeService<CemeteryTypeBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--insertCemeteryType======>");		
		appDao.insert("CemeteryType.addCemeteryType",cemeteryType);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--updateCemeteryType======>");
		appDao.update("CemeteryType.updateCemeteryType",cemeteryType);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--deleteCemeteryType======>");
		appDao.delete("CemeteryType.deleteCemeteryType",cemeteryType);
	}
	
	/**
     * 根据墓园Id删除墓型（逻辑删除）
     */
	public void deleteCemeteryTypeByC(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--deleteCemeteryType======>");
		appDao.update("CemeteryType.deleteCemeteryTypeByC",cemeteryType);
	}
	
	/**
     * 根据园区Id删除墓型（逻辑删除）
     */
	public void deleteCemeteryTypeByCP(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--deleteCemeteryTypeByCP======>");
		appDao.update("CemeteryType.deleteCemeteryTypeByCP",cemeteryType);
	}
	
	/**
      * 查询数据
      */
	public CemeteryTypeBO findOne(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--findCemeteryType======>");
		
		CemeteryTypeBO cemeteryTypeBackBO=appDao.queryOneObject("CemeteryType.findOneCemeteryType", cemeteryType);
		return cemeteryTypeBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<CemeteryTypeBO> findAll(CemeteryTypeBO  cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--findAllCemeteryType======>");
		return appDao.queryForEntityList("CemeteryType.findAllCemeteryType", cemeteryType);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======CemeteryTypeServiceImpl--queryCemeteryTypeForPage======>");
		return appDao.queryForPage("CemeteryType.queryCemeteryTypeForPage", currentPage);
	}
	
	 /**
     * 分页查询墓型列表
     */
	public CurrentPage allCemeteryTypeList(CurrentPage currentPage) {
		logger.debug("<======CemeteryTypeServiceImpl--allCemeteryTypeList======>");
		return appDao.queryForPage("CemeteryType.allCemeteryTypeList", currentPage);
	}
	
	/**
     * 查询所有墓型列表
     */
	public List<CemeteryTypeBO> allCemeteryTypeListByC(CemeteryTypeBO cemeteryType) {
		logger.debug("<======CemeteryTypeServiceImpl--allCemeteryTypeListByC======>");
		return appDao.queryForEntityList("CemeteryType.allCemeteryTypeList", cemeteryType);
	}
	
	 /**
     * 分页查询指定墓型列表
     */
	public CurrentPage getCemeteryType(CurrentPage currentPage) {
		logger.debug("<======CemeteryTypeServiceImpl--getCemeteryType======>");
		return appDao.queryForPage("CemeteryType.getCemeteryType", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======CemeteryTypeServiceImpl--findAllMapCemeteryType======>");		
		return appDao.queryForMapList("CemeteryType.findAllMapCemeteryType", param);
	}
	
	/**
     * 查询所有数据 ，重新组装为map根据parkId
     */
	public List<Dto> newFindAllMap(Dto param){
		logger.debug("<======CemeteryTypeServiceImpl--findAllMapCemeteryTypeByCP======>");		
		return appDao.queryForMapList("CemeteryType.findAllMapCemeteryTypeByCP", param);
	}
	
	/**
     * 查询所有数据 ，重新组装为map根据cemeteryId
     */
	public List<Dto> newFindAllMapByC(Dto param){
		logger.debug("<======CemeteryTypeServiceImpl--findAllMapCemeteryTypeByC======>");		
		return appDao.queryForMapList("CemeteryType.findAllMapCemeteryTypeByC", param);
	}
 }
  