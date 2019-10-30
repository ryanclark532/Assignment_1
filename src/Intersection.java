import java.awt.*;
import java.util.ArrayList;

public class Intersection extends Road {

    public Intersection(double xStart, double yStart, String orientation) {
        super(30, xStart, yStart, orientation);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = ((Graphics2D) g);
        g2d.setColor(Color.GRAY);
        g2d.fillRect(((int) this.xStart), ((int) this.yStart), ((int) this.length), ((int) this.length));
    }

    ArrayList<Road> links() {
        ArrayList<Road> roads = new ArrayList<>();
        for (Road i : RoadList.index) {
            for (Road x : RoadList.index) {
                if (i == x) {
                    continue;
                }
                if (x instanceof Intersection) {
                    if (((i.xFinish == x.xStart) && (i.yStart == x.yStart)) || ((x.xFinish == i.xStart) && (x.yStart == i.yStart)) ||
                            ((x.xStart == i.xStart) && (x.yStart == i.yFinish)) || ((i.xStart == x.xStart) && (x.yFinish == i.yStart))) {
                        roads.add(i);

                    }
                }
            }
        }
        return roads;
    }
}