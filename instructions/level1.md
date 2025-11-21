# Level 1: Objekter og Instance Metoder

## Level 1 fokuserer på:
- Oprette objekter ved hjælp af `new` keyword og konstruktører
- Kalde instance metoder på objekter
- Forstå at hvert objekt har sin egen tilstand (state)
- Forstå at flere objekter af samme klasse opfører sig uafhængigt
- Arbejde med flere objekter samtidig

---

## Begrebsgennemgang
Et **objekt** er en instans af en klasse. Klassen er "skabelonen", mens objektet er den konkrete "ting" du arbejder med. 

For at oprette et objekt bruger du `new` keywordet:
```java
Car myCar = new Car("Toyota", "red");
```

Når du har et objekt, kan du kalde dets **instance metoder** ved at bruge punktum-notation:
```java
myCar.start();      // Kalder start() metoden på myCar objektet
myCar.accelerate(); // Kalder accelerate() metoden på myCar objektet
```

Hvert objekt har sin egen **tilstand** (state). Hvis du opretter to Car objekter, har de hver deres egen hastighed, farve osv.

**Tag udgangspunkt i klasserne Car, Dog, og BankAccount.**  
**Skriv din kode i Main.java i testLevel1() metoden.**

---

## Tips
- Du opretter et objekt med: `KlasseNavn variabelNavn = new KlasseNavn(argumenter);`
- Du kalder en metode på et objekt med: `variabelNavn.metodeNavn();`
- Hvert objekt har sin egen tilstand - ændringer på ét objekt påvirker ikke andre objekter
- Du kan oprette så mange objekter af samme klasse som du vil
- Glem ikke at objekter skal oprettes før du kan kalde metoder på dem
- Al din kode skal placeres inde i `testLevel1()` metoden mellem tuborgklammerne `{}`

---

## Opgaver

### Opgave 1.1: Opret dit første objekt
**Opgave:** 
1. Opret et Car objekt med brand "Tesla" og farve "blue"
2. Gem det i en variabel kaldet `myCar`
3. Kald `start()` metoden på `myCar`

**Forventet Output:**
```
The blue Tesla is starting...
```

---

### Opgave 1.2: Kald flere metoder på samme objekt
**Opgave:** 
1. Opret et Car objekt med brand "BMW" og farve "black"
2. Kald `start()`
3. Kald `accelerate()` tre gange
4. Kald `honk()`

**Forventet Output:**
```
The black BMW is starting...
BMW is accelerating. Speed: 10 km/h
BMW is accelerating. Speed: 20 km/h
BMW is accelerating. Speed: 30 km/h
BMW says: BEEP BEEP!
```

---

### Opgave 1.3: To objekter af samme klasse
**Opgave:** 
1. Opret et Car objekt: brand "Toyota", farve "red", gem i variabel `car1`
2. Opret et Car objekt: brand "Honda", farve "white", gem i variabel `car2`
3. Kald `start()` på begge biler
4. Kald `accelerate()` på `car1` to gange
5. Kald `accelerate()` på `car2` én gang
6. Kald `displayInfo()` på begge biler

**Forventet Output:**
```
The red Toyota is starting...
The white Honda is starting...
Toyota is accelerating. Speed: 10 km/h
Toyota is accelerating. Speed: 20 km/h
Honda is accelerating. Speed: 10 km/h
Car: Toyota, Color: red, Speed: 20 km/h
Car: Honda, Color: white, Speed: 10 km/h
```

---

### Opgave 1.4: Objekter har uafhængig tilstand
**Opgave:** 
1. Opret to Dog objekter: "Max" (Golden Retriever) og "Bella" (Poodle)
2. Lad Max play() to gange
3. Lad Bella play() én gang
4. Vis status for begge hunde med `showStatus()`

**Forventet Output:**
```
Max is playing! Energy: 80
Max is playing! Energy: 60
Bella is playing! Energy: 80
Max the Golden Retriever - Energy: 60
Bella the Poodle - Energy: 80
```

---

### Opgave 1.5: Arbejde med forskellige klasser
**Opgave:** 
1. Opret en Dog: "Fido" (Labrador)
2. Opret en Car: "Volvo", "silver"
3. Lad Fido bark()
4. Lad bilen honk()
5. Lad Fido play()
6. Lad bilen accelerate()

**Forventet Output:**
```
Fido says: Woof woof!
Volvo says: BEEP BEEP!
Fido is playing! Energy: 80
Volvo is accelerating. Speed: 10 km/h
```

---

### Opgave 1.6: Gendan tilstand
**Opgave:** 
1. Opret en Dog: "Rex" (German Shepherd)
2. Lad Rex play() tre gange
3. Vis Rex's status
4. Lad Rex sleep()
5. Vis Rex's status igen

**Forventet Output:**
```
Rex is playing! Energy: 80
Rex is playing! Energy: 60
Rex is playing! Energy: 40
Rex the German Shepherd - Energy: 40
Rex is sleeping... Zzz... Energy restored to 100
Rex the German Shepherd - Energy: 100
```

---

### Opgave 1.7: BankAccount objekter
**Opgave:** 
1. Opret en BankAccount: "Anna" med initial balance 1000.0
2. Deposit 500.0
3. Withdraw 200.0
4. Vis balance

**Forventet Output:**
```
Deposited 500.0 kr. New balance: 1500.0 kr.
Withdrew 200.0 kr. New balance: 1300.0 kr.
Anna's balance: 1300.0 kr.
```

---

### Opgave 1.8: Flere bank accounts
**Opgave:** 
1. Opret to BankAccount objekter: "Peter" (2000.0) og "Maria" (1500.0)
2. Peter depositer 300.0
3. Maria withdraw 500.0
4. Vis balance for begge

**Forventet Output:**
```
Deposited 300.0 kr. New balance: 2300.0 kr.
Withdrew 500.0 kr. New balance: 1000.0 kr.
Peter's balance: 2300.0 kr.
Maria's balance: 1000.0 kr.
```

---

### Opgave 1.9: Transfer mellem accounts
**Opgave:** 
1. Opret to BankAccount objekter: "Lars" (3000.0) og "Sofie" (500.0)
2. Lars transferer 1000.0 til Sofie
3. Vis balance for begge

**Forventet Output:**
```
Transferred 1000.0 kr to Sofie
Lars's balance: 2000.0 kr.
Sofie's balance: 1500.0 kr.
```

---

### Opgave 1.10: Insufficient funds
**Opgave:** 
1. Opret en BankAccount: "Thomas" (100.0)
2. Prøv at withdraw 200.0
3. Vis balance

**Forventet Output:**
```
Insufficient funds! Balance: 100.0 kr.
Thomas's balance: 100.0 kr.
```

---

### Opgave 1.11: En kompleks sekvens
**Opgave:** 
1. Opret en Car: "Audi", "grey"
2. Start bilen
3. Accelerate fire gange
4. Brake to gange
5. Honk
6. Display info

**Forventet Output:**
```
The grey Audi is starting...
Audi is accelerating. Speed: 10 km/h
Audi is accelerating. Speed: 20 km/h
Audi is accelerating. Speed: 30 km/h
Audi is accelerating. Speed: 40 km/h
Audi is braking. Speed: 30 km/h
Audi is braking. Speed: 20 km/h
Audi says: BEEP BEEP!
Car: Audi, Color: grey, Speed: 20 km/h
```

---

### Opgave 1.12: Tre hunde leger
**Opgave:** 
Opret tre Dog objekter med forskellige navne og racer. Lad dem alle:
1. Barke
2. Lege én gang
3. Vise deres status

**Forventet Output:** (eksempel)
```
Buddy says: Woof woof!
Luna says: Woof woof!
Charlie says: Woof woof!
Buddy is playing! Energy: 80
Luna is playing! Energy: 80
Charlie is playing! Energy: 80
Buddy the Beagle - Energy: 80
Luna the Husky - Energy: 80
Charlie the Bulldog - Energy: 80
```

---

### Opgave 1.13: Komplet bank scenario
**Opgave:** 
1. Opret tre BankAccount objekter med forskellige navne og balancer
2. Lav mindst tre transaktioner (deposit, withdraw, eller transfer)
3. Vis alle tre balances til sidst

**Forventet Output:** (dit eget design)

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvad sker der hvis du kalder en metode på et objekt der ikke findes? (Prøv det!)
2. Kan to objekter have samme navn? Hvorfor/hvorfor ikke?
3. Hvad betyder det at objekter har "uafhængig tilstand"?
