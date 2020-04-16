package com.company;

/*
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */

/*
 * Thinking:
 * going through every element in shift
 * Use counter to record the final movement
 * Use String library to make the movement
 * Thus, we only perform once
 * 0 left *(-1), 1 right (1)
 */
public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        int move = 0;
        for(int i=0; i<shift.length;i++){
            int amount = shift[i][1];
            if(shift[i][0]==0){
                move += (-1)*amount;
            }else if(shift[i][0]==1){
                move += amount;
            }
        }


        if(move<0){ //left shift
            for(int i=0; i<Math.abs(move); i++){
                char c = s.charAt(0);
                s =  s.substring(1,s.length()) + c;
                System.out.println("hit here");
            }
        }else if(move>0){ //right shift
            for(int i=0; i<move; i++){
                s = s.charAt(s.length()-1) + s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}

/*
 * String.substring(start, end)
 * extract string from start to end, start included, end not included
 */
