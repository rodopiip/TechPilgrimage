package org.example.technical_Inteview_evaluation;

import java.util.*;

public class ClassHierarchyManagement {
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

    //collection for relationships
    static Map<String, List<String>> map;
    //collection for employees
    static Set<String> employees;
    private static void hierarchize(String[] workRelationships) {
        //1. initialize the static collection
        map = new HashMap<>();
        employees = new HashSet<>();
        //2. iterate over workRelationships array
        for (String workRelationship : workRelationships){
            String[]pair = workRelationship.split(" ");
            String employee = pair[0];
            String manager = pair[1];
            //employee -> hashSet
            employees.add(employee);
            if (manager.equals("None")){
                continue;
            }
            //relationship -> hashMap
            map.putIfAbsent(manager, new ArrayList<>());
            map.get(manager).add(employee);
        }
        //3. locate the highest manager (tree root)
        //todo: explain via comments
        String root = null;
        for (String manager : map.keySet()){
            if (!employees.equals(manager)){
                root = manager;
                break;
            }
        }
        //todo: 4. I sense a recursion.

        //todo: 5. display the names with indentation,
        // that matches the index.

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. input for total number of employees
        int entry_size = scanner.nextInt();
        //2. n lines for Employee-Manager relationship - for loop
        String work_relationships[] = new String[entry_size];
        for (int i = 0; i<entry_size; i++){
            work_relationships[i] = scanner.next();
        }
        //3. method()
        hierarchize(work_relationships);
    }
}
