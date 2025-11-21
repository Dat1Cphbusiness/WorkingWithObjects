public class Point {
    
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // Getters
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    // Setters
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    // Override toString() - WITHOUT this, printing object shows memory address
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
    
    // Override equals() - WITHOUT this, == compares memory addresses
    @Override
    public boolean equals(Object obj) {
        // Check if same object
        if (this == obj) {
            return true;
        }
        
        // Check if obj is null or different class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // Cast to Point and compare values
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
    
    // Helper methods
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    
    public double distanceTo(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
