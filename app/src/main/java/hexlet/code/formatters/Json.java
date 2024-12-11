package hexlet.code.formatters;

import java.io.IOException;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Json implements Format {
    public final String format(List<HashMap<String, Object>> diff) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(diff);
    }
}
