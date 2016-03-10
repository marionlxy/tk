package com.taikang.iu.opt.regoods.model;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.lang.Integer;
import java.lang.String;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;


/**
  * RegoodsBO 
  */
public class Regoods  extends BaseBO {
	private String refundState;
	private String balanceState;
	private String returnId;
	private String returnCode;
	private String returnState;
	private String returnReason;
	private String sellerName;
	private String sellerCode;
	private String orderAppId;
	private String subCode;
	private String orderCode;
	private String applianceId;
	private String applianceCoding;
	private String categoryId;
	private String categoryCode;
	private String categoryName;
	private String applianceName;
	private String applianceUnit;
	private Integer applianceCount;
	private BigDecimal appliancePrice;
	private BigDecimal applianceSettlePrice;
	private BigDecimal applianceMarketPrice;
	private String skuCode;
	private String skuPropertyStr;
	private String site;
	private String oddnum;
	private String logistics;
	private BigDecimal logisticsCost;
	private String applyName;
	private String applyTel;
	private Timestamp applyTime;
	private String auditBy;
	private Timestamp auditTime;
	private String sendBy;
	private Timestamp sendTime;
	private String cancelBy;
	private Timestamp cancelTime;
	private String remindBy;
	private Timestamp remindTime;
	private String takeBy;
	private Timestamp takeTime;
	private String lockBy;
	private Timestamp lockTime;
	private String checkBy;
	private Timestamp checkTime;
	private String checkResult;
	private String applyReturnBy;
	private Timestamp applyReturnTime;
	private String returnBy;
	private Timestamp returnTime;
	private String agreeBy;
	private Timestamp agreeTime;
	private String refundBy;
	private Timestamp refundTime;
	private Timestamp createdTime;
	private String createdBy;
	private Timestamp modifiedTime;
	private String modifiedBy;
	private Integer version;
	private String delflag;
	private String isreceipt;
	private String returnAddress;
	public String getRefundState() {
		return refundState;
	}
	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}
	public String getBalanceState() {
		return balanceState;
	}
	public void setBalanceState(String balanceState) {
		this.balanceState = balanceState;
	}
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnState() {
		return returnState;
	}
	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerCode() {
		return sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}
	public String getOrderAppId() {
		return orderAppId;
	}
	public void setOrderAppId(String orderAppId) {
		this.orderAppId = orderAppId;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getApplianceId() {
		return applianceId;
	}
	public void setApplianceId(String applianceId) {
		this.applianceId = applianceId;
	}
	public String getApplianceCoding() {
		return applianceCoding;
	}
	public void setApplianceCoding(String applianceCoding) {
		this.applianceCoding = applianceCoding;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getApplianceName() {
		return applianceName;
	}
	public void setApplianceName(String applianceName) {
		this.applianceName = applianceName;
	}
	public String getApplianceUnit() {
		return applianceUnit;
	}
	public void setApplianceUnit(String applianceUnit) {
		this.applianceUnit = applianceUnit;
	}
	public Integer getApplianceCount() {
		return applianceCount;
	}
	public void setApplianceCount(Integer applianceCount) {
		this.applianceCount = applianceCount;
	}
	public BigDecimal getAppliancePrice() {
		return appliancePrice;
	}
	public void setAppliancePrice(BigDecimal appliancePrice) {
		this.appliancePrice = appliancePrice;
	}
	public BigDecimal getApplianceSettlePrice() {
		return applianceSettlePrice;
	}
	public void setApplianceSettlePrice(BigDecimal applianceSettlePrice) {
		this.applianceSettlePrice = applianceSettlePrice;
	}
	public BigDecimal getApplianceMarketPrice() {
		return applianceMarketPrice;
	}
	public void setApplianceMarketPrice(BigDecimal applianceMarketPrice) {
		this.applianceMarketPrice = applianceMarketPrice;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getSkuPropertyStr() {
		return skuPropertyStr;
	}
	public void setSkuPropertyStr(String skuPropertyStr) {
		this.skuPropertyStr = skuPropertyStr;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getOddnum() {
		return oddnum;
	}
	public void setOddnum(String oddnum) {
		this.oddnum = oddnum;
	}
	public String getLogistics() {
		return logistics;
	}
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	public BigDecimal getLogisticsCost() {
		return logisticsCost;
	}
	public void setLogisticsCost(BigDecimal logisticsCost) {
		this.logisticsCost = logisticsCost;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApplyTel() {
		return applyTel;
	}
	public void setApplyTel(String applyTel) {
		this.applyTel = applyTel;
	}
	public Timestamp getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	public String getAuditBy() {
		return auditBy;
	}
	public void setAuditBy(String auditBy) {
		this.auditBy = auditBy;
	}
	public Timestamp getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Timestamp auditTime) {
		this.auditTime = auditTime;
	}
	public String getSendBy() {
		return sendBy;
	}
	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public String getCancelBy() {
		return cancelBy;
	}
	public void setCancelBy(String cancelBy) {
		this.cancelBy = cancelBy;
	}
	public Timestamp getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Timestamp cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getRemindBy() {
		return remindBy;
	}
	public void setRemindBy(String remindBy) {
		this.remindBy = remindBy;
	}
	public Timestamp getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(Timestamp remindTime) {
		this.remindTime = remindTime;
	}
	public String getTakeBy() {
		return takeBy;
	}
	public void setTakeBy(String takeBy) {
		this.takeBy = takeBy;
	}
	public Timestamp getTakeTime() {
		return takeTime;
	}
	public void setTakeTime(Timestamp takeTime) {
		this.takeTime = takeTime;
	}
	public String getLockBy() {
		return lockBy;
	}
	public void setLockBy(String lockBy) {
		this.lockBy = lockBy;
	}
	public Timestamp getLockTime() {
		return lockTime;
	}
	public void setLockTime(Timestamp lockTime) {
		this.lockTime = lockTime;
	}
	public String getCheckBy() {
		return checkBy;
	}
	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
	}
	public Timestamp getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getApplyReturnBy() {
		return applyReturnBy;
	}
	public void setApplyReturnBy(String applyReturnBy) {
		this.applyReturnBy = applyReturnBy;
	}
	public Timestamp getApplyReturnTime() {
		return applyReturnTime;
	}
	public void setApplyReturnTime(Timestamp applyReturnTime) {
		this.applyReturnTime = applyReturnTime;
	}
	public String getReturnBy() {
		return returnBy;
	}
	public void setReturnBy(String returnBy) {
		this.returnBy = returnBy;
	}
	public Timestamp getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}
	public String getAgreeBy() {
		return agreeBy;
	}
	public void setAgreeBy(String agreeBy) {
		this.agreeBy = agreeBy;
	}
	public Timestamp getAgreeTime() {
		return agreeTime;
	}
	public void setAgreeTime(Timestamp agreeTime) {
		this.agreeTime = agreeTime;
	}
	public String getRefundBy() {
		return refundBy;
	}
	public void setRefundBy(String refundBy) {
		this.refundBy = refundBy;
	}
	public Timestamp getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(Timestamp refundTime) {
		this.refundTime = refundTime;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getIsreceipt() {
		return isreceipt;
	}
	public void setIsreceipt(String isreceipt) {
		this.isreceipt = isreceipt;
	}
	public String getReturnAddress() {
		return returnAddress;
	}
	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}
	public Regoods(String refundState, String balanceState, String returnId,
			String returnCode, String returnState, String returnReason,
			String sellerName, String sellerCode, String orderAppId,
			String subCode, String orderCode, String applianceId,
			String applianceCoding, String categoryId, String categoryCode,
			String categoryName, String applianceName, String applianceUnit,
			Integer applianceCount, BigDecimal appliancePrice,
			BigDecimal applianceSettlePrice, BigDecimal applianceMarketPrice,
			String skuCode, String skuPropertyStr, String site, String oddnum,
			String logistics, BigDecimal logisticsCost, String applyName,
			String applyTel, Timestamp applyTime, String auditBy,
			Timestamp auditTime, String sendBy, Timestamp sendTime,
			String cancelBy, Timestamp cancelTime, String remindBy,
			Timestamp remindTime, String takeBy, Timestamp takeTime,
			String lockBy, Timestamp lockTime, String checkBy,
			Timestamp checkTime, String checkResult, String applyReturnBy,
			Timestamp applyReturnTime, String returnBy, Timestamp returnTime,
			String agreeBy, Timestamp agreeTime, String refundBy,
			Timestamp refundTime, Timestamp createdTime, String createdBy,
			Timestamp modifiedTime, String modifiedBy, Integer version,
			String delflag, String isreceipt, String returnAddress) {
		super();
		this.refundState = refundState;
		this.balanceState = balanceState;
		this.returnId = returnId;
		this.returnCode = returnCode;
		this.returnState = returnState;
		this.returnReason = returnReason;
		this.sellerName = sellerName;
		this.sellerCode = sellerCode;
		this.orderAppId = orderAppId;
		this.subCode = subCode;
		this.orderCode = orderCode;
		this.applianceId = applianceId;
		this.applianceCoding = applianceCoding;
		this.categoryId = categoryId;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.applianceName = applianceName;
		this.applianceUnit = applianceUnit;
		this.applianceCount = applianceCount;
		this.appliancePrice = appliancePrice;
		this.applianceSettlePrice = applianceSettlePrice;
		this.applianceMarketPrice = applianceMarketPrice;
		this.skuCode = skuCode;
		this.skuPropertyStr = skuPropertyStr;
		this.site = site;
		this.oddnum = oddnum;
		this.logistics = logistics;
		this.logisticsCost = logisticsCost;
		this.applyName = applyName;
		this.applyTel = applyTel;
		this.applyTime = applyTime;
		this.auditBy = auditBy;
		this.auditTime = auditTime;
		this.sendBy = sendBy;
		this.sendTime = sendTime;
		this.cancelBy = cancelBy;
		this.cancelTime = cancelTime;
		this.remindBy = remindBy;
		this.remindTime = remindTime;
		this.takeBy = takeBy;
		this.takeTime = takeTime;
		this.lockBy = lockBy;
		this.lockTime = lockTime;
		this.checkBy = checkBy;
		this.checkTime = checkTime;
		this.checkResult = checkResult;
		this.applyReturnBy = applyReturnBy;
		this.applyReturnTime = applyReturnTime;
		this.returnBy = returnBy;
		this.returnTime = returnTime;
		this.agreeBy = agreeBy;
		this.agreeTime = agreeTime;
		this.refundBy = refundBy;
		this.refundTime = refundTime;
		this.createdTime = createdTime;
		this.createdBy = createdBy;
		this.modifiedTime = modifiedTime;
		this.modifiedBy = modifiedBy;
		this.version = version;
		this.delflag = delflag;
		this.isreceipt = isreceipt;
		this.returnAddress = returnAddress;
	}
	public Regoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

