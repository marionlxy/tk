package com.taikang.iu.opt.test.action;

import java.util.List;

import com.taikang.iu.opt.test.model.TestBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;


/**
  * ITestAction
  */

public interface ITestAction extends IBaseAction { 

	final String ACTION_ID = "testAction"; 	
	 List<TestBO> findAllTestBO(Dto param);
}
