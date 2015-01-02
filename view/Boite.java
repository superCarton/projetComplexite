import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class Boite extends JPanel{

	private static final long serialVersionUID = -4249700837193975502L;
	private static final int coefMultPixel = 50;
	private int hauteur = 1;
	private int largeur = 1;
	private int nombreRect = 0;
	private List<Rect> rectangles = new LinkedList<Rect>();
	
	public Boite(int n, int m, List<int[]> rects){
		
		largeur = n;
		hauteur = m;
		setPreferredSize(new Dimension(n*coefMultPixel, m*coefMultPixel));
		setBackground(Color.WHITE);
		setBounds(100,10,140,80);
		
		
		for(int[] elems : rects) {
			Rect rectangle = new Rect(elems[0], elems[1], getCouleurRect(nombreRect), elems[2], elems[3]);
			rectangles.add(rectangle);
			nombreRect++;
		}
		
	}
	
	public void paint(Graphics g) {
			
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, largeur*coefMultPixel, hauteur*coefMultPixel);
		
		for (Rect r : rectangles){
			g.setColor(r.getColor());
			g.fillRect(r.getX()*coefMultPixel, r.getY()*coefMultPixel, r.getLargeur()*coefMultPixel, r.getHauteur()*coefMultPixel);
		}
		
		g.setColor(c);
		
	}
	
	private Color getCouleurRect(int n){
		
		List<Color> liste = new LinkedList<Color>();
		liste.add(Color.BLUE);
		liste.add(Color.GRAY);
		liste.add(Color.GREEN);
		liste.add(Color.BLACK);
		liste.add(Color.MAGENTA);
		liste.add(Color.ORANGE);
		liste.add(Color.YELLOW);
		liste.add(Color.CYAN);
		liste.add(Color.RED);
		liste.add(Color.DARK_GRAY);
		
		return liste.get(n % 10);
	}
}
