package lab1;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date cr��: 2013-05-03
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
 * Cette fen�tre g�re l'affichage des formes
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension DIMENSION = new Dimension(500, 500);
	private static final int MAX_FORMS = 10;

	/**
	 * Array contenant les formes de la fen�tre.
	 */
	private LinkedList<AbstractForme> formes = new LinkedList<AbstractForme>(MAX_FORMS);
	
	
	/**
	 * Le nombre de formes pr�sentement dans la fen�tre
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
		
		 //L'it�rateur pour allez chercher les formes
		 	
		Iterator unIterateur = formes.getIterator();
		
		while(unIterateur.hasNext()){
			AbstractForme uneForme = (AbstractForme) unIterateur.getNext();
			uneForme.paint((Graphics2D) graphics);
		}
	}

	/**
	 * Ajouter une forme � la fen�tre. Cette m�thode va s'assurer qu'il n'y
	 * ait pas plus que le nombre maximal de formes Dans la fen�tre. Elle
	 * va automatiquement provoquer un repaint pour afficher les chagements.
	 * @param forme la forme � ajouter
	 */
	public void add(AbstractForme forme) {
		formes.add(forme);

		// on repaint les formes pour prendre en compte les changements
		this.repaint();
	}

	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit r�server l'espace
	 * n�essaire � son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return DIMENSION;
	}
}
