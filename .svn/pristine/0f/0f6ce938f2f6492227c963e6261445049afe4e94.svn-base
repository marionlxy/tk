package com.taikang.iu.biz.goodscategory.service.impl;
 
import com.taikang.iu.biz.goodscategory.service.IGoodscategoryService;

import java.util.ArrayList;
import java.util.List;

import com.taikang.iu.biz.goodscategory.model.GoodscategoryBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;


import com.taikang.udp.framework.common.datastructre.Dto;

import org.springframework.stereotype.Service;

import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
import com.taikang.udp.sys.util.vo.Tree;
 
  
/**
  * GoodscategoryServiceImpl
  */
 @Service(IGoodscategoryService.SERVICE_ID)
 public class GoodscategoryServiceImpl extends BaseServiceImpl 
 implements IGoodscategoryService<GoodscategoryBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(GoodscategoryBO goodscategory) {
		logger.debug("<======GoodscategoryServiceImpl--insertGoodscategory======>");		
		appDao.insert("Goodscategory.addGoodscategory",goodscategory);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(GoodscategoryBO goodscategory) {
		logger.debug("<======GoodscategoryServiceImpl--updateGoodscategory======>");
		appDao.update("Goodscategory.updateGoodscategory",goodscategory);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(GoodscategoryBO goodscategory) {
		logger.debug("<======GoodscategoryServiceImpl--deleteGoodscategory======>");
		appDao.delete("Goodscategory.deleteGoodscategory",goodscategory);
	}
	
	/**
      * 查询数据
      */
	public GoodscategoryBO findOne(GoodscategoryBO goodscategory) {
		logger.debug("<======GoodscategoryServiceImpl--findGoodscategory======>");
		
		GoodscategoryBO goodscategoryBackBO=appDao.queryOneObject("Goodscategory.findOneGoodscategory", goodscategory);
		return goodscategoryBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<GoodscategoryBO> findAll(GoodscategoryBO  goodscategory) {
		logger.debug("<======GoodscategoryServiceImpl--findAllGoodscategory======>");
		return appDao.queryForEntityList("Goodscategory.findAllGoodscategory", goodscategory);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======GoodscategoryServiceImpl--queryGoodscategoryForPage======>");
		return appDao.queryForPage("Goodscategory.queryGoodscategoryForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======GoodscategoryServiceImpl--findAllMapGoodscategory======>");		
		return appDao.queryForMapList("Goodscategory.findAllMapGoodscategory", param);
	}
	
	/**
	 * 查询所有子目录<br/>
	 * 
	 * @param param
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public List<Dto> findAllMenuTreeLeafMap(Dto param) {
    	logger.debug("<======Goodscategory--findAllMapGoodscategory======>");		
		List<Dto> menuBOLst = null;
		menuBOLst = appDao.queryForMapList("Goodscategory.findAllMapGoodscategory", param);
		for(int i=0;i<menuBOLst.size();i++){
			Dto dto = menuBOLst.get(i);
			//List list = dto.getDefaultAList();
			String[] TREE_PATH = dto.getAsString("TREE_PATH").split("\\|");
			int last = TREE_PATH.length-1;
			menuBOLst.get(i).put("_parentId", Integer.valueOf(TREE_PATH[last]));    //_以下滑线开头的变量基本都是固定的 
			//menuBOLst.get(i).put("_parentId", dto.getAsInteger("Parent_Id"));
			menuBOLst.get(i).put("state", "open");
			menuBOLst.get(i).put("checked", false);
		}
		return menuBOLst;
    }
    
    
    /**
	 * 获取机构树信息<br/>
	 * @return   
	 * List<Tree>
	 */
	public List<Tree> getComInfo() {

		List<Tree> treeLst = new ArrayList<Tree>();
		List<Tree> childrenLst;
		Tree tree;
		GoodscategoryBO goodscategory = new GoodscategoryBO();
		goodscategory.setCategoryGrade(1);
		// 查询所有一级机构信息
		List<GoodscategoryBO> ComLst = this.findAll(goodscategory);

		if (ComLst != null) {
			for (GoodscategoryBO comrow : ComLst) {
				tree = new Tree();
				tree.setId(String.valueOf(comrow.getCategoryId()));
				tree.setText(comrow.getCategoryName());
				childrenLst = this.getChildrenTreeLst( Integer.parseInt(comrow.getCategoryId()),"open");
				tree.setChildren(childrenLst);
				treeLst.add(tree);
			}
		}
		return treeLst;
	}
	
	/**
	 * 获取指定机构的子机构信息<br/>
	 * @param comId
	 * @return   
	 * List<Tree>
	 */
	public List<Tree> getChildrenTreeLst(Integer categoryId, String state) {
		List<Tree> treeLst = new ArrayList<Tree>();
		Tree tree;
		GoodscategoryBO goodscategory = new GoodscategoryBO();
		goodscategory.setCategoryId(categoryId.toString());

		List<GoodscategoryBO> lst = appDao.queryForEntityList("Goodscategory.getcategoryBycategoryId", goodscategory);
		for (GoodscategoryBO comRelabo : lst) {
			tree = new Tree();
			tree.setId(String.valueOf(comRelabo.getCategoryId()));
			tree.setText( comRelabo.getCategoryName());
			if (3 == comRelabo.getCategoryGrade()|| 4 == comRelabo.getCategoryGrade()) {
				tree.setState(state);
			}
			List<Tree> childrenLst = this.getChildrenTreeLst(Integer.parseInt(comRelabo.getCategoryId()),state);
			tree.setChildren(childrenLst);
			treeLst.add(tree);
		}

		return treeLst;
	}
	
 }
  