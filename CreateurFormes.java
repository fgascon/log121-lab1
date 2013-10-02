import java.awt.Color;

import lab1.formes.*;

import ca.etsmtl.log.util.IDLogger;


public class CreateurFormes {
	
	private IDLogger logger;
	RegEx unRegex;
	final String carre = "CARRE";
	final String rectangle = "RECTANGLE";
	final String cercle = "CERCLE";
	final String ligne = "LIGNE";
	final String ovale = "OVALE";

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
	 *         avec les paramètres passés par la chaêne d'entrée.
	 */
	public Forme creerForme(String chaineForme) {
		this.unRegex = new RegEx(chaineForme);
		//String parts[] = chaineForme.split("\\s");
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