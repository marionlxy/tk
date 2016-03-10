package com.taikang.iu.opt.order.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import javax.annotation.Resource;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.order.action.IOrderMealAction;
import com.taikang.iu.opt.order.service.IOrderMealService;
import com.taikang.iu.opt.order.model.OrderMealBO;

/**
  * OrderMealAction
  */
  @Service(IOrderMealAction.ACTION_ID)
public class OrderMealActionImpl extends BaseActionImpl 
  implements IOrderMealAction {

    /**
      * 注入service
      */
    @Resource(name=IOrderMealService.SERVICE_ID)
	private IOrderMealService<OrderMealBO> orderMealService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======OrderMealAction--addOrderMeal======>");
		
		OrderMealBO orderMealBO = BaseDto.toModel(OrderMealBO.class , param);
		orderMealService.insertObject(orderMealBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======OrderMealAction--updateOrderMeal======>");
		
		OrderMealBO orderMealBO = BaseDto.toModel(OrderMealBO.class , param);
		orderMealService.updateObject(orderMealBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======OrderMealAction--deleteOrderMeal======>");
		
		OrderMealBO orderMealBO = BaseDto.toModel(OrderMealBO.class , param);
		orderMealService.deleteObject(orderMealBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======OrderMealAction--findOneOrderMeal======>");
		
		OrderMealBO orderMealBO = BaseDto.toModel(OrderMealBO.class , param);
		return orderMealService.findOne(orderMealBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======OrderMealAction--findAllOrderMeal======>");
				
		return orderMealService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======OrderMealAction--queryOrderMealForPage======>");
		
		return orderMealService.queryForPage(currentPage);
	}	
}
