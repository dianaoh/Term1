package spaceInvaders;

// SpaceThing class for SpaceInvaders by Mr. David
// no need to edit this class

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Class extends premade Rectangle Class
public class SpaceThing extends Rectangle {
	
	//Instance for image used in Spacething
	private Image img;
	
	//Boolean to keep track if the SpaceThing is a ghost alien or not
	private boolean ghost;
	
	// constructor takes a location, the dimensions, the name of the image file and
	//a boolean to keep track of the ghost as parameters.
	public SpaceThing(int x, int y, int w, int h, String imgName, boolean ghost) {
		super(x, y, w, h);
		
		//Image to be used for the SpaceThing
		try {
			img = ImageIO.read(new File(imgName)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Image file not found");
		}
		this.ghost= ghost;
	}
	
	// moves x by the inputted amount
	public void moveX(int dX) {
		x += dX;
	}
	
	// moves y by the inputted amount
	public void moveY(int dY) {
		y += dY;
	}
	
	//Returns boolean saying if it is a ghost or not
	public boolean getGhost () {
		return ghost;
	}
	
	// draws the image corresponding with this alien/player
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}