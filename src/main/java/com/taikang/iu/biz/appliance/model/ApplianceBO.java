package com.taikang.iu.biz.appliance.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * ApplianceBO 
  */
public class ApplianceBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public ApplianceBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("appliance_id","category_id","quality_value_id","created_time","modified_time","appliance_coding","appliance_name","seller_name","appliance_settle_price","appliance_marketprice","interflow_price","service_site","is_return_bills","appliance_unit","appliance_category_id","ismarketable","version","delflag","sellcount","seller_id","seller_code","describe","created_by","modified_by"));
	}
	
		
		
	private String applianceId;
		public void setApplianceId(String applianceId){
		getData().put("appliance_id",applianceId);
		this.applianceId=applianceId;
	}
	
	public String getApplianceId(){
		return (String)getData().get("appliance_id");
	}	
		
		
	private String categoryId;
		public void setCategoryId(String categoryId){
		getData().put("category_id",categoryId);
		this.categoryId=categoryId;
	}
	
	public String getCategoryId(){
		return (String)getData().get("category_id");
	}	
		
		
	private String qualityValueId;
		public void setQualityValueId(String qualityValueId){
		getData().put("quality_value_id",qualityValueId);
		this.qualityValueId=qualityValueId;
	}
	
	public String getQualityValueId(){
		return (String)getData().get("quality_value_id");
	}	
		
		
	private Timestamp createdTime;
		public void setCreatedTime(Timestamp createdTime){
		getData().put("created_time",createdTime);
		this.createdTime=createdTime;
	}
	
	public Timestamp getCreatedTime(){
		return (Timestamp)getData().get("created_time");
	}	
		
		
	private Timestamp modifiedTime;
		public void setModifiedTime(Timestamp modifiedTime){
		getData().put("modified_time",modifiedTime);
		this.modifiedTime=modifiedTime;
	}
	
	public Timestamp getModifiedTime(){
		return (Timestamp)getData().get("modified_time");
	}	
		
		
	private String applianceCoding;
		public void setApplianceCoding(String applianceCoding){
		getData().put("appliance_coding",applianceCoding);
		this.applianceCoding=applianceCoding;
	}
	
	public String getApplianceCoding(){
		return (String)getData().get("appliance_coding");
	}	
		
		
	private String applianceName;
		public void setApplianceName(String applianceName){
		getData().put("appliance_name",applianceName);
		this.applianceName=applianceName;
	}
	
	public String getApplianceName(){
		return (String)getData().get("appliance_name");
	}	
		
		
	private String sellerName;
		public void setSellerName(String sellerName){
		getData().put("seller_name",sellerName);
		this.sellerName=sellerName;
	}
	
	public String getSellerName(){
		return (String)getData().get("seller_name");
	}	
		
		
	private BigDecimal applianceSettlePrice;
		public void setApplianceSettlePrice(BigDecimal applianceSettlePrice){
		getData().put("appliance_settle_price",applianceSettlePrice);
		this.applianceSettlePrice=applianceSettlePrice;
	}
	
	public BigDecimal getApplianceSettlePrice(){
		return (BigDecimal)getData().get("appliance_settle_price");
	}	
		
		
	private BigDecimal applianceMarketprice;
		public void setApplianceMarketprice(BigDecimal applianceMarketprice){
		getData().put("appliance_marketprice",applianceMarketprice);
		this.applianceMarketprice=applianceMarketprice;
	}
	
	public BigDecimal getApplianceMarketprice(){
		return (BigDecimal)getData().get("appliance_marketprice");
	}	
		
		
	private BigDecimal interflowPrice;
		public void setInterflowPrice(BigDecimal interflowPrice){
		getData().put("interflow_price",interflowPrice);
		this.interflowPrice=interflowPrice;
	}
	
	public BigDecimal getInterflowPrice(){
		return (BigDecimal)getData().get("interflow_price");
	}	
		
		
	private String serviceSite;
		public void setServiceSite(String serviceSite){
		getData().put("service_site",serviceSite);
		this.serviceSite=serviceSite;
	}
	
	public String getServiceSite(){
		return (String)getData().get("service_site");
	}	
		
		
	private String isReturnBills;
		public void setIsReturnBills(String isReturnBills){
		getData().put("is_return_bills",isReturnBills);
		this.isReturnBills=isReturnBills;
	}
	
	public String getIsReturnBills(){
		return (String)getData().get("is_return_bills");
	}	
		
		
	private String applianceUnit;
		public void setApplianceUnit(String applianceUnit){
		getData().put("appliance_unit",applianceUnit);
		this.applianceUnit=applianceUnit;
	}
	
	public String getApplianceUnit(){
		return (String)getData().get("appliance_unit");
	}	
		
		
	private String applianceCategoryId;
		public void setApplianceCategoryId(String applianceCategoryId){
		getData().put("appliance_category_id",applianceCategoryId);
		this.applianceCategoryId=applianceCategoryId;
	}
	
	public String getApplianceCategoryId(){
		return (String)getData().get("appliance_category_id");
	}	
		
		
	private String ismarketable;
		public void setIsmarketable(String ismarketable){
		getData().put("ismarketable",ismarketable);
		this.ismarketable=ismarketable;
	}
	
	public String getIsmarketable(){
		return (String)getData().get("ismarketable");
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
		
		
	private Integer sellcount;
		public void setSellcount(Integer sellcount){
		getData().put("sellcount",sellcount);
		this.sellcount=sellcount;
	}
	
	public Integer getSellcount(){
		return (Integer)getData().get("sellcount");
	}	
		
		
	private String sellerId;
		public void setSellerId(String sellerId){
		getData().put("seller_id",sellerId);
		this.sellerId=sellerId;
	}
	
	public String getSellerId(){
		return (String)getData().get("seller_id");
	}	
		
		
	private String sellerCode;
		public void setSellerCode(String sellerCode){
		getData().put("seller_code",sellerCode);
		this.sellerCode=sellerCode;
	}
	
	public String getSellerCode(){
		return (String)getData().get("seller_code");
	}	
		
		
	private String describe;
		public void setDescribe(String describe){
		getData().put("describe",describe);
		this.describe=describe;
	}
	
	public String getDescribe(){
		return (String)getData().get("describe");
	}	
	
	private String createdBy;
	public String getCreatedBy() {
		return (String)getData().get("created_by");
	}

	public void setCreatedBy(String createdBy) {
		getData().put("created_by",createdBy);
		this.createdBy = createdBy;
	}

	
	private String modifiedBy;
		public String getModifiedBy() {
		return (String)getData().get("modified_by");
	}

	public void setModifiedBy(String modifiedBy) {
		getData().put("modified_by",modifiedBy);
		this.modifiedBy = modifiedBy;
	}
	
	
}

