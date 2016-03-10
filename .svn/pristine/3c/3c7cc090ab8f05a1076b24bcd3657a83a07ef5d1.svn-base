package com.taikang.iu.opt.operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.opt.employee.action.IEmployeeAction;
import com.taikang.iu.opt.employee.action.impl.EmployeeActionImpl;
import com.taikang.iu.opt.operation.action.IoperationAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IUserRoleAction;
import com.taikang.udp.sys.action.impl.UserActionImpl;
import com.taikang.udp.sys.model.RoleBO;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * operationController
  */
@Controller("operationController")
@RequestMapping(value="/operation")
public class operationController  extends BaseController  {
		
	@Resource(name=IoperationAction.ACTION_ID)
	private IoperationAction operationAction;
	/**
	 * 注入用户角色service
	 */
	@Resource(name=IUserRoleAction.ACTION_ID)
	private IUserRoleAction userRoleAction;
	
	@Resource(name=IEmployeeAction.ACTION_ID)
	private IEmployeeAction employeeAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showComplainIndexPage() {
		return "operation/operationIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getComplainList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = new BaseDto();
		Dto params = new BaseDto();
		params.put("userId", loginId);
		params.put("roleId", "2104");
		Dto userRole = userRoleAction.findOne(params);//查询是否是运营经理
		Dto  dto = getParamAsDto(request);
		if(userRole.isEmpty()){
			param.put("userId", loginId);
			Dto loginUser = employeeAction.findOne(param);//通过用户ID查询该用户站点
			String site = loginUser.getAsString("SITE");
			dto.put("site", site);
		}
		page.setParamObject(dto);
		CurrentPage currentPage = operationAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	
	
	@RequestMapping("/edit")
	public String showComplainEditPage(String complainId,Model model) {
		
		if(complainId!=null && !complainId.equals(""))
		{
			model.addAttribute("complainId",complainId );
		}
		
		return "operation/operationEdit";
	}
	
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@RequestMapping("/view")
	public String showComplainViewPage(@RequestParam("complainId") String complainId,Model model) {
		
		if(complainId!=null && !complainId.equals(""))
		{
			model.addAttribute("complainId",complainId );
		}
		
		return "operation/operationView"; 
	}
	
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getComplainById(@RequestParam("complainId") String complainId)
	{
		Dto param = new BaseDto();
		param.put("complainId", complainId);
		Dto dto = operationAction.findOne(param);
		
		return dto;
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveComplainInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("complainId") ==null ||"".equals(param.get("complainId")))
		{
			param.put("complainId", UUID.randomUUID().toString().replace("-", ""));
			param.put("complainType", param.get("complainType")); // “1”代表“使用中”
			param.put("complainState", param.get("complainState")); // “1”代表“使用中”
//			param.put("complainMsg", "1"); // “1”代表“使用中”
//			param.put("complainState", "1");
//			param.put("complainTel", "1"); // “1”代表“使用中”
			param.put("complainNum", "TS"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+BusinessSeqGenerator.getInstance("COMPLAIN_CODE").nextId()); 
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			operationAction.insertObject(param);
			map.put(MESSAGE_INFO, "添加成功！");
		}
		else
		{
			param.put("complainState","0"); // “1”代表“使用中”
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			operationAction.updateObject(param);
			map.put(MESSAGE_INFO, "修改成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteComplain(@RequestParam("complainId") String complainId) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(complainId);
		Dto param = new BaseDto();
		param.put("complainId", complainId);
		//complainAction.deleteObject(param);
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("delflag", "1"); // “1”代表“已删除”
		operationAction.updateObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

