package org.example.file_reversal;

public class Demo {
    public static void main(String[] args) {
        /*
         Create a simple Java application that reads a text file line by line,
         reverses the content of each line,
         and writes the reversed content to a new output file.
         Use the Files utility class, StringBuffer,
         multithreading, and exception handling.
         */

        /*
        note:
         10. In the main method of the ReverseFileContent class,
         call the reverseContent method with the input file path
         and output file path as arguments.
         You can either hardcode the file paths
         or read them from the command-line arguments.
         */
        String inputFile = "src/Zavetni_liri_-_Antologija_na_ruskata_klasicheska_poezija.txt";
//        String inputFile = "non_existent_file.txt";
        String outputFile = "src/output_file.txt";
        ReverseFileContent.reverseContent(inputFile, outputFile);
    }
}