public class Rectangle {
    
    private double width;
    private double height;
    private String color;
    
    // Default constructor
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.color = "white";
    }
    
    // Constructor with width and height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.color = "white";
    }
    
    // Constructor with all parameters
    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    // Getters
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public String getColor() {
        return color;
    }
    
    // Setters
    public void setWidth(double width) {
        this.width = width;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    // Helper methods
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    public boolean isSquare() {
        return width == height;
    }
    
    public void displayInfo() {
        System.out.println("Rectangle: " + width + " x " + height);
        System.out.println("Color: " + color);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
