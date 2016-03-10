package com.taikang.iu.opt.single.action;

import com.taikang.iu.opt.single.model.SingleBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
  * ISingleAction
  */

public interface ISingleAction extends IBaseAction { 

	final String ACTION_ID = "singleAction";

	CurrentPage queryForServPage(CurrentPage page);

	List<SingleBO> findAllSellerService(Dto param);

	void insertSellerService(Dto param);

	Dto findOneSeller(Dto params);

	void delSellerService(Dto param);

	CurrentPage queryForServListPage(CurrentPage page);

	void updateSellerService(Dto param);

	List<SingleBO> findOneSellers(Dto params);

	void insertService(Dto param);

	String uploadBySpringGrpSingle(HttpServletRequest request);


}
