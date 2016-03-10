package com.taikang.iu.opt.single.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * SingleBO 
  */
public class SingleBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public SingleBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("seller_id","relation_id","seller_name","seller_type","seller_code","settle_price","service_id","service_num","seller_linkman","seller_tel","seller_address","site","bank_name","bank_account","account_holder","seller_state","service_name","service_type","service_msg","purchase_price","sell_price","facilitator_count","service_state","moral","picture_url","sell_count","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
	private String sellerId;
	public void setSellerId(String sellerId){
	getData().put("seller_id",sellerId);
	this.sellerId=sellerId;
	}

	public String getSellerId(){
		return (String)getData().get("seller_id");
	}	
	private String sellerType;
	public void setSellerType(String sellerType){
		getData().put("seller_type",sellerType);
		this.sellerType=sellerType;
	}
	
	public String getSellerType(){
		return (String)getData().get("seller_type");
	}	
	
	
	private String sellerName;
	public void setSellerName(String sellerName){
		getData().put("seller_name",sellerName);
		this.sellerName=sellerName;
	}

	public String getSellerName(){
		return (String)getData().get("seller_name");
	}	
	
	private String sellerLinkman;
	public void setSellerLinkman(String sellerLinkman){
	getData().put("seller_linkman",sellerLinkman);
	this.sellerLinkman=sellerLinkman;
}

public String getSellerLinkman(){
	return (String)getData().get("seller_linkman");
}	
	
	
private String sellerTel;
	public void setSellerTel(String sellerTel){
	getData().put("seller_tel",sellerTel);
	this.sellerTel=sellerTel;
}

public String getSellerTel(){
	return (String)getData().get("seller_tel");
}	
	
	
private String sellerAddress;
	public void setSellerAddress(String sellerAddress){
	getData().put("seller_address",sellerAddress);
	this.sellerAddress=sellerAddress;
}

public String getSellerAddress(){
	return (String)getData().get("seller_address");
}	
	
	
private String site;
	public void setSite(String site){
	getData().put("site",site);
	this.site=site;
}

public String getSite(){
	return (String)getData().get("site");
}	
	
	
private String bankName;
	public void setBankName(String bankName){
	getData().put("bank_name",bankName);
	this.bankName=bankName;
}

public String getBankName(){
	return (String)getData().get("bank_name");
}	
	
	
private String bankAccount;
	public void setBankAccount(String bankAccount){
	getData().put("bank_account",bankAccount);
	this.bankAccount=bankAccount;
}

public String getBankAccount(){
	return (String)getData().get("bank_account");
}	
private String accountHolder;
public void setAccountHolder(String accountHolder){
getData().put("account_holder",accountHolder);
this.accountHolder=accountHolder;
}

public String getAccountHolder(){
return (String)getData().get("account_holder");
}	


private String sellerState;
public void setSellerState(String sellerState){
getData().put("seller_state",sellerState);
this.sellerState=sellerState;
}

public String getSellerState(){
return (String)getData().get("seller_state");
}	


	
	private String sellerCode;
	public void setSellerCode(String sellerCode){
		getData().put("seller_code",sellerCode);
		this.sellerCode=sellerCode;
	}

	public String getSellerCode(){
		return (String)getData().get("seller_code");
	}	
	
	
	private String relationId;
	public void setRelationId(String relationId){
		getData().put("relation_id",relationId);
		this.relationId=relationId;
	}

	public String getRelationId(){
		return (String)getData().get("relation_id");
	}	
	
	private BigDecimal settlePrice;
	public void setSettlePrice(BigDecimal settlePrice){
		getData().put("settle_price",settlePrice);
		this.settlePrice=settlePrice;
	}

	public BigDecimal getSettlePrice(){
		return (BigDecimal)getData().get("settle_price");
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
		
		
	private Integer facilitatorCount;
		public void setFacilitatorCount(Integer facilitatorCount){
		getData().put("facilitator_count",facilitatorCount);
		this.facilitatorCount=facilitatorCount;
	}
	
	public Integer getFacilitatorCount(){
		return (Integer)getData().get("facilitator_count");
	}	
		
		
	private String serviceState;
		public void setServiceState(String serviceState){
		getData().put("service_state",serviceState);
		this.serviceState=serviceState;
	}
	
	public String getServiceState(){
		return (String)getData().get("service_state");
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
		
		
	private Integer sellCount;
		public void setSellCount(Integer sellCount){
		getData().put("sell_count",sellCount);
		this.sellCount=sellCount;
	}
	
	public Integer getSellCount(){
		return (Integer)getData().get("sell_count");
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



