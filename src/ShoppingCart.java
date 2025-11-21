public class ShoppingCart {
    
    private String customerName;
    private double totalPrice;
    private int itemCount;
    private boolean isPremiumMember;
    
    public ShoppingCart(String customerName) {
        this.customerName = customerName;
        this.totalPrice = 0.0;
        this.itemCount = 0;
        this.isPremiumMember = false;
    }
    
    // Getters
    public String getCustomerName() {
        return customerName;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public int getItemCount() {
        return itemCount;
    }
    
    public boolean isPremiumMember() {
        return isPremiumMember;
    }
    
    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    
    public void setPremiumMember(boolean isPremiumMember) {
        this.isPremiumMember = isPremiumMember;
    }
    
    // Helper methods
    public void addItem(double price) {
        totalPrice += price;
        itemCount++;
        System.out.println("Added item for " + price + " kr. Total: " + totalPrice + " kr (" + itemCount + " items)");
    }
    
    public void removeItem(double price) {
        if (itemCount > 0) {
            totalPrice -= price;
            itemCount--;
            System.out.println("Removed item for " + price + " kr. Total: " + totalPrice + " kr (" + itemCount + " items)");
        } else {
            System.out.println("Cart is empty!");
        }
    }
    
    public void applyDiscount(double percentage) {
        double discount = totalPrice * (percentage / 100.0);
        totalPrice -= discount;
        System.out.println("Applied " + percentage + "% discount. Saved " + discount + " kr. New total: " + totalPrice + " kr");
    }
    
    public void clearCart() {
        totalPrice = 0.0;
        itemCount = 0;
        System.out.println("Cart cleared for " + customerName);
    }
    
    public double calculateFinalPrice() {
        double finalPrice = totalPrice;
        if (isPremiumMember) {
            finalPrice *= 0.9; // 10% discount for premium members
        }
        if (totalPrice > 1000) {
            finalPrice -= 100; // 100 kr off for orders over 1000 kr
        }
        return finalPrice;
    }
    
    public void displayCart() {
        System.out.println("=== Shopping Cart: " + customerName + " ===");
        System.out.println("Items: " + itemCount);
        System.out.println("Total: " + totalPrice + " kr");
        System.out.println("Premium Member: " + isPremiumMember);
        System.out.println("Final Price: " + calculateFinalPrice() + " kr");
    }
}
