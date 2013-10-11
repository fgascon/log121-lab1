package lab1;

import java.util.regex.*;

/**
 * Classe qui g�re les ReglarExpressions
 */
public class RegEx {
	
	private String unSplit[];
	private String unMatch;
	private int unID;
	private String uneForme;
	private int coordonneex1;
	private int coordonneey1;
	private int coordonneex2;
	private int coordonneey2;
	
	/**
	 * Constructeur de la classe qui g�re les R�gularExpression
	 */
	
	public RegEx(String unString){
		unMatch = unString;
		matcher();
	}
	
	/**
	 * M�thode permettant la v�rification des expressions r�guli�res
	 * @param regex  on donne l'expression d�sir�e � v�rifier dans la string
	 * @param input on entre la String � comparer avec l'expression
	 * Ce code a �t� inspir� du site StackOverflow.com
	 */
	public void matcher(){
			
		//Constructeur de l,expression r�guli�re
		Pattern unPattern = Pattern.compile("(\\d)+\\s<(.*)>(\\s(\\d)+)+");
		
		//Constructeur du v�rificateur de l'expression r�guli�re
		Matcher unMatcher = unPattern.matcher(unMatch);
		//Si l'expression est trouv�e, on entre dans la boucle
		while (unMatcher.find()){
			//Split les informations n�c�ssaires pour les stocker correctement
			unSplit = unMatcher.group().split(" ");
			//entre le nom de la forme sans les <> qui l'entour
			this.unSplit[1] = unMatcher.group(2);
			//Convertit le String du ID en integer
			unID = Integer.parseInt(unSplit[0]);
			//l'ajout du nom sans <> dans sa variable
			uneForme = unSplit[1];
			//convertion d'un cooredonn�e String en Integer
			coordonneex1 = Integer.parseInt(unSplit[2]);
			//convertion d'un cooredonn�e String en Integer
			coordonneey1 = Integer.parseInt(unSplit[3]);
			//convertion d'un cooredonn�e String en Integer
			coordonneex2 = Integer.parseInt(unSplit[4]);
			//V�rifie si il y a 4 coordonn�es et s'il y en a 4 il va la chercher et la stock
			if (unSplit.length== 6){
				coordonneey2=Integer.parseInt(unSplit[5]);
			}
		}
		
	}
	
	/**
	 * Cette m�thode sert a retourner la position X1
	 * */
	public int getX1(){
		return coordonneex1;
	}
	
	/**
	 * Cette m�thode sert a retourner la position X2
	 * */
	public int getX2(){
		return coordonneex2;
	}
	
	/**
	 * Cette m�thode sert a retourner la position Y1
	 * */
	public int getY1(){
		return coordonneey1;
	}
	
	/**
	 * Cette m�thode sert a retourner la position Y1
	 * */
	public int getY2(){
		return coordonneey2;
	}
	
	/**
	 * Cette m�thode sert a retourner le ID de la requete
	 * */
	public int getId(){
		return unID;
	}
	
	/**
	 * Cette m�thode sert a retourner le nom de la forme � �tre cr��e
	 * */
	public String getForme(){
		return uneForme;
	}
	
}
