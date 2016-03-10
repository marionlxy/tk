package com.taikang.iu.biz.goodscategory.controller;

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
import com.taikang.iu.biz.goodscategory.action.IGoodscategoryAction;
import com.taikang.iu.biz.goodscategory.model.GoodscategoryBO;

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.vo.Tree;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


/**
  * GoodscategoryController
  */
@Controller("goodscategoryController")
@RequestMapping(value="/goodscategory")
public class GoodscategoryController  extends BaseController  {
		
	@Resource(name=IGoodscategoryAction.ACTION_ID)
	private IGoodscategoryAction goodscategoryAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showGoodscategoryIndexPage() {
		return "goodscategory/goodscategoryIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getGoodscategoryList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = goodscategoryAction.queryForPage(page);
		
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
	public String oneRole(Model model) {
		return "goodscategory/goodscategoryAdd"; 
	}

	/**
	 * 打开新增页面
	 * @return   
	 * String
	 */
	@RequestMapping("/addAuto")
	public String oneRoleAuto(@RequestParam("treePath")String treePath,Model model) {
		model.addAttribute("treePath", treePath);
		return "goodscategory/goodscategoryAdd"; 
	}
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showGoodscategoryEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "goodscategory/goodscategoryEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getGoodscategoryById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("categoryId", rowId);
		return goodscategoryAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveGoodscategoryInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		
		if(param.get("categoryId") ==null ||"".equals(param.get("categoryId")))
		{
			String treePath = param.getAsString("treePath");
			int treePath2=Integer.parseInt(treePath); 
			
			param.put("categoryId",param.get("categoryCode"));
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("categoryGrade", treePath2+1);
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			goodscategoryAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			goodscategoryAction.updateObject(param);
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
	public Map<String, String> deleteGoodscategory(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("categoryId", rowId);
		goodscategoryAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 查询所有菜单节点信息列表<br/>
	 * @param request
	 * @param page
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping("/getMenuList4Tree")
	@ResponseBody
	public Map<String,Object> getMenuList4Tree(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();

		List list = goodscategoryAction.findAllMenuTreeLeafMap(getParamAsDto(request));
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2 = (Map<String, Object>) list.get(0);
		map.put("rows", list);
		map.put("total", list.size());
		
		return map;
		
	}
	
	@SuppressWarnings({ "unused", "rawtypes" })
	@RequestMapping(value="/getCategoryComboTree")   
	public  @ResponseBody  List<Dto> getCategoryComboTree(HttpServletRequest request){ 
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dto> menuBOLst = goodscategoryAction.findAllMenuTreeLeafMap(getParamAsDto(request));
		Dto dto=null;
		for(int i=0;i<menuBOLst.size();i++){
			 dto = menuBOLst.get(i);
			menuBOLst.get(i).put("id", dto.getAsString("CATEGORY_ID"));    //_以下滑线开头的变量基本都是固定的 
			menuBOLst.get(i).put("text",dto.getAsString("CATEGORY_NAME"));    //_以下滑线开头的变量基本都是固定的 
			menuBOLst.get(i).put("children", dto.getAsInteger("_parentId"));
		}
		
		return menuBOLst;
	}
	
	/*
	 * 查询字典类别树形菜单
	 * */
	@RequestMapping("/getComTree")
	@ResponseBody
	public List<Tree> getComTree(@RequestParam("id") String id) {

		List<Tree> rtnLst = null;

		String array[] = null;
		if (id != null) {
			array = id.split(",");
			if (array != null && (array.length == 1)) {
				// 获取机构树信息
				rtnLst = goodscategoryAction.getComInfo();
			} else if (array != null && (array.length == 2)) {
				// 获取机构树信息
				rtnLst = goodscategoryAction
				        .getChildrenTreeLst(Integer.valueOf(array[1]),"open");
			}
		} else {
			rtnLst = new ArrayList<Tree>();
		}

		return rtnLst;
	}
	
}

