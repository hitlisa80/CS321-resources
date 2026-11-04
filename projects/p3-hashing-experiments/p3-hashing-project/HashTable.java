abstract class Hashtable {
    protected HashObject[] table;
    protected int size;
    protected int count;
    

    public Hashtable(int size) {
        this.size = size;
        this.count = 0;
        this.table = new HashObject[size];
    }

    protected abstract int probe(int keyHash, int attempt);


    public void insert(HashObject obj) {
               int index;               
               for (int attempt = 0; attempt < size; attempt++) {
               index = probe(obj.getKey().hashCode(), attempt);
               obj.increaseProbeCount();
               if (table[index] == null) {
                   table[index] = obj;
                   count++;                   
                   return;
               }
               else if (table[index].getKey().equals(obj.getKey())) {
                       table[index].increaseFrequency();
                       return;
               }
           }
           throw new RuntimeException("Table is full");
        }
    }
