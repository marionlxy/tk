package com.taikang.iu.opt.cemetery.service.impl;
 
import com.taikang.iu.opt.cemetery.service.ICemeteryService;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.cemetery.model.CemeteryBO;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * CemeteryServiceImpl
  */
 @Service(ICemeteryService.SERVICE_ID)
 public class CemeteryServiceImpl extends BaseServiceImpl 
 implements ICemeteryService<CemeteryBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(CemeteryBO cemetery) {
		logger.debug("<======CemeteryServiceImpl--insertCemetery======>");		
		appDao.insert("Cemetery.addCemetery",cemetery);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(CemeteryBO cemetery) {
		logger.debug("<======CemeteryServiceImpl--updateCemetery======>");
		appDao.update("Cemetery.updateCemetery",cemetery);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(CemeteryBO cemetery) {
		logger.debug("<======CemeteryServiceImpl--deleteCemetery======>");
		appDao.delete("Cemetery.deleteCemetery",cemetery);
	}
	
	/**
      * 查询数据
      */
	public CemeteryBO findOne(CemeteryBO cemetery) {
		logger.debug("<======CemeteryServiceImpl--findCemetery======>");
		
		CemeteryBO cemeteryBackBO=appDao.queryOneObject("Cemetery.findOneCemetery", cemetery);
		return cemeteryBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<CemeteryBO> findAll(CemeteryBO  cemetery) {
		logger.debug("<======CemeteryServiceImpl--findAllCemetery======>");
		return appDao.queryForEntityList("Cemetery.findAllCemetery", cemetery);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======CemeteryServiceImpl--queryForPageByCondition======>");
		return appDao.queryForPage("Cemetery.queryForPageByCondition", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======CemeteryServiceImpl--findAllMapCemetery======>");		
		return appDao.queryForMapList("Cemetery.findAllMapCemetery", param);
	}
 }
  