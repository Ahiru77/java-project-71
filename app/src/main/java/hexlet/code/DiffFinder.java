package hexlet.code;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class DiffFinder {
    public static ArrayList<HashMap<String, Object>> findDiff(Map<String, Object> map1,
                                                         Map<String, Object> map2) throws Exception {
        var differs = new ArrayList<HashMap<String, Object>>();
        var keys = getKeys(map1, map2);
        for (String key : keys) {
            var map = new HashMap<String, Object>();
            var val1 = map1.get(key);
            var val2 = map2.get(key);
            if (val1 == null && !map1.containsKey(key)) {
                map.put("key", key);
                map.put("status", "added");
                map.put("new value", val2);
            } else if (val2 == null && !map2.containsKey(key)) {
                map.put("key", key);
                map.put("status", "deleted");
                map.put("value", val1);
            } else if (!Objects.equals(val1, val2)) {
                map.put("key", key);
                map.put("status", "modified");
                map.put("value", val1);
                map.put("new value", val2);
            } else if (Objects.equals(val1, val2)) {
                map.put("key", key);
                map.put("status", "unchanged");
                map.put("value", val1);
            }
            differs.add(map);
        }
        return differs;
    }

    public static ArrayList<String> getKeys(Map<String, Object> map1, Map<String, Object> map2) {
        var map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.putAll(map1);
        map.putAll(map2);
        return new ArrayList<String>(map.keySet());
    }
}

