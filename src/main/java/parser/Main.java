package parser;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main(String[] args) throws IOException {
        CommandLineArguments maincli = CommandLineArgumentsParser.parseArguments(args);
        DataReader reader = new DataReader();
        reader.readFiles(maincli.getInputFiles(), maincli.getStatistic());

        if (maincli.getStatistic() != null) {
            if (maincli.isShortStat()) {
                maincli.getStatistic().PrintShortStatistics();
            } else {
                maincli.getStatistic().PrintFullStatistics();
            }
        }
        OutputWriter writer = new OutputWriter();
        writer.DataOutputToAllFiles(reader);
    }
}