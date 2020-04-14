package com.company;
/*
 * Date: 2020/Apr/13
 * Problem #13:
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */

/*
 * Thinking:
 * #1 Divide and conquer method solve for the max subarray
 * an modification of find max subarray
 * #2 DP maybe
 */

import java.util.HashMap;

/*
 * When I check out the solution, it's actually quite simple
 * Like the find max profit for stock we done before
 * The idea is that use a counter to count 0s and 1s, but 0 as -1, and 1 as 1
 * the difference between position with same value is the max subarray with same number of 0s and 1s
 *
 * Use a hashmap to store, <key:count, value:position>
 */
public class FindMaxLength {
    public int solution(int[] nums){
        HashMap<Integer,Integer> counts = new HashMap<>();
        counts.put(0,-1);
        int count = 0;
        int maxLen = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count--;
            }else{
                count++;
            }

            if(counts.containsKey(count)){
                maxLen = Math.max(maxLen, i-counts.get(count));
            }else{
                // only the first appeared
                counts.put(count,i);
            }
        }
        return maxLen;
    }
}
