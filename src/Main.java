public class Main {
    public static void main(String[] args) {
        Road road=new Road(30,0,0,"horizontal");
        Road up = new Road(30, 40, 0, "horizontal");
        TrafficLight trafficLight=new TrafficLight();
        RoadList list=new RoadList();
        list.addElement(road);
        list.addElement(trafficLight);
        list.addElement(up);
        Road last = RoadList.index.get(RoadList.index.size() - 1);
        Car car = new Car("Car", 60.00, 0, 0);
        while (true) {
            try {
                System.out.println(car.x + " " + car.y + " " + car.currentSpeed + " " + trafficLight.leftLight);
                car.updatePosition();
                trafficLight.change();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Simulation Complete!");
                break;
            }

        }


    }
}
