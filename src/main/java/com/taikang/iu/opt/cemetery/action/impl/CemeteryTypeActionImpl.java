package com.taikang.iu.opt.cemetery.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.cemetery.action.ICemeteryTypeAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.service.IFileloadService;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.iu.opt.cemetery.service.ICemeteryTypeService;
import com.taikang.iu.opt.cemetery.model.CemeteryBO;
import com.taikang.iu.opt.cemetery.model.CemeteryTypeBO;

import org.springframework.stereotype.Service;

/**
  * CemeteryTypeAction
  */
  @Service(ICemeteryTypeAction.ACTION_ID)
public class CemeteryTypeActionImpl extends BaseActionImpl 
  implements ICemeteryTypeAction {

    /**
      * 注入service
      */
    @Resource(name=ICemeteryTypeService.SERVICE_ID)
	private ICemeteryTypeService<CemeteryTypeBO> cemeteryTypeService;	
	
    /**
   	 * 注入上传service
   	 */
   	@Resource(name = IFileloadService.SERVICE_ID)
   	private IFileloadService fileloadService;
   	
   	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======CemeteryTypeAction--addCemeteryType======>");
		param.put("typeCode", "CT"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("TYPE_CODE").nextId());//墓型编号
		CemeteryTypeBO cemeteryTypeBO = BaseDto.toModel(CemeteryTypeBO.class , param);
		cemeteryTypeService.insertObject(cemeteryTypeBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======CemeteryTypeAction--updateCemeteryType======>");
		
		CemeteryTypeBO cemeteryTypeBO = BaseDto.toModel(CemeteryTypeBO.class , param);
		cemeteryTypeService.updateObject(cemeteryTypeBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======CemeteryTypeAction--deleteCemeteryType======>");
		
		CemeteryTypeBO cemeteryTypeBO = BaseDto.toModel(CemeteryTypeBO.class , param);
		cemeteryTypeService.deleteObject(cemeteryTypeBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======CemeteryTypeAction--findOneCemeteryType======>");
		
		CemeteryTypeBO cemeteryTypeBO = BaseDto.toModel(CemeteryTypeBO.class , param);
		return cemeteryTypeService.findOne(cemeteryTypeBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======CemeteryTypeAction--findAllCemeteryType======>");
				
		return cemeteryTypeService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======CemeteryTypeAction--queryCemeteryTypeForPage======>");
		
		return cemeteryTypeService.queryForPage(currentPage);
	}	
	
	/**
     * 分页查询所有墓型
     */
	public CurrentPage allCemeteryTypeList(CurrentPage currentPage){
		logger.debug("<======CemeteryTypeAction--allCemeteryTypeList======>");
		
		return cemeteryTypeService.allCemeteryTypeList(currentPage);
	}
	
	/**
     * 分页查询指定墓型
     */
	public CurrentPage getCemeteryType(CurrentPage currentPage){
		logger.debug("<======CemeteryTypeAction--getCemeteryType======>");
		
		return cemeteryTypeService.getCemeteryType(currentPage);
	}
	
	/**
	 * 墓地图片上传
	 * @param request
	 * @return
	 */
	public String uploadByCemetery(HttpServletRequest request){
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		String realUrl = null;
		String upLoadPath = CommonUtil.uploadFilePath();
		String typeId = request.getParameter("typeId");
		try {
			realUrl = fileloadService.uploadBySpringGrpFixed(request,upLoadPath,"cemetery_type","");
		} catch (TKCheckedException e) {
		}
			if(typeId != null && !"".equals(typeId)){
				if(realUrl!=null && !"".equals(realUrl)){
					param.put("typeId", typeId);
					param.put("realUrl", realUrl);
					
					CemeteryTypeBO filePath = BaseDto.toModel(CemeteryTypeBO.class , param);
					cemeteryTypeService.updateObject(filePath);
				
					return realUrl;
				}
			}
		return null;	
	}
}
