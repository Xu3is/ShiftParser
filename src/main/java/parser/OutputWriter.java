package parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class OutputWriter {
    private <T> void DataOutputToFiles(List<T> data, Path path, boolean appendmode) throws IOException {
        if (data.isEmpty()) return;
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }
        StandardOpenOption[] dataActions;
        if (appendmode) {
            dataActions = new StandardOpenOption[]{
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            };
        } else {
            dataActions = new StandardOpenOption[]{
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            };
        }
        try (BufferedWriter w = Files.newBufferedWriter(path, StandardCharsets.UTF_8, dataActions)) {
            for (int i = 0; i < data.size(); i++) {
                w.write(data.get(i).toString());
                w.newLine();
            }
        }
    }

    public void DataOutputToAllFiles(DataReader reader, String prefix, Path path, boolean appendMode) throws IOException {
        Path intPath = path.resolve(prefix + "integers.txt");
        Path floatPath = path.resolve(prefix + "floats.txt");
        Path stringPath = path.resolve(prefix + "strings.txt");

        DataOutputToFiles(reader.GetInts(), intPath, appendMode);
        DataOutputToFiles(reader.GetDoubles(), floatPath, appendMode);
        DataOutputToFiles(reader.GetStrings(), stringPath, appendMode);
    }
}
