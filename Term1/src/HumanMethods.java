public class HumanMethods {
	private int age;
	private char gender;
	
	public void setAge (int num)
	{
		//this.age = age;
		age = num;
	}
	
	public void setGender (char l)
	{
		//this.gender = gender
		gender = l;
	}
	
	public void vote () {
		if (age>18)
		{
			System.out.println("person can vote");
		}
	}
	
	public void tetanus ()
	{
		if (age%4==0)
		{
			System.out.println("need tetanus shot");
		}
	}
	
	public void toddler () {
		if (age<4 && gender== 'g') {
			System.out.println("toddler girl");
		}
		else if (age< 4 && gender=='b') {
			System.out.println("toddler boy");
		}
		else {
			System.out.println("not toddler");
		}
	}
		
	public void discount () {
		if (age>65 || age<12)
		{
			System.out.println("discount");
		}
	}
		
	public void teen () {
		if (age>=12 && age<=18)
		{
			System.out.println("teenager");
		}
	}
	
	public void teammates (int a1, int g1) { //Challenge
		if((a1-age<-2 || a1-age<2) && g1==gender) {
			System.out.println("teammates");
		}
	}

	
	public static void main(String [] args) {
		HumanMethods a = new HumanMethods ();
		a.setAge (3);
		a.setGender('g');
		a.tetanus ();
		a.vote();
		a.toddler ();
		a.discount ();
		a.teen();
		a.teammates(1, 'g');
	}

}
