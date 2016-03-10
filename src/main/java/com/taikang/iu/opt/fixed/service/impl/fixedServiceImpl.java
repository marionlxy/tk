package com.taikang.iu.opt.fixed.service.impl;
 
import com.taikang.iu.opt.fixed.service.IfixedService;

import java.util.List;

import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;

import org.springframework.stereotype.Service;

import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * fixedServiceImpl
  */
 @Service(IfixedService.SERVICE_ID)
 public class fixedServiceImpl extends BaseServiceImpl 
 implements IfixedService<fixedBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--insertfixed======>");		
		appDao.insert("fixed.addfixed",fixed);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--updatefixed======>");
		appDao.update("fixed.updatefixed",fixed);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--deletefixed======>");
		appDao.delete("fixed.deletefixed",fixed);
	}
	
	/**
      * 查询数据
      */
	public fixedBO findOne(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findfixed======>");
		
		fixedBO fixedBackBO=appDao.queryOneObject("fixed.findOnefixed", fixed);
		return fixedBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<fixedBO> findAll(fixedBO  fixed) {
		logger.debug("<======fixedServiceImpl--findAllfixed======>");
		return appDao.queryForEntityList("fixed.findAllfixed", fixed);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======fixedServiceImpl--queryFixedByConForPage======>");
		return appDao.queryForPage("fixed.queryFixedByConForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======fixedServiceImpl--findAllMapfixed======>");		
		return appDao.queryForMapList("fixed.findAllMapfixed", param);
	}

	public CurrentPage queryForLinkPage(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--queryForLinkPage======>");
		return appDao.queryForPage("fixed.queryForLinkPage", page);
	}

	public void deleteLink(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--deleteLink======>");
		appDao.delete("fixed.deleteLink",fixedBO);
		
	}
//选择服务
	public List<fixedBO> findAllServerService(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--findAllServerService======>");
		return appDao.queryForEntityList("fixed.findAllServerService", fixedBO);
	}
	//修改环节查询
	public BaseBO findOneLink(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--findOneLink======>");
		
		fixedBO fixedBackBO=appDao.queryOneObject("fixed.findOneLink", fixedBO);
		return fixedBackBO;	
	}

	public void insertLink(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--insertLink======>");		
		appDao.insert("fixed.addLink",fixedBO);
	}
//修改环节
	public void updateLink(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--updateLink======>");
		appDao.update("fixed.updateLink",fixedBO);
	}

	public CurrentPage queryForShowAppliancePage(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--queryForAppliancePage======>");
		return appDao.queryForPage("fixed.queryForShowAppliancePage",page);
	}
	public CurrentPage queryForAppliancePage(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--queryForAppliancePage======>");
		return appDao.queryForPage("fixed.queryForAppliancePage",page);
	}

	public List<fixedBO> findAllAppliance(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findAllAppliance======>");
		return appDao.queryForEntityList("fixed.findAllAppliance", fixed);
	}
//删除用品
	public void delAppliance(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--delAppliance======>");
		appDao.delete("fixed.delAppliance",fixedBO);
		
	}
//环节添加用品
	public void insertLinkServer(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--insertLinkServer======>");		
		appDao.insert("fixed.insertLinkServer",fixedBO);
		
	}
//环节添加服务
	public void insertServer(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--insertServer======>");		
		appDao.insert("fixed.insertServer",fixedBO);
	}
//查询环节下服务
	public List<fixedBO> findFixService(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--findFixService======>");
		return appDao.queryForEntityList("fixed.findFixService", fixedBO);
	}

	public void delFixService(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--deletefixed======>");
		appDao.delete("fixed.delFixService",fixedBO);
	}

	public void updateServer(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--updateServer======>");
		appDao.update("fixed.updateServer",fixedBO);
	}
//查询环节下服务
	public List<fixedBO> findOneServerService(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findOneServerService======>");
		return appDao.queryForEntityList("fixed.findOneServerService", fixed);
	}

	public CurrentPage queryForServicePage(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--queryForServicePage======>");
		return appDao.queryForPage("fixed.queryForServicePage",page);
	}
//查询环节下服务
	public CurrentPage findOneService(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--findOneService======>");
		return appDao.queryForPage("fixed.findOneService",page);
	}

	public List<fixedBO> findLink(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findLink======>");
		return appDao.queryForEntityList("fixed.findLink", fixed);
	}

	public CurrentPage findEditLinkPage(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--findEditLinkPage======>");
		return appDao.queryForPage("fixed.findEditLinkPage", page);
	}

	public List<fixedBO> findEditMealList(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findEditMealList======>");
		return appDao.queryForEntityList("fixed.findEditMealList", fixed);
	}
//查询单个套餐
	public BaseBO findOneMeal(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--findOneMeal======>");
		
		fixedBO fixedBackBO=appDao.queryOneObject("fixed.findOneMeal", fixedBO);
		return fixedBackBO;
	}
//查询套餐下环节列表
	public List<fixedBO> findEditMealCheckList(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findEditMealCheckList======>");
		return appDao.queryForEntityList("fixed.findEditMealList", fixed);
	}

	public List<fixedBO> findApplianceList(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findApplianceList======>");
		return appDao.queryForEntityList("fixed.findApplianceList", fixed);
	}

	public List<fixedBO> findDelLink(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findDelLink======>");
		return appDao.queryForEntityList("fixed.findDelLink", fixed);
	}

	public List<fixedBO> findDelLinks(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findDelLinks======>");
		return appDao.queryForEntityList("fixed.findDelLinks", fixed);
	}

	public void delApplianceLink(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--delApplianceLink======>");
		appDao.delete("fixed.delApplianceLink",fixedBO);
	}

	public List<fixedBO> findRelation(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findRelation======>");
		return appDao.queryForEntityList("fixed.findRelation", fixed);
	}

	public void updateAppliance(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--updateAppliance======>");
		appDao.update("fixed.updateAppliance",fixedBO);
	}

	public List<fixedBO> findApplianceLists(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findApplianceLists======>");
		return appDao.queryForEntityList("fixed.findApplianceLists", fixed);
	}

	public CurrentPage findOneServices(CurrentPage page) {
		logger.debug("<======fixedServiceImpl--findOneServices======>");
		return appDao.queryForPage("fixed.findOneServices", page);
	}

	public List<fixedBO> searchAppliance(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--searchAppliance======>");
		return appDao.queryForEntityList("fixed.searchAppliance", fixed);
	}

	public List<fixedBO> findApplianRelation(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findApplianRelation======>");		
		return appDao.queryForEntityList("fixed.findApplianRelation", fixed);
	}

	public List<fixedBO> findApplianList(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findApplianList======>");		
		return appDao.queryForEntityList("fixed.findApplianList", fixed);
	}

	public List<fixedBO> findDelApplianceLists(fixedBO fixed) {
		logger.debug("<======fixedServiceImpl--findDelApplianceLists======>");
		return appDao.queryForEntityList("fixed.findDelApplianceLists", fixed);
	}

	public List<fixedBO> findFixServices(fixedBO fixedBO) {
		logger.debug("<======fixedServiceImpl--findFixServices======>");
		return appDao.queryForEntityList("fixed.findFixServices", fixedBO);
	}

 }
  