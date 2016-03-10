package com.taikang.iu.opt.cemetery.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.cemetery.action.ICemeteryTypeAction;
import com.taikang.iu.opt.characterset.model.CharactersetBO;
import com.taikang.iu.opt.fixed.model.fixedBO;

import java.util.List;

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

import java.util.Arrays;


/**
  * CemeteryTypeController
  */
@Controller("cemeteryTypeController")
@RequestMapping(value="/cemeteryType")
public class CemeteryTypeController  extends BaseController  {
		
	@Resource(name=ICemeteryTypeAction.ACTION_ID)
	private ICemeteryTypeAction cemeteryTypeAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showCemeteryTypeIndexPage() {
		return "cemeteryType/cemeteryTypeIndex"; 
	}
	
	/**
	 * 打开新增页面
	 * @return 页面地址
	 */
	@RequestMapping("/add")
	public String addCemeteryTypePage(String parkId,Model model) {
		if (parkId != null && !"".equals(parkId)) {
			model.addAttribute("parkId",parkId);
		}
		return "cemeterytype/cemeterytypeAdd"; 
	}
	
	@RequestMapping("/goMains")
	public String goMainS() {
		return "cemetery/cemeteryIndex"; 
	}
	
	/**
	 * 打开查询详细页面    
	 * @return 页面地址
	 */
	@RequestMapping("/view")
	public String showCemeteryType(String typeId,Model model) {
		if(typeId!=null && !typeId.equals("")) {
			Dto param = new BaseDto();
			param.put("typeId", typeId);
			Dto cemeteryType = cemeteryTypeAction.findOne(param);
			List urlList = new ArrayList();
			String pictureUrl = cemeteryType.getAsString("realUrl");
			if(pictureUrl!=null && !"".equals(pictureUrl)){
				String newPictureUrl = pictureUrl.replace("\\", "/");
				String[] split = newPictureUrl.split(",");
				for (int i = 0; i < split.length; i++) {
					Map map =new BaseDto();
					String url = CommonUtil.RELATION_UPLOAD_FILEPATH+split[i];
					map.put("url", url);
//					String url = "/upload/"+split[i];
					urlList.add(map);
					
				}
			}   
			model.addAttribute("urlList",urlList);
			model.addAttribute("typeId",typeId );
		}
		return "cemeterytype/showCemeterytype"; 
	}
	
	/**
	 * 查询指定墓园下的所有墓型信息
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getCemeteryTypeList(HttpServletRequest request,String cemeteryId,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		param.put("cemeteryId", cemeteryId);
		page.setParamObject(param);
		CurrentPage currentPage = cemeteryTypeAction.allCemeteryTypeList(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 查询指定园区下的所有墓型信息
	 * @return 分页列表数据
	 */
	@RequestMapping("/getCemeteryType")
	@ResponseBody
	public Map<String,Object> getCemeteryType(HttpServletRequest request,String parkId,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		param.put("parkId", parkId);
		page.setParamObject(param);
		CurrentPage currentPage = cemeteryTypeAction.getCemeteryType(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String showCemeteryTypeEditPage(String typeId,Model model) {
		
		if(typeId!=null && !typeId.equals(""))
		{
			model.addAttribute("typeId",typeId );
		}
		
		return "cemeterytype/cemeterytypeEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getCemeteryTypeById(@RequestParam("typeId")String typeId,Model model)
	{
		Dto param = new BaseDto();
		param.put("typeId", typeId);
		Dto cemeteryType = cemeteryTypeAction.findOne(param);
		//对textarea里的值进行处理
//		String typeContent = cemeteryType.getAsString("typeContent");
//		if (typeContent != null && !"".equals(typeContent)) {
//			String newTypeContent  = "";
//			for (int i = 0; i < typeContent.split("<br/>").length; i++) {
//				newTypeContent = newTypeContent + typeContent.split("<br/>")[i]+"\n";
//			}
//			cemeteryType.put("typeContent", newTypeContent);
//		}
		return cemeteryType;
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveCemeteryTypeInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("typeId") ==null ||"".equals(param.get("typeId")))
		{	
			try{
				//对textarea里的值进行处理
//				String typeContent = param.getAsString("typeContent");
//				if (typeContent != null && !"".equals(typeContent)) {
//					String newTypeContent  = "";
//					for (int i = 0; i < typeContent.split("\n").length; i++) {
//						newTypeContent = newTypeContent + typeContent.split("\n")[i]+"<br/>";
//					}
//					param.put("typeContent", newTypeContent);
//				}
				param.put("typeId", UUID.randomUUID().toString().replace("-", ""));
				param.put("createdBy", loginId);
				param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("delflag", "0"); // “0”代表“未删除”
				param.put("version", 1);
				map.put("tId", param.getAsString("typeId"));
				cemeteryTypeAction.insertObject(param);
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
//				String typeContent = param.getAsString("typeContent");
//				if (typeContent != null && !"".equals(typeContent)) {
//					String newTypeContent  = "";
//					for (int i = 0; i < typeContent.split("\n").length; i++) {
//						newTypeContent = newTypeContent + typeContent.split("\n")[i]+"<br/>";
//					}
//					param.put("typeContent", newTypeContent);
//				}
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", param.getAsInteger("version")+1);
				cemeteryTypeAction.updateObject(param);
				map.put(MESSAGE_INFO, "更新成功！");
				map.put(RTN_RESULT, "true");
			}catch(Exception e){
				map.put(MESSAGE_INFO, "更新失败！");
				map.put(RTN_RESULT, "false");
			}
			
		}
		
		
		return map;
	}
	
	
	/**
	 * 墓型图片上传
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadByCemeteryType")
	public Map<String,String> uploadByCemetery(HttpServletRequest request)  {
		
		Map<String, String> map = new HashMap<String, String>();
		try {
			String realUrl = cemeteryTypeAction.uploadByCemetery(request);
			map.put(MESSAGE_INFO, "更新成功！");
			map.put(RTN_RESULT, "true");
		} catch (Exception e) {
			map.put(MESSAGE_INFO, "更新失败！");
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
	public Map<String, String> deleteCemeteryType(@RequestParam("typeId") String typeId,@RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		try {
			
			param.put("typeId", typeId);
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "1"); // “1”代表“已删除”
			param.put("version", Integer.parseInt(version)+1);
			cemeteryTypeAction.updateObject(param);
			map.put(RTN_RESULT, "true");
			map.put(MESSAGE_INFO, "删除成功！");
			
		} catch (Exception e) {
			
			map.put(RTN_RESULT, "false");
			map.put(MESSAGE_INFO, "删除失败！");
		}
		return map;
	}
}

