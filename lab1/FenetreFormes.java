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
import lab1.collections.*;
import javax.swing.JComponent;
import lab1.formes.AbstractForme;

/**
 * Cette fenêtre gère l'affichage des formes
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension DIMENSION = new Dimension(500, 500);
	private static final int MAX_FORMS = 10;

	/**
	 * Array contenant les formes de la fenêtre.
	 */
	private LinkedList<AbstractForme> formes = new LinkedList<AbstractForme>(MAX_FORMS);
	
	
	/**
	 * Le nombre de formes présentement dans la fenêtre
	 */
	private int nbFormes;

	/**
	 * Constructeur de la classe
	 */
	public FenetreFormes() {
		nbFormes = 0;
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
	 * Ajouter une forme à la fenêtre. Cette méthode va s'assurer qu'il n'y
	 * ait pas plus que le nombre maximal de formes Dans la fenêtre. Elle
	 * va automatiquement provoquer un repaint pour afficher les chagements.
	 * @param forme la forme à ajouter
	 */
	public void add(AbstractForme forme) {
		formes.add(forme);

		// on repaint les formes pour prendre en compte les changements
		this.repaint();
	}

	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver l'espace
	 * néessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return DIMENSION;
	}
}
