public class DoubleHashing extends Hashtable {
    public DoubleHashing(int size) {
        super(size);
    }

    @Override
        protected int probe(int keyHash, int attempt) {
        long startIndex;
        long step;
        startIndex = Math.floorMod(primaryHash(keyHash), size);
        step = secondaryHash(keyHash);
        return (int) Math.floorMod(startIndex + attempt * step, size);
    }
    protected int primaryHash(int keyHash) {
        return Math.floorMod(keyHash, size);
    }

    protected int secondaryHash(int keyHash) {
        return 1 + Math.floorMod(keyHash, size - 2);
    }

}
