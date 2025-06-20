package hexlet.code.formatters;

import java.io.IOException;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json implements Format {
    public final String format(ArrayList<HashMap<String, Object>> diff) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        return mapper.writeValueAsString(diff);
    }
}
