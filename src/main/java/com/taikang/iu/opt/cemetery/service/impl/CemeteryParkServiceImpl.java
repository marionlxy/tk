package com.taikang.iu.opt.cemetery.service.impl;
 
import java.util.List;
import com.taikang.iu.opt.cemetery.model.CemeteryParkBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.cemetery.service.ICemeteryParkService;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * CemeteryParkServiceImpl
  */
 @Service(ICemeteryParkService.SERVICE_ID)
 public class CemeteryParkServiceImpl extends BaseServiceImpl 
 implements ICemeteryParkService<CemeteryParkBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(CemeteryParkBO cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--insertCemeteryPark======>");		
		appDao.insert("CemeteryPark.addCemeteryPark",cemeteryPark);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(CemeteryParkBO cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--updateCemeteryPark======>");
		appDao.update("CemeteryPark.updateCemeteryPark",cemeteryPark);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(CemeteryParkBO cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--deleteCemeteryPark======>");
		appDao.delete("CemeteryPark.deleteCemeteryPark",cemeteryPark);
	}
	
	/**
     * 根据墓园Id删除园区（逻辑删除）
     */
	public void deleteCemeteryParkByC(CemeteryParkBO cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--deleteCemeteryPark======>");
		appDao.update("CemeteryPark.newDeleteCemeteryPark",cemeteryPark);
	}
	
	/**
      * 查询数据
      */
	public CemeteryParkBO findOne(CemeteryParkBO cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--findCemeteryPark======>");
		
		CemeteryParkBO cemeteryParkBackBO=appDao.queryOneObject("CemeteryPark.findOneCemeteryPark", cemeteryPark);
		return cemeteryParkBackBO;		
	}
	
	/**
     * 查询一个园区的详细信息
     */
	public CemeteryParkBO findNewOne(CemeteryParkBO cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--findNewOneCemeteryPark======>");
		
		CemeteryParkBO cemeteryParkBackBO=appDao.queryOneObject("CemeteryPark.findNewOneCemeteryPark", cemeteryPark);
		return cemeteryParkBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<CemeteryParkBO> findAll(CemeteryParkBO  cemeteryPark) {
		logger.debug("<======CemeteryParkServiceImpl--findAllCemeteryPark======>");
		return appDao.queryForEntityList("CemeteryPark.findAllCemeteryPark", cemeteryPark);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======CemeteryParkServiceImpl--queryCemeteryParkForPage======>");
		return appDao.queryForPage("CemeteryPark.queryCemeteryParkForPage", currentPage);
	}
	
	 /**
     * 分页查询指定园区信息
     */
	public CurrentPage queryNewForPage(CurrentPage currentPage) {
		logger.debug("<======CemeteryParkServiceImpl--queryNewForPage======>");
		return appDao.queryForPage("CemeteryPark.queryNewForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======CemeteryParkServiceImpl--findAllMapCemeteryPark======>");		
		return appDao.queryForMapList("CemeteryPark.findAllMapCemeteryPark", param);
	}
	
	/**
     * 查询所有数据 ，重新组装为map
     */
	public List<Dto> newFindAllMap(Dto param){
		logger.debug("<======CemeteryParkServiceImpl--findAllMapCemeteryParkByC======>");		
		return appDao.queryForMapList("CemeteryPark.findAllMapCemeteryParkByC", param);
	}
 }
  