import java.util.HashMap;
public class HashMapExample 
{
    public static void main(String[] args) 
    {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("john", 10);
        map.put("jane", 30);
        map.put("alice", 20);
        System.out.println("Size of map is: " + map.size());
        System.out.println(map);
        if (map.containsKey("john")) 
        {
            Integer a = map.get("john");
            System.out.println("value for key \"john\" is: " + a);
        }
    }
}
