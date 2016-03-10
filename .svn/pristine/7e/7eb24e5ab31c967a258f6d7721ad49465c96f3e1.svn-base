package com.taikang.iu.opt.regoods.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;

import com.taikang.iu.opt.regoods.model.RegoodsBO;

import java.util.List;

import com.taikang.iu.opt.regoods.action.IRegoodsAction;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;
import com.taikang.iu.opt.regoods.service.IRegoodsService;

import org.springframework.stereotype.Service;

/**
  * RegoodsAction
  */
  @Service(IRegoodsAction.ACTION_ID)
public class RegoodsActionImpl extends BaseActionImpl 
  implements IRegoodsAction {

    /**
      * 注入service
      */
    @Resource(name=IRegoodsService.SERVICE_ID)
	private IRegoodsService<RegoodsBO> regoodsService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======RegoodsAction--addRegoods======>");
		
		RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
		regoodsService.insertObject(regoodsBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======RegoodsAction--updateRegoods======>");
		
		RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
		regoodsService.updateObject(regoodsBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======RegoodsAction--deleteRegoods======>");
		
		RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
		regoodsService.deleteObject(regoodsBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======RegoodsAction--findOneRegoods======>");
		
		RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
		return regoodsService.findOne(regoodsBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======RegoodsAction--findAllRegoods======>");
				
		return regoodsService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======RegoodsAction--queryRegoodsForPage======>");
		
		return regoodsService.queryForPage(currentPage);
	}	
	 /**
     * regoodsGet
     */
	public CurrentPage regoodsGet(CurrentPage currentPage){
		logger.debug("<======RegoodsAction--queryRegoodsForPage======>");
		
		return regoodsService.regoodsGet(currentPage);
	}
	 /**
     * endList
     */
	public CurrentPage endList(CurrentPage currentPage){
		logger.debug("<======RegoodsAction--queryRegoodsForPage======>");
		
		return regoodsService.endList(currentPage);
	}
	 /**
     * checkList
     */
	public CurrentPage checkList(CurrentPage currentPage){
		logger.debug("<======RegoodsAction--queryRegoodsForPage======>");
		
		return regoodsService.checkList(currentPage);
	}
	 /**
     * checkList
     */
	public CurrentPage overlist(CurrentPage currentPage){
		logger.debug("<======RegoodsAction--queryRegoodsForPage======>");
		
		return regoodsService.overlist(currentPage);
	}



	public List<Dto> findAllRegoods(Dto param) {
		logger.debug("<======RegoodsAction--findAllRegoods======>");
		return regoodsService.findAllRegoods(param);
	}

	@SuppressWarnings("unchecked")
	public void updateFixedTimeRe(Dto regoods) {
		Dto param = new BaseDto();
		if(regoods.get("RETURN_STATE").equals("0")){
			param.put("returnId", regoods.get("RETURN_ID"));
			param.put("returnState", "1");
			param.put("auditTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("auditBy", "系统审核");
			param.put("modifiedBy", "系统操作");
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version",  Integer.parseInt(regoods.get("VERSION").toString())+1);
			RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
			
			regoodsService.updateObject(regoodsBO);


		}else if(regoods.get("RETURN_STATE").equals("1")){
			
			
			param.put("returnId", regoods.get("RETURN_ID"));
			param.put("returnState", "4");
			param.put("cancelBy", "系统已取消");
			param.put("cancelTime", TKDateTimeUtils.getTodayTimeStamp());

			param.put("modifiedBy", "系统操作");
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version",  Integer.parseInt(regoods.get("VERSION").toString())+1);
			RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
			
			regoodsService.updateObject(regoodsBO);
		}else if(regoods.get("RETURN_STATE").equals("3")){
			
			
			param.put("returnId", regoods.get("RETURN_ID"));
			param.put("returnState", "8");
			param.put("agreeBy", "系统同意退货");
			param.put("agreeTime", TKDateTimeUtils.getTodayTimeStamp());

			param.put("modifiedBy", "系统操作");
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version",  Integer.parseInt(regoods.get("VERSION").toString())+1);
			RegoodsBO regoodsBO = BaseDto.toModel(RegoodsBO.class , param);
			
			regoodsService.updateObject(regoodsBO);
		}
		
		
		
		
		
	}

}
