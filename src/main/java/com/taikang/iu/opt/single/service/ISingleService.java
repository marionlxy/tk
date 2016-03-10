package com.taikang.iu.opt.single.service;

import com.taikang.iu.opt.single.model.SingleBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * ISingleService
  */
 
 public interface ISingleService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "singleService";

	CurrentPage queryForServPage(CurrentPage page);

	List<SingleBO> findAllSellerService(SingleBO single);

	void insertSellerService(SingleBO singleBO);

	BaseBO findOneSeller(SingleBO singleBO);

	void delSellerService(SingleBO singleBO);

	CurrentPage queryForServListPage(CurrentPage page);

	void updateSellerService(SingleBO singleBO);

	List<SingleBO>  findOneSellers(SingleBO singleBO);
	
	/**
     * 查询单个服务的结算价格
     */
	public SingleBO findNewOne(SingleBO single) ;

 }
 
 
 