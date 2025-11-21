public class Person {
    
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;
    
    // Constructor with only name
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = 0;
        this.email = "";
        this.phoneNumber = "";
    }
    
    // Constructor with name and age
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = "";
        this.phoneNumber = "";
    }
    
    // Constructor with name, age, and email
    public Person(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = "";
    }
    
    // Constructor with all parameters
    public Person(String firstName, String lastName, int age, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    // Helper methods
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public boolean hasEmail() {
        return !email.isEmpty();
    }
    
    public boolean hasPhoneNumber() {
        return !phoneNumber.isEmpty();
    }
    
    public boolean isAdult() {
        return age >= 18;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + getFullName());
        System.out.println("Age: " + age);
        if (hasEmail()) {
            System.out.println("Email: " + email);
        }
        if (hasPhoneNumber()) {
            System.out.println("Phone: " + phoneNumber);
        }
    }
}
