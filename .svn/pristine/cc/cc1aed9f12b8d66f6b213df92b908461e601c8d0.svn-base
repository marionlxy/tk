package com.taikang.iu.biz.qualitymeasure.controller;

import java.util.Map;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.iu.biz.qualitymeasure.action.IQualitymeasureAction;
import com.taikang.iu.biz.qualitymeasure.model.QualitymeasureBO;
import com.taikang.udp.framework.common.datastructre.Dto;

import java.util.HashMap;

import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * QualitymeasureController
  */
@Controller("qualitymeasureController")
@RequestMapping(value="/qualitymeasure")
public class QualitymeasureController  extends BaseController  {
		
	@Resource(name=IQualitymeasureAction.ACTION_ID)
	private IQualitymeasureAction qualitymeasureAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showQualitymeasureIndexPage() {
		return "qualitymeasure/qualitymeasureIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getQualitymeasureList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = qualitymeasureAction.queryForPage(page);

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
		return "qualitymeasure/qualitymeasureAdd"; 
	}
	
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showQualitymeasureEditPage(String qualityId,Model model) {
		
		if(qualityId!=null && !qualityId.equals(""))
		{
			model.addAttribute("qualityId",qualityId );
		}
		
		return "qualitymeasure/qualitymeasureEdit"; 
	}
	
	/**
	 * 打开详细页面
	 * @return
	 * String
	 */
	@RequestMapping("/view")
	public String showSellerViewPage(String qualityId,Model model) {
		
		if(qualityId!=null && !qualityId.equals(""))
		{
			model.addAttribute("qualityId",qualityId );
		}
		
		return "qualitymeasure/qualitymeasureView"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getQualitymeasureById(@RequestParam("qualityId")String qualityId)
	{
		Dto param = new BaseDto();
		param.put("qualityId", qualityId);
		return qualitymeasureAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveQualitymeasureInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("qualityId") ==null ||"".equals(param.get("qualityId")))
		{
			param.put("qualityId", UUID.randomUUID().toString().replace("-", ""));
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			qualitymeasureAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			qualitymeasureAction.updateObject(param);
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
	public Map<String, String> deleteQualitymeasure(@RequestParam("qualityId") String qualityId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("qualityId", qualityId);
		qualitymeasureAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

