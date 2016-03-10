package com.taikang.iu.opt.test.action.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.test.action.ITestAction;
import com.taikang.iu.opt.test.model.TestBO;
import com.taikang.iu.opt.test.service.ITestService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * TestAction
  */
  @Service(ITestAction.ACTION_ID)
public class TestActionImpl extends BaseActionImpl 
  implements ITestAction {

    /**
      * 注入service
      */
    @Resource(name=ITestService.SERVICE_ID)
	private ITestService<TestBO> testService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======TestAction--addTest======>");
		
		TestBO testBO = BaseDto.toModel(TestBO.class , param);
		testService.insertObject(testBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======TestAction--updateTest======>");
		
		TestBO testBO = BaseDto.toModel(TestBO.class , param);
		testService.updateObject(testBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======TestAction--deleteTest======>");
		
		TestBO testBO = BaseDto.toModel(TestBO.class , param);
		testService.deleteObject(testBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======TestAction--findOneTest======>");
		
		TestBO testBO = BaseDto.toModel(TestBO.class , param);
		return testService.findOne(testBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======TestAction--findAllTest======>");
				
		return testService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======TestAction--queryTestForPage======>");
		
		return testService.queryForPage(currentPage);
		
	}

	@Override
	public List<TestBO> findAllTestBO(Dto param) {
		//将dto转换成testBO的实例
		TestBO testBO = BaseDto.toModel(TestBO.class , param);
		return testService.findAllTestBO(testBO);
	}	
}
