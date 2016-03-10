package com.taikang.iu.biz.appliance.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.biz.appliance.action.IApplianceAction;
import com.taikang.iu.biz.picture.action.IPictureAction;
import com.taikang.iu.biz.picture.model.PictureBO;
import com.taikang.iu.com.CommonUtil;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;


/**
  * ProductController
  */
@Controller("ProductSeatController")
@RequestMapping(value="/productseat")
public class ProductSeatController extends BaseController{
	 
	@Resource(name=IApplianceAction.ACTION_ID)
	private IApplianceAction applianceAction;
	
	@Resource(name=IPictureAction.ACTION_ID)
	private IPictureAction pictureAction;
	 
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showApplianceIndexPage() {
		return "appliance/productseatIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getApplianceList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param=getParamAsDto(request);
		String isMarket=param.getAsString("ismarketable");
		if("".equals(isMarket)||isMarket==null){
			param.put("ismarketable", "2");			
		}
		page.setParamObject(param);
		
		
		CurrentPage currentPage = applianceAction.queryProductSeatForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**
	 * 打开新增或修改页面
	 * @return
	 */
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
		
		return "appliance/productEdit"; 
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
			List <Dto> pictureDtoList = new ArrayList<Dto>();
			String url = CommonUtil.RELATION_UPLOAD_FILEPATH;
			for(int i =0 ;i<pictureList.size();i++){
				Dto pictureDto = new BaseDto();
				pictureDto = pictureList.get(i);
				pictureDto.put("PICTURE_ADDRESS", url+pictureDto.getAsString("PICTURE_ADDRESS"));
				pictureDtoList.add(pictureDto);
			}
			model.addAttribute("describe",dto.getAsString("describe"));
			model.addAttribute("pictureDtoList",pictureDtoList);
			
		}
		
		return "appliance/productseatView"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getApplianceById(@RequestParam("applianceId")String applianceId)
	{
		Dto param = new BaseDto();
		param.put("applianceId", applianceId);
		return applianceAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 * @throws IOException 
	 * @throws FileUploadException 
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
			
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			
			param.put("modifiedTime", param.get("applianceMarketprice"));
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			applianceAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	
	/**
	 * 同意上架
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
				if(dto.getAsString("ismarketable").equals("1")&&!dto.getAsString("applianceMarketprice").equals("")){
					dto.put("ismarketable", 2);
				}
				applianceAction.updateObject(dto);
			}
			map.put(MESSAGE_INFO, "批量修改成功!");
			map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	 *同意下架
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
				if(dto.getAsString("ismarketable").equals("3")){
					dto.put("ismarketable", 4);
				}
				applianceAction.updateObject(dto);
			}
			map.put(MESSAGE_INFO, "批量修改成功!");
			map.put(RTN_RESULT, "true");
		
		return map;
	}

}