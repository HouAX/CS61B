public class Palindrome {
    /*
     * Returns a Deque where the characters appear in the same order as in the String.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /*
     * Returns true if word is palindrome.
     */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        while (wordDeque.size() > 1) {
            if (wordDeque.removeFirst() != wordDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /** Off by one version. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        while (wordDeque.size() > 1) {
            if (cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
