package hexlet.code.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String dataToValid, String formatToProcess) throws IOException {
        return switch (formatToProcess) {
            case "json" -> parseJson(dataToValid);
            case "yml" -> parseYml(dataToValid);
            case "yaml" -> parseYml(dataToValid);
            default -> throw new RuntimeException("Unknown format: " + formatToProcess);
        };
    }
    public static Map<String, Object> parseYml(String data) throws IOException {
        YAMLMapper mapper = new YAMLMapper();
        return mapper.readValue(data, new TypeReference<>() { });
    }

    public static Map<String, Object> parseJson(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(data, new TypeReference<>() { });
    }

}
