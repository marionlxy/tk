package com.taikang.iu.opt.appraise.service;

import java.util.List;

import com.taikang.iu.opt.appraise.model.DimensionBO;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IDimensionService
  */
 
 public interface IDimensionService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "dimensionService";
 	/**
 	 * 更具评价的id查找评价维度
 	 * @param dimension
 	 * @return
 	 */
    public List<DimensionBO> queryFindDimensionList(DimensionBO  dimension);
 }
 
 
 