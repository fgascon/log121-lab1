package laboratoire1main;
import java.awt.Color;

import lab1.formes.*;

import ca.etsmtl.log.util.IDLogger;

/**
 * Crée des formes à partir d'une chaîne de caractère décrivant la forme.
 */
public class CreateurFormes {
	
	/**
	 * IDLogger par lequel la classe va logger les formes décodés
	 */
	private IDLogger logger;
	
	final String carre = "CARRE";
	final String rectangle = "RECTANGLE";
	final String cercle = "CERCLE";
	final String ligne = "LIGNE";
	final String ovale = "OVALE";

	/**
	 * Constructeur de la classe
	 */
	public CreateurFormes() {
		this.logger = IDLogger.getInstance();
	}

	/**
	 * Crée une nouvelle forme. Cette méthode reçoit la chaîne de caractères
	 * provenant du serveur de formes, elle détermine de quelle forme il s'agit
	 * et applique l'opérateur new sur le constructeur de la forme désirée.
	 * 
	 * @param chaineForme
	 *            un objet String contenant la chaîne de caractères qui décrit
	 *            une forme et provenant du serveur de formes.
	 * 
	 * @return une instance d'une des sous-classes de la classe abstraite Forme
	 *         avec les paramêtres passés par la chaîne d'entrée.
	 */
	public AbstractForme creerForme(String chaineForme) {
		RegEx unRegex = new RegEx(chaineForme);
		
		logger.logID(unRegex.getId());
		if (unRegex.getForme().equals(ligne)){
			return new Ligne(
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2(),
					Color.ORANGE);
		}
		else if (unRegex.getForme().equals(rectangle)){
			return new Rectangle(
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2(),
					Color.CYAN);
		}
		else if (unRegex.getForme().equals(carre)){
			return new Rectangle(
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2(),
					Color.PINK);
		}
		else if (unRegex.getForme().equals(ovale)){
			return new Ovale(
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2(),
					Color.BLUE);
		}
		else if (unRegex.getForme().equals(cercle)){
			return new Ovale(
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					Color.DARK_GRAY);
		}
		else {
			return null;
		}
	}
}