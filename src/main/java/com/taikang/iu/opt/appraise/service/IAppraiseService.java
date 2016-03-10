package com.taikang.iu.opt.appraise.service;

import java.util.List;

import com.taikang.iu.opt.appraise.model.AppraiseBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IAppraiseService
  */
 
 public interface IAppraiseService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "appraiseService";
 	/**
	 * 根据子订单的id查找对应的评价
	 * @param appraise
	 * @return
	 */
	public List<AppraiseBO> findUniquedAppraise(AppraiseBO appraise);
	public Dto findOneApp(Dto param);
 }
 
 
 