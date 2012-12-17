public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int sol[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            sol[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            sol[0][j] = j;
        }
        char c1;
        for (int i = 1; i <= len1; i++) {
            c1 = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                sol[i][j] = min3(sol[i - 1][j] + 1, sol[i][j - 1] + 1, 
                sol[i - 1][j - 1] + (c1 == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        return sol[len1][len2];
    }
    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
