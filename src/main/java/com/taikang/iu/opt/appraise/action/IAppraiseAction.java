package com.taikang.iu.opt.appraise.action;

import java.util.List;

import com.taikang.iu.opt.appraise.model.AppraiseBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;


/**
  * IAppraiseAction
  */

public interface IAppraiseAction extends IBaseAction { 

	final String ACTION_ID = "appraiseAction";
	/**
	 * 根据子订单的id查找对应的评价
	 * @param appraise
	 * @return
	 */
	public List<AppraiseBO> findUniquedAppraise(AppraiseBO appraise);
    /**
     * 添加评价信息同时修改服务状态，判断子订单的id
     * @author t-zhaohan
     * @Credited 2015年5月21日 下午2:19:48
     * @return
     */
	public void updateAppraiseAndOrderStatus(Dto param,String orderSevId,String subId);
	public Dto findOneApp(Dto param);
}
