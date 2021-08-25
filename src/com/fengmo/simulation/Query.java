package com.fengmo.simulation;

import java.math.BigDecimal;
import java.util.Date;

import com.fengmo.list.InfoCus;
import com.fengmo.list.InfoMon;
import com.fengmo.obtain.SelectCus;
import com.fengmo.obtain.SelectMon;

public class Query {
	public void query() {

		//查询原数据
		SelectCus seCus = new SelectCus();
		String sql1 = "select 账号 accounts,余额 balance,年利率 apr from info_mon where 账号 = ?";
		String sql2 = "select 姓名 name,账号 accounts from info_cus where 账号 = ?";
		InfoMon infomon = seCus.selectCus(InfoMon.class, sql1,Login.key);
		InfoCus infocus = seCus.selectCus(InfoCus.class, sql2,Login.key);
		
		System.out.println("========查询========");
		System.out.println("您的卡号："+infocus.getAccounts());
		System.out.println("您的姓名："+infocus.getName());
		
		//更新数据
		SelectMon seMon = new SelectMon();
		BigDecimal originbalance = infomon.getBalance();
		System.out.println("现有余额："+originbalance);
		Date date = new Date();
		System.out.println("取款日期："+date);	
		}

}
