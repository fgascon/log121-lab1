package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente un rectangle pouvant être dessiné.
 */
public class Rectangle extends AbstractForme {

	private int coordonneex;
	private int coordonneey;
	private int width;
	private int height;

	/**
	 * Constructeur de la classe
	 * @param coordonneex1 coordonée en x du premier coin du rectangle
	 * @param coordonneey1 coordonée en y du premier coin du rectangle
	 * @param coordonneex2 coordonée en x du deuxième coin du rectangle
	 * @param coordonneey2 coordonée en y du deuxième coin du rectangle
	 * @param color couleur du rectangle
	 */
	public Rectangle(int coordonneex1, int coordonneey1, int coordonneex2, int coordonneey2, Color color) {
		super(color);
		width = Math.abs(coordonneex2 - coordonneex1);
		height = Math.abs(coordonneey2 - coordonneey1);
		coordonneex = Math.min(coordonneex1, coordonneex2);
		coordonneey = Math.min(coordonneey1, coordonneey2);
	}

	@Override
	/**
	 * Paint le rectangle sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner le rectangle
	 */
	protected void drawForme(Graphics graphics){
		graphics.fillRect(coordonneex, coordonneey, width, height);
	}

	@Override
	protected void drawOutbound(Graphics graphics){
		graphics.drawRect(coordonneex-1, coordonneey-1, width+1, height+1);
	}

	@Override
	public float getMaxDistance() {
		return (float)Math.sqrt(width*width + height*height);
	}

	@Override
	public float getAire() {
		return width * height;
	}
}
