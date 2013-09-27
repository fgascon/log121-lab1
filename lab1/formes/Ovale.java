package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Forme {

	private int x;
	private int y;
	private int width;
	private int height;

	public Ovale(int x, int y, int rayon, Color color) {
		this(x, y, rayon, rayon, color);
	}

	public Ovale(int x, int y, int rayonH, int rayonV, Color color) {
		super(color);
		this.x = x;
		this.y = y;
		this.width = rayonH * 2;
		this.height = rayonV * 2;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(x, y, width, height);
	}
}
