package parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OutputWriter  {
    private <T> void DataOutputToFiles(List<T> data, String filename) throws  IOException {
        if (data.isEmpty()) return;
        Path path = Path.of(filename);
        try (BufferedWriter w = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int i = 0; i < data.size(); i++) {
                w.write(data.get(i).toString());
                w.newLine();
            }
        }
    }
    public void DataOutputToAllFiles(DataReader reader) throws IOException {
        DataOutputToFiles(reader.GetInts(), "sample-integers.txt");
        DataOutputToFiles(reader.GetDoubles(), "sample-doubles.txt");
        DataOutputToFiles(reader.GetStrings(), "sample-strings.txt");
        System.out.println("Данные записаны успешно");
    }
}
