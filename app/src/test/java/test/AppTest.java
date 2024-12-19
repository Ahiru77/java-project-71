package test;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {
    private final String path = "src/test/resources/";
    private final String expStylish =  (path + "StylishResult.txt");
    private final String expPlain = (path + "PlainResult.txt");
    private final String expJson = (path + "JsonResult.txt");
    private final String pathJSON1 = (path + "file1.json");
    private final String pathJSON2 = (path + "file2.json");
    private final String pathYML1 = (path + "file1.yml");
    private final String pathYML2 = (path + "file2.yml");

    @Test
    void testGenerateJSON() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathJSON1, pathJSON2);
        assertEquals(expected, actual);
    }

    @Test
    void testJSONStylish() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathJSON1, pathJSON2, "stylish");
        assertEquals(expected, actual);
    }
    @Test
    void testJSONPlain() throws Exception {
        String expected = readFile(expPlain);
        String actual = Differ.generate(pathJSON1, pathJSON2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testJSONJson() throws Exception {
        String expected = readFile(expJson);
        String actual = Differ.generate(pathJSON1, pathJSON2, "json");
        assertEquals(expected, actual);
    }

    @Test
    void testGenerateYml() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathYML1, pathYML2);
        assertEquals(expected, actual);
    }

    @Test
    void testYmlStylish() throws Exception {
        String expected = readFile(expStylish);
        String actual = Differ.generate(pathYML1, pathYML2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    void testYmlPlain() throws Exception {
        String expected = readFile(expPlain);
        String actual = Differ.generate(pathYML1, pathYML2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    void testYmlJson() throws Exception {
        String expected = readFile(expJson);
        String actual = Differ.generate(pathYML1, pathYML2, "json");
        assertEquals(expected, actual);
    }

    public static String readFile(String path) throws IOException {
        var normPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(normPath);
    }
}
