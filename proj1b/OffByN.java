public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int i) {
        this.N = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }
}
