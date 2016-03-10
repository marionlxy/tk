package com.taikang.iu.biz.picture.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.biz.picture.model.PictureBO;
import com.taikang.iu.biz.picture.service.IPictureService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * PictureServiceImpl
  */
 @Service(IPictureService.SERVICE_ID)
 public class PictureServiceImpl extends BaseServiceImpl 
 implements IPictureService<PictureBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(PictureBO picture) {
		logger.debug("<======PictureServiceImpl--insertPicture======>");		
		appDao.insert("Picture.addPicture",picture);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(PictureBO picture) {
		logger.debug("<======PictureServiceImpl--updatePicture======>");
		appDao.update("Picture.updatePicture",picture);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(PictureBO picture) {
		logger.debug("<======PictureServiceImpl--deletePicture======>");
		appDao.delete("Picture.deletePicture",picture);
	}
	
	/**
      * 查询数据
      */
	public PictureBO findOne(PictureBO picture) {
		logger.debug("<======PictureServiceImpl--findPicture======>");
		
		PictureBO pictureBackBO=appDao.queryOneObject("Picture.findOnePicture", picture);
		return pictureBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<PictureBO> findAll(PictureBO  picture) {
		logger.debug("<======PictureServiceImpl--findAllPicture======>");
		return appDao.queryForEntityList("Picture.findAllPicture", picture);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======PictureServiceImpl--queryPictureForPage======>");
		return appDao.queryForPage("Picture.queryPictureForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======PictureServiceImpl--findAllMapPicture======>");		
		return appDao.queryForMapList("Picture.findAllMapPicture", param);
	}
 }
  