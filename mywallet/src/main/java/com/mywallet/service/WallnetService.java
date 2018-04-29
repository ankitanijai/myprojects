package com.mywallet.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.mywallet.bean.WalletMoneyTransferRequest;
import com.mywallet.bean.WallnetAccountMaster;
import com.mywallet.bean.WallnetTransactionManagment;

public interface WallnetService {

	public WallnetAccountMaster retiveWallnetBalance(String memberId ) ;
	
	public WallnetAccountMaster createNewWalletAccount(WallnetAccountMaster wallnetaccountmaster) ;
	
	public WallnetAccountMaster updateBalance(String memberId ,WallnetTransactionManagment wallnetTransactionManagment);
	
	public List<WallnetTransactionManagment> retriveTransactionDetails(String memberId);
	
	public Boolean transferWalletMoney(WalletMoneyTransferRequest walletMoneyTransferRequest);
	
	public List<WallnetTransactionManagment> retriveDetailsOfLastTransaction(@RequestParam("startDate") Date startDate,@RequestParam("endDate")Date endDate,@PathVariable("memberID")String memberID);
	
}
