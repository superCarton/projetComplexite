package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = -1673052513013997822L;
	private List<Boite> boites = new LinkedList<Boite>();
	
	JPanel container = new JPanel();
	
	public Fenetre(List<Boite> b){
		
		super("Projet complexite : nombre de boites = " + b.size());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boites = b;
		
		container.setLayout(new FlowLayout(50, 50, 20));
		for (Boite bo : boites){
			Border padding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
		    bo.setBorder(padding);
			container.add(bo);
		}
		
		setContentPane(container);
		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension((int)tailleEcran.getWidth(), (int)tailleEcran.getHeight()));
	    pack();
	    setVisible(true);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String args[]){

		List<int[]> l1 = new LinkedList<int[]>();
		int[] r1 = {2, 1, 0, 0};
		l1.add(r1);
		int[] r2 = {1, 2, 0, 1};
		l1.add(r2);
		int[] r3 = {1, 2, 1, 1};
		l1.add(r3);
		int[] r4 = {1, 1, 2, 2};
		l1.add(r4);
		Boite b1 = new Boite(3, 3, l1);
		List<Boite> boites =new LinkedList<Boite>();
		boites.add(b1);
		new Fenetre(boites);
	}

}
