package com.taikang.iu.biz.qualityvalue.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * QualityvalueBO 
  */
public class QualityvalueBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public QualityvalueBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("quality_value_id","quality_id","quality_value_name","state","sort","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String qualityValueId;
		public void setQualityValueId(String qualityValueId){
		getData().put("quality_value_id",qualityValueId);
		this.qualityValueId=qualityValueId;
	}
	
	public String getQualityValueId(){
		return (String)getData().get("quality_value_id");
	}	
		
		
	private String qualityId;
		public void setQualityId(String qualityId){
		getData().put("quality_id",qualityId);
		this.qualityId=qualityId;
	}
	
	public String getQualityId(){
		return (String)getData().get("quality_id");
	}	
		
		
	private String qualityValueName;
		public void setQualityValueName(String qualityValueName){
		getData().put("quality_value_name",qualityValueName);
		this.qualityValueName=qualityValueName;
	}
	
	public String getQualityValueName(){
		return (String)getData().get("quality_value_name");
	}	
		
		
	private String state;
		public void setState(String state){
		getData().put("state",state);
		this.state=state;
	}
	
	public String getState(){
		return (String)getData().get("state");
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

