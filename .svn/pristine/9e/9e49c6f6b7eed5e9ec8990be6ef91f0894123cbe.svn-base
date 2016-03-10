package com.taikang.iu.biz.goodscategory.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.iu.biz.goodscategory.action.IGoodscategoryAction;

import javax.annotation.Resource;

import com.taikang.iu.biz.goodscategory.service.IGoodscategoryService;

import java.util.List;

import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.iu.biz.goodscategory.model.GoodscategoryBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.sys.util.vo.Tree;

import org.springframework.stereotype.Service;

/**
  * GoodscategoryAction
  */
  @Service(IGoodscategoryAction.ACTION_ID)
public class GoodscategoryActionImpl extends BaseActionImpl 
  implements IGoodscategoryAction {

    /**
      * 注入service
      */
    @Resource(name=IGoodscategoryService.SERVICE_ID)
	private IGoodscategoryService<GoodscategoryBO> goodscategoryService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======GoodscategoryAction--addGoodscategory======>");
		
		GoodscategoryBO goodscategoryBO = BaseDto.toModel(GoodscategoryBO.class , param);
		goodscategoryService.insertObject(goodscategoryBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======GoodscategoryAction--updateGoodscategory======>");
		
		GoodscategoryBO goodscategoryBO = BaseDto.toModel(GoodscategoryBO.class , param);
		goodscategoryService.updateObject(goodscategoryBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======GoodscategoryAction--deleteGoodscategory======>");
		
		GoodscategoryBO goodscategoryBO = BaseDto.toModel(GoodscategoryBO.class , param);
		goodscategoryService.deleteObject(goodscategoryBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======GoodscategoryAction--findOneGoodscategory======>");
		
		GoodscategoryBO goodscategoryBO = BaseDto.toModel(GoodscategoryBO.class , param);
		return goodscategoryService.findOne(goodscategoryBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======GoodscategoryAction--findAllGoodscategory======>");
				
		return goodscategoryService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======GoodscategoryAction--queryGoodscategoryForPage======>");
		
		return goodscategoryService.queryForPage(currentPage);
	}	
	
	/**
     * 查询所有目录树叶子节点和父节点
     */
    public List<Dto> findAllMenuTreeLeafMap(Dto param) {
    	logger.debug("<======MenuAction--findAllMenuTreeLeafMap======>");
		return goodscategoryService.findAllMenuTreeLeafMap(param);
    } 
    
    /**
	 * 获取机构树信息<br/>
	 * @return   
	 * List<Tree>
	 */
	public List<Tree> getComInfo() {
		logger.debug("<======ComAction--getComInfo======>");
		
		return goodscategoryService.getComInfo();
	}
	
	/**
	 * 获取指定机构的子机构信息<br/>
	 * @param comId
	 * @return   
	 * List<Tree>
	 */
	public List<Tree> getChildrenTreeLst(Integer comId, String state) {
		logger.debug("<======ComAction--getChildrenTreeLst======>");
		
		return goodscategoryService.getChildrenTreeLst(comId,state);
	}

}
