import java.util.ArrayList;

/**
 * Pascal's Triangle
 * Given an input parameter numRows, generate the first numRows number of rows of
 * Pascal's triangle. As a quick refresher - in a Pascal's triangle, each number is equal to the sum of the two directly above it.
 */
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generatePascalTriangle(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        pascalTriangle.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> prevList = pascalTriangle.get(i - 1);
            ArrayList<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for (int j = 1; j < prevList.size(); j++) {
                int currentValue = prevList.get(j) + prevList.get(j - 1);
                nextList.add(currentValue);
            }
            nextList.add(1);
            pascalTriangle.add(nextList);
        }
        return pascalTriangle;
    }
}
