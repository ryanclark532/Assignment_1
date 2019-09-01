import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoadTesting {
    @Test
    public void defaultTest() {
        Road roadOne = new Road(45, 0, 0, "horizontal");
        Road roadTwo = new Road(45, 0, 0, "vertical");
        assertEquals(45, roadOne.xFinish, 45);
        assertEquals(0, roadOne.yFinish, 0);
        assertEquals("horizontal", roadOne.orientation);
        assertEquals(45, roadTwo.yFinish, 45);
        assertEquals(0, roadTwo.xFinish, 0);
        assertEquals("vertical", roadTwo.orientation);
    }
}
