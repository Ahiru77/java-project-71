package hexlet.code.formatters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Format {
    String format(ArrayList<HashMap<String, Object>> diffMap) throws IOException;
}
