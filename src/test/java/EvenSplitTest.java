import org.junit.Test;

import static org.junit.Assert.*;

public class EvenSplitTest {

    @Test
    public void splitArray() {
        boolean result = EvenSplit.splitArray(new int[]{1, 2, 3, 4});
        assertTrue(result);
        result = EvenSplit.splitArray(new int[]{1, 2, 4});
        assertFalse(result);
    }
}