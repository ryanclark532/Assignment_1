import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {

    public static void main(String[] args) {

    }
    public void paintComponent(Graphics g) {
        for (Road i : RoadList.index) {
            i.paint(g);
        }
        for (Car i : CarList.index) {
            i.paint(g);
        }
    }
}
