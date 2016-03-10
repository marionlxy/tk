package com.taikang.iu.opt.finance.cloaccount.service.impl;
 
import java.util.List;
import com.taikang.iu.opt.finance.cloaccount.service.IcloSellerService;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.opt.finance.cloaccount.model.cloSellerBO;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * cloSellerServiceImpl
  */
 @Service(IcloSellerService.SERVICE_ID)
 public class cloSellerServiceImpl extends BaseServiceImpl 
 implements IcloSellerService<cloSellerBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(cloSellerBO cloSeller) {
		logger.debug("<======cloSellerServiceImpl--insertcloSeller======>");		
		appDao.insert("cloSeller.addcloSeller",cloSeller);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(cloSellerBO cloSeller) {
		logger.debug("<======cloSellerServiceImpl--updatecloSeller======>");
		appDao.update("cloSeller.updatecloSeller",cloSeller);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(cloSellerBO cloSeller) {
		logger.debug("<======cloSellerServiceImpl--deletecloSeller======>");
		appDao.delete("cloSeller.deletecloSeller",cloSeller);
	}
	
	/**
      * 查询数据
      */
	public cloSellerBO findOne(cloSellerBO cloSeller) {
		logger.debug("<======cloSellerServiceImpl--findcloSeller======>");
		
		cloSellerBO cloSellerBackBO=appDao.queryOneObject("cloSeller.findOnecloSeller", cloSeller);
		return cloSellerBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<cloSellerBO> findAll(cloSellerBO  cloSeller) {
		logger.debug("<======cloSellerServiceImpl--findAllcloSeller======>");
		return appDao.queryForEntityList("cloSeller.findAllcloSeller", cloSeller);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======cloSellerServiceImpl--querycloSellerForPage======>");
		return appDao.queryForPage("cloSeller.querycloSellerForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======cloSellerServiceImpl--findAllMapcloSeller======>");		
		return appDao.queryForMapList("cloSeller.queryCountPrice", param);
	}
 }
  