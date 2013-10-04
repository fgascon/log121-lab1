package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente un ovale pouvant être dessiné.
 */
public class Ovale extends AbstractForme {

	private int coordonnex;
	private int coordonney;
	private int width;
	private int height;

	/**
	 * Constructeur prennant un seul rayon pour représenter un cercle
	 * @param coordonnex coordonée en x du centre
	 * @param coordonney coordonée en y du centre
	 * @param rayon rayon du cercle
	 * @param color couleur du cercle
	 */
	public Ovale(int coordonnex, int coordonney, int rayon, Color color) {
		this(coordonnex, coordonney, rayon, rayon, color);
	}

	/**
	 * Constructeur prennant 2 rayons pour représenter un ovale
	 * @param coordonnex coordonée en x du centre
	 * @param coordonney coordonée en y du centre
	 * @param rayonH rayon horizontal
	 * @param rayonV rayon vertical
	 * @param color couleur de l'ovale
	 */
	public Ovale(int coordonnex, int coordonney, int rayonH, int rayonV, Color color) {
		super(color);
		this.coordonnex = coordonnex;
		this.coordonney = coordonney;
		this.width = rayonH * 2;
		this.height = rayonV * 2;
	}

	@Override
	/**
	 * Paint l'ovale sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner l'ovale
	 */
	public void paint(Graphics graphic) {
		graphic.setColor(this.getColor());
		graphic.fillOval(coordonnex, coordonney, width, height);
	}
}
