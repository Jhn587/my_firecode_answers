import java.util.Arrays;

/**
 * Even Split
 * Given an array of integers, determine if it is possible to split
 * the array into two parts such that the sum of all elements in each part is the same.
 * <p>
 * Examples:
 * <p>
 * splitArray({1,2,3,4}) ==> true
 * splitArray({1,2,4}) ==> false
 */
public class EvenSplit {
    public static boolean splitArray(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
//        return sumHelper(arr, 0, 0, 0);
        return sumHelperDynamicProgramming(arr);
    }

    //looks like we can do this through dynamic programming
    //  find out what the sum of the array is
    //  if odd
    //     return false
    //  if even
    //     see if you can find a subset that sums to that number
    private static boolean sumHelperDynamicProgramming(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int numberToFind = sum / 2;

        boolean[][] a = new boolean[sum / 2 + 1][arr.length];
        for (int i = 0; i <= numberToFind; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > i) {
                    if (j > 0) {
                        a[i][j] = a[i][j - 1];
                    } else {
                        a[i][j] = false;
                    }
                } else if (arr[j] == i) {
                    a[i][j] = true;
                } else if (arr[j] < i) {
                    if (j > 0) {
                        int difference = i - arr[j];
                        boolean differenceIsSummable = a[difference][j - 1];//it's j-1 bc we can't be using j
                        a[i][j] = differenceIsSummable;
                    } else {
                        a[i][j] = false;
                    }
                }
            }
        }
        return a[numberToFind][arr.length - 1];
    }

    /**
     * o(n^2) runtimes
     */
    private static boolean sumHelper(int[] arr, int leftSum, int rightSum, int index) {
        if (index >= arr.length) {
            return leftSum == rightSum;
        }

        return sumHelper(arr, leftSum + arr[index], rightSum, index + 1)
                || sumHelper(arr, leftSum, rightSum + arr[index], index + 1);
    }
}
