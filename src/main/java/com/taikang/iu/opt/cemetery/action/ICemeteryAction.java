package com.taikang.iu.opt.cemetery.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;


/**
  * ICemeteryAction
  */

public interface ICemeteryAction extends IBaseAction { 

	final String ACTION_ID = "cemeteryAction"; 
	
	public void deleteCemetery(Dto param);
	
	public String uploadByCemetery(HttpServletRequest request);
}
