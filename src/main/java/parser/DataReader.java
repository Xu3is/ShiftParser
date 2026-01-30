package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class DataReader {

    private int intCount;
    private int doubleCount;
    private int stringCount;

    public void readFile(Path filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Такой файл не найден " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + e.getMessage());
        }
    }
}
