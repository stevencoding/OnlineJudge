public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len == 0) return 0;
        int sol[] = new int[len];
        sol[0] = s.charAt(0) - '0' == 0 ? 0 : 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') {
                sol[i] = sol[i - 1];
            }
            if (s.charAt(i - 1) > '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                sol[i] += i - 2 >= 0 ? sol[i - 2] : 1;
            }
        }
        return sol[len - 1];
    }
}