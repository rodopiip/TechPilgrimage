package org.example.file_reversal;

import org.example.util.Util;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
/*
note:
   1.Create a class named ReverseFileContent.
 */
public class ReverseFileContent {
    /*
    note:
     2. In the ReverseFileContent class,
     define a method with the following signature:
     */
    public static void reverseContent(String inputFile, String outputFile) {
        /*
        note:
         3. In the reverseContent method,
         use the Files utility class to read the input file into a List<String>
         using the Files.readAllLines(Path) method.
         Catch any IOException that might occur and handle it accordingly
         (e.g., print an error message and return).
         */
        try {
            Path inputPath = Paths.get(inputFile);
            List<String> lines = Files.readAllLines(inputPath);
            /*
            note:
             4. Create an empty List<String> to store the reversed lines.
            */
            List<String> reversedLines = new ArrayList<>();
            List<Future<String>> futures = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(4);
            /*
            note:
             5. Iterate over the lines read from the input file.
             For each line, create a new StringBuffer and append the line content to it.
             Use the reverse() method of the StringBuffer to reverse the content.
             Add the reversed content (converted back to a String) to the list of reversed lines.
             */
            for (String line : lines){
                /*
                note:
                 6. Use the ExecutorService and Callable to process the lines in parallel.
                 For each line, create a Callable task that performs steps 4 and 5,
                 and submit the task to the executor service.
                 Collect the Future objects returned by the executor service.
                 */
                Callable<String> reversalTask = () -> {
                    StringBuffer buffLine = new StringBuffer(line);
                    buffLine.reverse();
                    return buffLine.toString();
                };
                Future<String> future = executor.submit(reversalTask);
                futures.add(future);
            }
            /*
            note:
             7. After submitting all tasks,
             shut down the executor service using shutdown()
             and wait for the tasks to complete using awaitTermination(long, TimeUnit).
             */
            /*
            hint: first signal the executor service to stop accepting new tasks
             */
            executor.shutdown();
            /*
            hint:
             and then waits for a maximum of 10 seconds
             for all the submitted tasks to complete
             */
            executor.awaitTermination(10, TimeUnit.SECONDS);
            /*
            note:
             8. Once all tasks are completed,
             collect the results from the Future objects
             and store them in the list of reversed lines.
             */
            for (Future<String> future : futures){
                reversedLines.add(future.get());
            }
            /*
            note:
             9. Use the Files utility class to write the list of reversed lines
             to the output file using the Files.write(Path, Iterable, OpenOption) method.
             Catch any IOException that might occur and handle it accordingly
             (e.g., print an error message and return).
             */
            Path outputPath = Paths.get(outputFile);
            Files.write(outputPath, reversedLines, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (InvalidPathException e){
            System.out.println(Util.ANSI_YELLOW+"Attention: Invalid file path: "+Util.ANSI_RESET+e.getMessage());
        } catch (NoSuchFileException e){
            System.out.println(Util.ANSI_YELLOW+"File not found: " +Util.ANSI_RESET+ e.getMessage());
        } catch (IOException e) {
            System.out.println(Util.ANSI_YELLOW+"Attention: reading/writing the input/output file: "+Util.ANSI_RESET+e.getMessage());
        } catch (InterruptedException | ExecutionException e){
            System.out.println(Util.ANSI_YELLOW+"Error while processing tasks in parallel: "+Util.ANSI_RESET+e.getMessage());
        }
    }
}
