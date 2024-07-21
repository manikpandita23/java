import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LinkedHashMapPosition {
    static LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
    static {
        linkedHashMap.put("apple", 10);
        linkedHashMap.put("orange", 20);
        linkedHashMap.put("banana", 15);
    }
    public static int getPositionByKeyUsingIteration(String key) {
        int position = 0;
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                return position;
            }
            position++;
        }
        return -1; 
    }
    public static int getPositionByKeyUsingStreams(String key) {
        Optional<String> keyOptional = linkedHashMap.keySet().stream()
            .filter(k -> Objects.equals(k, key))
            .findFirst();
        return keyOptional.map(s -> new LinkedList<>(linkedHashMap.keySet()).indexOf(s)).orElse(-1); // Key not found
    }
    public static void main(String[] args) {
        String keyToFind = "orange";
        int positionUsingIteration = getPositionByKeyUsingIteration(keyToFind);
        System.out.println("Position of key \"" + keyToFind + "\" using iteration: " + positionUsingIteration);
        int positionUsingStreams = getPositionByKeyUsingStreams(keyToFind);
        System.out.println("Position of key \"" + keyToFind + "\" using streams: " + positionUsingStreams);
    }
}
