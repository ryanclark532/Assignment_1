import java.util.ArrayList;
import java.util.ListIterator;

public class Car {
    String type;
    double currentSpeed;
    double speedModifier;
    double x,y;
    RoadList roadList;
    public static void main(String[] args) {

    }

    public  Car(String type, double currentSpeed, int x, int y,RoadList roadList) {
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.roadList=roadList;
    }
    public void speedUp(){
        this.currentSpeed=60;
    }
    public void slowDown(){
        this.currentSpeed=0;
    }

    public void updatePosition(Road road){
        ListIterator<Road> iterator=this.roadList.index.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        if(road.orientation.equals("vertical")){
            this.y+=1;
        }
        else {
            this.x+=1;
        }

    }


}
