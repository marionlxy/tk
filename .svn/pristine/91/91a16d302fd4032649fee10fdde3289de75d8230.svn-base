package com.taikang.iu.opt.order.service;

import java.util.List;

import com.taikang.iu.opt.order.model.OrderAppBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IOrderAppService
  */
 
 public interface IOrderAppService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "orderAppService";
 	/**查询用品订单的分页数据
    * （通过订单的ID）
    */
	public CurrentPage queryOrderIdForPage(CurrentPage currentPage);
	public List<OrderAppBO> findAllOrderApp(OrderAppBO orderAppBO);  	
	/**
	 * zhaohan
	 * 查询用品商订单
	 * @param currentPage
	 * @return
	 */
	public CurrentPage queryfindAppliancePage(CurrentPage currentPage);
	/**
	 * 根据id查找子订单信息
	 * @param orderApp
	 * @return
	 * zhaohan
	 */
	public OrderAppBO findOrderAppByIdInfo(OrderAppBO orderApp);
	/**
	 * 获得所有的用品
 	 * @author t-zhaohan
 	 * @Credited 2015年4月21日 上午10:09:29
 	 * @return
 	 */
 	public List<Dto> findAllAppOrderList(Dto param);
 }
 
 
 