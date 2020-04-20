package com.company;

/*
Date: 2020/Apr/19
Problem #19:
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).
 */

/*
Thinking:
At first, I was thinking resort the whole array, since it's rotated.
But actually, we only need to focus on the element we search for.
And binary search takes O(log n). I assume this is kind like revised binary search.
 */
public class SearchInRotatedSortedArray {
//    public int search(int[] nums, int i) {
//        if(nums.length==0) return -1;
//        int low=0;
//        int high=nums.length-1;
//        return BS(nums,low,high,i);
//    }
//
//    private int BS(int[] nums, int low, int high, int x){
//        int mid = (low+high)/2;
//        if(nums[mid]==x) return mid;
//        else if(nums[mid]<nums[high]){ //right part is sorted
//            if(x>nums[mid] && x<=nums[high]){
//                return BS(nums,mid+1,high,x);
//            }else{
//                return BS(nums,low,mid-1,x);
//            }
//        }else if(nums[mid]>nums[low]){//left part is sorted
//            if(x<nums[mid] && x>= nums[low]){
//                return BS(nums,low,mid-1,x);
//            }else{
//                return BS(nums,mid+1,high,x);
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int low=0;
        int high=nums.length-1;

        while(low<high){
            int mid = low + (high - low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        int start = low;
        low = 0;
        high = nums.length-1;

        if(target>=nums[start] && target<= nums[high]){
            low = start;
        }else {
            high=start;
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
