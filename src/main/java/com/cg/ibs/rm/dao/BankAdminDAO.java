package com.cg.ibs.rm.dao;

import java.math.BigInteger;
import java.util.Set;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.Beneficiary;
import com.cg.ibs.rm.model.CreditCard;

public interface BankAdminDAO {
	public Set<BigInteger> getRequests();

	public Set<CreditCard> getCreditCardDetails();

	public Set<Beneficiary> getBeneficiaryDetails();

	public boolean checkedCreditCardDetails(BigInteger cardNumber) throws IBSExceptions;

	public boolean checkedBeneficiaryDetails(BigInteger accountNumber) throws IBSExceptions;
	
	public boolean decliningCreditCardDetails(BigInteger cardNumber) throws IBSExceptions;
	
	public boolean decliningBeneficiaryDetails(BigInteger accountNumber) throws IBSExceptions;
}
