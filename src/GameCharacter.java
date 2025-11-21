public class GameCharacter {
    
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private int level;
    
    public GameCharacter(String name, int maxHealth, int attackPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.level = 1;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int getAttackPower() {
        return attackPower;
    }
    
    public int getLevel() {
        return level;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHealth(int health) {
        if (health > maxHealth) {
            this.health = maxHealth;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }
    
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    // Helper methods
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " took " + damage + " damage. Health: " + health + "/" + maxHealth);
    }
    
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
        System.out.println(name + " healed " + amount + " HP. Health: " + health + "/" + maxHealth);
    }
    
    public void levelUp() {
        level++;
        maxHealth += 10;
        health = maxHealth;
        attackPower += 5;
        System.out.println(name + " leveled up to level " + level + "!");
        System.out.println("Max Health: " + maxHealth + ", Attack Power: " + attackPower);
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public void displayStats() {
        System.out.println("=== " + name + " ===");
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Attack Power: " + attackPower);
    }
}
