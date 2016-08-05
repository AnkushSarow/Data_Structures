/**
 * Created by AnkushSarow on 8/4/16.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void testHashMap_Constructor() {
        HashMap<Integer, Integer> map = new HashMap<>();

        assertTrue(map.isEmpty());
        assertEquals(0, map.getSize());
        assertEquals(16, map.getTableSize());

        HashMap<Integer, Integer> map2 = new HashMap<>(97);
        assertTrue(map2.isEmpty());
        assertEquals(0, map2.getSize());
        assertEquals(97, map2.getTableSize());
    }

    @Test
    public void testPut() {
        HashMap<Integer, Integer> map = new HashMap<>(32);

        map.put(100, 1);
        assertFalse(map.isEmpty());
        assertEquals(1, map.getSize());
        assertTrue(map.contains(100));

        map.put(39,2);
        assertEquals(2, map.getSize());
        assertTrue(map.contains(39));

        map.put(20, 2);
        assertEquals(3, map.getSize());
        assertTrue(map.contains(20));

        map.put(100, 4);
        assertEquals(3, map.getSize());
        assertTrue(map.contains(100));

        map.put(102,7);
        assertEquals(4, map.getSize());
        assertTrue(map.contains(102));

        map.put(null,null);
        assertEquals(5, map.getSize());
        assertTrue(map.contains(null));
        map.put(null,null); //should not be added, only one null key allowed
        assertEquals(5, map.getSize());

        map.put(100, 5);
        assertEquals(5, map.getSize());
        assertTrue(map.contains(100));

        map.put(13, 9);
        assertEquals(6, map.getSize());
        assertTrue(map.contains(13));

    }

    @Test
    public void testGet() {
        HashMap<Integer, Integer> map = new HashMap<>(16);

        map.put(10, 1);
        map.put(null,null);
        map.put(13, 2);
        map.put(15, 3);
        map.put(16, 5);
        assertEquals(1, (int) map.get(10));
        assertEquals(2, (int) map.get(13));
        assertEquals(3, (int) map.get(15));
        assertEquals(null, map.get(null));
        map.put(null, 0);
        assertEquals(0, (int) map.get(null));
        map.put(10,2);
        assertEquals(2, (int) map.get(10));
    }

    @Test
    public void testRemove() {
        HashMap<Integer, Integer> map = new HashMap<>(11);

        assertEquals(null, map.remove(5));

        map.put(null, null);
        assertEquals(1, map.getSize());
        map.remove(null);
        assertEquals(0, map.getSize());
        assertFalse(map.contains(null));

        map.put(10, 1);
        map.put(10, 3);
        map.remove(10);
        assertEquals(0, map.getSize());
        assertTrue(map.isEmpty());
        assertFalse(map.contains(10));
        assertEquals(null, map.get(10));

        map.put(11, 2);
        map.put(null, null);
        map.remove(11);
        assertEquals(1, map.getSize());
        assertFalse(map.contains(11));
        assertEquals(null, map.get(11));
        map.remove(null);
        assertTrue(map.isEmpty());
        assertFalse(map.contains(null));

        map.put(5, 2);
        map.put(7, 4);
        map.put(4, 3);
        assertEquals(3, map.getSize());
        map.remove(4);
        map.remove(5);
        map.remove(7);
        assertEquals(0, map.getSize());
        assertTrue(map.isEmpty());
        assertFalse(map.contains(5));
        assertFalse(map.contains(7));
        assertFalse(map.contains(4));
    }

    @Test
    public void testInsert_withResize() {
        HashMap<Integer, Integer> map = new HashMap<>(8);

        map.put(1, 10);
        map.put(2, 13);
        map.put(null,null);
        map.put(13, 16);
        map.put(7, 23);
        assertEquals(5, map.getSize());

        //After this put, the map resizes to 16
        map.put(6, 34);
        assertEquals(6, map.getSize());
        assertEquals(16, map.getTableSize());
        assertFalse(map.isEmpty());
        assertTrue(map.contains(6));
        assertTrue(map.contains(1));
        assertTrue(map.contains(null));
        assertTrue(map.contains(2));
        assertTrue(map.contains(13));
        assertTrue(map.contains(7));
    }
}