import java.util.*;

class Solution {
    
    public static void main(String args[]) {
       System.out.println(new Solution().maxCoins(new int[]{3,1,5,8})); 
    }

    public int maxCoins(int[] a) {
        
        if (a.length == 0) return 0;

        final int n = a.length;
        int[][] dp = new int[n][n];

        for (int l = n-1; l >= 0; --l) {
            for (int r = l; r < n; ++r) {
                for (int i = l; i <= r; ++i) {
                    dp[l][r] = Math.max(dp[l][r],
                            a[i]*(l > 0 ? a[l-1] : 1) * (r == n-1 ? 1 : a[r+1])
                            + (l <= i-1 ? dp[l][i-1] : 0) + (i+1 <= r ? dp[i+1][r] : 0));
                }
            }
        }

        return dp[0][n-1];
    }
}

