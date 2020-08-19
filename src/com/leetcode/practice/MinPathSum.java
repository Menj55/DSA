package com.leetcode.practice;

public class MinPathSum {

	public int minPathSum(int[][] grid) {
        return minSum(grid, grid.length-1, grid[0].length-1);
    }
    
    public int minSum(int[][] grid, int x, int y) {
    	System.out.println("X = " + x + "  y = "+ y);
    	if(x == 0 && y == 0) {
    		return grid[x][y];
    	}
    	if(x < 0 || y < 0)
            return Integer.MAX_VALUE;
    	int l = minSum(grid,x-1,y);
        int r = minSum(grid,x,y-1);
        return grid[x][y] + Math.min(l,r);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]grid = {{1,3,1},{1,5,1},{4,2,1}};
		MinPathSum p = new MinPathSum();
		boolean toVisit[] = new boolean[10];
		System.out.println(p.minPathSum(grid));
	}

}
