# Lab 10 – Singleton Design Pattern

## Lab Information
**Course:** Software Construction  
**Lab Title:** Singleton Design Pattern  
**Project:** Lab10  
**Language:** Java  

## Overview
This lab demonstrates the Singleton Design Pattern in Java. The Singleton pattern restricts a class to a single instance and provides a global access point to that instance. The lab explores Singleton implementation, shared resources, and thread safety.

## Tasks

### Task 1 – Database Connection Manager
Implemented a Singleton `DatabaseConnectionManager` to ensure that only one instance of the database manager is created and shared among different modules.

**Concepts demonstrated:**
- Private constructor
- Static instance
- Global access through `getInstance()`
- Reference equality using `==`
- Constructor count verification

### Task 2 – CampusPrint Spooler Queue
Implemented a Singleton `PrintSpooler` shared by different campus labs. Multiple labs submit print jobs to a common queue.

**Concepts demonstrated:**
- Shared Singleton instance
- FIFO (First-In, First-Out) queue
- `Queue` and `LinkedList`
- Synchronized methods
- Adding and processing print jobs

### Task 3 – AuditLogger and Race Condition
Implemented a Singleton `AuditLogger` accessed by multiple threads. The naive Singleton implementation demonstrates a potential race condition when multiple threads attempt to create the instance simultaneously.

The problem was resolved using **Double-Checked Locking (DCL)** with `volatile` and `synchronized`.

**Concepts demonstrated:**
- Multithreading
- Race conditions
- Lazy initialization
- `volatile`
- Synchronization
- Double-Checked Locking

## Technologies Used
- Java
- Apache Maven
- NetBeans IDE
- Git
- GitHub

## Project Structure

```text
Lab10
├── README.md
├── pom.xml
└── src/main/java/com/uet/lab10
    ├── Lab10.java
    ├── DatabaseConnectionManager.java
    ├── PrintSpooler.java
    ├── SoftwareLab1.java
    ├── NetworkingLab2.java
    └── AuditLogger.java
```

## How to Run

1. Clone or download this repository.
2. Open the project in NetBeans IDE.
3. Make sure Java is configured.
4. Open `Lab10.java`.
5. Run the main class.

The program demonstrates all three tasks and displays the results in the console.

## Learning Outcomes
- Understand and implement the Singleton Design Pattern.
- Restrict object creation using a private constructor.
- Share a single instance between multiple modules.
- Manage shared resources using a Singleton.
- Understand race conditions in multithreaded applications.
- Implement thread-safe Singleton initialization using Double-Checked Locking.
- Understand the benefits and limitations of global shared state.
