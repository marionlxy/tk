package com.taikang.iu.biz.appliance.controller;

import java.io.IOException;
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

import com.taikang.iu.biz.appliance.action.IApplianceAction;
import com.taikang.iu.biz.appliancesku.action.IApplianceskuAction;
import com.taikang.iu.biz.qualitymeasure.action.IQualitymeasureAction;
import com.taikang.iu.biz.picture.action.IPictureAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.exception.TKCheckedException;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IFileloadAction;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;



/**
  * ApplianceController
  */
@Controller("applianceController")
@RequestMapping(value="/appliance")
public class ApplianceController  extends BaseController  {
		
	@Resource(name=IApplianceAction.ACTION_ID)
	private IApplianceAction applianceAction;
		
	@Resource(name=IQualitymeasureAction.ACTION_ID)
	private IQualitymeasureAction qualitymeasureAction;
	
	@Resource(name=IApplianceskuAction.ACTION_ID)
	private IApplianceskuAction applianceskuAction;
	
	@Resource(name = "fileloadAction")
	private IFileloadAction fileloadAction;
	
	@Resource(name=IPictureAction.ACTION_ID)
	private IPictureAction pictureAction;
	
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showApplianceIndexPage() {
		return "appliance/applianceIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getApplianceList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		
		CurrentPage currentPage = applianceAction.queryForPage(page);
		
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
	public String oneRole(Model model,HttpServletRequest request,String checked) {
		//Dto param = new BaseDto();
		Dto param = getParamAsDto(request);
		List <Dto> qualitymeasureList = qualitymeasureAction.findAll(param);
		model.addAttribute("qualitymeasureList",qualitymeasureList);
		return "appliance/applianceAdd"; 
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("edit")
	public String showApplianceEditPage(String applianceId,Model model) {
		
		if(applianceId!=null && !applianceId.equals(""))
		{
			model.addAttribute("applianceId",applianceId );
			Dto param = new BaseDto();
			Dto picturedto = new BaseDto();
			param.put("applianceId", applianceId);
			picturedto.put("appliance_id", applianceId);
			Dto dto = applianceAction.findOne(param);
			List <Dto> pictureList = pictureAction.findAll(picturedto);
			model.addAttribute("describe",dto.getAsString("describe"));
			model.addAttribute("pictureList",pictureList);
		}
		
		return "appliance/applianceEdit"; 
	}
	
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/view")
	public String showSellerViewPage(String applianceId,Model model) {
		
		if(applianceId!=null && !applianceId.equals(""))
		{
			model.addAttribute("applianceId",applianceId );
			Dto param = new BaseDto();
			Dto picturedto = new BaseDto();
			param.put("applianceId", applianceId);
			picturedto.put("appliance_id", applianceId);
			Dto dto = applianceAction.findOne(param);
			List <Dto> pictureList = pictureAction.findAll(picturedto);
			model.addAttribute("describe",dto.getAsString("describe"));
			model.addAttribute("pictureList",pictureList);
		}
		
		return "appliance/applianceView"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getApplianceById(@RequestParam("applianceId")String applianceId,Model model)
	{
		Dto param = new BaseDto();
		param.put("applianceId", applianceId);
		Dto dto = applianceAction.findOne(param);
		model.addAttribute("describe",dto.getAsString("describe"));
		return applianceAction.findOne(param);
	}
	
	
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveApplianceInfo(HttpServletRequest request)  
	{
		
		Map<String,String> map=new HashMap<String,String>();
		Dto param = getParamAsDto(request);
		if(param.get("applianceId") ==null ||"".equals(param.get("applianceId")))
		{
			String Id = UUID.randomUUID().toString().replace("-", "");
			param.put("applianceId", Id);
			param.put("ismarketable", 4);
			param.put("applianceCoding","YP"+BusinessSeqGenerator.getInstance("APPLIANCE_CODING").nextId()); 
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);

			/****************用品图片的处理*********************/
			
			
				
				
			applianceAction.insertObject(param);
			
			CurrentPage page = new CurrentPage();
			page.setParamObject(getParamAsDto(request));
			CurrentPage currentPage = applianceskuAction.findAllNull(page);
			Dto param2 = getParamAsDto(request);
			param2.clear();
			for(int i=0;i<currentPage.getPageItems().size();i++){
				Dto dto = currentPage.getPageItems().get(i);
				param2.put("skuId", dto.getAsString("SKU_ID"));
				param2.put("applianceId",Id);
				applianceskuAction.updateObject(param2);
			}
			
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			try {
				if(!fileloadAction.uploadBySpringGrp(request)) {
					map.put(RTN_RESULT, "false");
					map.put(MESSAGE_INFO, "操作失败！");
				}else {
					map.put(RTN_RESULT, "true");
					map.put(MESSAGE_INFO, "操作成功！");
				}
			} catch (TKCheckedException e) {
				map.put(RTN_RESULT, "false");
				map.put(MESSAGE_INFO, "操作失败！");
			}
			
			
			CurrentPage page = new CurrentPage();
			page.setParamObject(getParamAsDto(request));
			CurrentPage currentPage = applianceskuAction.findAllNull(page);
			Dto param2 = getParamAsDto(request);
			param2.clear();
			for(int i=0;i<currentPage.getPageItems().size();i++){
				Dto dto = currentPage.getPageItems().get(i);
				param2.put("skuId", dto.getAsString("SKU_ID"));
				param2.put("applianceId",param.get("applianceId"));
				applianceskuAction.updateObject(param2);
			}
			
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			applianceAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteAppliance(@RequestParam("applianceId") String applianceId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("applianceId", applianceId);
		param.put("delflag", 1);
		param.put("ismarketable", 5);
		applianceAction.updateObject(param);
//		applianceAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 申请上架
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLinkServers")
	@ResponseBody
	private Map<String,String> saveLinkServers(String applianceId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
//		LoginUser user = UserUtils.getUser();
		Dto param = getParamAsDto(request);
			String[] id = applianceId.split(",");
			for (int i = 0; i < id.length; i++) {
				param.put("applianceId", id[i]);
				Dto dto = applianceAction.findOne(param);
				if(dto.getAsString("ismarketable").equals("4")){
					dto.put("ismarketable", 1);
				}
				applianceAction.updateObject(dto);
			}
			map.put(MESSAGE_INFO, "申请上架成功，请等待！= =！");
			map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	 *申请下架
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLinkServerx")
	@ResponseBody
	private Map<String,String> saveLinkServerx(String applianceId,HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
//		LoginUser user = UserUtils.getUser();
		Dto param = getParamAsDto(request);
			String[] id = applianceId.split(",");
			for (int i = 0; i < id.length; i++) {
				param.put("applianceId", id[i]);
				Dto dto = applianceAction.findOne(param);
				if(dto.getAsString("ismarketable").equals("2")){
					dto.put("ismarketable", 3);
				}
				applianceAction.updateObject(dto);
			}
			map.put(MESSAGE_INFO, "申请下架成功，请等待！= =！");
			map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	
	
}

