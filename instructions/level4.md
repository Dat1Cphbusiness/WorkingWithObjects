# Level 4: Constructors

## Level 4 fokuserer på:
- Forstå hvad en constructor er og hvorfor den er vigtig
- Bruge forskellige constructors til at oprette objekter med forskellig initial state
- Forstå constructor overloading (flere constructors med forskellige parametre)
- Sammenligne constructor-initialisering med setter-initialisering
- Default constructors vs. parameterized constructors
- Constructors med validering og forretningslogik
- Vælge den rigtige constructor til forskellige situationer

---

## Begrebsgennemgang

### Hvad er en Constructor?
En **constructor** er en speciel metode der bliver kaldt når du opretter et objekt med `new`. Den sætter objektets initial state:

```java
// Kalder constructor med to parametre
Rectangle rect = new Rectangle(5.0, 3.0);
```

### Constructor vs. Almindelig Metode
Constructors er forskellige fra normale metoder:
- Navnet er præcis det samme som klassen
- Ingen return type (ikke engang `void`)
- Kaldes automatisk med `new`
- Bruges kun til at initialisere objekter

```java
public class Rectangle {
    // Dette er en constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // Dette er en normal metode
    public void displayInfo() {
        System.out.println("Width: " + width);
    }
}
```

### Constructor Overloading
En klasse kan have **flere constructors** med forskellige parametre:

```java
public class Person {
    // Constructor 1: Kun navn
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = 0;  // Default value
    }
    
    // Constructor 2: Navn og alder
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

// Brug constructor 1
Person p1 = new Person("Anna", "Jensen");

// Brug constructor 2
Person p2 = new Person("Peter", "Nielsen", 25);
```

### Default Constructor
Hvis en klasse ikke definerer nogen constructor, får den en **default constructor** (ingen parametre):

```java
Rectangle rect = new Rectangle();  // Bruger default constructor
```

Men hvis du definerer EN constructor, får du ikke længere den automatiske default constructor!

### Constructor vs. Setters
**Constructor**: Sæt initial state når objektet oprettes
```java
Person person = new Person("Anna", "Jensen", 25);
```

**Setters**: Ændre state efter objektet er oprettet
```java
Person person = new Person("Anna", "Jensen");
person.setAge(25);  // Sæt age senere
```

Ofte er constructor-initialisering at foretrække når du kender værdierne ved oprettelse.

**Tag udgangspunkt i klasserne Rectangle, Person, og BankAccount2.**  
**Skriv din kode i Main.java i testLevel4() metoden.**

---

## Tips
- En constructor har samme navn som klassen
- Constructors har ingen return type
- Du kan have flere constructors med forskellige parametre (overloading)
- Vælg den constructor der passer bedst til dine data
- Constructors kan have validering og forretningslogik
- Hvis du vil have både default values og custom values, lav flere constructors
- Al din kode skal placeres inde i `testLevel4()` metoden mellem tuborgklammerne `{}`

---

## Del A: Basic Constructors

### Opgave 4.1: Default constructor
**Opgave:** 
1. Opret en Rectangle ved hjælp af default constructor (ingen parametre)
2. Display info

**Forventet Output:**
```
Rectangle: 1.0 x 1.0
Color: white
Area: 1.0
Perimeter: 4.0
```

---

### Opgave 4.2: Constructor med parametre
**Opgave:** 
1. Opret en Rectangle med width 10.0 og height 5.0
2. Display info

**Forventet Output:**
```
Rectangle: 10.0 x 5.0
Color: white
Area: 50.0
Perimeter: 30.0
```

---

### Opgave 4.3: Constructor med alle parametre
**Opgave:** 
1. Opret en Rectangle med width 7.0, height 3.0, color "red"
2. Display info

**Forventet Output:**
```
Rectangle: 7.0 x 3.0
Color: red
Area: 21.0
Perimeter: 20.0
```

---

### Opgave 4.4: Sammenlign constructors
**Opgave:** 
1. Opret tre Rectangle objekter ved hjælp af hver af de tre constructors
2. Display info for alle tre

**Forventet Output:**
```
Rectangle: 1.0 x 1.0
Color: white
Area: 1.0
Perimeter: 4.0
Rectangle: 5.0 x 5.0
Color: white
Area: 25.0
Perimeter: 20.0
Rectangle: 8.0 x 4.0
Color: blue
Area: 32.0
Perimeter: 24.0
```

---

### Opgave 4.5: Person constructors
**Opgave:** 
1. Opret en Person med kun firstName "Anna" og lastName "Jensen"
2. Opret en Person med navn "Peter Nielsen" og age 30
3. Display info for begge

**Forventet Output:**
```
Name: Anna Jensen
Age: 0
Name: Peter Nielsen
Age: 30
```

---

## Del B: Constructor Overloading

### Opgave 4.6: Forskellige Person constructors
**Opgave:** 
1. Opret fire Person objekter ved hjælp af fire forskellige constructors:
   - Kun navn
   - Navn og alder
   - Navn, alder, og email
   - Alle parametre (navn, alder, email, telefon)
2. Display info for alle

**Forventet Output:** (eksempel)
```
Name: Anna Jensen
Age: 0
Name: Peter Nielsen
Age: 30
Name: Maria Larsen
Age: 25
Email: maria@email.com
Name: Lars Hansen
Age: 40
Email: lars@email.com
Phone: 12345678
```

---

### Opgave 4.7: BankAccount2 constructors
**Opgave:** 
1. Opret en BankAccount2 med kun account number "ACC001" og holder "Emma"
2. Opret en BankAccount2 med account number "ACC002", holder "Thomas", initial balance 5000
3. Display info for begge accounts

**Forventet Output:**
```
=== Account ACC001 ===
Holder: Emma
Type: Checking
Balance: 0.0 kr
Interest Rate: 1.0%
=== Account ACC002 ===
Holder: Thomas
Type: Checking
Balance: 5000.0 kr
Interest Rate: 1.0%
```

---

### Opgave 4.8: Account types
**Opgave:** 
1. Opret tre BankAccount2 objekter med forskellige account types:
   - "ACC101", "Anna", 10000, "Checking"
   - "ACC102", "Peter", 10000, "Savings"
   - "ACC103", "Maria", 10000, "Premium"
2. Apply interest til alle tre
3. Display alle balances for at se forskellen

**Forventet Output:**
```
Interest applied: 100.0 kr. New balance: 10100.0 kr
Interest applied: 300.0 kr. New balance: 10300.0 kr
Interest applied: 500.0 kr. New balance: 10500.0 kr
10100.0
10300.0
10500.0
```

---

### Opgave 4.9: Vælg den rigtige constructor
**Opgave:** 
1. Opret en Person hvor du kun kender navnet
2. Senere, brug setters til at tilføje age og email
3. Opret en anden Person hvor du kender alle oplysninger ved oprettelse
4. Display info for begge

**Forventet Output:** (eksempel)
```
Name: Sofie Andersen
Age: 28
Email: sofie@email.com
Name: Lars Petersen
Age: 35
Email: lars@email.com
Phone: 87654321
```

---

### Opgave 4.10: Constructor med logik
**Opgave:** 
1. Opret en BankAccount2 med type "Savings" - bemærk at interest rate automatisk sættes til 0.03
2. Opret en BankAccount2 med type "Premium" - interest rate sættes til 0.05
3. Display interest rates for begge

**Forventet Output:**
```
3.0%
5.0%
```

---

## Del C: Constructor med Collections

### Opgave 4.11: ArrayList med forskellige constructors
**Opgave:** 
1. Opret en `ArrayList<Rectangle>`
2. Tilføj 5 rectangles ved hjælp af forskellige constructors
3. Loop gennem og print area for alle

**Forventet Output:** (eksempel)
```
1.0
20.0
35.0
16.0
42.0
```

---

### Opgave 4.12: Find squares
**Opgave:** 
1. Opret en ArrayList med 6 Rectangle objekter (nogle squares, nogle ikke)
2. Loop gennem og print info for alle der er squares (width == height)

**Forventet Output:** (eksempel)
```
Rectangle: 5.0 x 5.0
Color: white
Area: 25.0
Perimeter: 20.0
Rectangle: 3.0 x 3.0
Color: red
Area: 9.0
Perimeter: 12.0
```

---

### Opgave 4.13: Person directory
**Opgave:** 
1. Opret en ArrayList med 5 Person objekter
2. Brug forskellige constructors - nogle med email, nogle uden
3. Loop gennem og print kun personer der har email

**Forventet Output:** (eksempel)
```
Name: Peter Nielsen
Age: 30
Email: peter@email.com
Name: Maria Larsen
Age: 25
Email: maria@email.com
```

---

### Opgave 4.14: Bank system
**Opgave:** 
1. Opret en ArrayList med 4 BankAccount2 objekter
2. Brug forskellige constructors - forskellige types og balances
3. Loop gennem og apply interest til alle
4. Find account med højeste balance

**Forventet Output:** (eksempel)
```
Interest applied: 100.0 kr. New balance: 10100.0 kr
Interest applied: 150.0 kr. New balance: 5150.0 kr
Interest applied: 300.0 kr. New balance: 10300.0 kr
Interest applied: 750.0 kr. New balance: 15750.0 kr
Highest balance: ACC104 with 15750.0 kr
```

---

### Opgave 4.15: Constructor vs. Setter comparison
**Opgave:** 
1. Opret en Person ved hjælp af constructor med alle parametre
2. Opret en Person ved hjælp af minimal constructor, derefter brug setters
3. Mål tiden det tager (konceptuelt - bare print "Done" efter hver)
4. Diskuter: Hvilken metode er mere læselig?

**Forventet Output:**
```
Constructor method done
Setter method done
```

---

## Del D: Advanced Constructor Usage

### Opgave 4.16: Initialize collection with constructors
**Opgave:** 
1. Opret et `Rectangle[]` array med 5 elementer
2. Brug en loop til at initialisere hver rectangle med width = i+1, height = i+2
3. Print alle areas

**Forventet Output:**
```
2.0
6.0
12.0
20.0
30.0
```

---

### Opgave 4.17: Factory pattern (simple)
**Opgave:** 
1. Opret en metode `createSavingsAccount(String holder, double balance)` der returnerer en BankAccount2 med type "Savings"
2. Opret en metode `createPremiumAccount(String holder, double balance)` der returnerer en BankAccount2 med type "Premium"
3. Brug metoderne til at oprette 3 savings og 2 premium accounts
4. Display alle

**Forventet Output:** (eksempel - implementer metoderne selv)
```
=== Account ACC001 ===
Holder: Anna
Type: Savings
Balance: 5000.0 kr
Interest Rate: 3.0%
...
```

---

### Opgave 4.18: Bulk creation
**Opgave:** 
1. Opret en ArrayList<Person>
2. Brug en loop til at oprette 10 personer med navne "Person1", "Person2", osv. og ages 20-29
3. Print count af adults (age >= 18)

**Forventet Output:**
```
Number of adults: 10
```

---

### Opgave 4.19: Configuration-based construction
**Opgave:** 
1. Opret tre "configuration" variabler: defaultWidth, defaultHeight, defaultColor
2. Opret 5 Rectangle objekter ved hjælp af disse configurations
3. Ændre configuration variablerne
4. Opret 5 mere Rectangle objekter
5. Print info for første og sidste rectangle for at vise forskellen

**Forventet Output:** (eksempel)
```
First rectangle:
Rectangle: 5.0 x 3.0
Color: blue
Area: 15.0
Perimeter: 16.0
Last rectangle:
Rectangle: 8.0 x 4.0
Color: red
Area: 32.0
Perimeter: 24.0
```

---

### Opgave 4.20: Complex initialization
**Opgave:** 
Opret en "bank" med forskellige account types:
1. Opret en ArrayList<BankAccount2>
2. Add 3 checking accounts (forskellige balances)
3. Add 3 savings accounts (forskellige balances)
4. Add 2 premium accounts (forskellige balances)
5. Loop gennem alle og:
   - Apply interest
   - Deposit 1000 kr til alle accounts med balance under 5000
6. Beregn total bank assets (sum af alle balances)

**Forventet Output:** (dit eget design)

---

### Opgave 4.21: Person contact list
**Opgave:** 
Opret en contact list applikation:
1. Opret ArrayList<Person> med mindst 8 personer
2. Nogle har kun navn, nogle har email, nogle har både email og telefon
3. Find og print alle personer der:
   - Er adults
   - Har email
   - Har telefon nummer
4. Print statistik

**Forventet Output:** (dit eget design)

---

### Opgave 4.22: Shape comparison
**Opgave:** 
1. Opret ArrayList<Rectangle> med 10 rectangles (random dimensions)
2. Find og print:
   - Largest area
   - Smallest area
   - Total area of all rectangles
   - Average area
   - Count of squares

**Forventet Output:** (dit eget design)

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvad er fordelen ved at have flere constructors i samme klasse?
2. Hvornår ville du bruge en constructor med få parametre vs. mange parametre?
3. Hvad er fordelen ved at initialisere gennem constructor vs. gennem setters?
4. Hvordan kan en constructor have logik (som at sætte interest rate baseret på account type)?
5. Hvis du skulle designe en ny klasse, hvordan ville du beslutte hvilke constructors den skulle have?
