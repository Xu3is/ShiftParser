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

    public List<BigInteger> GetInts() {
        return this.ints;
    }

    public List<Double> GetDoubles() {
        return this.doubles;
    }

    public List<String> GetStrings() {
        return this.strings;
    }

    private void EndifyType(String line, Statistics stat) {
        try {
            BigInteger num = new BigInteger(line);
            ints.add(num);

            if (stat != null) {
                stat.CollectStatInt(num);
            }
            return;
        } catch (NumberFormatException _) {
        }

        try {
            double numdub = Double.parseDouble(line);
            doubles.add(numdub);

            if (stat != null) {
                stat.CollectStatDouble(numdub);
            }
            return;
        } catch (NumberFormatException _) {
        }

        if (stat != null) {
            stat.CollectStatString(line);
        }
        strings.add(line);
    }

    public void readFiles(List<Path> filePath, Statistics stat) {
        for (Path path : filePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        EndifyType(line, stat);
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Такой файл не найден " + path);
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла " + e.getMessage());
            }
        }
    }
}
