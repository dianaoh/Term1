package polymorphism;

import java.awt.Color;
import java.awt.Graphics;

public class RoundedRect extends Shape {
	private int width;
	private int height;
	public RoundedRect (int startx, int starty,int width, int height) {
		super (startx, starty);
		this.width=width;
		this.height=height;
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.cyan);
		g.fillRoundRect (getX(),getY(),width, height, 10, 10);
	}
}
