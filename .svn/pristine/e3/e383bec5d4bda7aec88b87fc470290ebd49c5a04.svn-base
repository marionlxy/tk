package com.taikang.iu.opt.cemetery.service;

import com.taikang.iu.opt.cemetery.model.CemeteryTypeBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * ICemeteryTypeService
  */
 
 public interface ICemeteryTypeService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "cemeteryTypeService"; 
 	
 	public CurrentPage allCemeteryTypeList(CurrentPage currentPage);
 	
 	public CurrentPage getCemeteryType(CurrentPage currentPage);

	public void deleteCemeteryTypeByC(CemeteryTypeBO cemeteryTypeBO);
	
	public void deleteCemeteryTypeByCP(CemeteryTypeBO cemeteryTypeBO);
	
	public List<CemeteryTypeBO> allCemeteryTypeListByC(CemeteryTypeBO cemeteryType);
	
	public List<Dto> newFindAllMap(Dto param);
	
	public List<Dto> newFindAllMapByC(Dto param);
 	
 }
 
 
 