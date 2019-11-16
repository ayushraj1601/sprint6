package com.cg.ibs.rm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Autopayment_table")
public class AutoPayment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4643315123018156703L;
	@EmbeddedId
	private ServiceProviderId serviceProviderId;
	private BigDecimal amount;
	private String dateOfStart;
	private String dateOfEnd;
	private String serviceName;
	
	@OneToMany(cascade = CascadeType.ALL)	
	private Set<TransactionBean> transactions = new HashSet<>();

	public AutoPayment() {
		super();
	}

	public AutoPayment(ServiceProviderId serviceProviderId, BigDecimal amount, String dateOfStart) {
		super();
		this.serviceProviderId = serviceProviderId;
		this.amount = amount;
		this.dateOfStart = dateOfStart;
	}

	public AutoPayment(ServiceProviderId serviceProviderId, BigDecimal amount, String dateOfStart, String dateOfEnd,
			Set<TransactionBean> transactions) {
		super();
		this.serviceProviderId = serviceProviderId;
		this.amount = amount;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.transactions = transactions;
	}
 
	@Override
	public String toString() {
		return "AutoPayment [serviceProviderId=" + serviceProviderId + ", amount=" + amount + ", dateOfStart="
				+ dateOfStart + ", dateOfEnd=" + dateOfEnd + ", transactions=" + transactions + "]";
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDateOfEnd() {
		return dateOfEnd;
	}

	public void setDateOfEnd(String dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}

	public Set<TransactionBean> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionBean> transactions) {
		this.transactions = transactions;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(String dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public ServiceProviderId getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(ServiceProviderId serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

}
