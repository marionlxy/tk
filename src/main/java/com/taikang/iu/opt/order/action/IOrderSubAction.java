package com.taikang.iu.opt.order.action;

import java.util.List;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;


/**
  * IOrderSubAction
  */

public interface IOrderSubAction extends IBaseAction { 

	final String ACTION_ID = "orderSubAction"; 	
	/**
 	 * 获得子订单服务类型的且状态为实施中
 	 * @author t-zhaohan
 	 * @Credited 2015年4月21日 上午10:09:29
 	 * @see       [相关类/方法]
 	 * @return
 	 */
 	public List<Dto> findSubOrderIsTypeFT(Dto param);
	/**
 	 * 获得子订单用品类型的且状态为发货
 	 * @author t-zhaohan
 	 * @Credited 2015年4月21日 上午10:09:29
 	 * @see       [相关类/方法]
 	 * @return
 	 */
 	public List<Dto> findSubOrderIsTypeST(Dto param);
 	/**
	 * 修改确认收货
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 下午4:00:30
	 * @return
	 */
	public void updateFixedTimeSubApp(Dto param);
	/**
	 * 修改确认收货
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 下午4:00:30
	 * @return
	 */
	public void updateFixedTimeSubSev(Dto param);
	/**
	 * 获得所有的子订单根据orderID
	 * @author t-zhaohan
	 * @Credited 2015年5月15日 上午9:36:54
	 * @return
	 */
	public List<Dto> findSubOrderIsByOrderId(Dto param);
}
