public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    K key;
    V value;

    public Association(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Association<K, V> o) {
        return this.key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}