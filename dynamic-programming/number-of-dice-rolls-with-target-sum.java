import java.util.*;

class NumberOfDiceRollsWithTargetSum {

    private static final mod = 1_000_000_007;
    
    public static void main(String args[]) {
        NumberOfDiceRollsWithTargetSum c = new NumberOfDiceRollsWithTargetSum();
        System.out.println(c.numRollsToTarget(1, 6, 3));
        System.out.println(c.numRollsToTarget(2, 6, 7));
    }

    public int numRollsToTarget(int d, int f, int target) {
        
        int ans = 0;
        int[] sums = new int[target];
        for (int i = 0; i < d; i++) {
            for (int j = 1; j <= f; ++j) {
                if (i == 0) {
                    if (j < target) sum[j]
                }
            }
        }
    }
}

