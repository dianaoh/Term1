package objects;

public class Car {
	private String name;
	private int year;
	private int mileage;
	
	public Car (String n, int y, int m) {
		name=n;
		year=y;
		mileage=m;
	}
	
	public void drive (int distance) {
		mileage+=distance;
	}
	
	public int worth (int currentYear) {
		return 10000-year-mileage;
	}
	
	public int getMileage() {
		return mileage;
	}
}
