public class StudentRegistry {
    
    // Static field - shared by all instances
    private static int totalStudents = 0;
    private static int nextId = 1000;
    
    // Instance fields - unique to each instance
    private int studentId;
    private String name;
    private double grade;
    
    // Constructor
    public StudentRegistry(String name, double grade) {
        this.studentId = nextId++;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }
    
    // Static methods - operate on static data
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public static int getNextId() {
        return nextId;
    }
    
    public static void resetRegistry() {
        totalStudents = 0;
        nextId = 1000;
        System.out.println("Registry reset. Total students: " + totalStudents);
    }
    
    public static double calculateAverageGrade(StudentRegistry[] students) {
        if (students.length == 0) return 0.0;
        
        double sum = 0;
        for (StudentRegistry student : students) {
            sum += student.grade;
        }
        return sum / students.length;
    }
    
    // Instance methods - operate on instance data
    public int getStudentId() {
        return this.studentId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getGrade() {
        return this.grade;
    }
    
    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    public void displayInfo() {
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Name: " + this.name);
        System.out.println("Grade: " + this.grade);
    }
    
    public boolean isPassing() {
        return this.grade >= 2.0;
    }
}
