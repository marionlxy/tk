package com.taikang.iu.opt.fixed.service;

import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * IfixedService
  */
 
 public interface IfixedService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "fixedService";

	CurrentPage queryForLinkPage(CurrentPage page);

	void deleteLink(fixedBO fixedBO);

	List<fixedBO> findAllServerService(fixedBO fixedBO);

	BaseBO findOneLink(fixedBO fixedBO);
//新增环节
	void insertLink(fixedBO fixedBO);
//修改环节
	void updateLink(fixedBO fixedBO);
//查询用品列表
	CurrentPage queryForAppliancePage(CurrentPage page);
//根据站点查询用品
	List<fixedBO> findAllAppliance(fixedBO fixed);
//删除用品
	void delAppliance(fixedBO fixedBO);
//展示选中物品
	CurrentPage queryForShowAppliancePage(CurrentPage page);
//添加用品
	void insertLinkServer(fixedBO fixedBO);
//添加服务
	void insertServer(fixedBO fixedBO);
//查询环节下服务
	List<fixedBO> findFixService(fixedBO fixedBO);
//删除环节下服务
	void delFixService(fixedBO fixedBO);
//更改环节下服务
	void updateServer(fixedBO fixedBO);
//查询环节下服务
	List<fixedBO> findOneServerService(fixedBO fixed);
	//初始化服务列表
	CurrentPage queryForServicePage(CurrentPage page);
//显示环节下服务
	CurrentPage findOneService(CurrentPage page);
//查询套餐环节列表
	List<fixedBO> findLink(fixedBO fixed);
//分页查询套餐修改环节列表
	CurrentPage findEditLinkPage(CurrentPage page);
//查询套餐列表
	List<fixedBO> findEditMealList(fixedBO fixed);
//查询单个套餐
	BaseBO findOneMeal(fixedBO fixedBO);
//查询套餐下环节列表
	List<fixedBO> findEditMealCheckList(fixedBO fixed);

	List<fixedBO> findApplianceList(fixedBO fixed);
//查询套餐下环节列表
	List<fixedBO> findDelLink(fixedBO fixed);

	List<fixedBO> findDelLinks(fixedBO fixed);

	void delApplianceLink(fixedBO fixedBO);

	List<fixedBO> findRelation(fixedBO fixed);

	void updateAppliance(fixedBO fixedBO);

	List<fixedBO> findApplianceLists(fixedBO fixed);

	CurrentPage findOneServices(CurrentPage page);

	List<fixedBO> searchAppliance(fixedBO fixed);

	List<fixedBO> findApplianRelation(fixedBO fixed);

	List<fixedBO> findApplianList(fixedBO fixed);

	List<fixedBO> findDelApplianceLists(fixedBO fixed);

	List<fixedBO> findFixServices(fixedBO fixedBO);


 }
 
 
 