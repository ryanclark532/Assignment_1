import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTesting {
    @Test
    public void defaultTest() {
        Road road = new Road(30, 0, 0, "horizontal");
        Road up = new Road(30, 40, 0, "vertical");
        TrafficLight trafficLight = new TrafficLight();
        RoadList list = new RoadList();
        list.addElement(road);
        list.addElement(trafficLight);
        list.addElement(up);
        Road last = RoadList.index.get(RoadList.index.size() - 1);
        Car car = new Car("Car", 60.00, 0, 0);
        assertEquals(0, car.x, 0);
        assertEquals(0, car.y, 0);
        car.updatePosition();
        assertEquals(1, car.x, 1);
        car.updatePosition();
        assertEquals(2, car.x, 2);
        car.x = 40;
        car.updatePosition();
        assertEquals(1, car.y, 1);
        car.updatePosition();
        assertEquals(2, car.y, 2);
    }
}
