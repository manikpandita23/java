import java.util.HashMap;
public class HashMapLoadFactor {
    public static void main(String[] args) {
        int initialCapacity = 4;
        float loadFactor = 0.75f;
        HashMap<String, Integer> map = new HashMap<>(initialCapacity, loadFactor);
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        System.out.println("HashMap :" +map);
        System.out.println("Size of HashMap:"+map.size());
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        System.out.println("HashMap after more additions: " + map);
        System.out.println("Size of HashMap after more additions: " + map.size());
        }
    
}
