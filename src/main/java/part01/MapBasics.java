package part01;

import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates the basic operations of a Map. Implement each method
 * in this class. You may assume that all given keys and values are non-null.
 *
 * Do not change the method signatures or fields, as these will be used by the
 * automated tests.
 *
 * Resources:
 * https://dev.java/learn/api/collections-framework/working-with-keys-and-values/
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html
 * https://doc.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html
 */
public class MapBasics {

    /**
     * Create and return a new Map that maps String keys to String values.
     */
    public Map<String, String> createMap() {

        return new HashMap<String, String>();

    }

        // Hint: you can not instantiate a Map directly, but you can instantiate a class
        // that *implements* the Map interface.

    /**
     * Add the given key/value pair to the given map.
     */
    public void addEntry(Map<String, String> map, String key, String value) {
        // Hint: use the put method
        map.put(key,value);
    }

    /**

     * Returns a map that maps the names of the Nordic countries to their
     * populations. The countries and their populations are:
     *
     * Denmark 5 894 687
     * Finland 5 587 442
     * Iceland 354 234
     * Norway 5 509 591
     * Sweden 10 261 767
     *
     * Source: https://en.wikipedia.org/wiki/Nordic_countries, 9.8.2023
     */
    public Map<String, Integer> getPopulations() {
       Map<String, Integer> populations = new HashMap<>();
       populations.put("Denmark", 5894687);
       populations.put("Finland", 5587442);
       populations.put("Iceland", 354234);
       populations.put("Norway", 5509591);
       populations.put("Sweden", 10261767);
       
        // Hint: Make sure to write the names of the countries exactly as they are
        // written above, otherwise the tests will fail.
        return populations;
    }

    /**
     * Return the value associated with the given key in the given map. If the key
     * is not in the map, return null.
     */
    public String getValue(Map<String, String> map, String key) {
        // Hint: use the get method
        return map.get(key);
    }

    /**
     * Return true if the given map contains the given key, false otherwise.
     */
    public boolean hasKey(Map<String, String> map, String key) {
        // Hint: see the resources above for a method that does this and the rest of
        // the methods below
        return map.containsKey(key);
    }

    /**
     * Return true if the given map contains the given value, false otherwise.
     */
    public boolean hasValue(Map<String, String> map, String value) {
        return map.containsValue(value);
    }

    /**
     * Add the given key/value pair to the given map if the key is not already in
     * the map.
     */
    public void addIfNotPresent(Map<String, String> map, String key, String value) {


    if (!map.containsKey(key)) {
            map.put(key, value);
        }
    }   

    /**
     * Remove the entry with the given key from the given map.
     *
     * @param map the map to remove the entry from
     * @param key the key of the entry to remove
     */
    public void removeEntry(Map<String, String> map, String key) {
        map.remove(key);
    }

    /**
     * Return the number of entries (key/value pairs) in the given map.
     *
     * @param map the map to count the entries in
     * @return the number of entries in the map
     */
    public int countEntries(Map<String, String> map) {
        return map.size();
    }

    /**
     * Return true if the given map is empty, false otherwise.
     */
    public boolean isEmpty(Map<String, String> map) {
        return map.isEmpty();
    }

    /**
     * Return the largest Integer value in the map. If the map is empty, return
     * null.
     */
    public Integer largestValue(Map<String, Integer> map) {
       if (map.isEmpty()) {
            return null;
        }

        Integer max = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Return the sum of all the Integer values in the map. If the map is empty,
     * return 0.
     */
    public int sumOfValues(Map<String, Integer> map) {
        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
        }
        return sum;
    }

    /**
     * Combines the two maps into a single map. If a key is in both maps, the value
     * from the first map is used.
     *
     * The method must create and return a new map. Neither of the two given
     * maps should be modified.
     */
    public Map<String, String> combineMaps(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> combinedMap = new HashMap<>(map1);  // Start with all entries from map1
    for (Map.Entry<String, String> entry : map2.entrySet()) {
        combinedMap.putIfAbsent(entry.getKey(), entry.getValue());  // Add entries from map2 only if the key isn't already in combinedMap
    }
    return combinedMap;
}

    /**
     * Increments all the values in the given map by the given amount. This method
     * should modify the given map, not create a new one.
     */
    public void incrementValues(Map<String, Integer> map, int amount) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            entry.setValue(entry.getValue() + amount);
        }
    }
}
