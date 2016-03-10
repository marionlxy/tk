package com.taikang.iu.opt.complain.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.iu.opt.complain.service.IComplainService;
import com.taikang.iu.opt.complain.model.ComplainBO;
import com.taikang.iu.opt.complain.action.IComplainAction;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * ComplainAction
  */
  @Service(IComplainAction.ACTION_ID)
public class ComplainActionImpl extends BaseActionImpl 
  implements IComplainAction {

    /**
      * 注入service
      */
    @Resource(name=IComplainService.SERVICE_ID)
	private IComplainService<ComplainBO> complainService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======ComplainAction--addComplain======>");
		
		ComplainBO complainBO = BaseDto.toModel(ComplainBO.class , param);
		complainService.insertObject(complainBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======ComplainAction--updateComplain======>");
		
		ComplainBO complainBO = BaseDto.toModel(ComplainBO.class , param);
		complainService.updateObject(complainBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======ComplainAction--deleteComplain======>");
		
		ComplainBO complainBO = BaseDto.toModel(ComplainBO.class , param);
		complainService.deleteObject(complainBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======ComplainAction--findOneComplain======>");
		
		ComplainBO complainBO = BaseDto.toModel(ComplainBO.class , param);
		return complainService.findOne(complainBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======ComplainAction--findAllComplain======>");
				
		return complainService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======ComplainAction--queryComplainForPage======>");
		
		return complainService.queryForPage(currentPage);
	}	
}
