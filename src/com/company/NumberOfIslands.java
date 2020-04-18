package com.company;

/*
 * Date: 2020/Apr/17
 * Problem #17:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Thinking:
 * I suddenly realized that this problem is quite similar like identify property in Kingdomino
 * One can assign a char to a terrain type, and identify each property
 * m1:
 * make a hashset to store islands, if the up or left cell is '1', then add an existing island,
 * else creat a new island
 * m2:
 * DFS traversal of graph
 */
public class NumberOfIslands {
// two methods are available: DFS & Union-Find.

    // merge method
    public int numIsLands(char[][] grid){
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;

        int m= grid.length;
        int n= grid[0].length;

        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; i<n; i++){
                if(grid[i][j]=='1'){
                    count++;
                    merge(grid, i, j);
                }
            }
        }
        return count;
    }

    public void merge(char[][] grid, int i, int j){

        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length|| grid[i][j]!='1')
            return;

        grid[i][j]='X';

        merge(grid,i-1,j);
        merge(grid, i+1,j);
        merge(grid,i,j-1);
        merge(grid,j,j+1);
    }



}
/*
 * Yesterday I have a 223 project due, so regretfully that I don't have time for this.
 * Today, I'll learn it once again.
 */
