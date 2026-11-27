import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRegistration {

    private static final List<Student> students = new ArrayList<>();

    static class Student {
        private final String name;
        private final int age;
        private final double grade;

        public Student(String name, int age, double grade) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be null or empty.");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Student age cannot be negative.");
            }
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException("Student grade must be between 0 and 100.");
            }

            this.name = name.trim();
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Student)) return false;
            Student other = (Student) obj;
            return age == other.age
                    && Double.compare(other.grade, grade) == 0
                    && name.equalsIgnoreCase(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name.toLowerCase(), age, grade);
        }

        @Override
        public String toString() {
            return String.format("Name: %s | Age: %d | Grade: %.2f", name, age, grade);
        }
    }

    public static void addStudent(String name, int age, double grade) {
        try {
            Student student = new Student(name, age, grade);

            if (students.contains(student)) {
                System.out.println("Duplicate record rejected: " + student.getName() + " is already registered.");
                return;
            }

            students.add(student);
            System.out.println("Student Added! -> " + student);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to add student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while adding student: " + e.getMessage());
        }
    }

    public static void displayStudents() {
        System.out.println("\n--- Registered Students ---");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        addStudent("", -5, 150);     // Invalid input: rejected
        addStudent("John", 20, 85);  // Valid input: added
        addStudent("John", 20, 85);  // Duplicate entry: rejected

        displayStudents();
    }
}