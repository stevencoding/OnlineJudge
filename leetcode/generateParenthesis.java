public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        helper(n, "(", 1, result);
        return result;
    }
    private void helper(int n, String s, int score, ArrayList<String> result) {
        if (n == 0) return;
        int len = s.length();
        if (len == n * 2) {
            if (score == 0) result.add(s);
            return;
        }
        String types[] = {"(", ")"};
        for (String type : types) {
            String newStr = s + type;
            int newScore = score;
            if (type.equals("(")) newScore += 1;
            else newScore -= 1;
            if (score >= 0) {
                helper(n, newStr, newScore, result);
            }
        }
    }
}