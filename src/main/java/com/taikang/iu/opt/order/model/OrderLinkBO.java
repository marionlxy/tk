package com.taikang.iu.opt.order.model;

import java.sql.Timestamp;
import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * OrderLinkBO 
  */
public class OrderLinkBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public OrderLinkBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("link_id","meal_id","link_code","link_name","link_num","stage","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String linkId;
		public void setLinkId(String linkId){
		getData().put("link_id",linkId);
		this.linkId=linkId;
	}
	
	public String getLinkId(){
		return (String)getData().get("link_id");
	}	
		
		
	private String mealId;
		public void setMealId(String mealId){
		getData().put("meal_id",mealId);
		this.mealId=mealId;
	}
	
	public String getMealId(){
		return (String)getData().get("meal_id");
	}	
		
		
	private String linkCode;
		public void setLinkCode(String linkCode){
		getData().put("link_code",linkCode);
		this.linkCode=linkCode;
	}
	
	public String getLinkCode(){
		return (String)getData().get("link_code");
	}	
		
		
	private String linkName;
		public void setLinkName(String linkName){
		getData().put("link_name",linkName);
		this.linkName=linkName;
	}
	
	public String getLinkName(){
		return (String)getData().get("link_name");
	}	
		
		
	private Integer linkNum;
		public void setLinkNum(Integer linkNum){
		getData().put("link_num",linkNum);
		this.linkNum=linkNum;
	}
	
	public Integer getLinkNum(){
		return (Integer)getData().get("link_num");
	}	
		
		
	private String stage;
		public void setStage(String stage){
		getData().put("stage",stage);
		this.stage=stage;
	}
	
	public String getStage(){
		return (String)getData().get("stage");
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

