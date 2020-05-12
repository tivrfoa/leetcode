import java.util.*;

class LRUCache {
    
    public static void main(String args[]) {
        
    }

    LinkedList<Integer> leastUsedList = new LinkedList<>();
    HashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(this.capacity);
    }

    public int get(int k) {
        Integer v = map.get(k);
        if (v == null) return -1;
        leastUsedList.remove(Integer.valueOf(k));
        leastUsedList.add(k);
        return v;
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) { // just replace value
            map.put(k, v);
            leastUsedList.remove(Integer.valueOf(k));
            leastUsedList.add(k);
            return;
        }
        if (leastUsedList.size() == capacity) {
            map.remove(leastUsedList.remove(0));
        }
        map.put(k, v);
        leastUsedList.add(k);
    }
}

