package com.fengmo.simulation;

import java.util.Scanner;

import com.fengmo.list.InfoCus;
import com.fengmo.obtain.SelectCus;

public class Login {
	public static long key = 0;
	
	public static void main(String[] args) {
		System.out.println("欢迎使用银行ATM系统");
		System.out.println("请输入账号：");
		
		Scanner scanner = new Scanner(System.in);
		
		SelectCus scCus = new SelectCus();
		String sql = "select 账号 accounts,密码 password from info_cus where 账号 = ?";
		long num = scanner.nextLong();
		InfoCus infocus=scCus.selectCus(InfoCus.class, sql, num);

		try {
			if(infocus.getAccounts() == num) {
				System.out.println("请输入密码：");
				Login.key = num;

				 int count = 3;   //给定初始值设为3，代表3次机会
			     while(count!=0){
			    	 int password = scanner.nextInt();
			    	 if(infocus.getPassword() == password) {
						Menu menu = new Menu();
						menu.Menu();
						menu.Operation();
			               break;
			            }else{
			                count--;
			                if(count > 0) {
				                System.out.println("======================");
				                System.out.println("密码错误请重新输入：");
			                }else {
			                	System.out.println("======================");
			                	System.out.println("登录失败！");
			                }
			            }   
			        }
			}
		} catch (Exception e) {    
			System.out.println("==================");
			System.out.println("   账号错误");
			System.out.println(" ");
			main(args);
		}		
	}
}
