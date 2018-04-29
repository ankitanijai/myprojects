package com.mywallet.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywallet.bean.WalletMoneyTransferRequest;
import com.mywallet.bean.WallnetAccountMaster;
import com.mywallet.bean.WallnetTransactionManagment;
import com.mywallet.dao.WalletAccountRepository;
import com.mywallet.dao.WalletTransactionRepository;

@Service
public class WalletServiceImpl implements WallnetService{

	@Autowired
	WalletAccountRepository walletAccountRepository;
	
	@Autowired
	WalletTransactionRepository wallettransactionrepository;
	
	int minimumbalance=5000;
	
	@Override
	public WallnetAccountMaster retiveWallnetBalance(String memberId) {
		
		System.out.println("In wallet Srevice.. fetching data for memebr id :"+memberId);
		
		 
		WallnetAccountMaster wallnetAccountMaster= walletAccountRepository.findOneByMemberId(memberId);
		System.out.println("wallnetAccountMaster ::"+wallnetAccountMaster);
				return wallnetAccountMaster;
		
	}

	@Override
	public WallnetAccountMaster createNewWalletAccount(WallnetAccountMaster wallnetaccountmaster) {
		WallnetAccountMaster wallnetAccountMasters=walletAccountRepository.save(wallnetaccountmaster);
		return wallnetAccountMasters;
	}

	@Override
	public  WallnetAccountMaster updateBalance(String memberId, WallnetTransactionManagment wallnetTransactionManagment) {
		
		WallnetAccountMaster wallnetAccountMaster=walletAccountRepository.findOneByMemberId(wallnetTransactionManagment.getMemberId());
		
		if(null!=wallnetAccountMaster) {
			wallnetTransactionManagment.setCreatedOn(new Date()); // now current date is set in pojo.
			WallnetTransactionManagment persistedWallnetTransactionManagment=wallettransactionrepository.save( wallnetTransactionManagment);
			if(wallnetTransactionManagment.getTransactionType().equals("credit")) {
				wallnetAccountMaster.setBalanceAmount(wallnetAccountMaster.getBalanceAmount()+wallnetTransactionManagment.getCreditedAmount());
				walletAccountRepository.save(wallnetAccountMaster);
			}else if(wallnetTransactionManagment.getTransactionType().equals("debit")){
			
				double balanceAfterDebit=wallnetAccountMaster.getBalanceAmount()-wallnetTransactionManagment.getDebitedAmount();
				if(balanceAfterDebit>=minimumbalance) {
					wallnetAccountMaster.setBalanceAmount(balanceAfterDebit);
					walletAccountRepository.save(wallnetAccountMaster);
				}else {
					throw new Error("minimum balance should be 5000 required");
				}
				
			}else {
				throw new Error("invalid transaction type");
			}
		}
		
		return wallnetAccountMaster;
	}

	@Override
	public List<WallnetTransactionManagment> retriveTransactionDetails( String memberId) {
		WallnetAccountMaster wallnetAccountMaster=walletAccountRepository.findOneByMemberId(memberId);
		if(null!=wallnetAccountMaster) {
			List<WallnetTransactionManagment> wallnetTransactionManagment=wallettransactionrepository.findAllByMemberId(memberId);
			return wallnetTransactionManagment;
		}
		
		
		return null;
	}

	@Override
	public Boolean transferWalletMoney(WalletMoneyTransferRequest walletMoneyTransferRequest) {
		
		WallnetAccountMaster SenderAccountMaster=walletAccountRepository.findOneByMemberId(walletMoneyTransferRequest.getSenderId());
		System.out.println("SenderAccountMaster"+SenderAccountMaster);
		if(null!=SenderAccountMaster) {
			///WallnetTransactionManagment  wallnetTransactionManagment = null;
			if(walletMoneyTransferRequest.getTransactionType().equals("transfer")) {
				String	reciverId=walletMoneyTransferRequest.getSenderId();
				System.out.println("reciverId"+reciverId);
				
				WallnetAccountMaster	 reciverAccountMaster=walletAccountRepository.findOneByMemberId(walletMoneyTransferRequest.getReceiverId());
				System.out.println("reciverAccountMaster"+reciverAccountMaster);
				
				 if(null!=reciverAccountMaster) {
					
					 double balanceAfterDebit=SenderAccountMaster.getBalanceAmount()-walletMoneyTransferRequest.getAmount();
						System.out.println("balanceAfterDebit"+balanceAfterDebit);
						
						if(balanceAfterDebit>=minimumbalance) {
							SenderAccountMaster.setBalanceAmount(balanceAfterDebit);
							walletAccountRepository.save(SenderAccountMaster);
							
							
							reciverAccountMaster.setBalanceAmount(reciverAccountMaster.getBalanceAmount()+walletMoneyTransferRequest.getAmount());
							walletAccountRepository.save(reciverAccountMaster);
							
							WallnetTransactionManagment senderTransaction=new WallnetTransactionManagment();
							senderTransaction.setMemberId(SenderAccountMaster.getMemberId());
							senderTransaction.setDebitedAmount(walletMoneyTransferRequest.getAmount());
							senderTransaction.setTransactionType("debit");
							senderTransaction.setTransactionRemark("amount sent to"+reciverAccountMaster.getWalletId());
							senderTransaction.setCreatedBy("system");
							senderTransaction.setCreatedOn(new Date());
							wallettransactionrepository.save(senderTransaction);
							System.out.println("senderTransaction"+senderTransaction);
							
							WallnetTransactionManagment reciverTransaction=new WallnetTransactionManagment();
							reciverTransaction.setMemberId(reciverAccountMaster.getMemberId());
							reciverTransaction.setCreditedAmount(walletMoneyTransferRequest.getAmount());
							reciverTransaction.setTransactionType("credit");
							reciverTransaction.setTransactionRemark("amount recived from"+SenderAccountMaster.getWalletId());
							reciverTransaction.setCreatedBy("system");
							reciverTransaction.setCreatedOn(new Date());
							wallettransactionrepository.save(reciverTransaction);
							System.out.println("reciverTransaction"+reciverTransaction);
							
							return true;
							
						}
				 }
				
			}
		}
		
		return false;
	}

	@Override
	public List<WallnetTransactionManagment> retriveDetailsOfLastTransaction(Date startDate, Date endDate,	String memberId) {
		WallnetAccountMaster wallnetAccountMaster=walletAccountRepository.findOneByMemberId(memberId);
		System.out.println("wallnetAccountMaster"+wallnetAccountMaster);
		if(null!=wallnetAccountMaster) {
			List<WallnetTransactionManagment> listOfTransactions=wallettransactionrepository.findByMemberIdAndCreatedOnBetween(memberId, startDate, endDate);
			System.out.println("listOfTransactions"+listOfTransactions);
			return listOfTransactions;
		}
		return null; //sahilikha hai code  r:u)n kar
	}

//	@Override
//	public WallnetTransactionManagment createNewTransaction(WallnetTransactionManagment wallnettransactionmanagment) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	//if i enterr the member id then it will show me all the transaction details its like earlier and  now all the details.
}
