package projects;
// Angry Birds template provided by Mr. David
// Help with increasing score with Mr. Friedman

import java.awt.Color;
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
	//X and YPositions of enemies
	private int[] enemyX= {235,775,370,470,529,642,860};
	private int[] enemyY= {485,505,250,385,207,365,50};
	
	//Size of Enemies
	private int[] enemySize= {40,40,40,40,40,40,40};
	
	//Positions,speed of shrinking poison and reset position of poison
	private int[] poisonX= new int[enemyX.length-1];
	private int[] poisonY= {-600,-300,-800,-100,-400,-700};
	private int poisonSpeed=1;
	private int poisonYreset=-400;
	
	//Boolean to keep track if enemy is dead or not
	private boolean[] dead = {false,false,false,false,false,false,false};

	
	//Images of Rock, slingshot, enemies and poison
	private Image rock;
	private Image slingshot;
	private Image landscape;
	private Image monster1;
	private Image monster2;
	private Image monster3;
	private Image monster4;
	private Image monster5;
	private Image monster6;
	private Image crow;
	private Image potion;

	//Starting positions and speeds of rock, and speed of crow
	private int startX, startY;
	private double speedX=0, speedY=0; 
	private double rockX=73, rockY=440; 
	private double rockXOriginal=73, rockYOriginal=440;
	private double crowSpeed=5.5;
	
	//Crow shrinking rate, and number of points that crow has
	private double crowShrink=1.1;
	private int crowPoints=5;
	
	//Score of player
	private int score=0;
	
	//Number of tries used
	private int triesLeft=20;
	private int deadcount=0;
	
	//Gravitational pull boolean
	private boolean isGravityOn = false; 
	
	//Boolean to check if Player lost or won game
	private boolean gameOver=false;
	private boolean gameWin=false;
	
	//Sizes of rock and Poison
	private final int ROCKDIAM=25, ENEMYDIAM=40;
	private final int POTION_HEIGHT=27, POTION_WIDTH=15;
	
	
	//Slingshot Width and Height
	private final int SLINGSHOT_WIDTH=80, SLINGSHOT_HEIGHT=170;
	
	
	
	
	
	// this method is for setting up any arrays that need filling in and loading images. 
	public void setup() {
		
		//Image of rock to kill enemies
		try {
			rock = ImageIO.read(new File("rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of slingshot
		try {
			slingshot= ImageIO.read(new File("catapult.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Image of landscape
		try {
			landscape= ImageIO.read(new File("landscape3.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Monster1
		try {
			monster1= ImageIO.read(new File("big-mouth-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Monster2
		try {
			monster2= ImageIO.read(new File("round_monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Monster3
		try {
			monster3= ImageIO.read(new File("scary-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Monster4
		try {
			monster4= ImageIO.read(new File("bird-monster-pngrepo-com (1).png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Monster5
		try {
			monster5= ImageIO.read(new File("three-eyed-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Monster6
		try {
			monster6= ImageIO.read(new File("square-big-mouth-monster.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Crow
		try {
			crow= ImageIO.read(new File ("crow2.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		//Image of Potion
		try {
			potion= ImageIO.read(new File ("Potion.png"));
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	// moves 'rock' and applies gravitational pull 
	public void moveRock() {
		//if statement to see if the game is on going or ended
		if (gameOver==false && gameWin==false) {
			
			//acceleration of rock
			rockX += speedX; 
			rockY += speedY; 
			
			//Gravitational pull on rock
			if (isGravityOn) {
				speedY+= GRAVITY1;
			}
			
			//resets bird position when off the screen
			//turns gravity and speed back to zero
			if (rockX>W_WIDTH || rockY>W_HEIGHT) {
				rockX=rockXOriginal;
				rockY=rockYOriginal;
				speedX=0;
				speedY=0;
				isGravityOn=false;
				//reduces the number of tries left
				triesLeft--;
			}
			
		}
	}
	//Moves the 'Crow' and makes it fly
	public void moveCrow() {
		//if statement to see if the game is on going or ended
		if (gameOver==false && gameWin==false) {
			//moves crow across the screen
			enemyX[6]-=crowSpeed;
			
			//Checks for Collsions and resets position of crow
			if (enemyX[6]+ENEMYDIAM<0) {
				enemyX[6]=W_WIDTH+ENEMYDIAM*4;
			}
		}
	}
	
	//Method to drop Shrinking poisons/potions
	public void dropPotion() {
		//Setting position of poison X;
		for (int i=0;i<poisonX.length;i++) {
			poisonX[i]=enemyX[i]+enemySize[i]/2-POTION_WIDTH/2;
			
		}
		//if statement to see if the game is on going or ended
		if (gameOver==false && gameWin==false) {
			//makes the potion fall down the screen
			for (int i=0;i<poisonY.length;i++) {
				poisonY[i]+=poisonSpeed;
				
				//resets position of potion
				if (poisonY[i]>W_HEIGHT) {
					poisonY[i]=poisonYreset;
				}
			}
		}
	}
	
	// check for any collisions between your 'rock' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
		//if statement to see if the game is on going or ended
		if (gameOver==false && gameWin==false) {
			//finding out if there is a collision between rock and enemies
			for (int i=0;i<enemyX.length;i++) {
				if (distance(enemyX[i],enemyY[i],rockX,rockY)<=enemySize[i]/2+ROCKDIAM/2 && dead[i]==false) {
					//cast enemies as dead
					dead[i]=true;
					deadcount++;
					
					//increases score of player
					if (i==6) {
						score+=crowPoints;
					}
					else score++;
				}
			}
			
			//finding out if there is a collision between poison and enemies
			for (int i=0;i<poisonX.length;i++) {
				//if there is a collision between still enemy and potion shrinks size by 2
				if (poisonY[i]==enemyY[i]){
					//shrinks size by 2
					enemySize[i]/=2;
					//enemyY[i]+=enemySize[i];
					enemyX[i]+=enemySize[i]/2;
				}
				
				//if there is a collision between crow and potion, crow size shrinks by 1.1 (crowShrink)
				if (distance(enemyX[6],enemyY[6],poisonX[i],poisonY[i])<=enemySize[6]/2+POTION_WIDTH/2) {
					enemySize[6]/=crowShrink;
				}
			}
			
			
		
			//dropping monsters if they are dead
			for (int i=0;i<dead.length;i++) {
				if (dead[i]==true) {
					//applies gravity
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
		//if statement to see if the game is on going or ended
		if (gameOver==false && gameWin==false) {
			//the starting position is cast as the click of the player
			startX = mouseX;
			startY = mouseY; 
		}
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		//if statement to see if the game is on going or ended
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
	
	//Method to calculate if Game has finished with a Loss or a Win
	public void gameOverWin () {
		//Game Over is initiated
		if (triesLeft==0 && deadcount<7) {
			gameOver=true;
		}
		//Game is Won
		if (triesLeft>0 && deadcount>6) {
			gameWin=true;
		}
	}
	
	// draws everything in my project - the enemies, my 'rock', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		
		// draws a white background
		g.setColor(new Color (247,247,247));
		g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
		g.drawImage(landscape,70,20,W_WIDTH,W_HEIGHT,null);
		
		//displays score on screen
		//Make new font
		Font a= new Font ("Arial",Font.BOLD,10);
		g.setFont(a);
		g.setColor(Color.black);
		g.drawString("score: "+score, W_WIDTH/6, 20);
		
		//displayes tries left on screen
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
		g.drawImage(crow, enemyX[6], enemyY[6],enemySize[6], enemySize[6], null);
		
		
		//draws image of poison
		for (int i=0;i<poisonX.length;i++) {
			g.drawImage(potion,poisonX[i], poisonY[i], POTION_WIDTH, POTION_HEIGHT, null);
		}
		
		//displayes "GAME OVER" or "YOU WIN" depending on if the player wins or loses
		Font b= new Font ("Arial",Font.BOLD,60);
		g.setFont(b);
		g.setColor(Color.black);
		//Game is lost
		if (gameOver==true) {
			g.drawString("GAME OVER", W_WIDTH/3,W_HEIGHT/2);
		}
		//Game is won
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
