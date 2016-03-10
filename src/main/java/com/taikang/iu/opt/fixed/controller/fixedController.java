package com.taikang.iu.opt.fixed.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.com.Constants;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taikang.iu.biz.appliance.action.IApplianceAction;
import com.taikang.iu.opt.fixed.action.IfixedAction;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IFileloadAction;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * fixedController
  */
@Controller("fixedController")
@RequestMapping(value="/fixed")
public class fixedController  extends BaseController  {
		
	@Resource(name=IfixedAction.ACTION_ID)
	private IfixedAction fixedAction;
	
	@Resource(name=IApplianceAction.ACTION_ID)
	private IApplianceAction applianceAction;
	
	@Resource(name = "fileloadAction")
	private IFileloadAction fileloadAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showfixedIndexPage() {
		return "fixed/fixedIndex"; 
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
	//修改固定 套餐
	@RequestMapping("/editMeal")
	public String showfixedMealEditPage(String mealId,Model model) {
		
		if(mealId!=null && !mealId.equals(""))
		{
			model.addAttribute("mealId",mealId );
		}
		
		return "fixed/fixedEditMeal"; 
	}
	/**
	*删除固定套餐
	*/
	@RequestMapping(value="/delMeal")
	@ResponseBody
	public Map<String, String> deleteMeal(@RequestParam("mealId") String mealId, @RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = new BaseDto();
		Dto params = new BaseDto();
		Dto para = new BaseDto();
		Dto serverParam = new BaseDto();
		Dto linkParam = new BaseDto();
		param.put("mealId", mealId);
		List <fixedBO> list = fixedAction.findDelLink(param);
		for (int i = 0; i < list.size(); i++) {
		String linkId =	list.get(i).getLinkId();
		params.put("linkId", linkId);
		List <fixedBO> applianceList = fixedAction.findApplianceList(params);
		if(applianceList.size()!=0){
			for (int j = 0; j < applianceList.size(); j++) {
				Dto applianceParam = new BaseDto();
				applianceParam.put("applianceId", applianceList.get(j).getApplianceId());
				applianceParam.put("linkId", linkId);
				List <fixedBO> list1 = fixedAction.findRelation(applianceParam);
				para.put("relationId", list1.get(0).getRelationId());
				para.put("delflag", "1"); // “1”代表“已上架”
				para.put("modifiedBy", loginId);
				para.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				fixedAction.updateAppliance(para);
			}
		}
		List <fixedBO> serviceList = fixedAction.findFixService(params);
		if(serviceList.size()!=0){
			serverParam.put("relationId", serviceList.get(0).getRelationId());
			serverParam.put("delflag", "1"); // “1”代表“已上架”
			serverParam.put("modifiedBy", loginId);
			serverParam.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			fixedAction.updateServer(serverParam);
		}
		params.put("delflag", "1"); // “1”代表“已删除”
		params.put("modifiedBy", loginId);
		params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		fixedAction.updateLink(params);
		}
		param.put("delflag", "1"); // “1”代表“已删除”
		param.put("modifiedBy", loginId);
		param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		fixedAction.updateObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
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
		
		return "fixed/fixedViewMeal"; 
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
		page.setParamObject(getParamAsDto(request));
		param.put("serviceSite", site);
		page.setParamObject(param);
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
	 * @return 初始化数据
	 */
	@RequestMapping("/ListEmpty")
	@ResponseBody
	public Map<String,Object> getServiceListEmpty(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rows", 0);
		map.put("total", 0);
		
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
	/**
	 * 查询信息列表
	 * @return 分页用品列表数据
	 */
	@RequestMapping("/applianceShowLists")
	@ResponseBody
	public Map<String,Object> getApplianceShowLists(String linkId,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", 0);
		map.put("total", 0);
		
		return map;
	}

	/**
	 * 打开新增套餐页面
	 * @return   
	 * String
	 */
	@RequestMapping("/addFixed")
	public String addFixed() throws Exception{
		Dto params = new BaseDto();
		Dto param = new BaseDto();
		Dto para = new BaseDto();
		Dto serverParam = new BaseDto();
		Dto linkParam = new BaseDto();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
			param.put("version", "1");
			List <fixedBO> list = fixedAction.findLink(param);
			if(list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					String linkId =	list.get(i).getLinkId();
					params.put("linkId", linkId);
					List <fixedBO> serviceList = fixedAction.findFixServices(params);
					if(serviceList.size()!=0){
						serverParam.put("relationId", serviceList.get(0).getRelationId());
						fixedAction.delFixService(serverParam);
					}
					List <fixedBO> applianceList = fixedAction.findDelApplianceLists(params);
					if(applianceList.size()!=0){
						for (int j = 0; j < applianceList.size(); j++) {
							Dto applianceParam = new BaseDto();
							applianceParam.put("applianceId", applianceList.get(j).getApplianceId());
							applianceParam.put("linkId", linkId);
							List <fixedBO> list1 = fixedAction.findDelApplianceLists(params);
							for (int k = 0; k < list1.size(); k++) {
								para.put("relationId", list1.get(k).getRelationId());
								fixedAction.delAppliance(para);
							}
						}
					}
					fixedAction.deleteLink(params);
				}
			}
		
		
	
		return "fixed/fixedAdd"; 
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

		map.put("rows", 0);
		map.put("total", 0);
		
		return map;
	}
	
	//打开选中用品页面
	@RequestMapping("/checkAppliance")
	public String checkAppliance(String flag,String linkId,Model model,CurrentPage currentPage) {
		Dto param = new BaseDto();
		param.put("serviceSite", flag);
		param.put("delflag", "0");
		param.put("ismarketable", "2");
//		currentPage.setParamObject(param);
//		currentPage.setRows(60);
//		List<Dto>  applianceList = applianceAction.queryForPage(currentPage);
		List<fixedBO>  applianceList = fixedAction.findAllAppliance(param);
		model.addAttribute("applianceList",applianceList);
		model.addAttribute("flag", flag);
		model.addAttribute("linkId", linkId);
		return "fixed/checkAppliance";
	}
	
	/**
	 * 打开修改新增环节页面
	 * @return   
	 * String
	 */

	@RequestMapping("/addLink")
	public String addLinks(String site,String mealId,Model model) {
		if(mealId!=null && !mealId.equals(""))
		{
			model.addAttribute("mealId",mealId );
		}
		return "fixed/fixedAddLink"; 
	}
	/**
	 * 打开新增环节页面
	 * @return   
	 * String
	 */
	
	@RequestMapping("/addLinks")
	public String addLink(String site) {
		return "fixed/fixedAddLinks"; 
	}
	
//	@RequestMapping("/addImg")
//	@ResponseBody
//	public void addimg(HttpServletRequest request) throws TKCheckedException {
//		fixedAction.addimg(request);
//	}
	
	
	/**
	 * 添加套餐
	 * @throws TKCheckedException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveMeal")
	@ResponseBody
	public Map<String, String> saveMeal(String mealId,HttpServletRequest request)  {
		Map<String,String> map=new HashMap<String,String>();
		List <fixedBO> list = new ArrayList();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		String pictureUrl = null;
		Dto param = getParamAsDto(request);
		Dto params = new BaseDto();
		Dto paras = new BaseDto();
		Dto parss = new BaseDto();
		Dto para = new BaseDto();
		if(null==param.get("mealId")||"".equals(param.get("mealId"))){
			String meaId = UUID.randomUUID().toString().replace("-", "");
			params.put("mealId",meaId );
			params.put("createdBy", loginId);
			params.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			params.put("delflag", "0"); // “0”代表“未删除”
			params.put("version", 1);
			params.put("mealName", param.get("mealName"));
			params.put("state", "1");
//			params.put("mealType", param.get("mealType"));
			params.put("mealPrice", param.get("mealPrice"));
			params.put("site", param.get("site"));
			params.put("mealContent", param.get("mealContent"));
			fixedAction.insertObject(params);
			para.put("mealId", meaId);
			paras.put("delflag", 0);
			list = fixedAction.findLink(paras);
			for (int i = 0; i < list.size(); i++) {
				para.put("linkId", list.get(i).getLinkId());
				fixedAction.updateLink(para);
			}
			map.put(MESSAGE_INFO, "添加套餐成功！");
			map.put("sId", meaId);
		}else{
			
			if(mealId.contains(",")){
				mealId=mealId.substring(0, mealId.indexOf(","));
			}
			parss.put("mealName", param.get("mealName"));
			parss.put("mealId", mealId);
//			parss.put("mealType", param.get("mealType"));
			parss.put("mealPrice", param.get("mealPrice"));
			parss.put("mealContent", param.get("mealContent"));
			fixedAction.updateObject(parss);
			paras.put("delflag", 0);
			list = fixedAction.findLink(paras);
			if(list.size()>0){
				para.put("mealId", mealId);
				for (int i = 0; i < list.size(); i++) {
					para.put("linkId", list.get(i).getLinkId());
					fixedAction.updateLink(para);
				}
			}
			map.put(MESSAGE_INFO, "更新成功！");
		}
		
		map.put(RTN_RESULT, "true");
		return map;
	}
	
	
	/**
	 * 修改固定套餐
	 * @param mealId
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveMeals")
	public boolean saveMeals(String mealId,HttpServletRequest request) {
		Map<String,String> map=new HashMap<String,String>();
		List <fixedBO> list = new ArrayList();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		Dto paras = new BaseDto();
		Dto parss = new BaseDto();
		Dto para = new BaseDto();
	
			parss.put("mealName", param.get("mealName"));
			if(mealId.contains(",")){
				mealId=mealId.substring(0, mealId.indexOf(","));
			}
			parss.put("mealId", mealId);
//			parss.put("mealType", param.get("mealType"));
			parss.put("mealPrice", param.get("mealPrice"));
			parss.put("mealContent", param.get("mealContent"));

			fixedAction.updateObject(parss);
			paras.put("delflag", 0);
			list = fixedAction.findLink(paras);
			if(list.size()>0){
				para.put("mealId", mealId);
				for (int i = 0; i < list.size(); i++) {
					para.put("linkId", list.get(i).getLinkId());
					fixedAction.updateLink(para);
				}
			map.put(MESSAGE_INFO, "更新成功！");
		}
		
		
		return true;
	}
	
	/**
	 * springMVC包装好的解析器进行上传<br/>
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws TKCheckedException 
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadBySpringGrpFixed")
	public String uploadBySpringGrpFixed(HttpServletRequest request,
			HttpServletResponse response)  {
		Map<String, String> map = new HashMap<String, String>();
			try {
				String pictureUrl = fixedAction.uploadBySpringGrpFixed(request);
			} catch (Exception e) {
			}
			
		return "fixed/fixedIndex";
	}

	@RequestMapping("/goMain")
	public String goMain() {
		return "fixed/fixedIndex"; 
	}
	
	@RequestMapping("/goMains")
	public String goMainS() {
		return "fixed/fixedIndex"; 
	}
	/**
	 * 修改环节页面
	 * @return
	 */
	@RequestMapping("/editLink")
	public String showfixedEditPage(String linkId,Model model) {
		
		if(linkId!=null && !linkId.equals(""))
		{
			model.addAttribute("linkId",linkId );
		}
		
		return "fixed/fixedLinkEdit"; 
	}
	/**
	 * 修改套餐环节页面
	 * @return
	 */
	@RequestMapping("/editLinkMeal")
	public String showfixedEditPage1(String linkId,String mealId,Model model) {
		
		if(linkId!=null && !linkId.equals(""))
		{
			model.addAttribute("linkId",linkId );
		}
		if(mealId!=null && !mealId.equals(""))
		{
			model.addAttribute("mealId",mealId );
		}
		
		return "fixed/fixedLinkMealEdit"; 
	}
	
	/**
	 * 发布固定套餐
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/shelves")
	@ResponseBody
	private Map<String,String> saveMealShelvesInfo(String mealId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(mealId==null||mealId.equalsIgnoreCase("Undefined")){
			map.put(MESSAGE_INFO, "请选择套餐！");
		}else{
			String[] id = mealId.split(",");
			for (int i = 0; i < id.length; i++) {
						param.put("mealId", id[i]);
						param.put("state", "2"); 
						param.put("modifiedBy", loginId);
						param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
						fixedAction.updateObject(param);
						map.put(MESSAGE_INFO, "发布成功！");
			}	
		}
			
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
	private Map<String,String> saveFixedShelvesInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("mealId") !=null ||!"".equals(param.get("mealId")))
		{
			if(param.get("state").equals("2")){
				map.put(MESSAGE_INFO, "此套餐已上架！");
				map.put(RTN_RESULT, "false");
			}else{
				param.put("state", "2"); // “1”代表“已发布”
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", Integer.parseInt(param.get("version").toString())+1);
				fixedAction.updateObject(param);
				map.put(MESSAGE_INFO, "发布成功！");
			}
			map.put(RTN_RESULT, "true");
		}
		return map;
	}
	
	

	/**
	 * 保存下架套餐的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/soldOut")
	@ResponseBody
	private Map<String,String> saveMealSoldOutInfo(String mealId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(mealId==null||mealId.equalsIgnoreCase("Undefined")){
			map.put(MESSAGE_INFO, "请选择服务！");
		}else{
			String[] id = mealId.split(",");
			for (int i = 0; i < id.length; i++) {
						param.put("mealId", id[i]);
						param.put("state", "1"); 
						param.put("modifiedBy", loginId);
						param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
						fixedAction.updateObject(param);
						map.put(MESSAGE_INFO, "下架成功！");
			}	
		
			map.put(RTN_RESULT, "true");
		}
		
		return map;
	}
	
	/**
	 * 保存下架套餐的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveSoldOut")
	@ResponseBody
	private Map<String,String> saveFSoldOutInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("mealId") !=null ||!"".equals(param.get("mealId")))
		{
			if(param.get("state").equals("1")){
				map.put(MESSAGE_INFO, "此套餐未发布！");
				map.put(RTN_RESULT, "false");
			}else{
				param.put("state", "1"); // “1”代表“已上架”
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", Integer.parseInt(param.get("version").toString())+1);
				fixedAction.updateObject(param);
				map.put(MESSAGE_INFO, "下架成功！");
				
			}
			map.put(RTN_RESULT, "true");
		}
		
		return map;
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
		Dto params = new BaseDto();
		param.put("mealId", mealId);
		 Dto oneMeal = fixedAction.findOneMeal(param);
		 String url = oneMeal.getAsString("mealPicture");
		 url = CommonUtil.RELATION_UPLOAD_FILEPATH+url;
		 oneMeal.put("mealPicture", url);
		 return oneMeal;
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
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> savefixedInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			fixedAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			fixedAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}map.put(MESSAGE_INFO, "新增成功！");
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	
	
	/**
	 * 保存新增环节的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/saveLink")
	@ResponseBody
	private Map<String,String> saveLinkInfo(String mealId,HttpServletRequest request)
	{
			Map<String,String> map=new HashMap<String,String>();
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			Dto param = getParamAsDto(request);
		if(param.get("linkId") ==null ||"".equals(param.get("linkId")))
		{	if(mealId!=null && !"".equals(mealId) && !"undefined".equalsIgnoreCase(mealId) && !",".equals(mealId)){
				if(mealId.contains(",")){
					mealId= mealId.substring(0, mealId.indexOf(","));
				}
			param.put("mealId", mealId);
		}
			param.put("linkId", UUID.randomUUID().toString().replace("-", ""));
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			fixedAction.insertLink(param);
			map.put(MESSAGE_INFO, "新增成功！");
			map.put("linkId", (String) param.get("linkId"));
		}else{
			fixedAction.updateLink(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	 * 保存新增用品的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/saveLinkServer")
	@ResponseBody
	private Map<String,String> saveLinkServer(String applianceId,String linkId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(linkId==null||linkId.equalsIgnoreCase("Undefined")){
			map.put(MESSAGE_INFO, "请选择环节！");
		}else{
			String[] id = applianceId.split(",");
			for (int i = 0; i < id.length; i++) {
				Dto applianceParam = new BaseDto();
				applianceParam.put("applianceId", id[i]);
				applianceParam.put("linkId", linkId);
				List<fixedBO> applianceList = fixedAction.searchAppliance(applianceParam);
				if(applianceList.size()!=0){
					Dto appParam = new BaseDto();
					appParam.put("relationId", applianceList.get(0).getRelationId());
					appParam.put("delflag", "0");
					fixedAction.updateAppliance(appParam);
				}else{
					param.put("relationId", UUID.randomUUID().toString().replace("-", ""));
					param.put("linkId", linkId);
					param.put("applianceId", id[i]);
					param.put("createdBy", loginId);
					param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
					param.put("delflag", "0"); // “0”代表“未删除”
					param.put("version", 1);
					fixedAction.insertLinkServer(param);
				}

			}
			map.put(MESSAGE_INFO, "新增成功！");
		}
		
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	
	/**
	 * 保存新增服务的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/saveLinkService")
	@ResponseBody
	private Map<String,String> saveLinkService(String serviceId,String linkId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		Dto params = new BaseDto();
		Dto para = new BaseDto();
		if(linkId==null||linkId.equalsIgnoreCase("Undefined")){
			map.put(MESSAGE_INFO, "请选择环节！");
		}else{	
				params.put("linkId", linkId);
				List<fixedBO> findFixService = fixedAction.findFixService(params);
				if(findFixService.size()==0){
					param.put("relationId", UUID.randomUUID().toString().replace("-", ""));
					if(linkId.contains(",")){
						linkId=linkId.substring(0, linkId.indexOf(","));
						param.put("linkId", linkId);
					}else{
						param.put("linkId", linkId);
					}
					param.put("serviceId", serviceId);
					param.put("createdBy", loginId);
					param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
					param.put("delflag", "0"); // “0”代表“未删除”
					param.put("version", 1);
					fixedAction.insertServer(param);
				map.put(MESSAGE_INFO, "新增成功！");
				}else{
					
					para.put("relationId", findFixService.get(0).getRelationId());
					para.put("serviceId", serviceId);
					para.put("modifiedBy", loginId);
					para.put("modifiedBy", loginId);
					para.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
					fixedAction.updateServer(para);
					map.put(MESSAGE_INFO, "更新成功！");
				}
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	 *删除一条或多条记录
	 */
	@RequestMapping(value="/delLink")
	@ResponseBody
	public Map<String, String> delLink(@RequestParam("linkId") String linkId) {
		Map<String, String> map = new HashMap<String, String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = new BaseDto();
		Dto params = new BaseDto();
		param.put("linkId", linkId);
		List <fixedBO> applianceList = fixedAction.findApplianceList(param);
		if(applianceList.size()!=0){
			map.put("MESSAGE_INFO", "此环节下有用品");
		}else{
			List<fixedBO> findFixService = fixedAction.findFixService(param);
			if(findFixService.size()>0){
				params.put("relationId", findFixService.get(0).getRelationId());
				params.put("delflag", "1"); // “1”代表“已删除”
				params.put("modifiedBy", loginId);
				params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				fixedAction.updateServer(params);
			}
			param.put("delflag", "1"); // “1”代表“已删除”
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			fixedAction.updateLink(param);
			
			map.put(RTN_RESULT, "true");
			map.put(MESSAGE_INFO, "操作成功！");
		}
		return map;
	}
/**
 *删除一条或多条记录
 */
@RequestMapping(value="/delAppliance")
@ResponseBody
public Map<String, String> delAppliance(@RequestParam("applianceId") String applianceId,String linkId) {
	Map<String, String> map = new HashMap<String, String>();
	LoginUser user = UserUtils.getUser();
	String loginId = String.valueOf(user.getUserId());
	Dto param = new BaseDto();
	Dto params = new BaseDto();
	param.put("applianceId", applianceId);
	param.put("linkId", linkId);
	params.put("delflag", "1"); // “1”代表“已上架”
	params.put("modifiedBy", loginId);
	params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
	List <fixedBO> list = fixedAction.findRelation(param);
	params.put("relationId", list.get(0).getRelationId());
	fixedAction.updateAppliance(params);
	
	map.put(RTN_RESULT, "true");
	map.put(MESSAGE_INFO, "操作成功！");
	
	return map;
}
}

