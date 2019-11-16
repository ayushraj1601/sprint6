package com.cg.ibs.rm.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Embeddable;

@Embeddable
public class ServiceProviderId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053767533517376863L;
	private BigInteger Spi;
	private BigInteger uci;

	public ServiceProviderId() {
		super();
	}

	public ServiceProviderId(BigInteger spi, BigInteger uci) {
		super();
		Spi = spi;
		this.uci = uci;
	}

	public BigInteger getSpi() {
		return Spi;
	}

	public void setSpi(BigInteger spi) {
		Spi = spi;
	}

	public BigInteger getUci() {
		return uci;
	}

	public void setUci(BigInteger uci) {
		this.uci = uci;
	}

	@Override
	public String toString() {
		return "ServiceProviderId [Spi=" + Spi + ", uci=" + uci + "]";
	}

	
}
