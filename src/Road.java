import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {
    public double length;
    public double xStart,yStart;
    public double xFinish,yFinish;
    public String orientation;
    public boolean selected;
    public Road(int length, double xStart, double yStart, String orientation) {
        this.length = length;
        this.xStart = xStart;
        this.yStart = yStart;
        this.orientation=orientation;
        this.selected = false;
        if (orientation.equals("vertical")) {
            setyFinish(this.yStart + this.length);
            setxFinish(this.xStart + 30);
        }
        else {
            setxFinish(this.xStart + this.length);
            setyFinish(this.yStart + 30);
        }

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.orientation.equals("horizontal")) {
            g2d.setColor(Color.black);
            g2d.fillRoundRect((int) this.xStart, (int) this.yStart, (int) this.length, 30, 2, 2);
            g2d.setPaint(Color.GRAY);
            g2d.fillRect((int) this.xStart, (int) this.yStart + 15, (int) this.length, 3);
            if (this.selected) {
                g2d.setColor(Color.BLUE);
                g2d.drawRect((int) this.xStart, (int) this.yStart, (int) this.length, 30);
            }
        } else {
            g2d.setColor(Color.black);
            g2d.fillRoundRect((int) this.xStart, (int) this.yStart, 30, (int) this.length, 2, 2);
            g2d.setPaint(Color.GRAY);
            g2d.fillRect((int) this.xStart + 15, (int) this.yStart, 3, (int) this.length);
            if (this.selected) {
                g2d.setColor(Color.BLUE);
                g2d.drawRect((int) this.xStart, (int) this.yStart, 30, (int) this.length);
            }
        }

    }


    private void setxFinish(double xFinish) {
        this.xFinish = xFinish;
    }

    private void setyFinish(double yFinish) {
        this.yFinish = yFinish;
    }
}
