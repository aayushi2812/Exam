package StudentManager;

abstract class Student {
    String firstName;
    String lastName;
    String username;
    double lab1 = 0, lab2 = 0, midterm = 0, finalExam = 0;
    static int graduateCount = 0;
    static int undergraduateCount = 0;

    public Student(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    abstract double calculateFinalGrade();

    public void setGrades(double lab1, double lab2, double midterm, double finalExam) {
        this.lab1 = lab1;
        this.lab2 = lab2;
        this.midterm = midterm;
        this.finalExam = finalExam;
    }

    public static void displayStudentCount() {
        System.out.println("Graduate Students: " + graduateCount);
        System.out.println("Undergraduate Students: " + undergraduateCount);
    }

    public String toString() {
        return String.format(firstName + " " + lastName + " " + username);
    }
}

class GraduateStudent extends Student {
    public GraduateStudent(String firstName, String lastName, String username) {
        super(firstName, lastName, username);
        graduateCount++;
    }

    double calculateFinalGrade() {
        double labAverage = (lab1 + lab2) / 2;
        return labAverage * 0.2 + midterm * 0.3 + finalExam * 0.5;
    }
}

class UndergraduateStudent extends Student {
    public UndergraduateStudent(String firstName, String lastName, String username) {
        super(firstName, lastName, username);
        undergraduateCount++;
    }

    double calculateFinalGrade() {
        double labAverage = (lab1 + lab2) / 2;
        return labAverage * 0.2 + midterm * 0.3 + finalExam * 0.5;
    }
}

