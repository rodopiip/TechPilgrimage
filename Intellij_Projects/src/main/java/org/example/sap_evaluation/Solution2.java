import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * inputNum, representing the array with size of inputNum_size.
 * size, representing the total number of pages.
 */
public class Solution2
{
    public static int  cacheMisses(int[] inputNum, int size)
    {
        int  answer = 0;
        // Write your code here

        HashSet<Integer> cache = new HashSet<>(size);
        List<Integer> queue = new LinkedList<>();

        for (int page : inputNum){
            //cache hit
            if(cache.contains(page)){
                queue.remove(page);
                queue.addFirst(page);
            } else{
                //cache miss
                answer++;
                //check for full  cache
                if(queue.size()==size){
                    int last = queue.removeLast();
                    cache.remove(last);
                }
            }
            //current page - added to cache
            cache.add(page);
            queue.addFirst(page);
        }

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
