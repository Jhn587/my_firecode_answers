import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubsetSumWithConstraintTest {

    //groupSumWithNum({1,2,3,6,5},5,10) ==> true
    //groupSumWithNum({1,2,3,6,5},3,7) ==> false
    @Test
    public void groupSumWithNum() {
        boolean result = SubsetSumWithConstraint.groupSumWithNum(new int[]{1, 2, 3, 6, 5}, 5, 10);
        assertTrue(result);
        result = SubsetSumWithConstraint.groupSumWithNum(new int[]{1, 2, 3, 6, 5}, 3, 7);
        assertFalse(result);
    }

    //    Array: {4,6,7,9,10,-11}
//    Must have: 6
//    Target sum: 12
    @Test
    public void otherGroupSumWithNum() {
        boolean result = SubsetSumWithConstraint.groupSumWithNum(new int[]{4,6,7,9,10,-11}, 6, 12);
        assertTrue(result);
    }
}