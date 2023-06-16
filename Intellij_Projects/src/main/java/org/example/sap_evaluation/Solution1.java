import java.util.Scanner;

import java.lang.*;

/*
 * inputNum, representing the array with size of inputNum_size.
 * size, representing the total number of pages.
 */
public class Solution1
{
    public static int  cacheMisses(int[] inputNum, int size)
    {
        int  answer = 0;
        // Write your code here



        //the number of times a page is requested,
        //but is not found in the cache
        return answer;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //input for inputNum
        //total number of pages
        int inputNum_size = in.nextInt();
        int inputNum[] = new int[inputNum_size];
        for(int idx = 0; idx < inputNum_size; idx++)
        {
            //page requests per page
            inputNum[idx] = in.nextInt();
        }
        // input for size
        //cache size
        int size = in.nextInt();


        int result = cacheMisses(inputNum, size);
        System.out.print(result);

    }
}
