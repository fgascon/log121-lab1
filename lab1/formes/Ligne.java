package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

import lab1.math.Vecteur;

/**
 * Représente une ligne pouvant être dessinée
 */
public class Ligne extends AbstractForme {
	
	/**
	 * La position du début de la ligne relative aux coordonnées de la forme
	 */
	private Vecteur debut;
	
	/**
	 * La position de la fin de la ligne relative aux coordonnées de la forme
	 */
	private Vecteur fin;
	
	/**
	 * Constructeur de la classe
	 * @param numSequence numéro de séquence
	 * @param color couleur de la ligne
	 * @param debut coordonée du point 1 de la ligne
	 * @param fin coordonée du point 2 de la ligne
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
