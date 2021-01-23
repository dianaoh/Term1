
package Projects;
// Angry Birds template provided by Mr. David
// Help with increasing score with Mr. Friedman
// https://stackoverflow.com/questions/14160374/how-to-insert-an-animated-gif-in-java (for crow gif)

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class AngryBirds extends JPanel{
	
	// the width/height of the window
	private final int W_WIDTH = 900, W_HEIGHT = 600;
	
	// the number of enemies in the game
	private final int NUM_ENEMIES = 7;
	
	// a constant for the gravitational pull on our 'bird'
	private final double GRAVITY1 = .4;
	private final double GRAVITY2 = 8;

	//Arrays:
	//Positions of enemies
	private int[] enemyX= {235,780,370,469,527,642,860};
	private int[] enemyY= {468,438,245,360,195,360,50};
	private int[] poisonX= {241,786,376,475,534,647};
	private int[] poisonY= {-600,-300,-800,-100,-400,-700};
	private int[] poisonSpeed= new int [poisonX.length];
	
	private int[] enemySize= {40,40,40,40,40,40,40};
	
	//Dead or not
	private boolean[] dead = {false,false,false,false,false,false,false};

	
	//Images of Rock, slingshot, and enemies
	private Image rock;
	private Image slingshot;
	private Image landscape;
	private Image monster1;
	private Image monster2;
	private Image monster3;
	private Image monster4;
	private Image monster5;
	private Image monster6;
	private Image crow2;
	private Image potion;

	//Starting positions and speeds of rock
	private int startX, startY;
	private double speedX=0, speedY=0; 
	private double rockX=73, rockY=440; 
	private double crowSpeed=5.5;
	
	//Score of player
	private int score=0;
	
	
	//Number of tries used
	private int triesLeft=20;
	private int deadcount=0;
	
	//Gravitational pull boolean
	private boolean isGravityOn = false; 
	
	private boolean gameOver=false;
	private boolean gameWin=false;
	
	//Sizes of rock and Enemy
	private final int ROCKDIAM=25, ENEMYDIAM=40;
	private final int ENEMY_SIZE=40;
	private final int POTION_HEIGHT=27, POTION_WIDTH=15;
	
	
	//Slingshot Width and Height
	private final int SLINGSHOT_WIDTH=80, SLINGSHOT_HEIGHT=170;
	
	
	
	
	
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
			slingshot= ImageIO.read(new File("catapult.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//landscape code
		try {
			landscape= ImageIO.read(new File("landscape3.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Monsters Image reading
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
		
		try {
			crow2= ImageIO.read(new File ("crow2.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			potion= ImageIO.read(new File ("Potion.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveRock() {
		if (gameOver==false && gameWin==false) {
			rockX += speedX; 
			rockY += speedY; 
			
			if (isGravityOn) {
				speedY+= GRAVITY1;
			}
			
			//resets bird position when off the screen
			//turns gravity and speed back to zero
			if (rockX>W_WIDTH || rockY>W_HEIGHT) {
				rockX=73;
				rockY=440;
				speedX=0;
				speedY=0;
				isGravityOn=false;
				triesLeft--;
			}
			
		}
	}
	//Moves the 'Crow' and makes it fly, also checks when it reaches the wall
	public void moveCrow() {
		if (gameOver==false && gameWin==false) {
			enemyX[6]-=crowSpeed;
			
			if (enemyX[6]+ENEMYDIAM<0) {
				enemyX[6]=W_WIDTH+ENEMYDIAM*4;
			}
		}
	}
	
	public void dropPotion() {
		if (gameOver==false && gameWin==false) {
			for (int i=0;i<poisonY.length;i++) {
				poisonSpeed[i]=(int)(Math.random ()+1);
			}
			for (int i=0;i<poisonY.length;i++) {
				poisonY[i]+=poisonSpeed[i];
				if (poisonY[i]>W_HEIGHT) {
					poisonY[i]=-400;
					poisonSpeed[i]=(int)(Math.random ()+1);
				}
			}
		}
	}
	
	// check for any collisions between your 'bird' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
		if (gameOver==false && gameWin==false) {
			//finding out if there is a collision or not
			for (int i=0;i<enemyX.length;i++) {
				if (distance(enemyX[i],enemyY[i],rockX,rockY)<=enemySize[i]/2+ROCKDIAM/2 && dead[i]==false) {
					dead[i]=true;
					deadcount++;
					
					if (i==6) {
						score+=5;
					}
					else score+=1;
				}
			}
			
			for (int i=0;i<poisonX.length;i++) {
				if (poisonY[i]==enemyY[i]){
					enemySize[i]/=2;
				}
			}
		
			//dropping monsters if they are dead
			for (int i=0;i<dead.length;i++) {
				if (dead[i]==true) {
					enemyY[i]+=GRAVITY2;
				}
			}
		}
		
		
	}
	
	//Simple method to show the distance between two points.
	private int distance(int x1, int y1, double x2, double y2) {
		int dist=(int) Math.sqrt ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return dist;
	}
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	public void mousePressed(int mouseX, int mouseY) {
		if (gameOver==false && gameWin==false) {
			startX = mouseX;
			startY = mouseY; 
		}
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		if (gameOver==false && gameWin==false) {
			//distance between starting point and after point
			int distDraggedX= mouseX - startX;
			int distDraggedY= mouseY - startY;
			
			//speeds of X and Y values
			speedX= -distDraggedX/10.0;
			speedY= -distDraggedY/10.0;
			
			//Gravity turns on
			isGravityOn= true; 

		}
	}
	public void gameOverWin () {
		if (triesLeft==0 && deadcount<7) {
			gameOver=true;
		}
		if (triesLeft>0 && deadcount>6) {
			gameWin=true;
		}
	}
	
	// draws everything in our project - the enemies, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		
		// draws a white background
		g.setColor(new Color (247,247,247));
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		g.drawImage(landscape,70,20,W_WIDTH,W_HEIGHT,null);
		
		//displays score on screen
		Font a= new Font ("Arial",Font.BOLD,10);
		g.setFont(a);
		g.setColor(Color.black);
		g.drawString("score: "+score, W_WIDTH/6, 20);
		g.drawString("tries left: "+(triesLeft), W_WIDTH*4/6, 20);
		
		// draws image of rock
		g.drawImage(rock, (int) rockX, (int)rockY, ROCKDIAM, ROCKDIAM, null);
		
		// draws image of slingshot
		g.drawImage(slingshot,40,W_HEIGHT-SLINGSHOT_HEIGHT,SLINGSHOT_WIDTH,SLINGSHOT_HEIGHT, null);
		
		//draws image of enemies.
		g.drawImage(monster1, enemyX[0],enemyY[0], enemySize[0],enemySize[0], null);
		g.drawImage(monster2, enemyX[1],enemyY[1], enemySize[1],enemySize[1], null);
		g.drawImage(monster3, enemyX[2],enemyY[2], enemySize[2],enemySize[2], null);
		g.drawImage(monster4, enemyX[3],enemyY[3], enemySize[3],enemySize[3], null);
		g.drawImage(monster5, enemyX[4],enemyY[4], enemySize[4],enemySize[4], null);
		g.drawImage(monster6, enemyX[5],enemyY[5], enemySize[5],enemySize[5], null);
		g.drawImage(crow2, enemyX[6], enemyY[6],ENEMY_SIZE, ENEMY_SIZE, null);
		
		
		for (int i=0;i<poisonX.length;i++) {
			g.drawImage(potion,poisonX[i], poisonY[i], POTION_WIDTH, POTION_HEIGHT, null);
		}

		Font b= new Font ("Arial",Font.BOLD,60);
		g.setFont(b);
		g.setColor(Color.black);
		if (gameOver==true) {
			g.drawString("GAME OVER", W_WIDTH/3,W_HEIGHT/2);
		}
		
		if (gameWin==true) {
			g.drawString("YOU WIN:))))", W_WIDTH/3,W_HEIGHT/2);
		}
	}
	
	
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveRock();
			checkHits();
			repaint();
			moveCrow();
			gameOverWin ();
			dropPotion ();
			
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
