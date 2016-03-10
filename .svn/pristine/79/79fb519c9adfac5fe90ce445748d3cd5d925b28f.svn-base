package com.taikang.iu.biz.qualityvalue.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.biz.qualityvalue.model.QualityvalueBO;
import com.taikang.iu.biz.qualityvalue.service.IQualityvalueService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * QualityvalueServiceImpl
  */
 @Service(IQualityvalueService.SERVICE_ID)
 public class QualityvalueServiceImpl extends BaseServiceImpl 
 implements IQualityvalueService<QualityvalueBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(QualityvalueBO qualityvalue) {
		logger.debug("<======QualityvalueServiceImpl--insertQualityvalue======>");		
		appDao.insert("Qualityvalue.addQualityvalue",qualityvalue);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(QualityvalueBO qualityvalue) {
		logger.debug("<======QualityvalueServiceImpl--updateQualityvalue======>");
		appDao.update("Qualityvalue.updateQualityvalue",qualityvalue);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(QualityvalueBO qualityvalue) {
		logger.debug("<======QualityvalueServiceImpl--deleteQualityvalue======>");
		appDao.delete("Qualityvalue.deleteQualityvalue",qualityvalue);
	}
	
	/**
      * 查询数据
      */
	public QualityvalueBO findOne(QualityvalueBO qualityvalue) {
		logger.debug("<======QualityvalueServiceImpl--findQualityvalue======>");
		
		QualityvalueBO qualityvalueBackBO=appDao.queryOneObject("Qualityvalue.findOneQualityvalue", qualityvalue);
		return qualityvalueBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<QualityvalueBO> findAll(QualityvalueBO  qualityvalue) {
		logger.debug("<======QualityvalueServiceImpl--findAllQualityvalue======>");
		return appDao.queryForEntityList("Qualityvalue.findAllQualityvalue", qualityvalue);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======QualityvalueServiceImpl--queryQualityvalueByConForPage======>");
		return appDao.queryForPage("Qualityvalue.queryQualityvalueByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======QualityvalueServiceImpl--findAllMapQualityvalue======>");		
		return appDao.queryForMapList("Qualityvalue.findAllMapQualityvalue", param);
	}
 }
  