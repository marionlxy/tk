package com.taikang.iu.opt.cemetery.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.iu.opt.cemetery.action.ICemeteryParkAction;

import java.util.List;

import com.taikang.iu.opt.cemetery.model.CemeteryParkBO;
import com.taikang.iu.opt.cemetery.model.CemeteryTypeBO;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.cemetery.service.ICemeteryParkService;
import com.taikang.iu.opt.cemetery.service.ICemeteryTypeService;

/**
  * CemeteryParkAction
  */
  @Service(ICemeteryParkAction.ACTION_ID)
public class CemeteryParkActionImpl extends BaseActionImpl 
  implements ICemeteryParkAction {

    /**
      * 注入service
      */
    @Resource(name=ICemeteryParkService.SERVICE_ID)
	private ICemeteryParkService<CemeteryParkBO> cemeteryParkService;	
	
    
    /**
     * 注入cemeteryTypeService
     */
   @Resource(name=ICemeteryTypeService.SERVICE_ID)
 	private ICemeteryTypeService<CemeteryTypeBO> cemeteryTypeService;
   
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======CemeteryParkAction--addCemeteryPark======>");
		param.put("parkCode", "CP"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("PARK_CODE").nextId());//园区编号
		CemeteryParkBO cemeteryParkBO = BaseDto.toModel(CemeteryParkBO.class , param);
		cemeteryParkService.insertObject(cemeteryParkBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======CemeteryParkAction--updateCemeteryPark======>");
		
		CemeteryParkBO cemeteryParkBO = BaseDto.toModel(CemeteryParkBO.class , param);
		cemeteryParkService.updateObject(cemeteryParkBO);
	}
	
	/**
     * 删除园区（逻辑删除）
     */
	@SuppressWarnings("unchecked")
	public void delCemeteryPark(Dto param){
		//删除园区
		logger.debug("<======CemeteryParkAction--deleteCemeteryPark======>");
		CemeteryParkBO cemeteryParkBO = BaseDto.toModel(CemeteryParkBO.class , param);
		cemeteryParkService.updateObject(cemeteryParkBO);
		String parkId = param.getAsString("parkId");
		if (parkId != null && !"".equals(parkId)) {
			Dto cemeteryType = new BaseDto();
			cemeteryType.put("parkId",  param.getAsString("parkId"));
			List<Dto> cemeteryTypeList = cemeteryTypeService.newFindAllMap(cemeteryType);
			if (cemeteryTypeList.size()>0) {
				//如果有墓型，则删除该园区下的所有墓型
				logger.debug("<======CemeteryTypeAction--deleteCemeteryType======>");
				Dto newCemeteryType = new BaseDto();
				newCemeteryType.put("parkId", param.getAsString("parkId"));//陵园ID
				newCemeteryType.put("modifiedTime", param.getAsString("modifiedTime"));//修改时间
				newCemeteryType.put("modifiedBy", param.getAsString("modifiedBy"));//修改人
				newCemeteryType.put("version", param.getAsInteger("version"));//版本号
				newCemeteryType.put("delflag", 1);//删除标记
				CemeteryTypeBO cemeteryTypeBO = BaseDto.toModel(CemeteryTypeBO.class , newCemeteryType);
				cemeteryTypeService.deleteCemeteryTypeByCP(cemeteryTypeBO);
				
			}
		}
		
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======CemeteryParkAction--deleteCemeteryPark======>");
		
		CemeteryParkBO cemeteryParkBO = BaseDto.toModel(CemeteryParkBO.class , param);
		cemeteryParkService.deleteObject(cemeteryParkBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======CemeteryParkAction--findOneCemeteryPark======>");
		
		CemeteryParkBO cemeteryParkBO = BaseDto.toModel(CemeteryParkBO.class , param);
		return cemeteryParkService.findOne(cemeteryParkBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======CemeteryParkAction--findAllCemeteryPark======>");
				
		return cemeteryParkService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======CemeteryParkAction--queryCemeteryParkForPage======>");
		
		return cemeteryParkService.queryForPage(currentPage);
	}	
	
	/**
     * 分页查询指定园区信息
     */
	public CurrentPage queryNewForPage(CurrentPage currentPage){
		logger.debug("<======CemeteryParkAction--queryNewForPage======>");
		
		return cemeteryParkService.queryNewForPage(currentPage);
	}
}
