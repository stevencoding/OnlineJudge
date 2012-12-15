public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        if (len == 0) return 1;
        int des, tmp;
        for (int i = 0; i < len; i++) {
            if (A[i] <= 0 || A[i] > len || A[i] == i + 1) continue;
            des = A[i] - 1;
            A[i] = -1;
            while (A[des] > 0 && A[des] < len && A[des] != des + 1) {
                tmp = A[des] - 1;
                A[des] = des + 1;
                des = tmp;
            }
            A[des] = des + 1;
        }
        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}