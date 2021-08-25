package com.fengmo.simulation;

import java.util.Scanner;

public class Menu {
	private static int number;
	public void Menu() {

		System.out.println("欢迎使用银行ATM系统");
		
		System.out.println("    1.存   款");
		System.out.println("    2.取   款");
		System.out.println("    3.购物付款");
		System.out.println("    4.查   询");
		System.out.println("    5.退   出");
		
		System.out.println("请输入数字[1-5]:");
				
	}
	public void test() {
		System.out.println("===================");
		System.out.println("               ");
		System.out.println("请选择使用的功能");
		
		System.out.println("1.存款   2.取款   3.购物付款   4.查询   5.退出");
		
		System.out.println("请输入数字[1-5]:");
	}
	public void Operation() {
		do {
			Scanner scanner = new Scanner(System.in);
			number = scanner.nextInt();
			
			if(number>0 && number<6) {
				Menu me = new Menu();
				switch(number){
				case 1:
					Deposit dept = new Deposit();
					dept.deposit();
					me.test();
					break;
				case 2:
					Withdrawal wit = new Withdrawal();
					wit.withrawal();
					me.test();
					break;
				case 3:
					Shopping shop = new Shopping();
					shop.shopping();
					me.test();
					break;
				case 4:
					Query que = new Query();
					que.query();
					me.test();
					break;
				case 5:
					System.out.println("谢谢您的使用!");
				}
			}else {
				System.out.println("输入异常请输入数字[1-5]:");
			}
		}while(number != 5);
	}
}	

