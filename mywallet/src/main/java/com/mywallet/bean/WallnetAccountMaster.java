package com.mywallet.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="wallnet_account_master")
public class WallnetAccountMaster {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  //since this is auto doent ned to send id....
	@Column(name="walletId")
	private int walletId;
	
	@Column(name="memberId")
	private String memberId;
	
	@Column(name="balanceAmount")
	private double balanceAmount;
	
	@Column(name="updatedOn")
	private Date updatedOn;
	
	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="updatedBy")
	private String updatedBy;
	
	
	public WallnetAccountMaster() {
		
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String creadtedBy) {
		this.createdBy = creadtedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "WallnetAccountMaster [wallnetId=" + walletId + ", memberId=" + memberId + ", balanceAmount="
				+ balanceAmount + ", updatedOn=" + updatedOn + ", createdOn=" + createdOn + ", creadtedBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}
	
	public static int age;
}


