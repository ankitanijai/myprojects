package com.mywallet.bean;

import java.io.Serializable;


public class WalletMoneyTransferRequest implements Serializable{
	
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	private String senderId;
	private String receiverId;
	private Double amount;
	private String remark;
	private String transactionType;
	@Override
	public String toString() {
		return "WalletMoneyTransferRequest [senderId=" + senderId + ", receiverId=" + receiverId + ", amount=" + amount
				+ ", remark=" + remark + ", transactionType=" + transactionType + "]";
	}
	

}
