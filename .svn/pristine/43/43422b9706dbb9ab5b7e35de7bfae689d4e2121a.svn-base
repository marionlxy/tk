package com.taikang.iu.opt.single.service.impl;
 
import java.util.List;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.iu.opt.single.model.SingleBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.single.service.ISingleService;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * SingleServiceImpl
  */
 @Service(ISingleService.SERVICE_ID)
 public class SingleServiceImpl extends BaseServiceImpl 
 implements ISingleService<SingleBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(SingleBO single) {
		logger.debug("<======SingleServiceImpl--insertSingle======>");		
		appDao.insert("Single.addSingle",single);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(SingleBO single) {
		logger.debug("<======SingleServiceImpl--updateSingle======>");
		appDao.update("Single.updateSingle",single);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(SingleBO single) {
		logger.debug("<======SingleServiceImpl--deleteSingle======>");
		appDao.delete("Single.deleteSingle",single);
	}
	
	/**
     * 查询单个服务的结算价格
     */
	public SingleBO findNewOne(SingleBO single) {
		logger.debug("<======SingleServiceImpl--findNewOne======>");
		
		SingleBO singleBackBO=appDao.queryOneObject("Single.findNewOne", single);
		return singleBackBO;		
	}
	
	/**
      * 查询数据
      */
	public SingleBO findOne(SingleBO single) {
		logger.debug("<======SingleServiceImpl--findSingle======>");
		
		SingleBO singleBackBO=appDao.queryOneObject("Single.findOneSingle", single);
		return singleBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<SingleBO> findAll(SingleBO  single) {
		logger.debug("<======SingleServiceImpl--findAllSingle======>");
		return appDao.queryForEntityList("Single.findAllSingle", single);
	}
	
	
	 /**
     * 分页查询数据
     */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======SingleServiceImpl--querySingleByConForPage======>");
		// 注意：这里需要修改成自己写的查询语句
//		return appDao.queryForPage("Seller.querySellerForPage", currentPage);
		return appDao.queryForPage("Single.querySingleByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======SingleServiceImpl--findAllMapSingle======>");		
		return appDao.queryForMapList("Single.findAllMapSingle", param);
	}
	/**
	 * 分页查询服务商
	 */
	public CurrentPage queryForServPage(CurrentPage page) {
		logger.debug("<======SingleServiceImpl--queryForServPage======>");
		return appDao.queryForPage("Single.queryForServPage", page);
	}

	public List<SingleBO> findAllSellerService(SingleBO single) {
		logger.debug("<======SingleServiceImpl--findAllSellerService======>");		
		return appDao.queryForEntityList("Single.findAllSellerService",  single);
	}
	//添加服务商
	public void insertSellerService(SingleBO singleBO) {
		logger.debug("<======SingleServiceImpl--insertSellerService======>");		
		appDao.insert("Single.insertSellerService",singleBO);
	}

	public BaseBO findOneSeller(SingleBO singleBO) {
		logger.debug("<======SingleServiceImpl--findOneSeller======>");
		
		SingleBO singleBackBO=appDao.queryOneObject("Single.findOneSeller", singleBO);
		return singleBackBO;
	}
	/**
	 * 删除服务商
	 */
	public void delSellerService(SingleBO singleBO) {
		logger.debug("<======SingleServiceImpl--delSellerService======>");
		appDao.delete("Single.delSellerService",singleBO);
		
	}

	public CurrentPage queryForServListPage(CurrentPage page) {
		logger.debug("<======SingleServiceImpl--queryForServListPage======>");
		return appDao.queryForPage("Single.queryForServListPage", page);
	}

	public void updateSellerService(SingleBO singleBO) {
		logger.debug("<======SingleServiceImpl--updateSellerService======>");
		appDao.update("Single.updateSellerService",singleBO);
	}

	public List<SingleBO> findOneSellers(SingleBO singleBO) {
		logger.debug("<======SingleServiceImpl--findOneSellers======>");		
		return appDao.queryForEntityList("Single.findOneSellers",  singleBO);
	}


 }
  