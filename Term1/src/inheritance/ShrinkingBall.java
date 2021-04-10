package inheritance;

import java.awt.Color;

public class ShrinkingBall extends BouncingBall{
	private int count;
	public ShrinkingBall (int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super (startx, starty, startrad, startxspeed, startyspeed, startcolor);
		count=0;
	}
	public void move () {
		super.move();
		if ((getX()+getRad ()>=WIDTH || getX()<=0)&& getRad ()>=3) {
			setRad (getRad ()-1);
		}
		
		
		if ((getY ()+getRad ()>=HEIGHT|| getY()<=0)&& getRad()>=3) {
			setRad (getRad ()-1);
		}
	}
}
