public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int bits = 0;
        int cur;
        String result = "";
        String table[][] = {{"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", ""}};
        while (num != 0) {
            cur = num % 10;
            if (cur >= 1 && cur < 4) {
                for (int i = 0; i < cur; i++) {
                    result = table[bits][0] + result;
                }
            } else if (cur == 5) {
                result = table[bits][1] + result;
            } else if (cur == 4) {
                result = table[bits][0] + table[bits][1] + result;                
            } else if (cur > 5 && cur < 9) {
                for (int i = 5; i < cur; i++) {
                    result = table[bits][0] + result;
                }
                result = table[bits][1] + result;
            } else if (cur == 9) {
                result = table[bits][0] + table[bits + 1][0] + result;
            } 
            num /= 10;
            bits++;
        }
        return result;
    }
}