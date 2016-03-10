package com.taikang.iu.opt.business.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * BusinessBO 
  */
public class BusinessBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public BusinessBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("business_id","mernum","termid","trandate","trantime","referno","batchno","serialno","pan","amt","trantype","paytype","orderid","ext1","ext2","sign","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String businessId;
		public void setBusinessId(String businessId){
		getData().put("business_id",businessId);
		this.businessId=businessId;
	}
	
	public String getBusinessId(){
		return (String)getData().get("business_id");
	}	
		
		
	private String mernum;
		public void setMernum(String mernum){
		getData().put("mernum",mernum);
		this.mernum=mernum;
	}
	
	public String getMernum(){
		return (String)getData().get("mernum");
	}	
		
		
	private String termid;
		public void setTermid(String termid){
		getData().put("termid",termid);
		this.termid=termid;
	}
	
	public String getTermid(){
		return (String)getData().get("termid");
	}	
		
		
	private String trandate;
		public void setTrandate(String trandate){
		getData().put("trandate",trandate);
		this.trandate=trandate;
	}
	
	public String getTrandate(){
		return (String)getData().get("trandate");
	}	
		
		
	private String trantime;
		public void setTrantime(String trantime){
		getData().put("trantime",trantime);
		this.trantime=trantime;
	}
	
	public String getTrantime(){
		return (String)getData().get("trantime");
	}	
		
		
	private String referno;
		public void setReferno(String referno){
		getData().put("referno",referno);
		this.referno=referno;
	}
	
	public String getReferno(){
		return (String)getData().get("referno");
	}	
		
		
	private String batchno;
		public void setBatchno(String batchno){
		getData().put("batchno",batchno);
		this.batchno=batchno;
	}
	
	public String getBatchno(){
		return (String)getData().get("batchno");
	}	
		
		
	private String serialno;
		public void setSerialno(String serialno){
		getData().put("serialno",serialno);
		this.serialno=serialno;
	}
	
	public String getSerialno(){
		return (String)getData().get("serialno");
	}	
		
		
	private String pan;
		public void setPan(String pan){
		getData().put("pan",pan);
		this.pan=pan;
	}
	
	public String getPan(){
		return (String)getData().get("pan");
	}	
		
		
	private BigDecimal amt;
		public void setAmt(BigDecimal amt){
		getData().put("amt",amt);
		this.amt=amt;
	}
	
	public BigDecimal getAmt(){
		return (BigDecimal)getData().get("amt");
	}	
		
		
	private String trantype;
		public void setTrantype(String trantype){
		getData().put("trantype",trantype);
		this.trantype=trantype;
	}
	
	public String getTrantype(){
		return (String)getData().get("trantype");
	}	
		
		
	private String paytype;
		public void setPaytype(String paytype){
		getData().put("paytype",paytype);
		this.paytype=paytype;
	}
	
	public String getPaytype(){
		return (String)getData().get("paytype");
	}	
		
		
	private String orderid;
		public void setOrderid(String orderid){
		getData().put("orderid",orderid);
		this.orderid=orderid;
	}
	
	public String getOrderid(){
		return (String)getData().get("orderid");
	}	
		
		
	private String ext1;
		public void setExt1(String ext1){
		getData().put("ext1",ext1);
		this.ext1=ext1;
	}
	
	public String getExt1(){
		return (String)getData().get("ext1");
	}	
		
		
	private String ext2;
		public void setExt2(String ext2){
		getData().put("ext2",ext2);
		this.ext2=ext2;
	}
	
	public String getExt2(){
		return (String)getData().get("ext2");
	}	
		
		
	private String sign;
		public void setSign(String sign){
		getData().put("sign",sign);
		this.sign=sign;
	}
	
	public String getSign(){
		return (String)getData().get("sign");
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

