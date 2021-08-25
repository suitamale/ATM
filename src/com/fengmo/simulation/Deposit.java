package com.fengmo.simulation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

import com.fengmo.list.InfoCus;
import com.fengmo.list.InfoMon;
import com.fengmo.obtain.SelectCus;
import com.fengmo.obtain.SelectMon;

public class Deposit {
	public void deposit() {
		BigDecimal zero = new BigDecimal(0);
		BigDecimal one = new BigDecimal(1);
		BigDecimal bal = new BigDecimal(100);
		
		System.out.println("请输入存款金额：");
		//查询原数据
		SelectCus seCus = new SelectCus();
		String sql1 = "select 账号 accounts,余额 balance,年利率 apr from info_mon where 账号 = ?";
		String sql2 = "select 姓名 name,账号 accounts from info_cus where 账号 = ?";
		InfoMon infomon = seCus.selectCus(InfoMon.class, sql1,Login.key);
		InfoCus infocus = seCus.selectCus(InfoCus.class, sql2,Login.key);

		//获取输入
		Scanner scanner = new Scanner(System.in);
		BigDecimal money = scanner.nextBigDecimal();
		
		BigDecimal[] res = money.divideAndRemainder(bal);
	    BigDecimal Quotient = res[0];//商
	    BigDecimal remainderres = res[1];//余数
	    
	    if(Quotient.compareTo(zero) == 1 && remainderres.compareTo(zero) == 0) {
			System.out.println("========存款=========");
			System.out.println("您的卡号："+infocus.getAccounts());
			System.out.println("您的姓名："+infocus.getName());
			
			//更新数据
			SelectMon seMon = new SelectMon();
			BigDecimal originbalance = infomon.getBalance();
			System.out.println("原有余额："+originbalance);
			System.out.println("现存入："+money);
			
			BigDecimal existingbalance = infomon.getBalance().add(money);
			String sql = "update info_mon set 余额=? where 账号=?";
			seMon.selectMon(sql,existingbalance,Login.key);
	
			InfoMon infomon2 = seCus.selectCus(InfoMon.class, sql1,Login.key);
			System.out.println("最终余额："+existingbalance);
			
			Date date = new Date();
			System.out.println("存款日期："+date);
	    }else {
	    	System.out.println("请输入100的整数倍。");
	    }
	}
}
