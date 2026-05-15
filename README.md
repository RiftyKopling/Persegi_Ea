# Geometry Calculator - Java OOP Project

A Java Object Oriented Programming (OOP) project that implements several geometry objects such as:

- Square (Persegi)
- Square Pyramid (Limas Persegi)
- Square Prism (Prisma Bujur Sangkar)

This project also demonstrates:
- Inheritance
- Polymorphism
- Encapsulation
- Abstraction
- Multithreading
- Java Swing GUI

---

# Features

## 1. Square
Calculate:
- Area
- Perimeter

## 2. Square Pyramid
Calculate:
- Volume
- Surface Area

## 3. Square Prism
Calculate:
- Volume
- Surface Area

## 4. Multi Thread Execution
Compare:
- Single Thread
- Multi Thread

to analyze runtime performance.

---

# OOP Concepts Used

## Encapsulation
```java
private double sisi;
```

## Inheritance
```java
class LimasPersegi extends BangunRuang
```

## Polymorphism
```java
List<BendaGeometri> shapes;
```

## Abstraction
Using abstract class/interface for geometry objects.

---

# Project Structure

```bash
mainapp/
│
├── projek_pbo/
│   ├── BendaGeometri.java
│   ├── BangunRuang.java
│   ├── Persegi.java
│   ├── BujurSangkar.java
│   ├── LimasPersegi.java
│   └── PrismaBujurSangkar.java
│
├── threading/
│   ├── ThreadExecutor.java
│   └── ThreadExecutorSingle.java
│
├── ui/
│   ├── MultiThreadPage.java
│   └── other GUI pages
│
└── Main.java
```

---

# Technologies

```bash
- Java
- Java Swing
- ExecutorService
- Multithreading
- Object Oriented Programming
```

---

# How To Run

## Compile

```bash
javac Main.java
```

## Run

```bash
java Main
```

---

# Example Output

## Single Thread

```bash
main | #1 | [LimasPersegi] -> ...
main | #2 | [BujurSangkar] -> ...
```

## Multi Thread

```bash
pool-1-thread-1 | #1 | [LimasPersegi] -> ...
pool-1-thread-2 | #2 | [BujurSangkar] -> ...
```

---

# GUI Preview

```bash
---------------------------------------------------------
|      Single Thread     |      Multi Thread            |
---------------------------------------------------------
| output single thread   | output multi thread          |
| output single thread   | output multi thread          |
---------------------------------------------------------
| runtime single thread  | runtime multi thread         |
---------------------------------------------------------
```

---

# Purpose

This project was created to learn:
- Java OOP Concepts
- Java Swing GUI
- Geometry Calculations
- Java Multithreading
- Runtime Performance Comparison

---

# Author

```bash
morxidia
```

---

# License

This project is for educational purposes.
