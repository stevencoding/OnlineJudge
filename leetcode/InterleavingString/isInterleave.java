public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean sols[][] = new boolean[len1 + 1][len2 + 1];
        
        for (int i = len1; i >= 0; i--) {
            for (int j = len2; j >= 0; j--) {
                if (i == len1 && j == len2) {
                    sols[i][j] = true;
                } else {
                    char c = s3.charAt(i + j);
                    sols[i][j] = (i < len1 && s1.charAt(i) == c && sols[i + 1][j]) |
			(j < len2 && s2.charAt(j) == c && sols[i][j + 1]);
                    
                }
            }
        }
        
        return sols[0][0];
    }
}