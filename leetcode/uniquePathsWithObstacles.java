public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = obstacleGrid.length;
        if (height == 0) return 0;
        int width = obstacleGrid[0].length;
        int sol[][] = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) sol[i][j] = obstacleGrid[i][j] == 0 ? 1 : 0; // sol[i][j] = 0 if obstacleGrid[i][j] = 1
                else {
                    sol[i][j] = obstacleGrid[i][j] == 0 ? ((i - 1 >= 0 && obstacleGrid[i - 1][j] == 0) ? sol[i - 1][j] : 0)
			+ ((j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) ? sol[i][j - 1] : 0) : 0;
                }
            }
        }
        return sol[height - 1][width - 1];
    }
}