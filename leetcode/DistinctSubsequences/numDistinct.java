public class Solution {
    public int numDistinct(String S, String T) {
        // DO NOT write main() function
        // Start typing your Java solution below
        int slen = S.length(), tlen = T.length();
        if (tlen > slen) return 0;
        int prev[] = new int[slen], cur[] = new int[slen];
        char tc;
        for (int i = 0; i < tlen; i++) {
            tc = T.charAt(i); 
            for (int j = i; j < slen; j++) {
                if (S.charAt(j) == tc) {
                    cur[j] = j == 0 ? 1 : (i == 0 ? 1 : prev[j - 1]) + cur[j - 1];
                } else {
                    cur[j] = j == 0 ? 0 : cur[j - 1];
                }
            }
            for (int k = 0; k < slen; k++) {
                prev[k] = cur[k];
                cur[k] = 0;
            }
            

        }
        return prev[slen - 1];
        
    }
}