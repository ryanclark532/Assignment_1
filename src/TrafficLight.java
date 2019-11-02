import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class TrafficLight extends Road {
    String topLight;
    String leftLight;
    String rightLight;
    String bottomLight;

    public TrafficLight(double xStart, double yStart, String orientation) {
        super(30, xStart, yStart, orientation);
        this.topLight = "red";
        this.leftLight = "red";
        this.rightLight = "red";
        this.bottomLight = "red";
    }

    void change() {
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

    ArrayList<Road> links(Road next) {
        ArrayList<Road> roads = new ArrayList<>();
        for (Road i : RoadList.index) {
            if (((i.xFinish == next.xStart) && (i.yStart == next.yStart)) || ((next.xFinish == i.xStart) && (next.yStart == i.yStart)) ||
                    ((next.xStart == i.xStart) && (next.yStart == i.yFinish)) || ((i.xStart == next.xStart) && (next.yFinish == i.yStart))) {
                if (!roads.contains(i)) {
                    roads.add(i);
                }
            }

        }
        return roads;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = ((Graphics2D) g);
        g2d.setPaint(Color.GRAY);
        g2d.fillRect(((int) this.xStart), ((int) this.yStart), 30, 30);
        if (this.selected) {
            g2d.setPaint(Color.BLUE);
            g2d.drawRect(((int) this.xStart), ((int) this.yStart), 30, 30);
        }

    }
}




