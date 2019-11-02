import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LS {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    void save() throws IOException {
        JFileChooser file = new JFileChooser(System.getProperty("user.dir"));
        file.showDialog(Main.mainFrame, "Save");
        StringBuilder csvWriter = new StringBuilder();
        FileWriter output = new FileWriter(file.getSelectedFile().getAbsoluteFile() + ".csv");
        for (Road i : RoadList.index) {
            csvWriter.append(i.getClass());
            csvWriter.append(",");
            csvWriter.append(i.length);
            csvWriter.append(",");
            csvWriter.append((int) i.xStart);
            csvWriter.append(",");
            csvWriter.append((int) i.yStart);
            csvWriter.append(",");
            csvWriter.append(i.orientation);

            csvWriter.append("\n");
            output.write(String.valueOf(csvWriter));
            csvWriter.setLength(0);
        }
        output.flush();
        output.close();

    }

    void load() throws IOException {
        RoadList.index.clear();
        JFileChooser file = new JFileChooser(System.getProperty("user.dir"));
        file.showDialog(Main.mainFrame, "Open");
        BufferedReader currentfile = new BufferedReader(new FileReader(file.getSelectedFile().getAbsoluteFile()));
        String row;
        while ((row = currentfile.readLine()) != null) {

            String[] newRow = row.split(",");
            if (newRow[0].equals("class Intersection")) {
                Intersection new1 = new Intersection(Double.parseDouble(newRow[2]), Double.parseDouble(newRow[3]), "horizontal");
                RoadList.index.add(new1);
            } else if (newRow[0].equals("class TrafficLight")) {
                TrafficLight new2 = new TrafficLight(Double.parseDouble(newRow[2]), Double.parseDouble(newRow[3]), "horizontal");
                RoadList.index.add(new2);
            } else {
                Road new3 = new Road((int) Double.parseDouble(newRow[1]), Double.parseDouble(newRow[2]), Double.parseDouble(newRow[3]), newRow[4]);
                RoadList.index.add(new3);
            }
        }

    }
}
