//Classe qui gère les ReglarExpressions

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
	
	/**Constructeur de la classe qui gère les RégularExpressions*/
	
	public  RegEx(String unString){
		unMatch = unString;
		matcher();
	}
	/** Méthode permettant la vérification des expressions régulière
	 * @param regex  on donne l'expression désirée a vérifiée dans la string
	 * @param input on entre la String a comparer avec l'expression
	 * Ce code a été inspiré du site StackOverflow.com
	 */
	public void matcher(){
			
			//Constructeur de l,expression régulière
			Pattern unPattern = Pattern.compile("(\\d)+\\s<(.*)>(\\s(\\d)+)+");
			
			//Constructeur du vérificateur de l'expression régulière
			Matcher unMatcher = unPattern.matcher(unMatch);
			//Si l'expression est trouvée, on entre dans la boucle
			while (unMatcher.find()){
				//Split les informations nécéssaires pour les stocker correctement
				unSplit = unMatcher.group().split(" ");
				//entre le nom de la forme sans les <> qui l'entour
				RegEx.unSplit[1] = unMatcher.group(2);
				//Convertit le String du ID en integer
				unID=Integer.parseInt(unSplit[0]);
				//l'ajout du nom sans <> dans sa variable
				uneForme=unSplit[1];
				//convertion d'un cooredonnée String en Integer
				x1=Integer.parseInt(unSplit[2]);
				//convertion d'un cooredonnée String en Integer
				y1=Integer.parseInt(unSplit[3]);
				//convertion d'un cooredonnée String en Integer
				x2=Integer.parseInt(unSplit[4]);
				//Vérifie si il y a 4 coordonnées et s'il y en a 4 il va la chercher et la stock
				if (unSplit.length== 6){
					y2=Integer.parseInt(unSplit[5]);
				}
			}
			
			
			
			
		}
	/**
	 * Cette Méthode sert a retournée la position X1
	 * */
	public static int getX1(){
		return x1;
	}
	/**
	 * Cette Méthode sert a retournée la position X2
	 * */
	public static int getX2(){
		return x2;
	}
	/**
	 * Cette Méthode sert a retournée la position Y1
	 * */
	public static int getY1(){
		return y1;
	}
	/**
	 * Cette Méthode sert a retournée la position Y1
	 * */
	public static int getY2(){
		return y2;
	}
	/**
	 * Cette Méthode sert a retournée le ID de la requete
	 * */
	public static int getId(){
		return unID;
	}
	/**
	 * Cette Méthode sert a retournée le nom de la forme a être créée
	 * */
	public static String getForme(){
		return uneForme;
	}
	
}
