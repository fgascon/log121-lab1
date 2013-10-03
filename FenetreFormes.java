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
import javax.swing.JComponent;
import lab1.formes.Forme;

/**
 * Cette fen�tre g�re l'affichage des formes
 */
public class FenetreFormes extends JComponent {

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500, 500);
	private static final int MAX_FORMS = 10;

	/**
	 * Array contenant les formes de la fen�tre.
	 */
	private Forme formes[];
	
	/**
	 * Le nombre de formes pr�sentement dans la fen�tre
	 */
	private int nbFormes;

	/**
	 * Constructeur de la classe
	 */
	public FenetreFormes() {
		formes = new Forme[10];
		nbFormes = 0;
	}

	/**
	 * Dessine toutes les formes
	 */
	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < formes.length; i++) {
			if (formes[i] != null) {
				formes[i].paint(g);
			}
		}
	}

	/**
	 * Ajouter une forme � la fen�tre. Cette m�thode va s'assurer qu'il n'y
	 * ait pas plus que le nombre maximal de formes Dans la fen�tre. Elle
	 * va automatiquement provoquer un repaint pour afficher les chagements.
	 * @param forme la forme � ajouter
	 */
	public void add(Forme forme) {
		if (nbFormes < MAX_FORMS) {
			formes[nbFormes++] = forme;
		} else {
			for (int i = 0; i < nbFormes - 1; i++) {
				formes[i] = formes[i + 1];
			}
			formes[nbFormes - 1] = forme;
		}

		// on repaint les formes pour prendre en compte les changements
		this.repaint();
	}

	/**
	 * Le Layout qui utilise (contient) FenetreFormes doit r�server l'espace
	 * n�essaire � son affichage
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}
}
