package com.taikang.iu.opt.worksheet.model;

import java.sql.Timestamp;
import java.util.Arrays;

import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * WorksheetBO 
  */
public class WorksheetBO extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public WorksheetBO(){
		init();
	}
	
	protected final void init(){
		super.init();
		this.addList(Arrays.asList("worksheet_id","order_id","order_code","worksheet_code","worksheet_state","clue_id","clue_code","custom_id","custom_name","custom_sex","custom_tel","custom_address","custom_require","door_time","invalid_reason","proxy_tel","remark","angel_code","angel_name","angel_tel","angel_open_id","created_time","created_by","modified_time","modified_by","site","version","delflag"));
	}
	
		
		
	private String worksheetId;
		public void setWorksheetId(String worksheetId){
		getData().put("worksheet_id",worksheetId);
		this.worksheetId=worksheetId;
	}
	
	public String getWorksheetId(){
		return (String)getData().get("worksheet_id");
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
		
		
	private String worksheetCode;
		public void setWorksheetCode(String worksheetCode){
		getData().put("worksheet_code",worksheetCode);
		this.worksheetCode=worksheetCode;
	}
	
	public String getWorksheetCode(){
		return (String)getData().get("worksheet_code");
	}	
		
		
	private String worksheetState;
		public void setWorksheetState(String worksheetState){
		getData().put("worksheet_state",worksheetState);
		this.worksheetState=worksheetState;
	}
	
	public String getWorksheetState(){
		return (String)getData().get("worksheet_state");
	}	
		
		
	private String clueId;
		public void setClueId(String clueId){
		getData().put("clue_id",clueId);
		this.clueId=clueId;
	}
	
	public String getClueId(){
		return (String)getData().get("clue_id");
	}	
		
		
	private String clueCode;
		public void setClueCode(String clueCode){
		getData().put("clue_code",clueCode);
		this.clueCode=clueCode;
	}
	
	public String getClueCode(){
		return (String)getData().get("clue_code");
	}	
		
		
	private String customId;
		public void setCustomId(String customId){
		getData().put("custom_id",customId);
		this.customId=customId;
	}
	
	public String getCustomId(){
		return (String)getData().get("custom_id");
	}	
		
		
	private String customName;
		public void setCustomName(String customName){
		getData().put("custom_name",customName);
		this.customName=customName;
	}
	
	public String getCustomName(){
		return (String)getData().get("custom_name");
	}	
		
		
	private String customSex;
		public void setCustomSex(String customSex){
		getData().put("custom_sex",customSex);
		this.customSex=customSex;
	}
	
	public String getCustomSex(){
		return (String)getData().get("custom_sex");
	}	
		
		
	private String customTel;
		public void setCustomTel(String customTel){
		getData().put("custom_tel",customTel);
		this.customTel=customTel;
	}
	
	public String getCustomTel(){
		return (String)getData().get("custom_tel");
	}	
		
		
	private String customAddress;
		public void setCustomAddress(String customAddress){
		getData().put("custom_address",customAddress);
		this.customAddress=customAddress;
	}
	
	public String getCustomAddress(){
		return (String)getData().get("custom_address");
	}	
		
		
	private String customRequire;
		public void setCustomRequire(String customRequire){
		getData().put("custom_require",customRequire);
		this.customRequire=customRequire;
	}
	
	public String getCustomRequire(){
		return (String)getData().get("custom_require");
	}	
		
		
	private Timestamp doorTime;
		public void setDoorTime(Timestamp doorTime){
		getData().put("door_time",doorTime);
		this.doorTime=doorTime;
	}
	
	public Timestamp getDoorTime(){
		return (Timestamp)getData().get("door_time");
	}	
		
		
	private String invalidReason;
		public void setInvalidReason(String invalidReason){
		getData().put("invalid_reason",invalidReason);
		this.invalidReason=invalidReason;
	}
	
	public String getInvalidReason(){
		return (String)getData().get("invalid_reason");
	}	
		
		
	private String proxyTel;
		public void setProxyTel(String proxyTel){
		getData().put("proxy_tel",proxyTel);
		this.proxyTel=proxyTel;
	}
	
	public String getProxyTel(){
		return (String)getData().get("proxy_tel");
	}	
		
		
	private String remark;
		public void setRemark(String remark){
		getData().put("remark",remark);
		this.remark=remark;
	}
	
	public String getRemark(){
		return (String)getData().get("remark");
	}	
		
		
	private String angelCode;
		public void setAngelCode(String angelCode){
		getData().put("angel_code",angelCode);
		this.angelCode=angelCode;
	}
	
	public String getAngelCode(){
		return (String)getData().get("angel_code");
	}	
		
		
	private String angelName;
		public void setAngelName(String angelName){
		getData().put("angel_name",angelName);
		this.angelName=angelName;
	}
	
	public String getAngelName(){
		return (String)getData().get("angel_name");
	}	
		
		
	private String angelTel;
		public void setAngelTel(String angelTel){
		getData().put("angel_tel",angelTel);
		this.angelTel=angelTel;
	}
	
	public String getAngelTel(){
		return (String)getData().get("angel_tel");
	}	
		
		
	private String angelOpenId;
		public void setAngelOpenId(String angelOpenId){
		getData().put("angel_open_id",angelOpenId);
		this.angelOpenId=angelOpenId;
	}
	
	public String getAngelOpenId(){
		return (String)getData().get("angel_open_id");
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
	private String site;
	public void setSite(String site){
	getData().put("site",site);
	this.site=site;
}

public String getSite(){
	return (String)getData().get("site");
}	
	
	 }


