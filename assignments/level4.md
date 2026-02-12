# Level 4: Information Hiding, toString og Static - Opgaver

## Indhold
- [ ] [Del A: Access Modifiers og Getters/Setters](#del-a-access-modifiers-og-getterssetters)
- [ ] [Del B: toString Method](#del-b-tostring-method)
- [ ] [Del C: Static Variables og Methods](#del-c-static-variables-og-methods)
- [ ] [Del D: ArrayList Integration](#del-d-arraylist-integration)
- [ ] [Del E: Combined Concepts](#del-e-combined-concepts)

## Del A: Access Modifiers og Getters/Setters

### Opgave 1: Secure Player
Lav en klasse `Player` med:
- `private String name`
- `private int health`
- `private int maxHealth`

Lav en konstruktør.

Lav public methods:
- `String getName()` - getter
- `int getHealth()` - getter
- `void takeDamage(int damage)` - reducer health (min 0)
- `void heal(int amount)` - øg health (max maxHealth)

I `main()`:
- Lav en player
- Prøv at tilgå health direkte (skal fejle)
- Brug methods til at ændre health
- Print health med getter

<details>
<summary>Se svar</summary>

```java
class Player {
    private String name;
    private int health;
    private int maxHealth;
    
    public Player(String name, int maxHealth) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
        }
    }
    
    public void heal(int amount) {
        health = health + amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
}

void main() {
    Player player = new Player("Hero", 100);
    
    // player.health = -50;  // FEJL! health er private
    
    player.takeDamage(30);
    System.out.println(player.getName() + " health: " + player.getHealth());
    
    player.heal(50);
    System.out.println(player.getName() + " health: " + player.getHealth());
}
```
</details>

---

### Opgave 2: BankAccount med Validering
Lav en klasse `BankAccount` med:
- `private String owner`
- `private double balance`

Lav en konstruktør.

Lav public methods:
- `String getOwner()` - getter
- `double getBalance()` - getter
- `void deposit(double amount)` - hvis amount > 0: øg balance, ellers print fejl
- `void withdraw(double amount)` - hvis amount > 0 OG amount <= balance: reducer balance, ellers print fejl

I `main()`:
- Lav en konto
- Prøv at deposit negativ værdi
- Prøv at withdraw mere end balance
- Lav en valid deposit og withdrawal

<details>
<summary>Se svar</summary>

```java
class BankAccount {
    private String owner;
    private double balance;
    
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited " + amount + " kr");
        } else {
            System.out.println("Invalid amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance = balance - amount;
            System.out.println("Withdrew " + amount + " kr");
        }
    }
}

void main() {
    BankAccount account = new BankAccount("Anna", 1000);
    
    account.deposit(-100);   // Invalid
    account.withdraw(1500);  // Insufficient
    account.deposit(500);    // OK
    account.withdraw(300);   // OK
    
    System.out.println("Final balance: " + account.getBalance() + " kr");
}
```
</details>

---

### Opgave 3: Product med Price Validation
Lav en klasse `Product` med:
- `private String name`
- `private double price`
- `private int stock`

Lav en konstruktør.

Lav public methods:
- Getters for alle fields
- `void setPrice(double price)` - kun sæt hvis price > 0, ellers print fejl
- `void addStock(int amount)` - kun øg hvis amount > 0
- `void sell(int quantity)` - hvis quantity <= stock: reducer stock, ellers print fejl

I `main()`:
- Lav et produkt
- Prøv at sætte negativ price
- Tilføj stock
- Prøv at sælge mere end stock
- Lav et valid salg

<details>
<summary>Se svar</summary>

```java
class Product {
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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
    
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
            System.out.println("Price updated to " + price + " kr");
        } else {
            System.out.println("Price must be positive");
        }
    }
    
    public void addStock(int amount) {
        if (amount > 0) {
            stock = stock + amount;
            System.out.println("Added " + amount + " units");
        }
    }
    
    public void sell(int quantity) {
        if (quantity > stock) {
            System.out.println("Not enough stock");
        } else {
            stock = stock - quantity;
            System.out.println("Sold " + quantity + " units");
        }
    }
}

void main() {
    Product laptop = new Product("Laptop", 8999, 10);
    
    laptop.setPrice(-100);  // Invalid
    laptop.addStock(5);
    laptop.sell(20);        // Not enough
    laptop.sell(8);         // OK
    
    System.out.println(laptop.getName() + " stock: " + laptop.getStock());
}
```
</details>

---

### Opgave 4: Temperature med Private Validation
Lav en klasse `Temperature` med:
- `private double celsius`

Lav en konstruktør der validerer at celsius >= -273.15 (absolut nul).

Lav public methods:
- `double getCelsius()` - getter
- `void setCelsius(double celsius)` - setter med validering
- `double getFahrenheit()` - returner celsius * 9/5 + 32
- `double getKelvin()` - returner celsius + 273.15

I `main()`:
- Lav en temperatur
- Prøv at sætte temperatur under absolut nul
- Print i alle tre enheder

<details>
<summary>Se svar</summary>

```java
class Temperature {
    private double celsius;
    
    public Temperature(double celsius) {
        if (celsius >= -273.15) {
            this.celsius = celsius;
        } else {
            this.celsius = -273.15;
            System.out.println("Temperature set to absolute zero");
        }
    }
    
    public double getCelsius() {
        return celsius;
    }
    
    public void setCelsius(double celsius) {
        if (celsius >= -273.15) {
            this.celsius = celsius;
        } else {
            System.out.println("Cannot go below absolute zero");
        }
    }
    
    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }
    
    public double getKelvin() {
        return celsius + 273.15;
    }
}

void main() {
    Temperature temp = new Temperature(25);
    
    System.out.println("Celsius: " + temp.getCelsius());
    System.out.println("Fahrenheit: " + temp.getFahrenheit());
    System.out.println("Kelvin: " + temp.getKelvin());
    
    temp.setCelsius(-300);  // Below absolute zero
    System.out.println("Celsius: " + temp.getCelsius());
}
```
</details>

---

## Del B: toString Method

### Opgave 5: Player toString
Lav en klasse `Player` med:
- `private String name`
- `private int level`
- `private int experience`

Lav en konstruktør.

Lav en `toString()` method der returnerer: "Player: {name} (Level {level}, XP: {experience})"

I `main()`:
- Lav flere players
- Print dem direkte (bruger toString automatisk)
- Brug toString i String concatenation

<details>
<summary>Se svar</summary>

```java
class Player {
    private String name;
    private int level;
    private int experience;
    
    public Player(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }
    
    public String toString() {
        return "Player: " + name + " (Level " + level + ", XP: " + experience + ")";
    }
}

void main() {
    Player p1 = new Player("Anna", 25, 5000);
    Player p2 = new Player("Mikkel", 30, 7500);
    
    System.out.println(p1);
    System.out.println(p2);
    System.out.println("Current player: " + p1);
}
```
</details>

---

### Opgave 6: Book toString med Conditional
Lav en klasse `Book` med:
- `private String title`
- `private String author`
- `private boolean available`

Lav en konstruktør.

Lav en `toString()` method der returnerer:
- Hvis available: "{title} by {author} - Available"
- Hvis ikke available: "{title} by {author} - Checked out"

I `main()`:
- Lav bøger (nogle available, nogle ikke)
- Print dem

<details>
<summary>Se svar</summary>

```java
class Book {
    private String title;
    private String author;
    private boolean available;
    
    public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }
    
    public String toString() {
        if (available) {
            return title + " by " + author + " - Available";
        } else {
            return title + " by " + author + " - Checked out";
        }
    }
}

void main() {
    Book book1 = new Book("1984", "George Orwell", true);
    Book book2 = new Book("Harry Potter", "J.K. Rowling", false);
    Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", true);
    
    System.out.println(book1);
    System.out.println(book2);
    System.out.println(book3);
}
```
</details>

---

### Opgave 7: BankAccount toString
Lav en klasse `BankAccount` med:
- `private String owner`
- `private double balance`
- `private String accountNumber`

Lav en konstruktør.

Lav en `toString()` method der returnerer formateret information med alle fields.

I `main()`:
- Lav flere konti
- Print dem i forskellige kontekster

<details>
<summary>Se svar</summary>

```java
class BankAccount {
    private String owner;
    private double balance;
    private String accountNumber;
    
    public BankAccount(String owner, double balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    
    public String toString() {
        return "Account #" + accountNumber + " - " + owner + " (Balance: " + balance + " kr)";
    }
}

void main() {
    BankAccount acc1 = new BankAccount("Anna", 15000, "1234-5678");
    BankAccount acc2 = new BankAccount("Mikkel", 23000, "8765-4321");
    
    System.out.println(acc1);
    System.out.println("Transferring from: " + acc1);
}
```
</details>

---

### Opgave 8: Car toString med Composition
Lav en klasse `Engine` med:
- `private int horsePower`
- `private String type`

Lav konstruktør og `toString()` der returnerer: "{type} ({horsePower} HP)"

Lav en klasse `Car` med:
- `private String brand`
- `private Engine engine`

Lav konstruktør og `toString()` der inkluderer engine.toString().

I `main()`:
- Lav en bil med en motor
- Print bilen

<details>
<summary>Se svar</summary>

```java
class Engine {
    private int horsePower;
    private String type;
    
    public Engine(int horsePower, String type) {
        this.horsePower = horsePower;
        this.type = type;
    }
    
    public String toString() {
        return type + " (" + horsePower + " HP)";
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
        return brand + " with " + engine;
    }
}

void main() {
    Engine v8 = new Engine(450, "V8");
    Car mustang = new Car("Mustang", v8);
    
    System.out.println(mustang);
}
```
</details>

---

## Del C: Static Variables og Methods

### Opgave 9: Player Counter
Lav en klasse `Player` med:
- `private String name`
- `private static int playerCount = 0`

Lav en konstruktør der øger playerCount.

Lav en static method:
- `static int getPlayerCount()` - returner playerCount

I `main()`:
- Print playerCount (skal være 0)
- Lav 5 players
- Print playerCount (skal være 5)

<details>
<summary>Se svar</summary>

```java
class Player {
    private String name;
    private static int playerCount = 0;
    
    public Player(String name) {
        this.name = name;
        playerCount = playerCount + 1;
    }
    
    public static int getPlayerCount() {
        return playerCount;
    }
}

void main() {
    System.out.println("Players: " + Player.getPlayerCount());
    
    Player p1 = new Player("Anna");
    Player p2 = new Player("Mikkel");
    Player p3 = new Player("Sofie");
    Player p4 = new Player("Lars");
    Player p5 = new Player("Emma");
    
    System.out.println("Players: " + Player.getPlayerCount());
}
```
</details>

---

### Opgave 10: BankAccount Total Balance
Lav en klasse `BankAccount` med:
- `private String owner`
- `private double balance`
- `private static double totalBalance = 0`

Lav en konstruktør der tilføjer balance til totalBalance.

Lav methods:
- `void deposit(double amount)` - øg balance OG totalBalance
- `void withdraw(double amount)` - reducer balance OG totalBalance (hvis muligt)
- `static double getTotalBalance()` - returner totalBalance

I `main()`:
- Lav flere konti
- Lav deposits og withdrawals
- Print total balance

<details>
<summary>Se svar</summary>

```java
class BankAccount {
    private String owner;
    private double balance;
    private static double totalBalance = 0;
    
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        totalBalance = totalBalance + balance;
    }
    
    public void deposit(double amount) {
        balance = balance + amount;
        totalBalance = totalBalance + amount;
    }
    
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            totalBalance = totalBalance - amount;
        }
    }
    
    public static double getTotalBalance() {
        return totalBalance;
    }
}

void main() {
    BankAccount acc1 = new BankAccount("Anna", 1000);
    BankAccount acc2 = new BankAccount("Mikkel", 1500);
    
    System.out.println("Total: " + BankAccount.getTotalBalance());
    
    acc1.deposit(500);
    acc2.withdraw(300);
    
    System.out.println("Total: " + BankAccount.getTotalBalance());
}
```
</details>

---

### Opgave 11: StringHelper Utility Class
Lav en klasse `StringHelper` med KUN static methods:
- `static String reverse(String s)` - returner reversed string
- `static int countVowels(String s)` - tæl vokaler (a,e,i,o,u)
- `static boolean isPalindrome(String s)` - check om string er ens forfra og bagfra

I `main()`:
- Test alle methods uden at lave objekter
- Brug class navn til at kalde methods

<details>
<summary>Hint</summary>

For reverse: Brug en loop fra sidste index til 0 og byg ny string.
For vowels: Loop gennem characters og check om hver er en vokal.
For palindrome: Brug reverse method.
</details>

<details>
<summary>Se svar</summary>

```java
class StringHelper {
    public static String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }
    
    public static int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count = count + 1;
            }
        }
        return count;
    }
    
    public static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
}

void main() {
    System.out.println(StringHelper.reverse("hello"));
    System.out.println(StringHelper.countVowels("hello"));
    System.out.println(StringHelper.isPalindrome("racecar"));
    System.out.println(StringHelper.isPalindrome("hello"));
}
```
</details>

---

### Opgave 12: Game Statistics
Lav en klasse `Game` med:
- `private String playerName`
- `private int score`
- `private static int gamesPlayed = 0`
- `private static int totalScore = 0`
- `private static int highScore = 0`

Lav en konstruktør der opdaterer alle static variables.

Lav static methods:
- `static int getGamesPlayed()`
- `static double getAverageScore()` - totalScore / gamesPlayed
- `static int getHighScore()`

I `main()`:
- Lav flere games med forskellige scores
- Print statistikker

<details>
<summary>Se svar</summary>

```java
class Game {
    private String playerName;
    private int score;
    private static int gamesPlayed = 0;
    private static int totalScore = 0;
    private static int highScore = 0;
    
    public Game(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
        gamesPlayed = gamesPlayed + 1;
        totalScore = totalScore + score;
        if (score > highScore) {
            highScore = score;
        }
    }
    
    public static int getGamesPlayed() {
        return gamesPlayed;
    }
    
    public static double getAverageScore() {
        if (gamesPlayed == 0) {
            return 0;
        }
        return (double)totalScore / gamesPlayed;
    }
    
    public static int getHighScore() {
        return highScore;
    }
}

void main() {
    Game g1 = new Game("Anna", 1500);
    Game g2 = new Game("Mikkel", 2300);
    Game g3 = new Game("Sofie", 1800);
    Game g4 = new Game("Lars", 2100);
    
    System.out.println("Games played: " + Game.getGamesPlayed());
    System.out.println("Average score: " + Game.getAverageScore());
    System.out.println("High score: " + Game.getHighScore());
}
```
</details>

---

## Del D: ArrayList Integration

### Opgave 13: Player Inventory med ArrayList
Lav en klasse `Item` med:
- `private String name`
- `private int value`

Lav konstruktør, getters og toString.

Lav en klasse `Player` med:
- `private String name`
- `private ArrayList<Item> inventory`

Lav konstruktør der initialiserer inventory som tom ArrayList.

Lav methods:
- `void addItem(Item item)` - tilføj til inventory
- `int getTotalValue()` - sum af alle item values
- `void printInventory()` - print alle items (brug toString)
- `Item findMostValuable()` - returner item med højeste value (eller null)

I `main()`:
- Lav en player
- Tilføj flere items
- Print inventory
- Print total value
- Find most valuable item

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Item {
    private String name;
    private int value;
    
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
    
    public String toString() {
        return name + " (" + value + " gold)";
    }
}

class Player {
    private String name;
    private ArrayList<Item> inventory;
    
    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + " picked up " + item.getName());
    }
    
    public int getTotalValue() {
        int total = 0;
        for (Item item : inventory) {
            total = total + item.getValue();
        }
        return total;
    }
    
    public void printInventory() {
        System.out.println(name + "'s inventory:");
        for (Item item : inventory) {
            System.out.println("- " + item);
        }
    }
    
    public Item findMostValuable() {
        if (inventory.size() == 0) {
            return null;
        }
        
        Item mostValuable = inventory.get(0);
        for (Item item : inventory) {
            if (item.getValue() > mostValuable.getValue()) {
                mostValuable = item;
            }
        }
        return mostValuable;
    }
}

void main() {
    Player player = new Player("Hero");
    
    player.addItem(new Item("Sword", 150));
    player.addItem(new Item("Shield", 100));
    player.addItem(new Item("Potion", 50));
    player.addItem(new Item("Diamond", 500));
    
    player.printInventory();
    System.out.println("Total value: " + player.getTotalValue() + " gold");
    
    Item valuable = player.findMostValuable();
    System.out.println("Most valuable: " + valuable);
}
```
</details>

---

### Opgave 14: Library med ArrayList
Lav en klasse `Book` med:
- `private String title`
- `private String author`
- `private boolean available`

Lav konstruktør (available starter som true), getters, setters og toString.

Lav en klasse `Library` med:
- `private String name`
- `private ArrayList<Book> books`

Lav konstruktør der initialiserer books.

Lav methods:
- `void addBook(Book book)` - tilføj bog
- `ArrayList<Book> findAvailableBooks()` - returner liste af tilgængelige bøger
- `Book findBookByTitle(String title)` - returner bog eller null
- `void borrowBook(String title)` - find bog og sæt available til false
- `void returnBook(String title)` - find bog og sæt available til true
- `void printAllBooks()` - print alle bøger

I `main()`:
- Lav et bibliotek
- Tilføj flere bøger
- Lån nogle bøger
- Find available books
- Return books

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private boolean available;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public String toString() {
        String status = available ? "Available" : "Checked out";
        return title + " by " + author + " - " + status;
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public ArrayList<Book> findAvailableBooks() {
        ArrayList<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }
    
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    
    public void borrowBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Book not found");
        } else if (!book.isAvailable()) {
            System.out.println("Book already checked out");
        } else {
            book.setAvailable(false);
            System.out.println("Borrowed: " + title);
        }
    }
    
    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book == null) {
            System.out.println("Book not found");
        } else {
            book.setAvailable(true);
            System.out.println("Returned: " + title);
        }
    }
    
    public void printAllBooks() {
        System.out.println(name + " books:");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}

void main() {
    Library library = new Library("City Library");
    
    library.addBook(new Book("1984", "George Orwell"));
    library.addBook(new Book("Harry Potter", "J.K. Rowling"));
    library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
    
    library.printAllBooks();
    
    library.borrowBook("1984");
    library.borrowBook("Harry Potter");
    
    System.out.println("\nAvailable books:");
    ArrayList<Book> available = library.findAvailableBooks();
    for (Book book : available) {
        System.out.println("- " + book);
    }
    
    library.returnBook("1984");
}
```
</details>

---

### Opgave 15: Student Course Management
Lav en klasse `Course` med:
- `private String name`
- `private int credits`

Lav konstruktør, getters og toString.

Lav en klasse `Student` med:
- `private String name`
- `private ArrayList<Course> courses`

Lav konstruktør der initialiserer courses.

Lav methods:
- `void enrollIn(Course course)` - tilføj kursus
- `int getTotalCredits()` - sum af alle course credits
- `boolean isEnrolledIn(String courseName)` - check om studerende er tilmeldt
- `void printCourses()` - print alle kurser

I `main()`:
- Lav en studerende
- Tilmeld til flere kurser
- Print kurser og total credits

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Course {
    private String name;
    private int credits;
    
    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String toString() {
        return name + " (" + credits + " credits)";
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;
    
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    
    public void enrollIn(Course course) {
        courses.add(course);
        System.out.println(name + " enrolled in " + course.getName());
    }
    
    public int getTotalCredits() {
        int total = 0;
        for (Course course : courses) {
            total = total + course.getCredits();
        }
        return total;
    }
    
    public boolean isEnrolledIn(String courseName) {
        for (Course course : courses) {
            if (course.getName().equals(courseName)) {
                return true;
            }
        }
        return false;
    }
    
    public void printCourses() {
        System.out.println(name + "'s courses:");
        for (Course course : courses) {
            System.out.println("- " + course);
        }
        System.out.println("Total credits: " + getTotalCredits());
    }
}

void main() {
    Student student = new Student("Anna");
    
    student.enrollIn(new Course("Programming", 10));
    student.enrollIn(new Course("Mathematics", 5));
    student.enrollIn(new Course("Web Development", 10));
    
    student.printCourses();
    
    System.out.println("Enrolled in Programming? " + student.isEnrolledIn("Programming"));
    System.out.println("Enrolled in Physics? " + student.isEnrolledIn("Physics"));
}
```
</details>

---

### Opgave 16: Team med ArrayList og Static Counter
Lav en klasse `Player` med:
- `private String name`
- `private int score`

Lav konstruktør, getters og toString.

Lav en klasse `Team` med:
- `private String teamName`
- `private ArrayList<Player> players`
- `private static int teamCount = 0`

Lav konstruktør der initialiserer players og øger teamCount.

Lav methods:
- `void addPlayer(Player player)` - tilføj spiller
- `int getTotalScore()` - sum af alle player scores
- `Player findTopScorer()` - returner spiller med højeste score
- `void printTeam()` - print team navn, alle spillere og total score
- `static int getTeamCount()` - returner antal teams

I `main()`:
- Lav flere teams
- Tilføj spillere til hver team
- Print teams
- Print total antal teams

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Player {
    private String name;
    private int score;
    
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public String toString() {
        return name + " (" + score + " points)";
    }
}

class Team {
    private String teamName;
    private ArrayList<Player> players;
    private static int teamCount = 0;
    
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        teamCount = teamCount + 1;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public int getTotalScore() {
        int total = 0;
        for (Player player : players) {
            total = total + player.getScore();
        }
        return total;
    }
    
    public Player findTopScorer() {
        if (players.size() == 0) {
            return null;
        }
        
        Player top = players.get(0);
        for (Player player : players) {
            if (player.getScore() > top.getScore()) {
                top = player;
            }
        }
        return top;
    }
    
    public void printTeam() {
        System.out.println("\n=== " + teamName + " ===");
        for (Player player : players) {
            System.out.println("- " + player);
        }
        System.out.println("Total score: " + getTotalScore());
        Player top = findTopScorer();
        if (top != null) {
            System.out.println("Top scorer: " + top.getName());
        }
    }
    
    public static int getTeamCount() {
        return teamCount;
    }
}

void main() {
    Team red = new Team("Red Dragons");
    red.addPlayer(new Player("Anna", 150));
    red.addPlayer(new Player("Mikkel", 200));
    red.addPlayer(new Player("Sofie", 175));
    
    Team blue = new Team("Blue Sharks");
    blue.addPlayer(new Player("Lars", 180));
    blue.addPlayer(new Player("Emma", 220));
    blue.addPlayer(new Player("Peter", 160));
    
    red.printTeam();
    blue.printTeam();
    
    System.out.println("\nTotal teams created: " + Team.getTeamCount());
}
```
</details>

---

## Del E: Combined Concepts

### Opgave 17: Complete E-commerce System
Lav en klasse `Product` med:
- `private String name`
- `private double price`
- `private int stock`
- `private static int productCount = 0`

Lav konstruktør (øg productCount), getters, setters med validering, og toString.

Lav en klasse `ShoppingCart` med:
- `private ArrayList<Product> items`

Lav konstruktør og methods:
- `void addProduct(Product product)` - tilføj produkt hvis stock > 0, reducer stock
- `double getTotalPrice()` - sum af alle product prices
- `void printCart()` - print alle produkter og total
- `void clear()` - tøm kurven

I `main()`:
- Lav flere produkter
- Lav en shopping cart
- Tilføj produkter
- Print cart
- Print antal produkter skabt

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int stock;
    private static int productCount = 0;
    
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        productCount = productCount + 1;
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
    
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }
    
    public String toString() {
        return name + " - " + price + " kr (Stock: " + stock + ")";
    }
    
    public static int getProductCount() {
        return productCount;
    }
}

class ShoppingCart {
    private ArrayList<Product> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        if (product.getStock() > 0) {
            items.add(product);
            product.setStock(product.getStock() - 1);
            System.out.println("Added " + product.getName() + " to cart");
        } else {
            System.out.println(product.getName() + " is out of stock");
        }
    }
    
    public double getTotalPrice() {
        double total = 0;
        for (Product product : items) {
            total = total + product.getPrice();
        }
        return total;
    }
    
    public void printCart() {
        System.out.println("\n=== Shopping Cart ===");
        for (Product product : items) {
            System.out.println("- " + product.getName() + " (" + product.getPrice() + " kr)");
        }
        System.out.println("Total: " + getTotalPrice() + " kr");
    }
    
    public void clear() {
        items.clear();
        System.out.println("Cart cleared");
    }
}

void main() {
    Product laptop = new Product("Laptop", 8999, 5);
    Product mouse = new Product("Mouse", 299, 10);
    Product keyboard = new Product("Keyboard", 599, 0);
    
    ShoppingCart cart = new ShoppingCart();
    
    cart.addProduct(laptop);
    cart.addProduct(mouse);
    cart.addProduct(keyboard);  // Out of stock
    cart.addProduct(mouse);
    
    cart.printCart();
    
    System.out.println("\nTotal products created: " + Product.getProductCount());
}
```
</details>

---

### Opgave 18: Social Media System
Lav en klasse `Post` med:
- `private String author`
- `private String content`
- `private int likes`
- `private static int totalPosts = 0`

Lav konstruktør (likes starter på 0, øg totalPosts), getters, `void like()` metode, toString og `static int getTotalPosts()`.

Lav en klasse `User` med:
- `private String username`
- `private ArrayList<Post> posts`

Lav konstruktør og methods:
- `void createPost(String content)` - lav ny post med username som author
- `Post findMostLikedPost()` - returner post med flest likes
- `void printAllPosts()` - print alle posts
- `void printStats()` - print antal posts og total likes

I `main()`:
- Lav flere users
- Lav posts
- Like nogle posts
- Print stats

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Post {
    private String author;
    private String content;
    private int likes;
    private static int totalPosts = 0;
    
    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        this.likes = 0;
        totalPosts = totalPosts + 1;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getContent() {
        return content;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public void like() {
        likes = likes + 1;
    }
    
    public String toString() {
        return author + ": \"" + content + "\" (" + likes + " likes)";
    }
    
    public static int getTotalPosts() {
        return totalPosts;
    }
}

class User {
    private String username;
    private ArrayList<Post> posts;
    
    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
    }
    
    public void createPost(String content) {
        Post post = new Post(username, content);
        posts.add(post);
        System.out.println(username + " created a post");
    }
    
    public Post findMostLikedPost() {
        if (posts.size() == 0) {
            return null;
        }
        
        Post mostLiked = posts.get(0);
        for (Post post : posts) {
            if (post.getLikes() > mostLiked.getLikes()) {
                mostLiked = post;
            }
        }
        return mostLiked;
    }
    
    public void printAllPosts() {
        System.out.println("\n" + username + "'s posts:");
        for (Post post : posts) {
            System.out.println("- " + post);
        }
    }
    
    public void printStats() {
        int totalLikes = 0;
        for (Post post : posts) {
            totalLikes = totalLikes + post.getLikes();
        }
        
        System.out.println("\n=== " + username + " Stats ===");
        System.out.println("Posts: " + posts.size());
        System.out.println("Total likes: " + totalLikes);
        
        Post mostLiked = findMostLikedPost();
        if (mostLiked != null) {
            System.out.println("Most liked: \"" + mostLiked.getContent() + "\" (" + mostLiked.getLikes() + " likes)");
        }
    }
}

void main() {
    User anna = new User("Anna");
    User mikkel = new User("Mikkel");
    
    anna.createPost("Hello world!");
    anna.createPost("Learning Java is fun!");
    mikkel.createPost("First post!");
    mikkel.createPost("Java programming");
    
    // Simulate likes
    Post annaPost1 = anna.findMostLikedPost();
    for (int i = 0; i < 5; i++) {
        annaPost1.like();
    }
    
    anna.printAllPosts();
    anna.printStats();
    
    mikkel.printAllPosts();
    mikkel.printStats();
    
    System.out.println("\nTotal posts on platform: " + Post.getTotalPosts());
}
```
</details>

---

### Opgave 19: Complete Game Inventory System
Lav en komplet game inventory system med:

**Item klasse:**
- `private String name`
- `private String type` (weapon, armor, potion)
- `private int value`
- `private static int itemsCreated = 0`

**Player klasse:**
- `private String name`
- `private ArrayList<Item> inventory`
- `private int gold`

Implementer:
- Constructors
- Getters/setters med validering
- toString methods
- addItem, removeItem, buyItem, sellItem methods
- Filtreringsmetoder (fx findWeapons, findPotions)
- Sort methods (fx sortByValue)
- Static counter methods

I `main()`:
- Simuler et komplet inventory system med buying, selling, filtering

<details>
<summary>Hint</summary>

Brug `item.getType().equals("weapon")` til at filtrere.
Brug nested loops til at sort by value.
</details>

<details>
<summary>Se svar</summary>

```java
import java.util.ArrayList;

class Item {
    private String name;
    private String type;
    private int value;
    private static int itemsCreated = 0;
    
    public Item(String name, String type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
        itemsCreated = itemsCreated + 1;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int getValue() {
        return value;
    }
    
    public String toString() {
        return name + " (" + type + ") - " + value + " gold";
    }
    
    public static int getItemsCreated() {
        return itemsCreated;
    }
}

class Player {
    private String name;
    private ArrayList<Item> inventory;
    private int gold;
    
    public Player(String name, int gold) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.gold = gold;
    }
    
    public String getName() {
        return name;
    }
    
    public int getGold() {
        return gold;
    }
    
    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + " picked up " + item.getName());
    }
    
    public void removeItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(itemName)) {
                inventory.remove(i);
                System.out.println(name + " removed " + itemName);
                return;
            }
        }
        System.out.println("Item not found");
    }
    
    public void buyItem(Item item) {
        if (gold >= item.getValue()) {
            inventory.add(item);
            gold = gold - item.getValue();
            System.out.println(name + " bought " + item.getName() + " for " + item.getValue() + " gold");
        } else {
            System.out.println("Not enough gold");
        }
    }
    
    public void sellItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getName().equals(itemName)) {
                gold = gold + item.getValue();
                inventory.remove(i);
                System.out.println(name + " sold " + itemName + " for " + item.getValue() + " gold");
                return;
            }
        }
        System.out.println("Item not found");
    }
    
    public ArrayList<Item> findByType(String type) {
        ArrayList<Item> filtered = new ArrayList<>();
        for (Item item : inventory) {
            if (item.getType().equals(type)) {
                filtered.add(item);
            }
        }
        return filtered;
    }
    
    public int getTotalValue() {
        int total = 0;
        for (Item item : inventory) {
            total = total + item.getValue();
        }
        return total;
    }
    
    public void printInventory() {
        System.out.println("\n=== " + name + "'s Inventory ===");
        System.out.println("Gold: " + gold);
        System.out.println("Items:");
        for (Item item : inventory) {
            System.out.println("- " + item);
        }
        System.out.println("Total value: " + getTotalValue() + " gold");
    }
    
    public String toString() {
        return "Player: " + name + " (Gold: " + gold + ", Items: " + inventory.size() + ")";
    }
}

void main() {
    Player hero = new Player("Hero", 1000);
    
    // Buy items
    hero.buyItem(new Item("Iron Sword", "weapon", 150));
    hero.buyItem(new Item("Wooden Shield", "armor", 100));
    hero.buyItem(new Item("Health Potion", "potion", 50));
    hero.buyItem(new Item("Steel Sword", "weapon", 300));
    
    hero.printInventory();
    
    // Find weapons
    System.out.println("\nWeapons:");
    ArrayList<Item> weapons = hero.findByType("weapon");
    for (Item weapon : weapons) {
        System.out.println("- " + weapon);
    }
    
    // Sell item
    hero.sellItem("Iron Sword");
    
    hero.printInventory();
    
    System.out.println("\nTotal items created: " + Item.getItemsCreated());
}
```
</details>

---
