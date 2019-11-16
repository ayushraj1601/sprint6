package com.cg.ibs.rm.service;

import java.math.BigInteger;
import java.util.Set;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.Beneficiary;
import com.cg.ibs.rm.model.CreditCard;

public interface Bank_AdminService {
	public Set<BigInteger> showRequests();

	public Set<CreditCard> showUnapprovedCreditCards();

	public Set<Beneficiary> showUnapprovedBeneficiaries();

	public boolean saveCreditCardDetails(BigInteger cardNumber) throws IBSExceptions;

	public boolean saveBeneficiaryDetails(BigInteger accountNumber) throws IBSExceptions;

	public boolean disapproveBenficiary(BigInteger accountNumber) throws IBSExceptions;

	public boolean disapproveCreditCard(BigInteger cardNumber) throws IBSExceptions;

}
