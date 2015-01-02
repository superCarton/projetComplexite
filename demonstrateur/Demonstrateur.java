package demonstrateur;

import model.Box;
import model.Container;
import model.Rangeur;
import view.Boite;
import view.Fenetre;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yukikoo on 1/2/15.
 */
public class Demonstrateur {

    public static void main(String [] args){
        List<Box> listBox = new LinkedList<>();
        listBox.add(new Box(1,2));
        listBox.add(new Box(1,2));
        listBox.add(new Box(2,1));
        listBox.add(new Box(2,1));
        listBox.add(new Box(1,1));
        Rangeur r = new Rangeur(listBox, 3, 3);
        r.ranger();
        System.out.println(r);


        List<Boite> boites =new LinkedList<>();
        for(Container container: r.getContainers()){
            List<int[]> boitesGraphique = new LinkedList<>();
            for(Box box: container.getRangement()){
                int[] b = new int[4];
                b[0] = box.getX();
                b[1] = box.getY();
                b[2] = box.getPosition().getX();
                b[3] = box.getPosition().getY();
                boitesGraphique.add(b);
            }
            Boite b = new Boite(container.getX(), container.getY(), boitesGraphique);
            boites.add(b);
        }
        new Fenetre(boites);
    }
}
