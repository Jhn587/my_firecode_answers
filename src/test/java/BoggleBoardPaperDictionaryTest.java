import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BoggleBoardPaperDictionaryTest {

    @Test
    public void boggleByot() {
// * {
// * {A, O, L},
// * {D, E, L},
// * {G, H, I},
// * }
// * Dictionary : [HELLO, HOW, ARE, YOU] (as a Trie)
// * Output: [HELLO]
        BoggleBoardPaperDictionary boggle = new BoggleBoardPaperDictionary();
        List<String> strings = Arrays.asList("HELLO", "HOW", "ARE", "YOU");
        ArrayList<String> result = boggle.boggleByot(new char[][]{
                {'A', 'O', 'L'},
                {'D', 'E', 'L'},
                {'G', 'H', 'I'},

        }, new ArrayList<>(strings));

        assertEquals(Collections.singletonList("HELLO"), result);
    }
}