package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

import lab1.math.Vecteur;

/**
 * Repr�sente une ligne pouvant �tre dessin�e
 */
public class Ligne extends AbstractForme {
	
	/**
	 * La position du d�but de la ligne relative aux coordonn�es de la forme
	 */
	private Vecteur debut;
	
	/**
	 * La position de la fin de la ligne relative aux coordonn�es de la forme
	 */
	private Vecteur fin;
	
	/**
	 * Constructeur de la classe
	 * @param numSequence num�ro de s�quence
	 * @param color couleur de la ligne
	 * @param debut coordon�e du point 1 de la ligne
	 * @param fin coordon�e du point 2 de la ligne
	 */
	public Ligne(int numSequence, Color color, Vecteur debut, Vecteur fin) {
		super(numSequence, color, debut.getMin(fin));
		this.debut = debut.substract(getCoordonnees());
		this.fin = fin.substract(getCoordonnees());
	}
	
	@Override
	/**
	 * Paint la ligne sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner la ligne
	 */
	public void drawForme(Graphics graphic) {
		Vecteur debutAbsolu = debut.substract(getCoordonnees());
		Vecteur finAbsolu = fin.substract(getCoordonnees());
		graphic.drawLine(debutAbsolu.getX(), debutAbsolu.getY(), finAbsolu.getX(), finAbsolu.getY());
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
