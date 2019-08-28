public class TrafficLight extends Road {

    String frontLight;
    String leftLight;
    String rightLight;
    String backLight;

    public TrafficLight() {
        super(10,30,1,"horizontal");
        this.frontLight = "red";
        this.leftLight = "red";
        this.rightLight = "red";
        this.backLight = "red";
    }

}
