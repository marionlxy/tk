package com.taikang.iu.opt.order.service;

import java.util.List;

import com.taikang.iu.opt.order.model.OrderSevBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.service.IBaseService;

/**
  * IOrderSevService
  */
 
 public interface IOrderSevService<T> extends IBaseService<T>{
 
 	final String SERVICE_ID = "orderSevService";

	public CurrentPage queryOrderSevForPage(CurrentPage currentPage);

	public List<OrderSevBO> findAllOrderSev(OrderSevBO param);

	/**
	 * 查询服务商商订单
	 * @param currentPage
	 * @return
	 * zhaohan
	 */
	public CurrentPage queryfindSevOrderPage(CurrentPage currentPage);
	/**
	 * 第三方回访服务订单查看
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午1:33:09
	 * @see       [相关类/方法]
	 * @return
	 */
	public CurrentPage queryVitisSevOrderPage(CurrentPage currentPage);
	/**
	 * 第三方回访服务列表
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午1:33:09
	 * @see       [相关类/方法]
	 * @return
	 */
	public CurrentPage queryVitisSevList(CurrentPage currentPage);
	public List<Dto> findSubOrderIsBysubId(Dto param);
 }
 
 
 