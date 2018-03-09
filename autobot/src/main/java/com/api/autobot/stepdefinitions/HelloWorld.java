package com.api.autobot.stepdefinitions;


import java.util.Arrays;
import java.util.Scanner;
public class HelloWorld {
 
    private static Scanner scan;
 
       public static void main(String[] args) {
              scan = new Scanner(System.in);
        System.out.println("Type your sentence to find length and the longest word ");
        String s = scan.nextLine();
        System.out.println("Longest words in the sentence are as follows --- ");
        bignumber1(s);
        printnumwords(s);
    }
 
    public static String[] bignumber1(String y) {
        String s = y;
        String maxlenword = " ";
        String[] w = s.split(" ");
        String[] maxlenwordarr = null;
        for (String temp: w) {
            if (temp.length() >= maxlenword.length()) {
                maxlenword = temp;
            }
        }
        int maxlen = maxlenword.length();
        for (String temp1: w) {
            if (temp1.length() == maxlen) {
                maxlenwordarr = new String[]{temp1};
               
                for (int index = 0; index < maxlenwordarr.length; index++) {
                    System.out.println(maxlenwordarr[index]);
                   
                }
               
            }
        }
              return maxlenwordarr;
    }
   
    
    public static void printnumwords(String y) {
        if (y == null)
        System.out.println("There are no words in the sentence");
        else System.out.println("The number of words in the sentence are: " + y.trim().split("\\s+").length);
    }
   
    public static boolean assertnumword(String y, int z) {
        if (y == null)
        System.out.println("There are no words in the sentence");
        int a = y.trim().split("\\s+").length;
        if (z == a)
             System.out.println("The number of words are matching and the test passed");
        else
             System.out.println("The number of words are not matching and the test failed");
              return false;
    }
   
    public static boolean assertlongestword(String y, String[] z) {
       if (y == null)
        System.out.println("There are no words in the sentence");
        String s = y;
        String maxlenword = " ";
        String[] w = s.split(" ");
        String[] maxlenwordarr = new String[w.length];
        for (String temp: w) {
            if (temp.length() >= maxlenword.length()) {
                maxlenword = temp;
            }
        }
        int maxlen = maxlenword.length();
 
        for (int index = 0; index < w.length; index++) {
            if (w[index].length() == maxlen) {
            String d=w[index];
            maxlenwordarr[index] = d;
            }
        }
       
        for (int index = 0; index < maxlenwordarr.length; index++) {
            System.out.println(maxlenwordarr[index]);
 
        }
   
        for (int index = 0; index < z.length; index++) {
            System.out.println(z[index]);
        }
       
        
        if (Arrays.equals(z, maxlenwordarr))
             System.out.println("The longest words are matching and the test passed");
        else
             System.out.println("The longest words are not matching and the test failed");
              return false;
    }
}