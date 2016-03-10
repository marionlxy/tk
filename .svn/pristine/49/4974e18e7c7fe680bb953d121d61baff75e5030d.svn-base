package com.taikang.iu.biz.appliancesku.controller;

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

import com.taikang.iu.biz.appliance.action.IApplianceAction;
import com.taikang.iu.biz.appliancesku.action.IApplianceskuAction;
import com.taikang.iu.biz.picture.action.IPictureAction;
import com.taikang.iu.biz.qualitymeasure.action.IQualitymeasureAction;
import com.taikang.iu.biz.qualityvalue.action.IQualityvalueAction;
import com.taikang.iu.com.CommonUtil;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;


/**
  * ApplianceskuController
  */
@Controller("applianceskuController")
@RequestMapping(value="/appliancesku")
public class ApplianceskuController  extends BaseController  {
		
	@Resource(name=IApplianceskuAction.ACTION_ID)
	private IApplianceskuAction applianceskuAction;
	
	@Resource(name=IQualityvalueAction.ACTION_ID)
	private IQualityvalueAction qualityvalueAction;
		
	@Resource(name=IQualitymeasureAction.ACTION_ID)
	private IQualitymeasureAction qualitymeasureAction;
	
	@Resource(name=IApplianceAction.ACTION_ID)
	private IApplianceAction applianceAction;
	
	@Resource(name=IPictureAction.ACTION_ID)
	private IPictureAction pictureAction;
	
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showApplianceskuIndexPage() {
		return "appliancesku/applianceskuIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getApplianceskuList(HttpServletRequest request,CurrentPage page,String applianceId){
		Map<String, Object> map = new HashMap<String, Object>();
		if(applianceId!=null){
			Dto dto =new BaseDto();
			dto.put("applianceId", applianceId);
			page.setParamObject(dto);
		}else{
			Dto dto =new BaseDto();
			dto.put("applianceIdnull", "0");
			page.setParamObject(dto);
		}
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = applianceskuAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/listNull")
	@ResponseBody
	public Map<String,Object> getApplianceskuListNull(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = applianceskuAction.findAllNull(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("skuPictureView")
	public String skuPictureView(String skuId,Model model,String applianceId,String categoryId) {
		
		if(skuId!=null && !skuId.equals(""))
		{
			model.addAttribute("skuId",skuId );
			model.addAttribute("applianceId",applianceId );
			Dto picturedto = new BaseDto();
			picturedto.put("sku_id", skuId);
			List <Dto> pictureList = pictureAction.findAll(picturedto);
			List <Dto> pictureDtoList = new ArrayList<Dto>();
			String url = CommonUtil.RELATION_UPLOAD_FILEPATH;
			for(int i =0 ;i<pictureList.size();i++){
				Dto pictureDto = new BaseDto();
				pictureDto = pictureList.get(i);
				pictureDto.put("PICTURE_ADDRESS", url+pictureDto.getAsString("PICTURE_ADDRESS"));
				pictureDtoList.add(pictureDto);
			}
			model.addAttribute("pictureDtoList",pictureDtoList);
		}
		
		return "appliancesku/skupictureView"; 
	}
	
	/**
	 * 打开新增页面
	 * @return   
	 * String
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/add")
	public String oneRole(Model model,String applianceId) {
		Dto param = new BaseDto();
		List  qualityvalueList = qualityvalueAction.findAll(param);
		model.addAttribute("qualityvalueList",qualityvalueList);
		List  qualitymeasureList = qualitymeasureAction.findAll(param);
		model.addAttribute("qualitymeasureList",qualitymeasureList);
		model.addAttribute("qualityvalueList",qualityvalueList);
		if(applianceId!=null){
			model.addAttribute("add","false" );
			model.addAttribute("applianceId",applianceId );
		}else{
			model.addAttribute("add","true" );
		}
		return "appliancesku/applianceskuAdd"; 
	}
	

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showApplianceskuEditPage(String skuId,Model model,String applianceId) {
		
		if(skuId!=null && !skuId.equals(""))
		{
			model.addAttribute("skuId",skuId );
			model.addAttribute("applianceId",applianceId );
			Dto param = new BaseDto();
			List  qualityvalueList = qualityvalueAction.findAll(param);
			model.addAttribute("qualityvalueList",qualityvalueList);
			List  qualitymeasureList = qualitymeasureAction.findAll(param);
			model.addAttribute("qualitymeasureList",qualitymeasureList);
			model.addAttribute("qualityvalueList",qualityvalueList);
			param.put("skuId", skuId);
			Dto param2 = applianceskuAction.findOne(param);
			String valueId = param2.getAsString("qualityValuesId");
			model.addAttribute("valueId",valueId);
		}
		
		return "appliancesku/applianceskuEdit"; 
	}
	
	
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/view")
	public String showSellerViewPage(String skuId,Model model,String categoryId) {
		if(skuId!=null && !skuId.equals(""))
		{
			model.addAttribute("skuId",skuId);
			Dto param = new BaseDto();
			param.put("category_id", categoryId);
			List  qualityvalueList = qualityvalueAction.findAll(param);
			model.addAttribute("qualityvalueList",qualityvalueList);
			List  qualitymeasureList = qualitymeasureAction.findAll(param);
			model.addAttribute("qualitymeasureList",qualitymeasureList);
			model.addAttribute("qualityvalueList",qualityvalueList);
			param.put("skuId", skuId);
			Dto param2 = applianceskuAction.findOne(param);
			String valueId = param2.getAsString("qualityValuesId");
			model.addAttribute("valueId",valueId);
			model.addAttribute("categoryId",categoryId );
		}
		
		return "appliancesku/applianceskuView"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getApplianceskuById(@RequestParam("skuId")String skuId)
	{
		Dto param = new BaseDto();
		param.put("skuId", skuId);
		return applianceskuAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveApplianceskuInfo(HttpServletRequest request,String applianceId)
	{	
		Dto param = getParamAsDto(request);
		Map<String,String> map=new HashMap<String,String>();
		Dto parammeasure = new BaseDto();
		List  qualitymeasureList = qualitymeasureAction.findAll(parammeasure);
		Map<String, Object> map2 = new HashMap<String, Object>();
		String qualityNames="";
		String qualityIds="";
		String qualityMeasuresId="";
		String qualityValuesId="";
		for(int i=0;i<qualitymeasureList.size();i++){
			map2 = (Map<String, Object>) qualitymeasureList.get(i);
			String qualityValueId = (String)map2.get("QUALITY_ID");
			
			//根据属性表ID 加前台qualityName 取出用户动态选择的属性值
			String qualityValueId2 = param.get("qualityName"+qualityValueId).toString();
			
			Dto param2 = new BaseDto();
			param2.put("qualityValueId", qualityValueId2);
			Dto qualityValue = qualityvalueAction.findOne(param2);
			
			//根据属性值表中的属性ID查询属性的信息
			String qualityId = (String)map2.get("QUALITY_ID");
			Dto param3 = new BaseDto();
			param3.put("qualityId", qualityId);
			Dto qualityMeasure = qualitymeasureAction.findOne(param3);
			
			String qualityName = qualityMeasure.getAsString("qualityName");
			String qualityValueName = qualityValue.getAsString("qualityValueName");
			qualityNames += qualityName+":"+qualityValueName+";";
			qualityIds += qualityId+":"+qualityValueId2+";";
			qualityMeasuresId+=qualityId+",";
			qualityValuesId+=qualityValueId2+",";
		}
		
		if(param.get("skuId") ==null ||"".equals(param.get("skuId")))
		{
			param.put("skuId", UUID.randomUUID().toString().replace("-", ""));
			param.put("code", "DP"+BusinessSeqGenerator.getInstance("CODE").nextId());
			param.put("qualityNames", qualityNames);
			param.put("qualityIds", qualityIds);
			param.put("qualityMeasuresId", qualityMeasuresId.substring(0, qualityMeasuresId.length()-1));
			param.put("qualityValuesId", qualityValuesId.substring(0,qualityValuesId.length()-1));
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			param.put("applianceId",applianceId);
			applianceskuAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			param.put("applianceId",applianceId);
			param.put("qualityNames", qualityNames);
			param.put("qualityMeasuresId", qualityMeasuresId);
			param.put("qualityValuesId", qualityValuesId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			applianceskuAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteAppliancesku(@RequestParam("skuId") String skuId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("skuId", skuId);
		applianceskuAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

