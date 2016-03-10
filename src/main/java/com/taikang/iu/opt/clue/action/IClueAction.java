package com.taikang.iu.opt.clue.action;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
  * IClueAction
  */

public interface IClueAction extends IBaseAction { 

	final String ACTION_ID = "clueAction";

	CurrentPage cluequeryForPage(CurrentPage page);

	Dto addClueAnd(Dto param);

	List<Dto> proxyTelCheck(Dto param);

	CurrentPage cluequeryForPageT(CurrentPage page); 	
}
