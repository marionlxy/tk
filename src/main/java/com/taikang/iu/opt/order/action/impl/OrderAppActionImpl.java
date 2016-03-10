package com.taikang.iu.opt.order.action.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.order.action.IOrderAppAction;
import com.taikang.iu.opt.order.model.OrderAppBO;
import com.taikang.iu.opt.order.model.OrderBO;
import com.taikang.iu.opt.order.service.IOrderAppService;
import com.taikang.iu.opt.order.service.IOrderService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;

/**
  * OrderAppAction
  */
  @Service(IOrderAppAction.ACTION_ID)
public class OrderAppActionImpl extends BaseActionImpl 
  implements IOrderAppAction {

    /**
      * 注入service
      */
    @Resource(name=IOrderAppService.SERVICE_ID)
	private IOrderAppService<OrderAppBO> orderAppService;	
    /**
     * 注入service
     */
    @Resource(name=IOrderService.SERVICE_ID)
	private IOrderService<OrderBO> orderService;
    /**
     * 查询用品商户的所有订单
     * zhaohan
     */
	 public CurrentPage queryfindAppliancePage(CurrentPage currentPage) {
		return orderAppService.queryfindAppliancePage(currentPage);
	 }
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======OrderAppAction--addOrderApp======>");
		
		OrderAppBO orderAppBO = BaseDto.toModel(OrderAppBO.class , param);
		orderAppService.insertObject(orderAppBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======OrderAppAction--updateOrderApp======>");
		
		OrderAppBO orderAppBO = BaseDto.toModel(OrderAppBO.class , param);
		orderAppService.updateObject(orderAppBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======OrderAppAction--deleteOrderApp======>");
		
		OrderAppBO orderAppBO = BaseDto.toModel(OrderAppBO.class , param);
		orderAppService.deleteObject(orderAppBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======OrderAppAction--findOneOrderApp======>");
		
		OrderAppBO orderAppBO = BaseDto.toModel(OrderAppBO.class , param);
		return orderAppService.findOne(orderAppBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======OrderAppAction--findAllOrderApp======>");
				
		return orderAppService.findAllMap(param);
	} 
	
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======OrderAppAction--queryOrderAppForPage======>");
		
		return orderAppService.queryForPage(currentPage);
	}
	/**
	 * 根据id查找订单详细
	 */
	public OrderAppBO findOrderAppByIdInfo(OrderAppBO orderApp) {
		logger.debug("<======OrderAppAction--findOrderAppByIdInfo======>");
		return orderAppService.findOrderAppByIdInfo(orderApp);
	}
	/**
	 * 修改订单状态
	 */
	public void updateOrderApp(Dto param) {
        logger.debug("<======OrderAppAction--addOrderApp======>");
     	param.put("orderState", 05);
		param.put("appState", 05);
		OrderAppBO orderAppBO = BaseDto.toModel(OrderAppBO.class , param);
		orderAppService.updateObject(orderAppBO);
		OrderBO orderBO = BaseDto.toModel(OrderBO.class , param);
		orderService.updateObject(orderBO);
	}
	
	/**
	 * 查询用品订单的分页数据
     * （通过订单的ID）
	 */
	
	public CurrentPage queryOrderIdForPage(CurrentPage currentPage){
		logger.debug("<======OrderAppAction--queryOrderAppForPage======>");
		
		return orderAppService.queryOrderIdForPage(currentPage);
	}
	
	
}
