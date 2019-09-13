public class Main {
    public static void main(String[] args) {
        Road road = new Road(12, 0, 0, "horizontal");
        Road up = new Road(12, 26, 0, "horizontal");
        TrafficLight trafficLight = new TrafficLight(12, 13, 0, "horizontal");
        RoadList list=new RoadList();
        list.addElement(road);
        list.addElement(trafficLight);
        list.addElement(up);
        Road last = RoadList.index.get(RoadList.index.size() - 1);
        Car car = new Car("Car", 60.00, 0, 0, true);
        int i = 0;
        while (true) {
            try {
                car.updatePosition();
                if ((i % 4) == 0) {
                    trafficLight.change();
                }
                i += 1;
                System.out.println(car.x + " " + car.y + " " + car.currentSpeed + " " + trafficLight.leftLight);
                Thread.sleep(200);
            } catch (IndexOutOfBoundsException | InterruptedException e) {
                System.out.println("Simulation Complete! :) ");
                break;
            } catch (NullPointerException e) {
                System.out.println("Car hasnt started on a road!");
                break;
            }

        }

    }
}
