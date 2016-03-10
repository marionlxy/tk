package com.taikang.iu.opt.order.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * OrderAppBO 
  */
public class OrderAppBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public OrderAppBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("order_app_id","sub_id","link_id","sub_code","order_id","order_code","app_state","appliance_id","appliance_coding","category_id","category_code","category_name","appliance_name","appliance_unit","appliance_count","appliance_price","appliance_settle_price","appliance_market_price","sku_id","sku_code","sku_property_str","is_return_bills","interflow_price","picture_url","seller_code","seller_name","site","appraise_state","send_by","send_time","take_by","take_time","created_time","created_by","modified_time","modified_by","version","delflag"));
	}

	private String orderAppId;
		public void setOrderAppId(String orderAppId){
		getData().put("order_app_id",orderAppId);
		this.orderAppId=orderAppId;
	}
	
	public String getOrderAppId(){
		return (String)getData().get("order_app_id");
	}	
		
		
	private String subId;
		public void setSubId(String subId){
		getData().put("sub_id",subId);
		this.subId=subId;
	}
	
	public String getSubId(){
		return (String)getData().get("sub_id");
	}	
		
		
	private String linkId;
		public void setLinkId(String linkId){
		getData().put("link_id",linkId);
		this.linkId=linkId;
	}
	
	public String getLinkId(){
		return (String)getData().get("link_id");
	}	
		
		
	private String subCode;
		public void setSubCode(String subCode){
		getData().put("sub_code",subCode);
		this.subCode=subCode;
	}
	
	public String getSubCode(){
		return (String)getData().get("sub_code");
	}	
		
		
	private String orderId;
		public void setOrderId(String orderId){
		getData().put("order_id",orderId);
		this.orderId=orderId;
	}
	
	public String getOrderId(){
		return (String)getData().get("order_id");
	}	
		
		
	private String orderCode;
		public void setOrderCode(String orderCode){
		getData().put("order_code",orderCode);
		this.orderCode=orderCode;
	}
	
	public String getOrderCode(){
		return (String)getData().get("order_code");
	}	
		
		
	private String appState;
		public void setAppState(String appState){
		getData().put("app_state",appState);
		this.appState=appState;
	}
	
	public String getAppState(){
		return (String)getData().get("app_state");
	}	
		
		
	private String applianceId;
		public void setApplianceId(String applianceId){
		getData().put("appliance_id",applianceId);
		this.applianceId=applianceId;
	}
	
	public String getApplianceId(){
		return (String)getData().get("appliance_id");
	}	
		
		
	private String applianceCoding;
		public void setApplianceCoding(String applianceCoding){
		getData().put("appliance_coding",applianceCoding);
		this.applianceCoding=applianceCoding;
	}
	
	public String getApplianceCoding(){
		return (String)getData().get("appliance_coding");
	}	
		
		
	private String categoryId;
		public void setCategoryId(String categoryId){
		getData().put("category_id",categoryId);
		this.categoryId=categoryId;
	}
	
	public String getCategoryId(){
		return (String)getData().get("category_id");
	}	
		
		
	private String categoryCode;
		public void setCategoryCode(String categoryCode){
		getData().put("category_code",categoryCode);
		this.categoryCode=categoryCode;
	}
	
	public String getCategoryCode(){
		return (String)getData().get("category_code");
	}	
		
		
	private String categoryName;
		public void setCategoryName(String categoryName){
		getData().put("category_name",categoryName);
		this.categoryName=categoryName;
	}
	
	public String getCategoryName(){
		return (String)getData().get("category_name");
	}	
		
		
	private String applianceName;
		public void setApplianceName(String applianceName){
		getData().put("appliance_name",applianceName);
		this.applianceName=applianceName;
	}
	
	public String getApplianceName(){
		return (String)getData().get("appliance_name");
	}	
		
		
	private String applianceUnit;
		public void setApplianceUnit(String applianceUnit){
		getData().put("appliance_unit",applianceUnit);
		this.applianceUnit=applianceUnit;
	}
	
	public String getApplianceUnit(){
		return (String)getData().get("appliance_unit");
	}	
		
		
	private Integer applianceCount;
		public void setApplianceCount(Integer applianceCount){
		getData().put("appliance_count",applianceCount);
		this.applianceCount=applianceCount;
	}
	
	public Integer getApplianceCount(){
		return (Integer)getData().get("appliance_count");
	}	
		
		
	private BigDecimal appliancePrice;
		public void setAppliancePrice(BigDecimal appliancePrice){
		getData().put("appliance_price",appliancePrice);
		this.appliancePrice=appliancePrice;
	}
	
	public BigDecimal getAppliancePrice(){
		return (BigDecimal)getData().get("appliance_price");
	}	
		
		
	private BigDecimal applianceSettlePrice;
		public void setApplianceSettlePrice(BigDecimal applianceSettlePrice){
		getData().put("appliance_settle_price",applianceSettlePrice);
		this.applianceSettlePrice=applianceSettlePrice;
	}
	
	public BigDecimal getApplianceSettlePrice(){
		return (BigDecimal)getData().get("appliance_settle_price");
	}	
		
		
	private BigDecimal applianceMarketPrice;
		public void setApplianceMarketPrice(BigDecimal applianceMarketPrice){
		getData().put("appliance_market_price",applianceMarketPrice);
		this.applianceMarketPrice=applianceMarketPrice;
	}
	
	public BigDecimal getApplianceMarketPrice(){
		return (BigDecimal)getData().get("appliance_market_price");
	}	
		
		
	private String skuId;
		public void setSkuId(String skuId){
		getData().put("sku_id",skuId);
		this.skuId=skuId;
	}
	
	public String getSkuId(){
		return (String)getData().get("sku_id");
	}	
		
		
	private String skuCode;
		public void setSkuCode(String skuCode){
		getData().put("sku_code",skuCode);
		this.skuCode=skuCode;
	}
	
	public String getSkuCode(){
		return (String)getData().get("sku_code");
	}	
		
		
	private String skuPropertyStr;
		public void setSkuPropertyStr(String skuPropertyStr){
		getData().put("sku_property_str",skuPropertyStr);
		this.skuPropertyStr=skuPropertyStr;
	}
	
	public String getSkuPropertyStr(){
		return (String)getData().get("sku_property_str");
	}	
		
		
	private String isReturnBills;
		public void setIsReturnBills(String isReturnBills){
		getData().put("is_return_bills",isReturnBills);
		this.isReturnBills=isReturnBills;
	}
	
	public String getIsReturnBills(){
		return (String)getData().get("is_return_bills");
	}	
		
		
	private BigDecimal interflowPrice;
		public void setInterflowPrice(BigDecimal interflowPrice){
		getData().put("interflow_price",interflowPrice);
		this.interflowPrice=interflowPrice;
	}
	
	public BigDecimal getInterflowPrice(){
		return (BigDecimal)getData().get("interflow_price");
	}	
		
		
	private String pictureUrl;
		public void setPictureUrl(String pictureUrl){
		getData().put("picture_url",pictureUrl);
		this.pictureUrl=pictureUrl;
	}
	
	public String getPictureUrl(){
		return (String)getData().get("picture_url");
	}	
		
		
	private String sellerCode;
		public void setSellerCode(String sellerCode){
		getData().put("seller_code",sellerCode);
		this.sellerCode=sellerCode;
	}
	
	public String getSellerCode(){
		return (String)getData().get("seller_code");
	}	
		
		
	private String sellerName;
		public void setSellerName(String sellerName){
		getData().put("seller_name",sellerName);
		this.sellerName=sellerName;
	}
	
	public String getSellerName(){
		return (String)getData().get("seller_name");
	}	
		
		
	private String site;
		public void setSite(String site){
		getData().put("site",site);
		this.site=site;
	}
	
	public String getSite(){
		return (String)getData().get("site");
	}	
		
		
	private String appraiseState;
		public void setAppraiseState(String appraiseState){
		getData().put("appraise_state",appraiseState);
		this.appraiseState=appraiseState;
	}
	
	public String getAppraiseState(){
		return (String)getData().get("appraise_state");
	}
	
	private String sendBy;
	public void setSendBy(String sendBy){
	getData().put("send_by",sendBy);
	this.sendBy=sendBy;
	}
	
	public String getSendBy(){
		return (String)getData().get("send_by");
	}	
		
		
	private Timestamp sendTime;
		public void setSendTime(Timestamp sendTime){
		getData().put("send_time",sendTime);
		this.sendTime=sendTime;
	}
	
	public Timestamp getSendTime(){
		return (Timestamp)getData().get("send_time");
	}	
		
		
	private String takeBy;
		public void setTakeBy(String takeBy){
		getData().put("take_by",takeBy);
		this.takeBy=takeBy;
	}
	
	public String getTakeBy(){
		return (String)getData().get("take_by");
	}	
		
		
	private Timestamp takeTime;
		public void setTakeTime(Timestamp takeTime){
		getData().put("take_time",takeTime);
		this.takeTime=takeTime;
	}
	
	public Timestamp getTakeTime(){
		return (Timestamp)getData().get("take_time");
	}	
			
		
	private Timestamp createdTime;
		public void setCreatedTime(Timestamp createdTime){
		getData().put("created_time",createdTime);
		this.createdTime=createdTime;
	}
	
	public Timestamp getCreatedTime(){
		return (Timestamp)getData().get("created_time");
	}	
		
		
	private String createdBy;
		public void setCreatedBy(String createdBy){
		getData().put("created_by",createdBy);
		this.createdBy=createdBy;
	}
	
	public String getCreatedBy(){
		return (String)getData().get("created_by");
	}	
		
		
	private Timestamp modifiedTime;
		public void setModifiedTime(Timestamp modifiedTime){
		getData().put("modified_time",modifiedTime);
		this.modifiedTime=modifiedTime;
	}
	
	public Timestamp getModifiedTime(){
		return (Timestamp)getData().get("modified_time");
	}	
		
		
	private String modifiedBy;
		public void setModifiedBy(String modifiedBy){
		getData().put("modified_by",modifiedBy);
		this.modifiedBy=modifiedBy;
	}
	
	public String getModifiedBy(){
		return (String)getData().get("modified_by");
	}	
		
		
	private Integer version;
		public void setVersion(Integer version){
		getData().put("version",version);
		this.version=version;
	}
	
	public Integer getVersion(){
		return (Integer)getData().get("version");
	}	
		
		
	private String delflag;
		public void setDelflag(String delflag){
		getData().put("delflag",delflag);
		this.delflag=delflag;
	}
	
	public String getDelflag(){
		return (String)getData().get("delflag");
	}	
	 }

