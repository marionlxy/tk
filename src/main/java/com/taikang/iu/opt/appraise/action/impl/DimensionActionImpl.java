package com.taikang.iu.opt.appraise.action.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.appraise.action.IDimensionAction;
import com.taikang.iu.opt.appraise.model.DimensionBO;
import com.taikang.iu.opt.appraise.service.IDimensionService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * DimensionAction
  */
  @Service(IDimensionAction.ACTION_ID)
public class DimensionActionImpl extends BaseActionImpl 
  implements IDimensionAction {

    /**
      * 注入service
      */
    @Resource(name=IDimensionService.SERVICE_ID)
	private IDimensionService<DimensionBO> dimensionService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======DimensionAction--addDimension======>");
		
		DimensionBO dimensionBO = BaseDto.toModel(DimensionBO.class , param);
		dimensionService.insertObject(dimensionBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======DimensionAction--updateDimension======>");
		
		DimensionBO dimensionBO = BaseDto.toModel(DimensionBO.class , param);
		dimensionService.updateObject(dimensionBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======DimensionAction--deleteDimension======>");
		
		DimensionBO dimensionBO = BaseDto.toModel(DimensionBO.class , param);
		dimensionService.deleteObject(dimensionBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======DimensionAction--findOneDimension======>");
		
		DimensionBO dimensionBO = BaseDto.toModel(DimensionBO.class , param);
		return dimensionService.findOne(dimensionBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======DimensionAction--findAllDimension======>");
				
		return dimensionService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======DimensionAction--queryDimensionForPage======>");
		
		return dimensionService.queryForPage(currentPage);
	}
    /**
     * 根据评价的id查找评价维度
     */
	public List<DimensionBO> queryFindDimensionList(DimensionBO  dimension) {
		return dimensionService.queryFindDimensionList(dimension);
	}	
	
}
