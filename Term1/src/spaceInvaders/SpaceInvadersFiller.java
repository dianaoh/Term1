package spaceInvaders;

// Space Invaders Filler Code by Mr. David
// Extra Feature: Ghost Aliens and shield to protect player
// Ghost Aliens are aliens that sometimes are able to allow lasers through their body without getting
//killed
//

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvadersFiller {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35, LASERNUM=4,
			NUMSHIELD=2, SHIELDWIDTH= 100, SHIELDHEIGHT= 60;
	
	// determines the difficulty. The closer to 1.0, the easier the game 
	private final double DIFFICULTY = .95;
	
	//Determines the difficulty in which ghost aliens come out.
	private final double GHOSTDIFFICULTY= 0.8;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();
	
	//our list of shields to protect the player
	private ArrayList<Shield> shields = new ArrayList<Shield> ();
	
	//declaring the player
	private SpaceThing player;
	
	// the current speed of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		//if condition to make sure that game is on going
		if (lost==false && paused==false && won==false) {
			//moves player across the screen
			player.x+=playerSpeed;
			
			//moves the aliens across the screen
			for (int i=0;i<aliens.size();i++) {
				aliens.get(i).x+=ALIENSPEED;
				
				//shifts aliens down the screen once they go off the screen
				if (aliens.get(i).x>=WIDTH) {
					aliens.get(i).x=0;
					aliens.get(i).y+=PLAYERENEMYHEIGHT;
				}
			}
			
			//Adds new lasers to screen according to difficulty.
			for (int i=0;i<aliens.size();i++) {
				//generates new number and compares it to difficulty.
				if (Math.random()>DIFFICULTY) {
					alienLasers.add(new Laser (aliens.get(i).x, aliens.get(i).y,LASERWIDTH,LASERHEIGHT));
				}
			}
			
			//Moves alien Lasers down the screen.
			for (int i=0;i<alienLasers.size();i++) {
				alienLasers.get(i).y+=LASERSPEED;
			}
			//Moves player lasers up the screen.
			for (int i=0;i<playerLasers.size();i++) {
				playerLasers.get(i).y-=LASERSPEED;
			}
			
		}
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		//collision between alien laser and player
		for (int i=0;i<alienLasers.size();i++) {
			
			//lives deducted when there is collision between alien laser and player
			if (alienLasers.get(i).intersects(player)) {
				//laser removed, and lives reduced when there is collision
				lives--;
				alienLasers.remove(i);
			}
			//Game ends when lives=0.
			if (lives==0) {
				lost=true;
			}
		}
		
		//for loop to go through the collision between each player laser and aliens
		for (int i=0;i<playerLasers.size();i++) {
			for (int j=0;j<aliens.size();j++) {
				if (playerLasers.get(i).intersects(aliens.get(j))) {
					//removes alien when 1. the ghost alien luckly gets shot 2. when a normal alien gets hit
					if ((aliens.get(j).getGhost ()==true && Math.random()>=DIFFICULTY*GHOSTDIFFICULTY)
						||(aliens.get(j).getGhost ()==false)) {
						
						//removes alien and player laser.
						aliens.remove(j);
						playerLasers.remove(i);
						break;
					}
				}
			}
		}
		
		//Player wins when aliens get removed.
		if (aliens.size()==0) {
			won=true;
		}
		
		//nested for loop to check for collision between alien lasers and shield
		for (int i=0;i<alienLasers.size();i++) {
			for (int j=0;j<shields.size();j++) {
				if (alienLasers.get(i).intersects(shields.get(j))) {
					//increases damage of shield
					shields.get(j).increaseDamage();
					//removes laser that caused damage
					alienLasers.remove(i);
					break;
				}
				
				//shield is removed after 4 hits
				if (shields.get(j).getDamage()==4) {
					shields.remove(j);
				}
				
			}
			
		}
		
		//nested for loop to check for collision between shields and aliens
		for (int i=0;i<shields.size();i++) {
			for (int j=0;j<aliens.size ();j++) {
				//the whole shield gets removed during direct contact with an alien
				if (shields.get(i).intersects(aliens.get(j))) {
					//shield and alien is removed
					shields.remove(i);
					aliens.remove(j);
					break;
				}
			}
			
		}
		
		//Player loses when alien reaches the ground or touches player
		for (int i=0;i<aliens.size();i++) {
			//Touches the ground
			if (aliens.get(i).y>=HEIGHT) {
				lost=true;
			}
			//Collides with the player
			if (Math.abs(player.x-aliens.get(i).x)<=PLAYERENEMYWIDTH && Math.abs(player.y-aliens.get(i).y)<=PLAYERENEMYHEIGHT) {
				lost=true;
			}
		}
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		//sets new player
		player = new SpaceThing (WIDTH/2-PLAYERENEMYWIDTH/2,HEIGHT-PLAYERENEMYHEIGHT*2,PLAYERENEMYWIDTH,PLAYERENEMYHEIGHT,"playerCannon.jpg",false);
		
		//sets the list of aliens in rows
		for (int i=0;i<10;i++) {
			for (int j=0;j<NUMALIENS/10;j++) {
				//Sets ghost players according to difficulty
				if (Math.random ()>DIFFICULTY*GHOSTDIFFICULTY) {
					aliens.add(new SpaceThing (WIDTH*i/10, j*50,PLAYERENEMYWIDTH,PLAYERENEMYHEIGHT,"GhostAlien.png",true) );
				}
				//Sets normal aliens.
				else {
					aliens.add(new SpaceThing (WIDTH*i/10, j*50,PLAYERENEMYWIDTH,PLAYERENEMYHEIGHT,"alien.png",false) );
				}
				
			}
		}
		
		//sets the shields
		for (int i=0;i<NUMSHIELD;i++) {
			shields.add(new Shield (WIDTH*i/NUMSHIELD+ WIDTH/(NUMSHIELD*2)-SHIELDWIDTH/2,HEIGHT-SHIELDHEIGHT*4,SHIELDWIDTH, SHIELDHEIGHT,0));
		}
		
	}
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		//Removes laser if there are more than LASERNUM lasers being shot
		if (playerLasers.size()>=LASERNUM) {
			playerLasers.remove(0);
			//replace with new laser
			playerLasers.add(new Laser (player.x+PLAYERENEMYWIDTH/2,player.y,LASERWIDTH, LASERHEIGHT));

		}
		else {
			//adds laser when you press space bar
			playerLasers.add(new Laser (player.x+PLAYERENEMYWIDTH/2,player.y,LASERWIDTH, LASERHEIGHT));
		}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//draws player lasers
		for (int i=0;i<playerLasers.size ();i++) {
			g.setColor (Color.red);
			playerLasers.get(i).draw(g);
		}
		
		//draws alien lasers
		for (int i=0;i<alienLasers.size ();i++) {
			g.setColor(Color.red);
			alienLasers.get(i).draw(g);
		}
		
		//draws the row of aliens
		for (int i=0;i<aliens.size();i++) {
			aliens.get(i).draw(g);
		}
		
		//draws shield
		for (int i=0;i<shields.size();i++) {
			shields.get(i).draw(g);
		}
				
		//draws player
		player.draw(g); 
		
		//Displays lives on screen
		g.setColor(Color.red);
		g.drawString("Lives: "+lives, 15, 15);
		
		//Display lost.
		if (lost) 
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		
		//Display won.
		if (won) 
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvadersFiller() {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
				frame.getContentPane().repaint();
			}
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvadersFiller();
	}
}