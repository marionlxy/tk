package com.taikang.iu.opt.test.service.impl;

 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.test.model.TestBO;
import com.taikang.iu.opt.test.service.ITestService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * TestServiceImpl
  */
 @Service(ITestService.SERVICE_ID)
 public class TestServiceImpl extends BaseServiceImpl 
 implements ITestService<TestBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(TestBO test) {
		logger.debug("<======TestServiceImpl--insertTest======>");		
		appDao.insert("Test.addTest",test);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(TestBO test) {
		logger.debug("<======TestServiceImpl--updateTest======>");
		appDao.update("Test.updateTest",test);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(TestBO test) {
		logger.debug("<======TestServiceImpl--deleteTest======>");
		appDao.delete("Test.deleteTest",test);
	}
	
	/**
      * 查询数据
      */
	public TestBO findOne(TestBO test) {
		logger.debug("<======TestServiceImpl--findTest======>");
		
		TestBO testBackBO=appDao.queryOneObject("Test.findOneTest", test);
		return testBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<TestBO> findAll(TestBO  test) {
		logger.debug("<======TestServiceImpl--findAllTest======>");
		return appDao.queryForEntityList("Test.findAllTest", test);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======TestServiceImpl--queryTestForPage======>");
		//// 注意：这里需要修改成自己写的查询语句
//		return appDao.queryForPage("Test.queryTestForPage", currentPage);
		return appDao.queryForPage("Test.queryTestByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======TestServiceImpl--findAllMapTest======>");		
		return appDao.queryForMapList("Test.findAllMapTest", param);
	}

	@Override
	public List<TestBO> findAllTestBO(TestBO testBO) {
		logger.debug("<======testServiceImpl--findAllTestByCon======>");
		return appDao.queryForEntityList("Test.findAllTestByCon", testBO);
	}
 }
  