package com.taikang.iu.biz.appliancesku.service;

import java.util.List;

import com.taikang.iu.biz.appliancesku.model.ApplianceskuBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IApplianceskuService
  */
 
 public interface IApplianceskuService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "applianceskuService";  	
 	
 	 /**
     * 分页查询数据(ApplianceId为空的)
     */
	public CurrentPage findAllNull(CurrentPage currentPage);
	/**
	 * 根据用品ID更新SKU价格
	 */
	public void updateSKUByApplianceId(ApplianceskuBO appliancesku);
 }
 
 
 