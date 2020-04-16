package com.company;

/*
 * Date: 2020/Apr/15
 * Problem #15:
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class ProductExceptSeft {
    public int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];

        result[0]=1;
        for(int i=0; i<nums.length-1; i++){
            result[i+1]=result[i]*nums[i];
        } //counter forward

        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i] = result[i]*right;
            right = right*nums[i];
        } //count backward

        return result;
    }
}
