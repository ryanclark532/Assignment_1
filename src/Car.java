public class Car {
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


    }
}


