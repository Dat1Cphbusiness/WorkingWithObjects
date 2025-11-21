public class Car {
    
    private String brand;
    private String color;
    private int speed;
    
    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }
    
    public void start() {
        System.out.println("The " + color + " " + brand + " is starting...");
    }
    
    public void accelerate() {
        speed += 10;
        System.out.println(brand + " is accelerating. Speed: " + speed + " km/h");
    }
    
    public void brake() {
        if (speed >= 10) {
            speed -= 10;
        } else {
            speed = 0;
        }
        System.out.println(brand + " is braking. Speed: " + speed + " km/h");
    }
    
    public void honk() {
        System.out.println(brand + " says: BEEP BEEP!");
    }
    
    public void displayInfo() {
        System.out.println("Car: " + brand + ", Color: " + color + ", Speed: " + speed + " km/h");
    }
}
