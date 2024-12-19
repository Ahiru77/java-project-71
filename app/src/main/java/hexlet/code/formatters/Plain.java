package hexlet.code.formatters;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;

public class Plain implements Format {
    public final String format(List<HashMap<String, Object>> diff) {
        final String add = "\nProperty '%s' was added with value: %s";
        final String del = "\nProperty '%s' was removed";
        final String mod = "\nProperty '%s' was updated. From %s to %s";
        String result = "";
        for (int i = 0; i < diff.size(); i++) {
            var item = diff.get(i);
            var key = item.get("key");
            var status = String.valueOf(item.get("status"));
            var val1 = defType(item.get("value"));
            var val2 = defType(item.get("new value"));
            if (status.equals("added")) {
                result = result.concat(String.format(add, key, val2));
            } else if (status.equals("deleted")) {
                result = result.concat(String.format(del, key));
            } else if (status.equals("modified")) {
                result = result.concat(String.format(mod, key, val1, val2));
            }
        }
        return result.trim();
    }

    public static String defType(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (!ClassUtils.isPrimitiveOrWrapper(value.getClass())) {
            return "[complex value]";
        }
        return value.toString();
    }

}
