package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yukikoo on 1/2/15.
 */
public class Rangeur {

    private List<Box> listBox;

    public List<Container> getContainers() {
        return containers;
    }

    private List<Container> containers = new LinkedList<Container>();
    private int xSize;
    private int ySize;

    @Override
    public String toString(){
        String str = "======================================\nAu total, "+containers.size()+" boites ont été utilisée\n";
        str += "Detail de chacune des boites: \n";
        int numero = 1;
        for(Container container: containers){
            str += "Boite n°"+numero+" :";
            for (Box box : container.getRangement())
            {
                str += box;
            }
            numero++;
        }
        str += "===================================\n";
        return str;
    }

    public Rangeur(List<Box> box, int xSize, int ySize){

        this.listBox = box;
        this.xSize = xSize;
        this.ySize = ySize;
        listBox.sort(new BoxComparer());

        for(Box b: listBox){
            System.out.println(b);
            if(b.getX() > xSize || b.getY() > ySize){
                throw new RuntimeException("La boite est plus grande que le conteneur, c'est n'importe quoi");
            }
        }

    }

    public boolean rentre(Box b, int x, int y){
        return b.getX() <= x && b.getY() <= y;
    }

    public Box getBiggestFittingBox(int x, int y){
        Box biggestBox = null;
        for(Box b: listBox){
            if((biggestBox == null || b.size() > biggestBox.size() ) && rentre(b, x, y)){
                biggestBox = b;
            }
        }
        listBox.remove(biggestBox);
        return biggestBox;
    }

    public void ranger(){
        boolean finish;
        do {
            Container container = new Container(xSize, ySize);
            finish = ranger(container, new Point(0, 0), new Point(xSize, ySize));
            containers.add(container);
        }while(!finish);

    }

    private boolean ranger(Container container, Point leftTop, Point rightBottom){
        int currentSubContainerXSize = leftTop.getX() - rightBottom.getX();
        int currentSubContainerYSize = leftTop.getY() - rightBottom.getY();
        if(currentSubContainerXSize < 0){
            currentSubContainerXSize*=-1;
        }
        if(currentSubContainerYSize < 0){
            currentSubContainerYSize*=-1;
        }
        Box box = getBiggestFittingBox(currentSubContainerXSize,currentSubContainerYSize);
        if(box == null){
            return false;
        }

        List<Box> rangement = container.getRangement();
        box.setPosition(leftTop);
        rangement.add(box);
        container.setRangement(rangement);

        if(listBox.isEmpty()){
            return true;
        }else{

            Point newLeftTop1 = new Point(leftTop.getX(), leftTop.getY() + box.getY() );
            if(ranger(container, newLeftTop1, rightBottom)){
                return true;
            }
            Point newLeftTop2 = new Point(leftTop.getX() + box.getX(), leftTop.getY());
            Point newRightBottom2 = new Point(rightBottom.getX(), leftTop.getY() + box.getY());
            return ranger(container, newLeftTop2, newRightBottom2);

        }


    }


}
