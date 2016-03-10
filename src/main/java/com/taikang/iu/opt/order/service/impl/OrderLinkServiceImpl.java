package com.taikang.iu.opt.order.service.impl;
 
import com.taikang.iu.opt.order.service.IOrderLinkService;
import java.util.List;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.iu.opt.order.model.OrderLinkBO;
import org.springframework.stereotype.Service;
import com.taikang.udp.framework.core.service.impl.BaseServiceImpl;
 
  
/**
  * OrderLinkServiceImpl
  */
 @Service(IOrderLinkService.SERVICE_ID)
 public class OrderLinkServiceImpl extends BaseServiceImpl 
 implements IOrderLinkService<OrderLinkBO>  
  {
  	 	 	
 	/**
	  * 增加数据
	  */
	public void insertObject(OrderLinkBO orderLink) {
		logger.debug("<======OrderLinkServiceImpl--insertOrderLink======>");		
		appDao.insert("OrderLink.addOrderLink",orderLink);
	} 	
 	
 	/**
      * 修改数据
      */
	public void updateObject(OrderLinkBO orderLink) {
		logger.debug("<======OrderLinkServiceImpl--updateOrderLink======>");
		appDao.update("OrderLink.updateOrderLink",orderLink);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(OrderLinkBO orderLink) {
		logger.debug("<======OrderLinkServiceImpl--deleteOrderLink======>");
		appDao.delete("OrderLink.deleteOrderLink",orderLink);
	}
	
	/**
      * 查询数据
      */
	public OrderLinkBO findOne(OrderLinkBO orderLink) {
		logger.debug("<======OrderLinkServiceImpl--findOrderLink======>");
		
		OrderLinkBO orderLinkBackBO=appDao.queryOneObject("OrderLink.findOneOrderLink", orderLink);
		return orderLinkBackBO;		
	}
	
	/**
      * 查询所有数据
      */
	public List<OrderLinkBO> findAll(OrderLinkBO  orderLink) {
		logger.debug("<======OrderLinkServiceImpl--findAllOrderLink======>");
		return appDao.queryForEntityList("OrderLink.findAllOrderLink", orderLink);
	}
	
	
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage) {
		logger.debug("<======OrderLinkServiceImpl--queryOrderLinkForPage======>");
		return appDao.queryForPage("OrderLink.queryOrderLinkForPage", currentPage);
	}
		
	/**
      * 查询所有数据 ，重新组装为map
      */
	public List<Dto> findAllMap(Dto param){
		logger.debug("<======OrderLinkServiceImpl--findAllMapOrderLink======>");		
		return appDao.queryForMapList("OrderLink.findAllMapOrderLink", param);
	}
 }
  