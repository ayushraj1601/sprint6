package com.cg.ibs.rm.dao;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.CustomerBean;

@Repository("CustomerDao")
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	EntityManager manager;

	public String returnName(BigInteger uci) {
		CustomerBean customerBean = manager.find(CustomerBean.class, uci);
		String lastName = customerBean.getLastname();
		if (null == lastName) {
			lastName = " ";
		}
		return customerBean.getFirstName() + " " + lastName;
	}

	public Set<BigInteger> getUciList() throws IBSExceptions {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<BigInteger> query = builder.createQuery(BigInteger.class);
		Root<CustomerBean> custRoot = query.from(CustomerBean.class);
		query.select(custRoot.<BigInteger>get("uci"));
		List<BigInteger> ucis = manager.createQuery(query).getResultList();
		if (null == ucis) {
			throw new IBSExceptions("No customers");
		} else {
			return new HashSet<>(ucis);
		}

	}

	public CustomerDAOImpl() {
		super();

	}
}
