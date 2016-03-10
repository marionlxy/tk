package com.taikang.iu.opt.regoods.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;
import java.util.List;


/**
  * IRegoodsAction
  */

public interface IRegoodsAction extends IBaseAction { 

	final String ACTION_ID = "regoodsAction";

	CurrentPage regoodsGet(CurrentPage page);

	CurrentPage endList(CurrentPage page);

	CurrentPage checkList(CurrentPage page);

	CurrentPage overlist(CurrentPage page);

	List<Dto> findAllRegoods(Dto param);
	/**
	 * 定时器的修改状态方法
	 * @param regoods
	 */
	public void updateFixedTimeRe(Dto regoods); 	
}
