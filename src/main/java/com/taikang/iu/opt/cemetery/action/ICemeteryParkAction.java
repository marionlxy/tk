package com.taikang.iu.opt.cemetery.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;


/**
  * ICemeteryParkAction
  */

public interface ICemeteryParkAction extends IBaseAction { 

	final String ACTION_ID = "cemeteryParkAction"; 	
	
	public CurrentPage queryNewForPage(CurrentPage currentPage);
	
	public void delCemeteryPark(Dto param);
}
