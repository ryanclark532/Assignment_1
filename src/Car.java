import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Car extends JPanel {
    String type;
    double currentSpeed;
    public Road current;
    double x, y;
    Road next;
    private boolean direction;
    Random random = new Random();

    public Car(String type, double currentSpeed, double x, double y, boolean direction) {
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;
        this.direction = direction;
        currentRoad();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.current.orientation.equals("horizontal")) {
            if (this.direction) {
                g2d.setPaint(new Color(150, 150, 150));
                g2d.fillRoundRect((int) this.x, (int) this.y, 30, 15, 8, 8);

            } else {
                g2d.setPaint(new Color(150, 150, 150));
                g2d.fillRoundRect((int) this.x, (int) this.y, 40, 20, 10, 10);

            }
        } else {
            if (this.direction) {
                g2d.setPaint(new Color(150, 150, 150));
                g2d.fillRoundRect((int) this.x, (int) this.y, 15, 30, 8, 8);

            } else {
                g2d.setPaint(new Color(150, 150, 150));
                g2d.fillRoundRect((int) this.x, (int) this.y, 20, 30, 8, 10);
            }
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

    void nextRoad() {
        for (Road i : RoadList.index) {
            if (i == current) {
                continue;
            }
            if (current.orientation.equals("horizontal")) {
                if (this.direction) {
                    if ((i.xStart == current.xFinish) && (i.yStart == current.yStart)) {
                        next = i;

                    }
                } else {
                    if ((current.xStart == i.xFinish) && (i.yStart == current.yStart)) {
                        next = i;

                    }
                }
            } else {
                if (this.direction) {
                    if ((i.yStart == current.yFinish) && (i.xStart == current.xStart)) {
                        next = i;
                    }
                } else {
                    if ((current.yStart == i.yFinish) && (i.xStart == current.xStart)) {
                        next = i;
                    }
                }
            }
        }
    }

    public void updatePosition() throws InterruptedException {
        this.currentRoad();
        this.nextRoad();
        if (current.orientation.equals("horizontal")) {
                if (this.direction) {
                    for (Car i : CarList.index) {
                        if (i == this) {
                            continue;
                        }
                        if ((this.x >= i.x - 75) && (this.x <= i.x) && i.y == this.y) {
                            this.slowDown();
                        }
                    }
                    if (next instanceof Intersection) {
                        ArrayList<Road> links = ((Intersection) next).links(next);
                        int x = random.nextInt(links.size());
                        Road road = links.get(x);
                        while (current == road) {
                            x = random.nextInt(links.size());
                            road = links.get(x);
                        }

                        if (((this.x >= next.xStart - 5) && this.x <= next.xStart)) {
                            if (road.orientation.equals("vertical") && road.yStart < current.yStart) {
                                System.out.println("grga");
                                this.x = road.xStart;
                                this.y = road.yFinish;
                                this.direction = false;

                            } else {
                                this.x = road.xStart;
                                this.y = road.yStart;
                            }
                        }
                    } else if ((next instanceof TrafficLight) && ((TrafficLight) next).leftLight.equals("red")) {
                        if (this.x >= (this.current.xFinish - 40)) {
                            this.slowDown();
                        }
                    } else {
                        this.speedUp();
                    }

                    move();

                } else {
                    for (Car i : CarList.index) {
                        if (i == this) {
                            continue;
                        }
                        if ((this.x >= i.x + 75) && (this.x <= i.x)) {
                            this.slowDown();
                        }

                    }
                    if (next instanceof Intersection) {
                        ArrayList<Road> links = ((Intersection) next).links(next);
                        int x = random.nextInt(links.size());
                        Road road = links.get(x);
                        while (current == road) {
                            x = random.nextInt(links.size());
                            road = links.get(x);
                        }
                        if (((this.x <= next.xFinish + 5) && this.x > next.xFinish)) {
                            System.out.println("feef");
                            if (road.orientation.equals("vertical") && road.yStart > current.yStart) {
                                this.x = road.xStart;
                                this.y = road.yStart;
                                this.direction = true;

                            } else {
                                this.x = road.xFinish;
                                this.y = road.yFinish;
                            }
                        }
                    }
                    if ((next instanceof TrafficLight) && ((TrafficLight) next).rightLight.equals("red")) {

                        if (this.x >= (this.current.xStart + 40)) {
                            this.slowDown();
                        }
                    } else {
                        this.speedUp();
                    }

                    move();
                }
            } else {
                if (this.direction) {
                    for (Car i : CarList.index) {
                        if (i == this) {
                            continue;
                        }
                        if (((this.y >= i.y - 75) && (this.y <= i.y)) && (this.x == i.x)) {

                            this.slowDown();
                        }
                    }
                    if (next instanceof Intersection) {
                        ArrayList<Road> links = ((Intersection) next).links(next);
                        int x = random.nextInt(links.size());
                        Road road = links.get(x);
                        while (current == road) {
                            x = random.nextInt(links.size());
                            road = links.get(x);
                        }
                        if (((this.y >= next.yStart - 5) && this.y <= next.yStart)) {

                            if (road.orientation.equals("horizontal") && road.xStart < current.xStart) {
                                System.out.println("here");
                                this.x = road.xFinish;
                                this.y = road.yStart + 1;
                                this.direction = false;

                            } else {
                                this.x = road.xStart;
                                this.y = road.yStart;
                            }
                        }
                    }
                    if ((next instanceof TrafficLight) && ((TrafficLight) next).topLight.equals("red")) {
                        if (this.y >= (this.current.yFinish - 40)) {
                            this.slowDown();
                        }
                    } else {
                        this.speedUp();
                    }

                    move();
                } else {
                    for (Car i : CarList.index) {
                        if (i == this) {
                            continue;
                        }
                        if ((this.y >= i.y + 75) && (this.y <= i.y)) {
                            this.slowDown();
                        }
                    }
                    if (next instanceof Intersection) {
                        ArrayList<Road> links = ((Intersection) next).links(next);
                        int x = random.nextInt(links.size());
                        Road road = links.get(x);
                        while (current == road) {
                            x = random.nextInt(links.size());
                            road = links.get(x);
                        }
                        if (((this.y <= next.yFinish + 5) && this.y > next.yFinish)) {
                            System.out.println("feef");
                            if (road.orientation.equals("horizontal") && road.xStart > current.xStart) {
                                this.x = road.xStart;
                                this.y = road.yStart;
                                this.direction = true;

                            } else {
                                this.x = road.xFinish;
                                this.y = road.yFinish;
                            }
                        }
                    }
                    if ((next instanceof TrafficLight) && ((TrafficLight) next).bottomLight.equals("red")) {

                        if (this.y >= (this.current.yStart + 40)) {
                            this.slowDown();
                        }
                    } else {
                        this.speedUp();
                    }

                    move();
                }

        }
    }

    void move() {
        if (currentSpeed > 0) {
            if (current.orientation.equals("horizontal")) {
                if (this.direction) {
                    this.x += 0.01 * currentSpeed;
                } else {
                    this.x -= 0.01 * currentSpeed;
                }
            } else {
                if (this.direction) {
                    this.y += 0.01 * currentSpeed;
                } else {
                    this.y -= 0.01 * currentSpeed;
                }
            }
        }
    }
}




