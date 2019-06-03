/**
 * Minimum Sum PathGiven an m x n matrix filled with non-negative integers, find the minimum sum along a path from the top-left of the grid to the bottom-right which minimizes the sum of all numbers along it. Return this minimum sum. The direction of movement is limited to right and down.
 * Example:
 * <p>
 * Input Matrix :
 * <p>
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * <p>
 * Output  : 21
 */
public class MinimumSumPath {

    public static int minWeightedPath(int[][] grid) {

        int[][] arr = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int current = grid[i][j];
                int minPreviousValue = 0;
                if (i > 0 && j > 0) {
                    minPreviousValue = Math.min(arr[i - 1][j], arr[i][j - 1]);
                } else if (j > 0) {
                    minPreviousValue = arr[i][j - 1];
                } else if (i > 0) {
                    minPreviousValue = arr[i - 1][j];
                }

                arr[i][j] = current + minPreviousValue;


            }
        }


        return arr[arr.length - 1][arr[0].length - 1];
    }
}
