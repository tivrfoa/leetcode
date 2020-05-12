import java.util.*;


class a {
    
    public static void main(String args[]) {
        System.out.println(findOne(new int[][]{
            {0,0,0,1},
            {0,0,1,1},
            {0,0,1,1},
            {0,1,1,1}
        }));
        System.out.println(findOne(new int[][]{
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,1},
            {0,0,0,0}
        }));
        System.out.println(findOne(new int[][]{
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        }));
        System.out.println(findOne(new int[][]{
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,1}
        }));
        System.out.println(findOne(new int[][]{
            {0,0,0,0},
            {0,0,0,0},
            {0,1,1,1},
            {0,0,0,1}
        }));
        System.out.println(findOne(new int[][]{
            {0,0,0,0},
            {0,0,0,0},
            {0,0,1,1},
            {0,0,0,1}
        }));
        System.out.println(findOne(new int[][]{
            {0,0,0,0},
            {0,0,0,1},
            {0,0,0,0},
            {1,1,1,1}
        }));
    }

    public static int findOne(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int leftmost = m;
        for (int i = 0; i < n; ++i) {
            int lo = 0, hi = m - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                if (mid >= leftmost) break;
                if (mat[i][mid] == 1) {
                    leftmost = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

                if (leftmost == 0) return 0;
            }
        }

        return (leftmost == m) ? -1 : leftmost;
    }
}

