package com.taikang.iu.opt.employee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.opt.employee.action.IEmployeeAction;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;

/**
 * EmployeeController
 */
@Controller("employeeSecondAddController")
@RequestMapping(value = "/employeeSecondAddController")
public class EmployeeSecondAddController extends BaseController {
	@Resource(name = IEmployeeAction.ACTION_ID)
	private IEmployeeAction employeeAction;
	
	
	
	@RequestMapping("")
	public String showAngelIndexPage() {
		return "employee/angelIndex"; 
	}

	/**
	 * 分页查询天使信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/listAngle")
	@ResponseBody
	public Map<String,Object> getAngleList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = employeeAction.queryAnglesForPage(page);//queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
}
