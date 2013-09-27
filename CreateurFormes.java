import java.awt.Color;

import lab1.formes.*;

import ca.etsmtl.log.util.IDLogger;

public class CreateurFormes {
	
	private IDLogger logger;

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
	public Forme creerForme(String chaineForme) {
		String parts[] = chaineForme.split("\\s");
		logger.logID(Integer.parseInt(parts[0]));
		if (parts[1].equals("<LIGNE>")){
			return new Ligne(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.ORANGE);
		}
		else if (parts[1].equals("<RECTANGLE>")){
			return new Rectangle(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.CYAN);
		}
		else if (parts[1].equals("<CARRE>")){
			return new Rectangle(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.PINK);
		}
		else if (parts[1].equals("<OVALE>")){
			return new Ovale(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.BLUE);
		}
		else if (parts[1].equals("<CERCLE>")){
			return new Ovale(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Color.DARK_GRAY);
		}
		else {
			return null;
		}
	}
}