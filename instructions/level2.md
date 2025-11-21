# Level 2: Instance Fields (Getters) og Collections

## Level 2 fokuserer på:
- Læse objekters tilstand gennem getter-metoder
- Forstå forskellen mellem private fields og public getters
- Sammenligne værdier på tværs af flere objekter
- Gemme objekter i ArrayList
- Gemme objekter i arrays
- Iterere gennem collections og tilgå objekters data
- Finde specifikke objekter i collections baseret på deres tilstand

---

## Begrebsgennemgang

### Getters
En **getter-metode** giver dig adgang til et objekts private field. I stedet for at tilgå feltet direkte (hvilket ikke er muligt når det er `private`), kalder du en metode:

```java
Student student = new Student("Anna", 20, 7.5, "S12345");
String name = student.getName();  // Returnerer "Anna"
int age = student.getAge();       // Returnerer 20
```

### ArrayList
En **ArrayList** kan indeholde mange objekter af samme type:

```java
ArrayList<Student> students = new ArrayList<>();
students.add(student1);
students.add(student2);
students.add(student3);

// Få et objekt ud
Student first = students.get(0);

// Antal objekter
int count = students.size();

// Loop gennem alle
for (Student s : students) {
    System.out.println(s.getName());
}
```

### Array
Et **array** er en fast-størrelse samling af objekter:

```java
Student[] students = new Student[3];
students[0] = student1;
students[1] = student2;
students[2] = student3;

// Få et objekt ud
Student first = students[0];

// Antal objekter
int count = students.length;

// Loop gennem alle
for (Student s : students) {
    System.out.println(s.getName());
}
```

**Tag udgangspunkt i klasserne Student, Product, og Book.**  
**Skriv din kode i Main.java i testLevel2() metoden.**

---

## Tips
- Getter-metoder starter typisk med `get` efterfulgt af field-navnet: `getName()`, `getAge()`
- Boolean getters starter ofte med `is`: `isAvailable()`, `isPassing()`
- Du skal importere ArrayList: `import java.util.ArrayList;`
- ArrayList bruger `add()`, `get()`, og `size()`
- Arrays bruger `[]` notation og har `.length` (ikke en metode)
- Husk: ArrayList starter fra index 0, ligesom arrays
- Du kan sammenligne værdier fra getters: `if (student1.getGrade() > student2.getGrade())`
- Al din kode skal placeres inde i `testLevel2()` metoden mellem tuborgklammerne `{}`

---

## Del A: Getters og Object State

### Opgave 2.1: Læs et objekts tilstand
**Opgave:** 
1. Opret en Student: "Emma", alder 22, grade 8.5, ID "S001"
2. Print studentens navn ved hjælp af `getName()`
3. Print studentens alder ved hjælp af `getAge()`
4. Print studentens grade ved hjælp af `getGrade()`

**Forventet Output:**
```
Emma
22
8.5
```

---

### Opgave 2.2: Brug getter-værdier i beregninger
**Opgave:** 
1. Opret to Student objekter med forskellige grades
2. Beregn gennemsnittet af deres grades ved hjælp af getters
3. Print gennemsnittet

**Forventet Output:** (eksempel)
```
7.5
```

---

### Opgave 2.3: Sammenlign objekter
**Opgave:** 
1. Opret to Student objekter
2. Find ud af hvem der er ældst ved hjælp af `getAge()`
3. Print navnet på den ældste student

**Forventet Output:** (eksempel)
```
The oldest student is: Lars
```

---

### Opgave 2.4: Boolean getters
**Opgave:** 
1. Opret en Student med grade 10.0
2. Opret en Student med grade 0.5
3. Brug `isPassing()` til at tjekke om hver student består
4. Print resultatet

**Forventet Output:**
```
true
false
```

---

### Opgave 2.5: Product information
**Opgave:** 
1. Opret et Product: "Laptop", pris 5000.0, stock 10, category "Electronics"
2. Print produktets navn, pris, og stock ved hjælp af getters
3. Print den totale værdi ved hjælp af `getTotalValue()`

**Forventet Output:**
```
Laptop
5000.0
10
50000.0
```

---

### Opgave 2.6: Stock status
**Opgave:** 
1. Opret tre Product objekter med forskellige stock-niveauer: 0, 3, og 20
2. For hver produkt, brug `isInStock()` og `isLowStock()` til at printe status

**Forventet Output:** (eksempel)
```
Mouse: In stock: false, Low stock: false
Keyboard: In stock: true, Low stock: true
Monitor: In stock: true, Low stock: false
```

---

### Opgave 2.7: Book details
**Opgave:** 
1. Opret en Book: "1984", "George Orwell", 328 sider
2. Print title og author ved hjælp af getters
3. Brug `isLongBook()` til at tjekke om det er en lang bog
4. Borrow bogen
5. Brug `isAvailable()` til at tjekke om den er tilgængelig

**Forventet Output:**
```
1984
George Orwell
true
You borrowed: 1984
false
```

---

## Del B: ArrayList Collections

### Opgave 2.8: Opret og fyld en ArrayList
**Opgave:** 
1. Opret en `ArrayList<Student>` kaldet `students`
2. Opret tre Student objekter
3. Tilføj alle tre til ArrayList
4. Print antallet af studerende ved hjælp af `size()`

**Forventet Output:**
```
3
```

---

### Opgave 2.9: Tilgå elementer i ArrayList
**Opgave:** 
1. Opret en ArrayList med tre Student objekter
2. Få den første student ved hjælp af `get(0)`
3. Print den første students navn

**Forventet Output:** (eksempel)
```
Anna
```

---

### Opgave 2.10: Loop gennem ArrayList
**Opgave:** 
1. Opret en ArrayList med fire Student objekter
2. Brug en for-each loop til at printe alle studenters navne

**Forventet Output:** (eksempel)
```
Anna
Peter
Maria
Lars
```

---

### Opgave 2.11: Find gennemsnit i ArrayList
**Opgave:** 
1. Opret en ArrayList med fem Student objekter med forskellige grades
2. Loop gennem og beregn gennemsnittet af alle grades
3. Print gennemsnittet

**Forventet Output:** (eksempel)
```
Average grade: 7.8
```

---

### Opgave 2.12: Find bedste student
**Opgave:** 
1. Opret en ArrayList med flere Student objekter
2. Loop gennem og find studenten med den højeste grade
3. Print denne students navn og grade

**Forventet Output:** (eksempel)
```
Best student: Emma with grade 10.5
```

---

### Opgave 2.13: Filtrer studerende
**Opgave:** 
1. Opret en ArrayList med flere Student objekter (nogle passing, nogle failing)
2. Loop gennem og print kun navnene på studerende der består (`isPassing()` returnerer true)

**Forventet Output:** (eksempel)
```
Passing students:
Anna
Peter
Lars
```

---

### Opgave 2.14: Product inventory
**Opgave:** 
1. Opret en `ArrayList<Product>` med fem produkter
2. Loop gennem og print navnet på alle produkter der er low stock
3. Beregn den totale værdi af hele inventory

**Forventet Output:** (eksempel)
```
Low stock products:
Keyboard
Mouse
Total inventory value: 45000.0 kr
```

---

## Del C: Array Collections

### Opgave 2.15: Opret og fyld et array
**Opgave:** 
1. Opret et `Student[]` array med plads til 3 studerende
2. Opret tre Student objekter og placer dem i arrayet
3. Print længden af arrayet

**Forventet Output:**
```
3
```

---

### Opgave 2.16: Tilgå array elementer
**Opgave:** 
1. Opret et array med tre Student objekter
2. Print navnet på den første og sidste student i arrayet

**Forventet Output:** (eksempel)
```
First: Anna
Last: Peter
```

---

### Opgave 2.17: Loop gennem array
**Opgave:** 
1. Opret et Book array med fire bøger
2. Loop gennem arrayet og print hver bogs title og author

**Forventet Output:** (eksempel)
```
1984 by George Orwell
To Kill a Mockingbird by Harper Lee
The Great Gatsby by F. Scott Fitzgerald
Pride and Prejudice by Jane Austen
```

---

### Opgave 2.18: Find i array
**Opgave:** 
1. Opret et Product array med flere produkter
2. Loop gennem og find det dyreste produkt
3. Print navnet og prisen på dette produkt

**Forventet Output:** (eksempel)
```
Most expensive: Laptop at 8000.0 kr
```

---

### Opgave 2.19: Sammenlign ArrayList og Array
**Opgave:** 
1. Opret en ArrayList med tre studerende
2. Opret et array med tre studerende
3. Beregn gennemsnitsgraden for begge collections
4. Print begge gennemsnit

**Forventet Output:** (eksempel)
```
ArrayList average: 7.5
Array average: 8.2
```

---

### Opgave 2.20: Library system
**Opgave:** 
1. Opret en `ArrayList<Book>` med mindst 5 bøger
2. Borrow 2-3 af bøgerne
3. Loop gennem og print alle tilgængelige bøgers titler
4. Tæl hvor mange bøger der er tilgængelige

**Forventet Output:** (eksempel)
```
Available books:
The Great Gatsby
Pride and Prejudice
Moby Dick
Number of available books: 3
```

---

### Opgave 2.21: Complex filtering
**Opgave:** 
1. Opret en ArrayList med mange Student objekter
2. Find alle studerende der:
   - Er over 20 år
   - Har en grade over 7.0
3. Print deres navne

**Forventet Output:** (eksempel)
```
Qualified students:
Lars
Sofie
Thomas
```

---

### Opgave 2.22: Product categories
**Opgave:** 
1. Opret en ArrayList med produkter fra forskellige kategorier
2. Loop gennem og print alle produkter fra en specifik kategori (f.eks. "Electronics")
3. Beregn total værdi af produkter i denne kategori

**Forventet Output:** (eksempel)
```
Electronics products:
Laptop
Mouse
Keyboard
Total value: 7500.0 kr
```

---

### Opgave 2.23: Student statistics
**Opgave:** 
Opret en ArrayList med mindst 8 studerende og beregn:
1. Gennemsnitsalder
2. Gennemsnitsgrade
3. Antal studerende der består
4. Antal studerende der ikke består

**Forventet Output:** (eksempel)
```
Average age: 22.5
Average grade: 7.2
Passing: 6
Failing: 2
```

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvad er forskellen mellem at tilgå et field direkte vs. gennem en getter?
2. Hvornår ville du vælge ArrayList over array?
3. Hvad sker der hvis du prøver at tilgå index 5 i en ArrayList med kun 3 elementer?
4. Hvorfor er det nyttigt at kunne loop gennem en collection af objekter?
