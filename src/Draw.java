import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    Car car = new Car("Car", 60.00, 10, 10, true);
    Road road = new Road(600, 10, 10, "horizontal");

    public static void main(String[] args) {


    }

    public void paintComponent(Graphics g) {
        road.paint(g);
        car.paint(g);
    }
}
