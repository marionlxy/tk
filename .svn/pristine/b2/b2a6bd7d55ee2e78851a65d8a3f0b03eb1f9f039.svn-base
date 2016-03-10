package com.taikang.iu.opt.cemetery.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;

import javax.annotation.Resource;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.cemetery.action.ICemeteryParkAction;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * CemeteryParkController
  */
@Controller("cemeteryParkController")
@RequestMapping(value="/cemeteryPark")
public class CemeteryParkController  extends BaseController  {
		
	@Resource(name=ICemeteryParkAction.ACTION_ID)
	private ICemeteryParkAction cemeteryParkAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showCemeteryParkIndexPage() {
		return "cemeterypark/cemeteryparkIndex"; 
	}
	
	
	/**
	 * 打开查询详细页面    
	 * @return 页面地址
	 */
	@RequestMapping("/view")
	public String showCemeteryPark(String parkId,Model model) {
		if(parkId!=null && !parkId.equals("")) {
			model.addAttribute("parkId",parkId );
		}
		return "cemeterypark/showCemeterypark"; 
	}
	
	/**
	 * 打开新增园区页面    
	 * @return 页面地址
	 */
	@RequestMapping("/add")
	public String addCemeteryPark(String cemeteryId,Model model) {
		if(cemeteryId!=null && !cemeteryId.equals("")) {
			model.addAttribute("cemeteryId",cemeteryId );
		}
		return "cemeterypark/cemeteryparkAdd"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getCemeteryParkList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = cemeteryParkAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 查询指定Id的园区
	 * @return 分页列表数据
	 */
	@RequestMapping("/getAllCemeteryParkList")
	@ResponseBody
	public Map<String,Object> getAllCemeteryParkList(HttpServletRequest request,String cemeteryId,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		if (cemeteryId!=null && !cemeteryId.equals("")) {
			param.put("cemeteryId", cemeteryId);
		}
		page.setParamObject(param);
		CurrentPage currentPage = cemeteryParkAction.queryNewForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String showCemeteryParkEditPage(String parkId,Model model) {
		
		if(parkId!=null && !parkId.equals(""))
		{
			model.addAttribute("parkId",parkId );
		}
		
		return "cemeterypark/cemeteryparkEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getCemeteryParkById(@RequestParam("parkId")String parkId)
	{
		Dto param = new BaseDto();
		param.put("parkId", parkId);
		Dto cemeteryPark = cemeteryParkAction.findOne(param);
		//对textarea里的值进行处理
//		String parkContent = cemeteryPark.getAsString("parkContent");
//		if (parkContent != null && !"".equals(parkContent)) {
//			String newParkContent  = "";
//			for (int i = 0; i < parkContent.split("<br/>").length; i++) {
//				newParkContent = newParkContent + parkContent.split("<br/>")[i]+"\n";
//			}
//			cemeteryPark.put("parkContent", newParkContent);
//		}
		return cemeteryPark;
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveCemeteryParkInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("parkId") ==null ||"".equals(param.get("parkId")))
		{	
			try{
				
				//对textarea里的值进行处理
//				String parkContent = param.getAsString("parkContent");
//				if (parkContent != null && !"".equals(parkContent)) {
//					String newParkContent  = "";
//					for (int i = 0; i < parkContent.split("\n").length; i++) {
//						newParkContent = newParkContent + parkContent.split("\n")[i]+"<br/>";
//					}
//					param.put("parkContent", newParkContent);
//				}
				param.put("cemeteryId", request.getParameter("cemeteryId"));
				param.put("parkId", UUID.randomUUID().toString().replace("-", ""));
				param.put("createdBy", loginId);
				param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("delflag", "0"); // “0”代表“未删除”
				param.put("version", 1);
				cemeteryParkAction.insertObject(param);
				map.put(MESSAGE_INFO, "新增成功！");
				map.put(RTN_RESULT, "true");
				}catch(Exception e){
				map.put(MESSAGE_INFO, "新增失败！");
				map.put(RTN_RESULT, "false");
				}
				
		}
		else
		{	
			try{
				
				//对textarea里的值进行处理
//				String parkContent = param.getAsString("parkContent");
//				if (parkContent != null && !"".equals(parkContent)) {
//					String newParkContent  = "";
//					for (int i = 0; i < parkContent.split("\n").length; i++) {
//						newParkContent = newParkContent + parkContent.split("\n")[i]+"<br/>";
//					}
//					param.put("parkContent", newParkContent);
//				}
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", param.getAsInteger("version")+1);
				cemeteryParkAction.updateObject(param);
				map.put(MESSAGE_INFO, "更新成功！");
				map.put(RTN_RESULT, "true");
				}catch(Exception e){
				map.put(MESSAGE_INFO, "新增失败！");
				map.put(RTN_RESULT, "false");
				}
			
		}
		
		
		return map;
	}
	
	/**
	*删除一条或多条记录(逻辑)
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteCemeteryPark(@RequestParam("parkId") String parkId,@RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = new BaseDto();
		try {
			
			param.put("parkId", parkId);
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "1");
			param.put("version", Integer.parseInt(version)+1);
			cemeteryParkAction.delCemeteryPark(param);
			
			map.put(MESSAGE_INFO, "删除成功！");
			map.put(RTN_RESULT, "true");
		} catch (Exception e) {
			map.put(MESSAGE_INFO, "删除失败！");
			map.put(RTN_RESULT, "false");
		}
		
		return map;
	}
}

