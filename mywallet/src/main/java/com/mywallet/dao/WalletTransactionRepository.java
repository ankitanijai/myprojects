package com.mywallet.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mywallet.bean.WallnetTransactionManagment;

public interface WalletTransactionRepository extends CrudRepository<WallnetTransactionManagment, Integer>{

	List<WallnetTransactionManagment>findAllByMemberId(String memberId);
	List<WallnetTransactionManagment>findByMemberIdAndCreatedOnBetween(String memberId,Date startDate,Date endDate);
 } //date is createdOn wala you have used createdBy now run gaian

