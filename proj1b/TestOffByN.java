import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testisPalindromeOffBy5() {
        assertTrue(palindrome.isPalindrome("af", offBy5));
        assertFalse(palindrome.isPalindrome("fh", offBy5));
    }
}
