package com.taikang.iu.opt.order.action;

import com.taikang.iu.opt.order.model.OrderAppBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;



/**
  * IOrderAppAction
  */

public interface IOrderAppAction extends IBaseAction { 

	final String ACTION_ID = "orderAppAction";

	
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
	 * 修改订单状态
	 * @param param
	 */
	public void updateOrderApp(Dto param);
	public CurrentPage queryOrderIdForPage(CurrentPage page); 	
}
