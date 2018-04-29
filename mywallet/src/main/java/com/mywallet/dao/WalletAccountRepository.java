package com.mywallet.dao;

import org.springframework.data.repository.CrudRepository;

import com.mywallet.bean.WallnetAccountMaster;



public interface WalletAccountRepository extends CrudRepository<WallnetAccountMaster, Integer> {

	WallnetAccountMaster findOneByMemberId(String memberId);
	WallnetAccountMaster findOneByMemberIdOrWalletId(String memberId,Integer wallnetId);
	
	
	WallnetAccountMaster save(WallnetAccountMaster wallnetAccountMaster);
}
