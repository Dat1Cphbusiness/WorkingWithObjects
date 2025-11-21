# Level 3: Instance Fields (Setters) og State Mutation

## Level 3 fokuserer på:
- Ændre objekters tilstand gennem setter-metoder
- Forstå forskellen mellem getters (læse) og setters (skrive)
- Forstå mutability - at objekter kan ændre sig over tid
- Se hvordan ændringer i ét objekt ikke påvirker andre objekter
- Opdatere objekter i collections
- Validering og forretningslogik i setters
- Kæde metodekald sammen for at bygge kompleks tilstand

---

## Begrebsgennemgang

### Setters
En **setter-metode** lader dig ændre et objekts private field efter objektet er oprettet:

```java
Employee employee = new Employee("Anna", "Developer", 40000, 2);
System.out.println(employee.getSalary());  // 40000

employee.setSalary(45000);  // Ændrer salary
System.out.println(employee.getSalary());  // 45000
```

### Mutability
Objekter er **mutable** hvis deres tilstand kan ændres. De fleste objekter du arbejder med er mutable:

```java
GameCharacter hero = new GameCharacter("Hero", 100, 20);
hero.setHealth(50);      // Objektet ændrer sig
hero.setAttackPower(25); // Objektet ændrer sig igen
```

### Constructor vs. Setters
- **Constructor**: Bruges til at sætte initial tilstand når objektet oprettes
- **Setters**: Bruges til at ændre tilstand efter objektet er oprettet

```java
// Constructor sætter initial state
Employee emp = new Employee("Peter", "Intern", 25000, 0);

// Setters ændrer state over tid
emp.setPosition("Junior Developer");
emp.setSalary(35000);
emp.setYearsOfExperience(1);
```

### Opdatere objekter i Collections
Du kan ændre objekter der er gemt i ArrayList eller arrays:

```java
ArrayList<Employee> employees = new ArrayList<>();
employees.add(new Employee("Anna", "Developer", 40000, 2));

// Get object, modify it
Employee anna = employees.get(0);
anna.setSalary(45000);  // Ændringen påvirker objektet i ArrayList
```

**Tag udgangspunkt i klasserne Employee, GameCharacter, og ShoppingCart.**  
**Skriv din kode i Main.java i testLevel3() metoden.**

---

## Tips
- Setter-metoder starter typisk med `set` efterfulgt af field-navnet: `setName()`, `setAge()`
- Setters returnerer typisk `void` (intet)
- Nogle setters har validering (f.eks. health kan ikke være negativ)
- Du kan kalde flere setters efter hinanden: `emp.setName("X"); emp.setSalary(50000);`
- Objekter i collections kan modificeres - ændringen er permanent
- Tænk på setters som "commands" der ændrer objektets tilstand
- Al din kode skal placeres inde i `testLevel3()` metoden mellem tuborgklammerne `{}`

---

## Del A: Basic Setters

### Opgave 3.1: Din første setter
**Opgave:** 
1. Opret en Employee: "Maria", "Developer", 40000, 3
2. Print salary med getter
3. Brug `setSalary()` til at ændre salary til 45000
4. Print salary igen

**Forventet Output:**
```
40000.0
45000.0
```

---

### Opgave 3.2: Flere setters
**Opgave:** 
1. Opret en Employee: "Lars", "Intern", 25000, 0
2. Brug setters til at ændre:
   - Position til "Junior Developer"
   - Salary til 35000
   - Years of experience til 1
3. Display info

**Forventet Output:**
```
Employee: Lars
Position: Junior Developer
Salary: 35000.0 kr
Experience: 1 years
```

---

### Opgave 3.3: Uafhængige objekter
**Opgave:** 
1. Opret to Employee objekter: "Anna" og "Peter", begge med salary 40000
2. Brug setter til at ændre Anna's salary til 50000
3. Print begge salaries for at vise at Peter's salary ikke ændrede sig

**Forventet Output:**
```
Anna's salary: 50000.0
Peter's salary: 40000.0
```

---

### Opgave 3.4: GameCharacter health
**Opgave:** 
1. Opret en GameCharacter: "Warrior", 100 maxHealth, 20 attackPower
2. Print health
3. Brug `setHealth()` til at sætte health til 50
4. Print health igen
5. Display stats

**Forventet Output:**
```
100
50
=== Warrior ===
Level: 1
Health: 50/100
Attack Power: 20
```

---

### Opgave 3.5: ShoppingCart modifications
**Opgave:** 
1. Opret en ShoppingCart: "Emma"
2. Brug `setItemCount()` til at sætte item count til 5
3. Brug `setTotalPrice()` til at sætte total til 500.0
4. Display cart

**Forventet Output:**
```
=== Shopping Cart: Emma ===
Items: 5
Total: 500.0 kr
Premium Member: false
Final Price: 500.0 kr
```

---

## Del B: Helper Methods og State Changes

### Opgave 3.6: Employee raise
**Opgave:** 
1. Opret en Employee: "Sofie", "Developer", 40000, 2
2. Kald `giveRaise(10)` for at give 10% raise
3. Display info

**Forventet Output:**
```
Sofie received a 10.0% raise. New salary: 44000.0 kr
Employee: Sofie
Position: Developer
Salary: 44000.0 kr
Experience: 2 years
```

---

### Opgave 3.7: Employee promotion
**Opgave:** 
1. Opret en Employee: "Thomas", "Junior Developer", 35000, 1
2. Kald `promote("Senior Developer", 15000)`
3. Display info

**Forventet Output:**
```
Thomas promoted to Senior Developer with salary increase of 15000.0 kr
Employee: Thomas
Position: Senior Developer
Salary: 50000.0 kr
Experience: 1 years
```

---

### Opgave 3.8: GameCharacter combat
**Opgave:** 
1. Opret en GameCharacter: "Knight", 150, 25
2. Kald `takeDamage(30)` to gange
3. Kald `heal(20)`
4. Display stats

**Forventet Output:**
```
Knight took 30 damage. Health: 120/150
Knight took 30 damage. Health: 90/150
Knight healed 20 HP. Health: 110/150
=== Knight ===
Level: 1
Health: 110/150
Attack Power: 25
```

---

### Opgave 3.9: GameCharacter level up
**Opgave:** 
1. Opret en GameCharacter: "Mage", 80, 30
2. Display stats
3. Kald `levelUp()` to gange
4. Display stats igen

**Forventet Output:**
```
=== Mage ===
Level: 1
Health: 80/80
Attack Power: 30
Mage leveled up to level 2!
Max Health: 90, Attack Power: 35
Mage leveled up to level 3!
Max Health: 100, Attack Power: 40
=== Mage ===
Level: 3
Health: 100/100
Attack Power: 40
```

---

### Opgave 3.10: ShoppingCart operations
**Opgave:** 
1. Opret en ShoppingCart: "Peter"
2. Kald `addItem()` tre gange med forskellige priser
3. Kald `removeItem()` med én pris
4. Display cart

**Forventet Output:** (eksempel)
```
Added item for 100.0 kr. Total: 100.0 kr (1 items)
Added item for 250.0 kr. Total: 350.0 kr (2 items)
Added item for 150.0 kr. Total: 500.0 kr (3 items)
Removed item for 100.0 kr. Total: 400.0 kr (2 items)
=== Shopping Cart: Peter ===
Items: 2
Total: 400.0 kr
Premium Member: false
Final Price: 400.0 kr
```

---

## Del C: Collections og State Mutation

### Opgave 3.11: Opdater objekt i ArrayList
**Opgave:** 
1. Opret en `ArrayList<Employee>` med tre employees
2. Få den første employee fra listen
3. Giv denne employee en raise med `giveRaise(15)`
4. Loop gennem listen og print alle salaries

**Forventet Output:** (eksempel)
```
Anna received a 15.0% raise. New salary: 46000.0 kr
46000.0
40000.0
35000.0
```

---

### Opgave 3.12: Bulk salary increase
**Opgave:** 
1. Opret en ArrayList med fem employees
2. Loop gennem alle og giv hver employee en 5% raise
3. Print alle deres nye salaries

**Forventet Output:** (eksempel)
```
Anna received a 5.0% raise. New salary: 42000.0 kr
Peter received a 5.0% raise. New salary: 36750.0 kr
Maria received a 5.0% raise. New salary: 31500.0 kr
Lars received a 5.0% raise. New salary: 26250.0 kr
Sofie received a 5.0% raise. New salary: 47250.0 kr
42000.0
36750.0
31500.0
26250.0
47250.0
```

---

### Opgave 3.13: Conditional updates
**Opgave:** 
1. Opret en ArrayList med employees med forskellige salaries
2. Loop gennem listen
3. Giv kun employees med salary under 35000 en 10% raise
4. Print alle final salaries

**Forventet Output:** (eksempel)
```
Lars received a 10.0% raise. New salary: 33000.0 kr
Thomas received a 10.0% raise. New salary: 27500.0 kr
Salaries:
45000.0
38000.0
33000.0
27500.0
50000.0
```

---

### Opgave 3.14: GameCharacter battle simulation
**Opgave:** 
1. Opret en ArrayList med tre GameCharacter objekter
2. Loop gennem og lad hver character tage 25 damage
3. Loop gennem igen og heal hver character for 15 HP
4. Display stats for alle characters

**Forventet Output:** (eksempel)
```
Warrior took 25 damage. Health: 75/100
Mage took 25 damage. Health: 55/80
Rogue took 25 damage. Health: 85/110
Warrior healed 15 HP. Health: 90/100
Mage healed 15 HP. Health: 70/80
Rogue healed 15 HP. Health: 100/110
=== Warrior ===
Level: 1
Health: 90/100
Attack Power: 20
=== Mage ===
Level: 1
Health: 70/80
Attack Power: 30
=== Rogue ===
Level: 1
Health: 100/110
Attack Power: 15
```

---

### Opgave 3.15: Find og modificer
**Opgave:** 
1. Opret en ArrayList med flere employees
2. Find employee med navnet "Anna" (brug getter)
3. Promote denne employee til "Senior Developer" med 10000 kr raise
4. Display info for denne employee

**Forventet Output:** (eksempel)
```
Anna promoted to Senior Developer with salary increase of 10000.0 kr
Employee: Anna
Position: Senior Developer
Salary: 50000.0 kr
Experience: 3 years
```

---

### Opgave 3.16: Premium members
**Opgave:** 
1. Opret en ArrayList med fire ShoppingCart objekter
2. Tilføj items til hver cart (vælg selv priser)
3. Sæt to af carts til premium members med `setPremiumMember(true)`
4. Display alle carts for at se forskellen i final price

**Forventet Output:** (eksempel)
```
=== Shopping Cart: Anna ===
Items: 0
Total: 500.0 kr
Premium Member: true
Final Price: 450.0 kr
=== Shopping Cart: Peter ===
Items: 0
Total: 300.0 kr
Premium Member: false
Final Price: 300.0 kr
...
```

---

### Opgave 3.17: Array modifications
**Opgave:** 
1. Opret et `Employee[]` array med fire employees
2. Loop gennem arrayet og add 2 years of experience til hver employee med `addExperience(2)`
3. Print alle employees' experience levels

**Forventet Output:** (eksempel)
```
Anna now has 5 years of experience
Peter now has 3 years of experience
Maria now has 4 years of experience
Lars now has 2 years of experience
5
3
4
2
```

---

### Opgave 3.18: Level up party
**Opgave:** 
1. Opret et GameCharacter array med tre characters
2. Loop gennem og level up hver character
3. Display stats for alle

**Forventet Output:** (eksempel)
```
Warrior leveled up to level 2!
Max Health: 110, Attack Power: 25
Mage leveled up to level 2!
Max Health: 90, Attack Power: 35
Rogue leveled up to level 2!
Max Health: 120, Attack Power: 20
=== Warrior ===
Level: 2
Health: 110/110
Attack Power: 25
...
```

---

### Opgave 3.19: Shopping scenario
**Opgave:** 
1. Opret en ShoppingCart: "Emma"
2. Add fem forskellige items (vælg selv priser mellem 50-500 kr)
3. Gør Emma til premium member
4. Apply en 10% discount
5. Display cart

**Forventet Output:** (dit eget design)

---

### Opgave 3.20: Employee management system
**Opgave:** 
Opret en ArrayList med mindst 6 employees:
1. Giv alle employees under 30000 kr en 15% raise
2. Promote alle employees med 5+ years experience til "Senior" position (vælg selv salary increase)
3. Add 1 year experience til alle employees
4. Print statistik: average salary, højeste salary, antal senior positions

**Forventet Output:** (dit eget design)

---

### Opgave 3.21: Game party management
**Opgave:** 
1. Opret en ArrayList med 4 GameCharacter objekter (forskellige stats)
2. Simuler 3 kamprunder:
   - Hver character tager random damage (20-40)
   - Hvis character's health er under 30%, heal for 25 HP
3. Efter kampene, level up characters der stadig er alive
4. Display final stats for alle

**Forventet Output:** (dit eget design med variation)

---

### Opgave 3.22: Shopping cart cleanup
**Opgave:** 
1. Opret en ArrayList med flere ShoppingCart objekter
2. Add items til alle carts (forskellige amounts)
3. Loop gennem og clear alle carts der har total under 100 kr
4. Loop gennem og apply 20% discount til alle carts med total over 500 kr
5. Display alle carts

**Forventet Output:** (dit eget design)

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvad betyder det at et objekt er "mutable"?
2. Hvorfor påvirker ændringer i ét objekt ikke andre objekter?
3. Hvad er forskellen mellem at ændre et objekt gennem en setter vs. gennem en helper method (som `giveRaise()`)?
4. Hvornår ville det give mening at have validering i en setter?
5. Hvorfor kan vi modificere objekter i en ArrayList, selvom vi ikke "re-add" dem?
