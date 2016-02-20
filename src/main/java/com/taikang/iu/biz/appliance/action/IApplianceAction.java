package com.taikang.iu.biz.appliance.action;

import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;


/**
  * IApplianceAction
  */

public interface IApplianceAction extends IBaseAction { 

	final String ACTION_ID = "applianceAction"; 	
	
	/**
     * 分页查询数据查询用品需要审批的列表
     */
	public CurrentPage queryPriductForPage(CurrentPage currentPage);
	
	/**
     * 分页查询数据查询用品查看的列表
     */
	public CurrentPage queryProductSeatForPage(CurrentPage currentPage);
}
