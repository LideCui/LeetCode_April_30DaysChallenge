package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {

    @Test
    void minPathSum() {
       int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
       int result = new MinimumPathSum().minPathSum(grid);
       //System.out.println("---"+result);
       assertEquals(7, result);
    }

    @Test
    void goR() {
    }

    @Test
    void goD() {
    }

    @Test
    void testMinPathSum() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int result = new MinimumPathSum().minPathSum(grid);
        //System.out.println("---"+result);
        assertEquals(7, result);
    }
}