abstract class HashTable {
    protected HashObject[] table;
    protected int size;
    protected int count;
    

    public HashTable(int size) {
        this.size = size;
        this.count = 0;
        this.table = new HashObject[size];
    }


    public void insert(HashObject obj) {
        int index = kmodm;
        if (table[index] == null) {
            table[index] = obj;
            count++;
        }
        if (table[index] != null) {
            //Check if the key at index is the same
            if (table[index].getKey().equals(obj.getKey())) {
                table[index] = obj; // Update the existing entry
                count++;
            }
            else {
                //Calculate the next probe index

        }
    }
}
