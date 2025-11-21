public class Counter {
    
    private int value;
    private String name;
    
    public Counter(String name) {
        this.name = name;
        this.value = 0;
    }
    
    public Counter(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    // Getters
    public int getValue() {
        return this.value;
    }
    
    public String getName() {
        return this.name;
    }
    
    // Setters
    public void setValue(int value) {
        this.value = value;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Methods that return this for chaining
    public Counter increment() {
        this.value++;
        return this;
    }
    
    public Counter decrement() {
        this.value--;
        return this;
    }
    
    public Counter add(int amount) {
        this.value += amount;
        return this;
    }
    
    public Counter subtract(int amount) {
        this.value -= amount;
        return this;
    }
    
    public Counter reset() {
        this.value = 0;
        return this;
    }
    
    public Counter multiplyBy(int factor) {
        this.value *= factor;
        return this;
    }
    
    // Regular methods
    public void displayInfo() {
        System.out.println("Counter: " + this.name + " = " + this.value);
    }
    
    public boolean isPositive() {
        return this.value > 0;
    }
    
    public boolean isZero() {
        return this.value == 0;
    }
}
