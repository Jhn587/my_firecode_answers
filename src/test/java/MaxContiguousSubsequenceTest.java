import org.junit.Test;

import static org.junit.Assert.*;

public class MaxContiguousSubsequenceTest {

    @Test
    public void maxContSequence() {
        int[] result = MaxContiguousSubsequence.maxContSequence(new int[]{-1,30,-4,20,20,-11});
        assertTrue(compare(new int[]{66,1,4}, result));

        int[] resultTwo = MaxContiguousSubsequence.maxContSequence(new int[]{-1,-2,-3,-4,-5,-6});
        assertTrue(compare(new int[]{-1,0,0}, resultTwo));

        int[] resultThree = MaxContiguousSubsequence.maxContSequence(new int[]{});
        assertTrue(compare(new int[]{0,0,-1}, resultThree));
        int[] resultFour = MaxContiguousSubsequence.maxContSequence(new int[]{1,2,3,-2,5});
        assertTrue(compare(new int[]{9, 0, 4}, resultFour));

    }

    private boolean compare(int[] ints, int[] result) {

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != result[i]) {
                return false;
            }

        }
        return true;
    }
}