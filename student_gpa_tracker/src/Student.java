
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private int id;
    private ArrayList<Integer> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);

    }

    public double calculateGPA() {
        if (grades.size() == 0) {
            return 0;
        }
        double totalPoints = 0.0;

        for(int grade: grades) {
            if (grade >= 98) {
                totalPoints += 4.0;
            }
            else if (grade >= 80) {
                totalPoints += 3.0;
            }
            else if (grade >= 70) {
                totalPoints += 2.0;
            }
            else if (grade >= 60) {
                totalPoints += 1.0;
            }
            else{
                totalPoints += 0.0;
            }
        }
        return totalPoints / grades.size();
    }

    public void printStudentInfo(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("GPA: %.2f\n", calculateGPA());
        System.out.println("--------------");
    }

}


