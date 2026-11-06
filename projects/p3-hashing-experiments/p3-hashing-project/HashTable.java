import java.io.PrintWriter;
import java.io.FileNotFoundException;

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

        public int getCount() {
            return count;
        }

        public double getAverageProbes() {
            int totalProbes = 0;
            for (HashObject obj : table) {
                if (obj != null) {
                    totalProbes += obj.getProbeCount();
                }
            }
            return (double) totalProbes / count;
        }

        public void dumpToFile(String filename) {
            try (PrintWriter writer = new PrintWriter(filename)) {
                for (int index = 0; index < table.length; index++) {
                    if (table[index] != null) {
                        writer.println("table[" + index + "]: " + table[index].getKey() + " " + table[index].getFrequency() + " " + table[index].getProbeCount());
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            
        }
            }
        