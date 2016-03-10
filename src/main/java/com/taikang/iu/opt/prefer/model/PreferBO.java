package com.taikang.iu.opt.prefer.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * PreferBO 
  */
public class PreferBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public PreferBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("prefer_id","lower_limit","upper_limit","prefer_mini","prefer_max","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String preferId;
		public void setPreferId(String preferId){
		getData().put("prefer_id",preferId);
		this.preferId=preferId;
	}
	
	public String getPreferId(){
		return (String)getData().get("prefer_id");
	}	
		
		
	private BigDecimal lowerLimit;
		public void setLowerLimit(BigDecimal lowerLimit){
		getData().put("lower_limit",lowerLimit);
		this.lowerLimit=lowerLimit;
	}
	
	public BigDecimal getLowerLimit(){
		return (BigDecimal)getData().get("lower_limit");
	}	
		
		
	private BigDecimal upperLimit;
		public void setUpperLimit(BigDecimal upperLimit){
		getData().put("upper_limit",upperLimit);
		this.upperLimit=upperLimit;
	}
	
	public BigDecimal getUpperLimit(){
		return (BigDecimal)getData().get("upper_limit");
	}	
		
		
	private BigDecimal preferMini;
		public void setPreferMini(BigDecimal preferMini){
		getData().put("prefer_mini",preferMini);
		this.preferMini=preferMini;
	}
	
	public BigDecimal getPreferMini(){
		return (BigDecimal)getData().get("prefer_mini");
	}	
		
		
	private BigDecimal preferMax;
		public void setPreferMax(BigDecimal preferMax){
		getData().put("prefer_max",preferMax);
		this.preferMax=preferMax;
	}
	
	public BigDecimal getPreferMax(){
		return (BigDecimal)getData().get("prefer_max");
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

