public class Car {
    String type;
    int currentSpeed;
    int x,y;

    public Car(String type, int currentSpeed, int x, int y) {
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
    }
    public void updatePosition(){
        
    }
    public void speedUp(){
        while (this.currentSpeed<60){
            this.currentSpeed+=1;
        }

    }
}
