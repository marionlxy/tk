package com.taikang.iu.opt.regoods.controller;

import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.taikang.iu.opt.regoods.action.IRegoodsAction;
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
  * RegoodsController
  */
@Controller("regoodsController")
@RequestMapping(value="/regoods")
public class RegoodsController  extends BaseController  {
		
	@Resource(name=IRegoodsAction.ACTION_ID)
	private IRegoodsAction regoodsAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showRegoodsIndexPage() {
		return "regoods/regoodsIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getRegoodsList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = regoodsAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showRegoodsEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "regoods/regoodsEdit"; 
	}
	
	
	
	
	/**
	 *  修改returnState状态为通过审核（returnState =1），或者不通过审核（returnState =2）
	 * 页面是regoodsIndex
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/pass")
	@ResponseBody
	private Map<String,String> pass(String returnId,Integer version,Integer flag)
	{
		Map<String,String> map=new HashMap<String,String>();
		Dto param = new BaseDto();
		LoginUser user = UserUtils.getUser();
		String loginId = String.valueOf(user.getUserId());
	if(returnId != null || returnId.length()>0){
		if(flag==1 )
		{
			param.put("returnId", returnId);
			param.put("returnState", 1);
			param.put("auditTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("auditBy", loginId);
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
//			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "操作成功！");
		}
		/**
		 * 
		 * flag=2,代表审核不通过
		 */
		else if(flag==2)
		{
			
			param.put("returnId", returnId);
			param.put("modifiedBy", loginId);
			param.put("returnState", 2);
			param.put("auditTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("auditBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
//			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "操作成功！");
		}
		//重新发货
		else if(flag==12 )
		{
			param.put("returnId", returnId);
			param.put("returnState",1);   
			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("checkResult", "重新发货");//核实结果
			param.put("checkBy", loginId); //核实人
			param.put("checkTime", TKDateTimeUtils.getTodayTimeStamp());//核实时间
			param.put("version", version+1);
//			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "重新发货成功！");
		}
		//商户处理
		else if(flag==5)
		{
			
			param.put("returnId", returnId);
			param.put("modifiedBy",loginId);
			param.put("returnState", 5);
			param.put("checkResult", "商户处理");//核实结果
			param.put("checkBy", loginId); //核实人
			param.put("checkTime", TKDateTimeUtils.getTodayTimeStamp());//核实时间
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "商户处理成功！");
		}
		//客户放弃
		else if(flag==7){
			param.put("returnId", returnId);
			param.put("modifiedBy",loginId);
			param.put("returnState", 7);
			param.put("checkResult", "客户放弃");//核实结果
			param.put("checkBy", loginId); //核实人
			param.put("checkTime", TKDateTimeUtils.getTodayTimeStamp());//核实时间
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
//			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "客户放弃成功！");
		}
		//原物返回
		else if(flag==11 )
		{
			param.put("returnId", returnId);
			param.put("returnState",11);  
			param.put("returnBy",TKDateTimeUtils.getTodayTimeStamp());   
			param.put("returnTime",loginId);   

			param.put("modifiedBy", loginId);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
//			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "原物返回成功！");
		}
		//退款
		else if(flag==9)
		{
			
			param.put("returnId", returnId);
			param.put("modifiedBy",loginId);
			param.put("refundBy",loginId); 
			param.put("refundTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("returnState", 9);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
//			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "退款成功！");
		}
		regoodsAction.updateObject(param);

	}else{
		map.put(MESSAGE_INFO, "操作失败！");

	}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**
	 * 申请介入/确认收货
	 * 跳转到是否收到货物页面
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping("/regoodsGet")
	public String goodsGet(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "regoods/regoodsGet"; 
	}
	
	/**
	 * 申请介入/确认收货
	 * 查询returnState状态为待收货
	 * reGoods =3 待收货
	 */
	@RequestMapping("/regoodsGetList")
	@ResponseBody
	public Map<String,Object> regoodsGet(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = regoodsAction.regoodsGet(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**申请介入/确认收货
	 * 页面regoodsGet
	 * 修改returnState=6状态为锁定（申请介入），或者returnState=5状态为处理中（确认收货）
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/receive")
	@ResponseBody
	private Map<String,String> receive(String returnId,Integer version,Integer flag)
	{
		Map<String,String> map=new HashMap<String,String>();
		Dto param = new BaseDto();
		if(flag==5 )
		{
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("returnState", 5);
			param.put("modifiedBy", userName);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "确认收货成功！");
		}
		else if(flag==6)
		{
			
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("modifiedBy",userName);
			param.put("lockBy", userName);
			param.put("lockTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("returnState", 6);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "申请介入成功！");
		}
			else if(flag==10 )
		{
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("returnState",10);   
			param.put("applyReturnBy", userName);//申请原返人获取 数据不确定
			param.put("applyReturnTime", TKDateTimeUtils.getTodayTimeStamp());//申请原返时间
			param.put("modifiedBy", userName);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "申请原返成功！");
		}
		else if(flag==8)
		{
			
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserId());
			param.put("returnId", returnId);
			param.put("modifiedBy",userName);
			param.put("agreeBy",userName);
			param.put("agreeTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("returnState", 8);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "同意退款成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**申请原返/同意退款
	 * 页面跳转到申请原返/同意退款
	 * 
	 */
	@RequestMapping("/end")
	public String end(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "regoods/regoodsRefund"; 
	}
	
	/**申请原返/同意退款
	 * 
	 * 根据returnState=5状态（为处理中）查询出结果集
	 * 
	 */
	@RequestMapping("/endList")
	@ResponseBody
	public Map<String,Object> endList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = regoodsAction.endList(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**申请原返/同意退款
	 * 
	 *returnState= 10(申请原返)/returnState= 8(同意退款)
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/endgood")
	@ResponseBody
	private Map<String,String> endgoods(String returnId,Integer version,Integer flag)
	{
		Map<String,String> map=new HashMap<String,String>();
		Dto param = new BaseDto();
		if(flag==10 )
		{
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("returnState",10);   
			param.put("applyReturnBy", userName);//申请原返人获取 数据不确定
			param.put("applyReturnTime", TKDateTimeUtils.getTodayTimeStamp());//申请原返时间
			param.put("modifiedBy", userName);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "申请原返成功！");
		}
		else if(flag==8)
		{
			
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("modifiedBy",userName);
			param.put("agreeBy",userName);
			param.put("agreeTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("returnState", 8);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "同意退款成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**重新发货/商户处理/客户放弃
	 * 页面跳转到-->重新发货/商户处理/客户放弃
	 * 
	 */
	@RequestMapping("/check")
	public String check(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "regoods/regoodsIntervene"; 
	}
	
	

	/**重新发货/商户处理/客户放弃
	 * 
	 * 根据returnState=6状态（锁定）查询出结果集
	 * 
	 */
	@RequestMapping("/checkList")
	@ResponseBody
	public Map<String,Object> checkList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = regoodsAction.checkList(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	/**重新发货/商户处理/客户放弃
	 * 
	 * returnState=1(重新发货)/returnState=5(商户处理)/returnState=7(客户放弃)
	 * @param returnId
	 * @param version
	 * @param flag
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/intervene")
	@ResponseBody
	private Map<String,String> intervene(String returnId,Integer version,Integer flag)
	{
		Map<String,String> map=new HashMap<String,String>();
		Dto param = new BaseDto();
		//重新发货
		if(flag==1 )
		{
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("returnState",1);   
			param.put("modifiedBy", userName);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("checkResult", "重新发货");//核实结果
			param.put("checkBy", userName); //核实人
			param.put("checkTime", TKDateTimeUtils.getTodayTimeStamp());//核实时间
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "重新发货成功！");
		}
		//商户处理
		else if(flag==5)
		{
			
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("modifiedBy",userName);
			param.put("returnState", 5);
			param.put("checkResult", "商户处理");//核实结果
			param.put("checkBy", userName); //核实人
			param.put("checkTime", TKDateTimeUtils.getTodayTimeStamp());//核实时间
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "商户处理成功！");
		}
		//客户放弃
		else if(flag==7){
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("modifiedBy",userName);
			param.put("returnState", 7);
			param.put("checkResult", "客户放弃");//核实结果
			param.put("checkBy", userName); //核实人
			param.put("checkTime", TKDateTimeUtils.getTodayTimeStamp());//核实时间
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "客户放弃成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	
	/**原物返回/退款
	 * 页面跳转到-->原物返回/退款
	 * 
	 */
	@RequestMapping("/over")
	public String over(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "regoods/regoodsEnd"; 
	}

	/**原物返回/退款
	 * 
	 * 根据returnState=10状态（申请原返）查询出结果集
	 * 
	 */
	@RequestMapping("/overlist")
	@ResponseBody
	public Map<String,Object> overlist(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = regoodsAction.overlist(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	/**原物返回/退款
	 * 
	 *returnState= 11(原物返回)/returnState= 9(已退款)
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/endgoods")
	@ResponseBody
	private Map<String,String> overgoods(String returnId,Integer version,Integer flag)
	{
		Map<String,String> map=new HashMap<String,String>();
		Dto param = new BaseDto();
		if(flag==11 )
		{
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("returnState",11);   
			param.put("modifiedBy", userName);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "原物返回成功！");
		}
		else if(flag==9)
		{
			
			LoginUser user = UserUtils.getUser();
			String userName = String.valueOf(user.getUserName());
			param.put("returnId", returnId);
			param.put("modifiedBy",userName);
			param.put("refundBy",userName); 
			param.put("refundTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("returnState", 9);
			param.put("modifiedTime", TKDateTimeUtils.getTodayTimeStamp());
			param.put("version", version+1);
			regoodsAction.updateObject(param);
			map.put(MESSAGE_INFO, "退款成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getRegoodsById(@RequestParam("rowId")String rowId)
	{
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		return regoodsAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveRegoodsInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			regoodsAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			regoodsAction.updateObject(param);
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
	public Map<String, String> deleteRegoods(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		regoodsAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
}

