public class Course {
    private String code;
    private String title;
    private int capacity;

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void reduceCapacity() {
        capacity--;
    }

    public void increaseCapacity() {
        capacity++;
    }

    public String toString() {
        return code + " - " + title + " | Seats Left: " + capacity;
    }
}
