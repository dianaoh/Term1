package polymorphism;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import inheritance.Ball;

public class ShapeRunner {
	
	private Shape[] shapes = new Shape[4];
	
	// this method should move all the shapes in the list
	public void moveShapes() {
		for (int i=0;i<4;i++) {
			shapes[i].move(1, 1);
		}
	}
	
	// fill in your shape list here
	public void setup() {
		shapes[0] =new Shape (10,10);
		shapes[1] = new Rect (20,20,10,10);
		shapes[2]=new Oval (30,30,10,10);
		shapes[3] = new RoundedRect (70,70,40,40);
	}
	
	// DON'T TOUCH BELOW CODE
	
	public void run() {
		while (true ) {
			moveShapes();
			frame.repaint();
			try {
				Thread.sleep(75);
			} catch (Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		new ShapeRunner(); 
	}
	private JFrame frame;
	public ShapeRunner() {
		setup();
		frame = new JFrame() {
			public void paint(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 600, 600);
				
				for (Shape s: shapes)
					s.draw(g);
			}
		};
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		run();
	}
}