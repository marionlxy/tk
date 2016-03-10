package com.taikang.iu.opt.single.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.single.action.ISingleAction;
import com.taikang.iu.opt.single.model.SingleBO;


/**
  * SingleController
  */
@Controller("singleTableController")
@RequestMapping(value="/singleTable")
public class SingleTableController  extends BaseController  {
		
	@Resource(name=ISingleAction.ACTION_ID)
	private ISingleAction singleAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showSingleIndexPage() {
		return "single/singleTableIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getSingleList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = singleAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/servNumList")
	@ResponseBody
	public Map<String,Object> getservNumList(String serviceId){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		param.put("serviceId", serviceId);
		CurrentPage page = new CurrentPage();
		page.setParamObject(param);
		CurrentPage currentPage = singleAction.queryForServPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/servNumLists")
	@ResponseBody
	public Map<String,Object> getservNumLists(String sellerType,String serviceId,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		param.put("sellerType", sellerType);
		page.setParamObject(param);
		CurrentPage currentPage = singleAction.queryForServListPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	
	
	/**
	 * 打开新增页面
	 * @return   
	 * String
	 */
	@RequestMapping("/add")
	public String oneRole() {
		return "single/singleAdd"; 
	}
	
	/**
	 * 打开新增服务商页面
	 * @return   
	 * String
	 */
	@RequestMapping("/addFacilitator")
	public String addFacilitator(String serviceId,Model model) {
		Dto param = new BaseDto();
		param.put("sellerType", '2');
		List<SingleBO>  sellerServiceList = singleAction.findAllSellerService(param);
		model.addAttribute("sellerServiceList",sellerServiceList);
		model.addAttribute("serviceId", serviceId);
		return "single/singleAddFacilitator"; 
	}
	

	/**
	 * 打开修改页面
	 * @return
	 * String
	 */
	@RequestMapping("edit")
	public String showSingleEditPage(String serviceId,Model model) {
		
		if(serviceId!=null && !serviceId.equals(""))
		{
			model.addAttribute("serviceId",serviceId );
		}
		
		return "single/singleEdit"; 
	}
	
	
	/**
	 * 单项服务上架
	 * 
	 * 
	 */
	@RequestMapping("/shelves")
	public String shelvesEditPage(String serviceId,Model model) {
		
		if(serviceId!=null && !serviceId.equals(""))
		{
			model.addAttribute("serviceId",serviceId );
		}
		
		return "single/singleShelves"; 
	}
	
	/**
	 * 单项服务下架
	 * 
	 * 
	 */
	@RequestMapping("/soldOut")
	public String soldOutEditPage(String serviceId,Model model) {
		
		if(serviceId!=null && !serviceId.equals(""))
		{
			model.addAttribute("serviceId",serviceId );
		}
		
		return "single/singleSoldOut"; 
	}
	
	
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@RequestMapping("/view")
	public String showSingleViewPage(String serviceId,Model model) {
		
		if(serviceId!=null && !serviceId.equals(""))
		{
			model.addAttribute("serviceId",serviceId );
			Dto param = new BaseDto();
			param.put("serviceId", serviceId);
			Dto list = singleAction.findOne(param);
			String pictureUrl = list.getAsString("pictureUrl");
			String[] split = pictureUrl.split(",");
			List urlList = new ArrayList();
			
			for (int i = 0; i < split.length; i++) {
				Map map =new BaseDto();
				String url = CommonUtil.RELATION_UPLOAD_FILEPATH+split[i];
				map.put("url", url);
//				String url = "/upload/"+split[i];
				urlList.add(map);
				
			}
			model.addAttribute("urlList",urlList);
		}
		
		return "single/singleView"; 
	}

	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getSingleById(@RequestParam("serviceId")String serviceId)
	{
		Dto param = new BaseDto();
		param.put("serviceId", serviceId);
		return singleAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveSingleInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("serviceId") ==null ||"".equals(param.get("serviceId")))
		{
			param.put("serviceId", UUID.randomUUID().toString().replace("-", ""));
			param.put("serviceState", "0"); // “1”代表“使用中”
			param.put("serviceNum", BusinessSeqGenerator.getInstance("SERVICE_NUM").nextId()); 
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			singleAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			singleAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	
	
	/**
	 * 保存新增服务商记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveSellService")
	@ResponseBody
	private Map<String,String> saveSellService(HttpServletRequest request,String serviceId,String sellerId)
	{	
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto params = new BaseDto();
		params.put("sellerId", sellerId);
		Dto oneSeller = singleAction.findOneSeller(params);
		Dto param = getParamAsDto(request);
			param.put("relationId", UUID.randomUUID().toString().replace("-", ""));
			param.put("serviceId", serviceId.substring(0, serviceId.length()-1));
			param.put("sellerId", sellerId); 
			param.put("settlePrice", param.get("settlePrice")); 
			param.put("sellerName", oneSeller.get("sellerName")); 
			param.put("sellerCode", oneSeller.get("sellerCode")); 
			param.put("sellerType", 2); 
			param.put("serviceMsg", param.get("serviceMsg")); 
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			singleAction.insertSellerService(param);
			map.put(MESSAGE_INFO, "新增成功！");
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	 * 保存上架服务的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveShelves")
	@ResponseBody
	private Map<String,String> saveSingleShelvesInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("serviceId") !=null ||!"".equals(param.get("serviceId")))
		{
			if(param.get("serviceState").equals("1")){
				map.put(MESSAGE_INFO, "此商品已上架！");
				map.put(RTN_RESULT, "false");
			}else{
				param.put("serviceState", "1"); // “1”代表“已上架”
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", Integer.parseInt(param.get("version").toString())+1);
				singleAction.updateObject(param);
				map.put(MESSAGE_INFO, "上架成功！");
			}
			map.put(RTN_RESULT, "true");
		}
		return map;
	}
	
	
	/**
	 * 保存下架服务的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveSoldOut")
	@ResponseBody
	private Map<String,String> saveSingleSoldOutInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("serviceId") !=null ||!"".equals(param.get("serviceId")))
		{
			if(param.get("serviceState").equals("0")){
				map.put(MESSAGE_INFO, "此商品未上架！");
				map.put(RTN_RESULT, "false");
			}else{
				param.put("serviceState", "0"); // “1”代表“已上架”
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", Integer.parseInt(param.get("version").toString())+1);
				singleAction.updateObject(param);
				map.put(MESSAGE_INFO, "下架成功！");
				
			}
			map.put(RTN_RESULT, "true");
		}
		
		return map;
	}
	
	/**
	 * 服务商列表
	 */
	@RequestMapping("/servNum")
	public String showSingleServNumPage(String serviceId,Model model) {
		
		if(serviceId!=null && !serviceId.equals(""))
		{
			model.addAttribute("serviceId",serviceId );
		}
		
		return "single/singleServNum"; 
	}
	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteSingle(@RequestParam("serviceId") String serviceId, @RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("serviceId", serviceId);
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("delflag", "1"); // “1”代表“已删除”
		param.put("version", Integer.parseInt(version)+1);
		singleAction.updateObject(param);
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 *删除一条或多条记录
	 */
	@RequestMapping(value="/delSellerService")
	@ResponseBody
	public Map<String, String> delSellerService(@RequestParam("relationId") String relationId, @RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("relationId", relationId);
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		param.put("delflag", "1"); // “1”代表“已删除”
		param.put("version", Integer.parseInt(version)+1);
		singleAction.updateSellerService(param);
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 订单指派服务商显服务商列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/orderSevList")
	@ResponseBody
	public Map<String,Object> getOrderSevList(String serviceId, HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		request.setAttribute("serviceId", serviceId);
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = singleAction.queryForServPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	
}

