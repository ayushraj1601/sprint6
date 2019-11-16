package com.cg.ibs.rm.service;

import java.math.BigInteger;
import java.util.Set;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.AccountBean;

public interface AccountService {
	
	public Set<AccountBean> getAccountsOfUci(BigInteger uci) throws IBSExceptions;
}
