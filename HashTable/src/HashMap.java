/**
 * Class: HashMap.java
 * Purpose: Practice hash map implementation (One null key allowed) - null values allowed
 */

import java.lang.reflect.Array;

public class HashMap<K,V> {
    private int tableSize; //Number of buckets in the table
    private int size; //Total number of key-value pairs in the table
    //Using an array rather than ArrayList so that I practice using resize to keep the load factor at 0.75
    private Entry[] table;
    private final int DEFAULT_CAPACITY = 16;
    private final double LOAD_FACTOR = 0.75;

    private class Entry {
        private K key;
        private V value;
        private Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public Entry(K key, V value, Entry next, Entry prev) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Empty constructor - set the size to DEFAULT_CAPICTY (16)
     */
    public HashMap() {
        this.tableSize = DEFAULT_CAPACITY;
        this.size = 0;
        table = (Entry[]) Array.newInstance(Entry.class, tableSize);
        initalizeTable();
    }

    /**
     * HashMap constructor - initialize a hash map with a table size equal to the parameter
     *
     * @param tableSize - Size of the table
     */
    public HashMap(int tableSize) {
        if (tableSize < 1) {
            this.tableSize = DEFAULT_CAPACITY;
        } else {
            this.tableSize = tableSize;
        }
        this.size = 0;
        table = (Entry[]) Array.newInstance(Entry.class, tableSize);
        initalizeTable();
    }

    /**
     * Hash function to retrieve the integer index for a Key-Value pair
     *
     * @param key
     * @return - Returns the index to which the key value hashes to. Null keys hash to index 0
     */
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        //Basic hash
        return (key.hashCode() & 0x7fffffff) % this.tableSize;
    }

    /**
     * Place a key-value into the table. If the key is already in the table, the value parameter replaces the old value
     * Otherwise, it is placed at the first position of its index's list (entry[i].next not entry[i])
     * After placing an entry into the table, if the load factor is > 0.75, the resize function will be called.
     *
     * @param key   - Key associated with the value
     * @param value - Value associated with the key
     */
    public void put(K key, V value) {
        int index = hash(key);
        Entry current = table[index];

        if (contains(key)) {
            while (current.next != null) {
                if (current.next.key == null) {
                    if (key == null) {
                        current.next.value = value;
                        return;
                    }
                } else if (current.next.key.equals(key)) {
                    current.next.value = value;
                    return;
                }
                current = current.next;
            }
        }

        Entry entry = new Entry(key, value);
        entry.next = current.next;
        current.next = entry;
        ++size;

        if ((double) size / (double) tableSize >= LOAD_FACTOR) {
            resize();
        }

    }

    /**
     * Removes the key,value pair from the table if it exists in the table
     * @param key - Desired key to be removed
     * @return - Returns the value removed if the key is in the table, if not, returns null
     */
    public V remove(K key) {
        int index = hash(key);
        Entry current = table[index];

        while (current.next != null) {
            if (current.next.key == null) {
                if (key == null) {
                    V value = current.next.value;
                    current.next = current.next.next;
                    --size;
                    return value;
                }
            } else if (current.next.key.equals(key)) {
                V value = current.next.value;
                current.next = current.next.next;
                --size;
                return value;
            }
            current = current.next;
        }
        return null;
    }


    /**
     * Retrieves the value for the specified key
     *
     * @param key - Key associated with the value -
     * @return - Returns the value associated with the specific key if it's in the able. If it is not, returns null.
     */
    public V get(K key) {
        int index = hash(key);
        Entry current = table[index];

        while (current.next != null) {
            if (current.next.key == null) {
                if (key == null) {
                    return current.next.value;
                }
            } else if (current.next.key.equals(key)) {
                return current.next.value;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Checks to see if the key is in the table
     *
     * @param key - Desired key to look up
     * @return Returns true if the key is in the table, false if it is not
     */
    public boolean contains(K key) {
        int index = hash(key);
        Entry current = table[index];

        while (current.next != null) {
            if (current.next.key == null) {
                if (key == null) {
                    return true;
                }
            } else if (current.next.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getTableSize() {
        return tableSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Sets each index in the table to an empty Entry object
     */
    private void initalizeTable() {
        for (int i = 0; i < getTableSize(); ++i) {
            table[i] = new Entry(null,null,null,null);
        }
    }

    /**
     * Resize the table to 2x the size if the load factor is > 0.75 after an insert
     */
    private void resize() {
        //Make a new table with twice the size and initialize it
        Entry[] oldTable = table;
        table = (Entry[]) Array.newInstance(Entry.class, 2 * tableSize);
        tableSize *= 2;
        size = 0;
        initalizeTable();

        for (int i = 0; i < oldTable.length; ++i) {
            Entry current = oldTable[i];
            if (current.next != null) {
                while (current.next != null) {
                    //Place the key-value pairs in this.table from the old table
                    put(current.next.key, current.next.value);
                    current = current.next;
                }
            }
        }
    }
}
