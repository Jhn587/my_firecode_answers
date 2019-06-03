import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSumPathTest {

    @Test
    public void minWeightedPath() {
        int[][] inputs = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = MinimumSumPath.minWeightedPath(inputs);
        assertEquals(21, result);

    }
}