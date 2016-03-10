package com.taikang.iu.opt.cemetery.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.cemetery.service.ICemeteryParkService;
import com.taikang.iu.opt.cemetery.service.ICemeteryService;
import com.taikang.iu.opt.cemetery.service.ICemeteryTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.iu.opt.cemetery.action.ICemeteryAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;


import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.sys.service.IFileloadService;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.cemetery.model.CemeteryBO;
import com.taikang.iu.opt.cemetery.model.CemeteryParkBO;
import com.taikang.iu.opt.cemetery.model.CemeteryTypeBO;

/**
  * CemeteryAction
  */
  @Service(ICemeteryAction.ACTION_ID)
public class CemeteryActionImpl extends BaseActionImpl 
  implements ICemeteryAction {

    /**
      * 注入cemeteryService
      */
    @Resource(name=ICemeteryService.SERVICE_ID)
	private ICemeteryService<CemeteryBO> cemeteryService;	
    
    /**
     * 注入cemeteryParkService
     */
   @Resource(name=ICemeteryParkService.SERVICE_ID)
	private ICemeteryParkService<CemeteryParkBO> cemeteryParkService;
	
   
   /**
    * 注入cemeteryTypeService
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
		logger.debug("<======CemeteryAction--addCemetery======>");
		param.put("cemeteryCode", "CE"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("CEMETERY_CODE").nextId());//陵园编号
		CemeteryBO cemeteryBO = BaseDto.toModel(CemeteryBO.class , param);
		cemeteryService.insertObject(cemeteryBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======CemeteryAction--updateCemetery======>");
		
		CemeteryBO cemeteryBO = BaseDto.toModel(CemeteryBO.class , param);
		cemeteryService.updateObject(cemeteryBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======CemeteryAction--deleteCemetery======>");
		
		CemeteryBO cemeteryBO = BaseDto.toModel(CemeteryBO.class , param);
		cemeteryService.deleteObject(cemeteryBO);
	}
	
	/**
     * 删除陵园数据(逻辑删除)
     */
	@SuppressWarnings("unchecked")
	public void deleteCemetery(Dto param) {
		//删除陵园
		logger.debug("<======CemeteryAction--deleteCemetery======>");
		CemeteryBO cemeteryBO = BaseDto.toModel(CemeteryBO.class , param);
		cemeteryService.updateObject(cemeteryBO);
		String cemeteryId = param.getAsString("cemeteryId");
		if (cemeteryId!=null && !"".equals(cemeteryId)) {
			Dto cemeteryPark = new BaseDto();
			cemeteryPark.put("cemeteryId", cemeteryId);
			List<Dto> cemeteryParkList = cemeteryParkService.newFindAllMap(cemeteryPark);
			//如果有园区，则删除该陵园下的所有园区
			if (cemeteryParkList.size()>0) {
					logger.debug("<======CemeteryParkAction--deleteCemeteryPark======>");
					Dto newCemeteryPark = new BaseDto();
					newCemeteryPark.put("cemeteryId", param.getAsString("cemeteryId"));//陵园ID
					newCemeteryPark.put("modifiedTime", param.getAsString("modifiedTime"));//修改时间
					newCemeteryPark.put("modifiedBy", param.getAsString("modifiedBy"));//修改人
					newCemeteryPark.put("version", param.getAsInteger("version"));//版本号
					newCemeteryPark.put("delflag", 1);//删除标记
					CemeteryParkBO cemeteryParkBO = BaseDto.toModel(CemeteryParkBO.class , newCemeteryPark);
					cemeteryParkService.deleteCemeteryParkByC(cemeteryParkBO);
			}
			Dto cemeteryType = new BaseDto();
			cemeteryType.put("cemeteryId", cemeteryId);
			List<Dto> cemeteryTypeList = cemeteryTypeService.newFindAllMapByC(cemeteryType);
			if (cemeteryTypeList.size()>0) {
				//如果有墓型，则删除该陵园下的所有墓型
				logger.debug("<======CemeteryTypeAction--deleteCemeteryType======>");
				Dto newCemeteryType = new BaseDto();
				newCemeteryType.put("cemeteryId", param.getAsString("cemeteryId"));//陵园ID
				newCemeteryType.put("modifiedTime", param.getAsString("modifiedTime"));//修改时间
				newCemeteryType.put("modifiedBy", param.getAsString("modifiedBy"));//修改人
				newCemeteryType.put("version", param.getAsInteger("version"));//版本号
				newCemeteryType.put("delflag", 1);//删除标记
				CemeteryTypeBO newCemeteryTypeBO = BaseDto.toModel(CemeteryTypeBO.class , newCemeteryType);
				cemeteryTypeService.deleteCemeteryTypeByC(newCemeteryTypeBO);
				
			}
			
			
		}
		
		
		
		
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======CemeteryAction--findOneCemetery======>");
		
		CemeteryBO cemeteryBO = BaseDto.toModel(CemeteryBO.class , param);
		return cemeteryService.findOne(cemeteryBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======CemeteryAction--findAllCemetery======>");
				
		return cemeteryService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======CemeteryAction--queryCemeteryForPage======>");
		
		return cemeteryService.queryForPage(currentPage);
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
		String cemeteryId = request.getParameter("cemeteryId");
		try {
			realUrl = fileloadService.uploadBySpringGrpFixed(request,upLoadPath,"cemetery","");
		} catch (TKCheckedException e) {
		}
			if(cemeteryId != null && !"".equals(cemeteryId)){
				if(realUrl!=null && !"".equals(realUrl)){
					param.put("cemeteryId", cemeteryId);
					param.put("realUrl", realUrl);
					
					CemeteryBO filePath = BaseDto.toModel(CemeteryBO.class , param);
					cemeteryService.updateObject(filePath);
				
					return realUrl;
				}
			}
		return null;	
	}
}
