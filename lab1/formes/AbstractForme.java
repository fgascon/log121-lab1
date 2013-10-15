package lab1.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import lab1.math.Vecteur;

/**
 * Classe abstraite représentant une forme pouvant etre affichée.
 */
public abstract class AbstractForme {

	final static float DASHED_LINE[] = {10.0f};
	final static BasicStroke DASHED_STROKE = new BasicStroke(1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            10.0f, DASHED_LINE, 0.0f);

	private Vecteur coordonnees;
	private Color color;
	private int numSequence;

	/**
	 * Constructeur de la classe
	 * @param color la couleur de la forme
	 */
	public AbstractForme(int numSequence, Color color, Vecteur coordonnees) {
		this.numSequence = numSequence;
		this.color = color;
		this.coordonnees = coordonnees;
	}

	/**
	 * @return la couleur de la forme
	 */
	public Color getColor() {
		return this.color;
	}
	
	public int getNumSequence(){
		return numSequence;
	}
	
	public Vecteur getCoordonnees() {
		return coordonnees;
	}
	
	public void setCoordonnees(Vecteur coordonnees) {
		this.coordonnees = coordonnees;
	}
	
	public void setCoordonnees(int x, int y) {
		setCoordonnees(new Vecteur(x, y));
	}
	
	public abstract String getType();

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
		Vecteur size = this.getSize();
		graphics.drawRect(getCoordonnees().getX()-1, getCoordonnees().getY()-1, size.getX()+1, size.getY()+1);
		graphics.setStroke(normalStroke);
	}

	protected abstract void drawForme(Graphics graphics);

	protected abstract Vecteur getSize();
	
	public abstract float getMaxDistance();
	
	public abstract float getAire();
}
