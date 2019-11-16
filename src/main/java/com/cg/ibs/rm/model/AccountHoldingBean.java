package com.cg.ibs.rm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AccountHoldingBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8657885082899327732L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aHId;
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerBean customer;
	@ManyToOne(fetch = FetchType.LAZY)
	private AccountBean account;

	public AccountHoldingBean() {
		super();
	}

	public Long getaHId() {
		return aHId;
	}

	public void setaHId(Long aHId) {
		this.aHId = aHId;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}
	
}