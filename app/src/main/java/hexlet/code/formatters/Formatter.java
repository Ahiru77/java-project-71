package hexlet.code.formatters;

public class Formatter {
    public static Format pick(String name) {
        return switch (name) {
            case "stylish" -> new Stylish();
            case "json" -> new Json();
            case "plain" -> new Plain();
            default -> new Stylish();
        };
    }
}
