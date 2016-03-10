package com.taikang.iu.opt.cemetery.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * CemeteryBO 
  */
public class CemeteryBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public CemeteryBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("cemetery_addrass","cemetery_id","cemetery_code","cemetery_name","cemetery_content","cemetery_type","real_url","signal_url","longitude","latitude","site","areacode","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String cemeteryId;
		public void setCemeteryId(String cemeteryId){
		getData().put("cemetery_id",cemeteryId);
		this.cemeteryId=cemeteryId;
	}
	
	public String getCemeteryId(){
		return (String)getData().get("cemetery_id");
	}	
		
		
	private String cemeteryCode;
		public void setCemeteryCode(String cemeteryCode){
		getData().put("cemetery_code",cemeteryCode);
		this.cemeteryCode=cemeteryCode;
	}
	
	public String getCemeteryCode(){
		return (String)getData().get("cemetery_code");
	}	
		
		
	private String cemeteryAddrass;
		public void setCemeteryAddrass(String cemeteryAddrass){
		getData().put("cemetery_addrass",cemeteryAddrass);
		this.cemeteryAddrass=cemeteryAddrass;
	}
	
	public String getCemeteryAddrass(){
		return (String)getData().get("cemetery_addrass");
	}	
	
	
	private String cemeteryName;
	public void setCemeteryName(String cemeteryName){
		getData().put("cemetery_name",cemeteryName);
		this.cemeteryName=cemeteryName;
	}
	
	public String getCemeteryName(){
		return (String)getData().get("cemetery_name");
	}	
		
	private String cemeteryContent;
		public void setCemeteryContent(String cemeteryContent){
		getData().put("cemetery_content",cemeteryContent);
		this.cemeteryContent=cemeteryContent;
	}
	
	public String getCemeteryContent(){
		return (String)getData().get("cemetery_content");
	}	
		
		
	private String cemeteryType;
		public void setCemeteryType(String cemeteryType){
		getData().put("cemetery_type",cemeteryType);
		this.cemeteryType=cemeteryType;
	}
	
	public String getCemeteryType(){
		return (String)getData().get("cemetery_type");
	}	
		
		
	private String realUrl;
		public void setRealUrl(String realUrl){
		getData().put("real_url",realUrl);
		this.realUrl=realUrl;
	}
	
	public String getRealUrl(){
		return (String)getData().get("real_url");
	}	
		
		
	private String signalUrl;
		public void setSignalUrl(String signalUrl){
		getData().put("signal_url",signalUrl);
		this.signalUrl=signalUrl;
	}
	
	public String getSignalUrl(){
		return (String)getData().get("signal_url");
	}	
		
		
	private String longitude;
		public void setLongitude(String longitude){
		getData().put("longitude",longitude);
		this.longitude=longitude;
	}
	
	public String getLongitude(){
		return (String)getData().get("longitude");
	}	
		
		
	private String latitude;
		public void setLatitude(String latitude){
		getData().put("latitude",latitude);
		this.latitude=latitude;
	}
	
	public String getLatitude(){
		return (String)getData().get("latitude");
	}	
		
		
	private String site;
		public void setSite(String site){
		getData().put("site",site);
		this.site=site;
	}
	
	public String getSite(){
		return (String)getData().get("site");
	}	
		
		
	private String areacode;
		public void setAreacode(String areacode){
		getData().put("areacode",areacode);
		this.areacode=areacode;
	}
	
	public String getAreacode(){
		return (String)getData().get("areacode");
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

