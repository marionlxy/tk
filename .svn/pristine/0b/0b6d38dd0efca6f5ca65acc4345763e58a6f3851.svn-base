package com.taikang.iu.opt.order.action.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taikang.iu.opt.order.action.IOrderSevAction;
import com.taikang.iu.opt.order.model.OrderAppBO;
import com.taikang.iu.opt.order.model.OrderBO;
import com.taikang.iu.opt.order.model.OrderSevBO;
import com.taikang.iu.opt.order.model.OrderSubBO;
import com.taikang.iu.opt.order.service.IOrderAppService;
import com.taikang.iu.opt.order.service.IOrderService;
import com.taikang.iu.opt.order.service.IOrderSevService;
import com.taikang.iu.opt.order.service.IOrderSubService;
import com.taikang.iu.opt.single.model.SingleBO;
import com.taikang.iu.opt.single.service.ISingleService;
import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.TKDateTimeUtils;
import com.taikang.udp.framework.core.action.impl.BaseActionImpl;
import com.taikang.udp.framework.core.persistence.pagination.CurrentPage;
import com.taikang.udp.sys.util.UserUtils;
import com.taikang.udp.sys.util.sequence.BusinessSeqGenerator;
import com.taikang.udp.sys.util.vo.LoginUser;

/**
  * OrderSevAction
  */
  @Service(IOrderSevAction.ACTION_ID)
public class OrderSevActionImpl extends BaseActionImpl 
  implements IOrderSevAction {

    /**
      * 注入service
      */
    @Resource(name=IOrderSevService.SERVICE_ID)
	private IOrderSevService<OrderSevBO> orderSevService;	
	
    
    @Resource(name=IOrderService.SERVICE_ID)
    private IOrderService<OrderBO> orderService;
    
    @Resource(name=IOrderSubService.SERVICE_ID)
    private IOrderSubService<OrderSubBO> orderSubService;
    
    @Resource(name=IOrderAppService.SERVICE_ID)
    private IOrderAppService<OrderAppBO> orderAppService;
    
   @Resource(name=ISingleService.SERVICE_ID)
	private ISingleService<SingleBO> singleService;	
	/**
	 * 
	  * 增加数据
	  */
	public void insertObject(Dto param) {
		logger.debug("<======OrderSevAction--addOrderSev======>");
		
		OrderSevBO orderSevBO = BaseDto.toModel(OrderSevBO.class , param);
		orderSevService.insertObject(orderSevBO);
	}
	
	/**
      * 修改数据
      */
	public void updateObject(Dto param){
		logger.debug("<======OrderSevAction--updateOrderSev======>");
		
		OrderSevBO orderSevBO = BaseDto.toModel(OrderSevBO.class , param);
		orderSevService.updateObject(orderSevBO);
	}

	 /**
      * 删除数据
      */
	public void deleteObject(Dto param) {
		logger.debug("<======OrderSevAction--deleteOrderSev======>");
		
		OrderSevBO orderSevBO = BaseDto.toModel(OrderSevBO.class , param);
		orderSevService.deleteObject(orderSevBO);
	}
	
	/**
      * 查询单条数据
      */
	public Dto findOne(Dto param) {
		logger.debug("<======OrderSevAction--findOneOrderSev======>");
		
		OrderSevBO orderSevBO = BaseDto.toModel(OrderSevBO.class , param);
		return orderSevService.findOne(orderSevBO).toDto();//返回的BO对象自动转换成Dto返回
	}  
	
	/**
      * 查询所有数据
      */
	public List<Dto> findAll(Dto param) {
		logger.debug("<======OrderSevAction--findAllOrderSev======>");
				
		return orderSevService.findAllMap(param);
	} 
	
		
	 /**
      * 分页查询数据
      */
	public CurrentPage queryForPage(CurrentPage currentPage){
		logger.debug("<======OrderSevAction--queryOrderSevForPage======>");
		
		return orderSevService.queryForPage(currentPage);
	}

	public CurrentPage queryOrderSevForPage(CurrentPage currentPage) {
		logger.debug("<======OrderSevAction--queryOrderSevForPage======>");
		
		return orderSevService.queryOrderSevForPage(currentPage);
	}

	/**
	 * 指派服务商并保存数据
	 */
	public void saveSev(String orderId,String linkId, String serviceId, String sellerCode,
			String sellerName) {
		logger.debug("<======OrderSevAction--updateOrderSev==sellerCode====>");
		OrderSevBO orderSevBO = new OrderSevBO();
		orderSevBO.setOrderId(orderId);
		orderSevBO.setServiceId(serviceId);
		if (linkId != null && !"".equals(linkId) && !"undefined".equals(linkId)) {
			orderSevBO.setLinkId(linkId);
		}
		OrderSevBO sevBO = orderSevService.findOne(orderSevBO);
		if(sevBO != null){
			 sevBO.setSellerCode(sellerCode);
			 sevBO.setSellerName(sellerName);
			 orderSevService.updateObject(sevBO);
		}
	}
	/**
	 * 服务类订单拆单（生成子订单）
	 */
	public void subOrderSave(String orderId, String orderType) {
		LoginUser loginUser = UserUtils.getUser();
		String user = String.valueOf(loginUser.getUserId());
		OrderSevBO param = new OrderSevBO(); //服务订单
		OrderBO entity = new OrderBO(); //订单
		OrderAppBO orderAppBO = new OrderAppBO(); //用品订单
		OrderBO orderBO = null;
		List<OrderSevBO> orderSevAll = null; 
		List<OrderAppBO> orderAppAll = null;
		if(orderId != null ){
			entity.setOrderId(orderId);
			param.setOrderId(orderId);
			orderAppBO.setOrderId(orderId);
			orderBO =  orderService.findOneOrder(entity);  //获取主订单 
			orderSevAll = orderSevService.findAllOrderSev(param); //获取服务订单
			orderAppAll = orderAppService.findAllOrderApp(orderAppBO); //获取用品订单
			if(orderSevAll.size()>0 ){
				excreteOrderSev(user,orderType, orderBO, orderSevAll);
			}
			
			if(orderAppAll.size()>0){
				excreteOrderApp(user,orderType, orderBO, orderAppAll);
			}
			orderBO.setOrderState("15"); //主订单状态改为实施中
			orderBO.setModifiedTime(TKDateTimeUtils.getTodayTimeStamp());  //修改时间
			orderBO.setModifiedBy(user);  //修改人
			orderService.updateObject(orderBO);
		}
	}

	/**
	 * 套餐类用品订单进行子订单生成
	 * @param user
	 * @param orderType
	 * @param orderBO
	 * @param orApp
	 */
	@SuppressWarnings("unchecked")
	private void excreteOrderApp(String user,String orderType, OrderBO orderBO,List<OrderAppBO> orApp) {
		/**
		 *  用品订单表增加子订单ID、子订单编号、修改时间、修改人
		 */
		// 数据整理用
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		// 去重后的商户编号list
		List<String> codeList = new ArrayList<String>();
		OrderSubBO orderSubBO = null;
		if(orApp != null ){ 
			for(OrderAppBO appBo : orApp){
				if(appBo != null && appBo.getSellerCode() != null ){
					String sellerCode = appBo.getSellerCode();
//					if(dataMap.get(sellerCode) == null){
//					如果dataMap中没有该商户的编码，那么就新建一个列表并保存组装该商户的数据，
//					如果有则添加到这个商户原有的数据中
					if(!sellerCode.equals(dataMap.get(sellerCode))&&dataMap.get(sellerCode) == null){
						//新建用品的List 
						List<OrderAppBO> tmp = new ArrayList<OrderAppBO>();
						tmp.add(appBo);
						//将用品的信息保存到map中里
						dataMap.put(sellerCode, tmp);
						//将用品的总价及结算总价进行统计并保存
						dataMap.put("PRICE"+sellerCode, appBo.getApplianceSettlePrice()== null ? new BigDecimal(0):appBo.getApplianceSettlePrice() ); //用品结算价
						dataMap.put("MAK"+sellerCode, appBo.getApplianceMarketPrice() == null ? new BigDecimal(0) :appBo.getApplianceMarketPrice()); //用品销售价
						dataMap.put("NAME"+sellerCode, appBo.getSellerName());
						// 添加此 <商户编号> 到List中
						codeList.add(sellerCode);
					}else{
						List<OrderAppBO> tmp = (List<OrderAppBO>)dataMap.get(sellerCode);
						// 添加此用品数据=》此商户数据List中
						tmp.add(appBo);
						
						dataMap.put(sellerCode, tmp);
						BigDecimal tmpPrice =(BigDecimal)dataMap.get("PRICE"+sellerCode);
						BigDecimal tmpSelPrice =(BigDecimal)dataMap.get("MAK"+sellerCode);
						dataMap.put("PRICE"+sellerCode, tmpPrice.add(appBo.getApplianceSettlePrice()== null ? new BigDecimal(0):appBo.getApplianceSettlePrice()));//用品结算价
						dataMap.put("MAK"+sellerCode, tmpSelPrice.add(appBo.getApplianceMarketPrice() == null ? new BigDecimal(0):appBo.getApplianceMarketPrice())); //用品销售价
						dataMap.put("NAME"+sellerCode, appBo.getSellerName());
						
					}
				}
			}
			if(codeList.size() > 0 ){
				for(String code :codeList){
					BigDecimal stPrice =(BigDecimal)dataMap.get("PRICE"+code);
					BigDecimal stMakPrice =  (BigDecimal)dataMap.get("MAK"+code);
					String  name =(String)dataMap.get("NAME"+code);
					orderSubBO = orderAppFormSubNew(orderBO, user, null);
					orderSubBO.setsettlePrice(stPrice); //结算价格
					orderSubBO.setSubPrice(stMakPrice); //子订单总价格
					orderSubBO.setSellerCode(code);
					orderSubBO.setSellerName(name);
					orderSubService.insertObject(orderSubBO);
					List<OrderAppBO>  orderAppBoList = (List<OrderAppBO>)dataMap.get(code);
					for(OrderAppBO orderAppBO: orderAppBoList){
						orderAppBO.setSubId(orderSubBO.getSubId());
						orderAppBO.setSubCode(orderSubBO.getSubCode());
						orderAppBO.setAppState("02"); //用品订单状态，已支付
						orderAppBO.setModifiedTime(TKDateTimeUtils.getTodayTimeStamp()); 
						orderAppBO.setModifiedBy(user); 				
						orderAppService.updateObject(orderAppBO);
					}
				}
			}
		}
	}
	/**
	 * 套餐类服务订单进行子订单生成
	 * @param orderType
	 * @param orderBO
	 * @param orderSevAll
	 */
	@SuppressWarnings("unchecked")
	private void excreteOrderSev(String user,String orderType, OrderBO orderBO, List<OrderSevBO> orderSevAll) {
		 /*
		  * 服务订单表增加子订单ID、子订单编号、修改时间、修改人
		  */
		// 数据整理用
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		// 去重后的商户编号list
		List<String> codeList = new ArrayList<String>();
		List<OrderSevBO> tmp = null;
		OrderSubBO orderSubBO = null;
		if(orderSevAll.size()>0 ){ 
		   for(OrderSevBO sevBO : orderSevAll){
			   if(sevBO != null && sevBO.getSellerCode() != null ){
					String sellerCode = sevBO.getSellerCode();
					String serviceNum = sevBO.getServiceNum();
					SingleBO single = new SingleBO();
					single.setServiceNum(serviceNum);
					single.setSellerCode(sellerCode);
					SingleBO singleBO = singleService.findNewOne(single);
					
					// 将单项服务的结算价 赋值给 订单的相应服务
					sevBO.setPurchasePrice(singleBO.getSettlePrice());
					
//					if(dataMap.get(sellerCode) == null){
//					如果dataMap中没有该商户的编码，那么就新建一个列表并保存组装该商户的数据，
//					如果有则添加到这个商户原有的数据中
					if(!sellerCode.equals(dataMap.get(sellerCode))&&dataMap.get(sellerCode) == null){
						//新建服务的List 
						tmp = new ArrayList<OrderSevBO>();
						tmp.add(sevBO);
						//将服务的信息保存到map中里
						dataMap.put(sellerCode, tmp);
						//根据对应的商户编码和单项服务编码查询出此项服务的结算价格
						if (singleBO != null) {
							dataMap.put("PRICE"+sellerCode, singleBO.getSettlePrice() == null ? new BigDecimal(0):singleBO.getSettlePrice()); //服务结算价
						}
						//将服务的总价及结算总价进行统计并保存
						dataMap.put("MAK"+sellerCode, sevBO.getSellPrice()== null ? new BigDecimal(0):sevBO.getSellPrice()); //服务销售价
						dataMap.put("NAME"+sellerCode, sevBO.getSellerName());
						// 添加此 <商户编号> 到List中
						codeList.add(sellerCode);
					}else{
						tmp = (List<OrderSevBO>)dataMap.get(sellerCode);
						// 添加此服务数据=》此商户数据List中
						tmp.add(sevBO);						
						dataMap.put(sellerCode, tmp);
						BigDecimal tmpPrice =(BigDecimal)dataMap.get("PRICE"+sellerCode)  == null ?new BigDecimal(0):(BigDecimal)dataMap.get("PRICE"+sellerCode);
						BigDecimal tmpSelPrice =(BigDecimal)dataMap.get("MAK"+sellerCode) == null ?new BigDecimal(0):(BigDecimal)dataMap.get("MAK"+sellerCode);
						dataMap.put("PRICE"+sellerCode, tmpPrice.add(singleBO.getSettlePrice() == null ?new BigDecimal(0):singleBO.getSettlePrice()));//服务结算价
						dataMap.put("MAK"+sellerCode, tmpSelPrice.add(sevBO.getSellPrice() == null ?new BigDecimal(0):sevBO.getSellPrice())); //服务销售价
						dataMap.put("NAME"+sellerCode, sevBO.getSellerName());
						
					}
				}
			}
		   if(codeList.size() > 0){
			   for(String code :codeList){
					BigDecimal stPrice =(BigDecimal)dataMap.get("PRICE"+code);
					BigDecimal stMakPrice =  (BigDecimal)dataMap.get("MAK"+code);
					String  name =(String)dataMap.get("NAME"+code);
					orderSubBO = orderSevFormSubNew(orderBO, user, null);
					orderSubBO.setsettlePrice(stPrice); //结算价格
					orderSubBO.setSubPrice(stMakPrice); //子订单总价格
					orderSubBO.setSellerCode(code);
					orderSubBO.setSellerName(name);
					orderSubService.insertObject(orderSubBO);
					List<OrderSevBO>  orderAppBoList = (List<OrderSevBO>)dataMap.get(code);
					for(OrderSevBO orderSevBO: orderAppBoList){
						orderSevBO.setSubId(orderSubBO.getSubId());
						orderSevBO.setSubCode(orderSubBO.getSubCode());
						orderSevBO.setSevState("15"); //服务订单表状态变成： 实施中
						orderSevBO.setModifiedTime(TKDateTimeUtils.getTodayTimeStamp()); 
						orderSevBO.setModifiedBy(user); 
						orderSevService.updateObject(orderSevBO);			
					
					}
				} 
		   }
			
		}
	}
	/**
	 * 生成服务子订单表
	 * @param orderBO 主订单
	 * @param user 操作人
	 * @param sevBO 服务订单
	 * @return 子订单
	 */
	private  OrderSubBO orderSevFormSubNew(OrderBO orderBO, String user, OrderSevBO sevBO) {
		OrderSubBO orderSubBO = new OrderSubBO();
		orderSubBO.setSubId(UUID.randomUUID().toString().replace("-", ""));
	
		orderSubBO.setOrderCode(orderBO.getOrderCode());
		orderSubBO.setOrderId(orderBO.getOrderId());
		orderSubBO.setSubCode("FT"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+""+BusinessSeqGenerator.getInstance("FT_CODE").nextId()); //子订单编号
		orderSubBO.setSubState("15");//子订单状态
		orderSubBO.setSubType("1"); //子订单类型 FT
		orderSubBO.setAppraiseState("0");//评价状态“未回访”
		//orderSubBO.setSubPrice(orderBO.getOrderPrice());//子订单总价
		//orderSubBO.setSellerCode(sevBO.getSellerCode());
		//orderSubBO.setSellerName(sevBO.getSellerName());
		orderSubBO.setOddnum(orderBO.getOddnum());
		orderSubBO.setLogistics(orderBO.getLogistics());
		orderSubBO.setLogisticsCost(orderBO.getLogisticsCost());
		orderSubBO.setCreatedTime(TKDateTimeUtils.getTodayTimeStamp());
		orderSubBO.setCreatedBy(user);
		orderSubBO.setVersion(1);
		orderSubBO.setDelflag("0");
		return orderSubBO;
	}	
	
	/**
	 * 生成用品子订单
	 * @param orderBO 主订单
	 * @param user  操作人
	 * @param sevBO  用品订单
	 * @return  子订单
	 */
	private  OrderSubBO orderAppFormSubNew(OrderBO orderBO, String user, OrderAppBO appBO) {
		OrderSubBO orderSubBO = new OrderSubBO();
		orderSubBO.setSubId(UUID.randomUUID().toString().replace("-", ""));
		orderSubBO.setOrderCode(orderBO.getOrderCode());
		orderSubBO.setOrderId(orderBO.getOrderId());
		orderSubBO.setSubCode("ST"+TKDateTimeUtils.getCurrentDate().toString().replace("-", "")+""+BusinessSeqGenerator.getInstance("ST_CODE").nextId()); //子订单编号
		orderSubBO.setSubState("15");//子订单状态
		orderSubBO.setSubType("0"); //子订单类型 ST
		orderSubBO.setAppraiseState("0");//评价状态“未回访”
		//orderSubBO.setSubPrice(orderBO.getOrderPrice());//子订单总价
		//orderSubBO.setSellerCode(sevBO.getSellerCode());
		//orderSubBO.setSellerName(sevBO.getSellerName());
		orderSubBO.setOddnum(orderBO.getOddnum());
		orderSubBO.setLogistics(orderBO.getLogistics());
		orderSubBO.setLogisticsCost(orderBO.getLogisticsCost());
		orderSubBO.setCreatedTime(TKDateTimeUtils.getTodayTimeStamp());
		orderSubBO.setCreatedBy(user);
		orderSubBO.setVersion(1);
		orderSubBO.setDelflag("0");
		return orderSubBO;
	}

	public CurrentPage queryfindSevOrderPage(CurrentPage currentPage) {
		logger.debug("<======OrderSevAction--queryfindSevOrderPage======>");
		return orderSevService.queryfindSevOrderPage(currentPage);
	}
    /**
     * 第三方坐席回访订单查询
     */
	public CurrentPage queryVitisSevOrderPage(CurrentPage currentPage) {
		logger.debug("<======OrderSevAction--queryfindSevOrderPage======>");
		return orderSevService.queryVitisSevOrderPage(currentPage);
	}

	public CurrentPage queryVitisSevList(CurrentPage currentPage) {
		return orderSevService.queryVitisSevList(currentPage);
	}	
}
