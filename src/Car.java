public class Car {
    String type;
    int currentSpeed;
    double speedModifier;
    int x,y;

    public  Car(String type, int currentSpeed, int x, int y) {
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
    }
    public void speedUp(){
        while (this.currentSpeed<61){
            this.currentSpeed+=1;
        }
    }
    public void slowDown(){
        while (this.currentSpeed>0){
            this.currentSpeed-=1;
        }
    }
    public void updatePositon(Road road, int currentSpeed){

        if(road.orientation=="vertical"){
            this.y+=1;
        }
        else {
            this.x+=1;
        }

    }


}
