package com.taikang.iu.biz.picture.action.impl;


import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.biz.picture.action.IPictureAction;
import com.taikang.iu.biz.picture.model.PictureBO;
import com.taikang.iu.biz.picture.service.IPictureService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * PictureAction
  */
  @Service(IPictureAction.ACTION_ID)
public class PictureActionImpl extends BaseActionImpl 
  implements IPictureAction {

    /**
      * 注入service
      */
    @Resource(name=IPictureService.SERVICE_ID)
	private IPictureService<PictureBO> pictureService;	
	
	/**
	  * 增加数据
	  */
	@SuppressWarnings("unchecked")
	public void insertObject(Dto param) {
		logger.debug("<======PictureAction--addPicture======>");
		
		String Id = UUID.randomUUID().toString().replace("-", "");
		param.put("pictureId", Id);
		param.put("applianceId",param.getAsString("applianceId")); 
		param.put("pictureAddress",param.getAsString("pictureAddress")); 
		param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("delflag", "0"); // “0”代表“未删除”
		param.put("version", 1);
		
		PictureBO pictureBO = BaseDto.toModel(PictureBO.class , param);
		pictureService.insertObject(pictureBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======PictureAction--updatePicture======>");
		
		PictureBO pictureBO = BaseDto.toModel(PictureBO.class , param);
		pictureService.updateObject(pictureBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======PictureAction--deletePicture======>");
		
		PictureBO pictureBO = BaseDto.toModel(PictureBO.class , param);
		pictureService.deleteObject(pictureBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======PictureAction--findOnePicture======>");
		
		PictureBO pictureBO = BaseDto.toModel(PictureBO.class , param);
		return pictureService.findOne(pictureBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======PictureAction--findAllPicture======>");
				
		return pictureService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======PictureAction--queryPictureForPage======>");
		
		return pictureService.queryForPage(currentPage);
	}	
}
