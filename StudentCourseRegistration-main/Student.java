import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Course> registeredCourses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void registerCourse(Course course) {
        if (!registeredCourses.contains(course) && course.getCapacity() > 0) {
            registeredCourses.add(course);
            course.reduceCapacity();
            System.out.println("Course registered successfully!");
        } else {
            System.out.println("Cannot register. Either full or already registered.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.increaseCapacity();
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("Course not found in your registration list.");
        }
    }

    public void viewRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (Course c : registeredCourses) {
                System.out.println(c);
            }
        }
    }
}
