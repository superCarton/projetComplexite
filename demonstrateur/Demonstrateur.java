package demonstrateur;

import model.Box;
import model.Container;
import model.Rangeur;
import view.Boite;
import view.Fenetre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by yukikoo on 1/2/15.
 */
public class Demonstrateur {

    public static void main(String [] args) throws IOException {

        if(args.length != 1){
            System.out.println("aucun argument, attendu: nom du fichier");
            return;
        }
        String fileSrc = args[0];
        System.out.println(fileSrc);
        File file = new File(fileSrc);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String containerSizeString = br.readLine();
        String listBoxStringPack = br.readLine();
        br.close();
        fr.close();

        List<Box> listBox = new LinkedList<>();

        String[] containerSize = containerSizeString.split("x");
        String[] listBoxString = listBoxStringPack.split(",");
        for(String boxString: listBoxString){
            String[] boxSize = boxString.split("x");
            listBox.add(new Box(Integer.valueOf(boxSize[0]), Integer.valueOf(boxSize[1])));
        }

        Rangeur r = new Rangeur(listBox, Integer.valueOf(containerSize[0]), Integer.valueOf(containerSize[1]));
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
