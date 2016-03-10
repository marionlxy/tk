package com.taikang.iu.biz.qualitymeasure.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import java.util.List;
import com.taikang.iu.biz.qualitymeasure.model.QualitymeasureBO;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.iu.biz.qualitymeasure.action.IQualitymeasureAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.biz.qualitymeasure.service.IQualitymeasureService;
import org.springframework.stereotype.Service;

/**
  * QualitymeasureAction
  */
  @Service(IQualitymeasureAction.ACTION_ID)
public class QualitymeasureActionImpl extends BaseActionImpl 
  implements IQualitymeasureAction {

    /**
      * 注入service
      */
    @Resource(name=IQualitymeasureService.SERVICE_ID)
	private IQualitymeasureService<QualitymeasureBO> qualitymeasureService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======QualitymeasureAction--addQualitymeasure======>");
		
		QualitymeasureBO qualitymeasureBO = BaseDto.toModel(QualitymeasureBO.class , param);
		qualitymeasureService.insertObject(qualitymeasureBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======QualitymeasureAction--updateQualitymeasure======>");
		
		QualitymeasureBO qualitymeasureBO = BaseDto.toModel(QualitymeasureBO.class , param);
		qualitymeasureService.updateObject(qualitymeasureBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======QualitymeasureAction--deleteQualitymeasure======>");
		
		QualitymeasureBO qualitymeasureBO = BaseDto.toModel(QualitymeasureBO.class , param);
		qualitymeasureService.deleteObject(qualitymeasureBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======QualitymeasureAction--findOneQualitymeasure======>");
		
		QualitymeasureBO qualitymeasureBO = BaseDto.toModel(QualitymeasureBO.class , param);
		return qualitymeasureService.findOne(qualitymeasureBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======QualitymeasureAction--findAllQualitymeasure======>");
				
		return qualitymeasureService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======QualitymeasureAction--queryQualitymeasureForPage======>");
		
		return qualitymeasureService.queryForPage(currentPage);
	}	
}
