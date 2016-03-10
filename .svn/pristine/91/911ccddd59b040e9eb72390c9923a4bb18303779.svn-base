package com.taikang.iu.opt.single.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.UUID;

import com.taikang.iu.com.CommonUtil;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IFileloadAction;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.characterset.action.ICharactersetAction;
import com.taikang.iu.opt.characterset.model.CharactersetBO;
import com.taikang.iu.opt.fixed.action.IfixedAction;
import com.taikang.iu.opt.fixed.model.fixedBO;
import com.taikang.iu.opt.single.action.ISingleAction;
import com.taikang.iu.opt.single.model.SingleBO;


/**
  * SingleController
  */
@Controller("singleController")
@RequestMapping(value="/single")
public class SingleController  extends BaseController  {
		
	@Resource(name=ISingleAction.ACTION_ID)
	private ISingleAction singleAction;
	
	@Resource(name = "fileloadAction")
	private IFileloadAction fileloadAction;
	
	@Resource(name=IfixedAction.ACTION_ID)
	private IfixedAction fixedAction;
	
	@Resource(name=ICharactersetAction.ACTION_ID)
	private ICharactersetAction charactersetAction;
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showSingleIndexPage() {
		return "single/singleIndex"; 
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
	@RequestMapping("/goMain")
	public String goMain() {
		return "single/singleIndex"; 
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
	@SuppressWarnings("unchecked")
	@RequestMapping("/view")
	public String showSingleViewPage(String serviceId,Model model) {
		
		if(serviceId!=null && !serviceId.equals(""))
		{
			model.addAttribute("serviceId",serviceId );
			Dto param = new BaseDto();
			param.put("serviceId", serviceId);
			Dto list = singleAction.findOne(param);
			List urlList = new ArrayList();
			String pictureUrl = list.getAsString("pictureUrl");
			if(pictureUrl!=null && !"".equals(pictureUrl)){
				String[] split = pictureUrl.split(",");
				for (int i = 0; i < split.length; i++) {
					Map map =new BaseDto();
					String url = CommonUtil.RELATION_UPLOAD_FILEPATH+split[i];
					map.put("url", url);
//					String url = "/upload/"+split[i];
					urlList.add(map);
					
				}
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
	 * @throws TKCheckedException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveSingleInfo(HttpServletRequest request) throws TKCheckedException
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("serviceId") ==null ||"".equals(param.get("serviceId")))
		{	
			param.put("serviceId", UUID.randomUUID().toString().replace("-", ""));
			param.put("serviceState", "0"); // “1”代表“使用中”
			param.put("createdBy", param.get("loginId"));
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			param.put("moral", param.get("moral"));
			map.put("sId", param.getAsString("serviceId"));
			singleAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			map.put("sId", param.getAsString("serviceId"));
			singleAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		return map;
	}
	
	@RequestMapping("/uploadBySpringGrpSingle")
	public String uploadBySpringGrpSingle(HttpServletRequest request,
			HttpServletResponse response)  {
		Map<String, String> map = new HashMap<String, String>();
		try {
			String pictureUrl = singleAction.uploadBySpringGrpSingle(request);
		} catch (Exception e) {
		}
			return "single/singleIndex"; 
	}
//	@SuppressWarnings("unchecked")
//	@RequestMapping("/saveFile")
//	@ResponseBody
//	private String saveFile(@RequestParam MultipartFile[] myfiles,HttpServletRequest request,HttpServletResponse resp)
//	{
//		try {
//			request.setCharacterEncoding ("UTF-8");
//			resp.setCharacterEncoding("UTF-8");
//			for(MultipartFile myfile : myfiles){  
//				if(myfile.isEmpty()){  
//					System.out.println("文件未上传");  
//				}else{  
//					System.out.println("文件长度: " + myfile.getSize());  
//					System.out.println("文件类型: " + myfile.getContentType());  
//					System.out.println("文件名称: " + myfile.getName());  
//					System.out.println("文件原名: " + myfile.getOriginalFilename());  
//					System.out.println("========================================");  
//					//如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
//					String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");  
//					//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
//					FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));  
//				}  
//			} 
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "0";
//		}
//		return "1";
//	}
	
	
	
	/**
	 * 保存新增服务商记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveSellService")
	@ResponseBody
	private Map<String,String> saveSellService(HttpServletRequest request,String serviceId)
	{	
		Dto paramh = getParamAsDto(request);
		
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto params = new BaseDto();
		Dto para = new BaseDto();
		
		params.put("sellerId", paramh.get("sellerName"));
		Dto oneSellers = singleAction.findOneSeller(params);
		para.put("sellerId", paramh.get("sellerName"));
		if(serviceId.contains(",")){
			serviceId= serviceId.substring(0, serviceId.length()-1);
		}
		para.put("serviceId", serviceId);
		List<SingleBO> oneSeller = singleAction.findOneSellers(para);
		Dto param = getParamAsDto(request);
		if(oneSeller.size()==0){
			param.put("relationId", UUID.randomUUID().toString().replace("-", ""));
			param.put("serviceId", serviceId);
			param.put("sellerId", paramh.get("sellerName")); 
			param.put("settlePrice", param.get("settlePrice")); 
			param.put("sellerName", oneSellers.get("sellerName")); 
			param.put("sellerCode", oneSellers.get("sellerCode")); 
			param.put("sellerType", 2); 
			param.put("serviceMsg", param.get("serviceMsg")); 
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			singleAction.insertSellerService(param);
		}else{
			Dto sellParam = new BaseDto();
			sellParam.put("relationId", oneSeller.get(0).getRelationId());
			sellParam.put("settlePrice", param.get("settlePrice")); 
			sellParam.put("serviceMsg", param.get("serviceMsg")); 
			sellParam.put("modifiedBy", loginId);
			sellParam.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			singleAction.updateSellerService(sellParam);
		}
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
	private Map<String,String> saveSingleShelvesInfo(String serviceId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(serviceId==null||serviceId.equalsIgnoreCase("Undefined")){
			map.put(MESSAGE_INFO, "请选择服务！");
		}else{
			String[] id = serviceId.split(",");
			for (int i = 0; i < id.length; i++) {
						param.put("serviceId", id[i]);
						param.put("serviceState", "1"); // “1”代表“已上架”
						param.put("modifiedBy", loginId);
						param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
						singleAction.updateObject(param);
						map.put(MESSAGE_INFO, "上架成功！");
			}	
		}
			
		map.put(RTN_RESULT, "true");
		return map;
	}
	
	
	/**
	 * 保存下架服务的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveSoldOut")
	@ResponseBody
	private Map<String,String> saveSingleSoldOutInfo(String serviceId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto params = new BaseDto();
		Dto param = getParamAsDto(request);
		if(serviceId==null||serviceId.equalsIgnoreCase("Undefined")){
			map.put(MESSAGE_INFO, "请选择服务！");
		}else{
			String[] id = serviceId.split(",");
			for (int i = 0; i < id.length; i++) {
						params.put("serviceId", id[i]);
					List<fixedBO> fixList =	fixedAction.findApplianRelation(params);
					List <CharactersetBO> characterList = 	charactersetAction.findApplianceRelation(params);
						if(fixList.size()==0 && characterList.size()==0){
							param.put("serviceId", id[i]);
							param.put("serviceState", "0"); // “1”代表“已上架”
							param.put("modifiedBy", loginId);
							param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
							singleAction.updateObject(param);
							map.put(MESSAGE_INFO, "下架成功！");
						}else {
							map.put(MESSAGE_INFO, "此服务已被套餐使用，不能下架");
						}
						
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
		Dto params = new BaseDto();
		params.put("serviceId", serviceId);
		List <fixedBO> list = fixedAction.findApplianRelation(params);
		int num = list.size();
		List <CharactersetBO> characterList = charactersetAction.findApplianceRelation(params);
		int charaNum = characterList.size();
		if(num==0 && charaNum==0){
			param.put("serviceId", serviceId);
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "1"); // “1”代表“已删除”
			param.put("version", Integer.parseInt(version)+1);
			singleAction.updateObject(param);
			map.put(RTN_RESULT, "true");
			map.put(MESSAGE_INFO, "服务删除成功！");
		}else{
			map.put(RTN_RESULT, "true");
			map.put(MESSAGE_INFO, "此服务已被套餐使用不能删除");
		}
		
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
	public Map<String,Object> getOrderSevList(String serviceId,String serviceNum ,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		request.setAttribute("serviceId", serviceId);
		request.setAttribute("serviceNum", serviceNum);
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = singleAction.queryForServPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	
}

