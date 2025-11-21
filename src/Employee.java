public class Employee {
    
    private String name;
    private String position;
    private double salary;
    private int yearsOfExperience;
    
    public Employee(String name, String position, double salary, int yearsOfExperience) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    // Helper methods
    public void giveRaise(double percentage) {
        salary = salary * (1 + percentage / 100.0);
        System.out.println(name + " received a " + percentage + "% raise. New salary: " + salary + " kr");
    }
    
    public void promote(String newPosition, double salaryIncrease) {
        position = newPosition;
        salary += salaryIncrease;
        System.out.println(name + " promoted to " + position + " with salary increase of " + salaryIncrease + " kr");
    }
    
    public void addExperience(int years) {
        yearsOfExperience += years;
        System.out.println(name + " now has " + yearsOfExperience + " years of experience");
    }
    
    public void displayInfo() {
        System.out.println("Employee: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary + " kr");
        System.out.println("Experience: " + yearsOfExperience + " years");
    }
}
