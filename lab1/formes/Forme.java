package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe abstraite repr�sentant une forme pouvant etre affich�e.
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
	 * Cette m�thode doit �tre impl�ment� dans les classes concr�tes.
	 * 
	 * @param g Graphics sur lequel dessiner la forme
	 */
	public abstract void paint(Graphics g);
}
