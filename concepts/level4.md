# Level 4: Information Hiding, toString og Static

## Begrebsgennemgang

### Hvad Du Allerede Kan

I Level 3 lærte du hvordan objekter kan interagere og samarbejde:

```java
class BankAccount {
    String owner;
    double balance;
    
    void transfer(BankAccount target, double amount) {
        balance = balance - amount;
        target.balance = target.balance + amount;
    }
}

void main() {
    BankAccount account = new BankAccount("Anna", 1000);
    account.balance = -5000;  // Ups! Dette burde ikke være muligt!
}
```

**Problem:** Alle kan ændre instance variables direkte!

---

## Del 1: Information Hiding med Access Modifiers

### Problemet: Direct Access

Når instance variables er tilgængelige udefra kan de ændres ukontrolleret:

```java
class BankAccount {
    String owner;
    double balance;
    
    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
}

void main() {
    BankAccount account = new BankAccount("Anna", 1000);
    
    // Direkte adgang = farligt!
    account.balance = -5000;      // Negativ balance!
    account.owner = "";           // Tom owner!
    
    System.out.println(account.balance);  // -5000
}
```

**Vi har brug for kontrol!**

---

## Access Modifiers: `private` og `public`

**Access modifiers** kontrollerer hvem der kan tilgå class members:

```java
class BankAccount {
    private String owner;     // Kun tilgængelig INDE i klassen
    private double balance;   // Kun tilgængelig INDE i klassen
    
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
    
    public double getBalance() {  // Public metode = tilgængelig udefra
        return balance;
    }
}

void main() {
    BankAccount account = new BankAccount("Anna", 1000);
    
    // account.balance = -5000;  // FEJL! balance er private
    
    System.out.println(account.getBalance());  // OK - public metode
}
```

**Nu er data beskyttet!**

---

## `private` - Beskyt Data

**`private` betyder:**
- Kun tilgængelig inde i klassen selv
- Ikke tilgængelig fra `main()` eller andre klasser
- Beskytter data mod uønsket ændring

**Eksempel:**
```java
class Player {
    private String name;
    private int health;
    
    public Player(String name, int health) {
        this.name = name;
        this.health = health;
    }
    
    public void takeDamage(int damage) {
        health = health - damage;  // OK - inde i klassen
        if (health < 0) {
            health = 0;
        }
    }
}

void main() {
    Player player = new Player("Hero", 100);
    
    // player.health = -50;  // FEJL! health er private
    
    player.takeDamage(30);   // OK - public metode
}
```

---

## `public` - Åben Adgang

**`public` betyder:**
- Tilgængelig overalt
- Kan kaldes fra `main()` og andre klasser
- Bruges til methods der skal være tilgængelige udefra

**Regel:**
- Instance variables: Næsten altid `private`
- Konstruktører: Næsten altid `public`
- Methods: `public` hvis de skal bruges udefra, `private` ellers

---

## Getters - Læs Private Data

**Getter methods** giver adgang til at læse private data:

```java
class Car {
    private String brand;
    private int speed;
    
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public int getSpeed() {
        return speed;
    }
}

void main() {
    Car tesla = new Car("Tesla", 120);
    
    // tesla.brand  // FEJL! brand er private
    
    System.out.println(tesla.getBrand());  // OK - getter
    System.out.println(tesla.getSpeed());  // OK - getter
}
```

**Naming convention:**
- `getVariableName()` - for alle typer
- `isVariableName()` - for boolean (fx `isAvailable()`)

---

## Setters - Ændr Private Data med Validering

**Setter methods** giver kontrolleret adgang til at ændre private data:

```java
class BankAccount {
    private double balance;
    
    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    public void setBalance(double balance) {
        if (balance >= 0) {           // Validering!
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }
    
    public double getBalance() {
        return balance;
    }
}

void main() {
    BankAccount account = new BankAccount(1000);
    
    account.setBalance(1500);   // OK
    account.setBalance(-500);   // Afvist!
    
    System.out.println(account.getBalance());  // 1500
}
```

**Fordele ved setters:**
- Kan validere input
- Kan logge ændringer
- Beskytter data integritet

---

## Private Helper Methods

Methods der kun bruges internt kan også være private:

```java
class Game {
    private int score;
    
    public Game() {
        this.score = 0;
    }
    
    public void addPoints(int points) {
        score = score + points;
        checkAchievements();  // Kalder private metode
    }
    
    private void checkAchievements() {  // Private helper
        if (score >= 100) {
            System.out.println("Achievement unlocked!");
        }
    }
}

void main() {
    Game game = new Game();
    game.addPoints(120);
    
    // game.checkAchievements();  // FEJL! Private metode
}
```

---

## Hvornår Skal Jeg Bruge Private vs Public?

**Tommelfingerregel:**

**Altid `private`:**
- Instance variables

**Næsten altid `public`:**
- Konstruktører
- Methods der skal bruges udefra (API)

**Ofte `private`:**
- Helper methods (hjælpemetoder)
- Methods kun til intern brug

**Eksempel:**
```java
class Item {
    private String name;        // private - beskyt data
    private double price;       // private - beskyt data
    
    public Item(String name, double price) {  // public - skal kunne lave objekter
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {               // public - skal kunne læse
        return calculateFinalPrice();
    }
    
    private double calculateFinalPrice() {   // private - intern beregning
        return price * 1.25;  // +25% moms
    }
}
```

---

## Del 2: toString Method

### Problemet: Printing Objekter

Hvad sker der hvis du printer et objekt direkte?

```java
class Player {
    private String name;
    private int score;
    
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

void main() {
    Player player = new Player("Anna", 150);
    System.out.println(player);  // Player@15db9742 - hvad er det?!
}
```

**Output:** `Player@15db9742`

Dette er ikke særlig nyttigt!

---

## toString() - Læsbar Repræsentation

**`toString()` method** definerer hvordan et objekt skal printes:

```java
class Player {
    private String name;
    private int score;
    
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String toString() {
        return "Player: " + name + " (Score: " + score + ")";
    }
}

void main() {
    Player player = new Player("Anna", 150);
    System.out.println(player);  // Player: Anna (Score: 150)
}
```

**Nu får vi læsbar output!**

---

## toString() - Hvordan Virker Det?

**Automatisk kald:**
- `System.out.println(objekt)` kalder automatisk `toString()`
- `"text" + objekt` kalder automatisk `toString()`

```java
class Car {
    private String brand;
    private int speed;
    
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
    
    public String toString() {
        return brand + " (" + speed + " km/h)";
    }
}

void main() {
    Car tesla = new Car("Tesla", 120);
    
    System.out.println(tesla);              // Tesla (120 km/h)
    System.out.println("My car: " + tesla); // My car: Tesla (120 km/h)
    
    String info = tesla.toString();         // Eksplicit kald
    System.out.println(info);               // Tesla (120 km/h)
}
```

---

## toString() Patterns

**Pattern 1: Simpel format**
```java
public String toString() {
    return "Player: " + name + ", Score: " + score;
}
```

**Pattern 2: Med class navn**
```java
public String toString() {
    return "Car[brand=" + brand + ", speed=" + speed + "]";
}
```

**Pattern 3: Multi-line**
```java
public String toString() {
    return "=== Player ===\n" +
           "Name: " + name + "\n" +
           "Health: " + health + "\n" +
           "Score: " + score;
}
```

**Pattern 4: Conditional**
```java
public String toString() {
    if (available) {
        return name + " - " + price + " kr (In stock)";
    } else {
        return name + " - SOLD OUT";
    }
}
```

---

## toString() med Composition

Når objekter indeholder andre objekter kan du kalde deres `toString()`:

```java
class Engine {
    private int horsePower;
    
    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }
    
    public String toString() {
        return horsePower + " HP";
    }
}

class Car {
    private String brand;
    private Engine engine;
    
    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }
    
    public String toString() {
        return brand + " with " + engine;  // Kalder engine.toString()
    }
}

void main() {
    Engine v8 = new Engine(450);
    Car mustang = new Car("Mustang", v8);
    
    System.out.println(mustang);  // Mustang with 450 HP
}
```

---

## toString() i Debugging

`toString()` er meget nyttig til debugging:

```java
class Player {
    private String name;
    private int health;
    private int score;
    
    public Player(String name, int health, int score) {
        this.name = name;
        this.health = health;
        this.score = score;
    }
    
    public String toString() {
        return "Player[name=" + name + ", health=" + health + ", score=" + score + "]";
    }
}

void main() {
    Player player = new Player("Hero", 75, 200);
    
    System.out.println("DEBUG: " + player);  // Nemt at se objektets state!
}
```

---

## Del 3: Static - Basics

### Problemet: Shared Data

Hvad hvis du vil tælle hvor mange objekter der er lavet?

```java
class Player {
    private String name;
    private int score;
    
    // Hvor gemmer vi antal players? 🤔
}
```

**Vi har brug for data der deles mellem alle objekter!**

---

## `static` - Delt Data

**`static` variables** tilhører klassen, ikke det enkelte objekt:

```java
class Player {
    private String name;
    private int score;
    
    private static int playerCount = 0;  // Deles mellem alle Player objekter
    
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        playerCount = playerCount + 1;  // Øg tælleren
    }
    
    public static int getPlayerCount() {  // Static metode
        return playerCount;
    }
}

void main() {
    System.out.println(Player.getPlayerCount());  // 0
    
    Player p1 = new Player("Anna", 100);
    Player p2 = new Player("Mikkel", 150);
    Player p3 = new Player("Sofie", 120);
    
    System.out.println(Player.getPlayerCount());  // 3
}
```

**Bemærk:**
- `static` variable deles mellem alle objekter
- Tilgås via class navn: `Player.getPlayerCount()`
- Ikke via objekt: `p1.getPlayerCount()` (virker, men frarådes)

---

## Static vs Instance Variables

**Instance variable:**
- Hver objekt har sin egen kopi
- Tilgås via objekt: `player.score`
- Forskellige værdier for hver objekt

**Static variable:**
- Én delt kopi for alle objekter
- Tilgås via class: `Player.playerCount`
- Samme værdi for alle objekter

```java
class Game {
    private String name;           // Instance - hver Game har sit eget navn
    private static int gamesPlayed = 0;  // Static - delt mellem alle Games
    
    public Game(String name) {
        this.name = name;
        gamesPlayed = gamesPlayed + 1;
    }
    
    public String getName() {
        return name;  // Instance metode returnerer instance variable
    }
    
    public static int getGamesPlayed() {
        return gamesPlayed;  // Static metode returnerer static variable
    }
}
```

---

## Static Methods

**Static methods:**
- Tilhører klassen, ikke objektet
- Kaldes via class navn: `ClassName.methodName()`
- Kan IKKE tilgå instance variables
- Kan kun tilgå static variables

```java
class MathHelper {
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
}

void main() {
    int sum = MathHelper.add(5, 3);          // 8
    int product = MathHelper.multiply(4, 7);  // 28
    
    System.out.println(sum);
    System.out.println(product);
}
```

**Du har brugt static methods før:**
- `Math.random()`
- `Math.sqrt()`
- `Integer.parseInt()`

---

## Static - Hvornår Skal Det Bruges?

**Brug `static` når:**
- Data skal deles mellem alle objekter (fx tællere)
- Utility methods der ikke behøver objekter (fx `Math.sqrt()`)
- Constants (i kombination med `final`)

**Brug IKKE `static` når:**
- Data skal være unik for hvert objekt
- Metode arbejder med instance variables

**Eksempler på god brug:**

```java
class Car {
    private String brand;
    private static int totalCars = 0;  // God brug - tæller alle biler
    
    public Car(String brand) {
        this.brand = brand;
        totalCars = totalCars + 1;
    }
    
    public static int getTotalCars() {  // God brug - tilgår static variable
        return totalCars;
    }
}
```

---

## Static Method Begrænsninger

Static methods kan IKKE tilgå instance variables:

```java
class Player {
    private String name;
    private int score;
    private static int playerCount = 0;
    
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        playerCount = playerCount + 1;
    }
    
    public static void printCount() {
        System.out.println(playerCount);  // OK - static kan tilgå static
        // System.out.println(name);      // FEJL! static kan ikke tilgå instance
    }
}
```

**Hvorfor?**
- Static method tilhører klassen
- Instance variables tilhører det enkelte objekt
- Hvilken objekts `name` skulle den bruge?

---

## Kombiner Instance og Static

```java
class BankAccount {
    private String owner;
    private double balance;
    private static int accountCount = 0;
    private static double totalMoney = 0;
    
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        accountCount = accountCount + 1;
        totalMoney = totalMoney + balance;
    }
    
    public void deposit(double amount) {  // Instance metode
        balance = balance + amount;
        totalMoney = totalMoney + amount;  // Opdater static også
    }
    
    public static int getAccountCount() {  // Static metode
        return accountCount;
    }
    
    public static double getTotalMoney() {  // Static metode
        return totalMoney;
    }
}

void main() {
    BankAccount acc1 = new BankAccount("Anna", 1000);
    BankAccount acc2 = new BankAccount("Mikkel", 1500);
    
    System.out.println("Accounts: " + BankAccount.getAccountCount());    // 2
    System.out.println("Total money: " + BankAccount.getTotalMoney());    // 2500
    
    acc1.deposit(500);
    
    System.out.println("Total money: " + BankAccount.getTotalMoney());    // 3000
}
```

---

## Common Patterns

### Pattern 1: Counter
```java
class Item {
    private static int itemCount = 0;
    
    public Item() {
        itemCount = itemCount + 1;
    }
    
    public static int getItemCount() {
        return itemCount;
    }
}
```

### Pattern 2: Utility Class
```java
class StringHelper {
    public static String reverse(String s) {
        // reverse logic
        return reversed;
    }
    
    public static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
}
```

### Pattern 3: Configuration
```java
class Game {
    private static final int MAX_PLAYERS = 10;  // static + final = constant
    private static int currentPlayers = 0;
    
    public static boolean canAddPlayer() {
        return currentPlayers < MAX_PLAYERS;
    }
}
```

---

## Debugging Tips

**Problem:** Kan ikke tilgå static fra instance context
```java
class Player {
    private static int count = 0;
    
    public void printCount() {
        System.out.println(count);  // OK
    }
}
```

**Problem:** Kan ikke tilgå instance fra static context
```java
class Player {
    private String name;
    
    public static void printName() {
        // System.out.println(name);  // FEJL!
    }
}
```

**Problem:** Glemmer at kalde via class navn
```java
void main() {
    // Player.getCount();     // Korrekt for static
    // player.getScore();     // Korrekt for instance
}
```

---

## Best Practices

**Access Modifiers:**
- Instance variables: Altid `private`
- Getters/Setters: `public`
- Helper methods: `private`
- Konstruktører: `public`

**toString():**
- Altid implementer `toString()` for dine klasser
- Gør output læsbar og nyttig
- Inkluder vigtige instance variables
- Brug til debugging

**Static:**
- Brug sparsomt
- Kun når data skal deles mellem alle objekter
- Utility methods uden state
- Constants (static final)

---

## Komplet Eksempel

```java
class BankAccount {
    // Instance variables - private
    private String owner;
    private double balance;
    
    // Static variable - shared mellem alle accounts
    private static int accountCount = 0;
    
    // Constructor - public
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        accountCount = accountCount + 1;
    }
    
    // Getter - public
    public double getBalance() {
        return balance;
    }
    
    // Setter with validation - public
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }
    
    // toString - public
    public String toString() {
        return "BankAccount[owner=" + owner + ", balance=" + balance + " kr]";
    }
    
    // Static method - public
    public static int getAccountCount() {
        return accountCount;
    }
}

void main() {
    BankAccount acc1 = new BankAccount("Anna", 1000);
    BankAccount acc2 = new BankAccount("Mikkel", 1500);
    
    System.out.println(acc1);  // Bruger toString()
    System.out.println("Total accounts: " + BankAccount.getAccountCount());
    
    acc1.deposit(500);
    System.out.println("Anna's balance: " + acc1.getBalance());
}
```

---

## Opsummering

**Du har lært:**
- ✅ Access modifiers: `private` og `public`
- ✅ Information hiding - beskyt instance variables
- ✅ Getters og setters
- ✅ `toString()` method for læsbar output
- ✅ `static` variables - delt mellem objekter
- ✅ `static` methods - utility methods
- ✅ Forskellen mellem instance og static

**Næste skridt:**
- Lav øvelserne i `level4_exercises.md`
- Eksperimenter med access modifiers
- Implementer toString() i dine klasser
- Prøv at bruge static til counters

**Husk:**
- Instance variables: Altid `private`
- Implementer altid `toString()`
- Brug `static` kun når data skal deles
- Getters/setters giver kontrol over data
