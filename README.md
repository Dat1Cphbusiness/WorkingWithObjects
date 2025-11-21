# Java Objects og Classes - Øvelsesserie

En komprehensiv guide til at lære objekter og klasser i Java gennem 7 progressive levels.

## 📋 Oversigt

Denne øvelsesserie er designet til at lære studerende om objekter og klasser i Java gennem hands-on practice. Hver level fokuserer på et specifikt koncept og bygger videre på det forrige level.

## 🎯 Læringsmål

Efter at have gennemført alle 7 levels vil du kunne:
- Oprette og arbejde med objekter
- Forstå forskellen mellem instance og static members
- Implementere getters og setters
- Bruge constructors effektivt
- Anvende `this` keywordet og method chaining
- Override Object class metoder (toString, equals)
- Arbejde med objekter i collections (ArrayList og arrays)

## 📚 Level Progression

### Level 1: Objekter og Instance Metoder
**Fokus:** Grundlæggende object creation og instance metoder

**Koncepter:**
- Oprette objekter med `new` keyword
- Kalde instance metoder på objekter
- Forstå at hvert objekt har sin egen state
- Arbejde med flere objekter samtidig

**Klasser:** Car, Dog, BankAccount

**[Se Level 1 opgaver →](level1.md)**

---

### Level 2: Instance Fields (Getters) og Collections
**Fokus:** Læse objekters tilstand og gemme objekter i collections

**Koncepter:**
- Getter-metoder for at tilgå private fields
- ArrayList til at gemme objekter
- Arrays til at gemme objekter
- Iterere gennem collections
- Filtrere og søge i collections

**Klasser:** Student, Product, Book

**[Se Level 2 opgaver →](level2.md)**

---

### Level 3: Instance Fields (Setters) og State Mutation
**Fokus:** Ændre objekters tilstand efter de er oprettet

**Koncepter:**
- Setter-metoder for at modificere private fields
- Mutability - objekter der kan ændres
- Opdatere objekter i collections
- Helper methods der ændrer state
- Constructor vs. setter initialization

**Klasser:** Employee, GameCharacter, ShoppingCart

**[Se Level 3 opgaver →](level3.md)**

---

### Level 4: Constructors
**Fokus:** Initialisere objekter ved oprettelse

**Koncepter:**
- Constructor syntax og purpose
- Constructor overloading (flere constructors)
- Default constructor vs. parameterized constructors
- Constructor med validering og logic
- Vælge den rigtige constructor

**Klasser:** Rectangle, Person, BankAccount2

**[Se Level 4 opgaver →](level4.md)**

---

### Level 5: The `this` Keyword
**Fokus:** Reference til det nuværende objekt

**Koncepter:**
- `this` til at skelne mellem parameters og fields
- Returnere `this` for method chaining
- Builder pattern
- Method chaining for læsbarhed
- Hvornår `this` er nødvendigt

**Klasser:** Counter, Builder, Calculator2

**[Se Level 5 opgaver →](level5.md)**

---

### Level 6: Static Methods og Fields
**Fokus:** Class-level members der ikke tilhører specifikke objekter

**Koncepter:**
- Static vs. instance members
- Kalde static metoder uden objekter
- Static fields som shared state
- Static constants (final static)
- Utility classes
- Hvornår static er passende

**Klasser:** MathUtils, StudentRegistry, BankSystem

**[Se Level 6 opgaver →](level6.md)**

---

### Level 7: Object Class Methods (toString og equals)
**Fokus:** Override metoder fra Object klassen

**Koncepter:**
- Override `toString()` for læsbar output
- Override `equals()` for logical equality
- Forskellen mellem `==` og `.equals()`
- @Override annotation
- Standard equals() pattern
- Brug af toString og equals i collections

**Klasser:** Point, Book2, Person2

**[Se Level 7 opgaver →](level7.md)**

---

## 🚀 Kom i Gang

### 1. Download alle filer
Download alle `.java` filer og `.md` instruktionsfiler til dit projekt.

### 2. Åbn Main.java
`Main.java` indeholder 7 test metoder - én for hvert level.

### 3. Start med Level 1
```java
public static void main(String[] args) {
    testLevel1();  // Aktiv
    //testLevel2();  // Kommenteret ud
    //testLevel3();
    // osv...
}
```

### 4. Skriv din kode
Åbn `level1.md` og læs opgaverne. Skriv din kode i `testLevel1()` metoden.

### 5. Gå videre til næste level
Når du er færdig med Level 1, kommentér `testLevel1()` ud og fjern kommentaren fra `testLevel2()`.

## 📁 Filstruktur

```
objects-complete/
├── Main.java                    # Main class med alle testLevel metoder
├── README.md                    # Denne fil
│
├── level1.md                    # Level 1 instruktioner
├── Car.java                     # Level 1 klasser
├── Dog.java
├── BankAccount.java
│
├── level2.md                    # Level 2 instruktioner
├── Student.java                 # Level 2 klasser
├── Product.java
├── Book.java
│
├── level3.md                    # Level 3 instruktioner
├── Employee.java                # Level 3 klasser
├── GameCharacter.java
├── ShoppingCart.java
│
├── level4.md                    # Level 4 instruktioner
├── Rectangle.java               # Level 4 klasser
├── Person.java
├── BankAccount2.java
│
├── level5.md                    # Level 5 instruktioner
├── Counter.java                 # Level 5 klasser
├── Builder.java
├── Calculator2.java
│
├── level6.md                    # Level 6 instruktioner
├── MathUtils.java               # Level 6 klasser
├── StudentRegistry.java
├── BankSystem.java
│
├── level7.md                    # Level 7 instruktioner
├── Point.java                   # Level 7 klasser
├── Book2.java
└── Person2.java
```

## 💡 Tips til Studerende

### Generelle Tips
- Læs instrukserne grundigt før du begynder
- Kør din kode ofte for at teste
- Brug System.out.println() til debugging
- Sammenlign dit output med forventet output
- Hvis du sidder fast, genlæs "Tips" sektionen i level-filen

### Debugging Tips
- Print objekter direkte (toString() kaldes automatisk)
- Print field values med getters
- Test én metode ad gangen
- Start simpelt, byg derefter kompleksitet

### Best Practices
- Giv dine variabler meningsfulde navne
- Følg Java naming conventions (camelCase for variabler)
- Kommenter kompleks kode
- Refactor når noget bliver for langt eller kompliceret

## 🎓 Pædagogisk Tilgang

Denne serie bruger en scaffolded approach:

1. **Gradvis Kompleksitet:** Hver level introducerer ét nyt koncept
2. **Hands-On Practice:** Du skriver al koden selv
3. **Discover Learning:** Opgaverne opfordrer til eksperimentering
4. **Real-World Examples:** Klasser baseret på realistiske scenarios
5. **Progressive Challenges:** Fra simple til komplekse opgaver

## 📊 Progression Matrix

| Level | Objekter | Getters | Setters | Constructors | this | Static | Override |
|-------|----------|---------|---------|--------------|------|--------|----------|
| 1     | ✓        |         |         | Basic        |      |        |          |
| 2     | ✓        | ✓       |         | Basic        |      |        |          |
| 3     | ✓        | ✓       | ✓       | Basic        |      |        |          |
| 4     | ✓        | ✓       | ✓       | ✓            |      |        |          |
| 5     | ✓        | ✓       | ✓       | ✓            | ✓    |        |          |
| 6     | ✓        | ✓       | ✓       | ✓            | ✓    | ✓      |          |
| 7     | ✓        | ✓       | ✓       | ✓            | ✓    | ✓      | ✓        |

## 🔍 Refleksionsspørgsmål

Efter hvert level findes der refleksionsspørgsmål. Disse er designet til at:
- Forstærke læring
- Opfordre til critical thinking
- Forbinde koncepter på tværs af levels
- Forberede dig til at bruge koncepterne i dine egne projekter

## 📖 Yderligere Ressourcer

### Dokumentation
- [Official Java Documentation](https://docs.oracle.com/en/java/)
- [Java Tutorials - Oracle](https://docs.oracle.com/javase/tutorial/)

### Koncepter at Udforske Videre
Efter Level 7 er du klar til:
- Inheritance (nedarvning)
- Interfaces
- Abstract classes
- Polymorphism
- Encapsulation patterns
- Design patterns (Factory, Singleton, etc.)

## ✅ Checkliste

Brug denne checkliste til at tracke din progression:

- [ ] Level 1: Objekter og Instance Metoder
- [ ] Level 2: Instance Fields (Getters) og Collections
- [ ] Level 3: Instance Fields (Setters) og State Mutation
- [ ] Level 4: Constructors
- [ ] Level 5: The `this` Keyword
- [ ] Level 6: Static Methods og Fields
- [ ] Level 7: Object Class Methods (toString og equals)

## 🎯 Hvad Nu?

Når du har gennemført alle 7 levels:

1. **Review:** Genlæs refleksionsspørgsmålene
2. **Practice:** Lav dine egne klasser med disse koncepter
3. **Build:** Opret et lille projekt der bruger alt hvad du har lært
4. **Share:** Diskuter koncepterne med andre studerende

## 📝 Feedback

Har du feedback til disse øvelser? Del dine tanker med din instruktør!

---

**God fornøjelse med at lære Java Objects og Classes! 🚀**
