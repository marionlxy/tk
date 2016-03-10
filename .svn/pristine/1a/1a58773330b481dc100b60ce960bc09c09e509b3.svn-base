package com.taikang.iu.biz.goodscategory.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.sys.util.vo.Tree;

import java.util.Arrays;
import java.util.List;


/**
  * IGoodscategoryAction
  */

public interface IGoodscategoryAction extends IBaseAction { 

	final String ACTION_ID = "goodscategoryAction"; 	
	
	public List<Dto> findAllMenuTreeLeafMap(Dto param);
	
	public List<Tree> getComInfo(); 
	
	public List<Tree> getChildrenTreeLst(Integer comId, String state);
}
