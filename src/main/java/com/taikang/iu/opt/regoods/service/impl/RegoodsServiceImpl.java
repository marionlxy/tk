package com.taikang.iu.opt.regoods.service.impl;
 
import com.taikang.iu.opt.regoods.model.RegoodsBO;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.opt.regoods.service.IRegoodsService;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * RegoodsServiceImpl
  */
 @Service(IRegoodsService.SERVICE_ID)
 public class RegoodsServiceImpl extends BaseServiceImpl 
 implements IRegoodsService<RegoodsBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(RegoodsBO regoods) {
		logger.debug("<======RegoodsServiceImpl--insertRegoods======>");		
		appDao.insert("Regoods.addRegoods",regoods);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(RegoodsBO regoods) {
		logger.debug("<======RegoodsServiceImpl--updateRegoods======>");
		appDao.update("Regoods.updateRegoods",regoods);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(RegoodsBO regoods) {
		logger.debug("<======RegoodsServiceImpl--deleteRegoods======>");
		appDao.delete("Regoods.deleteRegoods",regoods);
	}
	
	/**
      * 查询数据
      */
	public RegoodsBO findOne(RegoodsBO regoods) {
		logger.debug("<======RegoodsServiceImpl--findRegoods======>");
		
		RegoodsBO regoodsBackBO=appDao.queryOneObject("Regoods.findOneRegoods", regoods);
		return regoodsBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<RegoodsBO> findAll(RegoodsBO  regoods) {
		logger.debug("<======RegoodsServiceImpl--findAllRegoods======>");
		return appDao.queryForEntityList("Regoods.findAllRegoods", regoods);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======RegoodsServiceImpl--queryRegoodsForPage======>");
		return appDao.queryForPage("Regoods.queryRegoodsForPage", currentPage);
	}
	
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======RegoodsServiceImpl--findAllMapRegoods======>");		
		return appDao.queryForMapList("Regoods.findAllMapRegoods", param);
	}
	 /**
     * regoodsGet
     */
	public CurrentPage regoodsGet(CurrentPage currentPage) {
		logger.debug("<======RegoodsServiceImpl--queryRegoodsForPage======>");
		return appDao.queryForPage("Regoods.regoodsGet", currentPage);
	}
	 /**
     * endList
     */
	public CurrentPage endList(CurrentPage currentPage) {
		logger.debug("<======RegoodsServiceImpl--queryRegoodsForPage======>");
		return appDao.queryForPage("Regoods.endList", currentPage);
	}
	 /**
     * checkList
     */
	public CurrentPage checkList(CurrentPage currentPage) {
		logger.debug("<======RegoodsServiceImpl--queryRegoodsForPage======>");
		return appDao.queryForPage("Regoods.checkList", currentPage);
	}
	 /**
     * checkList
     */
	public CurrentPage overlist(CurrentPage currentPage) {
		logger.debug("<======RegoodsServiceImpl--queryRegoodsForPage======>");
		return appDao.queryForPage("Regoods.overlist", currentPage);
	}

	public List<Dto> findAllRegoods(Dto param) {
		logger.debug("<======RegoodsServiceImpl--findAllRegoods======>");
		return appDao.queryForMapList("Regoods.findAllRegood", param);
	}

 }
  