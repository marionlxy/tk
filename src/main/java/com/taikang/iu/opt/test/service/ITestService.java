package com.taikang.iu.opt.test.service;

import com.taikang.iu.opt.test.model.TestBO;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * ITestService
  */
 
 public interface ITestService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "testService";

	List<TestBO> findAllTestBO(TestBO testBO);  	
 }
 
 
 