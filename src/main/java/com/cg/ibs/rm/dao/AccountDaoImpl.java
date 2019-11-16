package com.cg.ibs.rm.dao;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.AccountBean;

@Repository("AccountDao")
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext
	private EntityManager manager;
	
	public Set<AccountBean> getAccounts(BigInteger uci) throws IBSExceptions {
		TypedQuery<AccountBean> query = manager
				.createQuery("select a FROM AccountBean a INNER JOIN a.accountHoldings h INNER JOIN h.customer c WHERE c.uci=?1", AccountBean.class);
		query.setParameter(1, uci);
		List<AccountBean> beans = query.getResultList();
		if(!beans.isEmpty()) {
			return new HashSet<>(beans);
		}else {
			throw new IBSExceptions("No accounts available");
		}
		
	}

	public AccountDaoImpl() {
		super();
	}
}
