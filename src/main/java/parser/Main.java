package parser;

import java.nio.file.Path;

public class Main {
    static void main() {
        DataReader reader = new DataReader();
        reader.readFile(Path.of("input/in1.txt"));
        reader.testprintall();
    }
}
