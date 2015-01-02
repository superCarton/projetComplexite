package view;

import java.awt.Color;

public class Rect {

	private int largeur = 1;
	private int hauteur = 1;
	private int x = 0;
	private int y = 0;
	private Color couleur = Color.BLACK;
	
	public Rect(int l, int h, Color c, int x, int y){
		
		this.largeur = l;
		this.hauteur = h;
		couleur = c;
		this.x = x;
		this.y = y;
		
	}
	
	public Color getColor(){
		return couleur;
	}
	
	public int getLargeur(){
		return largeur;
	}
	
	public int getHauteur(){
		return hauteur;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
