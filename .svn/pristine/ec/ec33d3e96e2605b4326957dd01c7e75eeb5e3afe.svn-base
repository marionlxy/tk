package com.taikang.iu.biz.appliance.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.biz.appliance.action.IApplianceAction;
import com.taikang.iu.biz.appliancesku.model.ApplianceskuBO;
import com.taikang.iu.biz.appliancesku.service.IApplianceskuService;
import com.taikang.iu.biz.picture.action.IPictureAction;
import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.characterset.action.ICharactersetAction;
import com.taikang.iu.opt.employee.action.IEmployeeAction;
import com.taikang.iu.opt.fixed.action.IfixedAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IUserRoleAction;
import com.taikang.udp.sys.model.RoleBO;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;

/**
 * ProductController
 */
@Controller("ProductController")
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

	@Resource(name = IApplianceAction.ACTION_ID)
	private IApplianceAction applianceAction;

	@Resource(name = IPictureAction.ACTION_ID)
	private IPictureAction pictureAction;

	@Resource(name = IfixedAction.ACTION_ID)
	private IfixedAction fixedAction;

	@Resource(name = ICharactersetAction.ACTION_ID)
	private ICharactersetAction charactersetAction;
	
	@Resource(name=IEmployeeAction.ACTION_ID)
	private IEmployeeAction employeeAction;
	
	//用户角色表
	@Resource(name=IUserRoleAction.ACTION_ID)
	private IUserRoleAction userRoleAction;
		
    /**
     * 注入service
     */
   @Resource(name=IApplianceskuService.SERVICE_ID)
	private IApplianceskuService<ApplianceskuBO> applianceskuService;	
	

	/**
	 * 打开主查询页面
	 * 
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showApplianceIndexPage() {
		return "appliance/productIndex";
	}

	/**
	 * 查询信息列表
	 * 
	 * @return 分页列表数据
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> getApplianceList(HttpServletRequest request,
			CurrentPage page) {
		Dto param=getParamAsDto(request);
		Map<String, Object> map = new HashMap<String, Object>();
		LoginUser user = UserUtils.getUser();
		String currLoginId = String.valueOf(user.getUserId());
		//根据userId，获取角色
		Dto paramRole = new BaseDto();
		paramRole.put("userId",currLoginId);
		paramRole.put("roleId","2104");
		Dto userRole = userRoleAction.findOne(paramRole);
		boolean isyunyingm=false;
		if(!userRole.isEmpty()){
			isyunyingm=true;
		}
//		for(RoleBO role:roleList){//该循环用来判断当前登录账号是否为运营经理
//			String roleCode=role.getRoleCode();
//			if(roleCode!=null&&!"".equals(roleCode)&&"yunyingm".equals(roleCode)){
//				isyunyingm=true;
//				break;
//			}
//		}
		if(!isyunyingm){//如果当前账号不是运营经理则显示该员工所属站点的用品
			String loginId = String.valueOf(user.getUserId());
			Dto paramEmploy = new BaseDto();
			paramEmploy.put("userId", loginId);
			Dto currEmployee=employeeAction.findOne(paramEmploy);
			System.out.println(currEmployee.toJson());
			if(currEmployee!=null&&currEmployee.getAsString("SITE")!=null&&!"".equals(currEmployee.getAsString("SITE"))){
				param.put("serviceSite", currEmployee.getAsString("SITE"));			
			}			
		}
		page.setParamObject(param);
		CurrentPage currentPage = applianceAction.queryPriductForPage(page);

		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());

		return map;
	}

	/**
	 * 打开新增或修改页面
	 * 
	 * @return
	 */
	@RequestMapping("edit")
	public String showApplianceEditPage(String applianceId, Model model) {

		if (applianceId != null && !applianceId.equals("")) {
			model.addAttribute("applianceId", applianceId);
			Dto param = new BaseDto();
			Dto picturedto = new BaseDto();
			param.put("applianceId", applianceId);
			picturedto.put("appliance_id", applianceId);
			Dto dto = applianceAction.findOne(param);
			List<Dto> pictureList = pictureAction.findAll(picturedto);
			List<Dto> pictureDtoList = new ArrayList<Dto>();
			String url = CommonUtil.RELATION_UPLOAD_FILEPATH;
			for (int i = 0; i < pictureList.size(); i++) {
				Dto pictureDto = new BaseDto();
				pictureDto = pictureList.get(i);
				pictureDto.put("PICTURE_ADDRESS",
						url + pictureDto.getAsString("PICTURE_ADDRESS"));
				pictureDtoList.add(pictureDto);
			}
			model.addAttribute("pictureDtoList", pictureDtoList);
			model.addAttribute("describe", dto.getAsString("describe"));
		}

		return "appliance/productEdit";
	}

	/**
	 * 打开详细页面
	 * 
	 * @return String
	 */
	@RequestMapping("/view")
	public String showSellerViewPage(String applianceId, Model model) {

		if (applianceId != null && !applianceId.equals("")) {
			model.addAttribute("applianceId", applianceId);
			Dto param = new BaseDto();
			Dto picturedto = new BaseDto();
			param.put("applianceId", applianceId);
			picturedto.put("appliance_id", applianceId);
			Dto dto = applianceAction.findOne(param);
			List<Dto> pictureList = pictureAction.findAll(picturedto);
			List<Dto> pictureDtoList = new ArrayList<Dto>();
			String url = CommonUtil.RELATION_UPLOAD_FILEPATH;
			for (int i = 0; i < pictureList.size(); i++) {
				Dto pictureDto = new BaseDto();
				pictureDto = pictureList.get(i);
				pictureDto.put("PICTURE_ADDRESS",
						url + pictureDto.getAsString("PICTURE_ADDRESS"));
				pictureDtoList.add(pictureDto);
			}
			model.addAttribute("pictureDtoList", pictureDtoList);
			model.addAttribute("describe", dto.getAsString("describe"));
		}

		return "appliance/productView";
	}

	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * 
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getApplianceById(@RequestParam("applianceId") String applianceId) {
		Dto param = new BaseDto();
		param.put("applianceId", applianceId);
		return applianceAction.findOne(param);
	}

	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileUploadException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String, String> saveApplianceInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();

		Dto param = getParamAsDto(request);
		if (param.get("applianceId") == null
				|| "".equals(param.get("applianceId"))) {

			map.put(MESSAGE_INFO, "新增成功！");
		} else {

//			param.put("modifiedTime", param.get("applianceMarketprice"));
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version",
					Integer.parseInt(param.get("version").toString()) + 1);
			applianceAction.updateObject(param);			
			ApplianceskuBO  appliancesku = new ApplianceskuBO();
			appliancesku.setApplianceId(param.get("applianceId").toString());
			appliancesku.setPrice(new BigDecimal((String)param.get("applianceMarketprice")));
			applianceskuService.updateSKUByApplianceId(appliancesku);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");

		return map;
	}

	/**
	 * 同意上架
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLinkServers")
	@ResponseBody
	private Map<String, String> saveLinkServers(String applianceId,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		// LoginUser user = UserUtils.getUser();
		Dto param = getParamAsDto(request);
		String[] id = applianceId.split(",");
		for (int i = 0; i < id.length; i++) {
			param.put("applianceId", id[i]);
			Dto dto = applianceAction.findOne(param);
			if (!dto.getAsString("ismarketable").equals("1")
					|| dto.getAsString("applianceMarketprice").equals("")) {
				map.put(MESSAGE_INFO, "审批失败：<br/>1,所选商品是否已维护销售价格!<br/>2,请检查所选商品是否全部为“申请上架”状态!");
				map.put(RTN_RESULT, "false");
				return map;
			}
		}
		for (int i = 0; i < id.length; i++) {
			param.put("applianceId", id[i]);
			Dto dto = applianceAction.findOne(param);
			if (dto.getAsString("ismarketable").equals("1")
					&& !dto.getAsString("applianceMarketprice").equals("")) {
				dto.put("ismarketable", 2);
			}
			applianceAction.updateObject(dto);
		}
		map.put(MESSAGE_INFO, "批量修改成功!");
		map.put(RTN_RESULT, "true");

		return map;
	}

	/**
	 * 不同意上架
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLinkServersNo")
	@ResponseBody
	private Map<String, String> saveLinkServersNo(String applianceId,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		// LoginUser user = UserUtils.getUser();
		Dto param = getParamAsDto(request);
		String[] id = applianceId.split(",");
		for (int i = 0; i < id.length; i++) {
			param.put("applianceId", id[i]);
			Dto dto = applianceAction.findOne(param);
			if (dto.getAsString("ismarketable").equals("1")) {
				dto.put("ismarketable", 4);
			}
			applianceAction.updateObject(dto);
		}
		map.put(MESSAGE_INFO, "批量修改成功!");
		map.put(RTN_RESULT, "true");

		return map;
	}

	/**
	 * 同意下架
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLinkServerx")
	@ResponseBody
	private Map<String, String> saveLinkServerx(String applianceId,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		// LoginUser user = UserUtils.getUser();
		Dto param = getParamAsDto(request);
		String[] id = applianceId.split(",");
		// 判断 改用品是否为固定或者个性套餐的用品
		for (int i = 0; i < id.length; i++) {
			param.put("applianceId", id[i]);
			int count1 = fixedAction.findApplianList(param).size();
			int count2 = charactersetAction.searchAppliance(param).size();
			if (count1 > 0 || count2 > 0) {
				map.put(MESSAGE_INFO, "此用品已在套餐中使用，不允许下架!");
				map.put(RTN_RESULT, "false");
				return map;
			}
		}
		for (int i = 0; i < id.length; i++) {
			param.put("applianceId", id[i]);
			Dto dto = applianceAction.findOne(param);
			if (dto.getAsString("ismarketable").equals("3")) {
				dto.put("ismarketable", 4);
			}
			applianceAction.updateObject(dto);
		}
		map.put(MESSAGE_INFO, "批量修改成功!");
		map.put(RTN_RESULT, "true");

		return map;
	}

	/**
	 * 不同意下架
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveLinkServerxNo")
	@ResponseBody
	private Map<String, String> saveLinkServerxNo(String applianceId,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		// LoginUser user = UserUtils.getUser();
		Dto param = getParamAsDto(request);
		String[] id = applianceId.split(",");
		for (int i = 0; i < id.length; i++) {
			param.put("applianceId", id[i]);
			Dto dto = applianceAction.findOne(param);
			if (dto.getAsString("ismarketable").equals("3")) {
				dto.put("ismarketable", 2);
			}
			applianceAction.updateObject(dto);
		}
		map.put(MESSAGE_INFO, "批量修改成功!");
		map.put(RTN_RESULT, "true");

		return map;
	}

}