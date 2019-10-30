import java.awt.*;
import java.util.Random;
public class TrafficLight extends Road {
    public String topLight;
    public String leftLight;
    public String rightLight;
    public String bottomLight;

    public TrafficLight(int length, double xStart, double yStart, String orientation) {
        super(length, xStart, yStart, orientation);
        this.topLight = "red";
        this.leftLight = "red";
        this.rightLight = "red";
        this.bottomLight = "red";
    }

    public void change() {
        Random random = new Random();
        switch (random.nextInt(4)) {
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

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = ((Graphics2D) g);
        if (this.selected) {
            g2d.setPaint(Color.BLUE);
            g2d.fillRect(((int) this.xFinish), ((int) this.yStart), 30, 30);
        } else {
            g2d.setPaint(Color.GRAY);
            g2d.fillRect(((int) this.xFinish), ((int) this.yStart), 30, 30);
        }
    }
}




