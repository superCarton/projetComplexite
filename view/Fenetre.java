package view;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = -1673052513013997822L;
	private List<Boite> boites = new LinkedList<Boite>();
	
	JPanel container = new JPanel();
	
	public Fenetre(List<Boite> b){
		
		super("Projet complexite : nombre de boites = " + b.size());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boites = b;
		
		container.setLayout(new WrapLayout());
		for (Boite bo : boites){
			Border padding = BorderFactory.createEmptyBorder(10, 30, 10, 30);
		    bo.setBorder(padding);
			container.add(bo);

		}

		Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		JScrollPane scrollPane = new JScrollPane(container);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(container);
		setContentPane(scrollPane);
		setPreferredSize(new Dimension((int) tailleEcran.getWidth(), (int) tailleEcran.getHeight()));
	    pack();
	    setVisible(true);
		setLocationRelativeTo(null);
	}

}
