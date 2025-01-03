package hexlet.code;
import hexlet.code.formatters.Formatter;
import hexlet.code.parsers.Parser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        var diffRes = DiffFinder.findDiff(prepData(path1), prepData(path2));
        return Formatter.pick(format).format(diffRes);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static Map<String, Object> prepData(String path) throws Exception {
        Path pathNorm = Paths.get(path).toAbsolutePath().normalize();
        var data = Files.readString(pathNorm);
        String extension = null;
        if (path == null) {
            throw new Exception("Path is empty");
        }
        int dotIndex = path.lastIndexOf(".");
        if (dotIndex >= 0) {
            extension = path.substring(dotIndex + 1);
        } else {
            throw new Exception("File extension is unidentified.");
        }
        return Parser.parse(data, extension);
    }
}
