package com.taikang.iu.opt.finance.refund.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.iu.opt.finance.refund.model.refundBO;
import javax.annotation.Resource;
import com.taikang.iu.opt.finance.refund.service.IrefundService;
import com.taikang.iu.opt.finance.refund.action.IrefundAction;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * refundAction
  */
  @Service(IrefundAction.ACTION_ID)
public class refundActionImpl extends BaseActionImpl 
  implements IrefundAction {

    /**
      * 注入service
      */
    @Resource(name=IrefundService.SERVICE_ID)
	private IrefundService<refundBO> refundService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======refundAction--addrefund======>");
		
		refundBO refundBO = BaseDto.toModel(refundBO.class , param);
		refundService.insertObject(refundBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======refundAction--updaterefund======>");
		
		refundBO refundBO = BaseDto.toModel(refundBO.class , param);
		refundService.updateObject(refundBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======refundAction--deleterefund======>");
		
		refundBO refundBO = BaseDto.toModel(refundBO.class , param);
		refundService.deleteObject(refundBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======refundAction--findOnerefund======>");
		
		refundBO refundBO = BaseDto.toModel(refundBO.class , param);
		return refundService.findOne(refundBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======refundAction--findAllrefund======>");
				
		return refundService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======refundAction--queryrefundForPage======>");
		
		return refundService.queryForPage(currentPage);
	}	
}
