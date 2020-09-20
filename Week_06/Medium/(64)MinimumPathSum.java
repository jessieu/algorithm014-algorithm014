/**
 * 1D Dynamic Programming - bottom up
 */
class Solution {
    public int minPathSum(int[][] grid) {
        // we only need the entry for the bottom and the right element of current cell
        int[] memo = new int[grid[0].length];

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1) {
                    memo[j] = grid[i][j];
                } else if (i == grid.length - 1) {
                    memo[j] = grid[i][j] + memo[j+1];
                } else if (j == grid[0].length - 1) {
                    memo[j] = grid[i][j] + memo[j];
                } else {
                    memo[j] = grid[i][j] + Math.min(memo[j], memo[j+1]);
                }
            }
        }
        return memo[0];
    }
}
/**
 * 2D Dynamic Programming - bottom up
 */
//class Solution {
//    public int minPathSum(int[][] grid) {
//        int[][] memo = new int[grid.length][grid[0].length];
//
//        for (int i = grid.length - 1; i >= 0; i--) {
//            for (int j = grid[0].length - 1; j >= 0; j--) {
//                if (i == grid.length - 1 && j == grid[0].length - 1) {
//                    memo[i][j] = grid[i][j];
//                } else if (i == grid.length - 1) {
//                    memo[i][j] = grid[i][j] + memo[i][j+1];
//                } else if (j == grid[0].length - 1) {
//                    memo[i][j] = grid[i][j] + memo[i+1][j];
//                } else {
//                    memo[i][j] = grid[i][j] + Math.min(memo[i+1][j], memo[i][j+1]);
//                }
//            }
//        }
//        return memo[0][0];
//    }
//}
/**
 * Recursion with Memoization
 */
//class Solution {
//    private int[][] memo;
//    private int findMin(int[][] grid, int row, int col) {
//        if (row == grid.length || col == grid[0].length)
//            return Integer.MAX_VALUE; // when it reaches the boundary, we don't want it to be our min
//        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
//        if (memo[row][col] > 0) return memo[row][col];
//        memo[row][col] = grid[row][col] + Math.min(findMin(grid, row + 1, col), findMin(grid, row, col + 1));
//        return memo[row][col];
//    }
//    public int minPathSum(int[][] grid) {
//        memo = new int[grid.length][grid[0].length];
//        return findMin(grid, 0, 0);
//    }
//}

/**
 * Recursion
 */
//class Solution {
//    private int findMin(int[][] grid, int row, int col) {
//        if (row == grid.length || col == grid[0].length)
//            return Integer.MAX_VALUE; // when it reaches the boundary, we don't want it to be our min
//        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
//
//        return grid[row][col] + Math.min(findMin(grid, row + 1, col), findMin(grid, row, col + 1));
//    }
//    public int minPathSum(int[][] grid) {
//        return findMin(grid, 0, 0);
//    }
//}