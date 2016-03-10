package com.taikang.iu.opt.cemetery.service;

import com.taikang.iu.opt.cemetery.model.CemeteryParkBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * ICemeteryParkService
  */
 
 public interface ICemeteryParkService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "cemeteryParkService";  
 	
 	public CurrentPage queryNewForPage(CurrentPage currentPage);
 	
 	public void deleteCemeteryParkByC(CemeteryParkBO cemeteryPark);
 	
 	public CemeteryParkBO findNewOne(CemeteryParkBO cemeteryPark);
 	
 	public List<Dto> newFindAllMap(Dto param);
 }
 
 
 