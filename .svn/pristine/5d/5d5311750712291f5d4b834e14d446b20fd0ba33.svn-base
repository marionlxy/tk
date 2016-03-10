package com.taikang.iu.opt.worksheet.service;

import java.util.List;

import com.taikang.iu.opt.employee.model.EmployeeBO;
import com.taikang.iu.opt.worksheet.model.WorksheetBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IWorksheetService
  */
 
 public interface IWorksheetService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "worksheetService";

	List<EmployeeBO> findCustomTel(EmployeeBO param);

	CurrentPage queryForPageT(CurrentPage page);

	List<Dto> findAllWorksheet(Dto param);  	
 }
 
 
 