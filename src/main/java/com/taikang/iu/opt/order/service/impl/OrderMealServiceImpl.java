package com.taikang.iu.opt.order.service.impl;
 
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.order.service.IOrderMealService;
import com.taikang.iu.opt.order.model.OrderMealBO;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * OrderMealServiceImpl
  */
 @Service(IOrderMealService.SERVICE_ID)
 public class OrderMealServiceImpl extends BaseServiceImpl 
 implements IOrderMealService<OrderMealBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(OrderMealBO orderMeal) {
		logger.debug("<======OrderMealServiceImpl--insertOrderMeal======>");		
		appDao.insert("OrderMeal.addOrderMeal",orderMeal);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(OrderMealBO orderMeal) {
		logger.debug("<======OrderMealServiceImpl--updateOrderMeal======>");
		appDao.update("OrderMeal.updateOrderMeal",orderMeal);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(OrderMealBO orderMeal) {
		logger.debug("<======OrderMealServiceImpl--deleteOrderMeal======>");
		appDao.delete("OrderMeal.deleteOrderMeal",orderMeal);
	}
	
	/**
      * 查询数据
      */
	public OrderMealBO findOne(OrderMealBO orderMeal) {
		logger.debug("<======OrderMealServiceImpl--findOrderMeal======>");
		
		OrderMealBO orderMealBackBO=appDao.queryOneObject("OrderMeal.findOneOrderMeal", orderMeal);
		return orderMealBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<OrderMealBO> findAll(OrderMealBO  orderMeal) {
		logger.debug("<======OrderMealServiceImpl--findAllOrderMeal======>");
		return appDao.queryForEntityList("OrderMeal.findAllOrderMeal", orderMeal);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======OrderMealServiceImpl--queryOrderMealForPage======>");
		return appDao.queryForPage("OrderMeal.queryOrderMealForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======OrderMealServiceImpl--findAllMapOrderMeal======>");		
		return appDao.queryForMapList("OrderMeal.findAllMapOrderMeal", param);
	}
 }
  