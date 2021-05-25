package spaceInvaders;

import java.awt.Graphics;
import java.awt.Rectangle;

//Laser class extending premade Rectangle class 
public class Laser extends Rectangle {

	// constructor takes a location and the dimensions as parameters
	public Laser(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	
	// moves x by the inputted amount
	public void moveX(int dX) {
		x += dX;
	}
	
	// moves y by the inputted amount
	public void moveY(int dY) {
		y += dY;
	}
	
	// draws the image corresponding with this alien/player
	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}