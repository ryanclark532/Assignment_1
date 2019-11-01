import java.awt.*;
import java.util.ArrayList;

public class Intersection extends Road {

    public Intersection(double xStart, double yStart, String orientation) {
        super(30, xStart, yStart, orientation);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = ((Graphics2D) g);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(((int) this.xStart), ((int) this.yStart), ((int) this.length), ((int) this.length));
        if (this.selected) {
            g2d.setPaint(Color.BLUE);
            g2d.drawRect(((int) this.xStart), ((int) this.yStart), 30, 30);
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
}