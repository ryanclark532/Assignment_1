import javax.swing.*;
import java.awt.*;

public class UI {
    public static void main(String[] args) throws InterruptedException {
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(1000, 1000);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        Draw draw = new Draw();
        mainFrame.add(draw);

    }
}
