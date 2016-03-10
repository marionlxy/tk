package com.taikang.iu.opt.custom.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.iu.opt.custom.model.CustomBO;
import javax.annotation.Resource;
import com.taikang.iu.opt.custom.service.ICustomService;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.iu.opt.custom.action.ICustomAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;

/**
  * CustomAction
  */
  @Service(ICustomAction.ACTION_ID)
public class CustomActionImpl extends BaseActionImpl 
  implements ICustomAction {

    /**
      * 注入service
      */
    @Resource(name=ICustomService.SERVICE_ID)
	private ICustomService<CustomBO> customService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======CustomAction--addCustom======>");
		
		CustomBO customBO = BaseDto.toModel(CustomBO.class , param);
		customService.insertObject(customBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======CustomAction--updateCustom======>");
		
		CustomBO customBO = BaseDto.toModel(CustomBO.class , param);
		customService.updateObject(customBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======CustomAction--deleteCustom======>");
		
		CustomBO customBO = BaseDto.toModel(CustomBO.class , param);
		customService.deleteObject(customBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======CustomAction--findOneCustom======>");
		
		CustomBO customBO = BaseDto.toModel(CustomBO.class , param);
		return customService.findOne(customBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======CustomAction--findAllCustom======>");
				
		return customService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======CustomAction--queryCustomForPage======>");
		
		return customService.queryForPage(currentPage);
	}

	public void insertCustom(Dto param) {
		CustomBO customBO = BaseDto.toModel(CustomBO.class , param);
		customService.insertCustom(customBO);
	}	
}
