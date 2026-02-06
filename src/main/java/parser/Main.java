package parser;

import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {
        CommandLineArguments maincli = CommandLineArgumentsParser.parseArguments(args);
        DataReader reader = new DataReader();
        reader.readFiles(maincli.getInputFiles(), maincli.getStatistic());

        if (maincli.getStatistic() != null) {
            if (maincli.isShortStat()) {
                maincli.getStatistic().PrintShortStatistics();
            } else if (maincli.isFullStat()) {
                maincli.getStatistic().PrintFullStatistics();
            }
        }
        OutputWriter writer = new OutputWriter();
        writer.DataOutputToAllFiles(reader, maincli.getPrefix(), maincli.getOutputPath(), maincli.isAppendable());

        System.out.println("Программа отработала");
    }
}