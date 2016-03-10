package com.taikang.iu.opt.finance.account.action.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.finance.account.action.IFinanceAction;
import com.taikang.iu.opt.finance.account.model.FinanceBO;
import com.taikang.iu.opt.finance.account.service.IFinanceService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * FinanceAction
  */
  @Service(IFinanceAction.ACTION_ID)
public class FinanceActionImpl extends BaseActionImpl 
  implements IFinanceAction {

    /**
      * 注入service
      */
    @Resource(name=IFinanceService.SERVICE_ID)
	private IFinanceService<FinanceBO> financeService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======FinanceAction--addFinance======>");
		
		FinanceBO financeBO = BaseDto.toModel(FinanceBO.class , param);
		financeService.insertObject(financeBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======FinanceAction--updateFinance======>");
		
		FinanceBO financeBO = BaseDto.toModel(FinanceBO.class , param);
		financeService.updateObject(financeBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======FinanceAction--deleteFinance======>");
		
		FinanceBO financeBO = BaseDto.toModel(FinanceBO.class , param);
		financeService.deleteObject(financeBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======FinanceAction--findOneFinance======>");
		
		FinanceBO financeBO = BaseDto.toModel(FinanceBO.class , param);
		return financeService.findOne(financeBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======FinanceAction--findAllFinance======>");
				
		return financeService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======FinanceAction--queryFinanceForPage======>");
		
		return financeService.queryForPage(currentPage);
	}

	public List<FinanceBO> findAllFinance(Dto param) {
		logger.debug("<======FinanceAction--findAllFinances======>");
		
		FinanceBO financeBO = BaseDto.toModel(FinanceBO.class , param);
		return financeService.findAllFinance(financeBO);//返回的BO对象自动转换成Dto返回
	}
	
}
