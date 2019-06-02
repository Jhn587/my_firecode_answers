import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void testLongestPalindrome(){
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        String bccb = longestPalindrome.longestPalSubstr("bccb");
        assertEquals("bccb", bccb);

        String cc = longestPalindrome.longestPalSubstr("bccd");
        assertEquals("cc", cc);

        String bccc = longestPalindrome.longestPalSubstr("bccc");
        assertEquals("ccc", bccc);
    }

}