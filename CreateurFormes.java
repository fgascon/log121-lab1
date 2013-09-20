import java.awt.Color;

import javax.swing.JOptionPane;

import lab1.formes.*;

public class CreateurFormes {

	public CreateurFormes() {
		
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
		switch(parts[1]){
		case "<LIGNE>":
			return new Ligne(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.ORANGE);
			
		case "<RECTANGLE>":
			return new Rectangle(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.CYAN);
			
		case "<CARRE>":
			return new Rectangle(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.PINK);

		case "<OVALE>":
			return new Ovale(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5]),
					Color.BLUE);

		case "<CERCLE>":
			return new Ovale(
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Color.DARK_GRAY);
			
		default:
			return null;
		}
	}
}
