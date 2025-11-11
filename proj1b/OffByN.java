public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int i) {
        this.N = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == N) {
            return true;
        } else {
            return false;
        }
    }
}
