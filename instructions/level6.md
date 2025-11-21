# Level 6: Static Methods og Fields

## Level 6 fokuserer på:
- Forstå forskellen mellem static og instance members
- Kalde static metoder uden at oprette objekter
- Tilgå static fields (class-level data)
- Forstå hvornår static er passende vs. instance
- Static constants (final static fields)
- Kombination af static og instance members i samme klasse
- Utility classes med kun static metoder
- Shared state mellem alle objekter via static fields

---

## Begrebsgennemgang

### Static vs. Instance
**Instance members** tilhører et specifikt objekt:
```java
Car car = new Car("Toyota", "red");
car.start();  // Instance method - virker på ÉT Car objekt
```

**Static members** tilhører klassen selv, ikke et specifikt objekt:
```java
int sum = MathUtils.add(5, 3);  // Static method - ingen objekt nødvendigt
```

### Static Methods
Static metoder kaldes med **klassenavnet**, ikke et objekt:

```java
// KORREKT - brug klassenavn
int result = MathUtils.add(5, 3);

// FORKERT - ingen grund til at oprette objekt
MathUtils utils = new MathUtils();  // Unødvendigt!
int result = utils.add(5, 3);
```

### Static Fields
Static fields er **delt mellem alle instanser** af en klasse:

```java
public class Counter {
    private static int totalCount = 0;  // Delt af alle Counter objekter
    private int value;                   // Unik for hver Counter
    
    public Counter() {
        totalCount++;  // Hver gang vi opretter en Counter, øges totalCount
    }
}
```

### Static Constants
Static final fields er **konstanter** der aldrig ændrer sig:

```java
public class MathUtils {
    public static final double PI = 3.14159;  // Konstant
}

// Brug:
double area = MathUtils.PI * radius * radius;
```

### Hvornår Bruge Static?
**Brug static når:**
- Utility metoder (Math.max, String.format)
- Konstanter (Math.PI, Color.RED)
- Factory metoder
- Tælle instanser eller dele data mellem alle objekter

**Brug instance når:**
- Du arbejder med specifik objekt-data
- Hver objekt skal have sin egen state
- Du bruger `this` keywordet

### Static Methods Kan Ikke Tilgå Instance Members
```java
public class Example {
    private int instanceVar = 10;
    private static int staticVar = 20;
    
    public static void staticMethod() {
        System.out.println(staticVar);     // OK
        System.out.println(instanceVar);   // FEJL! Hvilket objekt?
        System.out.println(this.instanceVar);  // FEJL! Ingen 'this' i static
    }
}
```

**Tag udgangspunkt i klasserne MathUtils, StudentRegistry, og BankSystem.**  
**Skriv din kode i Main.java i testLevel6() metoden.**

---

## Tips
- Static metoder kaldes med klassenavn: `ClassName.methodName()`
- Static fields er delt mellem ALLE instanser
- Du behøver ikke oprette et objekt for at bruge static members
- Static metoder kan ikke bruge `this` eller tilgå instance fields direkte
- Konstanter bør være `public static final`
- Utility classes (kun static metoder) behøver aldrig instantieres
- Al din kode skal placeres inde i `testLevel6()` metoden mellem tuborgklammerne `{}`

---

## Del A: Basic Static Methods

### Opgave 6.1: Din første static method call
**Opgave:** 
1. Kald MathUtils.add(10, 5) og print resultatet
2. Kald MathUtils.multiply(4, 7) og print resultatet

**Forventet Output:**
```
15
28
```

---

### Opgave 6.2: Static methods uden objekter
**Opgave:** 
1. Kald følgende MathUtils metoder UDEN at oprette et MathUtils objekt:
   - subtract(20, 8)
   - divide(100, 4)
   - max(15, 23)

**Forventet Output:**
```
12
25.0
23
```

---

### Opgave 6.3: Static constants
**Opgave:** 
1. Print MathUtils.PI
2. Beregn circle area med radius 5 ved hjælp af MathUtils.circleArea()
3. Beregn circle circumference med radius 5 ved hjælp af MathUtils.circleCircumference()

**Forventet Output:**
```
3.14159
78.53975
31.4159
```

---

### Opgave 6.4: Boolean static methods
**Opgave:** 
1. Check om 10 er even ved hjælp af MathUtils.isEven()
2. Check om 7 er even
3. Check om 17 er prime ved hjælp af MathUtils.isPrime()
4. Check om 18 er prime

**Forventet Output:**
```
true
false
true
false
```

---

### Opgave 6.5: Complex static methods
**Opgave:** 
1. Beregn factorial af 5 ved hjælp af MathUtils.factorial()
2. Beregn factorial af 7
3. Find max af (factorial(4), factorial(3))

**Forventet Output:**
```
120
5040
24
```

---

## Del B: Static Fields (Class-Level Data)

### Opgave 6.6: Tracking instance creation
**Opgave:** 
1. Print StudentRegistry.getTotalStudents() (før du opretter nogen studerende)
2. Opret tre StudentRegistry objekter
3. Print StudentRegistry.getTotalStudents() igen

**Forventet Output:**
```
0
3
```

---

### Opgave 6.7: Auto-incrementing IDs
**Opgave:** 
1. Print StudentRegistry.getNextId()
2. Opret en StudentRegistry: "Anna", grade 8.0
3. Print student's ID
4. Opret en StudentRegistry: "Peter", grade 7.5
5. Print student's ID
6. Print StudentRegistry.getNextId()

**Forventet Output:**
```
1000
1000
1001
1002
```

---

### Opgave 6.8: Shared state
**Opgave:** 
1. Opret tre StudentRegistry objekter
2. Print totalStudents
3. Opret to mere StudentRegistry objekter
4. Print totalStudents igen
5. Vis at static field er delt mellem alle instanser

**Forventet Output:**
```
3
5
```

---

### Opgave 6.9: Static method operating on instances
**Opgave:** 
1. Opret et StudentRegistry array med 4 studerende (forskellige grades)
2. Kald static method StudentRegistry.calculateAverageGrade()
3. Print gennemsnittet

**Forventet Output:** (eksempel)
```
7.5
```

---

### Opgave 6.10: Resetting static state
**Opgave:** 
1. Opret 5 StudentRegistry objekter
2. Print totalStudents
3. Kald StudentRegistry.resetRegistry()
4. Print totalStudents
5. Opret 2 nye StudentRegistry objekter
6. Print totalStudents

**Forventet Output:**
```
5
Registry reset. Total students: 0
0
2
```

---

## Del C: Combining Static and Instance

### Opgave 6.11: BankSystem basics
**Opgave:** 
1. Print BankSystem.getAccountCount() (før du opretter accounts)
2. Opret to BankSystem accounts med forskellige initial balances
3. Print BankSystem.getAccountCount()

**Forventet Output:**
```
0
2
```

---

### Opgave 6.12: Tracking deposits
**Opgave:** 
1. Opret en BankSystem account: "ACC001", "Anna", 1000.0
2. Deposit 500.0
3. Print BankSystem.getTotalDeposits()

**Forventet Output:**
```
Anna deposited 500.0 kr. New balance: 1500.0 kr
1500.0
```

---

### Opgave 6.13: Transaction fees
**Opgave:** 
1. Print BankSystem.getTransactionFee()
2. Opret en account med balance 1000.0
3. Withdraw 100.0
4. Display account info for at se den nye balance (100 + fee er trukket)

**Forventet Output:**
```
5.0
[holder] withdrew 100.0 kr (fee: 5.0 kr). New balance: 895.0 kr
Account: ACC001
Holder: [holder]
Balance: 895.0 kr
```

---

### Opgave 6.14: System statistics
**Opgave:** 
1. Opret tre BankSystem accounts med forskellige initial balances
2. Lav nogle deposits og withdrawals
3. Kald BankSystem.displaySystemStats()

**Forventet Output:** (eksempel)
```
=== Bank System Statistics ===
Total Accounts: 3
Total Deposits: 6500.0 kr
Total Withdrawals: 300.0 kr
Net Flow: 6200.0 kr
Transaction Fee: 5.0 kr
```

---

### Opgave 6.15: Instance vs static methods
**Opgave:** 
1. Opret en BankSystem account
2. Kald instance method: deposit()
3. Kald static method: getTotalDeposits()
4. Forklar forskellen mellem de to typer metoder

**Forventet Output:** (din forklaring + output)

---

## Del D: Advanced Static Usage

### Opgave 6.16: Static utility calculations
**Opgave:** 
Brug MathUtils til at beregne:
1. (10 + 5) * 3
2. max(factorial(4), factorial(5) / 10)
3. circleArea(10) / PI

**Forventet Output:** (eksempel)
```
45
120
100.0
```

---

### Opgave 6.17: Student analytics
**Opgave:** 
1. Opret 10 StudentRegistry objekter med forskellige grades
2. Brug static method til at beregne average grade
3. Loop gennem og count hvor mange der isPassing()
4. Print statistik

**Forventet Output:** (eksempel)
```
Average grade: 7.2
Passing students: 8
Total students: 10
```

---

### Opgave 6.18: Bank flow analysis
**Opgave:** 
1. Opret 5 BankSystem accounts
2. Simuler forskellige deposits og withdrawals
3. Kald getNetFlow() til at se om banken har positivt eller negativt flow
4. Display system stats

**Forventet Output:** (dit eget design)

---

### Opgave 6.19: Static constants in calculations
**Opgave:** 
1. Opret et array af radii: [1, 2, 3, 4, 5]
2. Loop gennem og beregn circle area for hver
3. Beregn total area af alle circles
4. Brug MathUtils.PI konstanten

**Forventet Output:** (eksempel)
```
Total area of all circles: 165.0 kr
```

---

### Opgave 6.20: Multiple resets
**Opgave:** 
1. Opret 5 StudentRegistry objekter
2. Print totalStudents
3. Reset registry
4. Opret 3 nye StudentRegistry objekter
5. Print totalStudents
6. Reset igen
7. Print totalStudents

**Forventet Output:**
```
5
Registry reset. Total students: 0
3
Registry reset. Total students: 0
0
```

---

## Del E: Collections med Static

### Opgave 6.21: ArrayList tracking
**Opgave:** 
1. Opret en ArrayList<StudentRegistry>
2. Add 7 studerende til listen
3. Print ArrayList.size() og StudentRegistry.getTotalStudents()
4. Vis at begge tæller det samme

**Forventet Output:**
```
7
7
```

---

### Opgave 6.22: Batch statistics
**Opgave:** 
1. Opret to arrays af StudentRegistry (Klasse A og Klasse B)
2. Beregn average grade for hver klasse med static method
3. Sammenlign og print hvilken klasse har højere gennemsnit

**Forventet Output:** (eksempel)
```
Class A average: 7.5
Class B average: 8.2
Class B has higher average
```

---

### Opgave 6.23: Bank account management
**Opgave:** 
1. Opret en ArrayList<BankSystem> med 6 accounts
2. Loop gennem og lav random deposits (mellem 100-1000)
3. Loop gennem og lav random withdrawals (mellem 50-500)
4. Display system stats
5. Find account med højeste balance

**Forventet Output:** (dit eget design)

---

### Opgave 6.24: Filtering med static helper
**Opgave:** 
Opret en static method i MathUtils:
```java
public static boolean[] filterEven(int[] numbers)
```
der returnerer et boolean array der viser hvilke tal er even.

Test den med et array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

**Forventet Output:** (implementer metoden først)

---

### Opgave 6.25: Complex scenario - School management
**Opgave:** 
1. Opret to ArrayList<StudentRegistry> (Class A og Class B)
2. Add 5-7 studerende til hver klasse
3. Beregn average grade for hver klasse
4. Find total students på tværs af begge klasser med static method
5. Find antal passing students i hver klasse
6. Display complete statistik

**Forventet Output:** (dit eget design med complete stats)

---

### Opgave 6.26: Bank simulation
**Opgave:** 
Simuler en banking day:
1. Opret 10 BankSystem accounts (forskellige balances)
2. Simuler 20 random transaktioner (deposits og withdrawals)
3. Print system stats efter hver 5. transaktion
4. Find account med højeste og laveste balance
5. Display final system stats

**Forventet Output:** (dit eget design)

---

### Opgave 6.27: Utility class design
**Opgave:** 
Diskuter: Hvorfor har MathUtils kun static metoder? Ville det give mening at oprette et MathUtils objekt?

Opret din egen utility class: `StringUtils` med static methods:
- `reverse(String s)` - returnerer reversed string
- `countVowels(String s)` - tæller antal vokaler
- `isPalindrome(String s)` - checker om string er palindrome

Test alle metoderne.

**Forventet Output:** (implementer klassen og metoderne selv)

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvad er forskellen mellem static og instance members?
2. Hvorfor kan static metoder ikke tilgå instance fields?
3. Hvornår ville du vælge at gøre en metode static?
4. Hvad betyder det at et static field er "delt" mellem alle instanser?
5. Hvorfor bruger vi static final for konstanter?
6. Kan du kalde en static metode på et objekt? Burde du?
