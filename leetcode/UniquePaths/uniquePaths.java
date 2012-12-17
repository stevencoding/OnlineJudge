public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sol[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) sol[i][j] = 1;
                else {
                    sol[i][j] = (i - 1 >= 0 ? sol[i - 1][j] : 0) + (j - 1 >= 0 ? sol[i][j - 1] : 0);
                }
            }
        }
        return sol[m - 1][n - 1];       
    }
}