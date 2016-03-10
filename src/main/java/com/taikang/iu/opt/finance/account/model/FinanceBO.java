package com.taikang.iu.opt.finance.account.model;

import java.sql.Timestamp;
import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * FinanceBO 
  */
public class FinanceBO  extends BaseBO {
	
	private static final long serialVersionUID = 1L;
	
	public FinanceBO(){
		init();
	}
	
	protected void init(){
		super.init();
		this.addList(Arrays.asList("bank_account","serialno","order_id","order_code","order_state","order_type","order_sub_type","custom_id","custom_login_name","custom_name","custom_sex","custom_tel","custom_address","custom_email","custom_type","seller_code","seller_name","angel_login_name","angel_code","angel_name","angel_tel","angel_open_id","receiver_name","receiver_postcode","receiver_phone","receiver_address","site","pay_method","invoice_state","invoice_name","invoice_content","order_price","prefer_price","oddnum","logistics","logistics_cost","account_state","appraise_state","pay_by","pay_time","pay_time1","cancel_by","cancel_time","create_sub_by","create_sub_time","send_by","send_time","edit_send_by","edit_send_time","take_by","take_time","reject_by","reject_time","refund_by","refund_time","complete_by","complete_time","created_time","created_by","modified_time","modified_by","version","delflag"));
	}
	
		
		
	private String orderId;
		public void setOrderId(String orderId){
		getData().put("order_id",orderId);
		this.orderId=orderId;
	}
	
	public String getOrderId(){
		return (String)getData().get("order_id");
	}	
	private String bankAccount;
	public void setBankAccount(String bankAccount){
		getData().put("bank_account",bankAccount);
		this.bankAccount=bankAccount;
	}
	
	public String getBankAccount(){
		return (String)getData().get("bank_account");
	}	
	
	private String serialno;
	public void setSerialno(String serialno){
		getData().put("serialno",serialno);
		this.serialno=serialno;
	}
	
	public String getSerialno(){
		return (String)getData().get("serialno");
	}	
		
		
	private String orderCode;
		public void setOrderCode(String orderCode){
		getData().put("order_code",orderCode);
		this.orderCode=orderCode;
	}
	
	public String getOrderCode(){
		return (String)getData().get("order_code");
	}	
		
		
	private String orderState;
		public void setOrderState(String orderState){
		getData().put("order_state",orderState);
		this.orderState=orderState;
	}
	
	public String getOrderState(){
		return (String)getData().get("order_state");
	}	
		
		
	private String orderType;
		public void setOrderType(String orderType){
		getData().put("order_type",orderType);
		this.orderType=orderType;
	}
	
	public String getOrderType(){
		return (String)getData().get("order_type");
	}	
		
		
	private String orderSubType;
		public void setOrderSubType(String orderSubType){
		getData().put("order_sub_type",orderSubType);
		this.orderSubType=orderSubType;
	}
	
	public String getOrderSubType(){
		return (String)getData().get("order_sub_type");
	}	
		
		
	private String customId;
		public void setCustomId(String customId){
		getData().put("custom_id",customId);
		this.customId=customId;
	}
	
	public String getCustomId(){
		return (String)getData().get("custom_id");
	}	
		
		
	private String customLoginName;
		public void setCustomLoginName(String customLoginName){
		getData().put("custom_login_name",customLoginName);
		this.customLoginName=customLoginName;
	}
	
	public String getCustomLoginName(){
		return (String)getData().get("custom_login_name");
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
		
		
	private String customEmail;
		public void setCustomEmail(String customEmail){
		getData().put("custom_email",customEmail);
		this.customEmail=customEmail;
	}
	
	public String getCustomEmail(){
		return (String)getData().get("custom_email");
	}	
		
		
	private String customType;
		public void setCustomType(String customType){
		getData().put("custom_type",customType);
		this.customType=customType;
	}
	
	public String getCustomType(){
		return (String)getData().get("custom_type");
	}	
		
		
	private String sellerCode;
		public void setSellerCode(String sellerCode){
		getData().put("seller_code",sellerCode);
		this.sellerCode=sellerCode;
	}
	
	public String getSellerCode(){
		return (String)getData().get("seller_code");
	}	
		
		
	private String sellerName;
		public void setSellerName(String sellerName){
		getData().put("seller_name",sellerName);
		this.sellerName=sellerName;
	}
	
	public String getSellerName(){
		return (String)getData().get("seller_name");
	}	
		
		
	private String angelLoginName;
		public void setAngelLoginName(String angelLoginName){
		getData().put("angel_login_name",angelLoginName);
		this.angelLoginName=angelLoginName;
	}
	
	public String getAngelLoginName(){
		return (String)getData().get("angel_login_name");
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
		
		
	private String receiverName;
		public void setReceiverName(String receiverName){
		getData().put("receiver_name",receiverName);
		this.receiverName=receiverName;
	}
	
	public String getReceiverName(){
		return (String)getData().get("receiver_name");
	}	
		
		
	private String receiverPostcode;
		public void setReceiverPostcode(String receiverPostcode){
		getData().put("receiver_postcode",receiverPostcode);
		this.receiverPostcode=receiverPostcode;
	}
	
	public String getReceiverPostcode(){
		return (String)getData().get("receiver_postcode");
	}	
		
		
	private String receiverPhone;
		public void setReceiverPhone(String receiverPhone){
		getData().put("receiver_phone",receiverPhone);
		this.receiverPhone=receiverPhone;
	}
	
	public String getReceiverPhone(){
		return (String)getData().get("receiver_phone");
	}	
		
		
	private String receiverAddress;
		public void setReceiverAddress(String receiverAddress){
		getData().put("receiver_address",receiverAddress);
		this.receiverAddress=receiverAddress;
	}
	
	public String getReceiverAddress(){
		return (String)getData().get("receiver_address");
	}	
		
		
	private String site;
		public void setSite(String site){
		getData().put("site",site);
		this.site=site;
	}
	
	public String getSite(){
		return (String)getData().get("site");
	}	
		
		
	private String payMethod;
		public void setPayMethod(String payMethod){
		getData().put("pay_method",payMethod);
		this.payMethod=payMethod;
	}
	
	public String getPayMethod(){
		return (String)getData().get("pay_method");
	}	
		
		
	private String invoiceState;
		public void setInvoiceState(String invoiceState){
		getData().put("invoice_state",invoiceState);
		this.invoiceState=invoiceState;
	}
	
	public String getInvoiceState(){
		return (String)getData().get("invoice_state");
	}	
		
		
	private String invoiceName;
		public void setInvoiceName(String invoiceName){
		getData().put("invoice_name",invoiceName);
		this.invoiceName=invoiceName;
	}
	
	public String getInvoiceName(){
		return (String)getData().get("invoice_name");
	}	
		
		
	private String invoiceContent;
		public void setInvoiceContent(String invoiceContent){
		getData().put("invoice_content",invoiceContent);
		this.invoiceContent=invoiceContent;
	}
	
	public String getInvoiceContent(){
		return (String)getData().get("invoice_content");
	}	
		
		
	private BigDecimal orderPrice;
		public void setOrderPrice(BigDecimal orderPrice){
		getData().put("order_price",orderPrice);
		this.orderPrice=orderPrice;
	}
	
	public BigDecimal getOrderPrice(){
		return (BigDecimal)getData().get("order_price");
	}	
		
		
	private BigDecimal preferPrice;
		public void setPreferPrice(BigDecimal preferPrice){
		getData().put("prefer_price",preferPrice);
		this.preferPrice=preferPrice;
	}
	
	public BigDecimal getPreferPrice(){
		return (BigDecimal)getData().get("prefer_price");
	}	
		
		
	private String oddnum;
		public void setOddnum(String oddnum){
		getData().put("oddnum",oddnum);
		this.oddnum=oddnum;
	}
	
	public String getOddnum(){
		return (String)getData().get("oddnum");
	}	
		
		
	private String logistics;
		public void setLogistics(String logistics){
		getData().put("logistics",logistics);
		this.logistics=logistics;
	}
	
	public String getLogistics(){
		return (String)getData().get("logistics");
	}	
		
		
	private BigDecimal logisticsCost;
		public void setLogisticsCost(BigDecimal logisticsCost){
		getData().put("logistics_cost",logisticsCost);
		this.logisticsCost=logisticsCost;
	}
	
	public BigDecimal getLogisticsCost(){
		return (BigDecimal)getData().get("logistics_cost");
	}	
		
		
	private String accountState;
		public void setAccountState(String accountState){
		getData().put("account_state",accountState);
		this.accountState=accountState;
	}
	
	public String getAccountState(){
		return (String)getData().get("account_state");
	}	
		
		
	private String appraiseState;
		public void setAppraiseState(String appraiseState){
		getData().put("appraise_state",appraiseState);
		this.appraiseState=appraiseState;
	}
	
	public String getAppraiseState(){
		return (String)getData().get("appraise_state");
	}	
		
		
	private String payBy;
		public void setPayBy(String payBy){
		getData().put("pay_by",payBy);
		this.payBy=payBy;
	}
	
	public String getPayBy(){
		return (String)getData().get("pay_by");
	}	
		
		
	private Timestamp payTime;
		public void setPayTime(Timestamp payTime){
		getData().put("pay_time",payTime);
		this.payTime=payTime;
	}
	
	public Timestamp getPayTime(){
		return (Timestamp)getData().get("pay_time");
	}	
	private Timestamp payTime1;
	public void setPayTime1(Timestamp payTime1){
		getData().put("pay_time1",payTime1);
		this.payTime1=payTime1;
	}
	
	public Timestamp getPayTime1(){
		return (Timestamp)getData().get("pay_time1");
	}	
		
		
	private String cancelBy;
		public void setCancelBy(String cancelBy){
		getData().put("cancel_by",cancelBy);
		this.cancelBy=cancelBy;
	}
	
	public String getCancelBy(){
		return (String)getData().get("cancel_by");
	}	
		
		
	private Timestamp cancelTime;
		public void setCancelTime(Timestamp cancelTime){
		getData().put("cancel_time",cancelTime);
		this.cancelTime=cancelTime;
	}
	
	public Timestamp getCancelTime(){
		return (Timestamp)getData().get("cancel_time");
	}	
		
		
	private String createSubBy;
		public void setCreateSubBy(String createSubBy){
		getData().put("create_sub_by",createSubBy);
		this.createSubBy=createSubBy;
	}
	
	public String getCreateSubBy(){
		return (String)getData().get("create_sub_by");
	}	
		
		
	private Timestamp createSubTime;
		public void setCreateSubTime(Timestamp createSubTime){
		getData().put("create_sub_time",createSubTime);
		this.createSubTime=createSubTime;
	}
	
	public Timestamp getCreateSubTime(){
		return (Timestamp)getData().get("create_sub_time");
	}	
		
		
	private String sendBy;
		public void setSendBy(String sendBy){
		getData().put("send_by",sendBy);
		this.sendBy=sendBy;
	}
	
	public String getSendBy(){
		return (String)getData().get("send_by");
	}	
		
		
	private Timestamp sendTime;
		public void setSendTime(Timestamp sendTime){
		getData().put("send_time",sendTime);
		this.sendTime=sendTime;
	}
	
	public Timestamp getSendTime(){
		return (Timestamp)getData().get("send_time");
	}	
		
		
	private String editSendBy;
		public void setEditSendBy(String editSendBy){
		getData().put("edit_send_by",editSendBy);
		this.editSendBy=editSendBy;
	}
	
	public String getEditSendBy(){
		return (String)getData().get("edit_send_by");
	}	
		
		
	private Timestamp editSendTime;
		public void setEditSendTime(Timestamp editSendTime){
		getData().put("edit_send_time",editSendTime);
		this.editSendTime=editSendTime;
	}
	
	public Timestamp getEditSendTime(){
		return (Timestamp)getData().get("edit_send_time");
	}	
		
		
	private String takeBy;
		public void setTakeBy(String takeBy){
		getData().put("take_by",takeBy);
		this.takeBy=takeBy;
	}
	
	public String getTakeBy(){
		return (String)getData().get("take_by");
	}	
		
		
	private Timestamp takeTime;
		public void setTakeTime(Timestamp takeTime){
		getData().put("take_time",takeTime);
		this.takeTime=takeTime;
	}
	
	public Timestamp getTakeTime(){
		return (Timestamp)getData().get("take_time");
	}	
		
		
	private String rejectBy;
		public void setRejectBy(String rejectBy){
		getData().put("reject_by",rejectBy);
		this.rejectBy=rejectBy;
	}
	
	public String getRejectBy(){
		return (String)getData().get("reject_by");
	}	
		
		
	private Timestamp rejectTime;
		public void setRejectTime(Timestamp rejectTime){
		getData().put("reject_time",rejectTime);
		this.rejectTime=rejectTime;
	}
	
	public Timestamp getRejectTime(){
		return (Timestamp)getData().get("reject_time");
	}	
		
		
	private String refundBy;
		public void setRefundBy(String refundBy){
		getData().put("refund_by",refundBy);
		this.refundBy=refundBy;
	}
	
	public String getRefundBy(){
		return (String)getData().get("refund_by");
	}	
		
		
	private Timestamp refundTime;
		public void setRefundTime(Timestamp refundTime){
		getData().put("refund_time",refundTime);
		this.refundTime=refundTime;
	}
	
	public Timestamp getRefundTime(){
		return (Timestamp)getData().get("refund_time");
	}	
		
		
	private String completeBy;
		public void setCompleteBy(String completeBy){
		getData().put("complete_by",completeBy);
		this.completeBy=completeBy;
	}
	
	public String getCompleteBy(){
		return (String)getData().get("complete_by");
	}	
		
		
	private Timestamp completeTime;
		public void setCompleteTime(Timestamp completeTime){
		getData().put("complete_time",completeTime);
		this.completeTime=completeTime;
	}
	
	public Timestamp getCompleteTime(){
		return (Timestamp)getData().get("complete_time");
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

