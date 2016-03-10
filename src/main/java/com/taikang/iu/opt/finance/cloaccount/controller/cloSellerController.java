package com.taikang.iu.opt.finance.cloaccount.controller;

import java.net.URLDecoder;
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

import com.taikang.iu.opt.finance.account.action.IFinanceAction;
import com.taikang.iu.opt.finance.cloaccount.action.IcloSellerAction;
import com.taikang.iu.opt.order.action.IOrderAction;
import com.taikang.iu.opt.order.action.IOrderSubAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.vo.LoginUser;


/**
  * cloSellerController
  */
@Controller("cloSellerController")
@RequestMapping(value="/cloSeller")
public class cloSellerController  extends BaseController  {
		
	@Resource(name=IcloSellerAction.ACTION_ID)
	private IcloSellerAction cloSellerAction;
	
	@Resource(name=IFinanceAction.ACTION_ID)
	private IFinanceAction financeAction;
	
	@Resource(name=IOrderSubAction.ACTION_ID)
	private IOrderSubAction orderSubAction;
	
	@Resource(name=IOrderAction.ACTION_ID)
	private IOrderAction orderAction;
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showcloSellerIndexPage(Model model) {
//		Dto param=new BaseDto();
//		List<Dto> list=cloSellerAction.findAll(param);
//		if(list.get(0)==null||"".equals(list.get(0)))
//		{			
//			model.addAttribute("countPrice","0");
//		}
//		else
//		{
//			model.addAttribute("countPrice",list.get(0).get("countPrice"));
//		}
		return "finance/closellerIndex"; 
	}
	/**
	 * 结算管理动态查询合计金额
	 */
	@RequestMapping("/sumcloSellerAccount")
	@ResponseBody
	 public Dto sumcloSellerAccount(String sellerCode, String sellerName,String sellerType){
		Dto param=new BaseDto();
		param.put("sellerCode", sellerCode);
		if(sellerName != null ){
		sellerName=URLDecoder.decode(URLDecoder.decode(sellerName));
		}
		param.put("sellerName", sellerName);
		param.put("sellerType", sellerType);
     	List<Dto> list=cloSellerAction.findAll(param);
     	if(list.get(0) == null){
			Dto cPrice = new BaseDto();
			cPrice.put("countPrice", "0.00");
			return cPrice;
		}else{
			return list.get(0);
		}
	}
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getcloSellerList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = cloSellerAction.queryForPage(page);

		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showcloSellerEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "cloSeller/cloSellerEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getcloSellerById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return cloSellerAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> savecloSellerInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			cloSellerAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			cloSellerAction.updateObject(param);
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
	public Map<String, String> deletecloSeller(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		cloSellerAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 修改订单的结算状态为已结算
	 * @param sbId
	 * @return
	 */
	@RequestMapping(value="ok")
	@ResponseBody
	public Map<String,String> ok(String sbId,String orderId)
	{
		System.out.println("sbId==="+sbId);
		System.out.println("sbId==="+orderId);
		Map<String, String> map = new HashMap<String, String>();
		Dto params=new BaseDto();
		params.put("orderId", orderId);
		params=orderAction.findOne(params);
		if("1".equals(params.get("orderType")))
		{
			Dto param = new BaseDto();
			param.put("subId", sbId);
			param.put("balanceState", "1");
			
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			Dto versionParam = new BaseDto();
			versionParam.put("subId", sbId);
			Dto versionResult = orderSubAction.findOne(versionParam);
			int version = 1;
			
			// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
			if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
				version = 2;
			}else {
				version = Integer.parseInt(versionResult.get("version").toString())+1;
			}
			
			param.put("version", version);
			orderSubAction.updateObject(param);
		}
		else if("0".equals(params.get("orderType")))
		{
			Dto param = new BaseDto();
			param.put("orderId", orderId);
			param.put("balanceState", "1");
			
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			Dto versionParam = new BaseDto();
			versionParam.put("subId", sbId);
			Dto versionResult = orderSubAction.findOne(versionParam);
			int version = 1;
			
			// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
			if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
				version = 2;
			}else {
				version = Integer.parseInt(versionResult.get("version").toString())+1;
			}
			
			param.put("version", version);
			orderAction.updateObject(param);
		}
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		return map;
	}
	
	/**
	 * 修改订单的结算状态为未结算
	 * @param sbId
	 * @return
	 */
	@RequestMapping(value="ok1")
	@ResponseBody
	public Map<String,String> ok1(String sbId,String orderId)
	{
		Map<String, String> map = new HashMap<String, String>();
		Dto params=new BaseDto();
		params.put("orderId", orderId);
		params=orderAction.findOne(params);
		if("1".equals(params.get("orderType")))
		{
			Dto param = new BaseDto();
			param.put("subId", sbId);
			param.put("balanceState", "0");
			
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			Dto versionParam = new BaseDto();
			versionParam.put("subId", sbId);
			Dto versionResult = orderSubAction.findOne(versionParam);
			int version = 1;
			
			// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
			if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
				version = 2;
			}else {
				version = Integer.parseInt(versionResult.get("version").toString())+1;
			}
			
			param.put("version", version);
			orderSubAction.updateObject(param);
		}
		else if("0".equals(params.get("orderType")))
		{
			Dto param = new BaseDto();
			param.put("orderId", orderId);
			param.put("balanceState", "0");
			
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			Dto versionParam = new BaseDto();
			versionParam.put("subId", sbId);
			Dto versionResult = orderSubAction.findOne(versionParam);
			int version = 1;
			
			// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
			if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
				version = 2;
			}else {
				version = Integer.parseInt(versionResult.get("version").toString())+1;
			}
			
			param.put("version", version);
			orderAction.updateObject(param);
		}
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		return map;
	}
	
	/**
	 * 修改订单的结算状态为作废
	 * @param sbId
	 * @return
	 */
	@RequestMapping(value="ok2")
	@ResponseBody
	public Map<String,String> ok2(String sbId,String orderId)
	{
		Map<String, String> map = new HashMap<String, String>();
		Dto params=new BaseDto();
		params.put("orderId", orderId);
		params=orderAction.findOne(params);
		if("1".equals(params.get("orderType")))
		{
			Dto param = new BaseDto();
			param.put("subId", sbId);
			param.put("balanceState", "2");
			
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			Dto versionParam = new BaseDto();
			versionParam.put("subId", sbId);
			Dto versionResult = orderSubAction.findOne(versionParam);
			int version = 1;
			
			// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
			if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
				version = 2;
			}else {
				version = Integer.parseInt(versionResult.get("version").toString())+1;
			}
			
			param.put("version", version);
			orderSubAction.updateObject(param);
		}
		else if("0".equals(params.get("orderType")))
		{
			Dto param = new BaseDto();
			param.put("orderId", orderId);
			param.put("balanceState", "2");
			
			LoginUser user = UserUtils.getUser();
			String loginId = String.valueOf(user.getUserId());
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			Dto versionParam = new BaseDto();
			versionParam.put("subId", sbId);
			Dto versionResult = orderSubAction.findOne(versionParam);
			int version = 1;
			
			// 如果version为null时，将version置为2 (防止插入数据时没有为version赋值)
			if(versionResult.get("version") == null || "".equals(versionResult.get("version"))){
				version = 2;
			}else {
				version = Integer.parseInt(versionResult.get("version").toString())+1;
			}
			
			param.put("version", version);
			orderAction.updateObject(param);
		}
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		return map;
	}
}

