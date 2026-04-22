# Testing with JUnit 6 — Exercise Project

Exercise starter files for the **Testing with JUnit 6** module of the Udemy course  
**Java for Testers: From Copy-Paste to Confident Coding**

---

## What's in this repository

This repository contains the exercise starter project for the JUnit 6 module.  
Each lecture has its own package with test files ready for you to complete.

A companion **solutions** repository is also available — link in the course resources.

---

## Prerequisites

Before opening this project, make sure you have the following installed:

| Tool | Version | Download |
|---|---|---|
| Java JDK | 21 or higher | [adoptium.net](https://adoptium.net) |
| Maven | 3.8 or higher | [maven.apache.org](https://maven.apache.org) |
| IntelliJ IDEA | Community Edition | [jetbrains.com/idea](https://www.jetbrains.com/idea/download) |

> **Note:** JUnit 6 requires Java 17 or higher. Java 21 is recommended as it is the current LTS release.

---

## Getting started

### 1. Clone the repository

```bash
git clone https://github.com/YOUR-USERNAME/junit5-exercises.git
cd junit5-exercises
```

### 2. Open in IntelliJ IDEA

- Open IntelliJ IDEA
- Choose **File → Open** and select the `junit5-exercises` folder
- IntelliJ will detect the `pom.xml` and import the project automatically
- Wait for Maven to download dependencies (this may take a minute the first time)

### 3. Verify the setup

Right-click the `src/test/java` folder and choose **Run All Tests**.  
You should see all test methods listed — most will pass trivially or be empty.  
A few in Lecture 4 are intentionally written with weak assertions that you will fix.

---

## Project structure

```
junit5-exercises/
├── pom.xml
└── src/
    ├── main/java/com/javafortesters/
    │   ├── BankAccount.java         ← Lecture 10 exercise class
    │   ├── Calculator.java          ← Used in Lectures 2, 4, 7, 8
    │   ├── Item.java                ← Used with ShoppingCart
    │   └── ShoppingCart.java        ← Used in Lectures 3, 5, 6, 8, 9
    └── test/java/com/javafortesters/
        ├── lecture02/
        │   └── CalculatorBasicTest.java      ← Your first @Test methods
        ├── lecture03/
        │   └── ShoppingCartLifecycleTest.java ← @BeforeEach lifecycle
        ├── lecture04/
        │   └── AssertionsTest.java           ← Fix the weak assertions
        ├── lecture05/
        │   └── TestNamingTest.java           ← Rename and add @DisplayName
        ├── lecture06/
        │   └── ShoppingCartNestedTest.java   ← Reorganise into @Nested classes
        ├── lecture07/
        │   └── CalculatorParameterisedTest.java ← @ValueSource and @CsvSource
        ├── lecture08/
        │   └── ExceptionHandlingTest.java    ← assertThrows
        ├── lecture09/
        │   └── TaggingTest.java              ← @Tag and @Disabled
        └── lecture10/
            └── BankAccountTest.java          ← Comprehensive exercise
```

---

## The domain classes

You don't need to modify any of the classes in `src/main/java`. They are already complete.  
Your work is entirely in the test files under `src/test/java`.

### Calculator

A simple calculator with four operations.

```java
calculator.add(3, 4)        // returns 7
calculator.subtract(10, 3)  // returns 7
calculator.multiply(4, 5)   // returns 20
calculator.divide(10, 2)    // returns 5
calculator.divide(10, 0)    // throws ArithmeticException
```

### ShoppingCart and Item

A shopping cart that holds `Item` objects.

```java
Item apple = new Item("Apple", 0.99);

cart.addItem(apple);
cart.getItemCount()    // returns 1
cart.getTotal()        // returns 0.99
cart.isEmpty()         // returns false
cart.removeItem(apple)
cart.clear()
```

> Calling `removeItem()` with an item that is not in the cart throws `IllegalArgumentException`.

### BankAccount

Used in the Lecture 10 comprehensive exercise.

```java
BankAccount account = new BankAccount("Alice", 100.0);

account.getOwner()     // returns "Alice"
account.getBalance()   // returns 100.0
account.isEmpty()      // returns false

account.deposit(50.0)  // balance becomes 150.0
account.withdraw(30.0) // balance becomes 120.0
```

Throws:
- `IllegalArgumentException` — if initial balance is negative, or deposit/withdrawal amount is zero or negative
- `IllegalStateException` — if withdrawal amount exceeds current balance

---

## Lecture exercises

### Lecture 2 — Your First JUnit 6 Test
**File:** `lecture02/CalculatorBasicTest.java`

Write three `@Test` methods for `Calculator.add()`.  
Each test should follow the **Arrange / Act / Assert** pattern.

### Lecture 3 — The Test Lifecycle
**File:** `lecture03/ShoppingCartLifecycleTest.java`

1. Declare a `ShoppingCart` field
2. Add a `@BeforeEach` method that creates a fresh cart before each test
3. Complete the four test methods using the shared `cart` field

### Lecture 4 — Writing Good Assertions
**File:** `lecture04/AssertionsTest.java`

Four tests with broken or weak assertions — each TODO comment explains what's wrong.  
Fix each assertion so the test actually verifies the correct behaviour.

After fixing, apply the **mutation question**: *If I broke this code, would this test now fail?*

### Lecture 5 — Naming Your Tests
**File:** `lecture05/TestNamingTest.java`

- **Part A:** Rename four poorly named tests to describe behaviour, not method names  
  (Use IntelliJ: right-click the method → Refactor → Rename)
- **Part B:** Add `@DisplayName` to three tests with good method names

### Lecture 6 — Organising Tests with @Nested
**File:** `lecture06/ShoppingCartNestedTest.java`

Eight flat tests are already correct and passing.  
Reorganise them into three `@Nested` inner classes:

| Class | Tests |
|---|---|
| `WhenCartIsEmpty` | Tests 1–2 |
| `WhenCartHasOneItem` | Tests 3–5 |
| `WhenCartHasMultipleItems` | Tests 6–8 |

Add `@DisplayName` to each nested class and run the tests to see the tree structure in IntelliJ.

### Lecture 7 — Parameterised Tests
**File:** `lecture07/CalculatorParameterisedTest.java`

- **Part A:** Replace four repetitive tests with one `@ParameterizedTest` + `@ValueSource`
- **Part B:** Replace four repetitive tests with one `@ParameterizedTest` + `@CsvSource`

Keep it simple — each parameterised method should have one or three parameters respectively.

### Lecture 8 — Handling Expected Exceptions
**File:** `lecture08/ExceptionHandlingTest.java`

Write three exception tests using `assertThrows`:

```java
ExceptionType ex = assertThrows(
    ExceptionType.class,
    () -> methodThatShouldThrow()
);
```

One test also checks the exception message using AssertJ.

### Lecture 9 — @Tag and @Disabled
**File:** `lecture09/TaggingTest.java`

- Add `@Tag("smoke")` and/or `@Tag("regression")` and `@Tag("cart")` to four tests
- Add `@Disabled("reason")` to one test for a feature not yet implemented

**Bonus:** Try running only the `smoke` tagged tests in IntelliJ:  
Edit Run Configurations → JUnit → Test Kind: Tags → enter `smoke`

### Lecture 10 — Comprehensive Exercise
**File:** `lecture10/BankAccountTest.java`

The structure is already in place — three `@Nested` classes with 10 test methods to complete.  
This exercise covers everything from the module:

- `@BeforeEach` setup
- `@Nested` + `@DisplayName` structure
- `@Tag` on individual tests
- `assertThrows` for exception testing
- AssertJ assertions including `isCloseTo()`

---

## Running the tests

### Run all tests
```bash
mvn test
```

### Run tests for a specific lecture
```bash
mvn test -Dtest="com.javafortesters.lecture03.*"
```

### Run only smoke-tagged tests
```bash
mvn test -Dgroups="smoke"
```

### In IntelliJ
- Click the green arrow next to a test method to run one test
- Click the green arrow next to the class name to run all tests in that class
- Right-click `src/test/java` → Run All Tests to run everything

---

## Dependencies

| Dependency | Version | Purpose |
|---|---|---|
| `org.junit.jupiter:junit-jupiter` | `6.0.3` | Test framework — the latest JUnit release |
| `org.assertj:assertj-core` | `3.27.7` | Fluent assertion library |
| `maven-surefire-plugin` | `3.5.2` | Required by JUnit 6 (must be 3.0 or higher) |

The full `pom.xml` is at the root of the project.

---

## Tips

**If a test won't compile:**  
Check your imports. You need:
```java
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
```
IntelliJ can add these automatically — press `Alt+Enter` (Windows/Linux) or `Option+Enter` (Mac) on the underlined symbol.

**If Maven can't find the dependencies:**  
Right-click `pom.xml` → Maven → Reload Project

**If you're stuck:**  
Each TODO comment in the exercise files explains exactly what to do.  
If you're still unsure, check the companion solutions repository — link in the course resources.

---

## Related resources

- 📦 [Solutions repository](#) — completed versions of all exercises
- 🎬 [Udemy course](#) — Java for Testers: From Copy-Paste to Confident Coding
- 📖 [JUnit 6 User Guide](https://docs.junit.org/6.0.3/user-guide/)
- 📖 [AssertJ documentation](https://assertj.github.io/doc/)

---

## Licence

This project is provided for educational use as part of the Udemy course.  
© John Ferguson Smart — all rights reserved.

