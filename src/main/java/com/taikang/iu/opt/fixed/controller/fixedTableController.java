package com.taikang.iu.opt.fixed.controller;

import java.util.ArrayList;
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

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.fixed.action.IfixedAction;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * fixedController
  */
@Controller("fixedTableController")
@RequestMapping(value="/fixedTable")
public class fixedTableController  extends BaseController  {
		
	@Resource(name=IfixedAction.ACTION_ID)
	private IfixedAction fixedAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showfixedIndexPage() {
		return "fixed/fixedTableIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getFixedList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = fixedAction.queryForPage(page);

		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	//查看固定 套餐
	@RequestMapping("/viewMeal")
	public String showfixedMealViewPage(String mealId,Model model) {
		
		if(mealId!=null && !mealId.equals(""))
		{
			model.addAttribute("mealId",mealId );
			Dto param = new BaseDto();
			param.put("mealId", mealId);
			Dto list = fixedAction.findOne(param);
			String pictureUrl = list.getAsString("mealPicture");
				String url = CommonUtil.RELATION_UPLOAD_FILEPATH+pictureUrl;
				model.addAttribute("mealPicture",url);
		}
		
		return "fixed/fixedTableViewMeal"; 
	}
	//查询单个套餐
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getMealyId(@RequestParam("mealId")String mealId)
	{
		Dto param = new BaseDto();
		param.put("mealId", mealId);
		return fixedAction.findOne(param);
	}
	/**
	 * 查询信息列表
	 * @return 分页环节列表数据
	 */
	@RequestMapping("/linkList")
	@ResponseBody
	public Map<String,Object> getLinkList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		page.setRows(50);
		CurrentPage currentPage = fixedAction.queryForLinkPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 查询信息列表
	 * @return 分页环节列表数据
	 */
	@RequestMapping("/linkLists")
	@ResponseBody
	public Map<String,Object> getLinkLists(String mealId,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto dto = new BaseDto();
		dto.put("mealId", mealId);
		page.setParamObject(dto);
		page.setRows(50);
		CurrentPage currentPage = fixedAction.findEditLinkPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**
	 * 查询信息列表
	 * @return 分页环节列表数据
	 */
	@RequestMapping("/editLinkList")
	@ResponseBody
	public Map<String,Object> editLinkList(String mealId,String linkId,HttpServletRequest
			 request){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		CurrentPage page = new CurrentPage();
		param.put("mealId", mealId);
		page.setParamObject(param);
		page.setRows(50);
		CurrentPage currentPage = fixedAction.findEditLinkPage(page);
	
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**
	 * 查询信息列表
	 * @return 分页用品列表数据
	 */
	@RequestMapping("/applianceList")
	@ResponseBody
	public Map<String,Object> getApplianceList(String site,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new  BaseDto();
		param.put("site", site);
		page.setParamObject(param);
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = fixedAction.queryForAppliancePage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 查询信息列表
	 * @return 分页服务列表数据
	 */
	@RequestMapping("/serviceList")
	@ResponseBody
	public Map<String,Object> getServiceList(String site,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new  BaseDto();
		page.setParamObject(getParamAsDto(request));
		param.put("site", site);
		page.setParamObject(param);
		CurrentPage currentPage = fixedAction.queryForServicePage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**
	 * 查询信息列表
	 * @return 分页用品列表数据
	 */
	@RequestMapping("/applianceShowList")
	@ResponseBody
	public Map<String,Object> getApplianceShowList(String linkId,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		param.put("linkId", linkId);
		page.setParamObject(getParamAsDto(request));
		page.setParamObject(param);
		page.setRows(50);
		CurrentPage currentPage = fixedAction.queryForShowAppliancePage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	//查询所有站点服务
	@RequestMapping("/checkService")
	public String checkService(String flag,String linkId,Model model) {
		Dto param = new BaseDto();
		param.put("site", flag);
		List<fixedBO>  serviceList = fixedAction.findAllServerService(param);
		model.addAttribute("serviceList",serviceList);
		model.addAttribute("flag", flag);
		model.addAttribute("linkId", linkId);
		return "fixed/checkService";
	}
	
	//查询环节所选服务
	@RequestMapping("/viewServer")
	@ResponseBody
	public Map<String,Object> getviewServerList(String linkId,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		if(linkId.contains(",")){
			linkId= linkId.substring(0, linkId.indexOf(","));
			 param.put("linkId", linkId);
		}else{
			param.put("linkId", linkId);
		}
		page.setParamObject(getParamAsDto(request));
		page.setParamObject(param);
		CurrentPage currentPage = fixedAction.findOneService(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	//查询环节所选服务
	@RequestMapping("/viewServers")
	@ResponseBody
	public Map<String,Object> getviewServersList(String linkId,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		if(linkId.contains(",")){
			linkId= linkId.substring(0, linkId.indexOf(","));
			param.put("linkId", linkId);
		}else{
			param.put("linkId", linkId);
		}
		page.setParamObject(getParamAsDto(request));
		page.setParamObject(param);
		CurrentPage currentPage = fixedAction.findOneServices(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	
	@RequestMapping("/goMain")
	public String goMain() {
		return "fixed/fixedTableIndex"; 
	}
	
	@RequestMapping("/goMains")
	public String goMainS() {
		return "fixed/fixedTableIndex"; 
	}
	

	
	 
	
	
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOneMeal")
	@ResponseBody
	public Dto getfixedById(@RequestParam("mealId")String mealId)
	{
		Dto param = new BaseDto();
		param.put("mealId", mealId);
		return fixedAction.findOneMeal(param);
	}
	
	/**
	 * 获取一条记录详细信息，用来填充环节修改界面
	 * @return
	 */
	@RequestMapping("/getOneLink")
	@ResponseBody
	public Dto getOneLink(@RequestParam("linkId")String linkId)
	{
		Dto param = new BaseDto();
		param.put("linkId", linkId);
		return fixedAction.findOneLink(param);
	}
	
	
	
	
}

