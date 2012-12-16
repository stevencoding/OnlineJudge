public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
	// see http://en.wikipedia.org/wiki/File:Binary-reflected_Gray_code_construction.svg
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if (n > 0) {
            result.add(1);
            for (int bits = 1; bits < n; bits++) {
                for (int i = result.size() - 1; i >= 0; i--) {
                    result.add((1 << bits) | result.get(i));
                }
            }            
        }
        return result;
    }
}
