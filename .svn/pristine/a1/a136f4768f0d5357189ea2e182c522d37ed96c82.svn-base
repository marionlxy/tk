package com.taikang.iu.opt.appraise.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.appraise.model.DimensionBO;
import com.taikang.iu.opt.appraise.service.IDimensionService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * DimensionServiceImpl
  */
 @Service(IDimensionService.SERVICE_ID)
 public class DimensionServiceImpl extends BaseServiceImpl 
 implements IDimensionService<DimensionBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(DimensionBO dimension) {
		logger.debug("<======DimensionServiceImpl--insertDimension======>");		
		appDao.insert("Dimension.addDimension",dimension);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(DimensionBO dimension) {
		logger.debug("<======DimensionServiceImpl--updateDimension======>");
		appDao.update("Dimension.updateDimension",dimension);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(DimensionBO dimension) {
		logger.debug("<======DimensionServiceImpl--deleteDimension======>");
		appDao.delete("Dimension.deleteDimension",dimension);
	}
	
	/**
      * 查询数据
      */
	public DimensionBO findOne(DimensionBO dimension) {
		logger.debug("<======DimensionServiceImpl--findDimension======>");
		
		DimensionBO dimensionBackBO=appDao.queryOneObject("Dimension.findOneDimension", dimension);
		return dimensionBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<DimensionBO> findAll(DimensionBO  dimension) {
		logger.debug("<======DimensionServiceImpl--findAllDimension======>");
		return appDao.queryForEntityList("Dimension.findAllDimension", dimension);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======DimensionServiceImpl--queryDimensionForPage======>");
		return appDao.queryForPage("Dimension.queryDimensionForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======DimensionServiceImpl--findAllMapDimension======>");		
		return appDao.queryForMapList("Dimension.findAllMapDimension", param);
	}

	public List<DimensionBO> queryFindDimensionList(DimensionBO  dimension) {
		return appDao.queryForEntityList("Dimension.queryDimensionForInfo",dimension);
	}
 }
  