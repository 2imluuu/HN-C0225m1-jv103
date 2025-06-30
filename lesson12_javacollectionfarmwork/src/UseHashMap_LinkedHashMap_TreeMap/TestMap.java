package UseHashMap_LinkedHashMap_TreeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;
public class TestMap {
    public static void main(String[] args) {
        Map< String, Integer > hashMap = new HashMap< >();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in Map");
        System.out.println(hashMap + "\n");

        Map<String, Integer > treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap + "\n");

        Map < String, Integer > linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println(" The age of Lewis is " + linkedHashMap.get("Lewis"));
    }
}
