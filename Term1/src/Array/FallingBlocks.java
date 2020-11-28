package Array;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocks extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

	// instance variables (what kind of data structure should we use?)
	private int [] y = new int [NUMBLOCKS],x=new int [NUMBLOCKS]; 
	private int[] speed =new int [NUMBLOCKS];
	private int [] color1= new int [NUMBLOCKS];
	private int [] color2= new int [NUMBLOCKS];
	private int [] color3= new int [NUMBLOCKS];
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		
		for (int i=0;i<x.length;i++) {
			x[i]=(int)(Math.random()*WIDTH);
		}
		
		for (int i=0;i<speed.length; i++) {
			speed [i]= ((int)(Math.random ()*11)+3);
		}
		
		for (int i=0;i<color1.length;i++) {
			color1 [i]=(int)(Math.random ()*255);
			color2 [i]=(int)(Math.random ()*255);
			color3 [i]=(int)(Math.random ()*255);
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {

		for (int i=0;i<y.length;i++) {
			y[i]+=speed[i];
			if (y[i]>HEIGHT) {
				y[i]=0;
				x[i]=(int)(Math.random()*WIDTH);
				speed[i]=(int)(Math.random ()*11+3);
				color1 [i]=(int)(Math.random ()*255);
				color2 [i]=(int)(Math.random ()*255);
				color3 [i]=(int)(Math.random ()*255);
			}
				
		}
		
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		
		// draw your rectangles here! 
		for (int i=0;i<NUMBLOCKS;i++) {
			g.setColor(new Color (color1[i],color2[i],color3[i]));
			g.fillRect(x[i],y[i],10 ,10);
		}
		
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocks() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocks();
	}

}