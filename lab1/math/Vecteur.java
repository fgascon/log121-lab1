package lab1.math;

public class Vecteur {

	private int x;
	private int y;
	
	public Vecteur(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public float getDistance(Vecteur vector2) {
		Vecteur delta = substract(vector2);
		return (float) Math.sqrt(delta.getX()*delta.getX() + delta.getY()*delta.getY());
	}
	
	public Vecteur substract(Vecteur vector2) {
		return new Vecteur(vector2.getX() - this.getX(), vector2.getY() - this.getY());
	}
	
	public float getNorme() {
		return (float) Math.sqrt(getX()*getX() + getY()*getY());
	}
	
	public Vecteur getAbs() {
		return new Vecteur(Math.abs(getX()), Math.abs(getY()));
	}
	
	public Vecteur getMin(Vecteur vector2) {
		return new Vecteur(Math.min(getX(), vector2.getX()), Math.min(getY(), vector2.getY()));
	}
}
