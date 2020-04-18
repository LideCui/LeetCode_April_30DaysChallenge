package com.company;

/*
Date: 2020/Apr/18
Problem #18
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */

/*
Thinking:
At first, I was thinking use merge method similar to number of islands
But hint shows that this a minimize problem, so DP is closly related to it.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 && grid[0].length==0)
            return 0;

        int m=grid.length;
        int n=grid[0].length;

        int[][] tb = new int[m][n];
        //tb[0][0] = grid[0][0];
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(i-1<0 && j-1<0){
                    tb[i][j]=grid[i][j];
                } else if(i-1<0){
                    tb[i][j]=grid[i][j]+grid[i][j-1];
                }else if(j-1<0){
                    tb[i][j]=grid[i][j]+grid[i-1][j];
                } else{
                    tb[i][j] = grid[i][j]+ (grid[i-1][j]<grid[i][j-1]?grid[i-1][j]:grid[i][j-1]);
                }
            }
        }
        //int count = grid[m-1][n-1];
        return tb[m-1][n-1];
    }


//    public int minPathSum(int[][] grid) {
//        if(grid.length==0 && grid[0].length==0)
//            return 0;
//
//        int m=grid.length;
//        int n=grid[0].length;
//        int count = grid[0][0] + grid[m-1][n-1];
//        int r = goR(grid,0,1);
//        int d = goD(grid,1,0);
//        count += r<d?r:d;
//
//        return count;
//    }
//
//    public int goR(int[][] grid, int i, int j){
//        int m=grid.length;
//        int n=grid[0].length;
//        if(i==m-1 && j==n-1) return 0;
//
//        if(j<0||j>grid[0].length-1)
//            return Integer.MAX_VALUE;
//
//        int count = grid[i][j];
//        int d = goD(grid,i+1,j);
//        int r = goR(grid,i,j+1);
//        count += (r<d?r:d);
//        return count;
//    }
//    public int goD(int[][] grid, int i, int j){
//        int m=grid.length;
//        int n=grid[0].length;
//        if(i==m-1 && j==n-1) return 0;
//
//        if(i<0||i>grid.length-1)
//            return Integer.MAX_VALUE;
//
//        int count= grid[i][j];
//        int r = goR(grid,i,j+1);
//        int d = goD(grid,i-1,j);
//        count += (r<d?r:d);
//        return count;
//    }
}
