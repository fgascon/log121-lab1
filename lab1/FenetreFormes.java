package lab1;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import lab1.collections.*;
import javax.swing.JComponent;
import lab1.formes.AbstractForme;

/**
 * Cette fenêtre gère l'affichage des formes
 */
public class FenetreFormes extends JComponent implements Observer {

	private static final long serialVersionUID = -2262235643903749505L;
	private static final int DISTANCE_ENTRE_FORMES = 40;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension DIMENSION = new Dimension(500, 500);

	/**
	 * Array contenant les formes de la fenêtre.
	 */
	private LinkedList<AbstractForme> formes;

	/**
	 * Constructeur de la classe
	 */
	public FenetreFormes(LinkedList<AbstractForme> formes) {
		this.formes = formes;
		formes.addObserver(this);
	}

	/**
	 * Dessine toutes les formes
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		
		 //L'itérateur pour allez chercher les formes
		Iterator unIterateur = formes.getIterator();
		
		while(unIterateur.hasNext()){
			AbstractForme uneForme = (AbstractForme) unIterateur.getNext();
			uneForme.paint((Graphics2D) graphics);
		}
	}

	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver l'espace
	 * néessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return DIMENSION;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		//on dispose les formes par ordre
		Iterator iterator = formes.getIterator();
		int pos = 0;
		while(iterator.hasNext()){
			AbstractForme forme = (AbstractForme) iterator.getNext();
			forme.setCoordonnees(pos, pos);
			pos += DISTANCE_ENTRE_FORMES;
		}
		
		// on repaint les formes pour prendre en compte les changements
		this.repaint();
	}
}
