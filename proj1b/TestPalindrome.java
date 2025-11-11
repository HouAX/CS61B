import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("afernoon"));
        assertFalse(palindrome.isPalindrome("Aooa"));
    }

    @Test
    public void testisPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("%&", offByOne));
        assertFalse(palindrome.isPalindrome("&aa%", offByOne));
    }
}
