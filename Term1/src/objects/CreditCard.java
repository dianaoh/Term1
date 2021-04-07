package objects;

public class CreditCard extends InterestAccount {
	public CreditCard (int balance,String name, int interest) {
		super (balance, name, interest);
	}
	
	public void withdraw (int n) {
		if (getBalance () <100) {
			System.out.println("Cannot withdraw");
		}
		else {
			super.withdraw(n);
		}
	}
	
	public void addInterest () {
		super.addInterest();
		setBalance (getBalance()-10);
	}
}
