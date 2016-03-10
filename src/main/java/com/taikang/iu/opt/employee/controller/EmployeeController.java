package com.taikang.iu.opt.employee.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.opt.employee.action.IEmployeeAction;


/**
  * EmployeeController
  */
@Controller("employeeController")
@RequestMapping(value="/employee")
public class EmployeeController  extends BaseController  {
		
	@Resource(name=IEmployeeAction.ACTION_ID)
	private IEmployeeAction employeeAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showEmployeeIndexPage() {
		return "employee/employeeIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getEmployeeList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = employeeAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String showEmployeeEditPage(@RequestParam("employeeCode") String employeeCode,Model model) {
		if(employeeCode != null ){
			model.addAttribute("employeeCode", employeeCode);
		}
		return "employee/employeeEdit"; 
	}
	
	
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("/view")
	public String showEmployeeViewPage(@RequestParam("employeeCode") String employeeCode,Model model) {
		if(employeeCode != null ){
			model.addAttribute("employeeCode", employeeCode);
		}
		return "employee/employeeView"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getEmployeeById(@RequestParam("employeeCode")String employeeCode)
	{
		Dto param = new BaseDto();
		param.put("employeeCode", employeeCode);
		return employeeAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveEmployeeInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("version",Integer.parseInt(param.get("version").toString())+1 );
		if(param.get("employeeCode") !=null || !"".equals(param.get("employeeCode")))
		{
			employeeAction.updateObject(param);
			map.put(MESSAGE_INFO, "修改成功！");
			map.put(RTN_RESULT, "true");
		}else{
			map.put(MESSAGE_INFO, "修改失败！");	
			map.put(RTN_RESULT, "false");
		}
		
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteEmployee(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		employeeAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 打开天使的个人信息维护页面
	 * @return
	 */
	@RequestMapping("/editAngel")
	public String showEmployeeAnePage(Model model) {
		 LoginUser user = UserUtils.getUser();
		 String loginUser =String.valueOf(user.getUserId());
		 if(loginUser != null ){
			 model.addAttribute("userId",loginUser);
		 }
		return "employee/angelEdit"; 
	}
	
	
	/**
	 * 获取一条天使详细信息，用来填充修改界面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getOneAngel")
	@ResponseBody
	public Dto getEmployeeUserId(@RequestParam("userId")String userId)
	{
		Dto param = new BaseDto();
		param.put("userId", userId);
		return employeeAction.findOne(param);
	}
	
	
	
}

