# Level 7: Object Class Methods (toString og equals)

## Level 7 fokuserer på:
- Forstå at alle klasser arver fra Object klassen
- Override toString() for at få læsbar String-repræsentation af objekter
- Override equals() for at sammenligne objekter baseret på deres indhold
- Forstå forskellen mellem == og .equals()
- == sammenligner memory addresses (reference equality)
- .equals() sammenligner indhold (logical equality)
- Hvornår og hvordan man skal override disse metoder
- Best practices for toString() og equals()

---

## Begrebsgennemgang

### Object Klassen
Alle klasser i Java arver automatisk fra `Object` klassen. Object klassen har flere metoder som `toString()` og `equals()` som vi kan **override** (overskrive) for at give vores egne implementeringer.

### toString() Method
Når du printer et objekt, kaldes `toString()` automatisk:

```java
Point p = new Point(3, 4);
System.out.println(p);  // Kalder automatisk p.toString()
```

**Uden override:**
```
Point@15db9742  // Memory address - ikke særlig nyttigt!
```

**Med override:**
```java
@Override
public String toString() {
    return "Point(" + x + ", " + y + ")";
}
// Output: Point(3, 4)  // Meget bedre!
```

### equals() Method
Default `equals()` metode sammenligner memory addresses (samme som ==):

```java
Point p1 = new Point(3, 4);
Point p2 = new Point(3, 4);

System.out.println(p1 == p2);        // false - forskellige objekter i memory
System.out.println(p1.equals(p2));   // false - uden override, samme som ==
```

**Med override baseret på indhold:**
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Point other = (Point) obj;
    return this.x == other.x && this.y == other.y;
}

// Nu:
System.out.println(p1.equals(p2));   // true - samme x og y værdier!
```

### == vs .equals()
- **==** sammenligner references (er det samme objekt i memory?)
- **.equals()** sammenligner indhold (har de samme værdier?)

```java
Point p1 = new Point(3, 4);
Point p2 = new Point(3, 4);
Point p3 = p1;  // p3 peger på samme objekt som p1

System.out.println(p1 == p2);      // false - forskellige objekter
System.out.println(p1.equals(p2)); // true - samme værdier (hvis equals() er overridden)
System.out.println(p1 == p3);      // true - samme objekt
System.out.println(p1.equals(p3)); // true - samme objekt (og værdier)
```

### @Override Annotation
`@Override` fortæller compileren at du override en metode fra superclass. Det hjælper med at fange fejl:

```java
@Override
public String tostring() {  // FEJL! Compiler fanger at det skal være toString (med stort S)
    return "Point";
}
```

### equals() Standard Pattern
God praksis for equals():
```java
@Override
public boolean equals(Object obj) {
    // 1. Check if same object
    if (this == obj) return true;
    
    // 2. Check if null or different class
    if (obj == null || getClass() != obj.getClass()) return false;
    
    // 3. Cast and compare fields
    MyClass other = (MyClass) obj;
    return this.field1.equals(other.field1) && this.field2 == other.field2;
}
```

**Tag udgangspunkt i klasserne Point, Book2, og Person2.**  
**Skriv din kode i Main.java i testLevel7() metoden.**

---

## Tips
- toString() skal returnere en String der beskriver objektet
- Brug toString() til debugging og til at vise objekter til brugere
- equals() skal sammenligne det vigtigste indhold (ikke nødvendigvis alle fields)
- Husk @Override annotation
- == sammenligner references, .equals() sammenligner indhold
- equals() skal være symmetrisk: if a.equals(b) then b.equals(a)
- equals() skal håndtere null: obj.equals(null) skal returnere false
- Al din kode skal placeres inde i `testLevel7()` metoden mellem tuborgklammerne `{}`

---

## Del A: toString() Basics

### Opgave 7.1: Default toString() problem
**Opgave:** 
1. Opret en Point: (5, 10)
2. Print point objektet direkte med System.out.println()
3. Bemærk at toString() automatisk kaldes

**Forventet Output:**
```
Point(5, 10)
```

---

### Opgave 7.2: toString() i String concatenation
**Opgave:** 
1. Opret en Point: (3, 7)
2. Print: "The point is: " + point

**Forventet Output:**
```
The point is: Point(3, 7)
```

---

### Opgave 7.3: toString() med forskellige objekter
**Opgave:** 
1. Opret tre Point objekter med forskellige koordinater
2. Print alle tre

**Forventet Output:** (eksempel)
```
Point(1, 2)
Point(5, 8)
Point(-3, 4)
```

---

### Opgave 7.4: Book2 toString()
**Opgave:** 
1. Opret en Book2: "1984", "George Orwell", "978-0451524935", 1949
2. Print bogen

**Forventet Output:**
```
"1984" by George Orwell (1949) [ISBN: 978-0451524935]
```

---

### Opgave 7.5: Person2 toString()
**Opgave:** 
1. Opret en Person2: "Anna", "Jensen", 25, "anna@email.com"
2. Print personen
3. Print person.toStringFormal()
4. Print person.toStringShort()

**Forventet Output:**
```
Anna Jensen (age 25, anna@email.com)
Jensen, Anna
Anna J.
```

---

## Del B: equals() Basics

### Opgave 7.6: == vs equals() demonstration
**Opgave:** 
1. Opret Point p1: (5, 5)
2. Opret Point p2: (5, 5)
3. Opret Point p3 = p1
4. Print p1 == p2
5. Print p1.equals(p2)
6. Print p1 == p3
7. Print p1.equals(p3)

**Forventet Output:**
```
false
true
true
true
```

---

### Opgave 7.7: equals() med forskellige værdier
**Opgave:** 
1. Opret Point p1: (3, 4)
2. Opret Point p2: (3, 4)
3. Opret Point p3: (3, 5)
4. Print p1.equals(p2)
5. Print p1.equals(p3)

**Forventet Output:**
```
true
false
```

---

### Opgave 7.8: Book2 equals() baseret på ISBN
**Opgave:** 
1. Opret Book2 b1: "1984", "George Orwell", "978-0451524935", 1949
2. Opret Book2 b2: "Nineteen Eighty-Four", "G. Orwell", "978-0451524935", 1950
3. Print b1.equals(b2) (de har samme ISBN, så equals returnerer true)

**Forventet Output:**
```
true
```

---

### Opgave 7.9: equals() symmetry
**Opgave:** 
1. Opret Person2 p1: "Anna", "Jensen", 25, "anna@email.com"
2. Opret Person2 p2: "Anna", "Jensen", 25, "anna@email.com"
3. Print p1.equals(p2)
4. Print p2.equals(p1)
5. Vis at equals er symmetrisk

**Forventet Output:**
```
true
true
```

---

### Opgave 7.10: equals() med null
**Opgave:** 
1. Opret en Point: (5, 5)
2. Print point.equals(null)

**Forventet Output:**
```
false
```

---

## Del C: Practical Usage

### Opgave 7.11: Find i collection med equals()
**Opgave:** 
1. Opret en ArrayList<Point> med 5 punkter
2. Opret et "search" point: (3, 7)
3. Loop gennem listen og find punktet der equals search point
4. Print "Found!" hvis fundet

**Forventet Output:**
```
Found!
```

---

### Opgave 7.12: Remove duplicates
**Opgave:** 
1. Opret en ArrayList<Point> med 8 punkter (nogle duplicates)
2. Loop gennem og fjern duplicates ved hjælp af equals()
3. Print alle remaining punkter

**Forventet Output:** (eksempel)
```
Point(1, 2)
Point(3, 4)
Point(5, 6)
Point(7, 8)
```

---

### Opgave 7.13: Book collection search
**Opgave:** 
1. Opret en ArrayList<Book2> med 5 bøger
2. Search efter en bog ved ISBN
3. Print den fundne bog

**Forventet Output:** (eksempel)
```
Found: "1984" by George Orwell (1949) [ISBN: 978-0451524935]
```

---

### Opgave 7.14: Count occurrences
**Opgave:** 
1. Opret en ArrayList<Point> med 10 punkter
2. Count hvor mange gange Point(5, 5) forekommer
3. Print count

**Forventet Output:** (eksempel)
```
Point(5, 5) occurs 3 times
```

---

### Opgave 7.15: Compare persons
**Opgave:** 
1. Opret to Person2 objekter med samme navn men forskellige ages
2. Print p1.equals(p2) (false - age er forskellig)
3. Print p1.hasSameNameAs(p2) (true - custom method)

**Forventet Output:**
```
false
true
```

---

## Del D: toString() Advanced

### Opgave 7.16: toString() i loops
**Opgave:** 
1. Opret en ArrayList<Point> med 5 punkter
2. Loop gennem og print alle (toString() kaldes automatisk)

**Forventet Output:** (eksempel)
```
Point(1, 2)
Point(3, 4)
Point(5, 6)
Point(7, 8)
Point(9, 10)
```

---

### Opgave 7.17: Formatted output
**Opgave:** 
1. Opret en ArrayList<Book2> med 4 bøger
2. Print en formateret liste:
```
Library Books:
1. [book toString]
2. [book toString]
...
```

**Forventet Output:** (eksempel)
```
Library Books:
1. "1984" by George Orwell (1949) [ISBN: 978-0451524935]
2. "To Kill a Mockingbird" by Harper Lee (1960) [ISBN: 978-0061120084]
...
```

---

### Opgave 7.18: toString() for debugging
**Opgave:** 
1. Opret flere Point objekter med forskellige værdier
2. Brug toString() til at debug og verificere koordinater
3. Sammenlign med at bruge separate getX() og getY() calls

**Forventet Output:** (din observation om forskellen)

---

### Opgave 7.19: Custom toString formats
**Opgave:** 
1. Opret 3 Person2 objekter
2. Print hver person med alle tre formats:
   - Normal toString()
   - toStringFormal()
   - toStringShort()

**Forventet Output:** (eksempel)
```
Anna Jensen (age 25, anna@email.com)
Jensen, Anna
Anna J.

Peter Nielsen (age 30, peter@email.com)
Nielsen, Peter
Peter N.
...
```

---

### Opgave 7.20: toString() in concatenation
**Opgave:** 
1. Opret en Point: (10, 20)
2. Opret en String message: "Starting at " + point + " and moving to " + new Point(30, 40)

**Forventet Output:**
```
Starting at Point(10, 20) and moving to Point(30, 40)
```

---

## Del E: equals() Advanced

### Opgave 7.21: Complex equality check
**Opgave:** 
1. Opret to Book2 objekter med samme ISBN men forskellige titler
2. Vis at equals() returnerer true (baseret på ISBN)
3. Brug isSameEdition() til at vise de ikke er samme edition

**Forventet Output:**
```
Same book (ISBN): true
Same edition: false
```

---

### Opgave 7.22: ArrayList contains() bruger equals()
**Opgave:** 
1. Opret en ArrayList<Point> med flere punkter
2. Brug contains() method til at check om Point(5, 5) er i listen
3. contains() bruger equals() internt!

**Forventet Output:**
```
true
```
eller
```
false
```

---

### Opgave 7.23: Remove med equals()
**Opgave:** 
1. Opret en ArrayList<Point> med 6 punkter
2. Print listen
3. Brug remove() til at fjerne Point(3, 4)
4. Print listen igen
5. remove() bruger equals() til at finde objektet!

**Forventet Output:** (eksempel)
```
Before: [Point(1, 2), Point(3, 4), Point(5, 6), ...]
After: [Point(1, 2), Point(5, 6), ...]
```

---

### Opgave 7.24: Filtering med equals()
**Opgave:** 
1. Opret en ArrayList<Person2> med 8 personer
2. Opret en "target" person
3. Loop gennem og find alle personer der equals target
4. Print alle matches

**Forventet Output:** (eksempel)
```
Found matches:
Anna Jensen (age 25, anna@email.com)
```

---

### Opgave 7.25: Equality chains
**Opgave:** 
1. Opret tre Point objekter: p1(5,5), p2(5,5), p3(5,5)
2. Verify transitivity: if p1.equals(p2) and p2.equals(p3), then p1.equals(p3)

**Forventet Output:**
```
p1.equals(p2): true
p2.equals(p3): true
p1.equals(p3): true
Transitivity verified!
```

---

## Del F: Combined Usage

### Opgave 7.26: Library system
**Opgave:** 
1. Opret en ArrayList<Book2> "library" med 6 bøger
2. Print hele library (toString())
3. Search efter en bog ved ISBN (equals())
4. Print om den findes eller ej

**Forventet Output:** (dit eget design)

---

### Opgave 7.27: Point geometry
**Opgave:** 
1. Opret en ArrayList<Point> med 8 punkter
2. Find alle punkter der er lige langt fra origin (brug distanceFromOrigin() og equals())
3. Print dem med toString()

**Forventet Output:** (dit eget design)

---

### Opgave 7.28: Contact management
**Opgave:** 
1. Opret en ArrayList<Person2> "contacts"
2. Add 10 personer (nogle duplicates)
3. Remove duplicates ved hjælp af equals()
4. Print final contact list med toString()

**Forventet Output:** (dit eget design)

---

### Opgave 7.29: Book comparison
**Opgave:** 
1. Opret to ArrayList<Book2>: "myBooks" og "friendBooks"
2. Find bøger der findes i begge lister (brug equals())
3. Print shared books

**Forventet Output:** (dit eget design)

---

### Opgave 7.30: Complex scenario - Coordinate system
**Opgave:** 
Opret et koordinatsystem program:
1. Opret ArrayList<Point> "points" med 15 random punkter
2. Find og print alle punkter på x-axis (y=0)
3. Find og print alle punkter på y-axis (x=0)
4. Find punktet tættest på origin
5. Find alle punkter der er exact duplicates
6. Print alt med toString()

**Forventet Output:** (dit eget design med complete koordinatsystem analyse)

---

## Refleksionsspørgsmål

Efter du har løst opgaverne, tænk over:
1. Hvorfor er toString() nyttig til debugging?
2. Hvad er forskellen mellem == og .equals()?
3. Hvorfor skal equals() checke for null?
4. Hvad betyder det at equals() skal være "symmetrisk"?
5. Hvorfor bruges ISBN til at sammenligne bøger i stedet for titel?
6. Hvordan hjælper @Override annotation?
7. Hvad sker der hvis du ikke override toString()? equals()?
