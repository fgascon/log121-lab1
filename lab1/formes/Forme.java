package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe abstraite représentant une forme pouvant etre affichée.
 */
public abstract class Forme {

	private Color color;

	/**
	 * Constructeur de la classe
	 * @param color la couleur de la forme
	 */
	public Forme(Color color) {
		this.color = color;
	}

	/**
	 * @return la couleur de la forme
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Paint la forme sur un object Graphics.
	 * Cette méthode doit être implémenté dans les classes concrètes.
	 * 
	 * @param graphics Graphics sur lequel dessiner la forme
	 */
	public void paint(Graphics graphics){
		graphics.setColor(this.getColor());
		this.drawForme(graphics);
		graphics.setColor(Color.GRAY);
		//graphics.setStroke();
		this.drawOutbound(graphics);
	}

	protected abstract void drawForme(Graphics graphics);

	protected abstract void drawOutbound(Graphics graphics);
}
