package com.taikang.iu.biz.appliancesku.service.impl;
 
import com.taikang.iu.biz.appliancesku.service.IApplianceskuService;
import com.taikang.iu.biz.appliancesku.model.ApplianceskuBO;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * ApplianceskuServiceImpl
  */
 @Service(IApplianceskuService.SERVICE_ID)
 public class ApplianceskuServiceImpl extends BaseServiceImpl 
 implements IApplianceskuService<ApplianceskuBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(ApplianceskuBO appliancesku) {
		logger.debug("<======ApplianceskuServiceImpl--insertAppliancesku======>");		
		appDao.insert("Appliancesku.addAppliancesku",appliancesku);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(ApplianceskuBO appliancesku) {
		logger.debug("<======ApplianceskuServiceImpl--updateAppliancesku======>");
		appDao.update("Appliancesku.updateAppliancesku",appliancesku);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(ApplianceskuBO appliancesku) {
		logger.debug("<======ApplianceskuServiceImpl--deleteAppliancesku======>");
		appDao.delete("Appliancesku.deleteAppliancesku",appliancesku);
	}
	
	/**
      * 查询数据
      */
	public ApplianceskuBO findOne(ApplianceskuBO appliancesku) {
		logger.debug("<======ApplianceskuServiceImpl--findAppliancesku======>");
		
		ApplianceskuBO applianceskuBackBO=appDao.queryOneObject("Appliancesku.findOneAppliancesku", appliancesku);
		return applianceskuBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<ApplianceskuBO> findAll(ApplianceskuBO  appliancesku) {
		logger.debug("<======ApplianceskuServiceImpl--findAllAppliancesku======>");
		return appDao.queryForEntityList("Appliancesku.findAllAppliancesku", appliancesku);
	}
	
	 /**
     * 分页查询数据(ApplianceId为空的)
     */
	public CurrentPage findAllNull(CurrentPage currentPage) {
		logger.debug("<======ApplianceskuServiceImpl--queryApplianceIdnull======>");
		return appDao.queryForPage("Appliancesku.queryApplianceIdnull", currentPage);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======ApplianceskuServiceImpl--queryApplianceskuForPage======>");
		return appDao.queryForPage("Appliancesku.queryApplianceskuForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======ApplianceskuServiceImpl--findAllMapAppliancesku======>");		
		return appDao.queryForMapList("Appliancesku.findAllMapAppliancesku", param);
	}

	/**
	 * 根据用品ID更新SKU价格
	 */
	@Override
	public void updateSKUByApplianceId(ApplianceskuBO appliancesku) {
		logger.debug("<======ApplianceskuServiceImpl--updateSKUByApplianceId======>");
		appDao.update("Appliancesku.updateSKUByApplianceId",appliancesku);
	}
 }
  