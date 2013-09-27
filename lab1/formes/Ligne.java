package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

public class Ligne extends Forme {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public Ligne(int x1, int y1, int x2, int y2, Color color) {
		super(color);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(x1, y1, x2, y2);
	}
}
