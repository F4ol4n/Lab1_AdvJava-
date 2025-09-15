import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private double grade;

    // Constructor
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

public class Task3 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // 1. Add multiple students
        students.add(new Student(1, "Alice", 85.5));
        students.add(new Student(2, "Bob", 90.2));
        students.add(new Student(3, "Charlie", 78.0));
        students.add(new Student(4, "David", 92.5));

        // 2. Display all students
        System.out.println("\n--- List of Students ---");
        for (Student s : students) {
            System.out.println(s);
        }

        // 3. Search by ID
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == searchId) {
                System.out.println("Found: " + s);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }

        // 4. Remove a student by ID
        System.out.print("\nEnter ID to remove: ");
        int removeId = sc.nextInt();
        students.removeIf(s -> s.getId() == removeId);

        System.out.println("\n--- After Removal ---");
        for (Student s : students) {
            System.out.println(s);
        }

        // 5. Sort by grade (descending)
        Collections.sort(students, Comparator.comparingDouble(Student::getGrade).reversed());

        System.out.println("\n--- Sorted by Grade (Descending) ---");
        for (Student s : students) {
            System.out.println(s);
        }

        sc.close();
    }
}
