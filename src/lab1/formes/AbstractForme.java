package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe abstraite repr�sentant une forme pouvant etre affich�e.
 */
public abstract class AbstractForme {

	private Color color;

	/**
	 * Constructeur de la classe
	 * @param color la couleur de la forme
	 */
	public AbstractForme(Color color) {
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
	 * @param Graphic Graphics sur lequel dessiner la forme
	 */
	public abstract void paint(Graphics Graphic);
}
