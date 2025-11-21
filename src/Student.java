public class Student {
    
    private String name;
    private int age;
    private double grade;
    private String studentId;
    
    public Student(String name, int age, double grade, String studentId) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentId = studentId;
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
    
    public String getStudentId() {
        return studentId;
    }
    
    public void displayInfo() {
        System.out.println("Student: " + name + " (ID: " + studentId + ")");
        System.out.println("Age: " + age + ", Grade: " + grade);
    }
    
    public boolean isPassing() {
        return grade >= 2.0;
    }
}
