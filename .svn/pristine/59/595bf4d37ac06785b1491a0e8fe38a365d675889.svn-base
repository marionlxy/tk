package com.taikang.iu.opt.worksheet.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.iu.opt.employee.model.EmployeeBO;
import com.taikang.iu.opt.worksheet.action.IWorksheetAction;
import com.taikang.iu.opt.worksheet.model.WorksheetBO;

import java.util.List;

import com.taikang.iu.opt.worksheet.service.IWorksheetService;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;

import org.springframework.stereotype.Service;

/**
  * WorksheetAction
  */
  @Service(IWorksheetAction.ACTION_ID)
public class WorksheetActionImpl extends BaseActionImpl 
  implements IWorksheetAction {

    /**
      * 注入service
      */
    @Resource(name=IWorksheetService.SERVICE_ID)
	private IWorksheetService<WorksheetBO> worksheetService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======WorksheetAction--addWorksheet======>");
		
		WorksheetBO worksheetBO = BaseDto.toModel(WorksheetBO.class , param);
		worksheetService.insertObject(worksheetBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======WorksheetAction--updateWorksheet======>");
		
		WorksheetBO worksheetBO = BaseDto.toModel(WorksheetBO.class , param);
		worksheetService.updateObject(worksheetBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======WorksheetAction--deleteWorksheet======>");
		
		WorksheetBO worksheetBO = BaseDto.toModel(WorksheetBO.class , param);
		worksheetService.deleteObject(worksheetBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======WorksheetAction--findOneWorksheet======>");
		
		WorksheetBO worksheetBO = BaseDto.toModel(WorksheetBO.class , param);
		return worksheetService.findOne(worksheetBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======WorksheetAction--findAllWorksheet======>");
				
		return worksheetService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======WorksheetAction--queryWorksheetForPage======>");
		
		return worksheetService.queryForPage(currentPage);
	}

	public List<EmployeeBO> findCustomTel(EmployeeBO param) {
		logger.debug("<======WorksheetAction--findAllWorksheet======>");
		return worksheetService.findCustomTel(param);
	}

	public CurrentPage queryForPageT(CurrentPage page) {
		logger.debug("<======WorksheetAction--queryWorksheetForPageT======>");
		
		return worksheetService.queryForPageT(page);
	}

	public List<Dto> findAllWorksheet(Dto param) {
		logger.debug("<======WorksheetAction--queryWorksheetForPage======>");
		
		return worksheetService.findAllWorksheet(param);
	}	
}
