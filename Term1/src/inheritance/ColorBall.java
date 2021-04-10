package inheritance;

import java.awt.Color;

public class ColorBall extends BouncingBall {
	private int count;
	
	public ColorBall (int startx, int starty, int startrad, int startxspeed, int startyspeed) {
		super (startx, starty, startrad, startxspeed, startyspeed, null);
		count=0;
	}
	
	public void move() {
		super.move();
		if (count%20==0) {
			setColor (new Color ((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		}
		count++;
	}
}
