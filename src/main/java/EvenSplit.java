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
        return sumHelper(arr, 0, 0, 0);

    }

    private static boolean sumHelper(int[] arr, int leftSum, int rightSum, int index) {
        if (index >= arr.length) {
            return leftSum == rightSum;
        }

        return sumHelper(arr, leftSum + arr[index], rightSum, index + 1)
                || sumHelper(arr, leftSum, rightSum + arr[index], index + 1);
    }
}
