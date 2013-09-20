package lab1.formes;
import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Forme {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x1, int y1, int x2, int y2, Color color) {
		super(color);
		width = Math.abs(x2-x1);
		height = Math.abs(y2-y1);
		x = Math.min(x1, x2);
		y = Math.min(y1, y2);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(x, y, width, height);
	}
	
}
