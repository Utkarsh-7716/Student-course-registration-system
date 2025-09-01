import java.util.List;

public class Admin {
    public static void addCourse(List<Course> courseList, String code, String title, int capacity) {
        courseList.add(new Course(code, title, capacity));
        System.out.println("Course added successfully.");
    }

    public static void removeCourse(List<Course> courseList, String code) {
        courseList.removeIf(course -> course.getCode().equalsIgnoreCase(code));
        System.out.println("Course removed.");
    }
}
