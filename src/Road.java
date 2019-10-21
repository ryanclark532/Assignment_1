import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {
    public double length;
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
            setxFinish(this.xStart + 60);
        }
        else {
            setxFinish(this.xStart + this.length);
            setyFinish(this.yStart + 60);
        }

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);
        if (this.orientation.equals("horizontal")) {
            g2d.fillRoundRect((int) this.xStart, (int) this.yStart, (int) this.length, 50, 2, 2);
            g2d.setPaint(Color.GRAY);
            g2d.fillRect((int) this.xStart, (int) this.yStart + 22, (int) this.length, 3);
        } else {
            g2d.fillRoundRect((int) this.xStart, (int) this.yStart, 50, (int) this.length, 2, 2);
            g2d.setPaint(Color.GRAY);
            g2d.fillRect((int) this.xStart + 22, (int) this.yStart, 3, (int) this.length);
        }

    }


    private void setxFinish(double xFinish) {
        this.xFinish = xFinish;
    }

    private void setyFinish(double yFinish) {
        this.yFinish = yFinish;
    }
}
