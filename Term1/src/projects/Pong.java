//Diana Oh
package projects;
//Citations: https://stackoverflow.com/questions/18483768/draw-text-in-middle-of-the-screen
//Mr. Friedman helped me with drawing strings, and helped me figure out how to use the booleans 
//to make my code work
//filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 8, PADDLE_HEIGHT = 100;
	private final int SLOWER_DIAM=15;
	
	//variables that change as the game proceeds
	private  int slower_speed=5;
	private int paddle_speed1=4, paddle_speed2=4;
	private int x= WIDTH/2+3, y= HEIGHT/2-10, speedX= 0, speedY = 0;
	private int paddle1 = WIDTH/2-PADDLE_WIDTH/2, paddle2= WIDTH/2-PADDLE_WIDTH/2;
	private int score1, score2;
	private int slower_position1=0, slower_position2=WIDTH-SLOWER_DIAM;
	private int slower_positionx1= paddle1+PADDLE_HEIGHT/2-SLOWER_DIAM/2, slower_positionx2= paddle2+PADDLE_HEIGHT/2-SLOWER_DIAM/2;


	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo1 = false, solo2=false;		//booleans to keep track of solo modes
	private boolean round =false;					//boolean to keep track of new rounds
	private boolean restart=false;					//boolean to restart
	private boolean slower1=false, slower2=false;	//boolean to keep track of slower balls
	private boolean starter=true; 					//boolean to use for the starter
	private boolean solo=false;						//boolean to keep track if the mode is solo or not
	
	
	// this method moves the ball at each timestep
	public void move_ball() {

		x += speedX;
		y += speedY;
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (up1==true)
		{
			paddle1 += paddle_speed1;
		}
		
		if (up2==true)
		{
			paddle2 += paddle_speed2;
			
		}
		
		if (down1 == true) {
			paddle1 -= paddle_speed1; 
		}
		
		if (down2 ==true) {
			paddle2 -= paddle_speed2;
		}
		
		//AI paddles during solo mode
		if (solo==true) {
			
			//AI paddle for solo mode1
			if (solo1==true) {
				if (y>paddle2+PADDLE_HEIGHT/2) {
					up2=true;
					down2=false;
						
				}
				else if (y<paddle2+PADDLE_HEIGHT/2) {
					down2=true;
					up2=false;
					
				}
				else {
					down2=false;
					up2=false;	
				}
			}
			
			//AI paddle for solo mode2
			if (solo2==true) {
				if (y>paddle1+PADDLE_HEIGHT/2) {
					up1=true;
					down1=false;
		
				}
				else if (y<paddle1+PADDLE_HEIGHT/2) {
					down1=true;
					up1=false;
	
				}
				else {
					down1=false;
					up1=false;
				}
			}
		}
		
	}
	
	//this method moves the slowballs at each timestep
	public void move_slowballs () {
		if (slower1==true) {
			slower_position1+=slower_speed;
		}
		if (slower2==true) {
			slower_position2-=slower_speed;
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		if (x>=WIDTH-DIAM) {
			score1++;
			slower_speed=2;
			new_round ();
			
		}
		
		else if (x<=0) {
			score2++;
			slower_speed=2;
			new_round ();
		}
		
		if (y>= HEIGHT-DIAM|| y<=0) {
			speedY = -speedY;
	
		}
		
		//ball speed determination
		if (x<=PADDLE_WIDTH && y>=paddle1 && y<= paddle1+PADDLE_HEIGHT) {
			speedX=(3 + (int)(Math.random()*(3)));
			speedY=(3 + (int)(Math.random()*(3)));
		}
		
		if (x>=WIDTH-PADDLE_WIDTH-DIAM && y>= paddle2 && y<= paddle2+PADDLE_HEIGHT) {
			speedX=-(3 + (int)(Math.random()*(3)));
			speedY=-(3 + (int)(Math.random()*(3)));
		}
		
		
		//slowball collisions
		if (slower_position2<=PADDLE_WIDTH && slower_positionx2>=paddle1 && slower_positionx2<= paddle1+PADDLE_HEIGHT) {
			paddle_speed1=1;
		}
		
		if (slower_position1>=WIDTH-PADDLE_WIDTH-DIAM && slower_positionx1>= paddle2 && slower_positionx1<= paddle2+PADDLE_HEIGHT) {
			paddle_speed2=1;
		}


		
		
	}
	

	
	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		// background color is gray
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if (starter==true) {
			Font a= new Font ("Arial",Font.BOLD,100);
			g.setFont(a);
			g.setColor(Color.white);
			g.drawString("PONG", WIDTH/4,HEIGHT/2);
			Font b= new Font ("Arial",Font.ITALIC,20);
			g.setFont(b);
			g.setColor(Color.white);
			g.drawString("Press 'q'(1) or the left arrow key(2) for slow balls", WIDTH/7,HEIGHT/2+40);
			g.drawString("Press 'd' to continue", WIDTH/3,HEIGHT/2+20);
		}
		
		// draw your rectangles and circles here
		g.setColor(new Color(255,255,255));
		g.fillOval(x,y,DIAM,DIAM);
		
		g.setColor(new Color (255,255,255));
		g.fillRect(0,paddle1 , PADDLE_WIDTH, PADDLE_HEIGHT);
		
		g.setColor(new Color (255,255,255));
		g.fillRect (WIDTH-PADDLE_WIDTH, paddle2 ,PADDLE_WIDTH, PADDLE_HEIGHT);
		
		//Slowballs to make the other paddle slower
		g.setColor(new Color (255,255,255));
		int slower_positionx1= paddle1+PADDLE_HEIGHT/2-SLOWER_DIAM/2;
		g.fillOval(slower_position1,slower_positionx1,SLOWER_DIAM,SLOWER_DIAM);
		
		g.setColor(new Color (255,255,255));
		int slower_positionx2= paddle2+PADDLE_HEIGHT/2-SLOWER_DIAM/2;
		g.fillOval(slower_position2,slower_positionx2,SLOWER_DIAM,SLOWER_DIAM);
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("P1 Score: "+score1, WIDTH/5, 20);
		g.drawString("P2 Score: "+score2, WIDTH*3/5, 20);
		FontMetrics fontMetrics = g.getFontMetrics(f);
		
		//Continues to New Round 
		if (round==true) {
			slower_speed=0;
			String sentance= "Press c to continue";
			int size = fontMetrics.stringWidth(sentance);
			g.drawString(sentance, WIDTH/2-size/2, HEIGHT/2);
		}
		
		//Notification before restarting the game
		if (restart==true) {
			round=false;
			String sentance= "Would you really like to restart? (y/n)";
			speedX=0;
			speedY=0;
			int size = fontMetrics.stringWidth(sentance);
			g.drawString(sentance, WIDTH/2-size/2, HEIGHT/2);
		}
		
		//Displays Solo Rounds 1 & 2
		if (solo1==true) {
			String sentance= "Solo1 Mode";
			int size = fontMetrics.stringWidth(sentance);
			g.drawString(sentance, size/8, 20);
		}
		
		if (solo2==true) {
			String sentance= "Solo2 Mode";
			int size= fontMetrics.stringWidth(sentance);
			g.drawString(sentance, WIDTH-(size+size/8),20);

		}
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) 
			up2 = true;
		
		if (keyCode == KeyEvent.VK_UP) 
			down2= true;

		if (e.getKeyChar() == 's')
			up1 = true;
		
		if (e.getKeyChar() =='w')
			down1= true;
		
		if (e.getKeyChar()=='r') {
			restart=true;
		}
		
		if (e.getKeyChar()=='d' && starter==true) {
			starter=false;
			speedX=(3 + (int)(Math.random()*(3)));;
			speedY=(3 + (int)(Math.random()*(3)));;
		}
		
		//slowball shooting
		if (e.getKeyChar()=='q') {
			slower_speed=5;
			slower1=true;
		}
		if (keyCode==KeyEvent.VK_LEFT){
			slower_speed=5;
			slower2=true;
		}
		
		// turn 1-player mode on
		if (e.getKeyChar() == '1') {
			solo=true;
			solo1 = true;
			solo2=false;
			solo();
		}

			
		// turn 2-player mode on
		if (e.getKeyChar() == '2') {
			solo=true;
			solo2= true;
			solo1=false;
			solo ();
			
		}
			
		if (e.getKeyChar()=='c'&& round==true) {
			solo=true;
			speedX=(3 + (int)(Math.random()*(3)));;
			speedY=(3 + (int)(Math.random()*(3)));;
			round=false;
		}
		
		if (e.getKeyChar()=='n') {
			restart=false;
			speedX=(3 + (int)(Math.random()*(3)));;
			speedY=(3 + (int)(Math.random()*(3)));;
		}
		
		if (e.getKeyChar()=='y') {
			restart ();
			restart=false;
			speedX=(3 + (int)(Math.random()*(3)));;
			speedY=(3 + (int)(Math.random()*(3)));;
		}
		
		
		

	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) 
			down2 = false; 

		if (keyCode == KeyEvent.VK_DOWN) 
			up2 = false;

		if(e.getKeyChar() == 's')
			up1 = false;
		
		if (e.getKeyChar() == 'w')
			down1 = false;
		
	}
	
	// restarts the game, including scores
	public void restart() {
		slower_position1=0;
		slower_position2=WIDTH-SLOWER_DIAM;
		paddle_speed1=4;
		paddle_speed2=4;
		solo1=false;
		solo2=false;
		solo=false;
		score1=0;
		score2=0;
		speedX=0;
		speedY=0;
		x=WIDTH/2;
		y=HEIGHT/2;
		paddle1=WIDTH/2-PADDLE_HEIGHT/2;
		paddle2=WIDTH/2-PADDLE_HEIGHT/2;
	}
	
	//new round when a person scores
	public void new_round () {
		slower_position1=0;
		slower_position2=WIDTH-SLOWER_DIAM;
		paddle_speed1=4;
		paddle_speed2=4;
		solo=false;
		round=true;
		up1=false;
		up2=false;
		down1=false;
		down2=false;
		slower_speed=0;
		speedX=0;
		speedY=0;
		x=WIDTH/2;
		y=HEIGHT/2;
		paddle1=WIDTH/2-PADDLE_HEIGHT/2;
		paddle2=WIDTH/2-PADDLE_HEIGHT/2;
		
	}
	//resetting for solo rounds 1&2
	public void solo () {
		slower_speed=0;
		round=false;
		restart=false;
		score1=0;
		score2=0;
		speedX=3;;
		speedY=4;;
	
	}
	
	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, slowball and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			move_slowballs ();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
		
	}

	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart=true;
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}
