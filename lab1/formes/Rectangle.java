package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Repr�sente un rectangle pouvant �tre dessin�.
 */
public class Rectangle extends Forme {

	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * Constructeur de la classe
	 * @param x1 coordon�e en x du premier coin du rectangle
	 * @param y1 coordon�e en y du premier coin du rectangle
	 * @param x2 coordon�e en x du deuxi�me coin du rectangle
	 * @param y2 coordon�e en y du deuxi�me coin du rectangle
	 * @param color couleur du rectangle
	 */
	public Rectangle(int x1, int y1, int x2, int y2, Color color) {
		super(color);
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		x = Math.min(x1, x2);
		y = Math.min(y1, y2);
	}

	@Override
	/**
	 * Paint le rectangle sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner le rectangle
	 */
	public void paint(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(x, y, width, height);
	}

}
