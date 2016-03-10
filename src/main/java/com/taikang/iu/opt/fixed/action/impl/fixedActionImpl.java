package com.taikang.iu.opt.fixed.action.impl;


import com.taikang.udp.file.model.FilepathBO;
import com.taikang.udp.file.service.IFilepathService;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.fixed.service.IfixedService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.iu.opt.fixed.action.IfixedAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.service.IFileloadService;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;

import org.springframework.stereotype.Service;

/**
  * fixedAction
  */
  @Service(IfixedAction.ACTION_ID)
public class fixedActionImpl extends BaseActionImpl 
  implements IfixedAction {

    /**
      * 注入service
      */
    @Resource(name=IfixedService.SERVICE_ID)
	private IfixedService<fixedBO> fixedService;	
	
	@Resource(name = IFileloadService.SERVICE_ID)
	private IFileloadService fileloadService;
	
	 @Resource(name=IFilepathService.SERVICE_ID)
	private IFilepathService<FilepathBO> filepathService;
	 
		/**
		 * 注入默认上传文件保存路径
		 */
		public String upLoadPath = "";
		
	public String getUpLoadPath() {
			return upLoadPath;
		}

		public void setUpLoadPath(String upLoadPath) {
			this.upLoadPath = upLoadPath;
		}

	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======fixedAction--addfixed======>");
		param.put("mealCode", "TC"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("MEAL_CODE").nextId()); 
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.insertObject(fixedBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======fixedAction--updatefixed======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.updateObject(fixedBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======fixedAction--deletefixed======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.deleteObject(fixedBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======fixedAction--findOnefixed======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findOne(fixedBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======fixedAction--findAllfixed======>");
				
		return fixedService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======fixedAction--queryfixedForPage======>");
		
		return fixedService.queryForPage(currentPage);
	}
	/**
	 * 分页查询环节数据
	 */
	public CurrentPage queryForLinkPage(CurrentPage page) {
		logger.debug("<======fixedAction--queryfixedForPage======>");
		
		return fixedService.queryForLinkPage(page);
	}

	public void deleteLink(Dto param) {
		logger.debug("<======fixedAction--deleteLink======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.deleteLink(fixedBO);
		
	}

	public List<fixedBO> findAllServerService(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findAllServerService(fixed);
	}
//环节修改查询
	public Dto findOneLink(Dto param) {
	logger.debug("<======fixedAction--findOneLink======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findOneLink(fixedBO).toDto();//返回的BO对象自动转换成Dto返回
	}
//新增环节
	public void insertLink(Dto param) {
		logger.debug("<======fixedAction--insertLink======>");
		param.put("linkCode", "HJ"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("SERVICE_NUM").nextId());
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.insertLink(fixedBO);
	}
//修改环节
	public void updateLink(Dto param) {
		logger.debug("<======fixedAction--updatefixed======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.updateLink(fixedBO);
	}
//分页查询用品数据
	public CurrentPage queryForAppliancePage(CurrentPage page) {
		logger.debug("<======fixedAction--queryForAppliancePage======>");
		
		return fixedService.queryForAppliancePage(page);
	}

	public List<fixedBO> findAllAppliance(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findAllAppliance(fixed);
	}
//删除用品
	public void delAppliance(Dto param) {
		logger.debug("<======fixedAction--delAppliance======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.delAppliance(fixedBO);
		
	}
//展示选中物品
	public CurrentPage queryForShowAppliancePage(CurrentPage page) {
		logger.debug("<======fixedAction--queryForShowAppliancePage======>");
		
		return fixedService.queryForShowAppliancePage(page);
	}
//添加用品
	public void insertLinkServer(Dto param) {
		logger.debug("<======fixedAction--insertLinkServer======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.insertLinkServer(fixedBO);
		
	}
//添加服务
	public void insertServer(Dto param) {
		logger.debug("<======fixedAction--insertServer======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.insertServer(fixedBO);
		
	}
//查看环节下服务
	public List<fixedBO> findFixService(Dto param) {
		logger.debug("<======fixedAction--findFixService======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findFixService(fixedBO);
	}
//删除环节下服务
	public void delFixService(Dto param) {
		logger.debug("<======fixedAction--delFixService======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.delFixService(fixedBO);
	}

	public void updateServer(Dto param) {
		logger.debug("<======fixedAction--updateServer======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.updateServer(fixedBO);
	}
//查询环节下服务
	public List<fixedBO> findOneServerService(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return  fixedService.findOneServerService(fixed);
	}
//分页查询服务列表
	public CurrentPage queryForServicePage(CurrentPage page) {
	logger.debug("<======fixedAction--queryForAppliancePage======>");
		
		return fixedService.queryForServicePage(page);
	}
//显示环节下服务
	public CurrentPage findOneService(CurrentPage page) {
		logger.debug("<======fixedAction--queryfixedForPage======>");
		
		return fixedService.findOneService(page);
	}

	public List<fixedBO> findLink(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findLink(fixed);
	}
//分页查询套餐修改环节列表
	public CurrentPage findEditLinkPage(CurrentPage page) {
	logger.debug("<======fixedAction--findEditLinkPage======>");
		
		return fixedService.findEditLinkPage(page);
	}
//查询套餐列表
	public List<fixedBO> findEditMealList(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findEditMealList(fixed);
	}
//查询单个套餐
	public Dto findOneMeal(Dto param) {
	logger.debug("<======fixedAction--findOneMeal======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findOneMeal(fixedBO).toDto();//返回的BO对象自动转换成Dto返回
	}
//查询套餐下环节列表
	public List<fixedBO> findEditMealCheckList(Dto param) {
		logger.debug("<======fixedAction--findEditMealCheckList======>");
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findEditMealCheckList(fixed);
	}

	public List<fixedBO> findApplianceList(Dto params) {
		logger.debug("<======fixedAction--findApplianceList======>");
		fixedBO fixed = BaseDto.toModel(fixedBO.class , params);
		return fixedService.findApplianceList(fixed);
		
	}

	public List<fixedBO> findDelLink(Dto param) {
		logger.debug("<======fixedAction--findApplianceList======>");
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findDelLink(fixed);
	}

	public List<fixedBO> findDelLinks(Dto param) {
		logger.debug("<======fixedAction--findApplianceList======>");
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findDelLinks(fixed);
	}

	public void delApplianceLink(Dto param) {
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , param);
		fixedService.delApplianceLink(fixedBO);
	}

	public List<fixedBO> findRelation(Dto param) {
		logger.debug("<======fixedAction--findApplianceList======>");
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findRelation(fixed);
	}

	public void updateAppliance(Dto params) {
		logger.debug("<======fixedAction--updatefixed======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , params);
		fixedService.updateAppliance(fixedBO);
	}

	public List<fixedBO> findApplianceLists(Dto params) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , params);
		return fixedService.findApplianceLists(fixed);
	}

	public CurrentPage findOneServices(CurrentPage page) {
	logger.debug("<======fixedAction--findOneServices======>");
		
		return fixedService.findOneServices(page);
	}

	public List<fixedBO> searchAppliance(Dto applianceParam) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , applianceParam);
		return fixedService.searchAppliance(fixed);
	}

	//通过serviceId查询固定套餐内是否有此信息
	public List<fixedBO> findApplianRelation(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findApplianRelation(fixed);
	}

	public List<fixedBO> findApplianList(Dto param) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , param);
		return fixedService.findApplianList(fixed);
	
	}

	public String uploadBySpringGrpFixed(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		String pictureUrl = null;
		String upLoadPath = CommonUtil.uploadFilePath();
		String mealId = request.getParameter("mealId");
		try {
			pictureUrl = fileloadService.uploadBySpringGrpFixed(request,upLoadPath,"fixed","");
		} catch (TKCheckedException e) {
		}
		if(mealId != null && !"".equals(mealId)){
			if(pictureUrl!=null && !"".equals(pictureUrl)){
				param.put("mealId", mealId);
				param.put("mealPicture", pictureUrl);
				
				fixedBO filePath = BaseDto.toModel(fixedBO.class , param);
				fixedService.updateObject(filePath);
			
				return pictureUrl;
			}
		}
		return pictureUrl;
	}

	public List<fixedBO> findDelApplianceLists(Dto params) {
		fixedBO fixed = BaseDto.toModel(fixedBO.class , params);
		return fixedService.findDelApplianceLists(fixed);
	}

	public List<fixedBO> findFixServices(Dto params) {
		logger.debug("<======fixedAction--findFixServices======>");
		
		fixedBO fixedBO = BaseDto.toModel(fixedBO.class , params);
		return fixedService.findFixServices(fixedBO);
	}
	
//	public void addimg(HttpServletRequest request) throws TKCheckedException {
//		Map<String, String> map = new HashMap<String, String>();
//		Dto param = new BaseDto();
//		String pictureUrl = null;
//		upLoadPath = "D:///2233//upload//";
//		String mealId = request.getParameter("mealId");
//		pictureUrl = fileloadService.uploadBySpringGrpSingle(request,upLoadPath,"");
//		System.out.println("数据库地址:"+pictureUrl);
//	}


}
