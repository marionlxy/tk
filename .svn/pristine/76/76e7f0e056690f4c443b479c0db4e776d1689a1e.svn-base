package com.taikang.iu.opt.prefer.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.prefer.model.PreferBO;
import com.taikang.iu.opt.prefer.service.IPreferService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * PreferServiceImpl
  */
 @Service(IPreferService.SERVICE_ID)
 public class PreferServiceImpl extends BaseServiceImpl 
 implements IPreferService<PreferBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(PreferBO prefer) {
		logger.debug("<======PreferServiceImpl--insertPrefer======>");		
		appDao.insert("Prefer.addPrefer",prefer);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(PreferBO prefer) {
		logger.debug("<======PreferServiceImpl--updatePrefer======>");
		appDao.update("Prefer.updatePrefer",prefer);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(PreferBO prefer) {
		logger.debug("<======PreferServiceImpl--deletePrefer======>");
		appDao.delete("Prefer.deletePrefer",prefer);
	}
	
	/**
      * 查询数据
      */
	public PreferBO findOne(PreferBO prefer) {
		logger.debug("<======PreferServiceImpl--findPrefer======>");
		
		PreferBO preferBackBO=appDao.queryOneObject("Prefer.findOnePrefer", prefer);
		return preferBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<PreferBO> findAll(PreferBO  prefer) {
		logger.debug("<======PreferServiceImpl--findAllPrefer======>");
		return appDao.queryForEntityList("Prefer.findAllPrefer", prefer);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======PreferServiceImpl--queryPreferForPage======>");
		return appDao.queryForPage("Prefer.queryPreferForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======PreferServiceImpl--findAllMapPrefer======>");		
		return appDao.queryForMapList("Prefer.findAllMapPrefer", param);
	}

	public List<Dto> findPreferListOfSum(Dto param) {
		logger.debug("<======PreferServiceImpl--comfrimPreferForPage======>");		
		return appDao.queryForMapList("Prefer.comfrimPreferForPage", param);
	}

	public List<Dto> findPreferAll(Dto param) {
		logger.debug("<======PreferServiceImpl--comfrimPreferAll======>");		
		return appDao.queryForMapList("Prefer.comfrimPreferAll", param);
	}
 }
  