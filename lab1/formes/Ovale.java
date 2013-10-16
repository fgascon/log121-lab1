package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

import lab1.math.Vecteur;

/**
 * Repr�sente un ovale pouvant �tre dessin�.
 */
public class Ovale extends AbstractForme {

	private Vecteur size;

	/**
	 * Constructeur prennant un seul rayon pour repr�senter un cercle
	 * @param numSequence num�ro de s�quence
	 * @param color couleur du cercle
	 * @param coordonnees coordon�es du centre
	 * @param rayon rayon du cercle
	 */
	public Ovale(int numSequence, Color color, Vecteur coordonnees, int rayon) {
		this(numSequence, color, coordonnees, rayon, rayon);
	}

	/**
	 * Constructeur prennant 2 rayons pour repr�senter un ovale
	 * @param numSequence num�ro de s�quence
	 * @param color couleur de l'ovale
	 * @param coordonnees coordon�es du centre
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
