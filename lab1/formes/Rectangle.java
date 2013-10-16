package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

import lab1.math.Vecteur;

/**
 * Représente un rectangle pouvant être dessiné.
 */
public class Rectangle extends AbstractForme {
	
	private Vecteur size;
	
	/**
	 * Constructeur de la classe
	 * @param color couleur du rectangle
	 * @param coordonnees1 coordonées du premier coin du rectangle
	 * @param coordonnees2 coordonées du deuxième coin du rectangle
	 */
	public Rectangle(int numSequence, Color color, Vecteur coordonnees1, Vecteur coordonnees2) {
		super(numSequence, color, coordonnees1.getMin(coordonnees2));
		size = coordonnees2.substract(coordonnees1).getAbs();
	}
	
	@Override
	/**
	 * Paint le rectangle sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner le rectangle
	 */
	protected void drawForme(Graphics graphics){
		graphics.fillRect(getCoordonnees().getX(), getCoordonnees().getY(), size.getX(), size.getY());
	}
	
	protected Vecteur getSize() {
		return size;
	}

	@Override
	public float getMaxDistance() {
		return size.getNorme();
	}

	@Override
	public float getAire() {
		return size.getX() * size.getY();
	}

	@Override
	public String getType() {
		return size.getX() == size.getY() ? "carre" : "rectangle";
	}
}
