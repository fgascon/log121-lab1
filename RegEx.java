//Classe qui g�re les ReglarExpressions

import java.util.regex.*;

public class RegEx {
	private static String unSplit[];
	private static String unMatch;
	private static int unID;
	private static String uneForme;
	private static int x1;
	private static int y1;
	private static int x2;
	private static int y2;
	
	/**Constructeur de la classe qui g�re les R�gularExpressions*/
	
	public  RegEx(String unString){
		unMatch = unString;
		matcher();
	}
	/** M�thode permettant la v�rification des expressions r�guli�re
	 * @param regex  on donne l'expression d�sir�e a v�rifi�e dans la string
	 * @param input on entre la String a comparer avec l'expression
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
				RegEx.unSplit[1] = unMatcher.group(2);
				//Convertit le String du ID en integer
				unID=Integer.parseInt(unSplit[0]);
				//l'ajout du nom sans <> dans sa variable
				uneForme=unSplit[1];
				//convertion d'un cooredonn�e String en Integer
				x1=Integer.parseInt(unSplit[2]);
				//convertion d'un cooredonn�e String en Integer
				y1=Integer.parseInt(unSplit[3]);
				//convertion d'un cooredonn�e String en Integer
				x2=Integer.parseInt(unSplit[4]);
				//V�rifie si il y a 4 coordonn�es et s'il y en a 4 il va la chercher et la stock
				if (unSplit.length== 6){
					y2=Integer.parseInt(unSplit[5]);
				}
			}
			
			
			
			
		}
	/**
	 * Cette M�thode sert a retourn�e la position X1
	 * */
	public static int getX1(){
		return x1;
	}
	/**
	 * Cette M�thode sert a retourn�e la position X2
	 * */
	public static int getX2(){
		return x2;
	}
	/**
	 * Cette M�thode sert a retourn�e la position Y1
	 * */
	public static int getY1(){
		return y1;
	}
	/**
	 * Cette M�thode sert a retourn�e la position Y1
	 * */
	public static int getY2(){
		return y2;
	}
	/**
	 * Cette M�thode sert a retourn�e le ID de la requete
	 * */
	public static int getId(){
		return unID;
	}
	/**
	 * Cette M�thode sert a retourn�e le nom de la forme a �tre cr��e
	 * */
	public static String getForme(){
		return uneForme;
	}
	
}
