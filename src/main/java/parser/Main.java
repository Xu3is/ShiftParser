package parser;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main() throws IOException {
        DataReader reader = new DataReader();
        OutputWriter writer = new OutputWriter();

        reader.readFile(Path.of("input/in2.txt"));
        writer.IntegersOutputToFiles(reader.GetInts());
        writer.DoublesOutputToFiles(reader.GetDoubles());
        writer.StringsOutputToFiles(reader.GetStrings());
    }
}
