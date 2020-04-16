package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
       //System.out.println(" result =" + new ProductExceptSeft().productExceptSelf(nums));
        printArray(new ProductExceptSeft().productExceptSelf(nums));
    }

    public static String sortWord(String str){
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static void printList(ArrayList<ArrayList<String>> strs){
        System.out.println("[");
        for(ArrayList<String> l: strs){
            System.out.printf("\t[");
            for(String s: l){
                System.out.printf("%s ",s);
            }
            System.out.printf("]\n");
        }
        System.out.println("]");
    }

    public static void printArray(int[] nums){
        System.out.printf("\n*********** Start *********\n");
        for(int i=0; i<nums.length;i++){
            System.out.print(" " + nums[i]);
        }
        System.out.printf("\n************ End **********");
    }

}
