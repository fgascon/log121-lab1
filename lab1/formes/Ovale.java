package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

import lab1.math.Vecteur;

/**
 * Représente un ovale pouvant être dessiné.
 */
public class Ovale extends AbstractForme {

	private Vecteur size;

	/**
	 * Constructeur prennant un seul rayon pour représenter un cercle
	 * @param numSequence numéro de séquence
	 * @param color couleur du cercle
	 * @param coordonnees coordonées du centre
	 * @param rayon rayon du cercle
	 */
	public Ovale(int numSequence, Color color, Vecteur coordonnees, int rayon) {
		this(numSequence, color, coordonnees, rayon, rayon);
	}

	/**
	 * Constructeur prennant 2 rayons pour représenter un ovale
	 * @param numSequence numéro de séquence
	 * @param color couleur de l'ovale
	 * @param coordonnees coordonées du centre
	 * @param rayonH rayon horizontal
	 * @param rayonV rayon vertical
	 */
	public Ovale(int numSequence, Color color, Vecteur coordonnees, int rayonH, int rayonV) {
		super(numSequence, color, coordonnees.substract(new Vecteur(rayonH, rayonV)));
		this.size = new Vecteur(rayonH * 2, rayonV * 2);
	}

	@Override
	/**
	 * Paint l'ovale sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner l'ovale
	 */
	public void drawForme(Graphics graphic) {
		graphic.fillOval(getCoordonnees().getX(), getCoordonnees().getY(), size.getX(), size.getY());
	}

	@Override
	public float getMaxDistance() {
		return Math.max(size.getX(), size.getY());
	}

	@Override
	public float getAire() {
		//L'aire d'un ovale = PI * width/2 * height/2
		return (float) (Math.PI * size.getX() * size.getY() / 4);
	}

	@Override
	public String getType() {
		return size.getX() == size.getY() ? "cercle" : "ovale";
	}

	@Override
	protected Vecteur getSize() {
		return size;
	}
}
