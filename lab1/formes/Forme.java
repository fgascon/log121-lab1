package lab1.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 * Classe abstraite représentant une forme pouvant etre affichée.
 */
public abstract class Forme {

	final static float DASHED_LINE[] = {10.0f};
	final static BasicStroke DASHED_STROKE = new BasicStroke(1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f, DASHED_LINE, 0.0f);

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
	public void paint(Graphics2D graphics){
		Stroke normalStroke = graphics.getStroke();
		
		graphics.setColor(this.getColor());
		this.drawForme(graphics);
		
		graphics.setColor(Color.GRAY);
		graphics.setStroke(DASHED_STROKE);
		this.drawOutbound(graphics);
		graphics.setStroke(normalStroke);
	}

	protected abstract void drawForme(Graphics graphics);

	protected abstract void drawOutbound(Graphics graphics);
}
