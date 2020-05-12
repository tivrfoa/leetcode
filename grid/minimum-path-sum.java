import java.util.*;
import static java.lang.System.out;
import static java.lang.Math.abs;

class Solution {
    
    public static void main(String args[]) {
        Solution s = new Solution();
        System.out.println(s.minPathSum(new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
        }));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            System.err.println("Invalid grid.");
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int[][] sum = new int[n][m];
        for (int i = 0; i < n; ++i) Arrays.fill(sum[i], -1);

        return findMin(sum, grid, n-1, m-1);
    }

    private int findMin(int[][] sum, int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        if (x == 0 && y == 0) {
            return grid[0][0];
        }

        if (sum[x][y] != -1) return sum[x][y];
        
        if (x == 0) {
            sum[x][y] = grid[x][y] + findMin(sum, grid, x, y-1);
        } else if (y == 0) {
            sum[x][y] = grid[x][y] + findMin(sum, grid, x-1, y);
        } else {
            sum[x][y] = grid[x][y] + Math.min(findMin(sum, grid, x, y-1),
                                 findMin(sum, grid, x-1, y));
         }

        return sum[x][y];
    }
}

