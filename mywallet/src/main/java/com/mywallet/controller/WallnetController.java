package com.mywallet.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywallet.bean.WalletMoneyTransferRequest;
import com.mywallet.bean.WallnetAccountMaster;
import com.mywallet.bean.WallnetTransactionManagment;
import com.mywallet.service.WallnetService;

@RestController
public class WallnetController {
	
	
	@Autowired
	WallnetService wallnetservice;
	
	@GetMapping(path="/api/wallet")
	public WallnetAccountMaster retiveWallnetBalance(@RequestParam("memberId")String memberId ) {
		String string = "animals";
		
		System.out.println("In controller........"+string.substring(string.charAt(3) ));
		WallnetAccountMaster wallnetaccountmaster=wallnetservice.retiveWallnetBalance(memberId);
		return wallnetaccountmaster;
		
	}
	
	@PostMapping("/api/wallet") //@RequestBody is rewquired to ampp object to request
	public WallnetAccountMaster createNewWalletAccount(@RequestBody WallnetAccountMaster wallnetaccountmaster) {
		
		System.out.println("wallnetaccountmaster :"+wallnetaccountmaster);
		WallnetAccountMaster wallnetaccountmasters=wallnetservice.createNewWalletAccount(wallnetaccountmaster);
		
		return wallnetaccountmasters;
		
	}
	
	@PutMapping("/api/wallet/{memberId}")
	public WallnetAccountMaster updateBalance(@PathVariable("memberId")String memberId,@RequestBody WallnetTransactionManagment wallnetTransactionManagment) {
	
		System.out.println("memberId="+memberId);
		System.out.println("wallnetTransactionManagment="+wallnetTransactionManagment);
		WallnetAccountMaster wallnetAccountMaster=wallnetservice.updateBalance(memberId, wallnetTransactionManagment);
		
		return wallnetAccountMaster;
	}
	
	@GetMapping("/api/wallet/{memberId}/transaction")
	public  List<WallnetTransactionManagment> retriveDetailsForTransaction(@PathVariable("memberId")String  memberId) {
		
		List<WallnetTransactionManagment> wallnetTransactionManagmentList=wallnetservice.retriveTransactionDetails(memberId);
		return wallnetTransactionManagmentList;//list
	}
	
	@PostMapping("/api/wallet/transfer")
	public Boolean  transferWalletMoney(@RequestBody WalletMoneyTransferRequest walletMoneyTransferRequest) {
	Boolean moneyTransfer=	wallnetservice.transferWalletMoney(walletMoneyTransferRequest);
		System.out.println("moneyTransfer="+moneyTransfer);
		
		return moneyTransfer;
		
	}
	
	@GetMapping("/api/wallet/{memberId}/transactions")
	public List<WallnetTransactionManagment> retriveDetailsOfLastTransaction(@DateTimeFormat (pattern="yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,@PathVariable("memberId")String memberId){
	List<WallnetTransactionManagment> returingTransactionsList=wallnetservice.retriveDetailsOfLastTransaction(startDate, endDate, memberId);
	System.out.println("returingTransactionsList"+returingTransactionsList);//yyyy-MM-dd this i sdate format us mein bhi err
		return returingTransactionsList;
	}
	
	
//	@PostMapping("/api/wallet/{memberId}/transaction")
//	public WallnetTransactionManagment createNewTransaction(WallnetTransactionManagment wallnettransactionmanagment) {
//		return wallnettransactionmanagment;
//	}

}


