package StudentManager;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportFromFIle {

    public static ArrayList<Student> importFromFile() {
        ArrayList<Student> students = new ArrayList<>();
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 4) {
                        String lastName = data[0];
                        String firstName = data[1];
                        String username = data[2];
                        String type = data[3];

                        if (type.equalsIgnoreCase("grad")) {
                            students.add(new GraduateStudent(firstName, lastName, username));
                        } else if (type.equalsIgnoreCase("undergraduate")) {
                            students.add(new UndergraduateStudent(firstName, lastName, username));
                        }
                    }
                }
                System.out.println("Students imported successfully.");
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
        return students;
    }
}
