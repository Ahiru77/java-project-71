package hexlet.code.formatters;

import java.util.HashMap;
import java.util.List;

public class Stylish implements Format {
    public final String format(List<HashMap<String, Object>> diffMap) {
        final String format = "\n  %s %s: %s";
        String result = "";
        for (int i = 0; i < diffMap.size(); i++) {
            var item = diffMap.get(i);
            var key = item.get("key");
            String status = String.valueOf(item.get("status"));
            var val1 = item.get("value");
            var val2 = item.get("new value");
            if (status.equals("added")) {
                result = result.concat(String.format(format, "+", key, val2));
            } else if (status.equals("deleted")) {
                result = result.concat(String.format(format, "-", key, val1));
            } else if (status.equals("modified")) {
                result = result.concat(String.format(format, "-", key, val1));
                result = result.concat(String.format(format, "+", key, val2));
            } else if (status.equals("unchanged")) {
                result = result.concat(String.format(format, " ", key, val1));
            }
        }
        return "{\n" + "    " + result.trim() + "\n}";
    }
}
