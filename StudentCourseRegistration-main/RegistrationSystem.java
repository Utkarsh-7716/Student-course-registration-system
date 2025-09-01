import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationSystem {
    private static List<Course> courseList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedCourses(); // Pre-added sample courses

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student student = new Student(name, id);

        while (true) {
            System.out.println("\n===== Course Registration Menu =====");
            System.out.println("1. View All Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Admin: Add Course");
            System.out.println("6. Admin: Remove Course");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> viewAllCourses();
                case 2 -> {
                    viewAllCourses();
                    System.out.print("Enter course code to register: ");
                    String code = sc.nextLine();
                    Course c = findCourse(code);
                    if (c != null) student.registerCourse(c);
                    else System.out.println("Invalid course code.");
                }
                case 3 -> {
                    student.viewRegisteredCourses();
                    System.out.print("Enter course code to drop: ");
                    String code = sc.nextLine();
                    Course c = findCourse(code);
                    if (c != null) student.dropCourse(c);
                    else System.out.println("Invalid course code.");
                }
                case 4 -> student.viewRegisteredCourses();
                case 5 -> {
                    System.out.print("Enter new course code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter capacity: ");
                    int cap = Integer.parseInt(sc.nextLine());
                    Admin.addCourse(courseList, code, title, cap);
                }
                case 6 -> {
                    System.out.print("Enter course code to remove: ");
                    String code = sc.nextLine();
                    Admin.removeCourse(courseList, code);
                }
                case 0 -> {
                    System.out.println("Thank you! Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void seedCourses() {
        courseList.add(new Course("CS101", "Data Structures", 3));
        courseList.add(new Course("CS102", "OOP in Java", 2));
        courseList.add(new Course("CS103", "Operating Systems", 2));
    }

    private static void viewAllCourses() {
        System.out.println("Available Courses:");
        for (Course c : courseList) {
            System.out.println(c);
        }
    }

    private static Course findCourse(String code) {
        for (Course c : courseList) {
            if (c.getCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }
}
