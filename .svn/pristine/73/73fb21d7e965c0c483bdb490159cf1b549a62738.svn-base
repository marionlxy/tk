package com.taikang.iu.opt.finance.cloaccount.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.iu.opt.finance.cloaccount.service.IcloSellerService;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.opt.finance.cloaccount.model.cloSellerBO;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.finance.cloaccount.action.IcloSellerAction;

/**
  * cloSellerAction
  */
  @Service(IcloSellerAction.ACTION_ID)
public class cloSellerActionImpl extends BaseActionImpl 
  implements IcloSellerAction {

    /**
      * 注入service
      */
    @Resource(name=IcloSellerService.SERVICE_ID)
	private IcloSellerService<cloSellerBO> cloSellerService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======cloSellerAction--addcloSeller======>");
		
		cloSellerBO cloSellerBO = BaseDto.toModel(cloSellerBO.class , param);
		cloSellerService.insertObject(cloSellerBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======cloSellerAction--updatecloSeller======>");
		
		cloSellerBO cloSellerBO = BaseDto.toModel(cloSellerBO.class , param);
		cloSellerService.updateObject(cloSellerBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======cloSellerAction--deletecloSeller======>");
		
		cloSellerBO cloSellerBO = BaseDto.toModel(cloSellerBO.class , param);
		cloSellerService.deleteObject(cloSellerBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======cloSellerAction--findOnecloSeller======>");
		
		cloSellerBO cloSellerBO = BaseDto.toModel(cloSellerBO.class , param);
		return cloSellerService.findOne(cloSellerBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======cloSellerAction--findAllcloSeller======>");
				
		return cloSellerService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======cloSellerAction--querycloSellerForPage======>");
		
		return cloSellerService.queryForPage(currentPage);
	}	
}
