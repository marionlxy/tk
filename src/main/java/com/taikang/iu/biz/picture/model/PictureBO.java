package com.taikang.iu.biz.picture.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * PictureBO 
  */
public class PictureBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public PictureBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("picture_id","appliance_id","sku_id","appliance_code","picture_address","sort","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String pictureId;
		public void setPictureId(String pictureId){
		getData().put("picture_id",pictureId);
		this.pictureId=pictureId;
	}
	
	public String getPictureId(){
		return (String)getData().get("picture_id");
	}	
		
		
	private String applianceId;
		public void setApplianceId(String applianceId){
		getData().put("appliance_id",applianceId);
		this.applianceId=applianceId;
	}
	
	public String getApplianceId(){
		return (String)getData().get("appliance_id");
	}	
		
		
	private String skuId;
		public void setSkuId(String skuId){
		getData().put("sku_id",skuId);
		this.skuId=skuId;
	}
	
	public String getSkuId(){
		return (String)getData().get("sku_id");
	}	
		
		
	private String applianceCode;
		public void setApplianceCode(String applianceCode){
		getData().put("appliance_code",applianceCode);
		this.applianceCode=applianceCode;
	}
	
	public String getApplianceCode(){
		return (String)getData().get("appliance_code");
	}	
		
		
	private String pictureAddress;
		public void setPictureAddress(String pictureAddress){
		getData().put("picture_address",pictureAddress);
		this.pictureAddress=pictureAddress;
	}
	
	public String getPictureAddress(){
		return (String)getData().get("picture_address");
	}	
		
		
	private Integer sort;
		public void setSort(Integer sort){
		getData().put("sort",sort);
		this.sort=sort;
	}
	
	public Integer getSort(){
		return (Integer)getData().get("sort");
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

