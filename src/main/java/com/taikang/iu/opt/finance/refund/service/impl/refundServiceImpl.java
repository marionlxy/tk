package com.taikang.iu.opt.finance.refund.service.impl;
 
import com.taikang.iu.opt.finance.refund.model.refundBO;
import com.taikang.iu.opt.finance.refund.service.IrefundService;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * refundServiceImpl
  */
 @Service(IrefundService.SERVICE_ID)
 public class refundServiceImpl extends BaseServiceImpl 
 implements IrefundService<refundBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(refundBO refund) {
		logger.debug("<======refundServiceImpl--insertrefund======>");		
		appDao.insert("refund.addrefund",refund);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(refundBO refund) {
		logger.debug("<======refundServiceImpl--updaterefund======>");
		appDao.update("refund.updaterefund",refund);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(refundBO refund) {
		logger.debug("<======refundServiceImpl--deleterefund======>");
		appDao.delete("refund.deleterefund",refund);
	}
	
	/**
      * 查询数据
      */
	public refundBO findOne(refundBO refund) {
		logger.debug("<======refundServiceImpl--findrefund======>");
		
		refundBO refundBackBO=appDao.queryOneObject("refund.findOnerefund", refund);
		return refundBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<refundBO> findAll(refundBO  refund) {
		logger.debug("<======refundServiceImpl--findAllrefund======>");
		return appDao.queryForEntityList("refund.findAllrefund", refund);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======refundServiceImpl--queryrefundForPage======>");
		return appDao.queryForPage("refund.queryrefundForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======refundServiceImpl--queryCountPrice======>");		
		return appDao.queryForMapList("refund.queryCountPrice", param);
	}
 }
  