import java.util.*;
import java.util.stream.Collectors;

/**
 * Subset Summation with Number Constraint
 * Given an array of integers and a target integer, write a method groupSumWithNum
 * to determine if it is possible to choose a group of integers from the array such
 * that the group sums to the given target. An additional constraint is that the
 * summation must include the integer must_have if it is present in the array.
 * <p>
 * Examples:
 * groupSumWithNum({1,2,3,6,5},5,10) ==> true
 * <p>
 * groupSumWithNum({1,2,3,6,5},3,7) ==> false
 */
public class SubsetSumWithConstraint {
    public static boolean groupSumWithNum(int[] arr, int must_have, int target) {
        if (arr.length == 0) {
            return false;
        }
        if (Arrays.stream(arr).anyMatch(a -> a == must_have)) {
            int[] withoutMustHave = removeMustHave(arr, must_have);
            return slowSolution(withoutMustHave, 0, target - must_have);
        }
        return groupSumHelper(arr, target);
    }

    private static boolean slowSolution(int[] withoutMustHave, int i, int target) {
        if (i >= withoutMustHave.length) {
            return false;
        }
        if (withoutMustHave[i] == target) {
            return true;
        }
        boolean b = slowSolution(withoutMustHave, i + 1, target);
        boolean b1 = slowSolution(withoutMustHave, i + 1, target - withoutMustHave[i]);
        return b || b1;
    }

    private static int[] removeMustHave(int[] arr, int must_have) {
        int[] newArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != must_have) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    /**
     * this works on positive numbers only
     */
    private static boolean groupSumHelper(int[] arr, int num) {
        boolean[][] cache = new boolean[num + 1][arr.length];
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    cache[i][j] = true;
                    continue;
                }

                int otherNumber = num - arr[j];
                if (otherNumber <= i && otherNumber > 0 && j > 0) {
                    boolean otherNumberExists = cache[otherNumber][j - 1];
                    cache[i][j] = otherNumberExists;
                } else if (j > 0) {
                    cache[i][j] = cache[i][j - 1];
                } else {
                    cache[i][j] = false;

                }
            }
        }
        return cache[num][arr.length - 1];
    }

    private static boolean groupSumHelperLess(int[] arr, int num) {
        OptionalInt minOptional = Arrays.stream(arr).min();
        int min = minOptional.getAsInt();

        int limit = num + 1 + Math.abs(min);
        boolean[][] cache = new boolean[limit][arr.length];
        for (int i = 0; i < 2; i++) {

            for (int c = 1; c < limit; c++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i) {
                        cache[i][j] = true;
                        continue;
                    }
                    int currentNumber = arr[j];
                    if (currentNumber < 0) {
                        currentNumber = Math.abs(currentNumber);
                        int numberToFind = i + currentNumber;
                        if (numberToFind < limit) {
                            if (j > 0 && cache[numberToFind][j - 1]) {
                                cache[numberToFind][j] = true;
                            }
                            if (j > 0) {
                                cache[numberToFind][j] = cache[numberToFind][j - 1];
                            } else {
                                cache[numberToFind][j] = false;
                            }
                        }

                    } else {
                        int otherNumber = num - arr[j];
                        if (otherNumber <= i && otherNumber > 0 && j > 0) {
                            boolean otherNumberExists = cache[otherNumber][j - 1];
                            cache[i][j] = otherNumberExists;
                        } else if (j > 0) {
                            cache[i][j] = cache[i][j - 1];
                        } else {
                            cache[i][j] = false;

                        }
                    }
                }
            }
        }
        return cache[num][arr.length - 1];
    }

    private static boolean groupSumHelperWithNegatives(int[] arr, int num) {
        Map<Integer, Boolean[]> cache = new HashMap<>();
        int maxToFind = num;
        OptionalInt min = Arrays.stream(arr).min();
        for (int i = min.getAsInt(); i <= num + Math.max(-1 * min.getAsInt(), min.getAsInt()); i++) {
            Boolean[] list = cache.getOrDefault(i, new Boolean[arr.length]);
            cache.put(i, list);
            for (int j = 0; j < arr.length; j++) {
                list[j] = false;
                int currentNumber = arr[j];
                if (currentNumber == i) {
                    list[j] = true;
                }
                int oppositeNumber = i - currentNumber;
                Boolean[] otherList = cache.getOrDefault(oppositeNumber, new Boolean[arr.length]);
                if (j > 0 && otherList[j - 1] != null && otherList[j - 1]) {
                    list[j] = true;
                } else if (j > 0) {
                    list[j] = list[j - 1];
                }
            }
        }
        return cache.get(num)[arr.length - 1];
    }
}
