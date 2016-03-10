package com.taikang.iu.opt.order.action;

import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;


/**
  * IOrderSevAction
  */

public interface IOrderSevAction extends IBaseAction { 

	final String ACTION_ID = "orderSevAction";

	public CurrentPage queryOrderSevForPage(CurrentPage page);

	public void saveSev(String orderId,String linkId, String serviceId, String sellerCode,String sellerName);

	public void subOrderSave(String orderId, String orderType); 	
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
}
