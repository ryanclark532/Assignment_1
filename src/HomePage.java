import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class HomePage {
    static Timer timer;
    public static JFrame mainFrame = new JFrame();
    public static Draw draw = new Draw();
    static JFrame createSim = new JFrame();
    static CreateSimPage cs;
    static LS ls = new LS();

    public static void main(String[] args) throws IOException {

        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("yaya");
            }
        });


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem save = new JMenuItem("Save Configuration");
        JMenuItem open = new JMenuItem("Open Configuration");
        JMenuItem cn = new JMenuItem("Edit Current Sim");
        save.addActionListener(actionEvent -> {
            try {
                saveSim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        cn.addActionListener(actionEvent -> csShow());
        open.addActionListener(actionEvent -> {
            try {
                loadSim();
                mainFrame.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menu.add(file);
        menu.add(edit);
        file.add(save);
        file.add(open);
        edit.add(cn);
        menu.setAlignmentX(JMenuBar.LEFT_ALIGNMENT);
        c.weightx = 1;
        c.weighty = 0.001;

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        mainFrame.add(menu, c);


        c.weightx = 0.85;
        c.weighty = 0.75;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        mainFrame.add(draw, c);

        JPanel goStop = new JPanel();
        goStop.setLayout(new GridLayout(3, 1));
        JButton start = new JButton("Go");
        JButton stop = new JButton("Stop");
        JButton addCar = new JButton("New Car");
        start.addActionListener(actionEvent -> start());
        stop.addActionListener(actionEvent -> stop());
        addCar.addActionListener(actionEvent -> car());
        addCar.setHorizontalAlignment(JLabel.CENTER);
        addCar.setVerticalAlignment(JLabel.CENTER);
        goStop.add(start);
        goStop.add(stop);
        goStop.add(addCar);
        c.weightx = 0.15;
        c.weighty = 0.70;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        mainFrame.add(goStop, c);

        JPanel bcontainer = new JPanel();
        bcontainer.setLayout(new GridLayout(1, 2));
        c.weightx = 1;
        c.weighty = 0.15;
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

        load();

        createSim.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

            }
        });
        cs = new CreateSimPage(createSim);
        cs.load();
        Road first = new Road(200, 0, 300, "horizontal");
        RoadList.index.add(first);

        mainFrame.setVisible(true);
        ls.load();
        mainFrame.repaint();
    }

    private static void load() {
        timer = new Timer(1, actionEvent -> {
            for (Car i : CarList.index) {
                try {
                    i.updatePosition();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainFrame.repaint();
            }
        });
    }

    static void car() {
        Road test = RoadList.index.get(0);
        Car temp = new Car("Car", 60, test.xStart, test.yStart, true);
        CarList.index.add(temp);
        mainFrame.repaint();
    }
    private static void start() {
        timer.start();
        for (Road i : RoadList.index) {
            if (i instanceof TrafficLight) {
                ((TrafficLight) i).change();
            }
        }
    }

    private static void stop() {
        timer.stop();
    }

    private static void csShow() {
        createSim.setVisible(true);
    }

    static void saveSim() throws IOException {
        ls.save();
    }

    static void loadSim() throws IOException {
        ls.load();
    }

}
