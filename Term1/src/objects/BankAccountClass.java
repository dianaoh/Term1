package objects;

import java.util.Scanner;

public class BankAccountClass {
	private int balance;
	private String name;
	
	public BankAccountClass(String name){
		balance=0;
		this.name = name;
	}
	
	public BankAccountClass (int balance,String name) {
		this.balance=balance;
		this.name=name;
	}
	
	public void deposit(int n) {
		balance+= n;
	}
	
	public void withdraw (int n) {
		balance-=n;
	}
	
	public int getBalance () {
		return balance;
	}
	
	public void setBalance (int balance) {
		this.balance= balance;
	}
	
	public void display() {
		System.out.println(name+"has $"+balance+" in their bank account");
	}
	
//	public int position(String []arr,String name) {
//		for (int i=0;i<arr.length;i++) {
//			if (arr[i].equals(name)) {
//				return i;
//			}
//		}
//		return -1;
//	}
//	
//	public void askUser (String str) {
//		Scanner scan = new Scanner (System.in);
//		if (str.equals("deposit")) {
//			money=scan.nextInt();
//			deposit (money);
//		}
//		else if(str.equals("withdraw")){
//			money=scan.nextInt();
//			withdraw (money);
//		}
//		
//		else if (str.equals ("display")) {
//			display ();
//		}
//	}
	
//	public static void main(String[] args) {
		
//		BankAccountClass a= new BankAccountClass (200);
//		int accounts[]= {0,100,200,0,-100};
//		String name[]= {"Diana","Bob","Micheal","Mark"};
//		Scanner scan = new Scanner (System.in);
//		System.out.println("Hello. Welcome to your Bank Account");
//		System.out.println("Enter your first name");
//		String answer=  scan.nextLine ();
//		
//		while (a.position(name, answer)==-1) {
//			System.out.println("Not valid name. Enter again");
//			answer= scan.nextLine ();
//		}
//		money= accounts [a.position(name, answer)];
//		
//		
//		System.out.println("Enter your interest rate");
//		double i= scan.nextDouble ();
//		a.addInterest(i);
//		
//		System.out.println("Enter deposit, withdraw or display");
//		String str= scan.nextLine ();
//		while (!str.equals("exit")) {
//			a.askUser (str);
//		}
		
		

}
