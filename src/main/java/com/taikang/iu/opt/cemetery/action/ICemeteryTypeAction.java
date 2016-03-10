package com.taikang.iu.opt.cemetery.action;

import com.taikang.iu.opt.cemetery.model.CemeteryTypeBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;


/**
  * ICemeteryTypeAction
  */

public interface ICemeteryTypeAction extends IBaseAction { 

	final String ACTION_ID = "cemeteryTypeAction";
	
	public CurrentPage allCemeteryTypeList(CurrentPage currentPage);
	
	public CurrentPage getCemeteryType(CurrentPage currentPage);
	
	public String uploadByCemetery(HttpServletRequest request);
	
}
