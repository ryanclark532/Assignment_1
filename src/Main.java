public class Main {
    public static void main(String[] args) {
        Road road=new Road(30,1,1,"horizontal");
        TrafficLight trafficLight=new TrafficLight();
        RoadList list=new RoadList();
        list.addElement(road);
        list.addElement(trafficLight);
        int spaceleft=road.length;
        Car car=new Car("Car",60.00,1,1,list);
        while (car.x<30){
            spaceleft-=1;
            System.out.println(spaceleft);
            car.updatePosition(road);
            System.out.println(car.x+" "+car.currentSpeed);
        }


    }
}
