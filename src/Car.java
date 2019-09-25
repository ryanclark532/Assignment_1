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
        g2d.setPaint(new Color(150, 150, 150));
        g2d.fillRoundRect((int) this.x, (int) this.y, 90, 40, 10, 10);
        g2d.setPaint(new Color(89, 87, 79));
        g2d.fillOval((int) this.x + 10, (int) this.y - 5, 12, 12);
        g2d.fillOval((int) this.x + 10, (int) this.y + 35, 12, 12);
        g2d.fillOval((int) this.x + 60, (int) this.y - 5, 12, 12);
        g2d.fillOval((int) this.x + 60, (int) this.y + 35, 12, 12);
        g2d.setPaint(new Color(70, 89, 130));
        g2d.fillRoundRect((int) this.x + 8, (int) this.y + 8, 15, 25, 5, 5);
        g2d.fillRoundRect((int) this.x + 60, (int) this.y + 8, 15, 25, 5, 5);
    }



    private void speedUp() {
        if (this.currentSpeed < 60) {
            this.currentSpeed += 15;
        }
    }

    private void slowDown() {
        if (this.currentSpeed > 0) {
            this.currentSpeed -= 15;
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
                if ((next instanceof TrafficLight) && ((TrafficLight) next).leftLight.equals("red")) {
                    if ((this.x >= (this.current.xFinish - 4)) && ((this.current.yFinish) == this.y)) {
                        this.slowDown();
                    }
                } else {
                    this.speedUp();
                }

                if (this.currentSpeed > 0) {
                    if (current.orientation.equals("horizontal")) {
                        this.x += 1;
                    } else if (current.orientation.equals("vertical")) {
                        this.y += 1;
                    }
                }

            } else {
                Road next = RoadList.index.get(RoadList.index.indexOf(current) - 1);
                if ((next instanceof TrafficLight) && ((TrafficLight) next).rightLight.equals("red")) {
                    if ((this.x >= (this.current.xStart + 4)) && ((this.current.yFinish) == this.y)) {
                        this.slowDown();
                    }
                } else {
                    this.speedUp();
                }

                if (this.currentSpeed > 0) {
                    if (current.orientation.equals("horizontal")) {
                        this.x -= 1;
                    } else if (current.orientation.equals("vertical")) {
                        this.y -= 1;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            if (this.x <= current.xFinish) {
                if (this.currentSpeed > 0) {
                    if (current.orientation.equals("horizontal")) {
                        this.x += 1;
                    } else if (current.orientation.equals("vertical")) {
                        this.y += 1;
                    }
                }
            }
        }



    }
}


