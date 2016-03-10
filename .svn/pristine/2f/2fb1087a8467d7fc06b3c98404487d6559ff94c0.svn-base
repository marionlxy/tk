package com.taikang.iu.opt.order.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.order.model.OrderSevBO;
import com.taikang.iu.opt.order.service.IOrderSevService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * OrderSevServiceImpl
  */
 @Service(IOrderSevService.SERVICE_ID)
 public class OrderSevServiceImpl extends BaseServiceImpl 
 implements IOrderSevService<OrderSevBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(OrderSevBO orderSev) {
		logger.debug("<======OrderSevServiceImpl--insertOrderSev======>");		
		appDao.insert("OrderSev.addOrderSev",orderSev);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(OrderSevBO orderSev) {
		logger.debug("<======OrderSevServiceImpl--updateOrderSev======>");
		appDao.update("OrderSev.updateOrderSev",orderSev);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(OrderSevBO orderSev) {
		logger.debug("<======OrderSevServiceImpl--deleteOrderSev======>");
		appDao.delete("OrderSev.deleteOrderSev",orderSev);
	}
	
	/**
      * 查询数据
      */
	public OrderSevBO findOne(OrderSevBO orderSev) {
		logger.debug("<======OrderSevServiceImpl--findOrderSev======>");
		
		OrderSevBO orderSevBackBO=appDao.queryOneObject("OrderSev.findOneOrderSev", orderSev);
		return orderSevBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<OrderSevBO> findAll(OrderSevBO  orderSev) {
		logger.debug("<======OrderSevServiceImpl--findAllOrderSev======>");
		return appDao.queryForEntityList("OrderSev.findAllOrderSev", orderSev);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======OrderSevServiceImpl--queryOrderSevForPage======>");
		return appDao.queryForPage("OrderSev.queryOrderSevForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======OrderSevServiceImpl--findAllMapOrderSev======>");		
		return appDao.queryForMapList("OrderSev.findAllMapOrderSev", param);
	}

	public CurrentPage queryOrderSevForPage(CurrentPage currentPage) {
		logger.debug("<======OrderSevServiceImpl--queryOrderSevForPage=orderId=====>");
		return appDao.queryForPage("OrderSev.queryOrderSevIdForPage",currentPage);
	}
	
	/**
	 * 查询所有数据
	 */
	public List<OrderSevBO> findAllOrderSev(OrderSevBO param) {
		
		return appDao.queryForEntityList("OrderSev.findAllOrderSevB",param);
	}


	public CurrentPage queryfindSevOrderPage(CurrentPage currentPage) {
		logger.debug("<======OrderSevServiceImpl--queryfindSevOrderPage======>");	
		return appDao.queryForPage("OrderSev.queryfindSevOrderPage", currentPage);
	}
	/**
	 * 第三方回访服务订单查询
	 */
	public CurrentPage queryVitisSevOrderPage(CurrentPage currentPage) {
		logger.debug("<======OrderServiceImpl--queryVitisOrderPage======>");	
		return appDao.queryForPage("Order.queryVitisOrderList", currentPage);
	}
	public CurrentPage queryVitisSevList(CurrentPage currentPage) {
		logger.debug("<======OrderServiceImpl--queryVitisOrderPage======>");	
		return appDao.queryForPage("OrderSev.queryVitisSevList", currentPage);
	}

	public List<Dto> findSubOrderIsBysubId(Dto param) {
		logger.debug("<======OrderSubServiceImpl--findSubOrderIsBysubId======>");	
		return appDao.queryForMapList("OrderSev.findSubOrderIsBysubId", param);
	}
 }
  