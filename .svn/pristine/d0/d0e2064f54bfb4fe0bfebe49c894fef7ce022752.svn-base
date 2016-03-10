package com.taikang.iu.biz.qualityvalue.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.iu.biz.qualityvalue.model.QualityvalueBO;
import com.taikang.iu.biz.qualityvalue.service.IQualityvalueService;
import java.util.List;
import com.taikang.iu.biz.qualityvalue.action.IQualityvalueAction;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * QualityvalueAction
  */
  @Service(IQualityvalueAction.ACTION_ID)
public class QualityvalueActionImpl extends BaseActionImpl 
  implements IQualityvalueAction {

    /**
      * 注入service
      */
    @Resource(name=IQualityvalueService.SERVICE_ID)
	private IQualityvalueService<QualityvalueBO> qualityvalueService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======QualityvalueAction--addQualityvalue======>");
		
		QualityvalueBO qualityvalueBO = BaseDto.toModel(QualityvalueBO.class , param);
		qualityvalueService.insertObject(qualityvalueBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======QualityvalueAction--updateQualityvalue======>");
		
		QualityvalueBO qualityvalueBO = BaseDto.toModel(QualityvalueBO.class , param);
		qualityvalueService.updateObject(qualityvalueBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======QualityvalueAction--deleteQualityvalue======>");
		
		QualityvalueBO qualityvalueBO = BaseDto.toModel(QualityvalueBO.class , param);
		qualityvalueService.deleteObject(qualityvalueBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======QualityvalueAction--findOneQualityvalue======>");
		
		QualityvalueBO qualityvalueBO = BaseDto.toModel(QualityvalueBO.class , param);
		return qualityvalueService.findOne(qualityvalueBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======QualityvalueAction--findAllQualityvalue======>");
				
		return qualityvalueService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======QualityvalueAction--queryQualityvalueForPage======>");
		
		return qualityvalueService.queryForPage(currentPage);
	}	
}
