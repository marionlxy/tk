package com.taikang.iu.opt.order.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * OrderMealBO 
  */
public class OrderMealBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public OrderMealBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("meal_id","order_id","meal_code","meal_name","site","meal_price","meal_type","meal_conte","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String mealId;
		public void setMealId(String mealId){
		getData().put("meal_id",mealId);
		this.mealId=mealId;
	}
	
	public String getMealId(){
		return (String)getData().get("meal_id");
	}	
		
		
	private String orderId;
		public void setOrderId(String orderId){
		getData().put("order_id",orderId);
		this.orderId=orderId;
	}
	
	public String getOrderId(){
		return (String)getData().get("order_id");
	}	
		
		
	private String mealCode;
		public void setMealCode(String mealCode){
		getData().put("meal_code",mealCode);
		this.mealCode=mealCode;
	}
	
	public String getMealCode(){
		return (String)getData().get("meal_code");
	}	
		
		
	private String mealName;
		public void setMealName(String mealName){
		getData().put("meal_name",mealName);
		this.mealName=mealName;
	}
	
	public String getMealName(){
		return (String)getData().get("meal_name");
	}	
		
		
	private String site;
		public void setSite(String site){
		getData().put("site",site);
		this.site=site;
	}
	
	public String getSite(){
		return (String)getData().get("site");
	}	
		
		
	private BigDecimal mealPrice;
		public void setMealPrice(BigDecimal mealPrice){
		getData().put("meal_price",mealPrice);
		this.mealPrice=mealPrice;
	}
	
	public BigDecimal getMealPrice(){
		return (BigDecimal)getData().get("meal_price");
	}	
		
		
	private String mealType;
		public void setMealType(String mealType){
		getData().put("meal_type",mealType);
		this.mealType=mealType;
	}
	
	public String getMealType(){
		return (String)getData().get("meal_type");
	}	
		
		
	private String mealConte;
		public void setMealConte(String mealConte){
		getData().put("meal_conte",mealConte);
		this.mealConte=mealConte;
	}
	
	public String getMealConte(){
		return (String)getData().get("meal_conte");
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

