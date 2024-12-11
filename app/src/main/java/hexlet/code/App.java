package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

// import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Parameters(index = "0", description = "The first file to compare.")
    private String filepath1;
    @Parameters(index = "1", description = "The second file to compare.")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println("Differ.generate(filepath1, filepath2, format)");
        return null;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
