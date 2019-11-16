package com.cg.ibs.rm.dao;

import java.math.BigInteger;
import java.util.Set;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.AccountBean;

public interface AccountDao {
	public Set<AccountBean> getAccounts(BigInteger uci) throws IBSExceptions;
}
