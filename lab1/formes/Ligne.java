package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente une ligne pouvant être dessinée
 */
public class Ligne extends AbstractForme {

	private int coordonneex1;
	private int coordonneey1;
	private int coordonneex2;
	private int coordonneey2;

	/**
	 * Constructeur de la classe
	 * @param coordonneex1 coordonée en X du point 1 de la ligne
	 * @param coordonneey1 coordonée en Y du point 1 de la ligne
	 * @param coordonneex2 coordonée en X du point 2 de la ligne
	 * @param coordonneey2 coordonée en Y du point 2 de la ligne
	 * @param color couleur de la ligne
	 */
	public Ligne(int coordonneex1, int coordonneey1, int coordonneex2, int coordonneey2, Color color) {
		super(color);
		this.coordonneex1 = coordonneex1;
		this.coordonneey1 = coordonneey1;
		this.coordonneex2 = coordonneex2;
		this.coordonneey2 = coordonneey2;
	}

	@Override
	/**
	 * Paint la ligne sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner la ligne
	 */
	public void drawForme(Graphics graphic) {
		graphic.drawLine(coordonneex1, coordonneey1, coordonneex2, coordonneey2);
	}

	@Override
	protected void drawOutbound(Graphics graphics) {
		graphics.drawRect(Math.min(coordonneex1, coordonneex2), Math.min(coordonneey1, coordonneey2), Math.abs(coordonneex2-coordonneex1), Math.abs(coordonneey2-coordonneey1));
	}

	@Override
	public float getMaxDistance() {
		float deltaX = coordonneex2-coordonneex1;
		float deltaY = coordonneey2-coordonneey1;
		return (float)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}

	@Override
	public float getAire() {
		//l'aire de la ligne = 1 * longueur
		return getMaxDistance();
	}
}
