package com.taikang.iu.opt.single.action.impl;


import com.taikang.udp.file.model.FilepathBO;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.single.model.SingleBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.service.IFileloadService;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.single.action.ISingleAction;
import com.taikang.iu.opt.single.service.ISingleService;

/**
  * SingleAction
  */
  @Service(ISingleAction.ACTION_ID)
public class SingleActionImpl extends BaseActionImpl 
  implements ISingleAction {

    /**
      * 注入service
      */
    @Resource(name=ISingleService.SERVICE_ID)
	private ISingleService<SingleBO> singleService;	
	

	/**
	 * 注入上传service
	 */
	@Resource(name = IFileloadService.SERVICE_ID)
	private IFileloadService fileloadService;
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======SingleAction--addSingle======>");
		param.put("serviceNum", "DX"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("SERVICE_NUM").nextId()); 
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.insertObject(singleBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======SingleAction--updateSingle======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.updateObject(singleBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======SingleAction--deleteSingle======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.deleteObject(singleBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======SingleAction--findOneSingle======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		return singleService.findOne(singleBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======SingleAction--findAllSingle======>");
				
		return singleService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======SingleAction--querySingleForPage======>");
		
		return singleService.queryForPage(currentPage);
	}

	public CurrentPage queryForServPage(CurrentPage page) {
		logger.debug("<======SingleAction--queryForServPage======>");
		return singleService.queryForServPage(page);
	}

	public List<SingleBO> findAllSellerService(Dto param) {
		logger.debug("<======SingleAction--findAllSellerService======>");
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		return  singleService.findAllSellerService(singleBO);
	}

	public void insertSellerService(Dto param) {
		logger.debug("<======SingleAction--addSingle======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.insertSellerService(singleBO);
	}

	public Dto findOneSeller(Dto params) {
		logger.debug("<======SingleAction--findOneSeller======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , params);
		return singleService.findOneSeller(singleBO).toDto();//返回的BO对象自动转换成Dto返回
	}
	/**
	 * 删除服务商
	 */
	
	public void delSellerService(Dto param) {
		logger.debug("<======SingleAction--delSellerService======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.delSellerService(singleBO);
		
	}

	public CurrentPage queryForServListPage(CurrentPage page) {
		logger.debug("<======SingleAction--querySingleForPage======>");
		
		return singleService.queryForServListPage(page);
	}

	public void updateSellerService(Dto param) {
		logger.debug("<======SingleAction--updateSellerService======>");
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.updateSellerService(singleBO);
		
	}

	public List<SingleBO> findOneSellers(Dto params) {
		
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , params);
		return (List<SingleBO>) singleService.findOneSellers(singleBO);
	}

	public void insertService(Dto param) {
		logger.debug("<======SingleAction--addSingle======>");
		param.put("serviceId", UUID.randomUUID().toString().replace("-", ""));
		param.put("serviceState", "0"); // “1”代表“使用中”
		param.put("serviceNum", "DX"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("SERVICE_NUM").nextId()); 
		param.put("createdBy", param.get("loginId"));
		param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("delflag", "0"); // “0”代表“未删除”
		param.put("version", 1);
		param.put("serviceName", param.get("serviceName"));
		param.put("serviceType", param.get("serviceType"));
		param.put("serviceMsg", param.get("serviceMsg"));
		param.put("sellPrice", param.get("sellPrice"));
		param.put("moral", param.get("moral"));
		param.put("pictureUrl",param.get("pictureUrl") );
		SingleBO singleBO = BaseDto.toModel(SingleBO.class , param);
		singleService.insertObject(singleBO);
	}

	public String uploadBySpringGrpSingle(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		String pictureUrl = null;
		String upLoadPath = CommonUtil.uploadFilePath();
		String serviceId = request.getParameter("serviceId");
		try {
			pictureUrl = fileloadService.uploadBySpringGrpFixed(request,upLoadPath,"single","");
		} catch (TKCheckedException e) {
		}
			if(serviceId != null && !"".equals(serviceId)){
				if(pictureUrl!=null && !"".equals(pictureUrl)){
					param.put("serviceId", serviceId);
					param.put("pictureUrl", pictureUrl);
					
					SingleBO filePath = BaseDto.toModel(SingleBO.class , param);
					singleService.updateObject(filePath);
				
					return pictureUrl;
				}
			}
		return null;	
	}


}
