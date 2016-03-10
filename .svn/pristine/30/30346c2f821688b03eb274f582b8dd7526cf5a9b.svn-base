package com.taikang.iu.opt.prefer.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.opt.prefer.action.IPreferAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * PreferController
  */
@Controller("preferController")
@RequestMapping(value="/prefer")
public class PreferController  extends BaseController  {
		
	@Resource(name=IPreferAction.ACTION_ID)
	private IPreferAction preferAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showPreferIndexPage() {
		return "prefer/preferIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getPreferList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = preferAction.queryForPage(page);
		
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
	public String addPrefer() {
		return "/prefer/preferAdd"; 
	}
	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showPreferEditPage(String preferId,Model model) {
		
		if(preferId!=null && !preferId.equals(""))
		{
			model.addAttribute("preferId",preferId );
		}
		
		return "prefer/preferEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getPreferById(@RequestParam("preferId")String preferId)
	{
		Dto param = new BaseDto();
		param.put("preferId", preferId);
		return preferAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> savePreferInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("preferId") ==null ||"".equals(param.get("preferId")))
		{
			param.put("preferId", UUID.randomUUID().toString().replace("-", ""));
			param.put("createdBy",loginId);
			param.put("createdTime",TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", 1);
			param.put("delflag", 0);
			preferAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			preferAction.updateObject(param);
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
	public Map<String, String> deletePrefer(@RequestParam("preferId") String preferId,@RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("preferId", preferId);
		param.put("delflag", 1);
		preferAction.updateObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	/**
	 * 判断优惠区间
	 * @author t-zhaohan
	 * @Credited 2015年4月15日 下午5:43:29
	 * @see       [相关类/方法]
	 * @return
	 */
	    @SuppressWarnings("unchecked")
		@RequestMapping(value="/confrimRefer")
	    public void confrimRefer(String lowerLimit,String upperLimit,HttpServletResponse response)throws IOException{
	    	   response.setContentType("text/json; charset=UTF-8");
			   response.setHeader("Cache-Control", "no-cache");
			   Dto dto = new BaseDto();
//			   dto.put("lowerLimit", lowerLimit);
//			   dto.put("upperLimit", upperLimit);
			   BigDecimal A_ = new BigDecimal(lowerLimit);
			   BigDecimal A = new BigDecimal(upperLimit);
			   
			   List<Dto> currentList = preferAction.findPreferAll(dto);
			   int flag = 1;
			   if(currentList.size()>0){
			   for(int i = 0 ; i < currentList.size(); i ++){

				   String lowe = currentList.get(i).get("LOWER_LIMIT").toString();
				   BigDecimal B_ = new BigDecimal(lowe);
				   
				   String upper = currentList.get(i).get("UPPER_LIMIT").toString();
				   BigDecimal B = new BigDecimal(upper);
				   
				   if(A_.compareTo(B_) == -1 && A.compareTo(B_) == -1 || A_.compareTo(B) == 1){
					   flag = 1;
				   }else{
					   flag = 0;
					   break;
				   }
			   }
			   }
				List<String> listZtree = new ArrayList<String>();
				String treeNodes = "";
				   treeNodes = "{id:'"+flag+"'}";
					listZtree.add(treeNodes);
			   JSONArray json = JSONArray.fromObject(listZtree);
			   response.getWriter().print(json); 
			   response.getWriter().flush();
			   response.getWriter().close();
	    }
	    /**
		 * 判断优惠区间
		 * @author t-zhaohan
		 * @Credited 2015年4月15日 下午5:43:29
		 * @see       [相关类/方法]
		 * @return
		 */
		    @SuppressWarnings("unchecked")
			@RequestMapping(value="/confrimUpdateRefer")
		    public void confrimUpdateRefer(String lowerLimit,String upperLimit,String preferId,HttpServletResponse response)throws IOException{
		    	   response.setContentType("text/json; charset=UTF-8");
				   response.setHeader("Cache-Control", "no-cache");
				   Dto dto = new BaseDto();
//				   dto.put("lowerLimit", lowerLimit);
				   dto.put("preferId", preferId);
				   
				   BigDecimal A_ = new BigDecimal(lowerLimit);
				   BigDecimal A = new BigDecimal(upperLimit);
				   
				   List<Dto> currentList = preferAction.findPreferAll(dto);
				   int flag = 1;
				   if(currentList.size() > 0){
				   for(int i = 0 ; i < currentList.size(); i ++){

					   String lowe = currentList.get(i).get("LOWER_LIMIT").toString();
					   BigDecimal B_ = new BigDecimal(lowe);
					   
					   String upper = currentList.get(i).get("UPPER_LIMIT").toString();
					   BigDecimal B = new BigDecimal(upper);
					   
					   if(A_.compareTo(B_) == -1 && A.compareTo(B_) == -1 || A_.compareTo(B) == 1){
						   flag = 1;
					   }else{
						   flag = 0;
						   break;
					   }
				   }
				   }
					List<String> listZtree = new ArrayList<String>();
					String treeNodes = "";
					   treeNodes = "{id:'"+flag+"'}";
						listZtree.add(treeNodes);
				   JSONArray json = JSONArray.fromObject(listZtree);
				   response.getWriter().print(json); 
				   response.getWriter().flush();
				   response.getWriter().close();
		    }
}

