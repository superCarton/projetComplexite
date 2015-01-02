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

}
