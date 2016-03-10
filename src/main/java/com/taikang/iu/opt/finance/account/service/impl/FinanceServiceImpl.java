package com.taikang.iu.opt.finance.account.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.finance.account.model.FinanceBO;
import com.taikang.iu.opt.finance.account.service.IFinanceService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * FinanceServiceImpl
  */
 @Service(IFinanceService.SERVICE_ID)
 public class FinanceServiceImpl extends BaseServiceImpl 
 implements IFinanceService<FinanceBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(FinanceBO finance) {
		logger.debug("<======FinanceServiceImpl--insertFinance======>");		
		appDao.insert("Finance.addFinance",finance);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(FinanceBO finance) {
		logger.debug("<======FinanceServiceImpl--updateFinance======>");
		appDao.update("Finance.updateFinance",finance);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(FinanceBO finance) {
		logger.debug("<======FinanceServiceImpl--deleteFinance======>");
		appDao.delete("Finance.deleteFinance",finance);
	}
	
	/**
      * 查询数据
      */
	public FinanceBO findOne(FinanceBO finance) {
		logger.debug("<======FinanceServiceImpl--findFinance======>");
		
		FinanceBO financeBackBO=appDao.queryOneObject("Finance.findOneFinance", finance);
		return financeBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<FinanceBO> findAll(FinanceBO  finance) {
		logger.debug("<======FinanceServiceImpl--findAllFinance======>");
		return appDao.queryForEntityList("Finance.findAllFinance", finance);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======FinanceServiceImpl--queryFinanceForPage======>");
		return appDao.queryForPage("Finance.queryFinanceForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======FinanceServiceImpl--findAllMapFinance======>");		
		return appDao.queryForMapList("Finance.queryTotalPrice", param);
	}

	public List<FinanceBO> findAllFinance(FinanceBO financeBO) {
		logger.debug("<======FinanceServiceImpl--findAllFinances======>");
		return appDao.queryForEntityList("Finance.findAllFinances", financeBO);
	}
	
 }
  