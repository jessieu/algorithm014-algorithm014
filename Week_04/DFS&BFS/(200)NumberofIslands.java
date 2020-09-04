class Solution {
    // mark the visited island to '0'
    private void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        // terminator:
        // 1. index out of bound
        // 2. in water
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }
        // handle current logic: mark the visited island to '0'
        grid[r][c] = '0';
        // drill down
        dfs(grid, r, c-1); // left
        dfs(grid, r, c+1); // right
        dfs(grid, r-1, c); // top
        dfs(grid, r+1, c); // bottom
    }

    public int numIslands(char[][] grid) {
        int num = 0;
        int row = grid.length;
        int col = row > 0 ? grid[0].length : 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    num++;
                    dfs(grid, r, c);
                }
            }
        }
        return num;
    }
}