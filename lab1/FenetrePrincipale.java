package lab1;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import lab1.formes.Forme;

/**
 * Cette classe repr�sente la fen�tre principale de l'application
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = -1210804336046370508L;

	/**
	 * La fen�tre de formes qui va afficher les formes.
	 */
	private FenetreFormes fenetreFormes;
	
	/**
	 * Le cr�ateur de formes qui va cr�er des formes en fonctions des messages
	 * re�u du serveur.
	 */
	private CreateurFormes createurFormes;

	/**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm) {
		this.createurFormes = new CreateurFormes();

		MenuFenetre menu = new MenuFenetre(comm);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);

		fenetreFormes = new FenetreFormes();
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fen�tre de
														// forme � la fen�tre
														// principale

		this.pack(); // Ajuste la dimension de la fen�tre principale selon celle
						// de ses composants
		this.setVisible(true); // Rend la fen�tre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Appel� lorsque le sujet lance "firePropertyChanger".
	 * Cette m�thode va recevoir les �v�nements �mises par CommBase, va
	 * d�cortiquer la cha�ne re�u du serveur via le createurFormes, puis
	 * va l'ajouter � la fen�tre de formes.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		if (arg0.getPropertyName().equals("SERVER-MSG")) {
			String ligneRecu = (String) arg0.getNewValue();
			System.out.print(ligneRecu);

			if (ligneRecu != null) {
				// on cr�e la forme � partir de la ligne re�u
				Forme forme = createurFormes.creerForme(ligneRecu);

				// On ajoute la forme � la fen�tre
				fenetreFormes.add(forme);
			}
		}
	}
}
