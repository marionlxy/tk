package com.taikang.iu.biz.qualitymeasure.service.impl;
 
import java.util.List;
import com.taikang.iu.biz.qualitymeasure.model.QualitymeasureBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.biz.qualitymeasure.service.IQualitymeasureService;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * QualitymeasureServiceImpl
  */
 @Service(IQualitymeasureService.SERVICE_ID)
 public class QualitymeasureServiceImpl extends BaseServiceImpl 
 implements IQualitymeasureService<QualitymeasureBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(QualitymeasureBO qualitymeasure) {
		logger.debug("<======QualitymeasureServiceImpl--insertQualitymeasure======>");		
		appDao.insert("Qualitymeasure.addQualitymeasure",qualitymeasure);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(QualitymeasureBO qualitymeasure) {
		logger.debug("<======QualitymeasureServiceImpl--updateQualitymeasure======>");
		appDao.update("Qualitymeasure.updateQualitymeasure",qualitymeasure);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(QualitymeasureBO qualitymeasure) {
		logger.debug("<======QualitymeasureServiceImpl--deleteQualitymeasure======>");
		appDao.delete("Qualitymeasure.deleteQualitymeasure",qualitymeasure);
	}
	
	/**
      * 查询数据
      */
	public QualitymeasureBO findOne(QualitymeasureBO qualitymeasure) {
		logger.debug("<======QualitymeasureServiceImpl--findQualitymeasure======>");
		
		QualitymeasureBO qualitymeasureBackBO=appDao.queryOneObject("Qualitymeasure.findOneQualitymeasure", qualitymeasure);
		return qualitymeasureBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<QualitymeasureBO> findAll(QualitymeasureBO  qualitymeasure) {
		logger.debug("<======QualitymeasureServiceImpl--findAllQualitymeasure======>");
		return appDao.queryForEntityList("Qualitymeasure.findAllQualitymeasure", qualitymeasure);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======QualitymeasureServiceImpl--queryQualitymeasureByConForPage======>");
		return appDao.queryForPage("Qualitymeasure.queryQualitymeasureByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======QualitymeasureServiceImpl--findAllMapQualitymeasure======>");		
		return appDao.queryForMapList("Qualitymeasure.findAllMapQualitymeasure", param);
	}
 }
  