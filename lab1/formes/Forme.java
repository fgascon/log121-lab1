package lab1.formes;


import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme {

	private Color color;

	public Forme(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public abstract void paint(Graphics g);
}
