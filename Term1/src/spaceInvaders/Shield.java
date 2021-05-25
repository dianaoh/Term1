package spaceInvaders;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//class extending Rectangle class
public class Shield extends Rectangle {
	
	//Image instances for different stages of the shield
	private Image img1,img2,img3,img4;
	
	//Integer to keep track of damage in shield
	private int damage;
	
	// constructor takes the location, the name of the image, the dimensions 
	//and the starting damage as parameters
	public Shield(int x, int y, int w, int h, int damage) {
		super(x, y, w, h);
		
		//sets corresponding images to png
		try {
			img1 = ImageIO.read(new File("shield1.png")).getScaledInstance(w, h, Image.SCALE_SMOOTH);
			img2 = ImageIO.read(new File("shield2.png")).getScaledInstance(w, h, Image.SCALE_SMOOTH);
			img3 = ImageIO.read(new File("shield3.png")).getScaledInstance(w, h, Image.SCALE_SMOOTH);
			img4 = ImageIO.read(new File("shield4.png")).getScaledInstance(w, h, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Image file not found");
		}
		
		//sets the damage in the parameter equal to the damage of the shield
		this.damage= damage;
	}
	
	//Returns the damage to access in other classes.
	public int getDamage () {
		return damage;
	}
	
	//Increases the damage of the shield.
	public void increaseDamage () {
		damage++;
	}
	
	// draws the image corresponding with this shield
	public void draw(Graphics g) {
		//When damage is zero
		if (damage==0) {
			g.drawImage(img1, x, y, null);
		}
		//When damage is one
		else if (damage==1) {
			g.drawImage(img2, x, y, null);
		}
		//When damage is two
		else if (damage==2) {
			g.drawImage(img3, x, y, null);
		}
		//When damage is three
		else if (damage==3) {
			g.drawImage(img4, x, y, null);
		}
		//Shield is removed at damage four
	}
}
