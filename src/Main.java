import javax.swing.*;
import java.awt.*;

public class Main {
    public void main(String[] args) {
        Road road = new Road(500, 0, 0, "horizontal");
        Road up = new Road(500, 602, 0, "horizontal");


        Road last = RoadList.index.get(RoadList.index.size() - 1);
        Car car = new Car("Car", 60.00, 0, 0, true);
        CarList carList = new CarList();
        carList.addElement(car);
        int i = 0;

        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new GridLayout());
        mainFrame.setSize(1000, 1000);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        Draw draw = new Draw();
        JButton start = new JButton("Start");
        start.addActionListener(actionEvent -> start());
        mainFrame.add(draw);
        mainFrame.add(start);
    }

    public void start() {
        while (true) {
            try {
                for (Car i : CarList.index) {
                    i.updatePosition();
                }
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
