package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente une ligne pouvant être dessinée
 */
public class Ligne extends AbstractForme {

	private int axex1;
	private int axey1;
	private int axex2;
	private int axey2;

	/**
	 * Constructeur de la classe
	 * @param axex1 coordonée en X du point 1 de la ligne
	 * @param axey1 coordonée en Y du point 1 de la ligne
	 * @param axex2 coordonée en X du point 2 de la ligne
	 * @param axey2 coordonée en Y du point 2 de la ligne
	 * @param color couleur de la ligne
	 */
	public Ligne(int axex1, int axey1, int axex2, int axey2, Color color) {
		super(color);
		this.axex1 = axex1;
		this.axey1 = axey1;
		this.axex2 = axex2;
		this.axey2 = axey2;
	}

	@Override
	/**
	 * Paint la ligne sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner la ligne
	 */
	public void paint(Graphics graphic) {
		graphic.setColor(this.getColor());
		graphic.drawLine(axex1, axey1, axex2, axey2);
	}
}
