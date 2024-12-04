package StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students = ImportFromFIle.importFromFile();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1 - Display student list");
            System.out.println("2 - Input student grades");
            System.out.println("3 - Display final grades");
            System.out.println("4 - Show student count");
            System.out.println("5 - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    StudentDisplay.displayStudentList(students);
                    break;
                case 2:
                    inputStudentGrades(scanner);
                    break;
                case 3:
                    StudentDisplay.displayFinalGrades(students);
                    break;
                case 4:
                    Student.displayStudentCount();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void inputStudentGrades(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println("Enter grades for " + student + ":");
            System.out.print("Lab 1: ");
            double lab1 = scanner.nextDouble();
            System.out.print("Lab 2: ");
            double lab2 = scanner.nextDouble();
            System.out.print("Midterm: ");
            double midterm = scanner.nextDouble();
            System.out.print("Final Exam: ");
            double finalExam = scanner.nextDouble();
            student.setGrades(lab1, lab2, midterm, finalExam);
        }
        System.out.println("Grades updated.");
    }
}
