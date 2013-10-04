package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente un ovale pouvant être dessiné.
 */
public class Ovale extends Forme {

	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * Constructeur prennant un seul rayon pour représenter un cercle
	 * @param x coordonée en x du centre
	 * @param y coordonée en y du centre
	 * @param rayon rayon du cercle
	 * @param color couleur du cercle
	 */
	public Ovale(int x, int y, int rayon, Color color) {
		this(x, y, rayon, rayon, color);
	}

	/**
	 * Constructeur prennant 2 rayons pour représenter un ovale
	 * @param x coordonée en x du centre
	 * @param y coordonée en y du centre
	 * @param rayonH rayon horizontal
	 * @param rayonV rayon vertical
	 * @param color couleur de l'ovale
	 */
	public Ovale(int x, int y, int rayonH, int rayonV, Color color) {
		super(color);
		this.x = x;
		this.y = y;
		this.width = rayonH * 2;
		this.height = rayonV * 2;
	}

	@Override
	/**
	 * Paint l'ovale sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner l'ovale
	 */
	public void drawForme(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(x, y, width, height);
	}

	@Override
	protected void drawOutbound(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}
}
