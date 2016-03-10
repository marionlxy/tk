package com.taikang.iu.opt.cemetery.controller;

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

import javax.annotation.Resource;

import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import com.taikang.iu.com.CommonUtil;
import com.taikang.iu.opt.cemetery.action.ICemeteryAction;

import org.springframework.web.bind.annotation.ResponseBody;


/**
 * CemeteryController
 */
@Controller("cemeteryController")
@RequestMapping(value = "/cemetery")
public class CemeteryController extends BaseController {

	@Resource(name = ICemeteryAction.ACTION_ID)
	private ICemeteryAction cemeteryAction;

	/**
	 * 打开主查询页面
	 * 
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showCemeteryIndexPage() {
		return "cemetery/cemeteryIndex";
	}

	/**
	 * 返回陵园列表
	 * 
	 * @return
	 */
	@RequestMapping("/goMains")
	public String goMainS() {
		return "cemetery/cemeteryIndex";
	}

	/**
	 * 查询信息列表
	 * 
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> getCemeteryList(HttpServletRequest request,
			CurrentPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = cemeteryAction.queryForPage(page);

		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());

		return map;
	}

	/**
	 * 打开新增页面
	 * 
	 * @return
	 */
	@RequestMapping("add")
	public String showCemeteryAddPage(String cemeteryId, Model model) {

		if (cemeteryId != null && !cemeteryId.equals("")) {
			model.addAttribute("cemeteryId", cemeteryId);
		}

		return "cemetery/cemeteryAdd";
	}

	/**
	 * 打开详细页面
	 * 
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/view")
	public String showCemteryViewPage(String cemeteryId, Model model) {

		if (cemeteryId != null && !cemeteryId.equals("")) {
			model.addAttribute("cemeteryId", cemeteryId);
			Dto param = new BaseDto();
			param.put("cemeteryId", cemeteryId);
			Dto list = cemeteryAction.findOne(param);
			List urlList = new ArrayList();
			String pictureUrl = list.getAsString("realUrl");
			if (pictureUrl != null && !"".equals(pictureUrl)) {
				String[] split = pictureUrl.split(",");
				for (int i = 0; i < split.length; i++) {
					Map map = new BaseDto();
					String url = CommonUtil.RELATION_UPLOAD_FILEPATH + split[i];
					map.put("url", url);
					// String url = "/upload/"+split[i];
					urlList.add(map);

				}
			}
			model.addAttribute("urlList", urlList);

		}
		return "cemetery/showCemetery";
	}

	/**
	 * 打开修改页面
	 * 
	 * @return
	 */
	@RequestMapping("edit")
	public String showCemeteryEditPage(String cemeteryId, Model model) {

		if (cemeteryId != null && !cemeteryId.equals("")) {
			model.addAttribute("cemeteryId", cemeteryId);
		}

		return "cemetery/cemeteryEdit";
	}

	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * 
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getCemeteryById(@RequestParam("cemeteryId") String cemeteryId) {
		Dto param = new BaseDto();
		param.put("cemeteryId", cemeteryId);
		Dto cemetery = cemeteryAction.findOne(param);
		// 对textarea里的值进行处理
		String cemeteryContent = cemetery.getAsString("cemeteryContent");
		if (cemeteryContent != null && !"".equals(cemeteryContent)) {
			String newCemeteryContent = "";
			for (int i = 0; i < cemeteryContent.split("<br/>").length; i++) {
				newCemeteryContent = newCemeteryContent
						+ cemeteryContent.split("<br/>")[i] + "\n";
			}
			cemetery.put("cemeteryContent", newCemeteryContent);
		}
		return cemetery;
	}

	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/save")
	@ResponseBody
	private Map<String, String> saveCemeteryInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		Dto param = getParamAsDto(request);
		if (param.get("cemeteryId") == null
				|| "".equals(param.get("cemeteryId"))) {
			try {

				// 对textarea里的值进行处理
				String cemeteryContent = param.getAsString("cemeteryContent");
				if (cemeteryContent != null && !"".equals(cemeteryContent)) {
					String newCemeteryContent = "";
					for (int i = 0; i < cemeteryContent.split("\n").length; i++) {
						newCemeteryContent = newCemeteryContent
								+ cemeteryContent.split("\n")[i] + "<br/>";
					}
					param.put("cemeteryContent", newCemeteryContent);
				}
				param.put("site", param.getAsString("sites"));
				param.put("areacode", param.getAsString("areacodes"));
				param.put("cemeteryId",
						UUID.randomUUID().toString().replace("-", ""));
				param.put("createdBy", loginId);
				param.put("createdTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("delflag", "0"); // “0”代表“未删除”
				param.put("version", 1);
				map.put("cId", param.getAsString("cemeteryId"));
				cemeteryAction.insertObject(param);
				map.put(MESSAGE_INFO, "新增成功！");
				map.put(RTN_RESULT, "true");
			} catch (Exception e) {
				map.put(MESSAGE_INFO, "新增失败！");
				map.put(RTN_RESULT, "false");
			}
		} else {
			try {
				// 对textarea里的值进行处理
				String cemeteryContent = param.getAsString("cemeteryContent");
				if (cemeteryContent != null && !"".equals(cemeteryContent)) {
					String newCemeteryContent = "";
					for (int i = 0; i < cemeteryContent.split("\n").length; i++) {
						newCemeteryContent = newCemeteryContent
								+ cemeteryContent.split("\n")[i] + "<br/>";
					}
					param.put("cemeteryContent", newCemeteryContent);
				}
				param.put("modifiedBy", loginId);
				param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
				param.put("version", param.getAsInteger("version") + 1);
				cemeteryAction.updateObject(param);
				map.put(MESSAGE_INFO, "更新成功！");
				map.put(RTN_RESULT, "true");
			} catch (Exception e) {
				map.put(MESSAGE_INFO, "更新失败！");
				map.put(RTN_RESULT, "flase");
			}
		}

		return map;
	}

	/**
	 * 陵园图片上传
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/uploadByCemetery")
	public Map<String, String> uploadByCemetery(HttpServletRequest request) {

		Map<String, String> map = new HashMap<String, String>();
		try {
			String realUrl = cemeteryAction.uploadByCemetery(request);
		} catch (Exception e) {
		}
		return map;
	}

	/**
	 * 删除一条或多条记录
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public Map<String, String> deleteCemetery(
			@RequestParam("cemeteryId") String cemeteryId,
			@RequestParam("version") String version) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
		try {

			param.put("cemeteryId", cemeteryId);
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", Integer.parseInt(version) + 1);
			param.put("delflag", 1);
			cemeteryAction.deleteCemetery(param);
			map.put(RTN_RESULT, "true");
			map.put(MESSAGE_INFO, "操作成功！");

		} catch (Exception e) {

			map.put(RTN_RESULT, "false");
			map.put(MESSAGE_INFO, "删除失败！");

		}

		return map;
	}
}
