import java.util.Random;
public class TrafficLight extends Road {

    String frontLight;
    String leftLight;
    String rightLight;
    String backLight;

    public TrafficLight() {
        super(10,32,1,"horizontal");
        this.frontLight = "red";
        this.leftLight = "red";
        this.rightLight = "red";
        this.backLight = "red";
    }
    public void change(){
        Random random=new Random();
        switch (random.nextInt(4)){
            case 1:
                this.frontLight = "green";
                this.leftLight = "red";
                this.rightLight = "red";
                this.backLight = "red";
                break;
            case 2:
                this.frontLight = "red";
                this.leftLight = "green";
                this.rightLight = "red";
                this.backLight = "red";
                break;
            case 3:
                this.frontLight = "red";
                this.leftLight = "red";
                this.rightLight = "green";
                this.backLight = "red";
                break;
            case 4:
                this.frontLight = "red";
                this.leftLight = "red";
                this.rightLight = "red";
                this.backLight = "green";
                break;
        }
    }
}



