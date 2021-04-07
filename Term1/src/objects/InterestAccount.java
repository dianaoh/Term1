package objects;

public class InterestAccount extends BankAccountClass{
	private int interest;
	
	public InterestAccount (int balance, String name, int interest) {
		super(balance, name);
		this.interest= interest;
	}
	
	public void addInterest () {
		setBalance (getBalance()+getBalance()*interest/100);
	}
	
}
