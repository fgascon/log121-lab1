package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Repr�sente un rectangle pouvant �tre dessin�.
 */
public class Rectangle extends AbstractForme {

	private Vecteur size;

	/**
	 * Constructeur de la classe
	 * @param coordonneex1 coordon�e en x du premier coin du rectangle
	 * @param coordonneey1 coordon�e en y du premier coin du rectangle
	 * @param coordonneex2 coordon�e en x du deuxi�me coin du rectangle
	 * @param coordonneey2 coordon�e en y du deuxi�me coin du rectangle
	 * @param color couleur du rectangle
	 */
	public Rectangle(int numSequence, Color color, int coordonneex1, int coordonneey1, int coordonneex2, int coordonneey2) {
		super(numSequence, color, new Vecteur(Math.min(coordonneex1, coordonneex2), Math.min(coordonneey1, coordonneey2)));
		size = new Vecteur(Math.abs(coordonneex2 - coordonneex1), Math.abs(coordonneey2 - coordonneey1));
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
