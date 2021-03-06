package com.taikang.iu.opt.order.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.opt.order.action.IOrderAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;


/**
  * OrderController
  */
@Controller("seatOrderController")
@RequestMapping(value="/seat")
public class SeatOrderController  extends BaseController  {
		
	@Resource(name=IOrderAction.ACTION_ID)
	private IOrderAction orderAction;
		
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showOrderIndexPage() {
		return "order/seatIndex"; 
	}
	
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getOrderList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = orderAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String showOrderEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "order/orderEdit"; 
	}
	

	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getOrderById(@RequestParam("orderId")String orderId)
	{
		Dto param = new BaseDto();
		param.put("orderId", orderId);
		return orderAction.findOne(param);
	}
	
	/**
	 * 保存新增或修改的记录，将其持久化到数据库中
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	private Map<String,String> saveOrderInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			orderAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			orderAction.updateObject(param);
			map.put(MESSAGE_INFO, "更新成功！");
		}
		map.put(RTN_RESULT, "true");
		
		return map;
	}

	
	
	
	/**
	 * 订单明细查询页面跳转
	 * */
	@RequestMapping(value="/showOrderList")
	public String showOrderList(String orderId , String orderType,String orderState,String subCode,Model model){
         if(orderId != null ){
			 model.addAttribute("orderId", orderId);
			 model.addAttribute("orderType", orderType);
			 model.addAttribute("orderState", orderState);
         }
         String  view = null;
          if(("1").equals(orderType)){
         	 if(StringUtils.isNotBlank(subCode) && !("undefined").equals(subCode) ){
         		 model.addAttribute("subCode", subCode);
         		 String temp = subCode.substring(0, 2);
         		 if(("FT").equals(temp)){
         			 view = "order/showSeatOrderSevView";
         		 }else{
         			 view  = "order/showSeatOrderView";
         		 }
         	 }else{
         		 view = "order/showSeatOrderSevView";
         	 }
          }else{
         	 view = "order/showSeatOrderView";
          }
          return view ;
         
	}
	
	/**
	 * 指派服务商时的页面跳转
	 */
	@RequestMapping(value="/selectOrderSevIndex")
	public String selectOrderSevIndex(String serviceId ,String orderId, Model model){
         if(serviceId != null &&  orderId != null ){
			 model.addAttribute("serviceId", serviceId); 
			 model.addAttribute("orderId", orderId);
         }
        return "order/selectOrderSevIndex";
	}
	
	

	
}



