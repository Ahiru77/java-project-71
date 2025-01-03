package hexlet.code.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String file, String extension) throws IOException {
        return switch (extension) {
            case "json" -> parseJson(file);
            case "yml" -> parseYml(file);
            case "yaml" -> parseYml(file);
            default -> parseJson(file);
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
