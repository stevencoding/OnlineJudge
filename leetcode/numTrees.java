public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sol[] = new int[n + 1];
        if (n <= 2) return n;
        sol[0] = sol[1] = 1;
        sol[2] = 2;
        int i, j;
        for (i = 3; i <= n; i++) {
            for (j = 0; j < i / 2; j++) {
                sol[i] += 2 * (sol[j] * sol[i - j - 1]);
            }
            if (i % 2 == 1) sol[i] += sol[j] * sol[i - j - 1];
        } 
        return sol[n];
    }
}