public class Car {
    String type;
    double currentSpeed;
    double x,y;
    private Road current;
    public static void main(String[] args) {

    }

    public Car(String type, double currentSpeed, double x, double y) {
        this.type = type;
        this.currentSpeed = currentSpeed;
        this.x = x;
        this.y = y;

    }

    private void speedUp() {
        this.currentSpeed=60;
    }

    private void slowDown() {
        this.currentSpeed=0;
    }

    private void currentRoad() {
        for (Road i : RoadList.index) {
            if (((i.xStart <= this.x) && (i.xFinish >= this.x)) && ((i.yStart <= this.y) && (i.yFinish >= this.y))) {
                if (i instanceof TrafficLight) {
                    i = i;
                    this.current = i;
                } else {
                    this.current = i;
                }

            }
        }

    }

    public void updatePosition() {
        currentRoad();
        if ((this.current.xFinish == this.x) && (this.current.yFinish == this.y)) {
            Road next = RoadList.index.get(RoadList.index.indexOf(current) + 1);
            System.out.println(next);
            if (next instanceof TrafficLight) {
                if (((TrafficLight) next).leftLight.equals("red")) {
                    this.slowDown();
                } else if (((TrafficLight) next).leftLight.equals("green")) {
                    this.speedUp();
                }
            }
        }
        if (this.currentSpeed == 60) {
            if (current.orientation.equals("horizontal")) {
                this.x += 1;
            } else if (current.orientation.equals("vertical")) {
                this.y += 1;
            }
        }

    }
    }


