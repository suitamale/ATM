package com.fengmo.list;

public class InfoCus {
	private String name;
	private Long accounts;
	private String id;
	private int password;
	
	public InfoCus() { super(); }

	public void InfoCus(String name,Long accounts,String id,int password) {
		this.accounts = accounts;
		this.name =name;
		this.id = id;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getAccounts() {
		return accounts;
	}
	public void setAccounts(Long accounts) {
		this.accounts = accounts;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "infocus [name=" + name + ", accounts=" + accounts + ", id=" + id + ", password=" + password + "]";
	}
}
