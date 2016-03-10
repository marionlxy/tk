package com.taikang.iu.biz.goodscategory.service;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.service.IBaseService;
import com.taikang.udp.sys.util.vo.Tree;

import java.util.Arrays;
import java.util.List;

/**
  * IGoodscategoryService
  */
 
 public interface IGoodscategoryService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "goodscategoryService";  	
 	
 	public List<Dto> findAllMenuTreeLeafMap(Dto param);
 	
 	public List<Tree> getComInfo(); 
	
	public List<Tree> getChildrenTreeLst(Integer comId, String state);
 	
 }
 
 
 