import java.util.Random;
public class TrafficLight extends Road {
    public String topLight;
    public String leftLight;
    public String rightLight;
    public String bottomLight;

    public TrafficLight() {
        super(10, 30, 1, "horizontal");
        this.topLight = "red";
        this.leftLight = "red";
        this.rightLight = "red";
        this.bottomLight = "red";
    }
    public void change(){
        Random random=new Random();
        switch (random.nextInt(4)){
            case 1:
                this.topLight = "green";
                this.leftLight = "red";
                this.rightLight = "red";
                this.bottomLight = "red";
                break;
            case 2:
                this.topLight = "red";
                this.leftLight = "green";
                this.rightLight = "red";
                this.bottomLight = "red";
                break;
            case 3:
                this.topLight = "red";
                this.leftLight = "red";
                this.rightLight = "green";
                this.bottomLight = "red";
                break;
            case 4:
                this.topLight = "red";
                this.leftLight = "red";
                this.rightLight = "red";
                this.bottomLight = "green";
                break;
        }
    }
}



