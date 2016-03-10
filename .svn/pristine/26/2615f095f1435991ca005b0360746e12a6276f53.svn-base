package com.taikang.iu.opt.order.action.impl;


import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.iu.opt.order.service.IOrderLinkService;
import javax.annotation.Resource;
import java.util.List;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.opt.order.model.OrderLinkBO;
import org.springframework.stereotype.Service;
import com.taikang.iu.opt.order.action.IOrderLinkAction;

/**
  * OrderLinkAction
  */
  @Service(IOrderLinkAction.ACTION_ID)
public class OrderLinkActionImpl extends BaseActionImpl 
  implements IOrderLinkAction {

    /**
      * 注入service
      */
    @Resource(name=IOrderLinkService.SERVICE_ID)
	private IOrderLinkService<OrderLinkBO> orderLinkService;	
	
	/**
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======OrderLinkAction--addOrderLink======>");
		
		OrderLinkBO orderLinkBO = BaseDto.toModel(OrderLinkBO.class , param);
		orderLinkService.insertObject(orderLinkBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======OrderLinkAction--updateOrderLink======>");
		
		OrderLinkBO orderLinkBO = BaseDto.toModel(OrderLinkBO.class , param);
		orderLinkService.updateObject(orderLinkBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======OrderLinkAction--deleteOrderLink======>");
		
		OrderLinkBO orderLinkBO = BaseDto.toModel(OrderLinkBO.class , param);
		orderLinkService.deleteObject(orderLinkBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======OrderLinkAction--findOneOrderLink======>");
		
		OrderLinkBO orderLinkBO = BaseDto.toModel(OrderLinkBO.class , param);
		return orderLinkService.findOne(orderLinkBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======OrderLinkAction--findAllOrderLink======>");
				
		return orderLinkService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======OrderLinkAction--queryOrderLinkForPage======>");
		
		return orderLinkService.queryForPage(currentPage);
	}	
}
