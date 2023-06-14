package org.example.hashing_principle;

public class HashDemo {
    public static void main(String[] args) {
        int hash1 = "hello".hashCode();
        int hash2 = "world".hashCode();
        System.out.println(hash1);
        System.out.println(hash2);
    }
}
