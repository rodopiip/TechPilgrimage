package org.example.technical_Inteview_evaluation.class_hierarchy_management;

import java.util.*;

public class RecursiveClassHierarchyManagement {
    /*
    A company is implementing an HR system.
    They need a way to manage their organization's hierarchy.
    They have a simple rule:
    A Manager can have multiple Employees reporting to them,
    but an Employee can have only one Manager.

    Input: The first line consists of a positive integer, n,
    representing the total number of employees.
    The next n lines each contain a pair of space-separated strings
    representing an Employee and their Manager.

    Output: Print the hierarchy tree in string format,
    with each level indented by two spaces.

    Note: A Manager who does not report to anyone
        is considered the head of the hierarchy.
     */
    /*
    note:
     collections are static class variables instead of
     method variables for the purpose of maintaining their
     state across multiple method calls
    */
    //collection for relationships
    static Map<String, List<String>> employeeToSubordinates;
    //collection for employees
    static Set<String> employees;
    private static void hierarchize(String[] workRelationships) {
        //1. initialize the static collection
        employeeToSubordinates = new HashMap<>();
        employees = new HashSet<>();
        //2. iterate over workRelationships array
        for (String workRelationship : workRelationships){
            String[]pair = workRelationship.split(" ");
            String manager = pair[0];
            String employee = pair[1];
            //employee -> hashSet
            employees.add(employee);
            //relationship -> hashMap
            employeeToSubordinates.putIfAbsent(manager, new ArrayList<>());
            employeeToSubordinates.get(manager).add(employee);
        }
        //3. locate the highest manager (tree root)
        String root = employeeToSubordinates.keySet().stream()
                .filter(manager -> !employees.contains(manager))
                .findFirst().orElse(null);
        //4. use a recursive method for printing the hierarchy
        printHierarchy(root, "");
    }
    //define a recursive method for printing the hierarchy
    public static void printHierarchy(String manager, String indentation){
        //print the current manager with their respective indentation,
        //signifying their rank
        System.out.println(indentation+manager);
        //if the manager has employees
        //(if they are an actual manager),
        //call the recursive method for each employee
        //while increasing the indentation
        if (employeeToSubordinates.containsKey(manager)){
            for (String employee : employeeToSubordinates.get(manager)){
                printHierarchy(employee, indentation + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. input for total number of employees
        int entry_size = scanner.nextInt();
        //2. n lines for Employee-Manager relationship - for loop
        scanner.nextLine(); // consume newline
        String work_relationships[] = new String[entry_size];
        for (int i = 0; i<entry_size; i++){
            work_relationships[i] = scanner.nextLine();
        }
        //3. method()
        hierarchize(work_relationships);
    }
}
