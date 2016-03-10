package com.taikang.iu.opt.prefer.action.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.prefer.action.IPreferAction;
import com.taikang.iu.opt.prefer.model.PreferBO;
import com.taikang.iu.opt.prefer.service.IPreferService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * PreferAction
  */
  @Service(IPreferAction.ACTION_ID)
public class PreferActionImpl extends BaseActionImpl 
  implements IPreferAction {

    /**
      * 注入service
      */
    @Resource(name=IPreferService.SERVICE_ID)
	private IPreferService<PreferBO> preferService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======PreferAction--addPrefer======>");
		
		PreferBO preferBO = BaseDto.toModel(PreferBO.class , param);
		preferService.insertObject(preferBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======PreferAction--updatePrefer======>");
		
		PreferBO preferBO = BaseDto.toModel(PreferBO.class , param);
		preferService.updateObject(preferBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======PreferAction--deletePrefer======>");
		
		PreferBO preferBO = BaseDto.toModel(PreferBO.class , param);
		preferService.deleteObject(preferBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======PreferAction--findOnePrefer======>");
		
		PreferBO preferBO = BaseDto.toModel(PreferBO.class , param);
		return preferService.findOne(preferBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======PreferAction--findAllPrefer======>");
				
		return preferService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======PreferAction--queryPreferForPage======>");
		
		return preferService.queryForPage(currentPage);
	}

	public List<Dto> findPreferListOfSum(Dto param) {
		return preferService.findPreferListOfSum(param);
	}

	public List<Dto> findPreferAll(Dto param) {
		return preferService.findPreferAll(param);
	}	
}
