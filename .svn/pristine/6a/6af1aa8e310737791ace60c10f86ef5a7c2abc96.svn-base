package com.taikang.iu.opt.clue.service.impl;
 
import com.taikang.iu.opt.clue.service.IClueService;

import java.util.List;

import com.taikang.iu.opt.clue.model.ClueBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import org.springframework.stereotype.Service;

import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * ClueServiceImpl
  */
 @Service(IClueService.SERVICE_ID)
 public class ClueServiceImpl extends BaseServiceImpl 
 implements IClueService<ClueBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(ClueBO clue) {
		logger.debug("<======ClueServiceImpl--insertClue======>");		
		appDao.insert("Clue.addClue",clue);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(ClueBO clue) {
		logger.debug("<======ClueServiceImpl--updateClue======>");
		appDao.update("Clue.updateClue",clue);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(ClueBO clue) {
		logger.debug("<======ClueServiceImpl--deleteClue======>");
		appDao.delete("Clue.deleteClue",clue);
	}
	
	/**
      * 查询数据
      */
	public ClueBO findOne(ClueBO clue) {
		logger.debug("<======ClueServiceImpl--findClue======>");
		
		ClueBO clueBackBO=appDao.queryOneObject("Clue.findOneClue", clue);
		return clueBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<ClueBO> findAll(ClueBO  clue) {
		logger.debug("<======ClueServiceImpl--findAllClue======>");
		return appDao.queryForEntityList("Clue.findAllClue", clue);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======ClueServiceImpl--queryClueForPage======>");
//		return appDao.queryForPage("Clue.queryClueForPage", currentPage);
		return appDao.queryForPage("Clue.queryClueByConForPage", currentPage);

	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======ClueServiceImpl--findAllMapClue======>");		
		return appDao.queryForMapList("Clue.findAllMapClue", param);
	}

	public CurrentPage cluequeryForPage(CurrentPage currentPage) {
		// TODO Auto-generated method stub
		return appDao.queryForPage("Clue.cluequeryForPage", currentPage);
	}

	public List<Dto> proxyTelCheck(Dto clueBO) {
		logger.debug("<======ClueServiceImpl--proxyTelCheck======>");
		return appDao.queryForMapList("Clue.proxyTelCheck", clueBO);
		
	}

	public CurrentPage cluequeryForPageT(CurrentPage page) {
		// TODO Auto-generated method stub
		return appDao.queryForPage("Clue.cluequeryForPageT", page);
	}

	
 }
  