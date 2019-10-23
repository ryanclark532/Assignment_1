import javax.swing.*;
import java.awt.*;

public class Car extends JPanel {
    String type;
    double currentSpeed;
    double x,y;
    private Road current;
    private boolean direction;

    public Car(String type, double currentSpeed, double x, double y, boolean direction) {
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.direction) {
            g2d.setPaint(new Color(150, 150, 150));
            g2d.fillRoundRect((int) this.x - 40, (int) this.y, 30, 15, 8, 8);
            g2d.setPaint(new Color(89, 87, 79));
            g2d.fillOval((int) this.x + 5 - 40, (int) this.y - 3, 5, 5);
            g2d.fillOval((int) this.x + 5 - 40, (int) this.y + 12, 5, 5);
            g2d.fillOval((int) this.x + 23 - 40, (int) this.y - 3, 5, 5);
            g2d.fillOval((int) this.x + 23 - 40, (int) this.y + 12, 5, 5);
            g2d.setPaint(new Color(70, 89, 130));
            g2d.fillRoundRect((int) this.x + 9 - 40, (int) this.y + 2, 5, 11, 5, 5);
            g2d.fillRoundRect((int) this.x + 18 - 40, (int) this.y + 2, 5, 11, 5, 5);
        } else {
            g2d.setPaint(new Color(150, 150, 150));
            g2d.fillRoundRect((int) this.x + 40, (int) this.y, 40, 20, 10, 10);
            g2d.setPaint(new Color(89, 87, 79));
            g2d.fillOval((int) this.x + 3 + 40, (int) this.y - 3, 8, 8);
            g2d.fillOval((int) this.x + 3 + 40, (int) this.y + 15, 8, 8);
            g2d.fillOval((int) this.x + 30 + 40, (int) this.y - 3, 8, 8);
            g2d.fillOval((int) this.x + 30 + 40, (int) this.y + 15, 8, 8);
            g2d.setPaint(new Color(70, 89, 130));
            g2d.fillRoundRect((int) this.x + 10 + 40, (int) this.y + 2, 8, 15, 5, 5);
            g2d.fillRoundRect((int) this.x + 22 + 40, (int) this.y + 2, 8, 15, 5, 5);
        }

    }



    private void speedUp() {
        if (this.currentSpeed < 60) {
            this.currentSpeed += 0.5;
        }
    }

    private void slowDown() {
        if (this.currentSpeed > 0) {
            this.currentSpeed -= 0.5;
        }

    }

    private void currentRoad() {
        for (Road i : RoadList.index) {
            if (((i.xStart <= this.x) && (i.xFinish >= this.x)) && ((i.yStart <= this.y) && (i.yFinish >= this.y))) {
                if (i instanceof TrafficLight) {
                    this.current = i;
                } else {
                    this.current = i;
                }
            }
        }

    }

    public void updatePosition() {
        this.currentRoad();
        try {
            if (this.direction) {
                Road next = RoadList.index.get(RoadList.index.indexOf(current) + 1);
                for (Car i : CarList.index) {
                    if (i == this) {
                        continue;
                    }
                    if ((this.x >= i.x - 75) && (this.x <= i.x)) {
                        this.slowDown();
                    }
                }
                if ((next instanceof TrafficLight) && ((TrafficLight) next).leftLight.equals("red")) {
                    if (this.x >= (this.current.xFinish - 40)) {
                        this.slowDown();
                    }
                } else {
                    this.speedUp();
                }

                if (this.currentSpeed > 0) {
                    if (current.orientation.equals("horizontal")) {
                        this.x += 0.01 * currentSpeed;
                    } else if (current.orientation.equals("vertical")) {
                        this.y += 0.01 * currentSpeed;
                    }
                }

            } else {
                Road next = RoadList.index.get(RoadList.index.indexOf(current) - 1);
                for (Car i : CarList.index) {
                    if (i == this) {
                        continue;
                    }
                    if ((this.x >= i.x + 75) && (this.x <= i.x)) {
                        this.slowDown();
                    }
                }
                if ((next instanceof TrafficLight) && ((TrafficLight) next).rightLight.equals("red")) {

                    if (this.x >= (this.current.xStart + 40)) {
                        this.slowDown();
                    }
                } else {
                    this.speedUp();
                }

                if (this.currentSpeed > 0) {
                    if (current.orientation.equals("horizontal")) {
                        this.x -= 0.01 * currentSpeed;
                    } else if (current.orientation.equals("vertical")) {
                        this.y -= 0.01 * currentSpeed;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            if ((this.x < current.xFinish) && (this.y < current.yFinish)) {
                if (current.orientation.equals("horizontal")) {
                    this.x += 0.01 * currentSpeed;
                } else if (current.orientation.equals("vertical")) {
                    this.y += 0.01 * currentSpeed;
                }
            }


        }



    }
}


