package objects;

public class Garage {
	private Car [] c;
	
	public Garage (int n) {
		c = new Car [n];
	}
	
	public void addCar (int i,String name,int year, int mileage) {
		c [i]= new Car (name, year, mileage);
	}
	
	public int totalWorth (){
		int total=0;
		for (Car car:c) {
			if (car!= null) {
				total+=car.worth(2021);
			}
		}
		return total;
	}
	
	public double avgMileage () {
		int avg=0;
		int count=0;
		for (Car car:c) {
			if (car!=null) {
				avg+=car.getMileage ();
				count++;
			}
		}
		return avg/count;
	}
	
	public static void main (String []args) {
		Garage g = new Garage (19);
		g.addCar(2, "Sonata", 2018, 2);
		g.addCar(3, "Mercedez", 170,4);
		System.out.println(g.totalWorth()+" "+g.avgMileage());
	}
}
