package com.taikang.iu.opt.order.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * OrderSevBO 
  */
public class OrderSevBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public OrderSevBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("order_sev_id","link_id","sub_id","sub_code","order_id","order_code","sev_state","service_id","service_num","service_name","service_type","service_msg","purchase_price","sell_price","moral","picture_url","seller_code","seller_name","service_site","appraise_state","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String orderSevId;
		public void setOrderSevId(String orderSevId){
		getData().put("order_sev_id",orderSevId);
		this.orderSevId=orderSevId;
	}
	
	public String getOrderSevId(){
		return (String)getData().get("order_sev_id");
	}	
		
		
	private String linkId;
		public void setLinkId(String linkId){
		getData().put("link_id",linkId);
		this.linkId=linkId;
	}
	
	public String getLinkId(){
		return (String)getData().get("link_id");
	}	
		
		
	private String subId;
		public void setSubId(String subId){
		getData().put("sub_id",subId);
		this.subId=subId;
	}
	
	public String getSubId(){
		return (String)getData().get("sub_id");
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
		
		
	private String sevState;
		public void setSevState(String sevState){
		getData().put("sev_state",sevState);
		this.sevState=sevState;
	}
	
	public String getSevState(){
		return (String)getData().get("sev_state");
	}	
		
		
	private String serviceId;
		public void setServiceId(String serviceId){
		getData().put("service_id",serviceId);
		this.serviceId=serviceId;
	}
	
	public String getServiceId(){
		return (String)getData().get("service_id");
	}	
		
		
	private String serviceNum;
		public void setServiceNum(String serviceNum){
		getData().put("service_num",serviceNum);
		this.serviceNum=serviceNum;
	}
	
	public String getServiceNum(){
		return (String)getData().get("service_num");
	}	
		
		
	private String serviceName;
		public void setServiceName(String serviceName){
		getData().put("service_name",serviceName);
		this.serviceName=serviceName;
	}
	
	public String getServiceName(){
		return (String)getData().get("service_name");
	}	
		
		
	private String serviceType;
		public void setServiceType(String serviceType){
		getData().put("service_type",serviceType);
		this.serviceType=serviceType;
	}
	
	public String getServiceType(){
		return (String)getData().get("service_type");
	}	
		
		
	private String serviceMsg;
		public void setServiceMsg(String serviceMsg){
		getData().put("service_msg",serviceMsg);
		this.serviceMsg=serviceMsg;
	}
	
	public String getServiceMsg(){
		return (String)getData().get("service_msg");
	}	
		
		
	private BigDecimal purchasePrice;
		public void setPurchasePrice(BigDecimal purchasePrice){
		getData().put("purchase_price",purchasePrice);
		this.purchasePrice=purchasePrice;
	}
	
	public BigDecimal getPurchasePrice(){
		return (BigDecimal)getData().get("purchase_price");
	}	
		
		
	private BigDecimal sellPrice;
		public void setSellPrice(BigDecimal sellPrice){
		getData().put("sell_price",sellPrice);
		this.sellPrice=sellPrice;
	}
	
	public BigDecimal getSellPrice(){
		return (BigDecimal)getData().get("sell_price");
	}	
		
		
	private String moral;
		public void setMoral(String moral){
		getData().put("moral",moral);
		this.moral=moral;
	}
	
	public String getMoral(){
		return (String)getData().get("moral");
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
		
		
	private String serviceSite;
		public void setServiceSite(String serviceSite){
		getData().put("service_site",serviceSite);
		this.serviceSite=serviceSite;
	}
	
	public String getServiceSite(){
		return (String)getData().get("service_site");
	}	
		
		
	private String appraiseState;
		public void setAppraiseState(String appraiseState){
		getData().put("appraise_state",appraiseState);
		this.appraiseState=appraiseState;
	}
	
	public String getAppraiseState(){
		return (String)getData().get("appraise_state");
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

