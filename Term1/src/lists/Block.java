package lists;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	private int x,y;
	private int speed;
	private int width, height;
	Color color;
	
	public Block (int x, int y, int speed, Color color) {
		width=10;
		height=10;
		this.x=x;
		this.y=y;
		this.speed=speed;
		this.color= color;
	}

	public void draw (Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	public void move () {
		y+=speed;
		
	}
	
	public int getY() {
		return y;
	}
}
