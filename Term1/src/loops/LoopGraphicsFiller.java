package loops;
// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;

	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// call your methods here
		colorRectangle (g);
		//circles(g,13);
		//change_circles (g);
		//row_circles (g);
		//checkboard (g);
	}
	//Write a method that draws n (a parameter) circles across the screen
	public void circles(Graphics g,int n) {
		g.setColor (Color.BLACK);
		for (int i=0;i<n;i++) {
			g.fillOval (i*(int)(1000/n),HEIGHT/2,20,20);
		}
	}
	
	//Write a method that draws circles across the screen, which start small, grow bigger, then shrink again
	public void change_circles (Graphics g) {
		g.setColor (Color.BLACK);
		for (int i=1;i<=21;i++) {
			if (i<10) {
				g.fillOval (i*50,HEIGHT/2,i*2,i*2);
			}
			else if (i>=10) {
				g.fillOval (i*50,HEIGHT/2, (20-i)*2, (20-i)*2);
			}
			
		}
	}
	
	//Write a method that draws 10 rows of 10 circles each
	public void row_circles(Graphics g) {
		g.setColor (Color.BLACK);
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				g.fillOval (i*50,j*50,20,20);
			}
		}
	}
	
	public void colorRectangle (Graphics g) {
		for (int i=0;i<=20;i++) {
			g.setColor(new Color((int)(Math.random ()*255), (int)(Math.random ()*255),(int)(Math.random ()*255)));
			g.fillRect(i*50, HEIGHT/2,20, 20);
		}
	}
	
	public void checkboard (Graphics g) {
		for (int i=0;i<WIDTH ;i++) {
			for (int j=0;j<HEIGHT;j++) {
				if ((i+j)%2==0) {
					g.setColor(Color.WHITE);
				}
				else
				{
					g.setColor(Color.BLACK);
				}
				g.fillRect(i*20,j*20 ,20, 20);
			}
		}
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}