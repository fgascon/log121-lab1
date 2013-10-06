package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente une ligne pouvant être dessinée
 */
public class Ligne extends Forme {

	private int x1;
	private int y1;
	private int x2;
	private int y2;

	/**
	 * Constructeur de la classe
	 * @param x1 coordonée en X du point 1 de la ligne
	 * @param y1 coordonée en Y du point 1 de la ligne
	 * @param x2 coordonée en X du point 2 de la ligne
	 * @param y2 coordonée en Y du point 2 de la ligne
	 * @param color couleur de la ligne
	 */
	public Ligne(int x1, int y1, int x2, int y2, Color color) {
		super(color);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	/**
	 * Paint la ligne sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner la ligne
	 */
	public void drawForme(Graphics g) {
		g.drawLine(x1, y1, x2, y2);
	}

	@Override
	protected void drawOutbound(Graphics graphics) {
		graphics.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	}

	@Override
	public float getMaxDistance() {
		float deltaX = x2-x1;
		float deltaY = y2-y1;
		return (float)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}

	@Override
	public float getAire() {
		//l'aire de la ligne = 1 * longueur
		return getMaxDistance();
	}
}
