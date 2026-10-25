# Assignment 5: Strategy Pattern (Calculator)

Student: Zhassyn Zhalynuly  
Group: SE-2527  
Course: Software Design Patterns  
Option: B, Calculator

## Idea

A calculator can do different operations: add, subtract, multiply, divide. Instead of one
`if / switch` that picks the operation, every operation is a separate class that implements
the same interface. The `Calculator` calls the interface and does not know which operation
is inside. The client can change the operation at any time while the program is running.

```java
Calculator calculator = new Calculator(new AddStrategy());
calculator.calculate(12, 4);

calculator.setStrategy(new MultiplyStrategy());
calculator.calculate(12, 4);
```

## Pattern roles

| Role | Class |
|------|-------|
| Strategy interface | `OperationStrategy` |
| Concrete strategies | `AddStrategy`, `SubtractStrategy`, `MultiplyStrategy`, `DivideStrategy` |
| Context | `Calculator` |
| Client | `Main` |

## Project structure

```
src/
├── Calculator.java
├── Main.java
└── strategy/
    ├── AddStrategy.java
    ├── DivideStrategy.java
    ├── MultiplyStrategy.java
    ├── OperationStrategy.java
    └── SubtractStrategy.java
docs/
├── REPORT.md
└── uml.png
```

## How to build and run

Requires JDK 17+. Open the folder in IntelliJ IDEA and run `Main`, or from the terminal:

### Windows (PowerShell)

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | Select-Object -ExpandProperty FullName)
java -cp out Main
```

### Linux / macOS (Bash)

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

Expected output:

```
12.00 + 4.00 = 16.00
12.00 - 4.00 = 8.00
12.00 * 4.00 = 48.00
12.00 / 4.00 = 3.00
Error: Cannot divide by zero
```

## How to add a new strategy

Example: power (a to the power of b). `Calculator` and the existing strategies stay unchanged.

1. Create a class in `strategy/` that implements `OperationStrategy`:

   ```java
   public class PowerStrategy implements OperationStrategy {
       @Override
       public double execute(double a, double b) {
           return Math.pow(a, b);
       }
   }
   ```

2. Use it in the client:

   ```java
   calculator.setStrategy(new PowerStrategy());
   ```

`DivideStrategy` was added in this way. The commit "Add DivideStrategy as a new strategy"
adds one new file and changes nothing else.

## UML

![UML class diagram](docs/uml.png)
