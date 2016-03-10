package com.taikang.iu.opt.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.iu.com.SMSUtil;
import com.taikang.iu.opt.order.action.IOrderAction;
import com.taikang.iu.opt.order.action.IOrderSevAction;
import com.taikang.iu.opt.order.action.IOrderSubAction;
import com.taikang.iu.opt.seller.action.ISellerAction;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.framework.core.web.BaseController;


/**
  * OrderSevController
  */
@Controller("orderSevController")
@RequestMapping(value="/orderSev")
public class OrderSevController  extends BaseController  {
		
	@Resource(name=IOrderSevAction.ACTION_ID)
	private IOrderSevAction orderSevAction;
	/**
	 * 注入订单service
	 */
	@Resource(name=IOrderAction.ACTION_ID)
	private IOrderAction orderAction;
	/**
	 * 注入子订单
	 */
	@Resource(name=IOrderSubAction.ACTION_ID)
	private IOrderSubAction orderSubAction;
	/**
	 * 注入商户
	 */
	@Resource(name=ISellerAction.ACTION_ID)
	private ISellerAction sellerAction;
	/**
	 *  跳转第三方回访管理页面
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午1:16:48
	 * @return
	 */
	@RequestMapping(value="/toVisitSevPage")
	public String showVisitOrderSevPage(){
		return "ordersev/visitSeviOrderList";
	}
	/**
	 * 第三方坐席回访服务订单
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午1:23:37
	 * @see     getVitisOrderPage
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/visitOrderSevList")
	@ResponseBody
    public Map<String,Object> visitOrderSevList(String orderId,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		Dto param = new BaseDto();
		param.put("orderId", orderId);
		page.setParamObject(param);
		CurrentPage currentPage = orderSevAction.queryVitisSevList(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		return map;
    }
	/**
	 * 获得订单服务列表
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午1:58:55
	 * @return
	 */
	@RequestMapping(value="/visitOrderSevPage")
	@ResponseBody
    public Map<String,Object> visitOrderSevPage(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = orderAction.queryAllSevOrderPage(page);
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		return map;
    }
	
	/**
	 * 查看服务订单的详情
	 * @author t-zhaohan
	 * @Credited 2015年3月23日 下午2:44:50
	 * @return
	 */
	@RequestMapping("/viewSevOrderInfo")
	public String viewSevOrderInfo(String orderId,Model model){
		if(orderId!=null && !orderId.equals(""))
		{
			model.addAttribute("orderId",orderId );
		}
		return "ordersev/sevOrderView";
	}
	/**
	 * 打开主查询页面
	 * @return 页面地址
	 */
	@RequestMapping("")
	public String showOrderSevIndexPage() {
		return "orderSev/orderSevIndex"; 
	}
	/**
	 * 查询信息列表
	 * @return 分页列表数据
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,Object> getOrderSevList(HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = orderSevAction.queryForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}

	/**
	 * 打开新增或修改页面
	 * @return
	 */
	@RequestMapping("edit")
	public String showOrderSevEditPage(String rowId,Model model) {
		
		if(rowId!=null && !rowId.equals(""))
		{
			model.addAttribute("rowId",rowId );
		}
		
		return "orderSev/orderSevEdit"; 
	}
	
	/**
	 * 获取一条记录详细信息，用来填充修改界面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/getOne")
	@ResponseBody
	public Dto getOrderSevById(@RequestParam("orderId")String orderId)
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
	private Map<String,String> saveOrderSevInfo(HttpServletRequest request)
	{
		Map<String,String> map=new HashMap<String,String>();
		
		Dto param = getParamAsDto(request);
		if(param.get("rowId") ==null ||"".equals(param.get("rowId")))
		{
			orderSevAction.insertObject(param);
			map.put(MESSAGE_INFO, "新增成功！");
		}
		else
		{
			orderSevAction.updateObject(param);
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
	public Map<String, String> deleteOrderSev(@RequestParam("rowId") String rowId) {
		Map<String, String> map = new HashMap<String, String>();
		Dto param = new BaseDto();
		param.put("rowId", rowId);
		orderSevAction.deleteObject(param);
		
		map.put(RTN_RESULT, "true");
		map.put(MESSAGE_INFO, "操作成功！");
		
		return map;
	}
	
	/**
	 * 查询服务列表信息
	 * @param orderId 通过订单ID 
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("/showOrderSevPage")
	@ResponseBody
	public Map<String,Object> showOrderSevPage(String orderId,String subCode,HttpServletRequest request,CurrentPage page){
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(subCode)  && !("undefined").equals(subCode)){
			request.setAttribute("subCode", subCode);
		} 
		request.setAttribute("orderId", orderId);
		page.setParamObject(getParamAsDto(request));
		CurrentPage currentPage = orderSevAction.queryOrderSevForPage(page);
		
		map.put("rows", currentPage.getPageItems());
		map.put("total", currentPage.getTotalRows());
		
		return map;
	}
	
	
	/**
	 * 指派服务商并保存数据
	 * @return
	 */
	@RequestMapping(value="/saveSev")
	@ResponseBody
	public Map<String,String> saveSev(String orderId,String serviceId,String linkId,String sellerCode,String sellerName){
		Map<String,String>  map= new HashMap<String, String>();
		
		if(serviceId != null ){
			orderSevAction.saveSev(orderId,linkId,serviceId,sellerCode,sellerName);
			map.put(MESSAGE_INFO, "更新成功");
			map.put(RTN_RESULT, "true");
		}else{
			map.put(MESSAGE_INFO, "指派失败");
			map.put(RTN_RESULT, "false");
		}
		
		return map;
		
	}
	
	/**
	 * 服务项订单进行拆单操作，并生成子订单
	 */
	@RequestMapping(value="/subOrderSave")
	@ResponseBody
	public Map<String,String> subOrderSave(String orderId,String orderType){
		Map<String,String>  map= new HashMap<String, String>();
		
		if(orderId != null ){
			orderSevAction.subOrderSave(orderId,orderType);
			Dto orderParam  = new BaseDto();
			orderParam.put("orderId", orderId);
			List<Dto> subOrder = orderSubAction.findSubOrderIsByOrderId(orderParam);//获得所有的子订单
			logger.info("*********开始发送短息*********");	
			int subSize = subOrder.size();
			for(int i = 0 ; i < subSize ; i ++){
				Dto sellerVo = new BaseDto();
				sellerVo.put("sellerCode",subOrder.get(i).getAsString("SELLER_CODE"));
				Dto seller = sellerAction.findOne(sellerVo);
				if(subOrder.get(i).getAsString("subType").equals("0")){
					logger.info("*********--"+i+"--发送短信给"+seller.getAsString("sellerName")+"*********");	
					try {
						appSellerPaySms(seller.getAsString("sellerName"),seller.getAsString("sellerMobile"),"用品订单"+subOrder.get(i).getAsString("SUB_CODE"));
					} catch (Exception e) {
						logger.info("*********发送短信失败，可能参数为空*********");
					}
					logger.info("*********发送短信成功*********");	
				}else{
					logger.info("*********开始发送短信给"+seller.getAsString("sellerName")+"*********");	
					try {
						appSellerPaySms(seller.getAsString("sellerName"),seller.getAsString("sellerMobile"),"服务订单"+subOrder.get(i).getAsString("SUB_CODE"));
					} catch (Exception e) {
						logger.info("*********--"+i+"--发送短信失败，可能参数为空*********");
					}
					
					logger.info("*********发送短信成功*********");	
				}
			}
			logger.info("*********发送短信结束*********");	
			map.put(MESSAGE_INFO, "更新成功");
			map.put(RTN_RESULT, "true");
		}else{
			map.put(MESSAGE_INFO, "订单生成失败");
			map.put(RTN_RESULT, "false");
		}
		
		return map;
	}
	/**
	 * 给商户发送短息
	 * @author t-zhaohan
	 * @Credited 2015年5月13日 下午4:32:33
	 * @return
	 */
	public void appSellerPaySms(String sellerName,String mobile,String orderCode){
		String msg = "[爱佑汇]"+sellerName+"商户，您获得了新的"+orderCode+"。请尽快查看和处理。";
		String sms = SMSUtil.sendSMS(mobile, msg, SMSUtil.BUSINESS_TYPE_TOABL);
		logger.info("*********"+sms+"*********");
	}
	
}

