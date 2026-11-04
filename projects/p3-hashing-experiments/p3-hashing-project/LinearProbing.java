public class LinearProbing extends Hashtable {

    public LinearProbing(int size) {
        super(size);
    }

    @Override
    protected int probe(int keyHash, int attempt) {
        int startIndex;
        startIndex = Math.floorMod(keyHash, size);
        return Math.floorMod(startIndex + attempt, size);

    }
}
