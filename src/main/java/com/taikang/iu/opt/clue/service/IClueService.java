package com.taikang.iu.opt.clue.service;

import com.taikang.iu.opt.clue.model.ClueBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * IClueService
  */
 
 public interface IClueService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "clueService";

	CurrentPage cluequeryForPage(CurrentPage currentPage);

	public  List<Dto> proxyTelCheck(Dto clueBO);

	CurrentPage cluequeryForPageT(CurrentPage page);  	
 }
 
 
 