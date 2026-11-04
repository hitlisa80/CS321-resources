
public class HashObject {
    private Object key;
    private int frequency;
    private int probeCount;

    public HashObject(Object key) {
        this.key = key;
        this.frequency = 1;
        this.probeCount = 0;


    }

    public Object getKey() {
        return key;
    }

    public void increaseFrequency() {
        this.frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    public void increaseProbeCount() {
        this.probeCount++;
    }

    public int getProbeCount() {
        return probeCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HashObject other = (HashObject) obj;
        return key != null ? key.equals(other.key) : other.key == null;
    }
    @Override 
    public String toString() {
        return (key + " " + frequency + " " + probeCount);
    }
}
