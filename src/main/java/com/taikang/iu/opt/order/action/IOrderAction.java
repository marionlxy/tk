package com.taikang.iu.opt.order.action;

import java.util.List;

import com.taikang.iu.opt.order.model.OrderBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;


/**
  * IOrderAction
  */
public interface IOrderAction extends IBaseAction { 


	final String ACTION_ID = "orderAction";
	/**
	 * 根据订单查找详情
	 * @param orderId
	 * @return
	 * zhaohan
	 */
	public OrderBO findOrderByIdInfo(OrderBO order);
	/**
	 * 查看服务类型订单
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午2:06:41
	 * @see       [相关类/方法]
	 * @return
	 */
	public CurrentPage queryAllSevOrderPage(CurrentPage currentPage);
	/**
	 * 查看代理人及被推荐人的订单
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午2:06:41
	 * @return
	 */
	public CurrentPage queryReferenceOrderPage(CurrentPage currentPage);
	/**
	 * 查出订单类型为SD同时是已发货的用品
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 上午9:49:10
	 * @see       [相关类/方法]
	 * @return
	 */
	public  List<Dto> findOrderIsTypeSD(Dto param);
	/**
	 *订单列表信息
	 * @author t-pengyangyang
	 * @Credited 2015年7月31日 上午9:49:10
	 * @see       [相关类/方法]
	 * @return
	 */
	public List<OrderBO> findAllOrder(Dto param);
	/**
	 * 定时修改确认收货
	 * @author t-zhaohan
	 * @Credited 2015年4月21日 下午4:00:30
	 * @return
	 */
	public void updateFixedTimeApp(Dto param);
	/**
	 * 〈通过子订单编码查询商户电话〉
	 * @author t-lilong
	 * @Credited 2015年7月8日 上午11:07:27
	 * @return
	 */
	public Dto findOneSeller(Dto param);
	/**
	 * 
	 * 〈通过订单Id查询商户电话〉
	 * @author t-lilong
	 * @Credited 2015年7月8日 下午2:31:58
	 * @return
	 */
	public Dto findOneApp(Dto param);
}