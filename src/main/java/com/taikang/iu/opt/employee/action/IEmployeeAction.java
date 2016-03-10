package com.taikang.iu.opt.employee.action;

import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.List;

import com.taikang.iu.opt.employee.model.EmployeeBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.core.action.IBaseAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;


/**
  * IEmployeeAction
  */

public interface IEmployeeAction extends IBaseAction { 

	final String ACTION_ID = "employeeAction";

	public List<EmployeeBO> finAllEmp(Dto param); 	
	/**
	 * 查询当前登录人同一站点的天使
	 */
	
	public List<EmployeeBO> finAllEmpTS(Dto param) ;
	/**
     * 查询天使
     */
	public List<EmployeeBO> finAllEmpT(Dto param);

	public CurrentPage queryAnglesForPage(CurrentPage page);

	public CurrentPage queryEmployeesForPage(CurrentPage page);

	public void saveEmployeeManage(Dto param);

	public void updateEmployeeManage(Dto param);

	public List<Dto> queryAllEmployeeByCondition(Dto param);
}
