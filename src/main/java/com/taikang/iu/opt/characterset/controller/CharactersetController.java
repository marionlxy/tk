package com.taikang.iu.opt.characterset.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.characterset.action.ICharactersetAction;
import com.taikang.iu.opt.characterset.model.CharactersetBO;
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
  * CharactersetController
  */
@Controller("charactersetController")
@RequestMapping(value="/characterset")
public class CharactersetController  extends BaseController  {
	
	
		
	@Resource(name=ICharactersetAction.ACTION_ID)
	private ICharactersetAction charactersetAction;
	
	@Resource(name = "fileloadAction")
	private IFileloadAction fileloadAction;
	
	@Resource(name=IfixedAction.ACTION_ID)
	private IfixedAction fixedAction;
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showCharactersetIndexPage() {
		return "characterset/charactersetIndex";
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
		CurrentPage currentPage = charactersetAction.queryForLinkPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	@RequestMapping("/clearList")
	@ResponseBody
	public Map<String,Object> clearList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rows", 0);
		map.put("total", 0);
		
		return map;
	}
	
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getCharactersetList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = charactersetAction.queryForPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}



	@RequestMapping("/addserv")
	public String addServ() {
		return "characterset/checkService"; 
	}	
	@RequestMapping("edit")
	public String showCharactersetEditPage(String linkId,Model model) {
		
		if(linkId!=null && !linkId.equals(""))
		{
			model.addAttribute("linkId",linkId );
		}
		
		return "characterset/charactersetEdit"; 
	}
	


	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveCharactersetInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if(param.get("linkId") ==null ||"".equals(param.get("linkId")))
		{
			param.put("linkId", UUID.randomUUID().toString().replace("-", ""));
		param.put("state", "1"); // “1”代表“使用中”
			param.put("charactersetCode", BusinessSeqGenerator.getInstance("SELLER_CODE").nextId()); 
			param.put("createdBy", loginId);
			param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("delflag", "0"); // “0”代表“未删除”
			param.put("version", 1);
			charactersetAction.insertObject(param);
			map.put(MESSAGE_INFO, "添加成功！");
		}
	else
		{
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(param.get("version").toString())+1);
			charactersetAction.updateObject(param);
			map.put(MESSAGE_INFO, "修改成功！");
		}
	map.put(RTN_RESULT, "true");
		
		return map;
	}
//	

	/**
	*删除一条或多条记录
	*/
	@RequestMapping(value="/del")
	@ResponseBody
	public Map<String, String> deleteCharacterset(@RequestParam("linkId") String linkId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("linkId", linkId);
		charactersetAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	//修改固定 套餐
		@RequestMapping("/editMeal")
		public String showcharactersetMealEditPage(String mealId,Model model) {
			
			if(mealId!=null && !mealId.equals(""))
			{
				model.addAttribute("mealId",mealId );
			}
			
			return "characterset/characterEditMeal"; 
		}
		/**
		 * 查询信息列表
		 * @return 分页服务列表数据
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
		*删除个性套餐
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
			List <CharactersetBO> list = charactersetAction.findDelLink(param);
			if(list.size() != 0 ){
				for (int i = 0; i < list.size(); i++) {
					String linkId =	list.get(i).getLinkId();
					params.put("linkId", linkId);
					List <CharactersetBO> servList = charactersetAction.findCharactersetService(params);
					if(servList.size()!=0){
						for (int j = 0; j < servList.size(); j++) {
							Dto ServiceParam = new BaseDto();
							String srelationId =servList.get(j).getSrelationId();
							ServiceParam.put("srelationId", srelationId);
							List <CharactersetBO> applianceList = charactersetAction.findApplianceList(ServiceParam);
							
							if(applianceList.size()!=0){
								for (int k = 0; k < applianceList.size(); k++) {
									Dto applianceParam = new BaseDto();
									applianceParam.put("relationId", applianceList.get(k).getRelationId());
									applianceParam.put("applianceId", applianceList.get(k).getApplianceId());
									applianceParam.put("delflag", "1"); // “1”代表“已上架”
									applianceParam.put("modifiedBy", loginId);
									applianceParam.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
									charactersetAction.updateAppliance(applianceParam);
								}
								
							}
								serverParam.put("srelationId", srelationId);
								serverParam.put("delflag", "1"); // “1”代表“已上架”
								serverParam.put("modifiedBy", loginId);
								serverParam.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
								charactersetAction.updateServer(serverParam);
							}	
						}	
					params.put("linkId", linkId);
					params.put("delflag", "1"); // “1”代表“已删除”
					params.put("modifiedBy", loginId);
					params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
					charactersetAction.updateLink(params);
					}
				}
				    param.put("mealId", mealId);
					param.put("delflag", "1"); // “1”代表“已删除”
					param.put("modifiedBy", loginId);
					param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
					charactersetAction.updateObject(param);
					map.put(RTN_RESULT, "true");
					map.put(MESSAGE_INFO, "操作成功！");
					return map;
					
		}

		//查看固定 套餐
		@RequestMapping("/viewMeal")
		public String showcharactersetMealViewPage(String mealId,Model model) {
			
			if(mealId!=null && !mealId.equals(""))
			{
				model.addAttribute("mealId",mealId );
				Dto param = new BaseDto();
				param.put("mealId", mealId);
				Dto list = charactersetAction.findOneMeal(param);
				String pictureUrl = list.getAsString("mealPicture");
					String url = CommonUtil.RELATION_UPLOAD_FILEPATH+pictureUrl;
					model.addAttribute("mealPicture",url);
			}
			
			return "characterset/charactersetViewMeal"; 
		}
		//查询单个套餐
		@RequestMapping("/getOne")
		@ResponseBody
		public Dto getMealyId(@RequestParam("mealId")String mealId)
		{
			Dto param = new BaseDto();
			param.put("mealId", mealId);
			return charactersetAction.findOne(param);
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
			CurrentPage currentPage = charactersetAction.findEditLinkPage(page);
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
			CurrentPage currentPage = charactersetAction.findEditLinkPage(page);
		
			map.put("rows", currentPage.getPageItems());
			map.put("total", currentPage.getTotalRows());
			
			return map;
		}
		/**
		 * 查询信息列表
		 * @return 分页用品列表数据
		 */
		@RequestMapping("/ApplianceList")
		@ResponseBody
		public Map<String,Object> getApplianceList(String site,HttpServletRequest request,CurrentPage page){
			Map<String, Object> map = new HashMap<String, Object>();
			Dto param = new BaseDto();
			param.put("site", site);
			page.setParamObject(getParamAsDto(request));
			page.setParamObject(param);
			CurrentPage currentPage = charactersetAction.queryForAppliancePage(page);
			
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
			CurrentPage currentPage = charactersetAction.queryForServicePage(page);
			
			map.put("rows", currentPage.getPageItems());
			map.put("total", currentPage.getTotalRows());
			
			return map;
		}
		/**
		 * 查询信息列表
		 * @return 分页用品列表数据
		 */
		@RequestMapping("/applianceShowList")
		@ResponseBody
		public Map<String,Object> getApplianceShowList(String srelationId,HttpServletRequest request,CurrentPage page){
				Map<String, Object> map = new HashMap<String, Object>();
				Dto param = new BaseDto();
				param.put("srelationId", srelationId);
				page.setParamObject(getParamAsDto(request));
				page.setParamObject(param);
				page.setRows(50);
				CurrentPage currentPage = charactersetAction.queryForShowAppliancePage(page);
				
				map.put("rows", currentPage.getPageItems());
				map.put("total", currentPage.getTotalRows());

			return map;
		}
		/**
		 * 查询信息列表
		 * @return 分页用品列表数据
		 */
		@RequestMapping("/appliancesShowList")
		@ResponseBody
		public Map<String,Object> getAppliancesShowList(String srelationId,HttpServletRequest request,CurrentPage page){
				Map<String, Object> map = new HashMap<String, Object>();
				Dto param = new BaseDto();
				param.put("srelationId", srelationId);
				page.setParamObject(getParamAsDto(request));
				page.setParamObject(param);
				page.setRows(50);
				CurrentPage currentPage = charactersetAction.queryForShowAppliancePage(page);
				
				map.put("rows", currentPage.getPageItems());
				map.put("total", currentPage.getTotalRows());
			
			return map;
		}
		
		/**
		 * 查询信息列表
		 * @return 分页用品列表数据
		 */
		@RequestMapping("/appliancesShowList1")
		@ResponseBody
		public Map<String,Object> getAppliancesShowList1(String serviceId,HttpServletRequest request,CurrentPage page){
			Map<String, Object> map = new HashMap<String, Object>();
			Dto param = new BaseDto();
			Dto para = new BaseDto();
			CurrentPage pages = new CurrentPage();
			Dto params = getParamAsDto(request);
			page.setParamObject(getParamAsDto(request));
			param.put("serviceId", params.get("serviceId"));
			param.put("linkId", params.get("linkId"));
			List <CharactersetBO> serviceList = charactersetAction.searchOneService(param);
			if(serviceList.size()!=0){
				para.put("srelationId", serviceList.get(0).getSrelationId());
				pages.setParamObject(para);
				CurrentPage currentPage = charactersetAction.queryForShowAppliancePage(pages);
				map.put("rows", currentPage.getPageItems());
				map.put("total", currentPage.getTotalRows());
			}else{
				map.put("rows", 0);
				map.put("total",0);
			}
			
			return map;
		}



		/**
		 * 打开新增套餐页面
		 * @return   
		 * String
		 */
		@RequestMapping("/addcharacterset")
		public String addCharacterset() throws Exception{
			
			Dto params = new BaseDto();
			Dto param = new BaseDto();
			Dto para = new BaseDto();
			Dto serverParam = new BaseDto();
			Dto linkParam = new BaseDto();
				param.put("delfalg", "1");
				List <CharactersetBO> list = charactersetAction.findLink(param);
				if(list.size()>0){
					for (int i = 0; i < list.size(); i++) {
						String linkId =	list.get(i).getLinkId();
						params.put("linkId", linkId);
						List<CharactersetBO> serviceList = charactersetAction.findCharactersetService(params);
						if(serviceList.size()!=0){
							for (int k = 0; k < serviceList.size(); k++) {
								serverParam.put("srelationId", serviceList.get(k).getSrelationId());
				                 List <CharactersetBO> applianceList = charactersetAction.findDelApplianceList(serverParam);
				                if(applianceList.size()!=0){
					                 for (int j = 0; j < applianceList.size(); j++) {
						                   Dto applianceParam = new BaseDto();
						                   applianceParam.put("applianceId", applianceList.get(j).getApplianceId());
						                   String srelationId =	serviceList.get(k).getSrelationId();
						                    applianceParam.put("srelationId", srelationId);
						                   List <CharactersetBO> list1 = charactersetAction.findRelation(applianceParam);
						                   for (int l = 0; l < list1.size(); l++) {
						                	   para.put("relationId", list1.get(l).getRelationId());
			                                      charactersetAction.delAppliance(para);
										}
						                           
					                }
			                    }
				                	charactersetAction.delService(serverParam);
							 }
						}
						charactersetAction.deleteLink(params);
					}
				}
				
				
				return "characterset/charactersetAddSet"; 
		}
		
		//查询所有站点服务
		@RequestMapping("/checkService")
		public String checkService(String flag,String linkId,Model model) {
			Dto param = new BaseDto();
			param.put("site", flag);
			List<CharactersetBO>  serviceList = charactersetAction.findAllServerService(param);
			model.addAttribute("serviceList",serviceList);
			model.addAttribute("site", flag);
			model.addAttribute("linkId", linkId);
			return "characterset/checkService";
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
			page.setRows(50);
			CurrentPage currentPage = charactersetAction.findOneService(page);
			
			map.put("rows", currentPage.getPageItems());
			map.put("total", currentPage.getTotalRows());
			
			return map;
		}
		
		//打开选中用品页面
		@RequestMapping("/checkAppliance")
		public String checkAppliance(String flag,String srelationId,Model model) {
			Dto param = new BaseDto();
			param.put("site", flag);
			List<CharactersetBO>  applianceList = charactersetAction.findAllAppliance(param);
			model.addAttribute("applianceList",applianceList);
			model.addAttribute("flag", flag);
			model.addAttribute("srelationId", srelationId);
			return "characterset/checkAppliance";
		}
		
		//打开选中用品页面
		@RequestMapping("/checkEditAppliance")
		public String checkEditAppliance(String flag,String serviceId,Model model) {
			Dto param = new BaseDto();
			param.put("site", flag);
			List<CharactersetBO>  applianceList = charactersetAction.findAllAppliance(param);
			model.addAttribute("applianceList",applianceList);
			model.addAttribute("flag", flag);
			model.addAttribute("serviceId", serviceId);
			return "characterset/checkEditAppliance";
		}
		
		/**
		 * 打开修改新增环节页面
		 * @return   
		 * String
		 */

		@RequestMapping("/addLink")
		public String addLink(String site,String mealId,Model model) {
			if(mealId!=null && !mealId.equals(""))
			{
				model.addAttribute("mealId",mealId );
			}
			return "characterset/charactersetAddLink"; 
		}
		/**
		 * 打开新增环节页面
		 * @return   
		 * String
		 */
		
		@RequestMapping("/addLinks")
		public String addLinks(String site) {
			return "characterset/characterAddLinks"; 
		}
		/**
		 * 添加套餐
		 */
		@SuppressWarnings("unchecked")
		@RequestMapping("/saveMeal")
		@ResponseBody
		public Map<String, String> saveMeal(String mealId,HttpServletRequest request) {
			Map<String,String> map=new HashMap<String,String>();
			List<CharactersetBO> list = new ArrayList();
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			Dto param = getParamAsDto(request);
			Dto params = new BaseDto();
			Dto paras = new BaseDto();
			Dto parss = new BaseDto();
			Dto para = new BaseDto();
			if(null==param.get("mealId")||"".equals(param.get("mealId"))){
				String meaId = UUID.randomUUID().toString().replace("-", "");
				params.put("mealId",meaId );
				params.put("mealConte", param.get("mealConte"));
				params.put("mealPicture", param.get("mealPicture"));
				params.put("createdBy", loginId);
				params.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
				params.put("delflag", "0"); // “0”代表“未删除”
				params.put("version", 1);
				params.put("mealName", param.get("mealName"));
				params.put("state", "1");
//				params.put("mealType", param.get("mealType"));
				params.put("site", param.get("site"));
				charactersetAction.insertObject(params);
				para.put("mealId", meaId);
				paras.put("delflag", 0);
				list = charactersetAction.findLink(paras);
				for (int i = 0; i < list.size(); i++) {
					para.put("linkId", list.get(i).getLinkId());
					charactersetAction.updateLink(para);
				}
				map.put(MESSAGE_INFO, "添加套餐成功！");
				map.put("sId", meaId);
			}else{
				parss.put("mealName", param.get("mealName"));
				if(mealId.contains(",")){
					mealId=mealId.substring(0, mealId.indexOf(","));
				}
				parss.put("mealId", mealId);
//				parss.put("mealType", param.get("mealType"));
				parss.put("mealConte", param.get("mealConte"));
				parss.put("mealPicture", param.get("mealPicture"));
//				try {
//					String imgUrl = fileloadAction.uploadBySpringGrpCharacter(request);
//					if(imgUrl!=null && !"".equals(imgUrl)){
//						parss.put("mealPicture", imgUrl);
//					}
//				} catch (TKCheckedException e) {
//				}
				charactersetAction.updateObject(parss);
				paras.put("delflag", 0);
				list = charactersetAction.findLink(paras);
				if(list.size()>0){
					para.put("mealId", mealId);
					for (int i = 0; i < list.size(); i++) {
						para.put("linkId", list.get(i).getLinkId());
						charactersetAction.updateLink(para);
					}
				}
				map.put(MESSAGE_INFO, "更新成功！");
			}
			map.put(RTN_RESULT, "true");
			return map;
		}
		@RequestMapping("/goMain")
		public String goMain() {
			return "characterset/charactersetIndex"; 
		}
		
		@RequestMapping("/goMains")
		public String goMainS() {

			return "characterset/charactersetIndex"; 
		}
		
		@RequestMapping("/uploadBySpringGrpCharacter")
		public String uploadBySpringGrpCharacter(HttpServletRequest request,
				HttpServletResponse response)  {
			Map<String, String> map = new HashMap<String, String>();
				try {
					String pictureUrl = charactersetAction.uploadBySpringGrpFixed(request);
				} catch (Exception e) {
				}
				
			return "characterset/charactersetIndex";
		}
		/**
		 * 修改环节页面
		 * @return
		 */
		@RequestMapping("/editLink")
		public String showcharactersetEditPage(String linkId,Model model) {
			
			if(linkId!=null && !linkId.equals(""))
			{
				model.addAttribute("linkId",linkId );
			}
			
			return "characterset/characterLinkEdit"; 
		}
		/**
		 * 修改套餐环节页面
		 * @return
		 */
		@RequestMapping("/editLinkMeal")
		public String showcharactersetEditPage1(String linkId,String mealId,Model model) {
			
			if(linkId!=null && !linkId.equals(""))
			{
				model.addAttribute("linkId",linkId );
			}
			if(mealId!=null && !mealId.equals(""))
			{
				model.addAttribute("mealId",mealId );
			}
			
			return "characterset/characterLinkMealEdit"; 
		}
		
		/**
		 * 发布固定套餐
		 * 
		 * 
		 */
		@RequestMapping("/shelves")
		public String shelvesEditPage(String mealId,Model model) {
			
			if(mealId!=null && !mealId.equals(""))
			{
				model.addAttribute("mealId",mealId );
			}
			
			return "characterset/charactersetShelves"; 
		}
		
		

		/**
		 * 获取一条记录详细信息，用来填充修改界面
		 * @return
		 */
		@RequestMapping("/getOneMeal")
		@ResponseBody
		public Dto getcharactersetById(@RequestParam("mealId")String mealId)
		{
			Dto param = new BaseDto();
			param.put("mealId", mealId);
			return charactersetAction.findOneMeal(param);
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
			return charactersetAction.findOneLink(param);
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
				charactersetAction.insertLink(param);
				map.put(MESSAGE_INFO, "新增成功！");
			}else{
				charactersetAction.updateLink(param);
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
		private Map<String,String> saveLinkServer(String applianceId,String srelationId,HttpServletRequest request)
		{
			Map<String,String> map=new HashMap<String,String>();
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			if(srelationId==null||srelationId.equalsIgnoreCase("Undefined")){
				map.put(MESSAGE_INFO, "请选择服务！");
			}else{
				String[] id = applianceId.split(",");
				for (int i = 0; i < id.length; i++) {
					Dto applianceParam = new BaseDto();
					Dto appliancParam = new BaseDto();
					Dto servicearam = new BaseDto();
					appliancParam.put("applianceId", id[i]);
					applianceParam.put("applianceId", id[i]);
					applianceParam.put("srelationId", srelationId);
					List<CharactersetBO> applianceList = charactersetAction.searchAppliance(applianceParam);
					List<CharactersetBO> AppliancList = charactersetAction.searchOneAppliance(appliancParam);
					if(applianceList.size()!=0){
						Dto appParam = new BaseDto();
						appParam.put("relationId", applianceList.get(0).getRelationId());
						appParam.put("applianceCoding", AppliancList.get(0).getApplianceCoding());
						appParam.put("srelationId", srelationId);
						appParam.put("delflag", "0");
						charactersetAction.updateAppliance(appParam);
					}else{
							Dto param = new BaseDto();
							param.put("relationId", UUID.randomUUID().toString().replace("-", ""));
							param.put("srelationId", srelationId);
							param.put("applianceCoding", AppliancList.get(0).getApplianceCoding());
							param.put("applianceId", id[i]);
							param.put("createdBy", loginId);
							param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
							param.put("delflag", "0"); // “0”代表“未删除”
							param.put("version", 1);
							charactersetAction.insertLinkServer(param);
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
			Dto serviceParam = new BaseDto();
			if(linkId==null||linkId.equalsIgnoreCase("Undefined")){
				map.put(MESSAGE_INFO, "请选择环节！");
			}else{	
					params.put("linkId", linkId);
					String[] id = serviceId.split(",");
					for (int i = 0; i < id.length; i++) {
						Dto serParam = new BaseDto();
						Dto serviParam = new BaseDto();
						serParam.put("linkId", linkId);
						serParam.put("serviceId", id[i]);
						
					List<CharactersetBO> findCharactersetService = charactersetAction.findOneLinkService(serParam);
					
					if(findCharactersetService.size()==0){
						serviceParam.put("srelationId", UUID.randomUUID().toString().replace("-", ""));
						if(linkId.contains(",")){
							linkId=linkId.substring(0, linkId.indexOf(","));
							serviceParam.put("linkId", linkId);
						}else{
							serviceParam.put("linkId", linkId);
						}
						
							serviceParam.put("serviceId", id[i]);
							serviceParam.put("createdBy", loginId);
							serviceParam.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
							serviceParam.put("delflag", "0"); // “0”代表“未删除”
							serviceParam.put("version", 1);
							charactersetAction.insertServer(serviceParam);
						
						
							map.put(MESSAGE_INFO, "新增成功！");
					}else{
						serviceParam.put("srelationId", findCharactersetService.get(0).getSrelationId());
						serviceParam.put("serviceId", id[i]);
						serviceParam.put("modifiedBy", loginId);
						serviceParam.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
						charactersetAction.updateServer(serviceParam);
						map.put(MESSAGE_INFO, "更新成功！");
					}
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
			Dto para = new BaseDto();
			param.put("linkId", linkId);
			List <CharactersetBO> serviceList = charactersetAction.searchOneService(param);
			if(serviceList.size()!=0){
				para.put("srelationId", serviceList.get(0).getSrelationId());
				List <CharactersetBO> applianceList = charactersetAction.findApplianceList(para);
				if(applianceList.size()!=0){
					map.put("MESSAGE_INFO", "此环节下有用品");
				}else{
					params.put("srelationId", serviceList.get(0).getSrelationId());
					params.put("delflag", "1"); // “1”代表“已删除”
					params.put("modifiedBy", loginId);
					params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
					charactersetAction.updateServer(params);
					param.put("delflag", "1"); // “1”代表“已删除”
					param.put("modifiedBy", loginId);
					param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
					charactersetAction.updateLink(param);
					map.put(RTN_RESULT, "true");
					map.put(MESSAGE_INFO, "操作成功！");
				}
				
			}else{
				param.put("delflag", "1"); // “1”代表“已删除”
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				charactersetAction.updateLink(param);
				map.put(RTN_RESULT, "true");
				map.put(MESSAGE_INFO, "操作成功！");
			}
			return map;
		}
	/**
	 *删除一条或多条用品
	 */
	@RequestMapping(value="/delAppliances")
	@ResponseBody
	public Map<String, String> delAppliances(@RequestParam("applianceId") String applianceId,String srelationId,HttpServletRequest request) {
//		Map<String, String> map = new HashMap<String, String>();
//		Dto param = new BaseDto();
//		param.put("applianceId", applianceId);
//		charactersetAction.delAppliance(param);
		Map<String, String> map = new HashMap<String, String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = new BaseDto();
		Dto params = new BaseDto();
		Dto para = getParamAsDto(request);
		param.put("applianceId", applianceId);
		param.put("srelationId", srelationId);
		params.put("delflag", "1"); // “1”代表“已上架”
		params.put("modifiedBy", loginId);
		params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
		List <CharactersetBO> list = charactersetAction.findUpdateRelation(param);
		params.put("relationId", list.get(0).getRelationId());
		charactersetAction.updateAppliance(params);
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	/**
	 *删除服务
	 */
	@RequestMapping(value="/delService")
	@ResponseBody
	public Map<String, String> delService(@RequestParam("srelationId") String srelationId,@RequestParam("version") String version,String linkId,HttpServletRequest request) {
//		Map<String, String> map = new HashMap<String, String>();
//		Dto param = new BaseDto();
//		param.put("applianceId", applianceId);
//		charactersetAction.delAppliance(param);
		Map<String, String> map = new HashMap<String, String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = new BaseDto();
		Dto paras = new BaseDto();
		Dto params = new BaseDto();
		Dto para = getParamAsDto(request);
		param.put("srelationId", srelationId);
		param.put("linkId", linkId);
		
		List <CharactersetBO> list = charactersetAction.findOneLinkService(param);
		if(list.size()!=0){
			paras.put("srelationId", srelationId);
			List<CharactersetBO> appList = charactersetAction.findApplianceList(paras);
			if(appList.size()!=0){
				map.put(MESSAGE_INFO, "此服务下有用品，请先删除用品");
			}else{
				params.put("delflag", "1"); // “1”代表“已上架”
				params.put("modifiedBy", loginId);
				params.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				params.put("srelationId", srelationId);
				params.put("version", Integer.parseInt(version)+1);
				charactersetAction.updateServer(params);
				map.put(MESSAGE_INFO, "删除成功！");
			}
			map.put(RTN_RESULT, "true");
		}

		return map;
	}
}

