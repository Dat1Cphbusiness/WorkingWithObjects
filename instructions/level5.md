# Level 5: The `this` Keyword

## Level 5 fokuserer på:
- Forstå hvad `this` refererer til (det nuværende objekt)
- Bruge `this` til at skelne mellem parametre og fields
- Bruge `this` til at returnere det nuværende objekt fra metoder
- Method chaining - kalde flere metoder i én linje
- Builder pattern - bygge objekter op gradvist
- Forstå hvornår `this` er nødvendig og hvornår det er valgfrit
- Læsbarhed og best practices med `this`

---

## Begrebsgennemgang

### Hvad er `this`?
`this` er en reference til det **nuværende objekt** - objektet hvis metode der bliver kaldt lige nu.

```java
public class Counter {
    private int value;
    
    public Counter(int value) {
        this.value = value;  // this.value = field, value = parameter
    }
}
```

### `this` i Constructors og Setters
Når en parameter har samme navn som et field, bruger vi `this` til at skelne:

```java
public class Person {
    private String name;
    
    // Uden this - FEJL! Hvilket name er hvilket?
    public Person(String name) {
        name = name;  // Tilskriver parameter til sig selv - gør ingenting!
    }
    
    // Med this - KORREKT!
    public Person(String name) {
        this.name = name;  // this.name = field, name = parameter
    }
}
```

### Returnere `this` for Method Chaining
Hvis en metode returnerer `this`, kan du kalde flere metoder i træk:

```java
public class Counter {
    private int value;
    
    public Counter increment() {
        this.value++;
        return this;  // Returnerer det nuværende objekt
    }
    
    public Counter add(int amount) {
        this.value += amount;
        return this;
    }
}

// Brug:
Counter counter = new Counter("MyCounter");
counter.increment().increment().add(5);  // Chaining!
```

### Method Chaining Fordele
Method chaining gør koden mere læsbar og kompakt:

```java
// Uden chaining
Calculator calc = new Calculator();
calc.add(5);
calc.multiply(2);
calc.subtract(3);
System.out.println(calc.getResult());  // 7

// Med chaining
Calculator calc = new Calculator()
    .add(5)
    .multiply(2)
    .subtract(3);
System.out.println(calc.getResult());  // 7
```

### Builder Pattern
Builder pattern bruger method chaining til at bygge komplekse objekter:

```java
Builder person = new Builder()
    .setName("Anna")
    .setAge(25)
    .setEmail("anna@email.com")
    .setAddress("Copenhagen");
```

**Tag udgangspunkt i klasserne Counter, Builder, og Calculator2.**  
**Skriv din kode i Main.java i testLevel5() metoden.**

---

## Tips
- `this` refererer altid til det nuværende objekt
- Brug `this.field` når du har en parameter med samme navn som et field
- Returnér `this` fra en metode for at muliggøre chaining
- Method chaining læses fra venstre til højre (eller top til bund)
- Du kan breake en chain over flere linjer for læsbarhed
- Ikke alle metoder skal returnere `this` - kun dem der skal kunne chaines
- Al din kode skal placeres inde i `testLevel5()` metoden mellem tuborgklammerne `{}`

---

## Del A: Basic `this` Usage

### Opgave 5.1: this i constructor
**Opgave:** 
1. Opret en Counter med name "Score" og initial value 10
2. Print value og name

**Forventet Output:**
```
10
Score
```

---

### Opgave 5.2: this i setter
**Opgave:** 
1. Opret en Counter: "Points", 0
2. Brug setValue() til at sætte value til 100
3. Print value

**Forventet Output:**
```
100
```

---

### Opgave 5.3: Forstå this reference
**Opgave:** 
1. Opret to Counter objekter: "Counter1" og "Counter2"
2. Set Counter1's value til 50
3. Set Counter2's value til 75
4. Print begge values for at vise at this refererer til forskellige objekter

**Forventet Output:**
```
50
75
```

---

### Opgave 5.4: this i getters
**Opgave:** 
1. Opret en Counter: "MyCounter", 42
2. Kald getName() og getValue()
3. Print resultaterne

**Forventet Output:**
```
MyCounter
42
```

---

### Opgave 5.5: Display med this
**Opgave:** 
1. Opret tre Counter objekter med forskellige navne og values
2. Kald displayInfo() på alle tre

**Forventet Output:** (eksempel)
```
Counter: Counter1 = 10
Counter: Counter2 = 25
Counter: Counter3 = 50
```

---

## Del B: Returning `this` for Method Chaining

### Opgave 5.6: Din første chain
**Opgave:** 
1. Opret en Counter: "Score", 0
2. Kald increment() to gange ved hjælp af chaining
3. Print value

**Forventet Output:**
```
2
```

---

### Opgave 5.7: Længere chain
**Opgave:** 
1. Opret en Counter: "Points", 10
2. Chain sammen: increment(), increment(), add(5), decrement()
3. Print value

**Forventet Output:**
```
16
```

---

### Opgave 5.8: Chain med display
**Opgave:** 
1. Opret en Counter: "Test", 0
2. Chain: add(10), multiplyBy(2), subtract(5), display info
3. (Bemærk: displayInfo() returnerer ikke this, så den skal være sidst)

**Forventet Output:**
```
Counter: Test = 15
```

---

### Opgave 5.9: Calculator2 chaining
**Opgave:** 
1. Opret en Calculator2 med initial value 10
2. Chain sammen: add(5), multiply(2), subtract(10)
3. Display result

**Forventet Output:**
```
Result: 20.0 (last operation: subtract)
```

---

### Opgave 5.10: Kompleks calculation
**Opgave:** 
1. Opret en Calculator2: initial value 100
2. Chain: divide(2), add(10), multiply(3), sqrt()
3. Display result

**Forventet Output:**
```
Result: 10.0 (last operation: sqrt)
```

---

## Del C: Builder Pattern

### Opgave 5.11: Basic builder
**Opgave:** 
1. Opret en Builder objekt
2. Chain setName(), setAge(), setEmail()
3. Display info

**Forventet Output:**
```
=== Builder Object ===
Name: Anna
Age: 25
Email: anna@email.com
Address: 
Phone: 
Active: true
```

---

### Opgave 5.12: Full builder
**Opgave:** 
1. Opret en Builder objekt
2. Chain alle setter metoder (name, age, email, address, phone)
3. Display info

**Forventet Output:** (eksempel)
```
=== Builder Object ===
Name: Peter Nielsen
Age: 30
Email: peter@email.com
Address: Copenhagen
Phone: 12345678
Active: true
```

---

### Opgave 5.13: Builder med activation
**Opgave:** 
1. Opret to Builder objekter
2. Den første: set name og age, derefter deactivate()
3. Den anden: set name og age, derefter activate()
4. Display info for begge

**Forventet Output:** (eksempel)
```
=== Builder Object ===
Name: Inactive User
Age: 20
Email: 
Address: 
Phone: 
Active: false
=== Builder Object ===
Name: Active User
Age: 25
Email: 
Address: 
Phone: 
Active: true
```

---

### Opgave 5.14: Multi-line chaining for læsbarhed
**Opgave:** 
Opret en Builder med chaining over flere linjer (én metode per linje):
```java
Builder person = new Builder()
    .setName("Maria")
    .setAge(28)
    .setEmail("maria@email.com")
    .setAddress("Aarhus")
    .setPhoneNumber("87654321");
```

**Forventet Output:**
```
=== Builder Object ===
Name: Maria
Age: 28
Email: maria@email.com
Address: Aarhus
Phone: 87654321
Active: true
```

---

### Opgave 5.15: Conditional chaining
**Opgave:** 
1. Opret en Builder: set name og age
2. Hvis age > 25, chain også setEmail()
3. Hvis age <= 25, chain også setPhoneNumber()
4. Display info

**Forventet Output:** (afhænger af din age)

---

## Del D: Advanced Chaining

### Opgave 5.16: Calculator chain med display
**Opgave:** 
1. Opret en Calculator2: initial 50
2. Chain: add(10), displayAndContinue(), multiply(2), displayAndContinue(), subtract(20)
3. Display final result

**Forventet Output:**
```
Result: 60.0 (last operation: add)
Result: 120.0 (last operation: multiply)
Result: 100.0 (last operation: subtract)
```

---

### Opgave 5.17: Counter reset pattern
**Opgave:** 
1. Opret en Counter: "Game", 0
2. Chain: add(100), add(50), reset(), add(25)
3. Display info

**Forventet Output:**
```
Counter: Game = 25
```

---

### Opgave 5.18: Multiple chains på samme objekt
**Opgave:** 
1. Opret en Counter: "Total", 0
2. Første chain: increment(), increment(), add(10)
3. Print value
4. Anden chain: multiplyBy(2), subtract(5)
5. Print value igen

**Forventet Output:**
```
12
19
```

---

### Opgave 5.19: Calculator comparisons
**Opgave:** 
1. Opret to Calculator2 objekter med initial value 10
2. Første: chain add(5), multiply(3)
3. Anden: chain multiply(3), add(5)
4. Print begge results for at vise at rækkefølgen betyder noget

**Forventet Output:**
```
45.0
35.0
```

---

### Opgave 5.20: Builder array
**Opgave:** 
1. Opret et Builder array med 3 elementer
2. Brug chaining til at initialisere hver builder med forskellige værdier
3. Loop gennem og display alle

**Forventet Output:** (eksempel)
```
=== Builder Object ===
Name: Person1
Age: 20
Email: person1@email.com
...
```

---

## Del E: Collections og Chaining

### Opgave 5.21: ArrayList med chaining initialization
**Opgave:** 
1. Opret en ArrayList<Counter>
2. Add 5 counters, hvor hver counter er initialiseret med chaining
3. Eksempel: `counters.add(new Counter("C1", 0).add(5).add(3));`
4. Print alle values

**Forventet Output:** (eksempel)
```
8
12
15
6
20
```

---

### Opgave 5.22: Bulk operations med chaining
**Opgave:** 
1. Opret en ArrayList med 4 Counter objekter
2. Loop gennem og chain increment(), increment(), add(10) på hver
3. Print alle values

**Forventet Output:** (eksempel)
```
12
12
12
12
```

---

### Opgave 5.23: Calculator pipeline
**Opgave:** 
1. Opret en ArrayList<Calculator2> med 3 calculators (forskellige initial values)
2. Loop gennem og apply samme chain til alle: add(10), multiply(2), subtract(5)
3. Print alle results

**Forventet Output:** (eksempel)
```
35.0
45.0
55.0
```

---

### Opgave 5.24: Builder collection
**Opgave:** 
1. Opret en ArrayList<Builder>
2. Add 4 builders ved hjælp af chained initialization
3. Nogle skal være active, nogle inactive
4. Loop gennem og display kun de active builders

**Forventet Output:** (eksempel - kun active vises)
```
=== Builder Object ===
Name: User1
Age: 25
...
Active: true
=== Builder Object ===
Name: User3
Age: 35
...
Active: true
```

---

### Opgave 5.25: Complex scenario - Game scoring
**Opgave:** 
Simuler et spil scoring system:
1. Opret tre Counter objekter: "Player1", "Player2", "Player3" (alle start på 0)
2. Runde 1: Alle players add(10)
3. Runde 2: Player1 add(20), Player2 add(15), Player3 add(25)
4. Runde 3: Alle players multiplyBy(2)
5. Bonus: Player med højeste score add(50)
6. Display alle scores

**Forventet Output:** (eksempel)
```
Counter: Player1 = 60
Counter: Player2 = 50
Counter: Player3 = 120
```

---

### Opgave 5.26: Calculator transformations
**Opgave:** 
1. Opret en Calculator2: initial 16
2. Apply følgende transformationer i rækkefølge:
   - sqrt(), add(2), power(3), divide(10), multiply(2)
3. Display result ved hver transformation (brug displayAndContinue())

**Forventet Output:**
```
Result: 4.0 (last operation: sqrt)
Result: 6.0 (last operation: add)
Result: 216.0 (last operation: power)
Result: 21.6 (last operation: divide)
Result: 43.2 (last operation: multiply)
```

---

### Opgave 5.27: Builder factory
**Opgave:** 
Opret en metode `createStandardUser(String name, int age)` der returnerer en Builder:
- Set name og age
- Set email til name@standard.com
- Set active til true
- Return builder'en

Brug metoden til at oprette 3 users og display dem.

**Forventet Output:** (implementer metoden selv)

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvorfor har vi brug for `this` når parameter og field har samme navn?
2. Hvad returnerer en metode der returnerer `this`?
3. Hvad er fordelen ved method chaining?
4. Hvornår ville method chaining være uhensigtsmæssigt?
5. Hvorfor skal displayInfo() være sidst i en chain?
6. Kan du chain metoder der returnerer void? Hvorfor/hvorfor ikke?
