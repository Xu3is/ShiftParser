package parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OutputWriter  {
    private <T> void DataOutputToFiles(List<T> data, Path path) throws  IOException {
        if (data.isEmpty()) return;
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        try (BufferedWriter w = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int i = 0; i < data.size(); i++) {
                w.write(data.get(i).toString());
                w.newLine();
            }
        }
    }
    public void DataOutputToAllFiles(DataReader reader, String prefix, Path path) throws IOException {
        Path intPath = path.resolve(prefix + "integers.txt");
        Path floatPath = path.resolve(prefix + "floats.txt");
        Path stringPath = path.resolve(prefix + "strings.txt");

        DataOutputToFiles(reader.GetInts(), intPath);
        DataOutputToFiles(reader.GetDoubles(), floatPath);
        DataOutputToFiles(reader.GetStrings(), stringPath);
    }
}
