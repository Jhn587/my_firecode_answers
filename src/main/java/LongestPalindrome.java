/**
 * Longest Palindromic Substring New
 * Multi Dimensional Arrays Dynamic Programming
 * <p>
 * Given a String, write a method - longestPalSubstr that finds and returns the longest substring which is also a Palindrome. Try and accomplish this in at most O(n2) runtime.
 * <p>
 * Examples :
 * "bccb" => "bccb"
 * "bccd" => "cc"
 * "bccc" => "ccc"
 */
public class LongestPalindrome {

    public String longestPalSubstr(String str) {
        if(str == null || str.isEmpty()){
            return "";
        }
        int[][] a = new int[str.length()][str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (i < str.length() - 1 && j > 0) {
                        int prev = a[i + 1][j - 1];
                        a[i][j] = prev + 1;

                    } else {
                        a[i][j] = 1;
                    }
                }
            }
        }

//        print2dArray(a);

        int maxNumber = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > maxNumber) {
                    maxNumber = a[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        StringBuilder builder = new StringBuilder(str);
        return builder.substring(maxRow, maxCol + 1);
    }

    private void print2dArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
