import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTesting {
    @Test
    public void defaultTest() {
        Car carOne = new Car("car", 60, 1, 1);
        Road roadOne = new Road(45, 0, 0, "horizontal");
        Road roadTwo = new Road(45, 45, 0, "vertical");
        RoadList list = new RoadList();
        list.addElement(roadOne);
        list.addElement(roadTwo);
        assertEquals("car", carOne.type);
        assertEquals(60, carOne.currentSpeed, 60);
        carOne.updatePosition();


    }
}
