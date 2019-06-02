/**
 * Find the Maximum Contiguous Subsequence in an Array
 * Given an array of integers consisting of both positive and negative
 * numbers, find the contiguous subsequence that has the maximum sum among all subsequences in the array (click the red text to learn more about subsequences). Write a method that takes in
 * an array of integers arr and returns an array res containing 3 integers in the following format:
 * <p>
 * res[0] = max sum
 * res[1] = starting index of the subsequence
 * res[2] = ending index of the subsequence
 * <p>
 * <p>
 * Examples:
 * <p>
 * maxContSequence({-1,-2,3,4,5}) ==> {12,2,4}
 * <p>
 * maxContSequence({1,2,3,-2,5}) ==> {6,0,2}
 * They list that answer, but i believe it's 9, 0, 4
 */
public class MaxContiguousSubsequence {
    public static int[] maxContSequence(int[] arr) {
        if (arr.length == 0) {
            return new int[]{0, 0, -1};
        }
        int maxSum = -9999;
        int maxStart = 0;
        int maxEnd = 0;
        int currentSum = 0;
        int currentStart = 0;
        for (int i = 0; i < arr.length; i++) {
            if(currentSum < 0){
                currentSum = 0;
                currentStart = i;
            }
            int currentNumber = arr[i];
            if(currentSum + currentNumber < 0){
                if(currentSum + currentNumber > maxSum){
                    maxSum = currentSum + currentNumber;
                    maxStart = currentStart;
                    maxEnd = i;
                }
                currentSum = currentNumber;
                currentStart = i;
            } else {
                if(currentSum + currentNumber >= maxSum){
                    maxSum = currentSum + currentNumber;
                    maxStart = currentStart;
                    maxEnd = i;
                }
                currentSum += currentNumber;
            }

        }
        return new int[]{maxSum, maxStart, maxEnd};


    }
}
