package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente une ligne pouvant être dessinée
 */
public class Ligne extends AbstractForme {

	private Vecteur debut;
	private Vecteur fin;

	/**
	 * Constructeur de la classe
	 * @param coordonneex1 coordonée en X du point 1 de la ligne
	 * @param coordonneey1 coordonée en Y du point 1 de la ligne
	 * @param coordonneex2 coordonée en X du point 2 de la ligne
	 * @param coordonneey2 coordonée en Y du point 2 de la ligne
	 * @param color couleur de la ligne
	 */
	public Ligne(int numSequence, Color color, int coordonneex1, int coordonneey1, int coordonneex2, int coordonneey2) {
		super(numSequence, color, new Vecteur(coordonneex1, coordonneey1).getMin(new Vecteur(coordonneex2, coordonneey2)));
		this.debut = new Vecteur(coordonneex1, coordonneey1);
		this.fin = new Vecteur(coordonneex2, coordonneey2);
	}

	@Override
	/**
	 * Paint la ligne sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner la ligne
	 */
	public void drawForme(Graphics graphic) {
		graphic.drawLine(debut.getX(), debut.getY(), fin.getX(), fin.getY());
	}

	@Override
	public float getMaxDistance() {
		return debut.getDistance(fin);
	}

	@Override
	public float getAire() {
		//l'aire de la ligne = 1 * longueur
		return getMaxDistance();
	}

	@Override
	public String getType() {
		return "ligne";
	}

	@Override
	protected Vecteur getSize() {
		return fin.substract(debut).getAbs();
	}
}
