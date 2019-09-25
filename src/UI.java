import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI {
    static JFrame mainFrame = new JFrame();
    public static void main(String[] args) throws InterruptedException {
        Road road = new Road(100, 0, 0, "horizontal");
        Road up = new Road(100, 101, 0, "horizontal");
        Car car = new Car("Car", 60.00, 0, 0, true);
        RoadList roadList = new RoadList();
        CarList carList = new CarList();
        roadList.addElement(road);
        roadList.addElement(up);
        carList.addElement(car);

        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setSize(1000, 800);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("yaya");
            }
        });


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        JButton start = new JButton("Go");
        c.weightx = 1;
        c.weighty = 0.25;
        start.addActionListener(actionEvent -> start());
        c.ipady = 50;
        c.ipadx = 100;

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        mainFrame.add(start, c);

        Draw draw = new Draw();
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        mainFrame.add(draw, c);

        JLabel label = new JLabel("Test");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        mainFrame.add(label, c);

        JPanel bcontainer = new JPanel();
        bcontainer.setLayout(new GridLayout(1, 2));
        c.weightx = 1;
        c.weighty = 0.25;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        mainFrame.add(bcontainer, c);

        JPanel stats = new JPanel();
        stats.setBackground(Color.DARK_GRAY);
        stats.setLayout(new GridLayout(2, 3));
        JLabel lbl_AS = new JLabel("Average Speed: ");
        JLabel lbl_NOC = new JLabel("Number Of Cars: ");
        JLabel lbl_T = new JLabel("Length of Simulation: ");
        stats.add(lbl_AS);
        stats.add(lbl_NOC);
        stats.add(lbl_T);
        bcontainer.add(stats);

        JPanel export = new JPanel();
        export.setBackground(Color.ORANGE);
        bcontainer.add(export);
        mainFrame.setVisible(true);

    }

    private static void start() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Car i : CarList.index) {
                    i.updatePosition();
                    mainFrame.repaint();
                    System.out.println(i.x);
                }
            }
        });
        timer.start();


    }

}
