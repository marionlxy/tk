package com.taikang.iu.opt.prefer.service;

import java.util.List;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IPreferService
  */
 
 public interface IPreferService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "preferService";  
 	/**
	 * 判断优惠区间是否存在
	 * @author t-zhaohan
	 * @Credited 2015年4月16日 上午9:26:20
	 * @see       [相关类/方法]
	 * @return
	 */
	public List<Dto> findPreferListOfSum(Dto param);
	public List<Dto> findPreferAll(Dto param);
 }
 
 
 