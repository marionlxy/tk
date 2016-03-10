package com.taikang.iu.opt.worksheet.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.employee.model.EmployeeBO;
import com.taikang.iu.opt.worksheet.model.WorksheetBO;
import com.taikang.iu.opt.worksheet.service.IWorksheetService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * WorksheetServiceImpl
  */
 @Service(IWorksheetService.SERVICE_ID)
 public class WorksheetServiceImpl extends BaseServiceImpl 
 implements IWorksheetService<WorksheetBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(WorksheetBO worksheet) {
		logger.debug("<======WorksheetServiceImpl--insertWorksheet======>");		
		appDao.insert("Worksheet.addWorksheet",worksheet);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(WorksheetBO worksheet) {
		logger.debug("<======WorksheetServiceImpl--updateWorksheet======>");
		appDao.update("Worksheet.updateWorksheet",worksheet);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(WorksheetBO worksheet) {
		logger.debug("<======WorksheetServiceImpl--deleteWorksheet======>");
		appDao.delete("Worksheet.deleteWorksheet",worksheet);
	}
	
	/**
      * 查询数据
      */
	public WorksheetBO findOne(WorksheetBO worksheet) {
		logger.debug("<======WorksheetServiceImpl--findWorksheet======>");
		
		WorksheetBO worksheetBackBO=appDao.queryOneObject("Worksheet.findOneWorksheet", worksheet);
		return worksheetBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<WorksheetBO> findAll(WorksheetBO  worksheet) {
		logger.debug("<======WorksheetServiceImpl--findAllWorksheet======>");
		return appDao.queryForEntityList("Worksheet.findAllWorksheet", worksheet);
	}
	
	
	 /**
	  * 运营经理
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======WorksheetServiceImpl--queryWorksheetForPage======>");
		return appDao.queryForPage("Worksheet.queryWorksheetForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======WorksheetServiceImpl--findAllMapWorksheet======>");		
		return appDao.queryForMapList("Worksheet.findAllMapWorksheet", param);
	}

	public List<EmployeeBO> findCustomTel(EmployeeBO param) {
		logger.debug("<======WorksheetServiceImpl--findAllWorksheet======>");
		return appDao.queryForEntityList("Worksheet.findCustomTel", param);
	}
	 /** 
	  * 普通运营
     * 分页查询数据
     */
	public CurrentPage queryForPageT(CurrentPage page) {
		logger.debug("<======WorksheetServiceImpl--queryWorksheetForPageT======>");
		return appDao.queryForPage("Worksheet.queryWorksheetForPageT", page);
	}
	//导出
	public List<Dto> findAllWorksheet(Dto param) {
		logger.debug("<======WorksheetServiceImpl--findAllWorksheet======>");
		return appDao.queryForMapList("Worksheet.findAllWorksheetT", param);
	}
 }
  