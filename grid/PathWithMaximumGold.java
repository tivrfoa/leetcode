class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 0) continue;
                int g = findFrom(grid, i, j);
                if (g > max) max = g;
            }
        }
        
        return max;
    }
    
    private int findFrom(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        
        return findFrom(grid, i, j, visited) + grid[i][j];
    }
    
    private int findFrom(int[][] grid, int i, int j, boolean[][] visited) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        int max = 0;

        // up
        int x = i - 1, y = j;
        if (x >= 0 && !visited[x][y] && grid[x][y] > 0) {
            visited[x][y] = true;
            int tmp = findFrom(grid, x, y, visited) + grid[x][y];
            if (tmp > max) max = tmp;
            visited[x][y] = false;
        }
        
        // down
        x = i + 1; y = j;
        if (x < n && !visited[x][y] && grid[x][y] > 0) {
            visited[x][y] = true;
            int tmp = findFrom(grid, x, y, visited) + grid[x][y];
            if (tmp > max) max = tmp;
            visited[x][y] = false;
        } 
        
        // right
        x = i; y = j + 1;
        if (j+1 < m && !visited[x][y] && grid[x][y] > 0) {
            visited[x][y] = true;
            int tmp = findFrom(grid, x, y, visited) + grid[x][y];
            if (tmp > max) max = tmp;
            visited[x][y] = false;
        }
        
        // left
        x = i; y = j - 1;
        if (j-1 >= 0 && !visited[x][y] && grid[x][y] > 0) {
            visited[x][y] = true;
            int tmp = findFrom(grid, x, y, visited) + grid[x][y];
            if (tmp > max) max = tmp;
            visited[x][y] = false;
        }
        
        return max;
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
        System.out.println(new Solution().getMaximumGold(
            new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}
        ));
    }
}