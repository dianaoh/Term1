package Projects;
// Angry Birds template provided by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AngryBirds extends JPanel {
	
	// the width/height of the window - feel free to change these
	private final int W_WIDTH = 900, W_HEIGHT = 600;
	
	// the number of enemies in the game - feel free to change
	private final int NUM_ENEMIES = 6;
	
	// a constant for the gravitational pull on our 'bird' - again, feel free to change
	private final double GRAVITY = .4;

	// hints...
	private int[] enemyX= {};
	private int[] enemyY= {};
	private boolean[] dead;
	
	private Image rock;
	private Image catapult;
	private Image landscape;
	private Image monster1;
	private Image monster2;
	private Image monster3;
	private Image monster4;
	private Image monster5;
	private Image monster6;

	// you'll need more instance variables - put them here.
	private int startX, startY;
	private double speedX=0, speedY=0; 
	private double birdX=43, birdY=440; 
	
	private boolean isGravityOn = false; 
	
	private final int LAUNCHERDIAM=25, ENEMYDIAM=40;
	private final int SLINGSHOT_WIDTH=80, SLINGSHOT_HEIGHT=170;
	private final int ENEMY_SIZE=40;
	
	
	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		// example of loading an image file - edit to suit your project
		try {
			rock = ImageIO.read(new File("rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//slingshot
		try {
			catapult= ImageIO.read(new File("catapult.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//landscape code
		try {
			landscape= ImageIO.read(new File("landscape3.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			monster1= ImageIO.read(new File("big-mouth-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			monster2= ImageIO.read(new File("round_monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			monster3= ImageIO.read(new File("scary-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		try {
			monster4= ImageIO.read(new File("bird-monster-pngrepo-com (1).png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		try {
			monster5= ImageIO.read(new File("three-eyed-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		try {
			monster6= ImageIO.read(new File("square-big-mouth-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		// your code here
		
		birdX += speedX; 
		birdY += speedY; 
		
		if (isGravityOn) {
			speedY+= GRAVITY;
		}
		
		//resets bird position when off the screen
		//turns gravity and speed back to zero
		if (birdX>W_WIDTH || birdY>W_HEIGHT) {
			birdX=43;
			birdY=440;
			speedX=0;
			speedY=0;
			isGravityOn=false;
		}
	}
	
	// check for any collisions between your 'bird' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
		// your code here
	}
	
	//Simple method to show the distance between two points.
	private int distance() {
		int dist=6;
		return dist;
	}
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	public void mousePressed(int mouseX, int mouseY) {
		// your code here
		startX = mouseX;
		startY = mouseY; 
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		// your code here
		
		int distDraggedX= mouseX - startX;
		int distDraggedY= mouseY - startY;
		
		speedX= -distDraggedX/10.0;
		speedY= -distDraggedY/10.0;
		
		isGravityOn= true; 
	}
	
	// draws everything in our project - the enemies, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		// draws a white background
		g.setColor(new Color (247,247,247));
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		g.drawImage(landscape,60,20,W_WIDTH,W_HEIGHT,null);
		
		// example of how to draw an image - draws at (100, 100) with width/height 40/40
		g.drawImage(rock, (int) birdX, (int)birdY, LAUNCHERDIAM, LAUNCHERDIAM, null);
		
		// your code here
		g.drawImage(catapult,10,W_HEIGHT-SLINGSHOT_HEIGHT,SLINGSHOT_WIDTH,SLINGSHOT_HEIGHT, null);
		
		g.drawImage(monster1, 320, 438, ENEMY_SIZE, ENEMY_SIZE, null);
		g.drawImage(monster2, 770,438,  ENEMY_SIZE, ENEMY_SIZE, null);
		g.drawImage(monster3, 440,245, ENEMY_SIZE, ENEMY_SIZE, null);
		g.drawImage(monster4, 459,360,  ENEMY_SIZE, ENEMY_SIZE, null);
		g.drawImage(monster5, 517,195, ENEMY_SIZE, ENEMY_SIZE, null);
		g.drawImage(monster6, 632,360,  ENEMY_SIZE, ENEMY_SIZE, null);
	}
	
	
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	public AngryBirds() {
		setup();
		
		JFrame frame = new JFrame();
		frame.setSize(W_WIDTH,W_HEIGHT);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				AngryBirds.this.mousePressed(e.getX(),e.getY());	
			}
			public void mouseReleased(MouseEvent e) {
				AngryBirds.this.mouseReleased(e.getX(),e.getY());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		run();
	}
	public static void main(String[] args) {
		new AngryBirds();
	}
}
