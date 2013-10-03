
import java.util.regex.*;

/**
 * Classe qui gère les ReglarExpressions
 */
public class RegEx {
	
	private String unSplit[];
	private String unMatch;
	private int unID;
	private String uneForme;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	/**
	 * Constructeur de la classe qui gère les RégularExpression
	 */
	
	public RegEx(String unString){
		unMatch = unString;
		matcher();
	}
	
	/**
	 * Méthode permettant la vérification des expressions régulières
	 * @param regex  on donne l'expression désirée à vérifier dans la string
	 * @param input on entre la String à comparer avec l'expression
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
			this.unSplit[1] = unMatcher.group(2);
			//Convertit le String du ID en integer
			unID = Integer.parseInt(unSplit[0]);
			//l'ajout du nom sans <> dans sa variable
			uneForme = unSplit[1];
			//convertion d'un cooredonnée String en Integer
			x1 = Integer.parseInt(unSplit[2]);
			//convertion d'un cooredonnée String en Integer
			y1 = Integer.parseInt(unSplit[3]);
			//convertion d'un cooredonnée String en Integer
			x2 = Integer.parseInt(unSplit[4]);
			//Vérifie si il y a 4 coordonnées et s'il y en a 4 il va la chercher et la stock
			if (unSplit.length== 6){
				y2=Integer.parseInt(unSplit[5]);
			}
		}
		
	}
	
	/**
	 * Cette méthode sert a retourner la position X1
	 * */
	public int getX1(){
		return x1;
	}
	
	/**
	 * Cette méthode sert a retourner la position X2
	 * */
	public int getX2(){
		return x2;
	}
	
	/**
	 * Cette méthode sert a retourner la position Y1
	 * */
	public int getY1(){
		return y1;
	}
	
	/**
	 * Cette méthode sert a retourner la position Y1
	 * */
	public int getY2(){
		return y2;
	}
	
	/**
	 * Cette méthode sert a retourner le ID de la requete
	 * */
	public int getId(){
		return unID;
	}
	
	/**
	 * Cette méthode sert a retourner le nom de la forme à être créée
	 * */
	public String getForme(){
		return uneForme;
	}
	
}
