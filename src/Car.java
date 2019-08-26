public class Car {
    String type;
    double currentSpeed;
    double speedModifier;
    double x,y;

    public  Car(String type, double currentSpeed, int x, int y) {
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
    public void slowDown(double currentSpeed){
        currentSpeed*=0.25;
        while (this.currentSpeed>0){
            this.currentSpeed-=currentSpeed;
        }
    }
    public void updatePositon(Road road, double currentSpeed){
        double modifiedSpeed;
        modifiedSpeed=currentSpeed/60;
        if(road.orientation.equals("vertical")){
            this.y+=1*modifiedSpeed;
        }
        else {
            this.x+=1*modifiedSpeed;
        }

    }


}
