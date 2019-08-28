import java.util.ArrayList;
import java.util.ListIterator;

public class Car {
    String type;
    double currentSpeed;
    double x,y;
    RoadList roadList;
    Road current;

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
        int in=1;
        for(Road i:this.roadList.index){
            if ((i.xStart<=this.x) && (i.xFinish>=this.x)){
                current=i;
                break;
            }
            in+=1;
        }
        if (current.xFinish==this.x){
            for (Road next : this.roadList.index) {
                if (next instanceof TrafficLight) {
                    if (((TrafficLight) next).frontLight.equals("red")) {
                        this.slowDown();
                    }
                    if (((TrafficLight) next).frontLight.equals("green")) {
                        this.speedUp();
                    }
                }
            }
        }
        if(this.currentSpeed==60){
            if(road.orientation.equals("vertical")){
                this.y+=1;
            }
            else {
                this.x+=1;
            }
        }
    }
    }


