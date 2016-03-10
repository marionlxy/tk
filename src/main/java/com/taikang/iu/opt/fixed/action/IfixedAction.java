package com.taikang.iu.opt.fixed.action;

import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
  * IfixedAction
  */

public interface IfixedAction extends IBaseAction { 

	final String ACTION_ID = "fixedAction";

	CurrentPage queryForLinkPage(CurrentPage page);

	void deleteLink(Dto param);

	List<fixedBO> findAllServerService(Dto param);
	/**
	 * 通过服务Id查询套餐下是否有此服务
	 * @param param
	 * @return
	 */
	List<fixedBO> findApplianRelation(Dto param);
	/**
	 * 通过用品Id查询套餐下是否有此用品
	 * @param param
	 * @return
	 */
	List<fixedBO> findApplianList(Dto param);

	Dto findOneLink(Dto param);
//新增环节
	void insertLink(Dto param);
//修改环节
	void updateLink(Dto param);
//查询用品列表
	CurrentPage queryForAppliancePage(CurrentPage page);
	//根据站点查询用品列表
	List<fixedBO> findAllAppliance(Dto param);
//删除用品
	void delAppliance(Dto param);
	//展示选中物品
	CurrentPage queryForShowAppliancePage(CurrentPage page);
//添加用品
	void insertLinkServer(Dto param);
//添加服务
	void insertServer(Dto param);
//查询环节下是否有服务
	List<fixedBO> findFixService(Dto param);
//删除环节下服务
	void delFixService(Dto param);
//更新环节下服务
	void updateServer(Dto param);
//查询环节所选服务
	List<fixedBO> findOneServerService(Dto param);
//初始化服务列表
	CurrentPage queryForServicePage(CurrentPage page);
//显示环节下服务
	CurrentPage findOneService(CurrentPage page);
//查询环节列表
	List<fixedBO> findLink(Dto paras);
//查询套餐修改环节
	CurrentPage findEditLinkPage(CurrentPage page);
//查询套餐列表
	List<fixedBO> findEditMealList(Dto param);
//查询单个套餐
	Dto findOneMeal(Dto param);
//查询套餐下环节列表
	List<fixedBO> findEditMealCheckList(Dto param);
//查询环节下用品
	List<fixedBO> findApplianceList(Dto params);
//查询套餐下环节
	List<fixedBO> findDelLink(Dto param);

	List<fixedBO> findDelLinks(Dto param);

	void delApplianceLink(Dto param);

	List<fixedBO> findRelation(Dto param);

	void updateAppliance(Dto params);

	List<fixedBO> findApplianceLists(Dto params);

	CurrentPage findOneServices(CurrentPage page);

	List<fixedBO> searchAppliance(Dto applianceParam);

	String uploadBySpringGrpFixed(HttpServletRequest request);

	List<fixedBO> findDelApplianceLists(Dto params);

	List<fixedBO> findFixServices(Dto params);


}
