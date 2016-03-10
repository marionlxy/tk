package com.taikang.iu.opt.prefer.action;

import java.util.List;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;


/**
  * IPreferAction
  */

public interface IPreferAction extends IBaseAction { 

	final String ACTION_ID = "preferAction"; 	
	/**
	 * 判断优惠区间是否存在
	 * @author t-zhaohan
	 * @Credited 2015年4月16日 上午9:26:20
	 * @see       [相关类/方法]
	 * @return
	 */
	public List<Dto> findPreferListOfSum(Dto param);
	public List<Dto> findPreferAll(Dto param);
	
}
