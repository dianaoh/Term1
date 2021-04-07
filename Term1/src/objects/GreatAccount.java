package objects;

public class GreatAccount extends BankAccountClass {
	int countMonth;
	int countYear;
	public GreatAccount (int balance,String name, int countMonth, int countYear) {
		super (balance, name);
		countMonth=0;
		countYear=0;
	}
	
	public void monthWithdraw (int n) {
		countMonth++;
		countYear++;
		if (countMonth<=3) {
			super.withdraw(n);
		}
	}
	
	public void nextMonth () {
		countMonth=0;
	}
	
	public void reward () {
		if (countYear==0) {
			setBalance (getBalance ()*2);
		}
	}
	
}
