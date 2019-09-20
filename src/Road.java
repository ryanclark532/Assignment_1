import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {
    private double length;
    public double xStart,yStart;
    public double xFinish,yFinish;
    public String orientation;

    public Road(int length, double xStart, double yStart, String orientation) {
        this.length = length;
        this.xStart = xStart;
        this.yStart = yStart;
        this.orientation=orientation;
        if (orientation.equals("vertical")) {
            setyFinish(this.yStart + this.length);
            setxFinish(this.xStart);
        }
        else {
            setxFinish(this.xStart + this.length);
            setyFinish(this.yStart);
        }

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);
        g2d.fillRoundRect((int) this.xStart, (int) this.yStart, (int) this.length, 60, 2, 2);
    }


    private void setxFinish(double xFinish) {
        this.xFinish = xFinish;
    }

    private void setyFinish(double yFinish) {
        this.yFinish = yFinish;
    }
}
