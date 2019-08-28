public class Main {
    public static void main(String[] args) {
        Road road=new Road(30,0,0,"horizontal");
        TrafficLight trafficLight=new TrafficLight();
        RoadList list=new RoadList();
        list.addElement(road);
        list.addElement(trafficLight);

        Car car=new Car("Car",60.00,0,0,list);
        while (car.x<40){
            trafficLight.change();
            car.updatePosition(road);
            System.out.println(car.x+" "+car.currentSpeed+" "+trafficLight.frontLight);
        }


    }
}
