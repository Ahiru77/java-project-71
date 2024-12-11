package hexlet.code;
import hexlet.code.formatters.Formatter;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        var diffRes = DiffFinder.findDiff(path1, path2);
        return Formatter.pick(format).format(diffRes);
    }
    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
}
