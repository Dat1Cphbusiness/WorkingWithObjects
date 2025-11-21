public class Calculator2 {
    
    private double result;
    private String lastOperation;
    
    public Calculator2() {
        this.result = 0.0;
        this.lastOperation = "none";
    }
    
    public Calculator2(double initialValue) {
        this.result = initialValue;
        this.lastOperation = "initialized";
    }
    
    // Getters
    public double getResult() {
        return this.result;
    }
    
    public String getLastOperation() {
        return this.lastOperation;
    }
    
    // Setter
    public Calculator2 setResult(double result) {
        this.result = result;
        this.lastOperation = "set";
        return this;
    }
    
    // Chainable operations
    public Calculator2 add(double value) {
        this.result += value;
        this.lastOperation = "add";
        return this;
    }
    
    public Calculator2 subtract(double value) {
        this.result -= value;
        this.lastOperation = "subtract";
        return this;
    }
    
    public Calculator2 multiply(double value) {
        this.result *= value;
        this.lastOperation = "multiply";
        return this;
    }
    
    public Calculator2 divide(double value) {
        if (value != 0) {
            this.result /= value;
            this.lastOperation = "divide";
        } else {
            System.out.println("Cannot divide by zero!");
            this.lastOperation = "error";
        }
        return this;
    }
    
    public Calculator2 power(double exponent) {
        this.result = Math.pow(this.result, exponent);
        this.lastOperation = "power";
        return this;
    }
    
    public Calculator2 sqrt() {
        this.result = Math.sqrt(this.result);
        this.lastOperation = "sqrt";
        return this;
    }
    
    public Calculator2 negate() {
        this.result = -this.result;
        this.lastOperation = "negate";
        return this;
    }
    
    public Calculator2 clear() {
        this.result = 0.0;
        this.lastOperation = "clear";
        return this;
    }
    
    // Helper methods
    public void displayResult() {
        System.out.println("Result: " + this.result + " (last operation: " + this.lastOperation + ")");
    }
    
    public Calculator2 displayAndContinue() {
        this.displayResult();
        return this;
    }
}
