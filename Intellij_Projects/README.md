# Intellij Projects

This project currently contains several sub-projects, each containing Java code focusing on a specific topic or algorithm. These sub-projects are located in the `src/main/java/org/example` directory. Compiled class files are located in the `target/classes/org/example` directory.

Please refer to the individual sub-project directories for more information about each specific project.

## Problem Statements

Here are 2 problems I will try to solve in the next few days (as of 19.6.23) as part of my technical interview preparation:

### 1. [ClassHierarchyManagement.java](src/main/java/org/example/technical_Inteview_evaluation/ClassHierarchyManagement.java)

A company is implementing an HR system. They need a way to manage their organization's hierarchy. They have a simple rule: A Manager can have multiple Employees reporting to them, but an Employee can have only one Manager.

**Input:** The first line consists of a positive integer, `n`, representing the total number of employees. The next `n` lines each contain a pair of space-separated strings representing an Employee and their Manager.

**Output:** Print the hierarchy tree in string format, with each level indented by two spaces.

**Note:** A Manager who does not report to anyone is considered the head of the hierarchy.

**Example:**

```
Input:
4
Alice Bob
Bob Charlie
Charlie Dave
Eve Charlie
Output:
Dave
Charlie
Bob
Alice
Eve
```
**Explanation:** The given pairs show that Bob reports to Charlie, Alice reports to Bob, Charlie reports to Dave, and Eve also reports to Charlie. The hierarchy tree is then constructed based on this.

---

### 2. Sorting Algorithm Efficiency

You have been tasked with evaluating the efficiency of different sorting algorithms in Java. You will be provided with an array of integers and your task is to apply different sorting algorithms, measure their execution time, and determine the most efficient one.

**Input:** The first line consists of a positive integer, `n`, representing the size of the array. The next line consists of `n` space-separated integers, representing the array to be sorted.

**Output:** Print the name of the most efficient sorting algorithm, based on execution time.

**Note:** Evaluate at least three sorting algorithms: Bubble Sort, Quick Sort, and Merge Sort.

**Example:**

```
Input:
5
5 3 2 4 1
Output:
Quick Sort
```
**Explanation:** Upon implementing the three sorting algorithms and comparing their execution times, Quick Sort is found to be the most efficient for the given input.


