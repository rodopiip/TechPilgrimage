package org.example.inida_bix;

public class Demo {
    public static void main(String[] args) {
        int i = 1, j = 10;
        do
        {
            if(i++ > --j) /* Line 4 */
            {
                continue;
            }
        } while (i < 5);
        //System.out.println("i = " + i + "and j = " + j);
        String str = null;
        System.out.println(str);
    }
}
