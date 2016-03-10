package com.taikang.iu.opt.complain.service.impl;
 
import com.taikang.iu.opt.complain.service.IComplainService;
import com.taikang.iu.opt.complain.model.ComplainBO;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * ComplainServiceImpl
  */
 @Service(IComplainService.SERVICE_ID)
 public class ComplainServiceImpl extends BaseServiceImpl 
 implements IComplainService<ComplainBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(ComplainBO complain) {
		logger.debug("<======ComplainServiceImpl--insertComplain======>");		
		appDao.insert("Complain.addComplain",complain);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(ComplainBO complain) {
		logger.debug("<======ComplainServiceImpl--updateComplain======>");
		appDao.update("Complain.updateComplain",complain);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(ComplainBO complain) {
		logger.debug("<======ComplainServiceImpl--deleteComplain======>");
		appDao.delete("Complain.deleteComplain",complain);
	}
	
	/**
      * 查询数据
      */
	public ComplainBO findOne(ComplainBO complain) {
		logger.debug("<======ComplainServiceImpl--findComplain======>");
		ComplainBO complainBackBO=appDao.queryOneObject("Complain.findOneComplain", complain);
		return complainBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<ComplainBO> findAll(ComplainBO  complain) {
		logger.debug("<======ComplainServiceImpl--findAllComplain======>");
		return appDao.queryForEntityList("Complain.findAllComplain", complain);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======ComplainServiceImpl--queryComplainForPage======>");
	//	return appDao.queryForPage("Complain.queryComplainForPage", currentPage);
		return appDao.queryForPage("Complain.queryComplainByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======ComplainServiceImpl--findAllMapComplain======>");		
		return appDao.queryForMapList("Complain.findAllMapComplain", param);
	}
 }
  