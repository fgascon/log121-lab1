package lab1;
import java.awt.Color;

import lab1.formes.*;

import ca.etsmtl.log.util.IDLogger;

/**
 * Cr�e des formes � partir d'une cha�ne de caract�re d�crivant la forme.
 */
public class CreateurFormes {
	
	/**
	 * IDLogger par lequel la classe va logger les formes d�cod�s
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
	 * Cr�e une nouvelle forme. Cette m�thode re�oit la cha�ne de caract�res
	 * provenant du serveur de formes, elle d�termine de quelle forme il s'agit
	 * et applique l'op�rateur new sur le constructeur de la forme d�sir�e.
	 * 
	 * @param chaineForme
	 *            un objet String contenant la cha�ne de caract�res qui d�crit
	 *            une forme et provenant du serveur de formes.
	 * 
	 * @return une instance d'une des sous-classes de la classe abstraite Forme
	 *         avec les param�tres pass�s par la cha�ne d'entr�e.
	 */
	public AbstractForme creerForme(String chaineForme) {
		RegEx unRegex = new RegEx(chaineForme);
		
		logger.logID(unRegex.getId());
		if (unRegex.getForme().equals(ligne)){
			return new Ligne(
					unRegex.getId(),
					Color.ORANGE,
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2());
		}
		else if (unRegex.getForme().equals(rectangle)){
			return new Rectangle(
					unRegex.getId(),
					Color.CYAN,
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2());
		}
		else if (unRegex.getForme().equals(carre)){
			return new Rectangle(
					unRegex.getId(),
					Color.PINK,
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2());
		}
		else if (unRegex.getForme().equals(ovale)){
			return new Ovale(
					unRegex.getId(),
					Color.BLUE,
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2(),
					unRegex.getY2());
		}
		else if (unRegex.getForme().equals(cercle)){
			return new Ovale(
					unRegex.getId(),
					Color.RED,
					unRegex.getX1(),
					unRegex.getY1(),
					unRegex.getX2());
		}
		else {
			return null;
		}
	}
}