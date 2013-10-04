package lab1;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date crÃ©Ã©: 2013-05-03
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
 * Cette classe représente la fenêtre principale de l'application
 * 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = -1210804336046370508L;

	/**
	 * La fenêtre de formes qui va afficher les formes.
	 */
	private FenetreFormes fenetreFormes;
	
	/**
	 * Le créateur de formes qui va créer des formes en fonctions des messages
	 * reçu du serveur.
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
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de
														// forme à la fenêtre
														// principale

		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle
						// de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Appelé lorsque le sujet lance "firePropertyChanger".
	 * Cette méthode va recevoir les évènements émises par CommBase, va
	 * décortiquer la chaîne reçu du serveur via le createurFormes, puis
	 * va l'ajouter à la fenêtre de formes.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

		if (arg0.getPropertyName().equals("SERVER-MSG")) {
			String ligneRecu = (String) arg0.getNewValue();
			System.out.print(ligneRecu);

			if (ligneRecu != null) {
				// on crée la forme à partir de la ligne reçu
				Forme forme = createurFormes.creerForme(ligneRecu);

				// On ajoute la forme à la fenêtre
				fenetreFormes.add(forme);
			}
		}
	}
}
