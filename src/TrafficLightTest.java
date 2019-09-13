import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficLightTest {
    @Test
    public void defaultTest() {
        TrafficLight trafficLight = new TrafficLight(10, 30, 0, "horizontal");
        assertEquals("red", trafficLight.leftLight);
        assertEquals("red", trafficLight.topLight);
        assertEquals("red", trafficLight.bottomLight);
        assertEquals("red", trafficLight.rightLight);
        trafficLight.change(); //take an input for testing purposes
        assertEquals("red", trafficLight.leftLight);
        assertEquals("green", trafficLight.topLight);
        assertEquals("red", trafficLight.bottomLight);
        assertEquals("red", trafficLight.rightLight);
    }
}
