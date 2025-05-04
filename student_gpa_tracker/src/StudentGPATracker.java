import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGPATracker{

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++){
            System.out.println("\n==== Entering data for Student " + (i + 1) + "----");

            System.out.println("Enter student name: ");
            String name = scanner.nextLine();

            System.out.println("Enter student ID: ");
            int id = scanner.nextInt();

            Student student = new Student(name, id);

            System.out.println("How many grades for this student? ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++){
                System.out.println("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }

            students.add(student);
            scanner.nextLine();
        }

    }
}