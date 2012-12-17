public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int hlen = haystack.length(), nlen = needle.length();
        if (hlen < nlen) return null;
        if (nlen == 0) return haystack;
        for (int i = 0; i < hlen - nlen + 1; i++) {
            boolean match = true;
            for (int j = 0; j < nlen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}