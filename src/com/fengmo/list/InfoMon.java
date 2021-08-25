package com.fengmo.list;

import java.math.BigDecimal;

public class InfoMon {
	private long accounts;
	private BigDecimal balance;
	private BigDecimal apr;
	
	public InfoMon() { super(); }

	public InfoMon(long accounts, BigDecimal balance, BigDecimal apr) {
		super();
		this.accounts = accounts;
		this.balance = balance;
		this.apr = apr;
	}
	
	public long getAccounts() {
		return accounts;
	}

	public void setAccounts(long accounts) {
		this.accounts = accounts;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getApr() {
		return apr;
	}

	public void setApr(BigDecimal apr) {
		this.apr = apr;
	}

	@Override
	public String toString() {
		return "infomon [accounts=" + accounts + ", balance=" + balance + ", apr=" + apr + "]";
	}

}
