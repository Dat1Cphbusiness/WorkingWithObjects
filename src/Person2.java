public class Person2 {
    
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    
    public Person2(String firstName, String lastName, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    
    // Getters
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getEmail() {
        return this.email;
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
    
    // Override toString()
    @Override
    public String toString() {
        return firstName + " " + lastName + " (age " + age + ", " + email + ")";
    }
    
    // Override equals() - two persons are equal if all fields match
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Person2 other = (Person2) obj;
        return this.age == other.age &&
               this.firstName.equals(other.firstName) &&
               this.lastName.equals(other.lastName) &&
               this.email.equals(other.email);
    }
    
    // Helper methods
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public boolean hasSameNameAs(Person2 other) {
        return this.firstName.equals(other.firstName) && 
               this.lastName.equals(other.lastName);
    }
    
    public boolean isAdult() {
        return this.age >= 18;
    }
    
    // Alternative toString formats
    public String toStringFormal() {
        return lastName + ", " + firstName;
    }
    
    public String toStringShort() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}
