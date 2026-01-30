package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final List<BigInteger> ints = new ArrayList<>();
    private final List<Double> doubles = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();


    private void EndifyType(String line) {
        try {
            BigInteger num = new BigInteger(line);
            ints.add(num);
            return;
        } catch (NumberFormatException _) {}

        try {
            double numdub = Double.parseDouble(line);
            doubles.add(numdub);
            return;
        } catch (NumberFormatException _) {}

        strings.add(line);
    }

    public void readFile(Path filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    EndifyType(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Такой файл не найден " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + e.getMessage());
        }
    }

    public void testprintall() {
        System.out.println(ints);
        System.out.println(doubles);
        System.out.println(strings);
    }
}
