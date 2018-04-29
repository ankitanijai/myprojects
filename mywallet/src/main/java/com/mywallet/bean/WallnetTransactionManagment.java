package com.mywallet.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallet_transaction_master")

public class WallnetTransactionManagment {

	//Date date=new Date();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="transactionId")
	private int transactionId;
	
	@Column(name="memberId")
	private String memberId;
	
	@Column(name="creditedAmount")
	private double creditedAmount;
	
	@Column(name="debitedAmount")
	private double debitedAmount;
	
	@Column(name="transactionRemark")
	private String transactionRemark;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="transactionType")
	private String transactionType;
	
//	private String creditedTo;
//	private String debitedTo;
	
	 
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Wallnet_transaction_managment [transactionId=" + transactionId + ", memberId=" + memberId
				+ ", creditedAmount=" + creditedAmount + ", debitedAmount=" + debitedAmount + ", transactionRmark="
				+ transactionRemark + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ",transactionType="+transactionType+"]";
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public double getCreditedAmount() {
		return creditedAmount;
	}
	public void setCreditedAmount(double creditedAmount) {
		this.creditedAmount = creditedAmount;
	}
	public double getDebitedAmount() {
		return debitedAmount;
	}
	public void setDebitedAmount(double debitedAmount) {
		this.debitedAmount = debitedAmount;
	}
	public String getTransactionRemark() {
		return transactionRemark;
	}
	public void setTransactionRemark(String transactionRmark) {
		this.transactionRemark = transactionRmark;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
}
