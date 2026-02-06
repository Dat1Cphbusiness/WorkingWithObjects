# Level 7: Object Interaction

## Begrebsgennemgang

### Hvad Du Allerede Kan

I Level 6 lærte du at skrive instance methods der arbejder med objektets egen state:

```java
class Car {
    String brand;
    int speed;
    
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    
    void accelerate(int amount) {
        speed = speed + amount;
    }
}

void main() {
    Car tesla = new Car("Tesla", 0);
    tesla.accelerate(50);  // Bilen ændrer sin egen state
}
```

Men hvad hvis to objekter skal interagere? Hvad hvis en bil skal køre mod en destination? Hvad hvis en atlet skal konkurrere mod en anden atlet?

---

## Problemet: Objekter Er Isolerede

Hidtil har objekter kun arbejdet med deres egen state:

```java
class Athlete {
    String name;
    int score;
    
    void addPoints(int points) {
        score = score + points;  // Kun egen score
    }
}

void main() {
    Athlete anna = new Athlete("Anna", 100);
    Athlete mikkel = new Athlete("Mikkel", 120);
    
    // Hvordan kan de konkurrere mod hinanden?
    // Hvordan kan anna sammenligne sin score med mikkel?
}
```

**Vi har brug for at objekter kan interagere!**

---

## Løsningen: Objekter som Parametre

Du kan sende objekter som parametre til instance methods:

```java
class Athlete {
    String name;
    int score;
    
    Athlete(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    void compete(Athlete opponent) {
        if (score > opponent.score) {
            score = score + 10;
            System.out.println(name + " beats " + opponent.name);
        } else {
            opponent.score = opponent.score + 10;
            System.out.println(opponent.name + " beats " + name);
        }
    }
}

void main() {
    Athlete anna = new Athlete("Anna", 100);
    Athlete mikkel = new Athlete("Mikkel", 120);
    
    anna.compete(mikkel);  // Anna konkurrerer mod Mikkel
}
```

**Nu kan objekter interagere!**

---

## Objekter som Parametre - Grundlæggende

**Syntaks:**
```java
void methodName(ClassName objectName) {
    // Brug objectName
}
```

**Eksempel:**
```java
class Car {
    String brand;
    int speed;
    
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    
    void race(Car opponent) {
        System.out.println(brand + " races " + opponent.brand);
        if (speed > opponent.speed) {
            System.out.println(brand + " wins!");
        } else {
            System.out.println(opponent.brand + " wins!");
        }
    }
}

void main() {
    Car ferrari = new Car("Ferrari", 200);
    Car porsche = new Car("Porsche", 180);
    
    ferrari.race(porsche);
}
```

**Output:**
```
Ferrari races Porsche
Ferrari wins!
```

---

## Læse fra Andre Objekter

En instance method kan læse data fra et andet objekt:

```java
class Player {
    String name;
    int level;
    int health;
    
    Player(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }
    
    boolean isStrongerThan(Player other) {
        return level > other.level;
    }
    
    void printComparison(Player other) {
        System.out.println(name + " (lvl " + level + ") vs " + 
                         other.name + " (lvl " + other.level + ")");
        if (isStrongerThan(other)) {
            System.out.println(name + " is stronger!");
        } else {
            System.out.println(other.name + " is stronger!");
        }
    }
}

void main() {
    Player warrior = new Player("Warrior", 50, 100);
    Player mage = new Player("Mage", 45, 80);
    
    warrior.printComparison(mage);
}
```

---

## Modificere Andre Objekter

En instance method kan ændre et andet objekts state:

```java
class BankAccount {
    String owner;
    double balance;
    
    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
    
    void transfer(BankAccount target, double amount) {
        if (balance >= amount) {
            balance = balance - amount;           // Ændrer egen balance
            target.balance = target.balance + amount;  // Ændrer target's balance
            System.out.println("Transferred " + amount + " kr to " + target.owner);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    
    void printBalance() {
        System.out.println(owner + ": " + balance + " kr");
    }
}

void main() {
    BankAccount anna = new BankAccount("Anna", 1000);
    BankAccount mikkel = new BankAccount("Mikkel", 500);
    
    anna.transfer(mikkel, 300);
    
    anna.printBalance();   // Anna: 700 kr
    mikkel.printBalance(); // Mikkel: 800 kr
}
```

---

## Objekter Kalder Metoder på Andre Objekter

Et objekt kan kalde methods på et andet objekt:

```java
class Character {
    String name;
    int health;
    int attackPower;
    
    Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    
    void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
        }
    }
    
    void attack(Character target) {
        System.out.println(name + " attacks " + target.name + "!");
        target.takeDamage(attackPower);  // Kalder target's metode
    }
    
    void printStatus() {
        System.out.println(name + ": " + health + " HP");
    }
}

void main() {
    Character warrior = new Character("Warrior", 100, 20);
    Character goblin = new Character("Goblin", 50, 10);
    
    warrior.attack(goblin);  // Warrior kalder attack på goblin
    goblin.attack(warrior);
    
    warrior.printStatus();
    goblin.printStatus();
}
```

---

## Composition: Objekter Indeholder Objekter

Et objekt kan indeholde andre objekter som instance variables:

```java
class Engine {
    int horsePower;
    String type;
    
    Engine(int horsePower, String type) {
        this.horsePower = horsePower;
        this.type = type;
    }
    
    void printInfo() {
        System.out.println(type + " engine: " + horsePower + " HP");
    }
}

class Car {
    String brand;
    Engine engine;  // Car HAR EN Engine
    
    Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }
    
    void printInfo() {
        System.out.println("Car: " + brand);
        engine.printInfo();  // Kalder engine's metode
    }
}

void main() {
    Engine v8 = new Engine(450, "V8");
    Car mustang = new Car("Mustang", v8);
    
    mustang.printInfo();
}
```

**Output:**
```
Car: Mustang
V8 engine: 450 HP
```

**Dette kaldes "composition" - Car HAR EN Engine.**

---

## Composition vs Arrays

**Array af objekter:**
```java
Player[] team = new Player[5];  // Mange separate objekter
```

**Composition:**
```java
class Team {
    String name;
    Player captain;  // Team HAR EN captain
    
    Team(String name, Player captain) {
        this.name = name;
        this.captain = captain;
    }
}
```

**Forskel:**
- Array: Samling af lignende objekter
- Composition: Et objekt er en del af et andet objekt

---

## Composition med Multiple Objekter

Et objekt kan indeholde flere andre objekter:

```java
class Address {
    String street;
    String city;
    
    Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    
    void printAddress() {
        System.out.println(street + ", " + city);
    }
}

class Restaurant {
    String name;
    Address location;
    String cuisine;
    
    Restaurant(String name, Address location, String cuisine) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
    }
    
    void printInfo() {
        System.out.println(name + " (" + cuisine + ")");
        System.out.print("Location: ");
        location.printAddress();
    }
}

void main() {
    Address addr = new Address("Bredgade 45", "Copenhagen");
    Restaurant noma = new Restaurant("Noma", addr, "Nordic");
    
    noma.printInfo();
}
```

---

## Objekter i Objekter i Objekter

Composition kan gå flere niveauer dybt:

```java
class Ingredient {
    String name;
    int calories;
    
    Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}

class Dish {
    String name;
    Ingredient mainIngredient;
    
    Dish(String name, Ingredient mainIngredient) {
        this.name = name;
        this.mainIngredient = mainIngredient;
    }
    
    int getTotalCalories() {
        return mainIngredient.calories;
    }
}

class Menu {
    String restaurantName;
    Dish specialDish;
    
    Menu(String restaurantName, Dish specialDish) {
        this.restaurantName = restaurantName;
        this.specialDish = specialDish;
    }
    
    void printSpecial() {
        System.out.println(restaurantName + " special:");
        System.out.println(specialDish.name);
        System.out.println("Main ingredient: " + specialDish.mainIngredient.name);
        System.out.println("Calories: " + specialDish.getTotalCalories());
    }
}

void main() {
    Ingredient salmon = new Ingredient("Salmon", 350);
    Dish grilledSalmon = new Dish("Grilled Salmon", salmon);
    Menu menu = new Menu("Ocean View", grilledSalmon);
    
    menu.printSpecial();
}
```

---

## Multiple Objekter Arbejder Sammen

Flere objekter kan samarbejde om en opgave:

```java
class Driver {
    String name;
    int skill;
    
    Driver(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }
}

class Car {
    String brand;
    int speed;
    Driver driver;
    
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
        this.driver = null;
    }
    
    void assignDriver(Driver d) {
        driver = d;
        System.out.println(d.name + " is now driving " + brand);
    }
    
    int getEffectiveSpeed() {
        if (driver == null) {
            return 0;
        }
        return speed + driver.skill;
    }
    
    void printInfo() {
        System.out.println(brand);
        if (driver != null) {
            System.out.println("Driver: " + driver.name);
            System.out.println("Effective speed: " + getEffectiveSpeed());
        } else {
            System.out.println("No driver");
        }
    }
}

void main() {
    Car ferrari = new Car("Ferrari", 200);
    Driver anna = new Driver("Anna", 50);
    
    ferrari.assignDriver(anna);
    ferrari.printInfo();
}
```

---

## Null Check - Sikkerhed

Når et objekt kan være null, skal du checke før du bruger det:

```java
class Team {
    String name;
    Player captain;
    
    Team(String name) {
        this.name = name;
        this.captain = null;  // Starter uden captain
    }
    
    void assignCaptain(Player p) {
        captain = p;
    }
    
    void printTeam() {
        System.out.println("Team: " + name);
        if (captain != null) {
            System.out.println("Captain: " + captain.name);
        } else {
            System.out.println("No captain assigned");
        }
    }
}
```

**Altid check for null før du tilgår objektets members!**

---

## Arrays i Objekter (Composition + Collection)

Et objekt kan have et array af andre objekter:

```java
class Player {
    String name;
    int score;
    
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Team {
    String name;
    Player[] players;
    int playerCount;
    
    Team(String name, int maxPlayers) {
        this.name = name;
        this.players = new Player[maxPlayers];
        this.playerCount = 0;
    }
    
    void addPlayer(Player p) {
        if (playerCount < players.length) {
            players[playerCount] = p;
            playerCount = playerCount + 1;
        }
    }
    
    int getTotalScore() {
        int total = 0;
        for (int i = 0; i < playerCount; i++) {
            total = total + players[i].score;
        }
        return total;
    }
    
    void printTeam() {
        System.out.println("Team: " + name);
        for (int i = 0; i < playerCount; i++) {
            System.out.println("- " + players[i].name + ": " + players[i].score);
        }
        System.out.println("Total score: " + getTotalScore());
    }
}

void main() {
    Team redTeam = new Team("Red Team", 5);
    
    redTeam.addPlayer(new Player("Anna", 100));
    redTeam.addPlayer(new Player("Mikkel", 150));
    redTeam.addPlayer(new Player("Sofie", 120));
    
    redTeam.printTeam();
}
```

---

## Objekter Returnerer Objekter

Instance methods kan returnere objekter:

```java
class Item {
    String name;
    double price;
    
    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Shop {
    String name;
    Item[] inventory;
    int itemCount;
    
    Shop(String name, int maxItems) {
        this.name = name;
        this.inventory = new Item[maxItems];
        this.itemCount = 0;
    }
    
    void addItem(Item item) {
        if (itemCount < inventory.length) {
            inventory[itemCount] = item;
            itemCount = itemCount + 1;
        }
    }
    
    Item findCheapest() {
        if (itemCount == 0) {
            return null;
        }
        
        Item cheapest = inventory[0];
        for (int i = 1; i < itemCount; i++) {
            if (inventory[i].price < cheapest.price) {
                cheapest = inventory[i];
            }
        }
        return cheapest;
    }
}

void main() {
    Shop electronics = new Shop("Electronics Store", 10);
    
    electronics.addItem(new Item("Mouse", 299));
    electronics.addItem(new Item("Keyboard", 599));
    electronics.addItem(new Item("Monitor", 2499));
    
    Item cheapest = electronics.findCheapest();
    System.out.println("Cheapest: " + cheapest.name + " - " + cheapest.price + " kr");
}
```

---

## Objekter Kommunikerer Begge Veje

To objekter kan kommunikere frem og tilbage:

```java
class Customer {
    String name;
    double money;
    
    Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }
    
    boolean canAfford(Product product) {
        return money >= product.price;
    }
    
    void buy(Product product) {
        if (canAfford(product)) {
            money = money - product.price;
            product.sell();
            System.out.println(name + " bought " + product.name);
        } else {
            System.out.println(name + " cannot afford " + product.name);
        }
    }
}

class Product {
    String name;
    double price;
    int stock;
    
    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    void sell() {
        if (stock > 0) {
            stock = stock - 1;
        }
    }
}

void main() {
    Customer anna = new Customer("Anna", 500);
    Product laptop = new Product("Laptop", 8999, 5);
    Product mouse = new Product("Mouse", 299, 10);
    
    anna.buy(laptop);  // Cannot afford
    anna.buy(mouse);   // Success
}
```

---

## Complex System: Game med Multiple Interaktioner

```java
class Weapon {
    String name;
    int damage;
    
    Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
}

class Character {
    String name;
    int health;
    Weapon weapon;
    
    Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.weapon = null;
    }
    
    void equip(Weapon w) {
        weapon = w;
        System.out.println(name + " equipped " + w.name);
    }
    
    void attack(Character target) {
        if (weapon == null) {
            System.out.println(name + " has no weapon!");
            return;
        }
        
        System.out.println(name + " attacks " + target.name + " with " + weapon.name);
        target.takeDamage(weapon.damage);
    }
    
    void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " takes " + damage + " damage. Health: " + health);
    }
    
    boolean isAlive() {
        return health > 0;
    }
}

void main() {
    Character hero = new Character("Hero", 100);
    Character monster = new Character("Monster", 80);
    
    Weapon sword = new Weapon("Iron Sword", 25);
    Weapon axe = new Weapon("Battle Axe", 30);
    
    hero.equip(sword);
    monster.equip(axe);
    
    hero.attack(monster);
    monster.attack(hero);
    hero.attack(monster);
    
    System.out.println("Hero alive: " + hero.isAlive());
    System.out.println("Monster alive: " + monster.isAlive());
}
```

---

## Common Patterns

### Pattern 1: Sammenligning
```java
boolean isBetterThan(Player other) {
    return score > other.score;
}
```

### Pattern 2: Interaktion
```java
void attack(Enemy target) {
    target.takeDamage(attackPower);
}
```

### Pattern 3: Transfer
```java
void giveTo(Player receiver, Item item) {
    inventory.remove(item);
    receiver.inventory.add(item);
}
```

### Pattern 4: Composition
```java
class Car {
    Engine engine;  // HAR EN
    
    Car(Engine engine) {
        this.engine = engine;
    }
}
```

---

## Debugging Tips

**Problem:** NullPointerException
```java
class Team {
    Player captain;
    
    void printCaptain() {
        System.out.println(captain.name);  // FEJL hvis captain er null!
    }
}
```

**Løsning:** Altid check for null
```java
void printCaptain() {
    if (captain != null) {
        System.out.println(captain.name);
    } else {
        System.out.println("No captain");
    }
}
```

---

**Problem:** Modificerer forkert objekt
```java
void attack(Character target) {
    health = health - 10;  // FEJL! Ændrer egen health i stedet for target
}
```

**Løsning:** Brug target prefix
```java
void attack(Character target) {
    target.health = target.health - attackPower;  // Korrekt!
}
```

---

## Best Practices

**Naming:**
- Parametre: Beskrivende navne der viser relation
```java
void attack(Character target) { }     // Godt
void attack(Character c) { }          // Mindre klart
```

**Composition:**
- Brug når et objekt "HAR EN" relation
```java
class Car {
    Engine engine;  // Car HAR EN engine
}
```

**Null safety:**
- Check altid for null før brug
```java
if (weapon != null) {
    // Brug weapon
}
```

**Return objects:**
- Returner null hvis intet findes
```java
Player findPlayer(String name) {
    // søg...
    return null;  // Hvis ikke fundet
}
```

---

## Opsummering

**Du har lært:**
- ✅ Sende objekter som parametre til instance methods
- ✅ Læse data fra andre objekter
- ✅ Modificere andre objekters state
- ✅ Kalde methods på andre objekter
- ✅ Composition - objekter indeholder objekter
- ✅ Arrays i objekter
- ✅ Objekter returnerer objekter
- ✅ Multiple objekter arbejder sammen
- ✅ Null checks for sikkerhed
- ✅ Complex systems med mange interaktioner

**Næste skridt:**
- Lav øvelserne i `level7_exercises.md`
- Eksperimenter med object interaction
- Byg komplekse systemer hvor objekter arbejder sammen

**Husk:**
- Objekter kan kommunikere og samarbejde
- Composition = "HAR EN" relation
- Check altid for null!
- Objekter kan ændre hinandens state
