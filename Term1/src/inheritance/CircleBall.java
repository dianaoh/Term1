package inheritance;

import java.awt.Color;

public class CircleBall extends Ball{
	public CircleBall (int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super (startx, starty, startrad, startxspeed, startyspeed, startcolor);
		
	}
	
	public void move () {
		super.move();
		setY ((int)(Math.sqrt(30-getX()*getX())));
	}
}
