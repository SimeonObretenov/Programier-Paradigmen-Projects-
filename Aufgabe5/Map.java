package Aufgabe5;
/**
 * A map that associates two objects.
 */
public class Map<P, T> {
    private SinglyLinkedList<P> keys = new SinglyLinkedList<>();
    private SinglyLinkedList<T> values = new SinglyLinkedList<>();
    private int size = 0;

    /**
     * Adds a new key-value association to this map.If the key already exists in this map,
     * the value is replaced
     *
     * Design by Contract (DbC):
     * - Precondition: 'key' must not be null.
     * - Precondition: 'value' must not be null.
     *
     * @param key a key in the map
     * @param value an object to be associated with the key
     */
    public void put(P key, T value) {
        // put new key-value pair directly if the map is empty
        if (this.size == 0) {
            this.keys.addFirst(key);
            this.values.addFirst(value);
            this.size++;
            return;
        }

        // change the value if the key already exists
        for (int i = 0; i < this.size; i++) {
            if (this.keys.get(i) == key) {
                this.keys.remove(i);
                this.keys.addLast(key);
                this.values.remove(i);
                this.values.addLast(value);
                return;
            }
        }

        this.keys.addLast(key);
        this.values.addLast(value);
        size++;
    }

    /**
     * Returns the value associated with the specified key. Returns 'null' if the key is not contained in this map.
     *
     * Design by Contract (DbC):
     * - Precondition: 'key' must not be null.
     * - Postcondition: Returns a value associated with a specified key
     * - Postcondition: Returns null if the key does not exist in the map
     *
     * @param key a key in the map
     * @return the value associated with a specified key
     */
    public T get(P key) {
        for(int i = 0; i < this.size; i++) {
            if (this.keys.get(i) == key) {
                return this.values.get(i);
            }
        }
        return null;
    }

}
