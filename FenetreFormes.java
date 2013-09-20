/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

import lab1.formes.Forme;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	
	private Forme formes[];
	private int nbFormes;
	
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		formes = new Forme[10];
		nbFormes = 0;
	}
	
	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		for(int i=0; i<formes.length; i++) {
			if(formes[i] != null){
				formes[i].paint(g);
			}
		}
	}
	
	public void add(Forme forme){
		if(nbFormes<10){
			formes[nbFormes++] = forme;
		}else{
			for(int i=0; i<nbFormes-1; i++){
				formes[i] = formes[i+1];
			}
			formes[nbFormes-1] = forme;
		}
		
		//on repaint les formes
		this.repaint();
	}
	
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
}
