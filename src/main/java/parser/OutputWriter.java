package parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
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
    public void IntegersOutputToFiles(List<BigInteger> ints) throws IOException {
        DataOutputToFiles(ints, "sample-integers.txt");
        System.out.println("целые числа записаны в файл");
    }
    public void DoublesOutputToFiles(List<Double> doubles) throws IOException {
        DataOutputToFiles(doubles, "sample-doubles.txt");
        System.out.println("числа с плавающей точкой записаны в файл");
    }
    public void StringsOutputToFiles(List<String> strings) throws IOException {
        DataOutputToFiles(strings, "sample-strings.txt");
        System.out.println("строки записаны в файл");
    }
}
