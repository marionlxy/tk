package com.taikang.iu.opt.characterset.service;

import com.taikang.iu.opt.characterset.model.CharactersetBO;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

import java.util.Arrays;
import java.util.List;

/**
  * ICharactersetService
  */
 
 public interface ICharactersetService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "charactersetService";  	
 	
	CurrentPage queryForLinkPage(CurrentPage page);

	void deleteLink(CharactersetBO characterset);

	List<CharactersetBO> findAllServerService(CharactersetBO characterset);

	BaseBO findOneLink(CharactersetBO characterset);
//新增环节
	void insertLink(CharactersetBO characterset);
//修改环节
	void updateLink(CharactersetBO characterset);
//查询用品列表
	CurrentPage queryForAppliancePage(CurrentPage page);
//根据站点查询用品
	List<CharactersetBO> findAllAppliance(CharactersetBO characterset);
//删除用品
	void delAppliance(CharactersetBO characterset);
//展示选中物品
	CurrentPage queryForShowAppliancePage(CurrentPage page);
//添加用品
	void insertLinkServer(CharactersetBO charactersetBO);
//添加服务
	void insertServer(CharactersetBO charactersetBO);
//查询环节下服务
	List<CharactersetBO> findCharactersetService(CharactersetBO CharactersetBO);
//删除环节下服务
	void delCharactersetService(CharactersetBO characterset);
//更改环节下服务
	void updateServer(CharactersetBO characterset);
//查询环节下服务
	List<CharactersetBO> findOneServerService(CharactersetBO characterset);
	//初始化服务列表
	CurrentPage queryForServicePage(CurrentPage page);
//显示环节下服务
	CurrentPage findOneService(CurrentPage page);
	//查询套餐环节列表
		List<CharactersetBO> findLink(CharactersetBO characterset);
	//分页查询套餐修改环节列表
		CurrentPage findEditLinkPage(CurrentPage page);
	//查询套餐列表
		List<CharactersetBO> findEditMealList(CharactersetBO characterset);
	//查询单个套餐
		BaseBO findOneMeal(CharactersetBO characterset);
	//查询套餐下环节列表
		List<CharactersetBO> findEditMealCheckList(CharactersetBO characterset);
		
		List<CharactersetBO> findDelLink(CharactersetBO characterset);
		List<CharactersetBO> findDelLinks(CharactersetBO characterset);

		List<CharactersetBO> findApplianceList(CharactersetBO characterset);
		
		List<CharactersetBO> findRelation(CharactersetBO Characterset);

		void updateAppliance(CharactersetBO CharactersetBO);

		List<CharactersetBO> findApplianceLists(CharactersetBO CharactersetBO);

		CurrentPage findOneServices(CurrentPage page);

		void delApplianceLink(CharactersetBO CharactersetBO);
		
		public List<Dto> FindapplianceByServerIdIsNull(Dto param);

		List<CharactersetBO> findChacterAppliacnce(CharactersetBO chacter);

		void delService(CharactersetBO charactersetBO);

		List<CharactersetBO> searchAppliance(CharactersetBO charactersetBO);

		List<CharactersetBO> searchOneService(CharactersetBO charactersetBO);

		List<CharactersetBO> findApplianceRelation(CharactersetBO charactersetBO);

		List<CharactersetBO> findApplianList(CharactersetBO charactersetBO);

		List<CharactersetBO> searchOneAppliance(CharactersetBO charactersetBO);

		List<CharactersetBO> searchOnesService(CharactersetBO charactersetBO);

		List<CharactersetBO> findOneLinkService(CharactersetBO charactersetBO);

		List<CharactersetBO> findDelApplianceList(CharactersetBO charactersetBO);

		List<CharactersetBO> findUpdateRelation(CharactersetBO charactersetBO);

 }
 
 
 