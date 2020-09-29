public class ifStatement {
	//A method that takes as parameter an integer, and determines if it is positive. If positive, print "yes", otherwise print "no".
	//A method that takes an integer as parameter, and determines if it is even or odd. (Use one of your 5 operators to do this easily)
	//A method that takes a character as parameter, and determines if it is uppercase, lowercase, or neither. 
	//A method that takes an integer as parameter, and determines if it is a multiple of 10.
	//A method that takes three doubles as parameters, and prints out the biggest of the three (this is a maximum function).
	//Challenge (if you finish before class is over): Using only the operators we have learned so far, write a method that takes a double as input, and determines whether it is a whole number or not (2.0 is a whole number, 2.6 is not).
	
	public void positive (int n1)
	{
		if (n1>0)
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
	}
	
	public void evenOdd (int n1)
	{
		if (n1%2==0)
		{
			System.out.println("even");
		}
		else 
		{
			System.out.println("odd");
		}
	}
	
	public void upLow (char l1)
	{
		if (64<(int)l1 && (int)l1<91)
		{
			System.out.println("Uppercase");
		}
		else if (96<(int)l1 && (int)l1<123 )
		{
			System.out.println("Lowercase");
		}
		else 
		{
			System.out.println("neither");
		}
	}
	
	public void multiple10 (int n1)
	{
		if (n1%10==0)
		{
			System.out.println("Multiple of 10");
		}
		else
		{
			System.out.println("Not a multiple");
		}
	}
	
	public void maximum (double x1, double x2, double x3)
	{
		if (x1>x2 && x1>x3)
		{
			System.out.println(x1+" is the biggest");
		}
		else if (x2>x1 && x2>x3)
		{
			System.out.println(x2+" is the biggest");
		}
		else if (x3>x1 && x3>x2)
		{
			System.out.println(x3+" is the biggest");
		}
		else 
		{
			System.out.println("no maximum out of the three");
		}
	}
	
	public void integer (double n1)
	{
		if (n1%1==0) {
			System.out.println("integer");
		}
		else {
			System.out.println("not");
		}
	}
	
	public static void main (String []args ) 
	{
		ifStatement a = new ifStatement();
		a.upLow ('T');
		
		a.integer (1.5937485);
	}

}
