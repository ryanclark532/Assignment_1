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
    JButton save = new JButton("Save and Exit");
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
        addButtons.setLayout(new GridLayout(3, 2));
        JButton addRoad = new JButton("Add Road");
        JButton addIntersection = new JButton("Add Intersection");
        JButton addTrafficLight = new JButton("Add Traffic Light");
        JButton clear = new JButton("Clear Configuration");
        JButton clearselect = new JButton("Clear Selected");
        clear.addActionListener(actionEvent -> RoadList.index.clear());
        addRoad.addActionListener(actionEvent -> addRoad());
        addTrafficLight.addActionListener(actionEvent -> addTrafficLight());
        addIntersection.addActionListener(actionEvent -> addIntersection());
        clearselect.addActionListener(actionEvent -> removeselected());
        addButtons.add(clearselect);
        addButtons.add(addRoad);
        addButtons.add(addIntersection);
        addButtons.add(addTrafficLight);
        addButtons.add(clear);

        two.add(addButtons);
        two.add(details);
        JPanel savePanel = new JPanel();
        savePanel.setLayout(new GridLayout(2, 1));
        savePanel.add(lbl);
        savePanel.add(save);
        two.add(savePanel);
        lbl.setText("Please click on a road to select it\n use WASD to move the selected road");
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
            JOptionPane.showInputDialog("Please use WASD");
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
        TrafficLight temp = new TrafficLight(300, 300, "horizontal");
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
            CreateSim.repaint();
        });
        timer.start();
    }

    void removeselected() {
        for (Road i : RoadList.index) {
            if (i.selected) {
                RoadList.index.remove(i);
            }
        }
    }
}
