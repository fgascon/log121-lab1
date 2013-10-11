package lab1.formes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Représente un ovale pouvant être dessiné.
 */
public class Ovale extends AbstractForme {

	private int coordonneex;
	private int coordonneey;
	private int width;
	private int height;

	/**
	 * Constructeur prennant un seul rayon pour représenter un cercle
	 * @param coordonneex coordonée en x du centre
	 * @param coordonneey coordonée en y du centre
	 * @param rayon rayon du cercle
	 * @param color couleur du cercle
	 */
	public Ovale(int coordonneex, int coordonneey, int rayon, Color color) {
		this(coordonneex, coordonneey, rayon, rayon, color);
	}

	/**
	 * Constructeur prennant 2 rayons pour représenter un ovale
	 * @param coordonneex coordonée en x du centre
	 * @param coordonneey coordonée en y du centre
	 * @param rayonH rayon horizontal
	 * @param rayonV rayon vertical
	 * @param color couleur de l'ovale
	 */
	public Ovale(int coordonneex, int coordonneey, int rayonH, int rayonV, Color color) {
		super(color);
		this.coordonneex = coordonneex - rayonH;
		this.coordonneey = coordonneey - rayonV;
		this.width = rayonH * 2;
		this.height = rayonV * 2;
	}

	@Override
	/**
	 * Paint l'ovale sur un object Graphics.
	 * 
	 * @param g Graphics sur lequel dessiner l'ovale
	 */
	public void drawForme(Graphics graphic) {
		graphic.fillOval(coordonneex, coordonneey, width, height);
	}

	@Override
	protected void drawOutbound(Graphics graphics) {
		graphics.drawRect(coordonneex, coordonneey, width, height);
	}

	@Override
	public float getMaxDistance() {
		return Math.max(width, height);
	}

	@Override
	public float getAire() {
		//L'aire d'un ovale = PI * width/2 * height/2
		return (float) (Math.PI * width * height / 4);
	}

	@Override
	public String getType() {
		return width == height ? "cercle" : "ovale";
	}
}
