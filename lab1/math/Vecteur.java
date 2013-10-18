package lab1.math;

public class Vecteur {

	/**
	 * Composante en x du vecteur
	 */
	private int composantex;
	
	/**
	 * Composante en y du vecteur
	 */
	private int composantey;
	
	/**
	 * @param compox Composante en x du vecteur
	 * @param compoy Composante en y du vecteur
	 */
	public Vecteur(int compox, int compoy) {
		this.composantex = compox;
		this.composantey = compoy;
	}
	
	/**
	 * @return Composante en x du vecteur
	 */
	public int getX() {
		return composantex;
	}
	
	/**
	 * Modifier la composante en x du vecteur
	 * @param compox Composante en x du vecteur
	 */
	public void setX(int compox) {
		this.composantex = compox;
	}
	
	/**
	 * @return Composante en y du vecteur
	 */
	public int getY() {
		return composantey;
	}
	
	/**
	 * Modifier la composante en y du vecteur
	 * @param compoy Composante en y du vecteur
	 */
	public void setY(int compoy) {
		this.composantey = compoy;
	}
	
	/**
	 * Calcul la distance entre les points représenté par les 2 vecteurs
	 * @param vecteur2
	 * @return 
	 */
	public float getDistance(Vecteur vecteur2) {
		return this.substract(vecteur2).getNorme();
	}
	
	/**
	 * Somme avec un autre vecteur
	 * @param vecteur2 vecteur à additionner
	 * @return nouveau vecteur, somme des 2 vecteurs
	 */
	public Vecteur add(Vecteur vecteur2) {
		return new Vecteur(getX() + vecteur2.getX(), getY() + vecteur2.getY());
	}
	
	/**
	 * Différence avec un autre vecteur
	 * @param vecteur2 vecteur à soustraire
	 * @return nouveau vecteur, différence des 2 vecteurs
	 */
	public Vecteur substract(Vecteur vecteur2) {
		return new Vecteur(vecteur2.getX() - this.getX(), vecteur2.getY() - this.getY());
	}
	
	/**
	 * Norme. Longueur du vecteur
	 * @return La norme du vecteur
	 */
	public float getNorme() {
		return (float) Math.sqrt(getX()*getX() + getY()*getY());
	}
	
	/**
	 * Valeur absolue du vecteur
	 * @return un nouveau vecteur avec la valeur absolue des composants du vecteur actuel
	 */
	public Vecteur getAbs() {
		return new Vecteur(Math.abs(getX()), Math.abs(getY()));
	}
	
	/**
	 * Minimum
	 * @param vecteur2 vecteur avec lequel comparer
	 * @return un nouveau vecteur avec les plus petites valeurs des composantes des 2 vecteurs
	 */
	public Vecteur getMin(Vecteur vecteur2) {
		return new Vecteur(Math.min(getX(), vecteur2.getX()), Math.min(getY(), vecteur2.getY()));
	}
}
