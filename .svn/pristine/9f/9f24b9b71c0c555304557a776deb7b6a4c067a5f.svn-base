package com.taikang.iu.opt.order.service.impl;
 
import com.taikang.iu.opt.order.model.OrderSubBO;

import java.util.List;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.iu.opt.order.service.IOrderSubService;
import com.taikang.udp.framework.common.datastructre.Dto;

import org.springframework.stereotype.Service;

import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * OrderSubServiceImpl
  */
 @Service(IOrderSubService.SERVICE_ID)
 public class OrderSubServiceImpl extends BaseServiceImpl 
 implements IOrderSubService<OrderSubBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(OrderSubBO orderSub) {
		logger.debug("<======OrderSubServiceImpl--insertOrderSub======>");		
		appDao.insert("OrderSub.addOrderSub",orderSub);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(OrderSubBO orderSub) {
		logger.debug("<======OrderSubServiceImpl--updateOrderSub======>");
		appDao.update("OrderSub.updateOrderSub",orderSub);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(OrderSubBO orderSub) {
		logger.debug("<======OrderSubServiceImpl--deleteOrderSub======>");
		appDao.delete("OrderSub.deleteOrderSub",orderSub);
	}
	
	/**
      * 查询数据
      */
	public OrderSubBO findOne(OrderSubBO orderSub) {
		logger.debug("<======OrderSubServiceImpl--findOrderSub======>");
		
		OrderSubBO orderSubBackBO=appDao.queryOneObject("OrderSub.findOneOrderSub", orderSub);
		return orderSubBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<OrderSubBO> findAll(OrderSubBO  orderSub) {
		logger.debug("<======OrderSubServiceImpl--findAllOrderSub======>");
		return appDao.queryForEntityList("OrderSub.findAllOrderSub", orderSub);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======OrderSubServiceImpl--queryOrderSubForPage======>");
		return appDao.queryForPage("OrderSub.queryOrderSubForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======OrderSubServiceImpl--findAllMapOrderSub======>");		
		return appDao.queryForMapList("OrderSub.findAllMapOrderSub", param);
	}

	public List<Dto> findSubOrderIsTypeFT(Dto param) {
		logger.debug("<======OrderSubServiceImpl--findSubOrderIsTypeFT======>");	
		return appDao.queryForMapList("OrderSub.findSubOrderIsTypeFT", param);
	}

	public List<Dto> findSubOrderIsTypeST(Dto param) {
		logger.debug("<======OrderSubServiceImpl--findSubOrderIsTypeST======>");	
		return appDao.queryForMapList("OrderSub.findSubOrderIsTypeST", param);
	}
	public List<Dto> findSubOrderList(Dto param) {
		logger.debug("<======OrderSubServiceImpl--findSubOrderList======>");		
		return appDao.queryForMapList("OrderSub.findSubOrderList", param);
	}

	public List<Dto> findSubOrderIsByOrderId(Dto param) {
		logger.debug("<======OrderSubServiceImpl--findSubOrderIsByOrderId======>");		
		return appDao.queryForMapList("OrderSub.findSubOrderIsByOrderId", param);
	}
 }
  