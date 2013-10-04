package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Repr�sente un ovale pouvant �tre dessin�.
 */
public class Ovale extends AbstractForme {

	private int coordonnex;
	private int coordonney;
	private int width;
	private int height;

	/**
	 * Constructeur prennant un seul rayon pour repr�senter un cercle
	 * @param coordonnex coordon�e en x du centre
	 * @param coordonney coordon�e en y du centre
	 * @param rayon rayon du cercle
	 * @param color couleur du cercle
	 */
	public Ovale(int coordonnex, int coordonney, int rayon, Color color) {
		this(coordonnex, coordonney, rayon, rayon, color);
	}

	/**
	 * Constructeur prennant 2 rayons pour repr�senter un ovale
	 * @param coordonnex coordon�e en x du centre
	 * @param coordonney coordon�e en y du centre
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
