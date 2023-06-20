package org.example.technical_Inteview_evaluation.class_hierarchy_management;

import java.util.*;

public class IterativeClassHierarchyManagement {
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
    public static void hierarchize(String [] workRelationships){
        Map<String, List<String>> employeeToSubordinates = new HashMap<>();
        Set<String> employees = new HashSet<>();
        String boss = null;
        for (String relation : workRelationships){
            String[] parts = relation.split(" ");
            String manager = parts[0];
            String employee = parts[1];
            employees.add(employee);
            if (!employeeToSubordinates.containsKey(manager)){
                employeeToSubordinates.put(manager, new ArrayList<>());
            }
            employeeToSubordinates.get(manager).add(employee);
            if (!employees.contains(manager)){
                boss = manager;
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(boss);
        // We iterate until there are no more elements in the queue.
        // At the beginning, the queue contains only the boss.
        while (!queue.isEmpty()){
            // We take out the first person from the queue.
            // At the beginning, it's the boss.
            // After that, it's his subordinates, then their subordinates, etc.
            String currentEmployee = queue.poll();
            // Here we calculate the level of the current employee in the hierarchy.
            // We do this by splitting the currentEmployee string by spaces
            // and counting the parts.
            // Each part is a name, so the number of parts minus one is the number of spaces,
            // and each space represents one level of indentation
            // (we add a space for each level of management).
            int level = currentEmployee.split(" ").length - 1;
            // We print the name of the current employee,
            // indented by the appropriate number of spaces.
            // We find the actual name by taking the last part of the split string.
            System.out.println(" ".repeat(level*2)+currentEmployee.split(" ")[level]);
            // Only get the subordinates of the current employee, not the entire string in the queue.
            String employeeName = currentEmployee.split(" ")[level];
            // We get the list of subordinates of the current employee.
            List<String>subordinates = employeeToSubordinates.get(employeeName);
            // If the current employee has any subordinates...
            if (subordinates!=null){
                // ...we add each of them to the queue,
                // appending their name to the current employee's name,
                // so when we split it later, we get the correct level of indentation.
                for (String subordinate : subordinates){
                    queue.add(currentEmployee+" "+subordinate);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entry_size = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String workRelationships[] = new String[entry_size];
        for (int i = 0; i < entry_size; i++){
            workRelationships[i] = scanner.nextLine();
        }
        hierarchize(workRelationships);
    }
}
