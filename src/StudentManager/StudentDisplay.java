package StudentManager;

import java.util.ArrayList;

public class StudentDisplay {
    public static void displayStudentList(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void displayFinalGrades(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            double finalGrade = student.calculateFinalGrade();
            System.out.println("Student: " + student + " , Final Grade: " + finalGrade);
        }
    }
}
