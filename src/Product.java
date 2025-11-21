public class Product {
    
    private String name;
    private double price;
    private int stock;
    private String category;
    
    public Product(String name, double price, int stock, String category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getTotalValue() {
        return price * stock;
    }
    
    public boolean isInStock() {
        return stock > 0;
    }
    
    public boolean isLowStock() {
        return stock < 5;
    }
    
    public void displayInfo() {
        System.out.println("Product: " + name + " (" + category + ")");
        System.out.println("Price: " + price + " kr, Stock: " + stock);
    }
}
