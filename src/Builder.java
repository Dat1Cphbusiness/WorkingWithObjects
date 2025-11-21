public class Builder {
    
    private String name;
    private int age;
    private String email;
    private String address;
    private String phoneNumber;
    private boolean isActive;
    
    public Builder() {
        this.name = "";
        this.age = 0;
        this.email = "";
        this.address = "";
        this.phoneNumber = "";
        this.isActive = true;
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public boolean isActive() {
        return this.isActive;
    }
    
    // Builder methods that return this
    public Builder setName(String name) {
        this.name = name;
        return this;
    }
    
    public Builder setAge(int age) {
        this.age = age;
        return this;
    }
    
    public Builder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }
    
    public Builder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    public Builder setActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }
    
    public Builder activate() {
        this.isActive = true;
        return this;
    }
    
    public Builder deactivate() {
        this.isActive = false;
        return this;
    }
    
    // Helper method
    public void displayInfo() {
        System.out.println("=== Builder Object ===");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Email: " + this.email);
        System.out.println("Address: " + this.address);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Active: " + this.isActive);
    }
}
