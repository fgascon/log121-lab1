package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Repr�sente un rectangle pouvant �tre dessin�.
 */
public class Rectangle extends AbstractForme {

	private int coordonnex1;
	private int coordonney1;
	private int coordonnex2;
	private int coordonney2;

	/**
	 * Constructeur de la classe
	 * @param coordonnex1 coordon�e en x du premier coin du rectangle
	 * @param coordonney1 coordon�e en y du premier coin du rectangle
	 * @param coordonnex2 coordon�e en x du deuxi�me coin du rectangle
	 * @param coordonney2 coordon�e en y du deuxi�me coin du rectangle
	 * @param color couleur du rectangle
	 */
	public Rectangle(int coordonnex1, int coordonney1, int coordonnex2, int coordonney2, Color color) {
		super(color);
		this.coordonnex2 = Math.abs(coordonnex2 - coordonnex1);
		this.coordonney2 = Math.abs(coordonney2 - coordonney1);
		this.coordonnex1 = Math.min(coordonnex1, coordonnex2);
		this.coordonney1 = Math.min(coordonney1, coordonney2);
	}

	@Override
	/**
	 * Paint le rectangle sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner le rectangle
	 */
	public void paint(Graphics graphic) {
		graphic.setColor(this.getColor());
		graphic.fillRect(coordonnex1, coordonney1, coordonnex2, coordonney2);
	}

}
