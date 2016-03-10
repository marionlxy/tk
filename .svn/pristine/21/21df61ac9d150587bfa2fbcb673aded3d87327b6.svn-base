package com.taikang.iu.opt.operation.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import com.taikang.iu.opt.operation.action.IoperationAction;
import com.taikang.iu.opt.operation.service.IoperationService;
import java.util.List;
import com.taikang.iu.opt.operation.model.operationBO;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * operationAction
  */
  @Service(IoperationAction.ACTION_ID)
public class operationActionImpl extends BaseActionImpl 
  implements IoperationAction {

    /**
      * 注入service
      */
    @Resource(name=IoperationService.SERVICE_ID)
	private IoperationService<operationBO> operationService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======operationAction--addoperation======>");
		
		operationBO operationBO = BaseDto.toModel(operationBO.class , param);
		operationService.insertObject(operationBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======operationAction--updateoperation======>");
		
		operationBO operationBO = BaseDto.toModel(operationBO.class , param);
		operationService.updateObject(operationBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======operationAction--deleteoperation======>");
		
		operationBO operationBO = BaseDto.toModel(operationBO.class , param);
		operationService.deleteObject(operationBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======operationAction--findOneoperation======>");
		
		operationBO operationBO = BaseDto.toModel(operationBO.class , param);
		return operationService.findOne(operationBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======operationAction--findAlloperation======>");
				
		return operationService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======operationAction--queryoperationForPage======>");
		
		return operationService.queryForPage(currentPage);
	}	
}
