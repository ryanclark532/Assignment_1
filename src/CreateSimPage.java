import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateSimPage extends KeyAdapter {
    JFrame CreateSim;
    JPanel two = new JPanel();
    Road current;

    CreateSimPage(JFrame CreateSim) {
        this.CreateSim = CreateSim;
        this.CreateSim.setSize(1000, 800);
        this.CreateSim.setVisible(true);
        this.load();
    }

    void load() {
        CreateSim.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.weightx = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        Draw draw = new Draw();
        draw.setBackground(Color.green);
        two.setBackground(Color.orange);
        CreateSim.add(draw, c);

        c.gridx = 1;
        c.weightx = 0.35;
        CreateSim.add(two, c);
        two.setLayout(new GridLayout(3, 1));
        JButton add = new JButton("Add Road");
        JPanel details = new JPanel();
        details.setLayout(new GridBagLayout());
        JLabel lbl = new JLabel("Use arrow key to positon road");
        details.setBackground(Color.BLUE);
        add.addActionListener(actionEvent -> addRoad());


        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1;
        c.weighty = 0.33;
        JTextField x = new JTextField();
        JTextField y = new JTextField();
        JTextField orientation = new JTextField();
        JTextField length = new JTextField();
        JButton refresh = new JButton("Refresh Current Road");
        details.add(x, c);
        c.gridx = 1;
        details.add(y, c);
        c.gridx = 0;
        c.gridy = 1;
        details.add(orientation, c);
        c.gridx = 1;
        c.gridy = 1;
        details.add(length, c);
        c.gridwidth = 2;
        c.gridy = 2;
        c.gridx = 0;
        details.add(refresh, c);

        two.add(add);
        two.add(details);
        two.add(lbl);


        draw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    for (Road i : RoadList.index) {
                        if (((i.xStart <= e.getX()) && (i.xFinish >= e.getX())) && ((i.yStart <= e.getY() && (i.yFinish >= e.getY())))) {
                            if (i instanceof TrafficLight) {
                                current = i;
                            } else {
                                current = i;
                            }
                        }
                    }
                    x.setText(String.valueOf(current.xStart));
                    y.setText(String.valueOf(current.yStart));
                    orientation.setText(String.valueOf(current.orientation));
                    length.setText(String.valueOf(current.length));

                } catch (NullPointerException z) {
                    lbl.setText("No road found!");
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println(e.getX());
            }
        });

    }

    void addRoad() {
        RoadList list = new RoadList();
        Road temp = new Road(200, 203, 300, "horizontal");
        list.addElement(temp);
        CreateSim.repaint();
        System.out.println(RoadList.index);

    }
}
