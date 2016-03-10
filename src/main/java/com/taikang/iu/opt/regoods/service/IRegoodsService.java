package com.taikang.iu.opt.regoods.service;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * IRegoodsService
  */
 
 public interface IRegoodsService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "regoodsService";

	public CurrentPage regoodsGet(CurrentPage currentPage);//申请介入/确认收货

	public CurrentPage endList(CurrentPage currentPage);//申请原返/同意退款

	public CurrentPage checkList(CurrentPage currentPage);

	public CurrentPage overlist(CurrentPage currentPage);

	public List<Dto> findAllRegoods(Dto param);  	
 }
 
 
 