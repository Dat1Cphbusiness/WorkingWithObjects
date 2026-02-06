# Level 7: Object Interaction - Opgaver

## Indhold
- [ ] [Del A: Objekter som Parametre](#del-a-objekter-som-parametre)
- [ ] [Del B: Composition (Objekter Indeholder Objekter)](#del-b-composition-objekter-indeholder-objekter)
- [ ] [Del C: Arrays i Objekter](#del-c-arrays-i-objekter)
- [ ] [Del D: Complex Interactions](#del-d-complex-interactions)
- [ ] [Del E: Advanced Systems](#del-e-advanced-systems)
- 
## Del A: Objekter som Parametre

### Opgave 1: Basic Object Comparison
Lav en klasse `Player` med:
- `String name`
- `int score`

Lav en konstruktør.

Lav instance methods:
- `boolean hasHigherScoreThan(Player other)` - returner true hvis this player har højere score
- `void printComparison(Player other)` - print "{this.name} vs {other.name}: {winner} wins!"

I `main()`:
- Lav to players
- Kald `printComparison()` på den ene

<details>
<summary>Se svar</summary>

```java
class Player {
    String name;
    int score;
    
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    boolean hasHigherScoreThan(Player other) {
        return score > other.score;
    }
    
    void printComparison(Player other) {
        System.out.print(name + " vs " + other.name + ": ");
        if (hasHigherScoreThan(other)) {
            System.out.println(name + " wins!");
        } else {
            System.out.println(other.name + " wins!");
        }
    }
}

void main() {
    Player anna = new Player("Anna", 150);
    Player mikkel = new Player("Mikkel", 120);
    
    anna.printComparison(mikkel);
}
```
</details>

---

### Opgave 2: Transfer Between Objects
Lav en klasse `BankAccount` med:
- `String owner`
- `double balance`

Lav en konstruktør.

Lav instance methods:
- `void transfer(BankAccount target, double amount)` - hvis balance >= amount: reducer egen balance, øg target balance. Ellers print "Insufficient funds"
- `void printBalance()` - print owner og balance

I `main()`:
- Lav to konti
- Transfer 300 kr fra den ene til den anden
- Print begge balances

<details>
<summary>Se svar</summary>

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
            balance = balance - amount;
            target.balance = target.balance + amount;
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
    
    anna.printBalance();
    mikkel.printBalance();
}
```
</details>

---

### Opgave 3: Battle System
Lav en klasse `Character` med:
- `String name`
- `int health`
- `int attackPower`

Lav en konstruktør.

Lav instance methods:
- `void takeDamage(int damage)` - reducer health (min 0)
- `void attack(Character target)` - print "{name} attacks {target.name}!", kald target.takeDamage() med attackPower
- `boolean isAlive()` - returner true hvis health > 0
- `void printStatus()` - print navn og health

I `main()`:
- Lav to characters
- Lad dem angribe hinanden indtil én er død
- Print status for begge

<details>
<summary>Hint</summary>

Brug en while loop til at fortsætte kampen indtil én character har health <= 0.
</details>

<details>
<summary>Se svar</summary>

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
        target.takeDamage(attackPower);
    }
    
    boolean isAlive() {
        return health > 0;
    }
    
    void printStatus() {
        System.out.println(name + ": " + health + " HP");
    }
}

void main() {
    Character hero = new Character("Hero", 100, 25);
    Character monster = new Character("Monster", 80, 20);
    
    while (hero.isAlive() && monster.isAlive()) {
        hero.attack(monster);
        if (monster.isAlive()) {
            monster.attack(hero);
        }
    }
    
    System.out.println("\n=== Battle Result ===");
    hero.printStatus();
    monster.printStatus();
}
```
</details>

---

### Opgave 4: Race Between Cars
Lav en klasse `Car` med:
- `String brand`
- `int position`
- `int speed`

Lav en konstruktør (position starter på 0).

Lav instance methods:
- `void move()` - øger position med speed
- `void race(Car opponent)` - begge biler move 5 gange, print vinderen
- `boolean isAheadOf(Car other)` - returner true hvis position > other.position

I `main()`:
- Lav to biler med forskellige speeds
- Lad dem race mod hinanden

<details>
<summary>Se svar</summary>

```java
class Car {
    String brand;
    int position;
    int speed;
    
    Car(String brand, int speed) {
        this.brand = brand;
        this.position = 0;
        this.speed = speed;
    }
    
    void move() {
        position = position + speed;
    }
    
    void race(Car opponent) {
        System.out.println(brand + " races " + opponent.brand);
        
        for (int i = 0; i < 5; i++) {
            move();
            opponent.move();
        }
        
        if (isAheadOf(opponent)) {
            System.out.println(brand + " wins! Position: " + position);
        } else {
            System.out.println(opponent.brand + " wins! Position: " + opponent.position);
        }
    }
    
    boolean isAheadOf(Car other) {
        return position > other.position;
    }
}

void main() {
    Car ferrari = new Car("Ferrari", 50);
    Car porsche = new Car("Porsche", 45);
    
    ferrari.race(porsche);
}
```
</details>

---

## Del B: Composition (Objekter Indeholder Objekter)

### Opgave 5: Car med Engine
Lav en klasse `Engine` med:
- `int horsePower`
- `String type`

Lav en konstruktør og en `printInfo()` metode.

Lav en klasse `Car` med:
- `String brand`
- `Engine engine`

Lav en konstruktør og en `printInfo()` metode der også kalder engine.printInfo().

I `main()`:
- Lav en engine
- Lav en car med den engine
- Print car info

<details>
<summary>Se svar</summary>

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
    Engine engine;
    
    Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }
    
    void printInfo() {
        System.out.println("Car: " + brand);
        engine.printInfo();
    }
}

void main() {
    Engine v8 = new Engine(450, "V8");
    Car mustang = new Car("Mustang", v8);
    
    mustang.printInfo();
}
```
</details>

---

### Opgave 6: Restaurant med Address
Lav en klasse `Address` med:
- `String street`
- `String city`

Lav en konstruktør og en `printAddress()` metode.

Lav en klasse `Restaurant` med:
- `String name`
- `Address location`
- `String cuisine`

Lav en konstruktør og en `printInfo()` metode.

I `main()`:
- Lav en address
- Lav en restaurant med den address
- Print restaurant info

<details>
<summary>Se svar</summary>

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
</details>

---

### Opgave 7: Character med Weapon
Lav en klasse `Weapon` med:
- `String name`
- `int damage`

Lav en konstruktør.

Lav en klasse `Character` med:
- `String name`
- `int health`
- `Weapon weapon`

Lav en konstruktør (weapon kan være null).

Lav instance methods:
- `void equip(Weapon w)` - sætter weapon, print "{name} equipped {w.name}"
- `void attack(Character target)` - hvis weapon er null, print "No weapon!". Ellers kalder target.takeDamage() med weapon.damage
- `void takeDamage(int damage)` - reducer health

I `main()`:
- Lav to characters uden weapons
- Lav to weapons
- Equip characters med weapons
- Lad dem angribe hinanden

<details>
<summary>Se svar</summary>

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
}
```
</details>

---

### Opgave 8: Player med Inventory Item
Lav en klasse `Item` med:
- `String name`
- `double weight`

Lav en konstruktør.

Lav en klasse `Player` med:
- `String name`
- `Item heldItem` (kan være null)
- `double maxCarryWeight`

Lav en konstruktør (heldItem starter som null).

Lav instance methods:
- `void pickUp(Item item)` - hvis item.weight <= maxCarryWeight: sæt heldItem til item. Ellers print "Too heavy!"
- `void drop()` - sæt heldItem til null
- `void printInventory()` - print hvad spilleren holder (eller "Empty hands")

I `main()`:
- Lav en player med max carry weight 5.0
- Lav nogle items med forskellige weights
- Prøv at pick up items
- Drop og pick up andre items
- Print inventory

<details>
<summary>Se svar</summary>

```java
class Item {
    String name;
    double weight;
    
    Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}

class Player {
    String name;
    Item heldItem;
    double maxCarryWeight;
    
    Player(String name, double maxCarryWeight) {
        this.name = name;
        this.heldItem = null;
        this.maxCarryWeight = maxCarryWeight;
    }
    
    void pickUp(Item item) {
        if (item.weight <= maxCarryWeight) {
            heldItem = item;
            System.out.println(name + " picked up " + item.name);
        } else {
            System.out.println(item.name + " is too heavy!");
        }
    }
    
    void drop() {
        if (heldItem != null) {
            System.out.println(name + " dropped " + heldItem.name);
            heldItem = null;
        }
    }
    
    void printInventory() {
        System.out.print(name + " is holding: ");
        if (heldItem != null) {
            System.out.println(heldItem.name + " (" + heldItem.weight + " kg)");
        } else {
            System.out.println("Empty hands");
        }
    }
}

void main() {
    Player anna = new Player("Anna", 5.0);
    
    Item sword = new Item("Sword", 3.5);
    Item shield = new Item("Shield", 6.0);
    Item potion = new Item("Potion", 0.5);
    
    anna.pickUp(sword);
    anna.printInventory();
    
    anna.drop();
    anna.pickUp(shield);  // Too heavy
    anna.pickUp(potion);
    anna.printInventory();
}
```
</details>

---

## Del C: Arrays i Objekter

### Opgave 9: Team med Players
Lav en klasse `Player` med:
- `String name`
- `int score`

Lav en konstruktør.

Lav en klasse `Team` med:
- `String name`
- `Player[] players`
- `int playerCount`

Lav en konstruktør der tager team navn og max players.

Lav instance methods:
- `void addPlayer(Player p)` - tilføj player til arrayet hvis plads
- `int getTotalScore()` - returner sum af alle players' scores
- `void printTeam()` - print team navn og alle players med deres scores

I `main()`:
- Lav et team
- Lav og tilføj 4 players
- Print team
- Print total score

<details>
<summary>Se svar</summary>

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
            System.out.println(p.name + " joined " + name);
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
        System.out.println("=== " + name + " ===");
        for (int i = 0; i < playerCount; i++) {
            System.out.println(players[i].name + ": " + players[i].score);
        }
        System.out.println("Total: " + getTotalScore());
    }
}

void main() {
    Team redTeam = new Team("Red Team", 5);
    
    redTeam.addPlayer(new Player("Anna", 100));
    redTeam.addPlayer(new Player("Mikkel", 150));
    redTeam.addPlayer(new Player("Sofie", 120));
    redTeam.addPlayer(new Player("Lars", 90));
    
    redTeam.printTeam();
}
```
</details>

---

### Opgave 10: Shop med Items
Lav en klasse `Item` med:
- `String name`
- `double price`

Lav en konstruktør.

Lav en klasse `Shop` med:
- `String name`
- `Item[] inventory`
- `int itemCount`

Lav en konstruktør.

Lav instance methods:
- `void addItem(Item item)` - tilføj item til inventory
- `Item findCheapest()` - returner billigste item (eller null hvis ingen items)
- `Item findMostExpensive()` - returner dyreste item
- `void printInventory()` - print alle items

I `main()`:
- Lav en shop
- Tilføj 5 items med forskellige priser
- Find og print cheapest og most expensive

<details>
<summary>Se svar</summary>

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
    
    Item findMostExpensive() {
        if (itemCount == 0) {
            return null;
        }
        
        Item expensive = inventory[0];
        for (int i = 1; i < itemCount; i++) {
            if (inventory[i].price > expensive.price) {
                expensive = inventory[i];
            }
        }
        return expensive;
    }
    
    void printInventory() {
        System.out.println("=== " + name + " ===");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(inventory[i].name + ": " + inventory[i].price + " kr");
        }
    }
}

void main() {
    Shop electronics = new Shop("Electronics Store", 10);
    
    electronics.addItem(new Item("Mouse", 299));
    electronics.addItem(new Item("Keyboard", 599));
    electronics.addItem(new Item("Monitor", 2499));
    electronics.addItem(new Item("Webcam", 899));
    electronics.addItem(new Item("Headset", 1299));
    
    electronics.printInventory();
    
    Item cheapest = electronics.findCheapest();
    Item expensive = electronics.findMostExpensive();
    
    System.out.println("\nCheapest: " + cheapest.name + " - " + cheapest.price + " kr");
    System.out.println("Most expensive: " + expensive.name + " - " + expensive.price + " kr");
}
```
</details>

---

### Opgave 11: Restaurant med Menu
Lav en klasse `Dish` med:
- `String name`
- `double price`
- `int calories`

Lav en konstruktør og en `boolean isHealthy()` method (calories < 500).

Lav en klasse `Restaurant` med:
- `String name`
- `Dish[] menu`
- `int dishCount`

Lav en konstruktør.

Lav instance methods:
- `void addDish(Dish dish)` - tilføj dish til menu
- `int countHealthyOptions()` - returner antal healthy dishes
- `double getAveragePrice()` - returner gennemsnitspris
- `void printMenu()` - print alle dishes

I `main()`:
- Lav en restaurant
- Tilføj 6 dishes
- Print menu
- Print antal healthy options
- Print average price

<details>
<summary>Se svar</summary>

```java
class Dish {
    String name;
    double price;
    int calories;
    
    Dish(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }
    
    boolean isHealthy() {
        return calories < 500;
    }
}

class Restaurant {
    String name;
    Dish[] menu;
    int dishCount;
    
    Restaurant(String name, int maxDishes) {
        this.name = name;
        this.menu = new Dish[maxDishes];
        this.dishCount = 0;
    }
    
    void addDish(Dish dish) {
        if (dishCount < menu.length) {
            menu[dishCount] = dish;
            dishCount = dishCount + 1;
        }
    }
    
    int countHealthyOptions() {
        int count = 0;
        for (int i = 0; i < dishCount; i++) {
            if (menu[i].isHealthy()) {
                count = count + 1;
            }
        }
        return count;
    }
    
    double getAveragePrice() {
        if (dishCount == 0) {
            return 0;
        }
        double total = 0;
        for (int i = 0; i < dishCount; i++) {
            total = total + menu[i].price;
        }
        return total / dishCount;
    }
    
    void printMenu() {
        System.out.println("=== " + name + " Menu ===");
        for (int i = 0; i < dishCount; i++) {
            System.out.println(menu[i].name + " - " + menu[i].price + " kr - " + 
                             menu[i].calories + " cal");
        }
    }
}

void main() {
    Restaurant bistro = new Restaurant("The Bistro", 10);
    
    bistro.addDish(new Dish("Salad", 75, 320));
    bistro.addDish(new Dish("Burger", 95, 850));
    bistro.addDish(new Dish("Pasta", 89, 650));
    bistro.addDish(new Dish("Soup", 65, 280));
    bistro.addDish(new Dish("Steak", 145, 720));
    bistro.addDish(new Dish("Fish", 120, 450));
    
    bistro.printMenu();
    System.out.println("\nHealthy options: " + bistro.countHealthyOptions());
    System.out.println("Average price: " + bistro.getAveragePrice() + " kr");
}
```
</details>

---

### Opgave 12: Garage med Cars
Lav en klasse `Car` med:
- `String brand`
- `int year`
- `boolean damaged`

Lav en konstruktør.

Lav instance methods:
- `void repair()` - sætter damaged til false
- `boolean needsRepair()` - returner damaged

Lav en klasse `Garage` med:
- `String name`
- `Car[] cars`
- `int carCount`

Lav en konstruktør.

Lav instance methods:
- `void addCar(Car car)` - tilføj car
- `void repairAll()` - repair alle biler der needs repair
- `int countDamaged()` - returner antal damaged cars
- `void printGarage()` - print alle biler

I `main()`:
- Lav en garage
- Tilføj 5 biler (nogle damaged)
- Print antal damaged
- Repair all
- Print antal damaged igen

<details>
<summary>Se svar</summary>

```java
class Car {
    String brand;
    int year;
    boolean damaged;
    
    Car(String brand, int year, boolean damaged) {
        this.brand = brand;
        this.year = year;
        this.damaged = damaged;
    }
    
    void repair() {
        damaged = false;
        System.out.println(brand + " repaired!");
    }
    
    boolean needsRepair() {
        return damaged;
    }
}

class Garage {
    String name;
    Car[] cars;
    int carCount;
    
    Garage(String name, int maxCars) {
        this.name = name;
        this.cars = new Car[maxCars];
        this.carCount = 0;
    }
    
    void addCar(Car car) {
        if (carCount < cars.length) {
            cars[carCount] = car;
            carCount = carCount + 1;
        }
    }
    
    void repairAll() {
        System.out.println("\nRepairing all damaged cars...");
        for (int i = 0; i < carCount; i++) {
            if (cars[i].needsRepair()) {
                cars[i].repair();
            }
        }
    }
    
    int countDamaged() {
        int count = 0;
        for (int i = 0; i < carCount; i++) {
            if (cars[i].damaged) {
                count = count + 1;
            }
        }
        return count;
    }
    
    void printGarage() {
        System.out.println("=== " + name + " ===");
        for (int i = 0; i < carCount; i++) {
            System.out.println(cars[i].brand + " (" + cars[i].year + ") - Damaged: " + 
                             cars[i].damaged);
        }
    }
}

void main() {
    Garage garage = new Garage("Joe's Garage", 10);
    
    garage.addCar(new Car("Toyota", 2018, false));
    garage.addCar(new Car("Ford", 2015, true));
    garage.addCar(new Car("Honda", 2020, true));
    garage.addCar(new Car("BMW", 2019, false));
    garage.addCar(new Car("Audi", 2017, true));
    
    garage.printGarage();
    System.out.println("\nDamaged cars: " + garage.countDamaged());
    
    garage.repairAll();
    
    System.out.println("\nDamaged cars: " + garage.countDamaged());
}
```
</details>

---

## Del D: Complex Interactions

### Opgave 13: Customer Buying from Shop
Lav en klasse `Product` med:
- `String name`
- `double price`
- `int stock`

Lav en konstruktør og en `void sell()` method der reducer stock.

Lav en klasse `Customer` med:
- `String name`
- `double money`

Lav en konstruktør.

Lav en instance method:
- `void buy(Product product)` - hvis customer har nok penge OG product har stock: reducer money, kald product.sell(). Print "{name} bought {product.name}". Ellers print failure reason.

I `main()`:
- Lav en customer med 500 kr
- Lav 3 produkter
- Lad customer prøve at købe dem alle
- Print customer's remaining money

<details>
<summary>Se svar</summary>

```java
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

class Customer {
    String name;
    double money;
    
    Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }
    
    void buy(Product product) {
        if (product.stock <= 0) {
            System.out.println(product.name + " is out of stock!");
        } else if (money < product.price) {
            System.out.println(name + " cannot afford " + product.name);
        } else {
            money = money - product.price;
            product.sell();
            System.out.println(name + " bought " + product.name);
        }
    }
}

void main() {
    Customer anna = new Customer("Anna", 500);
    
    Product laptop = new Product("Laptop", 8999, 2);
    Product mouse = new Product("Mouse", 299, 5);
    Product keyboard = new Product("Keyboard", 599, 0);
    
    anna.buy(laptop);    // Cannot afford
    anna.buy(mouse);     // Success
    anna.buy(keyboard);  // Out of stock
    
    System.out.println("\n" + anna.name + " has " + anna.money + " kr left");
}
```
</details>

---

### Opgave 14: Team Battle
Lav en klasse `Player` med:
- `String name`
- `int health`
- `int attackPower`

Lav konstruktør og methods: `attack(Player target)`, `takeDamage(int damage)`, `isAlive()`.

Lav en klasse `Team` med:
- `String name`
- `Player[] players`
- `int playerCount`

Lav konstruktør og `addPlayer()` method.

Lav en instance method:
- `void battle(Team opponent)` - hver player fra this team angriber en random player fra opponent team. Print battle result.
- `int countAlive()` - returner antal spillere med health > 0

I `main()`:
- Lav to teams med 3 players hver
- Lav battle mellem teams
- Print antal alive på hver team

<details>
<summary>Hint</summary>

Brug `(int)(Math.random() * opponent.playerCount)` for random target.
</details>

<details>
<summary>Se svar</summary>

```java
class Player {
    String name;
    int health;
    int attackPower;
    
    Player(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    
    void attack(Player target) {
        System.out.println(name + " attacks " + target.name);
        target.takeDamage(attackPower);
    }
    
    void takeDamage(int damage) {
        health = health - damage;
        if (health < 0) {
            health = 0;
        }
    }
    
    boolean isAlive() {
        return health > 0;
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
    
    void battle(Team opponent) {
        System.out.println("\n=== " + name + " vs " + opponent.name + " ===");
        
        for (int i = 0; i < playerCount; i++) {
            if (players[i].isAlive()) {
                int targetIndex = (int)(Math.random() * opponent.playerCount);
                players[i].attack(opponent.players[targetIndex]);
            }
        }
    }
    
    int countAlive() {
        int count = 0;
        for (int i = 0; i < playerCount; i++) {
            if (players[i].isAlive()) {
                count = count + 1;
            }
        }
        return count;
    }
}

void main() {
    Team red = new Team("Red Team", 5);
    red.addPlayer(new Player("Anna", 100, 20));
    red.addPlayer(new Player("Mikkel", 100, 25));
    red.addPlayer(new Player("Sofie", 100, 22));
    
    Team blue = new Team("Blue Team", 5);
    blue.addPlayer(new Player("Lars", 100, 21));
    blue.addPlayer(new Player("Emma", 100, 23));
    blue.addPlayer(new Player("Peter", 100, 19));
    
    red.battle(blue);
    blue.battle(red);
    red.battle(blue);
    
    System.out.println("\n=== Battle Result ===");
    System.out.println("Red team alive: " + red.countAlive());
    System.out.println("Blue team alive: " + blue.countAlive());
}
```
</details>

---

### Opgave 15: Driver og Car System
Lav en klasse `Driver` med:
- `String name`
- `int skill` (0-100)

Lav en konstruktør.

Lav en klasse `Car` med:
- `String brand`
- `int baseSpeed`
- `Driver driver` (kan være null)

Lav en konstruktør (driver starter som null).

Lav instance methods:
- `void assignDriver(Driver d)` - sæt driver
- `int getEffectiveSpeed()` - hvis driver er null: return 0, ellers: return baseSpeed + driver.skill
- `void race(Car opponent)` - sammenlign effective speeds, print vinder

I `main()`:
- Lav to biler
- Lav to drivers med forskellige skills
- Assign drivers til biler
- Lad bilerne race

<details>
<summary>Se svar</summary>

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
    int baseSpeed;
    Driver driver;
    
    Car(String brand, int baseSpeed) {
        this.brand = brand;
        this.baseSpeed = baseSpeed;
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
        return baseSpeed + driver.skill;
    }
    
    void race(Car opponent) {
        System.out.println("\n=== Race ===");
        System.out.println(brand + " (speed: " + getEffectiveSpeed() + ") vs " + 
                         opponent.brand + " (speed: " + opponent.getEffectiveSpeed() + ")");
        
        if (getEffectiveSpeed() > opponent.getEffectiveSpeed()) {
            System.out.println(brand + " wins!");
        } else {
            System.out.println(opponent.brand + " wins!");
        }
    }
}

void main() {
    Car ferrari = new Car("Ferrari", 200);
    Car porsche = new Car("Porsche", 190);
    
    Driver anna = new Driver("Anna", 75);
    Driver mikkel = new Driver("Mikkel", 85);
    
    ferrari.assignDriver(anna);
    porsche.assignDriver(mikkel);
    
    ferrari.race(porsche);
}
```
</details>

---

### Opgave 16: Library Book Loan System
Lav en klasse `Book` med:
- `String title`
- `boolean available`

Lav en konstruktør (available starter som true).

Lav instance methods:
- `void borrow()` - sæt available til false
- `void returnBook()` - sæt available til true

Lav en klasse `Member` med:
- `String name`
- `Book borrowedBook` (kan være null)

Lav en konstruktør (borrowedBook starter som null).

Lav instance methods:
- `void borrowBook(Book book)` - hvis book er available OG member ikke allerede har en bog: kald book.borrow(), sæt borrowedBook. Print success/failure.
- `void returnBook()` - hvis member har en bog: kald borrowedBook.returnBook(), sæt borrowedBook til null

I `main()`:
- Lav 3 bøger
- Lav 2 members
- Simuler borrowing og returning

<details>
<summary>Se svar</summary>

```java
class Book {
    String title;
    boolean available;
    
    Book(String title) {
        this.title = title;
        this.available = true;
    }
    
    void borrow() {
        available = false;
    }
    
    void returnBook() {
        available = true;
    }
}

class Member {
    String name;
    Book borrowedBook;
    
    Member(String name) {
        this.name = name;
        this.borrowedBook = null;
    }
    
    void borrowBook(Book book) {
        if (borrowedBook != null) {
            System.out.println(name + " already has a book!");
        } else if (!book.available) {
            System.out.println(book.title + " is not available");
        } else {
            book.borrow();
            borrowedBook = book;
            System.out.println(name + " borrowed " + book.title);
        }
    }
    
    void returnBook() {
        if (borrowedBook != null) {
            System.out.println(name + " returned " + borrowedBook.title);
            borrowedBook.returnBook();
            borrowedBook = null;
        } else {
            System.out.println(name + " has no book to return");
        }
    }
}

void main() {
    Book book1 = new Book("1984");
    Book book2 = new Book("Harry Potter");
    Book book3 = new Book("The Hobbit");
    
    Member anna = new Member("Anna");
    Member mikkel = new Member("Mikkel");
    
    anna.borrowBook(book1);
    mikkel.borrowBook(book1);  // Not available
    mikkel.borrowBook(book2);
    anna.borrowBook(book3);    // Already has a book
    anna.returnBook();
    anna.borrowBook(book3);
}
```
</details>

---

