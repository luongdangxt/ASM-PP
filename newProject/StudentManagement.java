import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String fullName;
    private int age;

    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Full Name='" + fullName + '\'' +
                ", Age=" + age +
                '}';
    }
}

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentsByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < num; i++) {
            System.out.print("Enter full name of student " + (i + 1) + ": ");
            String fullName = scanner.nextLine();
            System.out.print("Enter age of student " + (i + 1) + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            students.add(new Student(fullName, age));
        }
        System.out.println("Student list entered successfully!");
    }

    private static void findStudentsByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            String[] names = student.getFullName().split(" ");
            if (names[names.length - 1].equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with the last name: " + lastName);
        }
    }

    private static void findAndEditStudentByFullName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("Student found: " + student);
                System.out.print("Enter new full name: ");
                String newFullName = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                student.setFullName(newFullName);
                student.setAge(newAge);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No students found with the full name: " + fullName);
        }
    }
}
