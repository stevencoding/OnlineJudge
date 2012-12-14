// Integer溢出的血与泪！
public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long l1 = (long)dividend, l2 = (long)divisor;
        int sig = 1;
        if (l1 < 0) {
            l1 = -l1;
            sig = -sig;
        }
        if (l2 < 0) {
            l2 = -l2;
            sig = -sig;
        }
        if (l1 < l2) return 0;
        if (l1 == l2) return sig;
        long r = 1;
        while (l1 > l2) {
            l2 <<= 1;
            r <<= 1;
        }
        if (l1 == l2) return sig > 0 ? (int)r : (int)(-r);
        else {
            r >>= 1;
            l2 >>= 1;
            long res2 = divide((int)(l1 - l2), divisor);
            if (res2 < 0) res2 = -res2;
            long res1 = r + res2;
            int result = (int)res1;
            return sig > 0 ? result : -result;
        }
    }
}
