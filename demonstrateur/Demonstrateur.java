package demonstrateur;

import model.Box;
import model.Rangeur;

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
    }
}
