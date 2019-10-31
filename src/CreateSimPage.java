import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateSimPage {
    JFrame CreateSim;
    JPanel two = new JPanel();
    Road current;
    JTextField x = new JTextField();
    JTextField y = new JTextField();
    JTextField orientation = new JTextField();
    JTextField length = new JTextField();
    JButton refresh = new JButton("Refresh Current Road");
    JLabel lbl = new JLabel("Use arrow key to positon road");
    Draw draw = new Draw();
    JButton save = new JButton();
    CreateSimPage(JFrame CreateSim) {
        this.CreateSim = CreateSim;

    }

    void load() {
        this.CreateSim.setSize(1500, 800);
        CreateSim.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.weightx = 0;
        c.weightx = 0.8;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        draw.setBackground(Color.green);
        two.setBackground(Color.orange);
        CreateSim.add(draw, c);

        c.gridx = 1;
        c.weightx = 0.2;
        CreateSim.add(two, c);
        two.setLayout(new GridLayout(3, 1));

        JPanel details = new JPanel();
        details.setLayout(new GridBagLayout());
        JLabel lbl = new JLabel("Use arrow key to positon road");
        details.setBackground(Color.BLUE);

        save.addActionListener(actionEvent -> save());
        refresh.addActionListener(actionEvent -> refresh());
        c.gridy = 0;
        c.gridx = 0;
        c.weightx = 1;
        c.weighty = 0.33;

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

        JPanel addButtons = new JPanel();
        addButtons.setLayout(new GridLayout(2, 2));
        JButton addRoad = new JButton("Add Road");
        JButton addIntersection = new JButton("Add Intersection");
        JButton addTrafficLight = new JButton("Add Traffic Light");
        addRoad.addActionListener(actionEvent -> addRoad());
        addTrafficLight.addActionListener(actionEvent -> addTrafficLight());
        addIntersection.addActionListener(actionEvent -> addIntersection());
        addButtons.add(addRoad);
        addButtons.add(addIntersection);
        addButtons.add(addTrafficLight);

        two.add(addButtons);
        two.add(details);
        JPanel savePanel = new JPanel();
        savePanel.setLayout(new GridLayout(2, 1));
        savePanel.add(lbl);
        savePanel.add(save);
        two.add(savePanel);

        draw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                roadClick(e);
            }
        });
        draw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                moveRoad(e);
            }
        });
        Road first = new Road(200, 100, 300, "horizontal");
        Intersection intersection = new Intersection(300, 300, "horizontal");
        Road seocond = new Road(200, 330, 300, "horizontal");
        Road up = new Road(200, 300, 100, "vertical");
        Road down = new Road(200, 300, 330, "vertical");
        RoadList.index.add(first);
        RoadList.index.add(intersection);
        RoadList.index.add(seocond);
        RoadList.index.add(up);
        RoadList.index.add(down);
        repaint();

    }


    void moveRoad(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            current.xStart -= 10;
            current.xFinish -= 10;
        } else if (e.getKeyChar() == 's') {
            current.yStart += 10;
            current.yFinish += 10;
        } else if (e.getKeyChar() == 'd') {
            current.xStart += 10;
            current.xFinish += 10;
        } else if (e.getKeyChar() == 'w') {
            current.yStart -= 10;
            current.yFinish -= 10;
        } else {
            JOptionPane.showInputDialog("no");
        }
        x.setText(String.valueOf(current.xStart));
        y.setText(String.valueOf(current.yStart));
        orientation.setText(String.valueOf(current.orientation));
        length.setText(String.valueOf(current.length));

    }

    void roadClick(MouseEvent e) {
        try {
            for (Road i : RoadList.index) {
                if (i.selected) {
                    i.selected = false;
                }
                if (((i.xStart <= e.getX()) && (i.xFinish >= e.getX())) && ((i.yStart <= e.getY() && (i.yFinish >= e.getY())))) {
                    current = i;
                }
            }
            x.setText(String.valueOf(current.xStart));
            y.setText(String.valueOf(current.yStart));
            orientation.setText(String.valueOf(current.orientation));
            length.setText(String.valueOf(current.length));
            lbl.setText("Road selected");
            draw.grabFocus();
            current.selected = true;

        } catch (NullPointerException z) {
            lbl.setText("No road found!");
        }

    }

    void refresh() {
        try {
            current.xStart = Double.valueOf(x.getText());
            current.yStart = Double.valueOf(y.getText());
            current.orientation = orientation.getText();
            current.length = Double.valueOf(length.getText());
            current.selected = true;

        } catch (NullPointerException e) {
            lbl.setText("No road selected");
        }
    }

    void save() {
        HomePage.mainFrame.repaint();
        CreateSim.dispose();
    }


    void addRoad() {
        Road temp = new Road(200, 200, 300, "horizontal");
        RoadList.index.add(temp);
        for (Road i : RoadList.index) {
            if (i.selected) {
                i.selected = false;
            }
        }
        temp.selected = true;
        draw.grabFocus();
    }

    void addTrafficLight() {
        TrafficLight temp = new TrafficLight(40, 300, 300, "horizontal");
        RoadList.index.add(temp);
        for (Road i : RoadList.index) {
            if (i.selected) {
                i.selected = false;
            }
        }
        temp.selected = true;
        draw.grabFocus();
    }

    private void addIntersection() {
        Intersection temp = new Intersection(300, 300, "horizontal");
        for (Road i : RoadList.index) {
            if (i.selected) {
                i.selected = false;
            }
        }
        draw.grabFocus();
        temp.selected = true;
        RoadList.index.add(temp);

    }

    void repaint() {
        Timer timer = new Timer(1, actionEvent -> {
            for (Road i : RoadList.index) {
                for (Road x : RoadList.index) {
                    if (i == x) {
                        continue;
                    }
                    i.connected = ((i.xFinish == x.xStart) && (i.yStart == x.yStart)) || ((x.xFinish == i.xStart) && (x.yStart == i.yStart)) ||
                            ((x.xStart == i.xStart) && (x.yStart == i.yFinish)) || ((i.xStart == x.xStart) && (x.yFinish == i.yStart));

                }
            }

            CreateSim.repaint();
        });
        timer.start();
    }


}
