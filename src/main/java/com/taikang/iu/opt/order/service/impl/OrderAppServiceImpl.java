package com.taikang.iu.opt.order.service.impl;
 
import com.taikang.iu.opt.order.service.IOrderAppService;
import java.util.List;
import com.taikang.iu.opt.order.model.OrderAppBO;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * OrderAppServiceImpl
  */
 @Service(IOrderAppService.SERVICE_ID)
 public class OrderAppServiceImpl extends BaseServiceImpl 
 implements IOrderAppService<OrderAppBO>  
  {
	   /**
	     *  查询用品商户的所有点单
	     *  zhaohan
	     */
		public CurrentPage queryfindAppliancePage(CurrentPage currentPage) {
			logger.debug("<======OrderServiceImpl--queryfindAppliancePage======>");
			return appDao.queryForPage("OrderApp.queryfindAppliancePage", currentPage);
		}
		
 	/**
	  * 增加数据
	  */
	public void insertObject(OrderAppBO orderApp) {
		logger.debug("<======OrderAppServiceImpl--insertOrderApp======>");		
		appDao.insert("OrderApp.addOrderApp",orderApp);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(OrderAppBO orderApp) {
		logger.debug("<======OrderAppServiceImpl--updateOrderApp======>");
		appDao.update("OrderApp.updateOrderApp",orderApp);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(OrderAppBO orderApp) {
		logger.debug("<======OrderAppServiceImpl--deleteOrderApp======>");
		appDao.delete("OrderApp.deleteOrderApp",orderApp);
	}
	
	/**
      * 查询数据
      */
	public OrderAppBO findOne(OrderAppBO orderApp) {
		logger.debug("<======OrderAppServiceImpl--findOrderApp======>");
		
		OrderAppBO orderAppBackBO=appDao.queryOneObject("OrderApp.findOneOrderApp", orderApp);
		return orderAppBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<OrderAppBO> findAll(OrderAppBO  orderApp) {
		logger.debug("<======OrderAppServiceImpl--findAllOrderApp======>");
		return appDao.queryForEntityList("OrderApp.findAllOrderApp", orderApp);
	}
	

	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======OrderAppServiceImpl--queryOrderAppForPage======>");
		return appDao.queryForPage("OrderApp.queryOrderAppForPage", currentPage);
	}
	
	//
	 /**
     * 查询用品订单的分页数据
     * （通过订单的ID）
     */
	public CurrentPage queryOrderIdForPage(CurrentPage currentPage) {
		logger.debug("<======OrderAppServiceImpl--queryOrderAppForPage======>");
		return appDao.queryForPage("OrderApp.queryOrderAppForPageOrder", currentPage);
	}
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======OrderAppServiceImpl--findAllMapOrderApp======>");		
		return appDao.queryForMapList("OrderApp.findAllMapOrderApp", param);
	}
	
	/**
     * 查询所有数据
     */
	public List<OrderAppBO> findAllOrderApp(OrderAppBO  orderApp) {
		logger.debug("<======OrderAppServiceImpl--findAllOrderApp======>");
		return appDao.queryForEntityList("OrderApp.findAllOrderAppB", orderApp);
	}
    /**
     * 根据id查找子订单信息
     */
	public OrderAppBO findOrderAppByIdInfo(OrderAppBO orderApp) {
		logger.debug("<======OrderAppServiceImpl--findOrderAppByIdInfo======>");	
		OrderAppBO orderAppBackBO=appDao.queryOneObject("OrderApp.findOneOrderApp", orderApp);
		return orderAppBackBO;
	}
	public List<Dto> findAllAppOrderList(Dto param) {
		logger.debug("<======OrderAppServiceImpl--findAllAppOrderList======>");
		return appDao.queryForMapList("OrderApp.findAllAppOrderList", param);
	}
 }
  