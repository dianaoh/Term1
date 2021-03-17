package objects;

import java.util.Scanner;

public class BankAccountClass {
	private int money;
	private double interest;
	
	private BankAccountClass(int money){
		this.money= money;
	}
	
	public void deposit(int n) {
		money+= n;
	}
	
	public void withdraw (int n) {
		money-=n;
	}
	
	public void addInterest (double interest) {
		this.interest= interest;
		money*=(interest+1);
	}
	
	public void display() {
		System.out.println("you have $"+money+" in your bank account");
	}
	
	public int position(String []arr,String name) {
		for (int i=0;i<arr.length;i++) {
			if (arr[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void askUser (String str) {
		Scanner scan = new Scanner (System.in);
		if (str.equals("deposit")) {
			money=scan.nextInt();
			deposit (money);
		}
		else if(str.equals("withdraw")){
			money=scan.nextInt();
			withdraw (money);
		}
		
		else if (str.equals ("display")) {
			display ();
		}
	}
	
	public static void main(String[] args) {
		
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

}
