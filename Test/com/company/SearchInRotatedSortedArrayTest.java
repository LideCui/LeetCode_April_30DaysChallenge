package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Test
    void search() {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {1,3};
        int result = new SearchInRotatedSortedArrayTest().search(nums2,0);
        assertEquals(-1, result);
    }

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