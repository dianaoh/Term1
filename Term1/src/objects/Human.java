package objects;

public class Human {	
	private String name;
	private int age;
	private int height;
	private boolean female;
	
	public Human(String name,int a,int h,boolean female){
		this.name= name;
		age = a;
		height=h;
		this.female = female;
	}
	
	public int getAge () {
		return age;
	}
	
	public void display () {
		System.out.println(age);
		System.out.println(height);
		if (female==true) {
			System.out.println("female");
		}
		else {
			System.out.println("male");
		}
	}
	
	public void getOlder() {
		age+=1;
	}
	
	public void changeName (String name) {
		this.name= name;
	}
	
	public void canVote (int year) {
		if (year%4==0 && age>=18) {
			System.out.println("Can Vote");
		}
		else {
			System.out.println("Cannot Vote");
		}
	}
	
	public static void main (String []args) {
		Human a = new Human ("Mark",18,180,false);
		a.getOlder();
		a.changeName("Bob");
		a.canVote(2020);
		System.out.println(a.age+" "+a.name+" "+a.height+" "+a.female);
	}
	
}

