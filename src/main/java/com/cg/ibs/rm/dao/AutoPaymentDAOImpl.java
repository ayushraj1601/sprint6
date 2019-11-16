package com.cg.ibs.rm.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.ibs.rm.exception.ExceptionMessages;
import com.cg.ibs.rm.exception.IBSExceptions;
import com.cg.ibs.rm.model.AccountBean;
import com.cg.ibs.rm.model.AutoPayment;
import com.cg.ibs.rm.model.CustomerBean;
import com.cg.ibs.rm.model.ServiceProvider;
import com.cg.ibs.rm.model.ServiceProviderId;
import com.cg.ibs.rm.model.TransactionBean;
import com.cg.ibs.rm.model.TransactionMode;
import com.cg.ibs.rm.model.TransactionType;


@Repository("AutoPaymentDao")
public class AutoPaymentDAOImpl implements AutoPaymentDAO {
	
	@PersistenceContext
	EntityManager manager;
	@PersistenceContext
	EntityManager manager1;
	//private static final Logger LOGGER = Logger.getLogger(AutoPaymentDAOImpl.class);

	public AutoPaymentDAOImpl() {
		super();
	}
	
	@Override
	public Set<AutoPayment> getAutopaymentDetails(BigInteger uci) throws IBSExceptions {
		//LOGGER.info("entered getAutopaymentDetails in AutoPaymentDAOImpl");
		TypedQuery<AutoPayment> query = manager.createQuery(
				"SELECT a FROM AutoPayment a  WHERE a.serviceProviderId.uci = ?1",
				AutoPayment.class);
		query.setParameter(1, uci);
		List<AutoPayment> list = query.getResultList();
		if(!list.isEmpty()) {
		return new HashSet<>(list);
		} else {
			throw new IBSExceptions("No autopayments added.");
		}
	}

	@Override
	public boolean copyDetails(BigInteger uci, AutoPayment autoPayment) throws IBSExceptions {
		//LOGGER.info("entered copyDetails in AutoPaymentDAOImpl");
		boolean result = false;
		if (null == manager.find(AutoPayment.class, autoPayment.getServiceProviderId())) {
			CustomerBean customerBean = manager.find(CustomerBean.class, uci);
			customerBean.getAutoPayments().add(autoPayment);
			manager.persist(autoPayment);// why not customer bean
			result = true;
		} else {
			throw new IBSExceptions(ExceptionMessages.AUTOPAYMENT_ALREADY_ADDED);
		}
		return result;
	}

	@Override
	public boolean deleteDetails(BigInteger uci, BigInteger spi) throws IBSExceptions {
		boolean result = false;
		//LOGGER.info("entered deleteDetails in AutoPaymentDAOImpl");
		AutoPayment autoPayment = manager.find(AutoPayment.class, new ServiceProviderId(spi, uci));
		if (null != autoPayment) {
			manager.remove(autoPayment);
		} else {
			throw new IBSExceptions(ExceptionMessages.AUTOPAYMENT_DOESNT_EXIST);
		}
		return result;
	}

	@Override
	public Set<ServiceProvider> showServiceProviderList() {
		//LOGGER.info("entered showServiceProviderList in AutoPaymentDAOImpl");
		TypedQuery<ServiceProvider> query = manager.createQuery("SELECT a FROM ServiceProvider a",
				ServiceProvider.class);
		return new HashSet<>(query.getResultList());
	}

	@Override
	public boolean setCurrentBalance(BigDecimal currentBalance, BigInteger accountNumber) {
		//LOGGER.info("entered setCurrentBalance in AutoPaymentDAOImpl");
		boolean result = false;
		AccountBean account = manager.find(AccountBean.class, accountNumber);
		account.setBalance(currentBalance);
		if (manager.merge(account) != null) {
			result = true;
		}
		return result;
	}

	@Override
	public AccountBean getAccount(BigInteger accountNumber) throws IBSExceptions {
		AccountBean account = manager.find(AccountBean.class, accountNumber);
		if(null == account) {
			throw new IBSExceptions("Account doesn't exist");
		} else {
			return account;
		}
	}

	@Override
	public boolean setTransaction(BigInteger uci, BigInteger accountNumber, AutoPayment autoPayment) {
		TransactionBean transactionBean = new TransactionBean();
		transactionBean.setTransactionDate(LocalDateTime.now());
		transactionBean.setTransactionAmount(autoPayment.getAmount());
		transactionBean.setTransactionDescription("Auto Payment");
		transactionBean.setTransactionMode(TransactionMode.ONLINE);
		transactionBean.setTransactionType(TransactionType.DEBIT);
		CustomerBean bean = manager.find(CustomerBean.class, uci);
		transactionBean.setAccount(manager1.find(AccountBean.class, accountNumber));
		autoPayment.getTransactions().add(transactionBean);
		bean.getAutoPayments().add(autoPayment);
		manager.merge(bean);
		manager1.merge(transactionBean);
		manager1.merge(autoPayment);
		return true;
	}

	@Override
	public boolean updateDetails(AutoPayment autoPayment) throws IBSExceptions {
		boolean result = false;
		AutoPayment autoPayment2 = manager.find(AutoPayment.class, autoPayment.getServiceProviderId());
		if(null == autoPayment2) {
			throw new IBSExceptions(ExceptionMessages.AUTOPAYMENT_DOESNT_EXIST);
		} else {
			manager.merge(autoPayment);
			result = true;
		}
		return result;
	}

	@Override
	public AutoPayment getAutopayment(ServiceProviderId providerId) throws IBSExceptions {
		
		
		AutoPayment autoPayment = manager.find(AutoPayment.class, providerId);
		if(null == autoPayment) {
			throw new IBSExceptions(ExceptionMessages.AUTOPAYMENT_DOESNT_EXIST);
		}else {
			return autoPayment;	
		}
		
	}
}
		